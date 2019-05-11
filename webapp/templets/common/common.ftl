<#--global value-->
<#global contextPath = contextPath>
<#---->

<#macro page title>
<html>
  <head>
    <title>${title}</title>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate,text/html; charset=GBK ">
	<META HTTP-EQUIV="expires" CONTENT="0">
<#--<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/admin.css">-->
<#--<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console.css">-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/GenShell.css">
<#--<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/front.css">-->
<#--<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console1.css">-->
<#--<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Styles.css">-->
	<link rel="stylesheet" type="text/css" media="all" href="${contextPath}/page/resources/style/style.css" />

<#--<script language="javascript" src="${contextPath}/page/resources/script/softPwd.js"></script>-->
    <script language="javascript" src="${contextPath}/page/resources/script/validations.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/rules.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/com_proc_func.js"></script>
<#--<script language="javascript" src="${contextPath}/page/resources/script/dispatch.js"></script>-->
	<script language="javascript" src="${contextPath}/page/resources/script/basefunc.js"></script>
    <script language="javascript" src="${contextPath}/page/resources/script/utilities.js"></script>
<#--<script language="javascript" src="${contextPath}/page/resources/script/dateCheck.js"></script>-->
	<script language="javascript" src="${contextPath}/page/resources/script/layout.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/datagrid.js"></script>

	<script language="javaScript">
	/*
	  document.oncontextmenu=new function{event.returnValue=false;return false;}
	  */
	  //屏蔽鼠标右键
    </script>
  </head>
  <body>
  <#--
  	 <@loading/>
  -->
    <#nested>
  </body>

</html>
</#macro>

<#macro pageI title bodyclass bodyid>
<html>
  <head>
    <title>${title}</title>
    <meta http-equiv="Content-type" content="text/html; charset=GBK">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/admin.css">
	<link rel="stylesheet" type="text/css" media="all" href="${contextPath}/page/resources/style/style.css" />
    <script language="javascript" src="${contextPath}/page/resources/script/validations.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/rules.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/com_proc_func.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/dispatch.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/basefunc.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/utilities.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/dateCheck.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/layout.js"></script>
	<script language="javaScript">
	/*
	  document.oncontextmenu=new function{event.returnValue=false;return false;}
	  */
	  //屏蔽鼠标右键
    </script>
  </head>
  <body class="${bodyclass}" id="${bodyid}">
    <#nested>
  </body>
</html>
</#macro>

<#macro pageII title csshref bodyclass bodyid>
<html>
  <head>
    <title>${title}</title>
    <meta http-equiv="Content-type" content="text/html; charset=gb2312">
    <link rel="stylesheet" href="${csshref}" type="text/css" />
  </head>
  <body class="${bodyclass}" id="${bodyid}">
    <#nested>
  </body>
</html>
</#macro>

<#macro pageIII title>
<html>
  <head>
    <title>${title}</title>
    <meta http-equiv="Content-type" content="text/html; charset=GBK">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/admin.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/GenShell.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/front.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console1.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Styles.css">
	<link rel="stylesheet" type="text/css" media="all" href="${contextPath}/page/resources/style/style.css" />
	<link href="${contextPath}/page/resources/style/softPwd.css" rel="stylesheet" type="text/css" />

  </head>
  <body>
    <#nested>
  </body>
</html>
</#macro>

<#macro pageIV title>
<html>
  <head>
    <title>${title}</title>
	<META HTTP-EQUIV="Cache-Control" CONTENT="must-revalidate,text/html; charset=GBK ">
	<META HTTP-EQUIV="expires" CONTENT="0">
<#--<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/admin.css">-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/GenShell.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/front.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console1.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Styles.css">
	<link rel="stylesheet" type="text/css" media="all" href="${contextPath}/page/resources/style/style.css" />

<#--<script language="javascript" src="${contextPath}/page/resources/script/softPwd.js"></script>-->
    <script language="javascript" src="${contextPath}/page/resources/script/validations.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/rules.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/com_proc_func.js"></script>
<#--<script language="javascript" src="${contextPath}/page/resources/script/dispatch.js"></script>-->
	<script language="javascript" src="${contextPath}/page/resources/script/basefunc.js"></script>
    <script language="javascript" src="${contextPath}/page/resources/script/utilities.js"></script>
<#--<script language="javascript" src="${contextPath}/page/resources/script/dateCheck.js"></script>-->
	<script language="javascript" src="${contextPath}/page/resources/script/layout.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/datagrid.js"></script>

	<script language="javaScript">
	/*
	  document.oncontextmenu=new function{event.returnValue=false;return false;}
	  */
	  //屏蔽鼠标右键
    </script>
  </head>
  <body>
  <#--
  	 <@loading/>
  -->
    <#nested>
  </body>

</html>
</#macro>

<#macro pageV title onloadfunction>
<html>
  <head>
    <title>${title}</title>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate,text/html; charset=GBK ">
	<META HTTP-EQUIV="expires" CONTENT="0">
<#--<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/admin.css">-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/GenShell.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/front.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Console1.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/Styles.css">
	<link rel="stylesheet" type="text/css" media="all" href="${contextPath}/page/resources/style/style.css" />

<#--<script language="javascript" src="${contextPath}/page/resources/script/softPwd.js"></script>-->
    <script language="javascript" src="${contextPath}/page/resources/script/validations.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/rules.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/com_proc_func.js"></script>
<#--<script language="javascript" src="${contextPath}/page/resources/script/dispatch.js"></script>-->
	<script language="javascript" src="${contextPath}/page/resources/script/basefunc.js"></script>
    <script language="javascript" src="${contextPath}/page/resources/script/utilities.js"></script>
