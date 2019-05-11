<#--提交页面测试-->
<#import "/templets/common/common.ftl" as com>
<#import "/templets/commonQuery/CommonQueryMacro.ftl" as CQMaco>
<#import "/templets/commonQuery/CQElement.ftl" as htmlelement>

<#escape x as x?html>
<@com.newpage title="${CommonQueryConfig.getAnyValue('title')}">
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-client.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-parser.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/CommonQueryResultProcess.js'> </script>


<script language="javascript">
<#assign elementList = CommonQueryConfig.elementList>
<#assign dataSetString="">
<#assign requestString="">
<#list elementList as element>
	<#assign requestString=RequestParam[element.getAnyValue("id")][0]>
	<#if requestString?length == 0>
		<#assign requestString = element.getViewValue(_request)>
	</#if>
<#if element_index != 0>
	<#assign dataSetString=dataSetString+","+ requestString>
<#else>
	<#assign dataSetString=requestString>
</#if>
</#list>
<#assign dataSetString=dataSetString + "," + CommonQueryConfig.id + ",1,10">
<!--
var ${CommonQueryConfig.getId()}_dataset=createDataset("${CommonQueryConfig.getId()}_dataset","","${dataSetString}");
var _t=${CommonQueryConfig.getId()}_dataset;
_t.readOnly=false;
_t.pageSize=100;
_t.pageIndex=1;
_t.pageCount=1;
_t.masterDataset="";
_t.references="";
_t.submitData="allchange";
_t.autoLoadPage=false;
_t.autoLoadDetail=true;
_t.downloadUrl=getDecodeStr("~2fextraservice~2fdownloaddata");
_t.sessionKey="dd99bd6a430e8e8ef5be7ce116138e44587fff";
_t.insertOnEmpty=false;
_t.tag="";
//-->
</script>
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
									<input type="hidden" extra="editor" id="CQId" name="CQId"
									 dataset="${CommonQueryConfig.getId()}_dataset" dataField="CQId" initValue="${CommonQueryConfig.id}">
									<input type="hidden" extra="editor" id="nextPage" name="nextPage"
									dataset="${CommonQueryConfig.getId()}_dataset" dataField="nextPage" initValue="1">
									<input type="hidden" extra="editor" id="everyPage" name="everyPage"
									dataset="${CommonQueryConfig.getId()}_dataset" dataField="everyPage" initValue="10">
									<@htmlelement.hiddenelement id="CQId" value=CommonQueryConfig.id></@htmlelement.hiddenelement>
									<@htmlelement.hiddenelement id="nextPage" value="1"></@htmlelement.hiddenelement>
									<@htmlelement.hiddenelement id="everyPage" value="10"></@htmlelement.hiddenelement>
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
					defaultOperation="asyncSubmit" submitManager="sm1">查询</button>
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
					defaultOperation="submitform" submitManager="sm1">查询</button>
					<script language="javascript">
					<!--
						var sm1=_createSubmitManager("sm1");
						var _t=sm1;
						_t.updaterClass="";
						_t.submitMode="default";
						_t.forwardPath="";
                        _t.targetFrame="";
                        _t.submitUrl="${CommonQueryConfig.getResultViewURL()}";
                        _submitManager_addDataset(_t, "${CommonQueryConfig.getId()}_dataset");
                        _array_submitmanager[_array_submitmanager.length]=_t;
                        //-->
                    </script>
				</#if>

				</td>
			</tr>

		</table>
		</td>
	</tr>
</table>
</@com.newpage>
</#escape>
${CommonQueryConfig.script?default('')}
<script language="javascript">
	wrnAlert("没有符合查询条件的记录");
</script>