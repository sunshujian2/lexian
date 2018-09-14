package com.seu.LexianSystem.service;

import java.io.UnsupportedEncodingException;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.po.Version;

public interface VersionService {
	public ResultHelper addVersion(Version version) throws UnsupportedEncodingException;

	public ResultHelper deleteVersion(int versionId);

	public ResultHelper getVersionRecord(Version version);
	
	public ResultHelper getVersionMessage(int versionId);

}