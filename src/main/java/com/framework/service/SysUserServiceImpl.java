
package com.framework.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.persistence.mapper.SysUserMapper;
import com.framework.persistence.po.SysUser;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;

	@Override
	public int insert(SysUser record) throws SQLException {
		return sysUserMapper.insert(record);
	}

	@Override
	public int update(SysUser record) throws SQLException {
		return sysUserMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return sysUserMapper.deleteById(id);
	}

	@Override
	public SysUser getById(Integer id) throws SQLException {
		return sysUserMapper.getById(id);
	}

	@Override
	public List<SysUser> getListByMap(Map<String, Object> condition) throws SQLException {
		return sysUserMapper.getListByMap(condition);
	}

	@Override
	public List<SysUser> getListByPo(SysUser record) throws SQLException {
		return sysUserMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return sysUserMapper.count(condition);
	}

	@Override
	public SysUser findUserByUserName(String username) {
		SysUser sysUser = new SysUser();
		sysUser.setUserAccount(username);
		List<SysUser> sysUserList = sysUserMapper.getListByPo(sysUser);
		return (sysUserList != null && sysUserList.size() > 0) ? sysUserList.get(0) : null;
	}

}
