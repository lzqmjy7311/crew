<#--信息提交-->
<#import "/templets/commonQuery/CQElement.ftl" as htmlelement>
<#import "/templets/commonQuery/CommonQueryMacro.ftl" as CQMaco>

<#--CSS:${contextPath}/page/resources/style/formSubmitI.css-->
<#macro formSubmit title name action onsubmit>
<FORM method="POST" action='${action}' name='${name}' onsubmit='${onsubmit?default()}'>
<TABLE WIDTH="99%" BORDER="0" CELLSPACING="1" CELLPADDING="3">
	<TR>
		<TD>
			<TABLE WIDTH="78%" BORDER="1" CELLSPACING="2" CELLPADDING="5" ALIGN="CENTER" BORDERCOLOR="#DFDFDF">
				<TR>
					<TD BGCOLOR="#88B8EF" CLASS="unnamed1" ALIGN="center">
						<DIV ALIGN="LEFT"><B><FONT SIZE="2" COLOR="#FFFFFF">
						<IMG SRC="${contextPath}/page/resources/image/common/b_kuk.gif" WIDTH="6" HEIGHT="10">${title}</FONT></B></DIV>
					</TD>
				</TR>
			</TABLE>
			<TABLE WIDTH="333" BORDER="0" CELLSPACING="0" CELLPADDING="0" ALIGN="center">
				<TR>
					<TD>&nbsp;</TD>
				</TR>
				<TR>
					<TD>&nbsp;</TD>
				</TR>
				<TR>
					<TD><IMG SRC="${contextPath}/page/resources/image/common/tiao-down-blue.jpg" WIDTH="435" HEIGHT="23"></TD>
				</TR>
				<TR>
					<TD VALIGN="TOP" BGCOLOR="#EDF1F9">
					   <TABLE WIDTH="82%" BORDER="0" CELLSPACING="0" CELLPADDING="0" ALIGN="CENTER">
                           <#nested>
					   </TABLE>
					</TD>
				</TR>
				<TR>
					<TD><IMG SRC="${contextPath}/page/resources/image/common/tiao-up-blue.jpg" WIDTH="435" HEIGHT="23"></TD>
				</TR>
			</TABLE>
		</TD>
	</TR>
	<TR>
		<TD>&nbsp;</TD>
	</TR>
	<TR>
		<TD>
			<TABLE BORDER="0" width="82%" CELLSPACING="2" CELLPADDING="2" ALIGN="CENTER">
			<SCRIPT LANGUAGE="JAVASCRIPT">
				function confrimForm(){
					if(typeof(${onsubmit}) == "function"){
						if(${onsubmit}()){
							confrim(document.all.${name});
						}
					}else{
						confrim(document.all.${name});
					}

				}
			</SCRIPT>
				<TR>
					<TD align="center">
         	           <@htmlelement.commonbutton  id="__queryButton" onclick="JavaScript:confrimForm();" value="查询"/>
                    </TD>
                    <TD align="center">
					   <@htmlelement.commonbutton  id="__resetButton" onclick="JavaScript:document.all.${name}.reset();" value="重载"/>
					</TD>
				</TR>
			</TABLE>
		</TD>
	</TR>
	<TR>
		<TD>&nbsp;</TD>
	</TR>
</TABLE>
</FORM>
</#macro>


<#macro newformSubmit name action onsubmit>

<script language="javascript">
<#assign elementList = CommonQueryConfig.elementList>
<#assign dataSetString="">
<#list elementList as element>
<#if element_index != 0>
	<#assign dataSetString=dataSetString+","+element.getViewValue(_request)>
<#else>
	<#assign dataSetString=element.getViewValue(_request)>
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
				action="${contextPath}/${action}" method="POST" height="" width="" tag="" class="autoform">
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

<#nested>
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
                        _t.submitUrl=getDecodeStr("${action}");
                        _submitManager_addDataset(_t, "${CommonQueryConfig.getId()}_dataset");
                        _array_submitmanager[_array_submitmanager.length]=_t;
                        //-->
                    </script>
				</td>
			</tr>

		</table>
		</td>
	</tr>
</table>
</#macro>


