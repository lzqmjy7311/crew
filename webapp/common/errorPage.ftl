<#global contextPath = contextPath>
<#assign detail = ERR_DETAIL?default('')?js_string>
<#assign errCd = ERR_ERRCODE>
<html>
<head>
	<title>��������</title>
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="must-revalidate">
	<MEAT HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=GBK">
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<script language="javascript" src="${contextPath}/templets/lib/salert.js"></script>
	<script language="JavaScript" type="text/javascript">
			if("${errCd}" == "GD0101"){
				//GD0101=����Ա�޴˹���Ȩ��
				errAlert("${detail}");
				window.open("${contextPath}", "_self");
			}else if("${errCd}" ==  "GD0102"){
				//GD0102=����Ա�Ự��Ч
				errAlert("${detail}");
				window.open("${contextPath}", "_self");
			}else{
				errAlert("${detail}");
			}
	</script>
</head>
</html>