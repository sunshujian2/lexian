package com.seu.LexianSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.BaseDao;
import com.seu.LexianSystem.dao.PrivilegeDao;
import com.seu.LexianSystem.po.LogPo;
import com.seu.LexianSystem.po.MenuPo;
import com.seu.LexianSystem.po.Record;
import com.seu.LexianSystem.vo.LoginVo;
import com.seu.LexianSystem.vo.ResetPassword;
import com.seu.LexianSystem.vo.UserLogVo;

@Repository
public class PrivilegeDaoImpl extends BaseDao implements PrivilegeDao {
	@Override
	public LoginVo login(LoginVo loginVo) {
		return selectOne("login", loginVo);
	}

	@Override
	public List<String> getUrl(int userId) {
		return selectList("getUrl", userId);
	}
 
	@Override
	public void addUserLog(Record record) {
		insert("addUserLog", record);

	} 
	
	@Override
	public List<Record> readUserLog(UserLogVo userLogVo) {
		return selectList("readUserLog", userLogVo);
	}

	@Override
	public List<LogPo> getLogs(LogPo logPo) {
		return selectList("getLogs", logPo);
	}

	@Override
	public List<MenuPo> getMenus(int userId) {
		return selectList("getMenus",userId);
	}

	@Override
	public List<String> findAllRole(String managerId) {
		return selectList("findAllRole",managerId);
	}

	@Override
	public void resetPassword(ResetPassword resetPassword) {
		update("resetPassword",resetPassword);
	}
}
