
package com.framework.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.persistence.mapper.SysUserRoleMapper;
import com.framework.persistence.po.SysUserRole;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public int insert(SysUserRole record) throws SQLException {
		return sysUserRoleMapper.insert(record);
	}

	@Override
	public int update(SysUserRole record) throws SQLException {
		return sysUserRoleMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return sysUserRoleMapper.deleteById(id);
	}

	@Override
	public SysUserRole getById(Integer id) throws SQLException {
		return sysUserRoleMapper.getById(id);
	}

	@Override
	public List<SysUserRole> getListByMap(Map<String, Object> condition) throws SQLException {
		return sysUserRoleMapper.getListByMap(condition);
	}
	
	@Override
	public List<SysUserRole> getListByPo(SysUserRole record) throws SQLException {
		return sysUserRoleMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return sysUserRoleMapper.count(condition);
	}
	
}

