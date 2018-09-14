package com.seu.LexianSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.LexianSystem.controller.BaseController;
import com.seu.LexianSystem.util.Constant;
import com.seu.LexianSystem.util.ParamValidateUtil;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.util.ParamValidateUtil.ParamNotValidException;
import com.seu.LexianSystem.constant.PrivilegeConstant;
import com.seu.LexianSystem.po.LogPo;
import com.seu.LexianSystem.service.PrivilegeService;
import com.seu.LexianSystem.vo.LoginVo;
import com.seu.LexianSystem.vo.ResetPassword;
import com.seu.LexianSystem.vo.UserLogVo;

@Controller
@RequestMapping("/login")
public class PrivilegeController extends BaseController {
	private PrivilegeService privilegeService;
	
	@Autowired
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	// 用户登录
	@RequestMapping("/login.do")
	@ResponseBody
	public ResultHelper login(LoginVo loginVo, HttpServletRequest httpServletRequest) {
		try {
			ParamValidateUtil.validateNull(loginVo, PrivilegeConstant.invalid_arguments);
			ParamValidateUtil.validateEmpty(loginVo.getUserName(), PrivilegeConstant.invalid_arguments);
			ParamValidateUtil.validateEmpty(loginVo.getPassWord(), PrivilegeConstant.invalid_arguments);
		} catch (ParamNotValidException e) {
			return new ResultHelper(Constant.failed_code, e.getMessage());
		}
		return privilegeService.login(loginVo,httpServletRequest);
	}

	//用户注销
	@RequestMapping("/logout.do")
	@ResponseBody
	public ResultHelper logout(HttpSession session) {
		session.removeAttribute("user");
		return new ResultHelper(Constant.success_code, PrivilegeConstant.success);
	}
    
	// 查询用户操作日志记录
	@RequestMapping("/readUserLog.do")
	@ResponseBody
	public ResultHelper readUserLog(UserLogVo userLogVo) {
		try {
			ParamValidateUtil.validateNull(userLogVo, PrivilegeConstant.invalid_arguments);
		} catch (ParamNotValidException e) {
			return new ResultHelper(Constant.failed_code, e.getMessage());
		}
		return privilegeService.readUserLog(userLogVo);
	}
	
	@RequestMapping("/resetPassword.do")
	@ResponseBody
    public ResultHelper resetPassword(HttpSession session,@ModelAttribute ResetPassword resetPassword){
    	try {
    		ParamValidateUtil.validateEmpty(resetPassword.getOldPassword(), PrivilegeConstant.invalid_arguments);
			ParamValidateUtil.validateEmpty(resetPassword.getNewPassword(), PrivilegeConstant.invalid_arguments);
    	} catch (ParamNotValidException e) {
            return new ResultHelper(Constant.failed_code,e.getMessage());
		}
		return privilegeService.resetPassword(session, resetPassword);
    }
	


	@RequestMapping("/getLogs.do")
	@ResponseBody
	public ResultHelper getLogs(LogPo logPo){
		return privilegeService.getLogs(logPo);
	}
	
	@RequestMapping("/getSession.do")
	@ResponseBody
	public ResultHelper getSession(HttpServletRequest httpServletRequest){
		return privilegeService.getSession(httpServletRequest);
	}
	
}
