<#--提交页面测试-->
<#import "/templets/common/common.ftl" as com>
<#import "/templets/commonQuery/CommonQueryMacro.ftl" as CQMaco>
<#import "/templets/commonQuery/CQElement.ftl" as htmlelement>
<#import "/templets/commonQuery/CQEditType.ftl" as htmledit>

<@com.newpage title="${CommonQueryConfig.getAnyValue('title')}">
${CommonQueryConfig.script?default('')}
<#escape x as x?html>
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-client.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-parser.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/CommonQueryResultProcess.js'> </script>

<script language="javascript">
<#-->
<#assign elementList = CommonQueryConfig.elementList>
<#assign dataSetString="">
<#list elementList as element>
<#if element_index != 0>
	<#assign dataSetString=dataSetString+","+element.getAnyValue("default")?default("")>
<#else>
	<#assign dataSetString=element.getAnyValue("default")?default("")>
</#if>
</#list>
-->
<#assign paramString = paramConver()>
<!--
var _common_query_id = "${CommonQueryConfig.getId()}";
var ${CommonQueryConfig.getId()}_dataset=createDataset("${CommonQueryConfig.getId()}_dataset","",";");
var _t=${CommonQueryConfig.getId()}_dataset;
_t.readOnly=false;
_t.pageSize=100;
_t.pageIndex=1;
_t.pageCount=1;
_t.masterDataset="";
_t.references="";
_t.submitData="allchange";
_t.type="interface";
_t.autoLoadPage=false;
_t.autoLoadDetail=true;
_t.downloadUrl=getDecodeStr("~2fextraservice~2fdownloaddata");
_t.sessionKey="dd99bd6a430e8e8ef5be7ce116138e44587fff";
_t.insertOnEmpty=false;
converStr2DataSetParameter("${paramString}",_t);
_t.tag="";
//-->
</script>
<#--
<@htmlelement.tabspage tabsFlag=CommonQueryConfig.getAnyValue("tabs")?default('false') tabsId=CommonQueryConfig.getAnyValue("tabsid") currentTabId=CommonQueryConfig.getAnyValue("tabid")>
-->
<table align="left" width="100%">
	<tr>
		<td>${CommonQueryConfig.getAnyValue("navigate")?default()}</td>
	</tr>
	<tr>
		<td>
		<hr />
		</td>
	</tr>

	<tr>
		<td>
		<table align="left">

			<tr>
				<td>
				<table id="autoformCustomerInfo" dataset="${CommonQueryConfig.getId()}_dataset"
				action="${contextPath}${CommonQueryConfig.getResultViewURL()}" method="POST" height="" width="" tag="" class="autoform">
					<tr>
						<td>
						<table width="100%" height="100%">
							<tr>
								<td>
								<FIELDSET name='fileddset_group1' style="padding: 6px;"><LEGEND>&nbsp;${CommonQueryConfig.getAnyValue("title")}&nbsp;</LEGEND>
								<table width="100%" height="100%">
									<#assign elementList = CommonQueryConfig.elementList>
									<#list elementList as element>
										<#if element_index%2 == 0>
											<@CQMaco.isShow element "<tr>" />
											<@CQMaco.showElement element/>
										<#else>
										    <@CQMaco.showElement element/>
											<@CQMaco.isShow element "</tr>" />
										</#if>
									</#list>
									<#--
									<input type="hidden" extra="editor" id="CQId" name="CQId"
									 dataset="${CommonQueryConfig.getId()}_dataset" dataField="CQId" initValue="${CommonQueryConfig.id}">
									<input type="hidden" extra="editor" id="nextPage" name="nextPage"
									dataset="${CommonQueryConfig.getId()}_dataset" dataField="nextPage" initValue="1">
									<input type="hidden" extra="editor" id="everyPage" name="everyPage"
									dataset="${CommonQueryConfig.getId()}_dataset" dataField="everyPage" initValue="${CommonQueryConfig.getAnyValue("pagesize")?default('10')}">
									-->
									<@htmledit.hiddenelement id="CQId" value=CommonQueryConfig.id targetDataset="${CommonQueryConfig.getId()}_dataset"></@htmledit.hiddenelement>
									<@htmledit.hiddenelement id="nextPage" value="1" targetDataset="${CommonQueryConfig.getId()}_dataset"></@htmledit.hiddenelement>
									<@htmledit.hiddenelement id="everyPage" value=CommonQueryConfig.getAnyValue("pagesize")?default('10') targetDataset="${CommonQueryConfig.getId()}_dataset"></@htmledit.hiddenelement>
									<script language="javascript">
									<!--
										initDataset(_t);
									//-->
									</script>
								</table>
								</FIELDSET>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>

			<tr>
				<td align="center">
				<#if CommonQueryConfig.getAnyValue("async")?default('') == "true">
					<button extra="button" type="button" id="btnSubmit" autoForm="autoformCustomerInfo"
					defaultOperation="asyncqrysubmit" submitManager="sm1">查询</button>
					<script language="javascript">
					<!--
						var element = document.getElementById("btnSubmit");
						element.onclick=_button_onclick_new;
						element.dataset = "${CommonQueryConfig.getId()}_dataset";
						element.url = "${CommonQueryConfig.getResultViewURL()}";
                     //-->
                    </script>
				<#else>
				<button extra="button" type="button" id="btnSubmit" autoForm="autoformCustomerInfo"
					defaultOperation="asyncqrysubmit" submitManager="sm1">查询</button>
					<script language="javascript">
					<!--
						var element = document.getElementById("btnSubmit");
						element.onclick=_button_onclick_new;
						element.dataset = "${CommonQueryConfig.getId()}_dataset";
						element.url = "${CommonQueryConfig.getResultViewURL()}";
                     //-->
                    </script>
				</#if>

				</td>
			</tr>

		</table>
		</td>
	</tr>
