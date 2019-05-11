<#--信息提交-->
<#import "/templets/commonQuery/CQElement.ftl" as htmlelement>

<#--CSS:${contextPath}/page/resources/style/formSubmitI.css-->
<#macro formSubmit title name action onsubmit>
<link rel="stylesheet" type="text/css" href="${contextPath}/page/resources/style/commonQuery.css">
<script language="javascript" src="${contextPath}/page/resources/script/qrypages.js"></script>
<FORM method="POST" action='${action}' name='${name}' id='${name}' onsubmit='${onsubmit?default()}'>
<TABLE WIDTH="99%" BORDER="0" CELLSPACING="1" CELLPADDING="1" >
<TR>
		<TD>
		<CENTER>
			<TABLE CLASS="report">
				<TR>
					<TD BGCOLOR="#88B8EF" CLASS="unnamed1" ALIGN="center">
						<DIV ALIGN="LEFT"><B><FONT SIZE="2" COLOR="#FFFFFF">
						<IMG SRC="${contextPath}/page/resources/image/common/b_kuk.gif" WIDTH="6" HEIGHT="10">${title}</FONT></B></DIV>
					</TD>
				</TR>
			</TABLE>
		</CENTER>
			 <#nested>
		</TD>
	</TR>
	<#--
	<TR>
		<TD>&nbsp;</TD>
	</TR>
	<TR>
		<TD>&nbsp;</TD>
	</TR>
	-->
</TABLE>
</FORM>
</#macro>