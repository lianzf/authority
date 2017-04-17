package com.framework.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

import com.framework.persistence.po.SysUser;

public class TokenManager {
	/**
	 * 登录
	 * 
	 * @param user
	 * @param rememberMe
	 * @return
	 */
	public static SysUser login(SysUser user, Boolean rememberMe) {
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserAccount(), user.getPassword());
		token.setRememberMe(rememberMe);
		SecurityUtils.getSubject().login(token);
		return getToken();
	}

	/**
	 * 获取当前登录的用户User对象
	 * 
	 * @return
	 */
	public static SysUser getToken() {
		Object obj = SecurityUtils.getSubject().getPrincipal();
		SysUser token = (SysUser) obj;
		return token;
	}
}
