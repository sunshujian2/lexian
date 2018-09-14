package com.seu.LexianSystem.vo;

public class ChangeManagerPassword {
	/**
	 * 用户id
	 */
	public Long managerId;
	public String managerName;
	/**
	 * 新密�?
	 */
	public String password;
	/**
	 * 旧密�?
	 */
	private String oldPassword;
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
