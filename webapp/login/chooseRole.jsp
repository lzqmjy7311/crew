<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="java.util.*"%>
<%@page import="com.huateng.ebank.entity.data.mng.RoleInfo"%>
<%@page import="com.huateng.ebank.entity.data.mng.Bctl"%>
<%@page import="com.huateng.ebank.entity.data.mng.TlrRoleRel"%>
<%@page import="com.huateng.ebank.business.management.service.UserMgrService"%>
<%@page import="com.huateng.ebank.framework.exceptions.CommonException"%>
<%@page import="com.huateng.ebank.business.common.DAOUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>切换机构及岗位</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/blue/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/uicore-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/locale/lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/rules.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/basic.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/properties.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/uiextend-min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/uirender-min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/uidata-min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/tree.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/inquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/report.js"></script>

<script type="text/javascript" src='<%=request.getContextPath()%>/dwr/engine.js'> </script>
<script type="text/javascript" src='<%=request.getContextPath()%>/dwr/util.js'> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/dwr.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/TaskVariable.js'> </script>
<style>
body{
	background-color: #D6EEFB;
	border:1px #BFE0EF solid;
	padding:10px;
	text-align: left;
	font-size:13px;
}
#btn-save{
	margin-top:5px;
}
</style>
</head>

<body>
<form action="<%=request.getContextPath() %>/custlogin.do" method="post" id="crForm" target="_parent">
<div style='padding-bottom:5px;'>>切换机构或岗位：</div>
<div>机构列表:</div>
<div>
<select name="orgId">
<%
//取用户所有岗位
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
List<Bctl> list = UserMgrService.getInstance().getUserOrgs(globalInfo.getTlrno());
//取用户默认岗位
String brcode=globalInfo.getBrcode();
String userId=globalInfo.getTlrno();
String roleId=globalInfo.getWorkflowRoleId();

for(Bctl  b:list){
	if(brcode!=null && brcode.equals(b.getBrcode())){
		out.println("<option value='"+b.getBrcode()+"' selected='selected'>"+b.getBrname()+"</option>");
	}else{
		out.println("<option value='"+b.getBrcode()+"'>"+b.getBrname()+"</option>");
	}
}
%>
</select>
</div>

<div>岗位列表:</div>
<div>
<select name="roleId">
	
</select>
</div>
<input name="changeRole" value="changeRole" type="hidden"/>
<br/>
<button type="submit" id="btn-save">确定</button>
</form>

<script  type="text/javascript">
	var userId='<%=userId%>';
	var brcode='<%=brcode%>';
	var roleId='<%=roleId%>';
	
	loadRoles(userId,brcode);
	//listeners
	$("#btn-save").linkbutton({iconCls:'icon-ok'});
	$("select[name=orgId]").bind('change',function(r){
		var _brcode=($(this).find("option:selected").attr("value"));
		loadRoles(userId,_brcode);
	});
	
	function loadRoles(userId,orgId){
		TaskVariable.getUserRoleByOrgIdMap(userId,orgId,function(data){
			$("select[name=roleId]").empty();
			if(data!=null){
				$.each(data,function(i,r){
					if(r.roleId==roleId){
						$("select[name=roleId]")
						.append("<option selected='seleted' value='"+r.roleId+"'>"+r.roleName+"</option>");
					}else{
						$("select[name=roleId]")
						.append("<option value='"+r.roleId+"'>"+r.roleName+"</option>");
					}
				});
			}
		});
	}
</script>
</body>
</html>