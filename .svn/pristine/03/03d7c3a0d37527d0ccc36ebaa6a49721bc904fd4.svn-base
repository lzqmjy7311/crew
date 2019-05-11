<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/blue/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/uicore-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/locale/lang-zh_CN.js"></script>
<style>
	.panel-body{
		overflow-x:hidden;
	}
	.body-regin {
		background-color: #F3F3F3;
	}
	.theme-div{
		width:200px;
		height:140px;
		text-align:center;
		cursor:hand;
		border:3px solid #FFF;
		float:left;
		margin:2px;
	}
	.theme-img{
		width:100%;
		height:120px;
	}
	.theme-title{
		padding-left:12px;
	}
	.theme-hover{
		border-color:#C0D6E7;
	}
	.theme-selected{
		border-color:#CBE2D6;
	}
	span.l-btn-text{
		padding-left:16px !important;
		font-size:18px;
		font-color:#444;
		font-weight: bold;
	}
</style>
</head>

<body>
<div region="center" border="false" id="centerDiv" class="body-regin">
<%
    String path = request.getRealPath("/");
	String themepath = "/templets/ui/themes/";
    File dir = new File(path + themepath);
    File[] filen = dir.listFiles();
    if (filen != null) {
        for (int i = 0; i < filen.length; i++) {
            if (filen[i].isDirectory()) {
				String themeName = filen[i].getName();                
                if (!"icons".equalsIgnoreCase(themeName)) {
                    String imgpath = request.getContextPath()+themepath+themeName;
                    out.print("<div class=\"theme-div\" theme=\""+themeName+"\"><img src=\""+imgpath+"/images/preview.jpg\" class=\"theme-img\" /><a>"+themeName+"</a></div>");
                    out.println();
                }
            }

        }
    }
%>
</div>
<script type="text/javascript">
	$('body').layout();
	var _current_user = '<%=((GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO)).getTlrno()%>';
	$(function(){
		$(".theme-div").hover(function(){
			$(this).addClass("theme-hover");
		},function(){
			$(this).removeClass("theme-hover");
		}).click(function(){
			$(".theme-selected .l-btn-text").removeClass("icon-ok");
			$(".theme-selected").removeClass("theme-selected");

			$(".l-btn-text",this).addClass("icon-ok");
			$(this).addClass("theme-selected");
			
			if($(this).attr("theme")) {
				swicthAllThemes($(this).attr("theme"));
			}
		});
		$(".theme-div a").each(function(){
			$(this).linkbutton({
				plain:true
			});
		});
		$(".theme-div[theme='"+($.cookie('fpportal-theme-'+_current_user)||"blue")+"']").trigger("click");
	});
	
</script>
</body>
</html>