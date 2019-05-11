<#--提交页面测试-->
<#import "/templets/common/common.ftl" as com>
<#import "/templets/commonQuery/CQResultFormSubmit.ftl" as formSubmit>
<#import "/templets/commonQuery/CommonQueryMacro.ftl" as CQMaco>


<#escape x as x?html>
<@com.page title=CommonQueryConfig.getAnyValue("title")>
<@formSubmit.formSubmit title=CommonQueryConfig.getAnyValue("title") name="commonQuery" action="${contextPath}/trans/CommonQueryResult.do" onsubmit="">

<#assign colnum = 0>
<#assign operationsSize = 0>
<#assign divString = "">
<#assign buttonString = "">
<#assign divString = "">
<#assign detail="">

<@ResultTable CommonQueryConfig = CommonQueryConfig Result = CommonQueryResult/>

<DIV height="40%"  align="right">
<@pagediv Result = CommonQueryResult/>
</DIV>

<#-- 页码信息 -->
<input type="hidden" name="currentPage" value="${CommonQueryResult.page.currentPage}"/>
<input type="hidden" name="pageNm" value="${CommonQueryResult.page.totalPage}"/>
<input type="hidden" name="everyPage" value="${CommonQueryResult.page.everyPage}"/>
<input type="hidden" name="nextPage" value=""/>
<input type="hidden" name="rowData" id="rowData" value=""/>
<#assign paramKeys=RequestParam?keys>
<#list paramKeys as paramId>
<#if paramId!="nextPage" && paramId!="everyPage" && paramId!="pageNm" && paramId!="currentPage" && paramId!="rowData">
<input type="hidden" name="${paramId}" value="${((RequestParam[paramId])[0])?default('')}"/>
</#if>
</#list>
<#-- -->
</@formSubmit.formSubmit>
</@com.page>
</#escape>



<#macro ResultTable CommonQueryConfig Result>
<CENTER>
<TABLE ID="datagrid" CELLSPACING="0" CLASS="qryResult">
<CAPTION> </CAPTION>
      <TR ID="colnum">
      	  <#assign fieldMap = CommonQueryConfig.fields>
      	  <#assign fields = fieldMap?keys>
      	  <#assign field = "">
      	  <#assign fDesc = "",fVal = "",fStat = "">
      	  <#assign columnInx = 0>
          <#list fields as fId>
          	<#assign field = fieldMap[fId]>
          	<#assign fDesc = field.getAnyValue("desc")>
         	<#assign fStat = field.getAnyValue("status")?lower_case>
          	<#assign fTip  = field.getAnyValue("tip")?default(fDesc)>
         	<#if fStat!="n"&&fStat!="d">
          		<TH SCOPE="col">
						${fDesc}
				</a>
		   		</TH>
          	<#else>
       	  	</#if>
          </#list>
      </TR>
      <#assign data=Result.data>
      <#assign rownum = 0>
      <#assign thClass="spec">
      <#assign trClass="alt">
      <#assign fieldData = "">
      <#assign rowHiddenData = "">
      <#assign rowOprData = "">
      <#list data as rowData>
       <#assign rowHiddenData = "">
       <#assign rowOprData = "">
       <#if rownum%2=0><#--表的行号为偶数-->
      	  <#assign thClass="spec">
          <#assign trClass="alt1">
       <#else>
       	  <#assign thClass="specalt">
          <#assign trClass="alt">
       </#if>
       <TR ID="row${rowData_index + 1}" CLASS="">
       		<#assign colnum = 0>
            <#list fields as fId>
           		<#assign field = fieldMap[fId]>
            	<#assign fStat = field.getAnyValue("status")?lower_case>
            	<#assign fieldData = rowData.rowMap[fId]>
            	<#assign rowHiddenData = rowHiddenData + fieldData.orig + "|">
            	<#if fStat!="n"&&fStat!="d">
            			<#if colnum==0>
            				<TH SCOPE="row" CLASS="${thClass}">&nbsp;${fieldData.opr}&nbsp;</TH><#--表值-->
      	    			<#else>
      	    				<TD CLASS="${trClass}">&nbsp;${fieldData.opr}&nbsp;</TD><#--表值-->
      	    			</#if>
      	    		<#assign colnum=colnum+1>
      	   		<#else>
       	 		</#if>
       	 		<#if fStat=="a"||fStat=="d">
       	 			<#assign rowOprData = rowOprData + fieldData.opr + "|">
       	 		</#if>
           </#list>
           <INPUT TYPE="HIDDEN" VALUE="${rowOprData}" id="row${rowData_index + 1}_OPR_DATA" name="row${rowData_index + 1}_OPR_DATA">
           <INPUT TYPE="HIDDEN" VALUE="${rowHiddenData}" id="row${rowData_index + 1}_DATA" name="row${rowData_index + 1}_DATA">
       </TR>
       <#assign rownum=rownum+1>
      </#list>

