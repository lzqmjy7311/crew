<%@page import="java.util.Map"%>
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
<%
UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
TPlTaskService service=TPlTaskService.getInstance();
Map<String,Integer> sums=service.sumCmTask();
Integer RULE_TYPE_TODO=sums.get("RULE_TYPE_TODO");
Integer RULE_TYPE_OVER=sums.get("RULE_TYPE_OVER");
Integer CUST_TYPE_TODO=sums.get("CUST_TYPE_TODO");
Integer CUST_TYPE_OVER=sums.get("CUST_TYPE_OVER");
Integer XIECHA_TYPE_TODO=sums.get("XIECHA_TYPE_TODO");
Integer XIECHA_TYPE_OVER=sums.get("XIECHA_TYPE_OVER");
%>
</head>
<body class="bm">
<a href="javascript:void(0);" onclick="parent.doWork('3','待办单客户预警任务','/gbicc-com-pages/cmWarnDisposal/ftl/TCmWarnTask.ftl')" >待办单客户预警任务：<%=CUST_TYPE_TODO %></a>
<a href="javascript:void(0);" onclick="parent.doWork('4','超时单客户预警任务','/gbicc-com-pages/cmWarnDisposal/ftl/TCmWarnTask.ftl?taskType=overTask')" >超时单客户预警任务：<%=CUST_TYPE_OVER %></a> 
<a href="javascript:void(0);" onclick="parent.doWork('5','待办案例协查任务','/gbicc-com-pages/single/ftl/single_rul_investigation_task.ftl')" >待办案例协查任务：<%=XIECHA_TYPE_TODO %></a>
<a href="javascript:void(0);" onclick="parent.doWork('6','超时案例协查任务','/gbicc-com-pages/single/ftl/single_rul_investigation_task.ftl?taskType=overTask')" >超时案例协查任务：<%=XIECHA_TYPE_OVER %></a> 
</body>
</html>