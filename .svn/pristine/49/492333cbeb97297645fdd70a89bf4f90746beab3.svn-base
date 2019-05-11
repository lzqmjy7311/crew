<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="单规则预警处置-新增案例">
<table>
	<@CommonQueryMacro.CommonQuery id="SingleRulCases" init="false" submitMode="current">
		<@CommonQueryMacro.Group id="SingleRulCasesGroup" label="" colNm=2 labelwidth="150"
		fieldStr="casesName,casesDesc"/>
		<center>
			<@CommonQueryMacro.Button id="btnSubmit" />
			<@CommonQueryMacro.Button id="btnEmptyCaseSubmit" />
			<@CommonQueryMacro.Button id="btCancel" />
		</center>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	var warningId='${warningId}';
	//页面初始化
	function initCallGetter_post(){
		SingleRulCases_dataset.setFieldReadOnly("casesCode",false);
		SingleRulCases_dataset.setFieldReadOnly("casesName",false);
		SingleRulCases_dataset.setFieldReadOnly("casesDesc",false);
		
		if(warningId){
			$("a[id=btnSubmit]").show();
			$("a[id=btnEmptyCaseSubmit]").hide();
		}else{
			$("a[id=btnSubmit]").hide();
			$("a[id=btnEmptyCaseSubmit]").show();
		}
	}
	//提交前检查事件
	function btnEmptyCaseSubmit_onClickCheck(button){
		var op="addCases";
		SingleRulCases_dataset.setParameter("op",op);
	}
	function btnSubmit_onClickCheck(button){
		var op="addCases";
		SingleRulCases_dataset.setParameter("op",op);
		SingleRulCases_dataset.setParameter("warningId",warningId);
	}
	//提交
	function btnSubmit_postSubmit(button){
		window.parent.caseWin_and_parWin_close();
	}
	function btnEmptyCaseSubmit_postSubmit(button){
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