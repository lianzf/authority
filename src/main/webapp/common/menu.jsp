<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" import="com.framework.common.Constant"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String menu = "";
	if (request.getRequestURI().indexOf("index.jsp") > 0) {
		menu = Constant.MENU_INDEX;
	} else {
		menu = request.getAttribute("menu").toString();
	}
%>
<div class="page-sidebar nav-collapse collapse">
	<!-- BEGIN SIDEBAR MENU -->
	<input id="path" type="hidden" value="<%=menu%>" />
	<ul class="page-sidebar-menu">
		<li>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
			<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
		</li>
		<li id="<%=Constant.MENU_INDEX%>" class="start"><a
			href="<%=request.getContextPath()%>/index.jsp"> <i
				class="icon-home"></i> <span class="title">首页</span> <span
				class="selected"></span>
		</a></li>
		<shiro:hasPermission name="system">
			<li class="last"><a href="javascript:;"> <i
					class="icon-cogs"></i> <span class="title">系统管理</span> <span
					class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<shiro:hasPermission name="/dictionary/dictionary">
						<li id=""><a
							href="<%=request.getContextPath()%>/dictionary/dictionary">数据字典</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/user/user">
						<li id=""><a href="<%=request.getContextPath()%>/user/user">用户管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/role/role">
						<li id=""><a href="<%=request.getContextPath()%>/role/role">角色管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="/resource/resource">
						<li id=""><a
							href="<%=request.getContextPath()%>/resource/resource">资源管理</a></li>
					</shiro:hasPermission>
				</ul></li>
		</shiro:hasPermission>
	</ul>
	<!-- END SIDEBAR MENU -->
</div>