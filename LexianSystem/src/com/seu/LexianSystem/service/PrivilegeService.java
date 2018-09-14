package com.seu.LexianSystem.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.po.LogPo;
import com.seu.LexianSystem.po.Record;
import com.seu.LexianSystem.vo.LoginVo;
import com.seu.LexianSystem.vo.ResetPassword;
import com.seu.LexianSystem.vo.UserLogVo;

public interface PrivilegeService {
	public ResultHelper login(LoginVo loginVo,HttpServletRequest httpServletRequest);
	
	public void addUserLog(Record record);
	
	public ResultHelper readUserLog(UserLogVo userLogVo);
	
	public ResultHelper getLogs(LogPo logPo);
	
	public ResultHelper getSession(HttpServletRequest httpServletRequest);
    
	public ResultHelper resetPassword(HttpSession session,ResetPassword resetPassword);
}
