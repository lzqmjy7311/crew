<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="基本信息">
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="tmodifiedroleid" init="true" submitMode="current">
					<@CommonQueryMacro.Interface id="interface1"  fieldStr="fdOpername,fdUsername,fdOrgname,fdstartdate,fdenddate"/>
					<@CommonQueryMacro.GroupBox id="operaterinfo" label="用户操作信息查询">
						<@CommonQueryMacro.DataTable id="group12" />
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>		
	</table>
<script>

	//页面初始化-发送post请求之前
	function initCallGetter_post(){
		var customerNum = "${RequestParameters["customerNum"]?default('')}";
	}  

</script>
</@CommonQueryMacro.page>