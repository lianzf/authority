package com.framework.core.shiro.realm;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.persistence.po.SysUser;
import com.framework.persistence.po.SysUserRole;
import com.framework.service.SysResourceService;
import com.framework.service.SysUserRoleService;
import com.framework.service.SysUserService;

@Service(value = "customAuthorizingRealm")
public class CustomAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysUserRoleService sysUserRoleService;
	@Autowired
	SysResourceService sysResourceService;

	public CustomAuthorizingRealm() {
		super();
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userAccount", user.getUserAccount());
		// 根据用户账号查询当前用户拥有的角色
		List<SysUserRole> userRoleList = null;
		try {
			userRoleList = sysUserRoleService.getListByMap(dataMap);
			Set<String> roles = new HashSet<String>();
			for (SysUserRole sur : userRoleList) {
				roles.add(sur.getId().toString());
			}
			// 将角色提供给authorizationInfo
			authorizationInfo.setRoles(roles);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 根据用户账号获取用户资源信息
		Set<String> resourceSet = sysResourceService.getResByUserId(user.getUserId());
		authorizationInfo.setStringPermissions(resourceSet);
		return authorizationInfo;
	}

	/**
	 * 用户认证、主要针对用户登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser user = sysUserService.findUserByUserName(token.getUsername());
		if (user == null) {
			throw new UnknownAccountException("该用户不存在");
		} else if (user.getStatus() == 0) {
			throw new AuthenticationException("用户被停用");
		}
		user.setLoginTime(new Date());
		try {
			sysUserService.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}

}
