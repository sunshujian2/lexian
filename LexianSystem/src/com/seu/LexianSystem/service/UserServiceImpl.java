package com.seu.LexianSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seu.LexianSystem.service.BaseService;
import com.seu.LexianSystem.util.Constant;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.util.SHA;
import com.seu.LexianSystem.constant.UserConstant;
import com.seu.LexianSystem.dao.UserDao;
import com.seu.LexianSystem.service.UserService;
import com.seu.LexianSystem.vo.UpdateUserVo;
import com.seu.LexianSystem.vo.UserVo;

@Service
@Transactional
public class UserServiceImpl extends BaseService implements UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public ResultHelper findUsers(UserVo userVo) {
		return new ResultHelper(Constant.success_code, UserConstant.success, 
				userDao.findUsers(userVo), userVo.getTotal());
	}

	@Override
	public ResultHelper updateUserVo(UpdateUserVo udpateUser) {
		if (udpateUser.getPassword() != null && udpateUser.getPassword() != "") {
			udpateUser.setPassword(SHA.instance.getEncryptResult(udpateUser.getPassword()));
		}
		userDao.updateUserVo(udpateUser);
		return new ResultHelper(Constant.success_code, UserConstant.success);
	}
}
