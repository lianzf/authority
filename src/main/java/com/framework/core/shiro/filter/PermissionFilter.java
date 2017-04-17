package com.framework.core.shiro.filter;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.framework.common.Constant;
import com.framework.common.LogFactory;

import net.sf.json.JSONObject;

/**
 * 权限校验
 * 
 * @author LianZhiFei
 *
 */
public class PermissionFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request, response);
		if (null != mappedValue) {
			String[] arra = (String[]) mappedValue;
			for (String permission : arra) {
				if (subject.isPermitted(permission)) {
					return true;
				}
			}
		}
		HttpServletRequest httpRequest = ((HttpServletRequest) request);

		String uri = httpRequest.getRequestURI();// 获取URI
		String basePath = httpRequest.getContextPath();// 获取basePath
		if (null != uri && uri.startsWith(basePath)) {
			uri = uri.replace(basePath, "");
		}
		if (subject.isPermitted(uri)) {
			return true;
		}

		if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {
			Map<String, String> resultMap = new HashMap<String, String>();
			LogFactory.getInstance().getSysInfoLogger().info("当前用户没有登录，并且是Ajax请求！");
			resultMap.put("login_status", "300");
			resultMap.put("message", "当前用户没有登录！");// 当前用户没有登录！
			PrintWriter out = null;
			try {
				response.setCharacterEncoding("UTF-8");
				out = response.getWriter();
				out.println(JSONObject.fromObject(resultMap).toString());
			} catch (Exception e) {
				LogFactory.getInstance().getSysInfoLogger().error(e + "输出JSON报错。");
			} finally {
				if (null != out) {
					out.flush();
					out.close();
				}
			}
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);  
        if (null == subject.getPrincipal()) {//表示没有登录，重定向到登录页面  
            saveRequest(request);  
            WebUtils.issueRedirect(request, response, Constant.LOGIN_URL);  
        } else {  
            if (StringUtils.hasText(Constant.UNAUTHORIZED)) {//如果有未授权页面跳转过去  
                WebUtils.issueRedirect(request, response, Constant.UNAUTHORIZED);  
            } else {//否则返回401未授权状态码  
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);  
            }  
        }  
		return false;
	}

}
