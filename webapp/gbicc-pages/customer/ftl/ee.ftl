<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="测试查询">
<@CommonQueryMacro.CommonQuery id="CssjQuery" init="true" submitMode="current">
<table>
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="条件" showButton="false" labelwidth="100" colNm=4/>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center" style="margin-bottom:5px">
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</div>
		</td>
	</tr>
	<tr>
		<td>
				<@CommonQueryMacro.DataTable id="myTable" nowrap="true" height="100%" 
					readonly="false" paginationbar="btnRead" 
					fitColumns="false"  
					remoteSort="true" sortable="true"
				fieldStr="ID,NAME,SEX" width="100%" hasFrame="true"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<<script type="text/javascript">
<!--

//-->
</script>
</@CommonQueryMacro.page>