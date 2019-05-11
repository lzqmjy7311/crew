<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.List"%>
<%@page import="com.huateng.report.utils.ReportUtils"%>
<%@page import="resource.bean.report.SysBusinavConf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/login/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/login/leftnavg/css/topnavg.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/login/leftnavg/js/topnavg.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/login/ymPrompt/dhtml/ymPrompt.css">
<script type='text/javascript' src='<%=request.getContextPath() %>/login/ymPrompt/ymPrompt.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath() %>/js/report.js'> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/easyui/themes/blue/easyui.css">

<%
List leftList = ReportUtils.getLeftNavgList("0");
if(leftList==null||leftList.size()==0){
%>
<script type="text/javascript">
document.write("未传入业务编码或编码不存在！");
</script>
<%return;} %>
</head>
<body scroll="no" class="bodycls">
<input type="hidden" id="curretnTab" value="">
<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%">
<tr>
<td width="100%" class="menucontainer" valign="middle">
<ul id="navigationMenu">
<%
for(int i=0;i<leftList.size();i++){
	SysBusinavConf conf = (SysBusinavConf)leftList.get(i);
	String url = conf.getQueryUrl()==null?"":request.getContextPath()+conf.getQueryUrl().trim();
%>
<li><a href="#"  onclick="changSelect('<%=conf.getId() %>')" class="normalMenu" id="topNavg_Link_<%=conf.getId() %>"><%=conf.getBusiNm() %></a>
<input type="hidden" name="topNavg" value="<%=conf.getId() %>"/>
<input type="hidden" id="topNavg_url_<%=conf.getId() %>" value="<%= url %>"/>
</li>
<%} %>
</ul>
</td>
</tr>
<tr height="100%">
<td>
<div id="msgDiv" style="display: none;width: 90%;line-height:30px;padding-top: 20px;padding-left: 20px;font-size: 16px;"></div>
<iframe id="TopNavgframe" height="100%" width="100%"  scrolling="auto" frameborder="0"></iframe>
</td>
</tr>
</table>
<script type="text/javascript">
	window.onload= function(){
		initTopNavg(0);
	}
</script>
</body>
</html>