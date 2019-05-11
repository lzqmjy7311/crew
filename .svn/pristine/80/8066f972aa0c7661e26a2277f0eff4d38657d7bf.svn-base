<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="成功">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td width="56"><img src="${contextPath}/images/info_f1.gif" width="56" height="44"></td>
    <td width="921" background="${contextPath}/images/info_f3.gif"><img src="${contextPath}/images/info_f2.gif" width="165" height="44"></td>
    <td width="26"><img src="${contextPath}/images/info_f4.gif" width="26" height="44"></td>
  </tr>
  <#assign workflowTlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getWorkflowTlrno()?default('')>
  <#assign setNull = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().setWorkflowTlrno(null)>
  <#if (workflowTlrno == 'XXXXXXXX')>
   <tr>
    <td height="71" valign="top" background="${contextPath}/images/info_f6.gif"><img src="${contextPath}/images/info_f5.gif" width="56" height="30"></td>
    <td align="center" class="errors"><font face="arial" color="red"> 您的操作无法进行下去，确认是否有设置相应权限的配置！${workflowTlrno} 无人能操作</font>
    </td>
    <td width="26" background="${contextPath}/images/info_f11.gif">&nbsp;</td>
  </tr>
  </#if>
  <#if (workflowTlrno == '')>
  <tr>
    <td height="71" valign="top" background="${contextPath}/images/info_f6.gif"><img src="${contextPath}/images/info_f5.gif" width="56" height="30"></td>
    <td align="center" class="errors"><font color="red">您的操作已成功！ </font></td>
    <td width="26" background="${contextPath}/images/info_f11.gif">&nbsp;</td>
  </tr>
  </#if>
  <#if (workflowTlrno != 'XXXXXXXX') && (workflowTlrno != '')>
  <tr>
    <td height="71" valign="top" background="${contextPath}/images/info_f6.gif"><img src="${contextPath}/images/info_f5.gif" width="56" height="30"></td>
    <td align="center" class="errors">您的操作已成功！下一任务已经分配给【${workflowTlrno}】操作员</td>
    <td width="26" background="${contextPath}/images/info_f11.gif">&nbsp;</td>
  </tr>
  </#if>
  <tr>
    <td><img src="${contextPath}/images/info_f7.gif" width="56" height="36"></td>
    <td background="${contextPath}/images/info_f9.gif"><img src="${contextPath}/images/info_f8.gif" width="77" height="36"></td>
    <td width="26"><img src="${contextPath}/images/info_f10.gif" width="25" height="35"></td>
  </tr>
</table>

</td>
</tr>

</table>

</@CommonQueryMacro.page>