</table>
<#--
</@htmlelement.tabspage>
-->
<#--
set default values
-->
<script language="javascript">
var ${CommonQueryConfig.getId()}_dataset_t =getDatasetByID("${CommonQueryConfig.getId()}_dataset");
var  ${CommonQueryConfig.getId()}_paramValues = _paramMap.keys();
	for(var i=0;i<${CommonQueryConfig.getId()}_paramValues.length;i++){
	${CommonQueryConfig.getId()}_dataset_t.setValue(${CommonQueryConfig.getId()}_paramValues[i],_paramMap.get(${CommonQueryConfig.getId()}_paramValues[i]));
}
</script>

</#escape>
</@com.newpage>


<#function reqParamConver>
<#assign paramString = "">
<#assign paramIds = _request.getParameterMap()?keys>
<#list paramIds as paramId>
	<#if paramString!="">
		<#assign paramString = paramString + ";" + paramId + "," + _request.getParameter(paramId)>
	<#else>
		<#assign paramString = paramId + "," + _request.getParameter(paramId)>
	</#if>
</#list>
<#return paramString>
</#function>

<#function configParamConver>
<#assign paramString = "">
<#assign paramIds = CommonQueryConfig.getParameters()?keys>
<#list paramIds as paramId>
	<#if paramString!="">
		<#assign paramString = paramString + ";" + paramId + "," + CommonQueryConfig.getParameter(paramId).getAnyValue("value")>
	<#else>
		<#assign paramString = paramId + "," + CommonQueryConfig.getParameter(paramId).getAnyValue("value")>
	</#if>
</#list>
<#return paramString>
</#function>

<#function paramConver>
<#assign cParamString = configParamConver()>
<#assign rParamString = reqParamConver()>
<#assign paramString = "">
<#if rParamString != "">
	<#assign paramString = cParamString + ";" + rParamString>
<#else>
	<#assign paramString = cParamString>
</#if>
<#return paramString>
</#function>


<#--
<#if CommonQueryConfig.getAnyValue("tabs")?default('false') == "true">
<script language="javascript">
	setActiveTab(tabset,"${CommonQueryConfig.getAnyValue("tabid")?default('')}");
</script>
</#if>
-->