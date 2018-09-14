package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.Version;

public interface VersionDao {
	public void addVersion(Version version);

	public void deleteVersion(int versionId);

	public Version getNewVersion();
	
	public List<Version> getVersionRecord(Version version);

	public Version getVersionMessage(int versionId);
}
