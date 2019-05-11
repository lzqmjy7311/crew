<#--global value-->
<#global contextPath = contextPath>
<#---->

<#macro tabspage tabsId currentTabId>
<#assign config = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean("${tabsId}")>
<#assign tabs ="" >
<#assign divString = "">
<#assign currentTabId = "${currentTabId}">
<#assign operationsMap = config.getOperations()>
<#assign operationsKeys = operationsMap.keySet()>
<#list operationsKeys as key>
			<#assign button = config.getOperationsElement(key?string)>
	 	 	<#assign desc = button.attributes("desc")?default("")>
	 	 	<#assign name = button.attributes["name"]?default("")>
	  	 	<#assign url  = button.attributes["url"]?default("")>
	 	    <#assign tabs = tabs + "${desc},${name},${url};">
	 	    <#assign divString = divString + "<div id=\"tabset_${name}\"></div>">
</#list>

<html>
  <head>
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
		//-->
		</script>
  </head>
  <script language="javascript">
					<!--



                        //-->
  </script>
  <body bgcolor="#FFFFFF">
    <#nested>
    <table id="_tabsetpane_tabset" cellspacing="0" cellpadding="0" width="100%" height="600" >
	<tr height="1"><td>
	<div id="_tabdiv_tabset">

	<div id="_tabpane_tabset" style="width:100%; overflow:hidden; ">
	<table extra="tabset" cellspacing="0" cellpadding="0" width="100%" id="tabset" tabPlacement="top" targetFrame="_self"
	   tabs=${tabs}>
	</table>
	</div>

	</div>
	</td></tr>
	<tr><td>
	<div id="_body_tabset" style="width:100%; height:100%; border-left:1 gray solid; border-right:1 gray solid; border-bottom:1 gray solid">
	</div>
	</td></tr>
	${divString}
	</table>
  </body>
</html>

  <script language="javascript">
					<!--
	setActiveTab(tabset,"${currentTabId}");
                        //-->
  </script>


</#macro>




