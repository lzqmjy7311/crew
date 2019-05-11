<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.business.common.UserSessionInfo"%>
<%@page import="java.util.Date"%>
<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<%@page import="com.gbicc.person.monitor.service.TPlTaskService"%>
<%@page import="java.util.Map"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/blue/easyui.css">
<title>登陆信息</title>
<%! Integer roleId=0; %>
<%
UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
TPlTaskService service=TPlTaskService.getInstance();
 Map map=  service.getCountByStatus();
 roleId = service.findRoleIdByUserId(userInfo.getTlrNo()).get(0);



 String xfpTask="";//新分配任务
 String outTimeTask="";//超时任务
 String dbTask="";//代办任务
 String backtask="";//审核退回任务  
 String checkTask="";//审核中任务
 String passTask="";//审核通过任务

 String redWarning="";//红色预警
 String yellWarning="";//黄色预警
 String oraWarning="";//橙色预警

 String alert="";//提醒



 if(map.containsKey("dbtask")){
 	 dbTask=(String)map.get("dbtask");//代办任务
 }
 if(map.containsKey("backtask")){
 	 backtask=(String)map.get("backtask");//审核退回任务
 }
 if(map.containsKey("checkTask")){
 	 checkTask=(String)map.get("checkTask");//审核中任务
 }
 if(map.containsKey("passTask")){
 	 passTask=(String)map.get("passTask");//审核通过任务
 }


 if(map.containsKey("new")){
 	xfpTask=(String)map.get("new");//新分配任务
 }
 if(map.containsKey("out")){
 	outTimeTask=(String)map.get("out");//超时任务
 }









%>
</head>
<body  style="padding:0px;margin:0px;font-size:12px;font-family: Arial,Helvetica,sans-serif;text-align: left;width: 100%;height: 100% " bgcolor="#ffffff">
<div style="font-size: 12px; color: green;padding-left: 15px;line-height: 25px;">
<% if(roleId==557||roleId==558||roleId==111){%>
<a href="javascript:void(0);" onclick="parent.doWork('1','新分配任务','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=new')" >新分配任务：<% if(StringUtils.isNotBlank(xfpTask)){out.print(xfpTask);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="javascript:void(0);" onclick="parent.doWork('2','超时任务','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=out')" >超时任务：<% if(StringUtils.isNotBlank(outTimeTask)){out.print(outTimeTask);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%} if(roleId==222||roleId==333||roleId==444||roleId==555){ %>
<a href="javascript:void(0);" onclick="parent.doWork('3','待办任务','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=dbtask')" >待办任务：<% if(StringUtils.isNotBlank(dbTask)){out.print(dbTask);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="parent.doWork('4','审核退回','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=backtask')" >审核退回：<% if(StringUtils.isNotBlank(backtask)){out.print(backtask);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="parent.doWork('5','审核中','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=checkTask')" >审核中：<% if(StringUtils.isNotBlank(checkTask)){out.print(checkTask);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="parent.doWork('6','审核通过','/gbicc-pages/regular/ftl/monitor_report_desk_list.ftl?type=passTask')" >审核通过：<% if(StringUtils.isNotBlank(passTask)){out.print(passTask);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%} %>
</div>
<div style="font-size: 12px; color: green;padding-left: 15px;line-height: 25px;">
<a href="javascript:void(0);" onclick="parent.doWork('7','红色预警','/gbicc-pages/warn/ftl/warning_entry.ftl')" >红色预警：<% if(StringUtils.isNotBlank(redWarning)){out.print(redWarning);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="parent.doWork('8','密码修改','/gbicc-pages/warn/ftl/warning_entry.ftl')" >黄色预警：<% if(StringUtils.isNotBlank(yellWarning)){out.print(yellWarning);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="parent.doWork('9','橙色预警','/gbicc-pages/warn/ftl/warning_entry.ftl')" >橙色预警：<% if(StringUtils.isNotBlank(oraWarning)){out.print(oraWarning);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="parent.doWork('10','提       醒','/gbicc-pages/warn/ftl/warning_entry.ftl')" >提醒：<% if(StringUtils.isNotBlank(alert)){out.print(alert);}%></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>

</body>
</html>