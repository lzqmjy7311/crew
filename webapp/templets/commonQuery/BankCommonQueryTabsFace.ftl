<#--Ìá½»Ò³Ãæ²âÊÔ-->
<#import "/templets/common/common.ftl" as com>
<#import "/templets/commonQuery/CommonQueryMacro.ftl" as CQMaco>
<#import "/templets/commonQuery/CQElement.ftl" as htmlelement>

<@com.newpage title="${CommonQueryConfig.getAnyValue('title')}">
<#assign tabs ="" >
<#assign divString = "">
<#assign operationsMap = CommonQueryConfig.getOperations()>
<#assign operationsKeys = operationsMap?keys>
<#list operationsKeys as key>
			<#assign button = operationsMap[key]>
	 	 	<#assign desc = button.attributes["desc"]?default("")>
	 	 	<#assign id = button.attributes["id"]?default("")>
	  	 	<#assign url  = contextPath + button.attributes["url"]?default("")>
	 	    <#assign tabs = tabs + desc + "," + id + "," + url + ";">
 	    	<#assign divString = divString + "<div id=\"tabset_${id}\"></div>">
</#list>

    <table id="_tabsetpane_tabset" cellspacing="0" cellpadding="0" width="100%" height="600" >
	<tr height="1">
		<td><hr /></td>
	</tr>
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
	</table>
	${divString}
<#assign tabid = _request.getParameter("tabid")?default('')>
</@com.newpage>
${CommonQueryConfig.script?default('')}
<script language="javascript">
<!--
	setActiveTab(tabset,"${tabid}");
//-->
</script>