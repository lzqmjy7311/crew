<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.business.common.UserSessionInfo"%>
<%@page import="com.gbicc.person.monitor.service.TPlTaskService"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/blue/easyui.css">
<title>任务总览</title>
<style>
body{
	padding-top:4px;
	margin:0px;
	font-size:12px;
}
.bm a{
	margin:0px 10px;
}
</style>
<script>
doWork=parent.parent.GTab.addTab;
</script>
<%
UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
TPlTaskService service=TPlTaskService.getInstance();
Integer newTask=service.getCount("newTask");
Integer overTask=service.getCount("overTask");
%>
</head>
<body class="bm">
<a href="javascript:void(0);" onclick="doWork('1','新分配任务','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=newTask')" >新分配任务：<%=newTask %></a>
<a href="javascript:void(0);" onclick="doWork('2','超时任务','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=overTask')" >超时任务：<%=overTask %></a> 
</body>
</html>