
package com.framework.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.persistence.mapper.SysRoleResourceMapper;
import com.framework.persistence.po.SysRoleResource;

@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

	@Autowired
	SysRoleResourceMapper sysRoleResourceMapper;
	
	@Override
	public int insert(SysRoleResource record) throws SQLException {
		return sysRoleResourceMapper.insert(record);
	}

	@Override
	public int update(SysRoleResource record) throws SQLException {
		return sysRoleResourceMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return sysRoleResourceMapper.deleteById(id);
	}

	@Override
	public SysRoleResource getById(Integer id) throws SQLException {
		return sysRoleResourceMapper.getById(id);
	}

	@Override
	public List<SysRoleResource> getListByMap(Map<String, Object> condition) throws SQLException {
		return sysRoleResourceMapper.getListByMap(condition);
	}
	
	@Override
	public List<SysRoleResource> getListByPo(SysRoleResource record) throws SQLException {
		return sysRoleResourceMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return sysRoleResourceMapper.count(condition);
	}
	
}

