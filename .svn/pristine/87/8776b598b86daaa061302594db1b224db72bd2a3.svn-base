<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.List"%>
<%@page import="com.huateng.report.utils.ReportUtils"%>
<%@page import="resource.bean.report.SysBusinavConf"%>
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<%@page import="com.huateng.report.genupreportfile.utils.ReportSubUtils"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/login/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/login/leftnavg/css/topnavg.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/login/leftnavg/js/topnavg.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/login/ymPrompt/dhtml/ymPrompt.css">
<script type='text/javascript' src='<%=request.getContextPath() %>/login/ymPrompt/ymPrompt.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath() %>/js/report.js'> </script>
<script language="javascript" src="<%=request.getContextPath() %>/templets/lib/salert.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/util.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/engine.js'> </script>
<script language="javascript" src="<%=request.getContextPath() %>/templets/lib/dwr.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/dwr/interface/ReportFile.js'> </script>
<script type="text/javascript">
	function sendToFile(){
		//开始进行生成文件处理
		window.setTimeout("window.location.href = '<%=request.getContextPath()%>/fpages/genupreportfile/jsp/createSubFileInfo.jsp'",0);
	}
	<%
	if(ReportSubUtils.IS_CREATE_FILE_BOP.equals("1")){//文件正在生成
	%>
		sendToFile();
	<%}%>
</script>
<%
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
GlobalInfo.setCurrentInstance(globalInfo);
List leftList = ReportUtils.getLeftNavgList("0");
String dt = DateUtil.dateToString(DateUtil.stringToDate2(globalInfo.getFileDate()));
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
	String url = conf.getMakefileUrl()==null?"":request.getContextPath()+conf.getMakefileUrl().trim();
%>
<li><a href="#"  onclick="changSelect('<%=conf.getId() %>')" class="normalMenu" id="topNavg_Link_<%=conf.getId() %>"><%=conf.getBusiNm() %></a>
<input type="hidden" name="topNavg" value="<%=conf.getId() %>"/>
<input type="hidden" id="topNavg_url_<%=conf.getId() %>" value="<%= url %>"/>
</li>
<%} %>
</ul>
</td>
<td style="background-color: #deedf7;border-bottom: 1px solid #aed0ea;padding-right: 5px;"  valign="middle" nowrap="nowrap">
<input type="hidden" id="fileDate" value="<%=dt %>"/>
<button class="divbutton" style="background-image: url(images/button.gif);" onmouseover="buttonMouseOver(this)" onmouseout="buttonMouseOut(this);" onclick="changeFileDate()"  title="选择工作日期" id="changeFileDateDiv"><%=dt %></button>
</td>
<td style="background-color: #deedf7;border-bottom: 1px solid #aed0ea;padding-right: 5px;"  valign="middle" nowrap="nowrap">
<button class="divbutton" style="background-image: url(images/button.gif);" onmouseover="buttonMouseOver(this)" onmouseout="buttonMouseOut(this);" onclick="toFile()"  title="生产上报文件">生成文件</button>
</td>
</tr>
<tr height="100%">
<td colspan="3">
<div id="msgDiv" style="display: none;width: 90%;line-height:30px;padding-top: 20px;padding-left: 20px;font-size: 16px;"></div>
<iframe id="TopNavgframe" height="100%" width="100%"  scrolling="auto" frameborder="0"></iframe>
</td>
</tr>
</table>
<script type="text/javascript">
	window.onload= function(){
		initTopNavg(0);
	}

	function changeFileDate(){
		showWin("日期选择",'<%=request.getContextPath() %>/fpages/common/ftl/SubFileWorkDate.ftl',"window","changeFileDateCallBack()",window,500,300,'c');
	}

	function changeFileDateCallBack(){
		var fdinput = document.getElementById("fileDate");
		var dt = fdinput.value;
		document.getElementById("changeFileDateDiv").innerHTML = dt;
		window.setTimeout("document.getElementById('TopNavgframe').contentWindow.location.reload()",0);
	}

	function toFile(){
		ReportFile.getSubFileInfoCount(fileCallback);
	}

	function fileCallback(data){
		var fdinput = document.getElementById("fileDate");
		var dt = fdinput.value;
		if(data>0){
			showWin("上报文件生成确定",'<%=request.getContextPath() %>/fpages/genupreportfile/ftl/BopToSubFileConfirm.ftl',"window","sendToFile()",window);
		}else{
			alert(dt+",没有需要上报的数据！");
		}
	}
</script>
</body>
</html>