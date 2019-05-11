<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.huateng.report.common.service.ReportCommonService"%>
<%@page import="java.util.List"%>
<%@page import="com.huateng.ebank.entity.data.mng.FunctionInfo"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>个人收藏夹</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/blue/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/uicore-min.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'> </script>
<script type='text/javascript' src="<%=request.getContextPath()%>/dwr/interface/PrivAction.js" ></script>

<script type="text/javascript">
<!--
var _application_root="<%=request.getContextPath() %>";
var _current_user = '<%=((GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO)).getTlrno()%>';
//-->
</script>
	<style type="text/css">
		.favdel{
			height:16px;
			width:16px;
			margin:4px;
			float:right;
			cursor:pointer;
		}
		.favtext{
		    float:left;
		}
	</style>
	<%
	List funcList = ReportCommonService.getInstance().getFunctionInfoListByFavt(session);
	%>
</head>
<body bgcolor="white" style="margin: 0px;">
<div style="padding: 3px;text-align: center;">
<%
if(funcList.size()>0){
for(int i=0;i<funcList.size();i++){
	FunctionInfo fun = (FunctionInfo)funcList.get(i);
%>
<div class="panel-header favorites-header" id="div_<%=fun.getId().trim() %>" style="text-align:left;cursor: pointer;" onclick="doIndexWork('<%=fun.getId().trim() %>','<%=fun.getFuncname() %>','<%=fun.getPagepath() %>')"  onmouseover="this.style.backgroundColor='#cce6f9'" onmouseout="this.style.backgroundColor=''" title="<%=fun.getFuncname() %>">
<span class="favtext"><%=fun.getFuncname() %></span><span class="icon-delete favdel" fid="<%=fun.getId() %>"></span>
</div>
<%} }else{%>
<div style="font-size: 12px;color: green;padding: 5px;text-align: center;border: 1px solid #ededed;cursor: default;" onmouseover="this.style.backgroundColor='#ffffbe'" onmouseout="this.style.backgroundColor=''" id="msg" >空的收藏夹</div>
<%} %>

</div>
<script type="text/javascript">
	function doIndexWork(funcId,name,url){
		window.parent.parent.doWork(funcId,name,url);
	}
	
	$(".favdel").click(function(e){
		var _this = $(this);
		PrivAction.saveFavt(_this.attr('fid'),-1,function(){
			_this.parent().fadeOut("normal",function(){
				$(this).remove();
			});
		});
		e.stopPropagation();
	}).hide();
</script>
</body>
</html>