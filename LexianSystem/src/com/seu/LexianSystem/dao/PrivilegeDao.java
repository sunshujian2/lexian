package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.LogPo;
import com.seu.LexianSystem.po.MenuPo;
import com.seu.LexianSystem.po.Record;
import com.seu.LexianSystem.vo.LoginVo;
import com.seu.LexianSystem.vo.ResetPassword;
import com.seu.LexianSystem.vo.UserLogVo;

public interface PrivilegeDao {
	public List<String> getUrl(int userId);
	
	public List<MenuPo> getMenus(int userId); 
	
	public List<LogPo> getLogs(LogPo logPo); 
	
	public LoginVo login(LoginVo loginVo);

	public void addUserLog(Record record);
 
	public List<Record> readUserLog(UserLogVo userLogVo);
	 
	public List<String> findAllRole(String managerId);
	 
	public void resetPassword(ResetPassword resetPassword);
}
