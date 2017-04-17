package com.framework.persistence.po;

import java.io.Serializable;

public class SysRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String roleName;
	private String roleDesc;

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setRoleName(String value) {
		this.roleName = value;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleDesc(String value) {
		this.roleDesc = value;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}
}
