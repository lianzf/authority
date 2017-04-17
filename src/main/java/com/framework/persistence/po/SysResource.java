package com.framework.persistence.po;

import java.io.Serializable;

public class SysResource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String resName;
	private String resString;
	private Integer parentId;

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setResName(String value) {
		this.resName = value;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResString(String value) {
		this.resString = value;
	}

	public String getResString() {
		return this.resString;
	}

	public void setParentId(Integer value) {
		this.parentId = value;
	}

	public Integer getParentId() {
		return this.parentId;
	}
}
