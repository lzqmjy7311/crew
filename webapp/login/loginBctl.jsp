<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.huateng.ebank.business.common.SystemConstant"%>
<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/application-tags" prefix="app"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import ="com.huateng.ebank.business.common.UserSessionInfo"  %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/login/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/b.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/CFInstall.min.js"></script>
<title>FlowPower 统一开发平台</title>
<script language="JavaScript" type="text/JavaScript">
var _application_root = "<%=request.getContextPath()%>";
if (window.self != window.top) {
    window.open("<%=request.getContextPath()%>/", "_top");
  }
function func_check()
{
	CFInstall.check();
	<% if (request.getAttribute("REQ_MSG") != null) {
		String errMsg = ((String) request.getAttribute("REQ_MSG")).replace("\n","[n]");
	%>
	var errMsg = "<%= errMsg %>";
	alert(errMsg.replace("[n]","\n"));
	<% } %>
	<%
	UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
	if(userInfo!=null)
	{
		out.println("document.loginForm.userName.value = \""+userInfo.getTlrNo()+"\";");
		out.println("document.loginForm.userName.readOnly=true;");
		out.println("focus(document.loginForm.passWord);");
	}
%>

	return;
}
var isenc = false;
function submitForm(){
	if(document.loginForm.userName.value==""){
//		document.all.mistake.innerText="用户名不能为空！";
		return;
	}else if(document.loginForm.passWord.value==""){
//		document.all.mistake.innerText="密码不能为空！";
		return;
	}else if(document.loginForm.brCode.value==""){
//		document.all.mistake.innerText="机构不能为空！";
		return;
	}
	if(!isenc) {
		document.loginForm.passWord.value = new _B().encode(document.loginForm.passWord.value);
		isenc=true;
		document.loginForm.submit();
	}
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 begin
function resetForm(){
	document.loginForm.reset();
	document.loginForm.userName.value ="";
	document.loginForm.passWord.value ="";
	document.loginForm.brCode.value ="";
	isenc=false;
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 end
function nextEvent(strName){
	if(event.keyCode==13 || event.keyCode==9){
	 	if (strName == "submit"){
			submitForm();
		}else{
			document.getElementById(strName).focus();
		}
	}
}
</script>
<style type="text/css">
	.inputcls{
		background:#f1f5f9;height:26px; line-height:26px; width:200px;border:none;
	}
#brCodeOl{
	list-style:none;
	margin:0 1px;
	border-top:1px solid #81aedc;border-left:1px solid #81aedc; border-bottom:1px solid #5081b0; border-right:1px solid #5081b0;
	float:left;
	display:none;
	overflow:hidden;
	width:auto;
	white-space: nowrap;

}
#brCodeOl li{
	height:22px;
	width:100%;
	cursor: default;
	white-space: nowrap;
}
#brCodeOl li a{
	height:22px;
	line-height:22px;
	text-decoration:none;
	color:#000;
	display:block;
	background-color: #ffffff;
	font-size: 12px;
	font-family: Arial,Helvetica,sans-serif;
	padding-left: 2px;
	border-bottom:1px solid #ededed;
	cursor: default;
	white-space: nowrap;
	width: 100%;
	padding-right: 3px;
	padding-left: 3px;
}
#brCodeOl li a:hover{
	text-decoration:none;
	color:#ffffff;
	background-color: highlight;
	cursor: default;
	white-space: nowrap;
}

</style>
</head>
<body onload="func_check()">

<div class="bg_login">
  <div class="line_login">
    <div class="cloud"><img src="<%=request.getContextPath() %>/login/images/logo.png"  alt="" /></div>
    <div class="panel_login">
   <html:form action="/custlogin.do" target="_top" focus="userName">
   <input type="hidden" name="brCode" id="brCode"/>
   <table cellpadding="0" cellspacing="0" border="0" width="595px" height="210xp">
		<tr>
			<td align="center" valign="top">
			<table cellpadding="0" cellspacing="0" border="0" width="246px" style="margin-top: 20px;">
			<tr  height="35px">
				<td width="37px"><img src="<%=request.getContextPath() %>/login/images/icon_user.gif"  alt=""/></td>
				<td width="100%"> <input type="text" name="userName"  id="userName" value=""	onkeypress="nextEvent('brCodeName');" maxlength="10" class="inputcls"/></td>
				<td width="9px;"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  alt="" /></td>
			</tr>
			<tr>
			
			<tr height="35px">
				<td width="37px"><img src="<%=request.getContextPath() %>/login/images/icon_jigou.gif"  alt="" id="brcodeImg1" title="点击选择机构"/></td>
				<td width="100%">
				<input type="text" name="brCodeName" id="brCodeName"  value="--请选择机构--" class="inputcls" readonly="readonly" style="cursor: default;" onkeypress="nextEvent('passWord');"/><p>
				<div id="brCodeSelect" style="position:absolute;width:auto;">
					<ol id="brCodeOl">
						<li><a href="javascript:setBrCode('XX银行总行','123456666666');" id="bctl_123456666666">123456666666-XX银行总行</a></li>
					</ol>
				</div>
				</p>
				</td>
				<td width="9px;"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  alt=""  id="brcodeImg2"/></td>
			</tr>
			<tr  height="35px">
				<td width="37px"><img src="<%=request.getContextPath() %>/login/images/icon_lock.gif"  alt=""/></td>
				<td width="100%"><input type="password" name="passWord" id="passWord" value=""	onkeypress="nextEvent('submit');" class="inputcls"/></td>
				<td width="9px;"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  alt="" /></td>
			</tr>
			<tr height="40px">
				<td colspan="3" valign="middle" align="center">
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						<td align="center">
						<img src="<%=request.getContextPath() %>/login/images/btn_login.png" class="hand"  alt="" onclick="submitForm()"/></li>
						</td>
						<td align="center">
						<img src="<%=request.getContextPath() %>/login/images/btn_cancel.png" class="hand"  alt="" onclick="resetForm()"/>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			</table>
			</td>
		</tr>
	</table>
      </html:form>
    </div>
  </div>
</div>
<script type="text/javascript">
	function setBrCode(name,code){
		var sel = document.getElementById("brCode").value;
		document.getElementById("bctl_"+code).style.backgroundColor = "highlight";
		document.getElementById("bctl_"+code).style.color = "#ffffff";
		if(sel!=null && sel.length>0 && sel!=code){
			document.getElementById("bctl_"+sel).style.backgroundColor = "";
			document.getElementById("bctl_"+sel).style.color = "";
		}
		document.getElementById("brCodeName").value = name;
		document.getElementById("brCode").value = code;
		hideOptions();
		document.getElementById("passWord").focus();
	}

	function showOptions () {
		var bcHt = document.getElementById("brCodeOl");
		bcHt.style.display='block';
		var ht = bcHt.offsetHeight;
		if(ht>160){
			bcHt.style.height="160px";
		}
	}
	function hideOptions () {
		document.getElementById("brCodeOl").style.display='none';
	}
	document.onclick = function(e){
		var evt = e?e:window.event;
		var ele = evt.srcElement || evt.target;
		if(ele.id == 'brCodeName' || ele.id == "brcodeImg1" || ele.id == "brcodeImg2"){
			showOptions();
		}else{
			hideOptions();
		}
	}
</script>
</body>
</html:html>
