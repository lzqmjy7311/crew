<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/application-tags" prefix="app" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<style>
	.suc{
		background: url("<%=request.getContextPath()%>/common/errorAuthority.png") no-repeat center center;
		width:600px;
		height:400px;
	}
</style>
</head>

<body>
  <div align="center">
     <div style="height:50px"></div>
     <div ><font color="red">没有访问权限，请联系管理员，谢谢。</font></div> 
	<div class="suc"></div>
  </div>
</body>
</html>
