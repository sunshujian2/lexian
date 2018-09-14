package com.seu.LexianSystem.service;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.vo.UpdateUserVo;
import com.seu.LexianSystem.vo.UserVo;

public interface UserService {
	public ResultHelper findUsers(UserVo userVo);

	public ResultHelper updateUserVo(UpdateUserVo udpateUser);
}
