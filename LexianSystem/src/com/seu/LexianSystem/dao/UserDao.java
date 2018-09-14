package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.UserPo;
import com.seu.LexianSystem.vo.UpdateUserVo;
import com.seu.LexianSystem.vo.UserVo;

public interface UserDao {
	public List<UserPo> findUsers(UserVo userVo);

	public int updateUserVo(UpdateUserVo updateUserVo);
}
