
package com.seu.LexianSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.BaseDao;
import com.seu.LexianSystem.dao.VersionDao;
import com.seu.LexianSystem.po.Version;

@Repository
public class VersionDaoImpl extends BaseDao implements VersionDao {
	@Override
	public void addVersion(Version version) {
		insert("addVersion", version);
	}
	@Override
	public void deleteVersion(int versionId) {
		delete("deleteVersion", versionId);
	}

	@Override
	public Version getNewVersion() {
		return selectOne("getNewVersion");
	}
	
	@Override
	public List<Version> getVersionRecord(Version version) {
		
		return selectList("getVersionRecord", version);
	}

	@Override
	public Version getVersionMessage(int versionId) {
		
		return selectOne("getVersionMessage",versionId) ;
	}

}
