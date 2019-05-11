<%@ page language="java" contentType="text/html; charset=GBK"  pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="com.huateng.report.common.service.ReportCommonService"%>
<%@page import="resource.bean.pub.FunctionInfo"%>
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>个人收藏设置</title>
<%
int row =15;
String path = request.getContextPath();
List funcList = ReportCommonService.getInstance().getFunctionInfoListByFavt(session);

GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
GlobalInfo.setCurrentInstance(globalInfo);
String startNode = globalInfo.getMenuCode();

%>
<script language="javascript" src="<%=path %>/templets/lib/salert.js"></script>
<script type='text/javascript' src='<%=path %>/dwr/util.js'> </script>
<script type='text/javascript' src='<%=path %>/dwr/engine.js'> </script>
<script language="javascript" src="<%=path %>/templets/lib/dwr.js"></script>
<script type="text/javascript" src="<%=path%>/js/xmlUtil.js"></script>
<script type="text/javascript" src="<%=path%>/js/tree.js"></script>
<script type="text/javascript" src="<%=path%>/js/xtree.js"></script>
<script type='text/javascript' src='<%=path%>/dwr/interface/PrivAction.js'> </script>
<link rel="stylesheet" type="text/css" href="<%=path%>/templets/easyui/themes/blue/easyui.css">
<script type="text/javascript">
	function buttonMouseOver(obj){
		obj.style.backgroundImage="";
		obj.style.backgroundColor = "#ededed";
	}

	function buttonMouseOut(obj){
		obj.style.backgroundImage = "url(<%=path%>/login/leftnavg/images/button.gif)";
	}
</script>
<style type="text/css">
	.divbutton{
		border: #002D96 1px solid;
		cursor: pointer;
		color: #000;
		font-size: 12px;
		font-family: Arial,Verdana,Vrinda,Tahoma;
		height: 22px;
	}
	.menudiv{
		cursor:default;
		background-color: #deedf7;
		border: solid 1px #aed0ea;
		text-align: left;
		line-height: 22px;
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
		color: #000000;
		margin-bottom: 1px;
		width: 180px;
		white-space:nowrap;
		padding-left: 5px;
		margin-top: 1px;
	}

</style>
</head>
<body bgcolor="white" style="margin: 0px;">
<div style="padding: 3px;padding-left: 10px;text-align: left;padding-top: 8px;">
<table>
	<tr>
		<td colspan="2">
		<button class="divbutton" style="background-image: url(<%=path%>/login/leftnavg/images/button.gif);" onmouseover="buttonMouseOver(this)" onmouseout="buttonMouseOut(this);" onclick="saveFavt()"  title="保存收藏夹设置"> 保 存 </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="divbutton" style="background-image: url(<%=path%>/login/leftnavg/images/button.gif);" onmouseover="buttonMouseOver(this)" onmouseout="buttonMouseOut(this);" onclick="canFavt()"> 取 消 </button>
		</td>
	</tr>
	<tr>
		<td align="left" width="350px" valign="top">
		<div id="tree" style="text-align: left;height: 450px;overflow: auto;border: 1px solid #ededed">
			<script language="javascript">
				var functree = null;
				dwr.engine.setAsync(false);
				PrivAction.getFuncArrayByFavt(
					function(data){
						functree = data;
					}
				);
				dwr.engine.setAsync(true);
                createTree(functree,'<%=startNode%>',0);
           </script>
           </div>
		</td>
		<td valign="top" width="220px">
			<div id="favtDiv" style="text-align: center;height: 450px;overflow: auto;border: 1px solid #ededed">
				<%
				if(funcList.size()>0){
				for(int i=0;i<funcList.size();i++){
					FunctionInfo fun = (FunctionInfo)funcList.get(i);
				%>
				<div class="menudiv" id="div_<%=fun.getId().trim() %>" title="<%=fun.getFuncname() %>"><%=fun.getFuncname() %><input type="hidden" name="favtinput" id="favt_<%=fun.getId().trim() %>" value="<%=fun.getId().trim() %>"/></div>
				<%} }else{%>
				<div style="font-size: 12px;color: green;padding: 5px;text-align: center;" id="msg" class="menudiv2" >请在左侧选择个人收藏夹菜单</div>
				<%} %>
			</div>
		</td>
	</tr>
</table>
</div>
<script type="text/javascript">
	window.onload = function(){
		PrivAction.getFavtList(selectFunction);
		setOnClick();
	}

	function selectFunction(data){
		for(var i=0;i <data.length;i++){
		 	var num = "id" + data[i];
	        if(document.getElementById(num) != null){
	        	document.getElementById(num).checked=true;
	        }
        }
	}

	function chkclick(obj){
		var fid = obj.getAttribute("id").replace("id","");;
		if(obj.checked){
			var objs = document.getElementsByName("favtinput");
			if(objs.length+1><%=row%>){
				obj.checked = false;
				alert("个人收藏夹请不要超过<%=row%>个!");
				return false;
			}

			var name=obj.parentNode.innerText;
			var div = document.createElement("div");
			div.className="menudiv";
			div.setAttribute("id", "div_"+fid);
			div.innerHTML = name+"<input type='hidden' name='favtinput' id='favt_"+fid+"' value='"+fid+"'/>";
			document.getElementById("favtDiv").appendChild(div);
		}else{
			var div=document.getElementById("div_"+fid);
			if(div!=null){
				document.getElementById("favtDiv").removeChild(div);
			}
		}
		var len = document.getElementsByName("favtinput").length;
		var msgobj = document.getElementById('msg');
		if(msgobj!=null){
			if(len>0){
				msgobj.style.display = "none";
			}else{
				msgobj.style.display = "";
			}
		}
	}

	function setOnClick(){
		var chks = document.getElementsByTagName("input");
		for (var i = 0; i <chks.length ; i++) {
			var chk = chks[i];
			var ta = chk.getAttribute("type");
			if(ta=="checkbox"){
				var val = chk.value;
				if(val=="on"){
					chk.style.display ="none";
				}else{
					chk.onclick = function(){
						chkclick(this);
					};
				}
			}
		}
	}

	function canFavt(){
		window.parent.maxFrm(0);
	}

	function saveFavt(){
		var objs = document.getElementsByName("favtinput");
		var ids = new Array(objs.length);
		for(var i=0;i<objs.length;i++){
			ids[i]=objs[i].value;
		}
		PrivAction.saveFavt(ids,savecallback);
	}

	function savecallback(data){
		alert("保存成功！");
		canFavt();
	}

</script>
</body>
</html>