package com.framework.persistence.po;

import java.io.Serializable;

public class SysUserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private Integer roleId;

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setRoleId(Integer value) {
		this.roleId = value;
	}

	public Integer getRoleId() {
		return this.roleId;
	}
}