<#assign operationsMap = CommonQueryConfig.operations>
<#assign operationsKeys = operationsMap?keys>

<#list operationsKeys as key>
	<#assign button = 	operationsMap[key]>
	<#if button.isShow(_request)>
		<#assign operationsSize = operationsSize + 1>
 	 	<#assign desc = button.attributes["desc"]?default("")>
  	 	<#assign url = button.attributes["url"]?default("")>
 	    <#assign divString = divString + " <li><a HREF='#' onclick=\"document.all.commonQuery.action = '${contextPath+url}';document.all.commonQuery.submit();\"  TITLE='${desc}'>${desc}</a></li>">
  		<#assign buttonString = buttonString + "<TD><button class=btn3_mouseout  onmouseover=\"this.className='btn3_mouseover'\" onclick=\"javascript:document.commonQuery.action='${contextPath+url}';document.commonQuery.submit();\" onmouseout=\"this.className='btn3_mouseout'\"" + "onmousedown=\"this.className='btn3_mousedown'\""+ "onmouseup=\"this.className='btn3_mouseup'\" title='${desc}'>${desc}</button></TD>">
    </#if>
</#list>

</#macro>

<TR>
</CENTER>
</TABLE>
<#macro pagediv Result>
<#assign page=Result.page>
<TABLE CLASS="qryResult">
<TR><TD>
<TABLE CLASS="pageNmTable">
<TR>
    <TD>
         		<FONT CLASS="pageDiv"> 页码 ${page.currentPage} of ${page.totalPage} </FONT>
    </TD>
</TR>
</TABLE>
</TD>
<TD>
<TABLE CLASS="pageControl">
        <TR>
          <TD>
          <TABLE>
          	<TR>
          	<TD>
          <button id="firstPageBT" class=btn_2k3 title="首页"
          	onmouseover="this.className='btn3_mouseover'"
			onmouseout="this.className='btn_2k3'"
			onmousedown="this.className='btn3_mousedown'"
			onmouseup="this.className='btn3_mouseup'"
			onclick="javascript:return firstPage(commonQuery);">
          	首页
          </button>

          </TD>
          <TD>
          <button id="previousPageBT" class=btn_2k3 title="前一页"
           	onmouseover="this.className='btn3_mouseover'"
			onmouseout="this.className='btn_2k3'"
			onmousedown="this.className='btn3_mousedown'"
			onmouseup="this.className='btn3_mouseup'"
          onclick="javascript:return previousPage(commonQuery);">
          	前一页
          </button>
          </TD>
          <TD>
          <button id="nextPageBT" class=btn_2k3 title="后一页"
            onmouseover="this.className='btn3_mouseover'"
			onmouseout="this.className='btn_2k3'"
			onmousedown="this.className='btn3_mousedown'"
			onmouseup="this.className='btn3_mouseup'"
          onclick="javascript:return nextPageFunction(commonQuery);">
          	后一页
          </button>
          </TD>
          <TD>
            <button id="lastPageBT" class=btn_2k3 title="末页"
            onmouseover="this.className='btn3_mouseover'"
			onmouseout="this.className='btn_2k3'"
			onmousedown="this.className='btn3_mousedown'"
			onmouseup="this.className='btn3_mouseup'"
            onclick="javascript:return lastPage(commonQuery);">
          	末页
          </button>
          </TD>
          </TR>
          </TABLE>
          </TD>
        </TR>
        </CENTER>
