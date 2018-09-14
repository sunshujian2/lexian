package com.seu.LexianSystem.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seu.LexianSystem.controller.BaseController;
import com.seu.LexianSystem.util.CommonUtil;
import com.seu.LexianSystem.util.Constant;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.constant.PrivilegeConstant;
import com.seu.LexianSystem.vo.Administrator;

public class PrivillegeFilter extends BaseController implements Filter {

	private final String session_id = "user";
	private final String NOTVERIFICATION = "/LexianSystem/management/verification.do";
	private final String LOGINURL = "/LexianSystem/login/login.do";
	private final String LOGOUTURL= "/LexianSystem/login/logout.do";
	private final String VALIDATE = "/LexianSystem/login/pictureValidate.do";
	private final String UNPREVILLEGE = "/LexianSystem/html/403.html";
	private final String LOGIN= "/LexianSystem/html/login.html";
	private final String NOTLOGIN = "/LexianSystem/html/unlogin.html";
	
	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, 
			ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		HttpServletRequest paramHttpServletRequest = (HttpServletRequest)paramServletRequest;
		HttpServletResponse paramHttpServletResponse = (HttpServletResponse)paramServletResponse;
		String url = paramHttpServletRequest.getRequestURI();
		HttpSession session = paramHttpServletRequest.getSession(true);
		boolean isAjax = CommonUtil.isAjaxAction(paramHttpServletRequest);
		Administrator administrator = (Administrator) session.getAttribute(session_id);
		
		// 登录、注�?以及获取验证码的请求可以直接执行
		if (url.equals(UNPREVILLEGE) || url.equals(NOTLOGIN)||
				url.equals(LOGIN)||url.equals(LOGINURL) || 
				url.equals(LOGOUTURL) || url.equals(VALIDATE)||url.equals(NOTVERIFICATION)) {
			paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
			return;
		}
		
		if (administrator == null) {	// 未登录用�?
			if (!isAjax) {
				paramHttpServletResponse.sendRedirect(NOTLOGIN);
			} else {
				try {
					outputData(paramHttpServletRequest, 
							paramHttpServletResponse,
							new ResultHelper(
									Constant.failed_code,
									PrivilegeConstant.invalid_user)
					);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return;
		}
		else {		// 已登录用�?
			List<String> urList = administrator.getUrl();
			
			if (!isAjax) {
				if (validateUrl(url, urList)) {
					paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
				}
				else{
					paramHttpServletResponse.sendRedirect(UNPREVILLEGE);
				}
			} else {
				if (validateUrl(url, urList)) {
					paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
				}
				else{
					try {
						outputData(paramHttpServletRequest, paramHttpServletResponse,
								new ResultHelper(Constant.failed_code, 
										PrivilegeConstant.permission_denied));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void destroy() {
		
	}
	
	// 从数据库中读取url及角色的对应表，�?查该角色是否有权限访问该url
	private boolean validateUrl(String url, List<String> urList) {
		boolean privilege = false;
		
		if (urList == null || urList.isEmpty()) {
			return privilege;
		}
		
		for (String privilegeUrl:urList) {
			if( url.endsWith(privilegeUrl) ){
				privilege = true;
				break;
			}
		}
		return privilege;
	}

}
