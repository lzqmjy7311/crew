<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/application-tags" prefix="app" %>
<% response.setStatus(200);%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<style>
	.suc{
		background: url("<%=request.getContextPath()%>/common/404.png") no-repeat center center;
		width:600px;
		height:400px;
	}
</style>

</head>

<body>
	<div class="suc"></div>
</body>
</html>