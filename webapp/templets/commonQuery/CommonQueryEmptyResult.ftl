<#--提交页面测试-->
<#import "/templets/common/common.ftl" as com>
<#import "/templets/commonQuery/CQInterfaceFormSubmit.ftl" as formSubmit>
<#import "/templets/commonQuery/CommonQueryMacroI.ftl" as CQMaco>




<@com.page title="${CommonQueryConfig.title}">
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-client.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-parser.js"></script>
<#escape x as x?html>
<@formSubmit.formSubmit title="${CommonQueryConfig.title}" name="form1" action="${contextPath}/trans/CommonQueryResult.do" onsubmit="checkSubmit">
<#assign elementList = CommonQueryConfig.elementList>
<#list elementList as element>
	<@CQMaco.showElement element=element requestParam=RequestParam/>
</#list>
<#-- 页码信息 -->
<input type="hidden" name="CQId" value="${CommonQueryConfig.id}"/>
<input type="hidden" name="nextPage" value="1"/>
<input type="hidden" name="everyPage" value="10"/>
<#-- -->
</@formSubmit.formSubmit>
<TABLE WIDTH="50%" BORDER="1" CELLSPACING="2" CELLPADDING="5" ALIGN="CENTER" >
				<TR>
					<TD CLASS="unnamed1" ALIGN="center">
						<DIV ALIGN="CENTER"><B><FONT SIZE="2" COLOR="#88B8EF">
						<FONT>
							没有符合条件的记录
						</FONT>
						</B>
						</DIV>
					</TD>
				</TR>
</TABLE>
</#escape>
${CommonQueryConfig.script?default('')}
</@com.page>
