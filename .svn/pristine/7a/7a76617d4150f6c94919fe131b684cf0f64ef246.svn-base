<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="单规则预警处置-归入案例">
<table>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="SingleRulCasesSelect" init="true" submitMode="current">
				<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4/>
				<@CommonQueryMacro.DataTable id ="SingleRulCasesSelectTable" paginationbar=""
				fieldStr="casesCode[150],casesName[150],createOrg[150],casesDesc[200],casesStatus[100],createDt[100]" readonly="true" width="100%"/></br>
				<center>
					<@CommonQueryMacro.Button id="btnSubmit" />
					<@CommonQueryMacro.Button id="btCancel" />
				</center>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script>
	//提交
	function btnSubmit_onClickCheck(){
		var id=SingleRulCasesSelect_dataset.getValue("id");
		if(!id){
			top.easyMsg.info("请选择要归入的案例！");
			return false;
		}
		var warningId='${warningId}';
		SingleRulCasesSelect_dataset.setParameter("casesId",id);
		SingleRulCasesSelect_dataset.setParameter("warningId",warningId);
		SingleRulCasesSelect_dataset.setParameter("op","joinCases");
	}
	//提交
	function btnSubmit_postSubmit(button){
		window.parent.caseWin_and_parWin_close();
	}
	//取消
	function btCancel_onClick(){
		window.parent.casesWin_close();
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>