</TD></TR></TABLE>
</#macro>

<BR>
<TABLE>
<CENTER>
        <#if operationsSize != 0 >
        <TR>
        	${buttonString}
        </TR>
        </#if>
</CENTER>
</TABLE>

<DIV ID="oContext2" STYLE="DISPLAY:none;" align="left" onmouseover="document.onmousedown=function(event){if(event == null)event = window.event;return false};"
	onmouseout="document.onmousedown=function(){hidenSubmenu();hidenMenu();return false};" />
<#if operationsSize != 0 >
<ul id="nav" align="left">
${divString}
</ul>
</#if>
</DIV>

<DIV ID="submenu" STYLE="DISPLAY:none;" >
<DIV ID="submenu_1">
      <DIV ID="submenu_1_1">
      <STRONG>${CommonQueryConfig.title}--详细信息</STRONG>
      </DIV>
      <DIV ID="submenu_1_2" align="LEFT">
       <#assign fieldMap = CommonQueryConfig.fields>
      	  <#assign fields = fieldMap?keys>
      	  <#assign field = "">
      	  <#assign fDesc = "",fStat = "">
      	  <#assign columnInx = 0>
          <#list fields as fId>
          	<#assign field = fieldMap[fId]>
          	<#assign fDesc = field.getAnyValue("desc")>
         	<#assign fStat = field.getAnyValue("status")?lower_case>
         	<#if fStat=="a"||fStat=="d">
         	<#if columnInx%2 == 0>
          		<UL ID="submenu_1_2_ul1" onmouseover="document.onmousedown = function(){return true;}" onmouseout="document.onmousedown = function(event){hidenSubmenu(event);hidenMenu(event);}">
         			<LI>
        	     		<P>${fDesc?right_pad(10,'－')}$${columnInx}$
         			</LI>
      			</UL>
      		<#else>
      			 <UL ID="submenu_1_2_ul2" onmouseover="document.onmousedown = function(){return true;}" onmouseout="document.onmousedown = function(event){hidenSubmenu(event);hidenMenu(event);}">
          			<LI>
        	    		<P>${fDesc?right_pad(10,'－')}$${columnInx}$
          			</LI>
     			</UL>
      		</#if>
		   	<#assign columnInx = columnInx+1>
          	<#else>
       	  	</#if>
          </#list>
      <DIV>
      <DIV ID="submenu_1_3" colSpan=4></DIV>
      <DIV align="right" style="cursor:hand;">close</DIV>
</DIV>


<script language="javascript" for="window" event="ONLOAD">
<!--
	var size = ${operationsSize};
    init(size);
    var row = document.getElementById("row1");
    if (row != null){
      tableOp_SingleSelect(row);
    }
    buttnCHK();
//-->
<!--
	document.oncontextmenu = function(event){
		if(event == null) event = window.event;//IE
		event.returnValue=false;
		return false;
	}
    document.onmousedown = function(event){
    	hidenSubmenu(event);
    	hidenMenu(event);
    }
//-->
<!--
	function buttnCHK(){
	    var cP = document.getElementById("currentPage");
		var pN = document.getElementById("pageNm");
		var cPage =  new Number(cP.value);
		var pNub = new Number(pN.value);
		if(cPage == 1){
			document.getElementById("firstPageBT").disabled = true;
			document.getElementById("previousPageBT").disabled = true;
		}
		if((cPage-pNub) == 0){
			document.getElementById("nextPageBT").disabled = true;
			document.getElementById("lastPageBT").disabled = true;
		}
	 }

	function formSubmit(action){
		document.all.commonQuery.action = action;
		document.all.commonQuery.submit();
		return true;
	}

//-->
</script>