<#--<script language="javascript" src="${contextPath}/page/resources/script/dateCheck.js"></script>-->
	<script language="javascript" src="${contextPath}/page/resources/script/layout.js"></script>
	<script language="javascript" src="${contextPath}/page/resources/script/datagrid.js"></script>

	<script language="javaScript">
	/*
	  document.oncontextmenu=new function{event.returnValue=false;return false;}
	  */
	  //屏蔽鼠标右键
    </script>
  </head>
  <body onload=${onloadfunction}>
  <#--
  	 <@loading/>
  -->
    <#nested>
  </body>

</html>
</#macro>

<#macro loading>
<STYLE>
.proccess {
BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BACKGROUND: #ffffff; MARGIN: 3px;
BORDER-LEFT: 1px solid; WIDTH: 8px;
BORDER-BOTTOM: 1px solid; HEIGHT: 8px
}
</STYLE>
<DIV id="loading__" style="visibility:hidden;position: absolute;width: 345px; height: 100px; z-index: 9999; left: 280px; top:200px; padding-left:4px; padding-right:4px; padding-top:1px; padding-bottom:1px;background-color:#FFF222">
<TABLE height="100%" cellSpacing="1" cellPadding="8" width="100%" align=center>
	<TBODY>
		<TR>
			<TD align=middle>
			<P></P>
			<!--  Displaytext-->
			<P></P>
			<P align=center><FONT class=fontbig></FONT></P>
			<SPAN
				style="FONT-WEIGHT: bold; FONT-SIZE:9pt; FONT-FAMILY: 宋体; font-color: black">
				正在处理中,请稍候...
			</SPAN>
			<BR>
			<SPAN style="FONT-SIZE: 9pt; FONT-FAMILY: Tahoma, Arial; font-color: black">
			Processing Information, please wait...
			</SPAN>
			<P></P>
			<FONT class="fontbig">
			<P></P>
			<P></P>
			<DIV align="center">
			<FORM name="proccess" method="post">
			<SCRIPT language="javascript">
        				 for(i=0;i<30;i++){
              			 	document.write("<input class=proccess>")
        		}
        		</SCRIPT></FORM>
			</DIV>
			</FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<table align=center>
	<SCRIPT language=JavaScript><!--
    var p=0,j=0;
    var c=new Array("lightskyblue","white")
    setInterval('proccess();',100)
    function proccess(){
       document.forms.proccess.elements[p].style.background=c[j];
       p+=1;
       if(p==30){p=0;j=1-j;}}
  --></SCRIPT>
</table>
</DIV>
<script>
	function loadingShow(){
		document.all("loading__").style.visibility = "visible";
	}
	function loadingHide(){
		document.all("loading__").style.visibility = "hidden";
	}
</script>
<!---------------- loading... end -------------------------------------->
<script language="javascript">
function loadingToCenter(){
 var load = document.all("loading__");
 var w = 340;
 var h = 100;

 load.style.left = screen.width/2 - w/2;
 load.style.top = 150;
}

try{
 loadingToCenter();
}catch(e){
}

var has = false;
function hasSubmit(){
	   //document.body.style.background=#111111
	   document.body.disabled = true;
       if(has){
         //loadingHide();
             return false;
        }else{
      			loadingShow();
            has = true;
            return true;
        }
    }

</script>

</#macro>


<#macro newpage title>
<html>
  <head>
    <title>${title}</title>
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="must-revalidate">
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="funccode:needlog" CONTENT="20200:false">
	<link rel="stylesheet" type="text/css"
		href="${contextPath}/templets/lib/themes/default/extra.css">
	<style>
	#body {
		visibility: hidden;
	}
	</style>
	<script language="jscript.encode" src="${contextPath}/templets/lib/rules.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/strings/chinese.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/basic.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/common.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/control.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/dataset.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/editor.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/table.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/dropdown.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/tree.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/menu.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/pagepilot.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/salert.js"></script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/bank.js"></script>
    <script type='text/javascript' src='${contextPath}/dwr/engine.js'> </script>
    <script type='text/javascript' src='${contextPath}/dwr/util.js'> </script>
	<script language="jscript.encode" src="${contextPath}/templets/lib/dwr.js"></script>
	<script language="javaScript">
	/*
	 // document.oncontextmenu=new function{event.returnValue=false;return false;}
	  */
	  //屏蔽鼠标右键
    </script>
    <script language="javascript">
<!--
var _extra_library="${contextPath}/templets/lib";
var _theme_root="${contextPath}/templets/lib/themes/default";
var _application_root="${contextPath}";
var _defaultSubmitUrl=getDecodeStr("~2fextraservice~2fupdate");
var _dynamicDropDownUrl=getDecodeStr("~2fdynamicdropdown~2ejsp");
var _checkBrowser=true;
var _disableSystemContextMenu=false;
var _processEnterAsTab=true;
var _enableClientDebug=true;
var _supportsDatasetMultiSelect=true;
var _paramMap = new Map();//use to set  defaults in dataset

var timer;
var text="正在载入";i=0;
function load() {
　　if(i<6) {
　　		text+=".";
　　		document.getElementById("Waiting").innerText=text;
　　		i++;
    }
　　else {
		text="正在载入文档";i=0;
	}
}
　　timer=window.setInterval("load()",300);
//-->
</script>
  </head>
  <body bgcolor="#FFFFFF" onload='clearInterval(timer);document.getElementById("Loading").style.display="none";'>

  <div id="Loading" style="position:absolute;width:100%; height:100%; z-index:100;background:white;">
　<div id="Waiting" style="position:absolute;left:50%;top:50%;"></div></div>
    <#nested>
  </body>
</html>
<script language="javascript">
var PageState=_createPageState();
PageState.version=-1;
function _setElementsProperties(){};
initDocument();
initCallGetter();

</script>

</#macro>




