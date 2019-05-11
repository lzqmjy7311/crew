<#--Ìá½»Ò³Ãæ²âÊÔ-->
<#import "/templets/common/common.ftl" as com>
<#import "/templets/commonQuery/CQResultFormSubmit.ftl" as formSubmit>
<#import "/templets/commonQuery/CommonQueryMacro.ftl" as CQMaco>
<#import "/templets/commonQuery/CommonQueryMacroNew.ftl" as CommonQuery>


<@com.newpage title=CommonQueryConfig.getAnyValue("title")>
<script type='text/javascript' src='${contextPath}/dwr/interface/CommonQueryResultProcess.js'> </script>
<script language="javascript">
<!--
var ${CommonQueryConfig.getId()}_dsResult=createDataset("${CommonQueryConfig.getId()}_dataset","","${CommonQueryResult.getResultOprStr()};");
${CommonQueryConfig.getId()}_dsResult.flushData=dataset_flushData_new;
var _t=${CommonQueryConfig.getId()}_dsResult,_f;
_t.readOnly=false;
_t.pageSize=${CommonQueryResult.page.everyPage};
_t.pageIndex=${CommonQueryResult.page.currentPage};
_t.pageCount=${CommonQueryResult.page.totalPage};
_t.masterDataset="";
_t.references="";
_t.submitData="allchange";
_t.autoLoadPage=false;
_t.autoLoadDetail=true;
_t.downloadUrl=getDecodeStr("~2fextraservice~2fdownloaddata");
_t.sessionKey="${_request.getSession().getId()}";
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
       										<#if fId_index%2 == 0>
       											<@CQMaco.isShowField field "<tr>" />
       											<@CQMaco.showField field/>
       										<#else>
       											<@CQMaco.showField field/>
												<@CQMaco.isShowField field "</tr>" />
       										</#if>
       									<#else>
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
									<#--
									<@htmlelement.hiddenelement id="CQId" value=CommonQueryConfig.id></@htmlelement.hiddenelement>
									<@htmlelement.hiddenelement id="nextPage" value="1"></@htmlelement.hiddenelement>
									<@htmlelement.hiddenelement id="everyPage" value=CommonQueryConfig.getAnyValue("pagesize")?default('10')></@htmlelement.hiddenelement>
									-->

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
         			<@CommonQuery.Button id="btSave"/>
				</td>
			</tr>

		</table>
		</td>
	</tr>
</table>
<script language="javascript">
	<!--
		initDataset(_t);
	//-->
</script>
</@com.newpage>
