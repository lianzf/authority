package com.framework.persistence.po;

import java.io.Serializable;

public class SysRoleResource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer roleId;
	private Integer resId;

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setRoleId(Integer value) {
		this.roleId = value;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setResId(Integer value) {
		this.resId = value;
	}

	public Integer getResId() {
		return this.resId;
	}
}
