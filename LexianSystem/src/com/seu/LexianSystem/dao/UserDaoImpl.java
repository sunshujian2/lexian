package com.seu.LexianSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.BaseDao;
import com.seu.LexianSystem.dao.UserDao;
import com.seu.LexianSystem.po.UserPo;
import com.seu.LexianSystem.vo.UpdateUserVo;
import com.seu.LexianSystem.vo.UserVo;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
	@Override
	public List<UserPo> findUsers(UserVo userVo) {
		return selectList("findUsers", userVo);
	}

	@Override
	public int updateUserVo(UpdateUserVo updateUserVo) {
		return update("updateUser", updateUserVo);
	}
}
