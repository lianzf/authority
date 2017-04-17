
package com.framework.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.persistence.mapper.SysResourceMapper;
import com.framework.persistence.po.SysResource;

@Service
public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	SysResourceMapper sysResourceMapper;
	
	@Override
	public int insert(SysResource record) throws SQLException {
		return sysResourceMapper.insert(record);
	}

	@Override
	public int update(SysResource record) throws SQLException {
		return sysResourceMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return sysResourceMapper.deleteById(id);
	}

	@Override
	public SysResource getById(Integer id) throws SQLException {
		return sysResourceMapper.getById(id);
	}

	@Override
	public List<SysResource> getListByMap(Map<String, Object> condition) throws SQLException {
		return sysResourceMapper.getListByMap(condition);
	}
	
	@Override
	public List<SysResource> getListByPo(SysResource record) throws SQLException {
		return sysResourceMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return sysResourceMapper.count(condition);
	}

	@Override
	public Set<String> getResByUserId(Integer userId) {
		return sysResourceMapper.getResByUserId(userId);
	}
	
}

