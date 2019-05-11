<#--------------- 文本输入框 ----------------->
<#macro textinput textinputlabel inputid name value size rules errMsg>

<td valign=center align="right" style="width: 80px" nowrap>
<label extra="fieldlabel" id="${inputid}"
	dataset="dsCustomerInfo" dataField="${textinputlabel}">
</label>
</td>
<td valign=center align="left">
<input type="text"
	extra="editor" id="${inputid}"
	name="${name}" dataset="${CommonQueryConfig.getId()}_dataset" dataField="${inputid}" value="${value}"
	style=""></td>
<script language="javascript">
<!--
var _f=_t.addField("${inputid}","string");
_f.label=getDecodeStr("^5ba2^6237^53f7");
_f.size=10;
_f.scale=0;
_f.readOnly=false;
_f.required=false;
_f.nullable=true;
_f.defaultValue=getDecodeStr("");
_f.updatable=true;
_f.valueProtected=false;
_f.visible=true;
_f.autoGenId=false;
_f.tableName="";
_f.fieldName="${inputid}";
_f.tag="";
_f.editorType="";
_f.dropDown="";
_f.mask=getDecodeStr("");
_f.maskErrorMessage=getDecodeStr("");
_f.toolTip=getDecodeStr("");
_f.lobDownloadURL=getDecodeStr("");
_f.lobPopupURL=getDecodeStr("");
//-->
</script>
<#if rules?length!=0>
		<SCRIPT LANGUAGE='JavaScript'>
				fieldRules['${name}'] = new Array(${rules});
				errMsgs['${name}']    = '${errMsg}';
		</SCRIPT>
</#if>

</#macro>





<#---------------- 日历输入框 -------------------->
<#macro calendar calendarlabel name value rules errMsg>
<script language="javascript" src="${contextPath}/page/resources/script/calendar.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/calendar-setup.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/calendar-zh.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/calendar-win2k-cold-1.css"/>
<SCRIPT LANGUAGE="JAVASCRIPT">
function calendarChange(inputEleNm,hidEleNm){
	 	var inputEle = document.getElementById(inputEleNm);
	 	var hidEle = document.getElementById(hidEleNm);
		var cls = inputEle.value.split("-");
		hidEle.value = cls[0]+cls[1]+cls[2];
}
</SCRIPT>
<TR>
	<TD WIDTH="10%" CLASS="unnamed2">
		<DIV ALIGN="center"><IMG SRC="${contextPath}/page/resources/image/common/sub_bulet04.gif"
		    WIDTH="7" HEIGHT="9"></DIV></TD>
	<TD WIDTH="20%" CLASS="unnamed2">${calendarlabel}</TD>
	<TD WIDTH="70%" CLASS="unnamed1">
	<table WIDTH="100%" BORDER="0" CELLSPACING="0" CELLPADDING="0">
	  <tr><td width="25%">
	  <input type="hidden" id="${name}" name="${name}" value="${value}"/>

	  <input readonly type="text" id="${name}_calendar" onpropertyChange="calendarChange('${name}_calendar','${name}')" CLASS="unnamed0" size=10 name="${name}_calendar"></td>
          <SCRIPT LANGUAGE='JavaScript'>
	  		var viewVal = "${value}";
	  		if(viewVal.length == 8){
	  			viewVal = viewVal.substring(0,4) + '-' + viewVal.substring(4,6) + '-' + viewVal.substring(6,8);
	  			var e = document.getElementById("${name}_calendar");
	  			e.value = viewVal;
	  		}
	     </SCRIPT>
          <td>
          <a onClick="return showCalendar('${name}_calendar','y-mm-dd');">
  	 		  <img id=dimg2 height=21 src="${contextPath}/page/resources/image/calendar/calendar.gif" width=34 align=absMiddle border=0></img></a></td></tr>
   		<#if rules?length!=0>
		<SCRIPT LANGUAGE='JavaScript'>
				fieldRules['${name}'] = new Array(${rules});
				errMsgs['${name}']    = '${errMsg}';
		</SCRIPT>
   		</#if>
    </table></TD></TR>
