<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.huateng.ebank.business.common.SystemConstant"%>
<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/application-tags" prefix="app"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import ="com.huateng.ebank.business.common.UserSessionInfo"  %>
<html:html>
<head>
<link rel="icon" type="image/png" href="<%=request.getContextPath() %>/login/images/indeximg/sh-logo.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/b.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/CFInstall.min.js"></script>
<title>上海农商银行信用风险预警系统</title>
<script>
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
		//out.println("document.loginForm.userName.readOnly=true;");
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
<style>
body{
	background: url("<%=request.getContextPath() %>/login/images/indeximg/2.png");
}
.panel_main{
	margin:175px auto 0px auto;
	height:325px;width:509px;
	background-image: url('<%=request.getContextPath() %>/login/images/indeximg/test.jpg');
}
.cnt_login{
	width:225px; 
	padding-top:169px;
	margin-left:234px;
	text-align:right;
	list-style: none;
}
.cnt_login li{
 	height:30px; 
 	line-height:30px;
 	padding:10px 0px;
}
.cnt_login input{ 
	background:#f1f5f9;
	border:none; 
	border-top:1px solid #d4dde5;
 	height:27px;  
 	line-height:27px;
    width:160px;  
}
.cnt_login .itm{
 	height:30px; 
 	float:left;
}
.hand{
	cursor: pointer;
}
.cnt_login {
	font-size: 14px;
}
.input_cls{
   color:gray;
}
</style>
</head>
<body onload="func_check()">

<div class="bg_login">
  <div class="line_login">
    <div class="panel_login">
    	
    	<div class="panel_main">
    		<html:form action="/custlogin.do" target="_top" focus="userName">
		        <ul class="cnt_login">
		          <li>
		            <div class="itm input_cls">用户名:</div>
		            <div class="itm">
		          	  <html:text property="userName" value="" 	onkeypress="nextEvent('passWord');" maxlength="8"/>
		            </div>
		            <div class="itm"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif" height="30px"  alt="" /></div>
		          </li>
		          <li>
		            <div class="itm input_cls">密　码:</div>
		            <div class="itm">
		            	<html:password property="passWord" value="" 	onkeypress="nextEvent('submit');"/>
		            </div>
		            <div class="itm"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  height="30px" alt=""  onclick="resetForm()"/></div>
		          </li>
		          <li style="white-space: nowrap;">
		          	<center>
		         		<img  src="<%=request.getContextPath() %>/login/images/btn_login.png" class="hand"  alt="" onclick="submitForm()"/>
		         	</center>
		          </li>
		        </ul>
		   </html:form>
    	</div>
    </div>
  </div>
</div>
</body>
</html:html>
