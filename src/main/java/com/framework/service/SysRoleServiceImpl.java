
package com.framework.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.persistence.mapper.SysRoleMapper;
import com.framework.persistence.po.SysRole;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Override
	public int insert(SysRole record) throws SQLException {
		return sysRoleMapper.insert(record);
	}

	@Override
	public int update(SysRole record) throws SQLException {
		return sysRoleMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return sysRoleMapper.deleteById(id);
	}

	@Override
	public SysRole getById(Integer id) throws SQLException {
		return sysRoleMapper.getById(id);
	}

	@Override
	public List<SysRole> getListByMap(Map<String, Object> condition) throws SQLException {
		return sysRoleMapper.getListByMap(condition);
	}
	
	@Override
	public List<SysRole> getListByPo(SysRole record) throws SQLException {
		return sysRoleMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return sysRoleMapper.count(condition);
	}
	
}

