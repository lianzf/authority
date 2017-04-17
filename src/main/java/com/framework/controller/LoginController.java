package com.framework.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.common.TokenManager;
import com.framework.persistence.po.SysUser;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseAction {

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitLogin(SysUser entity, Boolean rememberMe, HttpServletRequest request) {
		try {
			if (null == rememberMe) {
				rememberMe = true;
			}
			entity = TokenManager.login(entity, rememberMe);
			request.getSession().setAttribute("loginUser", entity);
			resultMap.put("success", true);
			resultMap.put("msg", "登录成功");
			resultMap.put("code", "200");
			resultMap.put("resultType", "url");
			resultMap.put("data", getContext() + "/login/index");
		} catch (UnknownAccountException e) {
			resultMap.put("success", false);
			resultMap.put("msg", e.getMessage());
		} catch (LockedAccountException e) {
			resultMap.put("success", false);
			resultMap.put("msg", e.getMessage());
		} catch (IncorrectCredentialsException e) {
			resultMap.put("success", false);
			resultMap.put("msg", "账号或密码错误");
		} catch (Exception e) {
			resultMap.put("success", false);
			resultMap.put("msg", "其他错误");
		}
		return resultMap;

	}

	@RequiresPermissions(value = { "index" })
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}
