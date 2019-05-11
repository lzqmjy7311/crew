<!-- 
	使用方法:
	code.jsp?ftl=file1;file2;&commquery=file3;file4
	ftl文件将在/demo/ftl下查找，commquery文件在/demo/xml下查找
-->
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%
	Map<String,String> map = new HashMap<String,String>();
	String path = request.getSession().getServletContext().getRealPath("");
	String[] ftlArr = StringUtils.split(request.getParameter("ftl"),";");
	String[] queryArr = StringUtils.split(request.getParameter("commquery"),";");
	if(ftlArr == null){
		ftlArr = new String[]{};
	}
	if(queryArr == null){
		queryArr = new String[]{};
	}
	for(String ftlStr:ftlArr){
		File ftlFile = new File(path + "/demo/ftl/" + StringUtils.trim(ftlStr) + ".ftl");
		InputStream input = null;
		try{
			if(ftlFile.exists()){
				input = new BufferedInputStream(new FileInputStream(ftlFile));
				String foo = IOUtils.toString(input, "GBK").replaceAll("<","&lt;");
				map.put(ftlStr+".ftl", foo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(input!=null){
				try{
					input.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	for(String commqueryStr:queryArr){
		File commqueryFile = new File(path + "/demo/xml/" + commqueryStr + ".xml");
		InputStream input2 = null;
		try{
			if(commqueryFile.exists()){
				input2 = new BufferedInputStream(new FileInputStream(commqueryFile));
				String bar = IOUtils.toString(input2, "UTF-8").replaceAll("<","&lt;");
				map.put(commqueryStr+".xml", bar);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(input2!=null){
				try{
					input2.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>代码</title>
<script type="text/javascript" src="syntaxhighlighter/scripts/shCore.js"></script>
<script type="text/javascript"
	src="syntaxhighlighter/scripts/shBrushPlain.js"></script>
<script type="text/javascript"
	src="syntaxhighlighter/scripts/shBrushXml.js"></script>
<link type="text/css" rel="stylesheet"
	href="syntaxhighlighter/styles/shCoreEclipse.css" />
<script type="text/javascript">
	SyntaxHighlighter.all();
</script>
</head>
<body>
	<%
	for(String foo:ftlArr){
		if(map.containsKey(foo+".ftl")){
%>
	<h2><%= "/demo/ftl/"+foo %>.ftl
	</h2>
	<pre class="brush: text"><%= map.get(foo+".ftl") %></pre>
	<%
		}
	}
%>
	<%
	for(String bar:queryArr){
		if(map.containsKey(bar+".xml")){
%>
	<h2><%= "/demo/xml/"+bar %>.xml
	</h2>
	<pre class="brush: xml"><%= map.get(bar+".xml") %></pre>
	<%
		}
	}
%>
</body>
</html>