<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.huateng.ebank.business.common.DAOUtils"%>
<%@page import="java.util.*"%>
<%@page import="com.huateng.ebank.entity.data.mng.FunctionInfo"%>
<%@page import="org.apache.commons.jxpath.JXPathContext"%>
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.business.management.service.UserMgrService"%>
<%
GlobalInfo globalInfo = (GlobalInfo)session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
//GlobalInfo.setCurrentInstance(globalInfo);
List<FunctionInfo> userlist = UserMgrService.getInstance().getUserFunctions(globalInfo.getTlrno());
Iterator it = userlist.iterator();
StringBuffer menuDiv = new StringBuffer();
while(it.hasNext()){
	FunctionInfo fi = (FunctionInfo)it.next();
	if(fi.getLastdirectory()==0){
		if(fi.getIsdirectory() == 1){
			menuDiv.append(getSubDiv(fi,userlist));
		}else{
			menuDiv.append("<li><a href=\"javascript:doWork('" + fi.getFuncname()+ "','" + fi.getPagepath()+ "')\">" + fi.getFuncname() + "&nbsp;&nbsp;</a></li>");
		}
	}else{
		//ignore
	}
}
%>
<%!
StringBuffer getSubDiv(FunctionInfo fi, List dirList){
	StringBuffer menuDiv = new StringBuffer();
	String stylelink = "";
	if(fi.getLastdirectory()==0){
		stylelink = "style='padding-right:10px;'";
	}
	if(fi.getIsdirectory() == 1){
		menuDiv.append("<li class=\"MenuBarItemSubmenu\"  "+stylelink+"><a href=\"#\">" + fi.getFuncname() + "&nbsp;&nbsp;</a><ul>");
		Iterator it1 = dirList.iterator();
		while(it1.hasNext()){
			FunctionInfo fi1 = (FunctionInfo)it1.next();
			if(fi.getId().trim().equals(String.valueOf(fi1.getLastdirectory()) )){
				menuDiv.append(getSubDiv(fi1,dirList));
			}else{
				//ignore
			}
		}
		menuDiv.append("</ul></li>");
	}else{
		menuDiv.append("<li><a href=\"javascript:doWork('" + fi.getFuncname()+ "','" + fi.getPagepath()+ "')\">" + fi.getFuncname() + "</a></li>");
	}
	return menuDiv;
}
%>
<ul id="MenuBar" class="MenuBarHorizontal">
<%=menuDiv.toString()%>
</ul>