<TR>
	<TD COLSPAN="3" CLASS="unnamed3">
	    <IMG SRC="${contextPath}/page/resources/image/common/line-blue.gif" WIDTH="100%" HEIGHT="5"></TD></TR>
</#macro>

<#---------------- 日历输入框_只能输入今天之前日期（包含今天） -------------------->
<#macro calendarOnlyBefore calendarlabel name value rules errMsg>
<script language="javascript" src="${contextPath}/page/resources/script/calendar.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/calendar-setup.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/calendar-zh.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/calendar-win2k-cold-1.css"/>
<SCRIPT LANGUAGE="JAVASCRIPT">
function calendarChange(inputEleNm,hidEleNm){
	 	var inputEle = document.getElementById(inputEleNm);
	 	var hidEle = document.getElementById(hidEleNm);
		var cls = inputEle.value.split("-");
		hidEle.value = cls[0]+cls[1]+cls[2];
}
</SCRIPT>
<TR>
<TD WIDTH="10%" CLASS="unnamed2">
<DIV ALIGN="center"><IMG SRC="${contextPath}/page/resources/image/common/sub_bulet04.gif"
WIDTH="7" HEIGHT="9"></DIV></TD>
<TD WIDTH="25%" CLASS="unnamed2">${calendarlabel}</TD>
<TD WIDTH="65%" CLASS="unnamed1">
<table WIDTH="100%" BORDER="0" CELLSPACING="0" CELLPADDING="0">
<tr><td width="25%">
<input type="hidden" id="${name}" name="${name}"/>
<input type="text" id="${name}_calendar" onpropertyChange="calendarChange('${name}_calendar','${name}')" CLASS="unnamed0" size=10 name="${name}_calendar"></td>
<td>
<a onClick="return showCalendarOnlyBefore('${name}_calendar');">
<img id=dimg2 height=21 src="${contextPath}/page/resources/image/calendar/calendar.gif" width=34 align=absMiddle border=0></img></a>
</td>
<td><font size="1" color="#999999">(y-mm-dd)</font></td>
</tr>
</table>
</TD>
</TR>
<TR>
<TD COLSPAN="3" CLASS="unnamed3">
<IMG SRC="${contextPath}/page/resources/image/common/line-blue.gif" WIDTH="400" HEIGHT="5"></TD></TR>
<script language='JavaScript'>
	fieldRules['${name}_calendar'] = new Array(isValidDateFormat);
	errMsgs['${name}_calendar']    = '请输入正确的${calendarlabel}！';
</script>
</#macro>

<#--------------- 密码输入框 ------------------>
<#macro password id passwordlabel name inputid value>
<TR>
	<TD WIDTH="10%" CLASS="unnamed2">
		<DIV ALIGN="center"><IMG SRC="${contextPath}/page/resources/image/common/sub_bulet04.gif"
		     WIDTH="7" HEIGHT="9"></DIV>
	</TD>
	<TD WIDTH="20%" CLASS="unnamed2">${passwordlabel}</TD>
	<TD WIDTH="70%" CLASS="unnamed1"><INPUT TYPE="password"
		NAME="${name}" CLASS="unnamed1" value="${value}"></TD>
</TR>
<TR id="${id}"><#-- 分隔线 -->
	<TD COLSPAN="3" CLASS="unnamed3">
	    <IMG SRC="${contextPath}/page/resources/image/common/line-blue.gif" WIDTH="100%" HEIGHT="5"></TD>
</TR>
</#macro>

