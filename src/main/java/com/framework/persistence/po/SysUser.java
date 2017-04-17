package com.framework.persistence.po;

import java.io.Serializable;

public class SysUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userAccount;
	private String userName;
	private String password;
	private Integer status;
	private java.util.Date loginTime;
	private java.util.Date createTime;

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserAccount(String value) {
		this.userAccount = value;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserName(String value) {
		this.userName = value;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}

	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}

	public java.util.Date getLoginTime() {
		return this.loginTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}
}
