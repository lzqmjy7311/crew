<%@page import="com.huateng.ebank.entity.data.mng.RoleInfo"%>
<%@page import="com.huateng.ebank.business.common.DAOUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.business.common.UserSessionInfo"%>
<%@page import="java.util.Date"%>
<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/blue/easyui.css">
<title>登陆信息</title>
<%
UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
RoleInfo info= DAOUtils.getRoleInfoDAO().findById(Integer.valueOf(globalInfo.getWorkflowRoleId()));
%>
<style>
body{
	padding-top:4px;
	margin:0px;
	font-size:12px;
}
.to{
	color:green;
}
.to span{
	margin:0px 10px;
}
</style>
</head>
<body>
<div style="" class="to">
<span>欢迎您：<%=userInfo.getTlrName() %>(<%=userInfo.getTlrNo() %>) </span>
<span>岗位：<%=info.getRoleName() %> </span>
<span>登录机构：<%=globalInfo.getBrName() %>(<%=globalInfo.getBrno() %>)</span>
<span>上次登录时间：<% if(StringUtils.isNotBlank(userInfo.getLastLoginTime())){out.print(DateUtil.Time14ToString(DateUtil.StringToTime(userInfo.getLastLoginTime())));} %></span>
</div>

</body>
</html>