<#---------------- 下拉菜单 ------------------->
<#macro select label selectName elements defaultValue size onchange>
<TR>
	<TD WIDTH="10%" CLASS="unnamed2">
		<DIV ALIGN="center"><IMG SRC="${contextPath}/page/resources/image/common/sub_bulet04.gif" WIDTH="7"
			HEIGHT="9"></DIV>
	</TD>
	<TD CLASS="unnamed2" WIDTH="20%">${label}</TD>
	<TD WIDTH="70%">
	<#assign optionMap = elements>
	<#assign optionKeys = elements?keys>
	<SELECT NAME="${selectName}" ID="${selectName}" CLASS="" onchange="${onchange}" width="${size}" style="width:${size?default()};align:center" >
	<#list optionKeys as optionKey>
		<OPTION VALUE = "${optionKey}">${elements[optionKey]}</OPTION>
	</#list>
	</SELECT>
		<script language="JavaScript" type="text/javascript">
 	 	<!--
 	 		if('${defaultValue}' != ''){
 	 			document.all.${selectName}.value = '${defaultValue}';
 	 		}
   		//-->
		</script>
	</TD>
</TR>
<TR><#-- 分隔线 -->
	<TD COLSPAN="3" CLASS="unnamed3">
	    <IMG SRC="${contextPath}/page/resources/image/common/line-blue.gif" WIDTH="100%" HEIGHT="5"></TD>
</TR>
</#macro>

<#--
<#macro commonbutton  href onclick imgsrc>
<TD align="center"><A HREF="${href}" onclick="${onclick}">
	<IMG NAME="button" BORDER="0" SRC="${imgsrc}" WIDTH="51" HEIGHT="24"></A></TD>
</#macro>
-->

<#---------------- 通用按钮 -------------------->
<#macro commonbutton id value onclick>
<input id="${id}" style="BACKGROUND: url(${contextPath}/page/resources/image/common/button.gif;); WIDTH: 51;
       CURSOR: pointer; BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none;
       HEIGHT: 24; BORDER-BOTTOM-STYLE: none" type=button onclick="${onclick}" value="${value}" >
</#macro>


<#--------------- Checkbox ----------------->
<#macro checkbox label id name checked>
<TR>
	<TD WIDTH="10%" CLASS="unnamed2">
		<DIV ALIGN="center"><IMG SRC="${contextPath}/page/resources/image/common/sub_bulet04.gif"
		    WIDTH="7" HEIGHT="9"></DIV>
	</TD>
	<TD WIDTH="20%" CLASS="unnamed2">${label}</TD>
	<TD WIDTH="70%" CLASS="unnamed1">
	<#if checked == "true">
	<INPUT TYPE="checkbox" ID="${id}"  NAME="${name}" CLASS="unnamed1" checked="${checked}">
	<#else>
	<INPUT TYPE="checkbox" ID="${id}"  NAME="${name}" CLASS="unnamed1">
	</#if>
	</TD>
</TR>
<TR><#-- 分隔线 -->
	<TD COLSPAN="3" CLASS="unnamed3">
	    <IMG SRC="${contextPath}/page/resources/image/common/line-blue.gif" WIDTH="100%" HEIGHT="5"></TD>
</TR>
</#macro>


<#macro tabspage tabsFlag tabsId currentTabId>
<#if tabsFlag == "true">
<#assign config = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean("${tabsId}")>
<#assign tabs ="" >
<#assign divString = "">
<#assign currentTabId = "${currentTabId}">
<#assign operationsMap = config.getOperations()>
<#assign operationsKeys = operationsMap.keySet()>
<#list operationsKeys as key>
			<#assign button = config.getOperationsElement(key?string)>
	 	 	<#assign desc = button.attributes("desc")?default("")>
	 	 	<#assign id = button.attributes["id"]?default("")>
	  	 	<#assign url  = contextPath + button.attributes["url"]?default("")>
	 	    <#assign tabs = tabs + desc + "," + id + "," + url + ";">
	 	    <#if id != currentTabId>
	 	    	<#assign divString = divString + "<div id=\"tabset_${id}\"></div>">
	 	    </#if>
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

	<div id="tabset_${currentTabId}">
		<#nested>
	</div>
	${divString}
</#if>
</#macro>