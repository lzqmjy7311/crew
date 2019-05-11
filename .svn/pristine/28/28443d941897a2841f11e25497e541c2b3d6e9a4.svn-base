<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
</head>
<!-- modify jiang@2009-11-02 BMS-2142 -->
<script language="JavaScript" type="text/javascript">

  if (window.self != window.top) {
      window.open("<%=request.getContextPath()%>/common/expired.jsp", "_top");
    }

var secs =5; //倒计时的秒数
var URL ;
function Load(url){
URL =url;
for(var i=secs;i>=0;i--)
{
window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000);
}
}
function doUpdate(num)
{
document.getElementById('ShowDiv').innerHTML = num ;
if(num == 0) { window.location=URL; }
}
</script>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="56"><img src="<%= request.getContextPath()%>/images/info_f1.gif" width="56" height="44"></td>
    <td width="921" background="<%= request.getContextPath()%>/images/info_f3.gif">
         <img src="<%=request.getContextPath()%>/images/info_f2.gif" width="165" height="44">
    </td>
    <td width="26"><img src="<%= request.getContextPath()%>/images/info_f4.gif" width="26" height="44"></td>
  </tr>
  <tr>
    <td height="71" valign="top" background="<%=request.getContextPath()%>/images/info_f6.gif"><img src="<%=request.getContextPath()%>/images/info_f5.gif" width="56" height="30"></td>
    <td align="center" class="tdValue">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<tr>
    		<td colspan="3" align="center" height="13"></td>
    	</tr>
    	<tr>
    		<td colspan="3" align="center" class="tdValue"><font color="#FF6000">您的会话已过期或无效，请重新登陆！原因为下列之一：</font></td>
    	</tr>
    	<tr>
    		<td colspan="3" align="center" height="23"></td>
    	</tr>
    	<tr>
		<td width="27%"></td>
		<td align="left" class="tdValue">
			<ul>
				<li>您已经超过会话有效时间未访问应用服务器，本地会话已过期</li>
				<li>系统中另一个用户已经以同一个用户标识登录，本地会话已无效</li>
				<li>您的会话标识为空或者用户会话数据为空，本地会话已无效</li>
			</ul>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label id="ShowDiv"></label>&nbsp;秒后跳转到&nbsp;<a href=<%=request.getContextPath()%>>登陆页面</a>
			<script language="javascript">
			Load("<%=request.getContextPath()%>");
			</script>
		</td>
		<td width="20%"></td>
		</tr>
		</table>
    </td>
    <td width="26" background="<%=request.getContextPath()%>/images/info_f11.gif">&nbsp;</td>
  </tr>
  <tr>
    <td><img src="<%=request.getContextPath()%>/images/info_f7.gif" width="56" height="36"></td>
    <td background="<%=request.getContextPath()%>/images/info_f9.gif"><img src="<%=request.getContextPath()%>/images/info_f8.gif" width="77" height="36"></td>
    <td width="26"><img src="<%=request.getContextPath()%>/images/info_f10.gif" width="25" height="35"></td>
  </tr>
</table>
<!-- end BMS-2142 -->
</body>
</html>
