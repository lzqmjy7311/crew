<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="">


	<@CommonQueryMacro.CommonQuery id="riskoverview" init="false" submitMode="current">
		<@CommonQueryMacro.Interface id="interface1" label="�������ѯ����" showButton="false"/>
		<div style="text-align:center"><@CommonQueryMacro.Button id="btQuery" /><@CommonQueryMacro.Button id="btReset"/></div>
		      <div id="table1">
				<div style="margin:10px 20px 3px 10px;text-align:right">
						<a href="javascript:btMore_onClick()">>>>����&lt;&lt;&lt</a>
				</div>
		        <@CommonQueryMacro.DataTable id="riskoverviewTable1" rownumbers="false" readonly="true"  pagination="false" fieldStr="warnCode,warnDt,rulName,rulType,warnStatus,eliminateDt,removedat,currentagent" width="100%"/>
		      </div>
		      <div id="table2" style="display:none">
		      <div style="margin:10px 20px 3px 10px;text-align:right">
					<a href="javascript:btMore1_onClick()">>>>����&lt;&lt;&lt</a>
			  </div>
		        <@CommonQueryMacro.DataTable id="riskoverviewTable2" rownumbers="false" readonly="true"   pagination="true" fieldStr="warnCode,warnDt,rulName,rulType,warnStatus,eliminateDt,removedat,currentagent" width="100%"/>
		      </div>
	</@CommonQueryMacro.CommonQuery>
<script>
	var flag='true';
	var queryflag="false";
	//ҳ���ʼ��
	function initCallGetter_post(){
	}
	
	function warningtype_DropDown_onSelect(dropDown,record,editor){
		var val = record.getValue("data");
		if(val==0){
			riskoverview_interface_dataset.setFieldReadOnly("rulTheme",false);
		}else{
			riskoverview_interface_dataset.setFieldReadOnly("rulTheme",true);
		}
		return true;
	}
	function btReset_onClick(){
		riskoverview_interface_dataset.clearData();
		var w=riskoverview_dataset.getValue("rulName");
		riskoverview_dataset.setParameter("rulName","1234");
		btMore1_onClick();
		queryflag='false';
		riskoverview_dataset.flushData(riskoverview_dataset.pageIndex);	
	}
	function btQuery_onClick(){
		queryflag='true';
		var warningtype=riskoverview_interface_dataset.getValue("warningtype");
		var warnCode=riskoverview_interface_dataset.getValue("warnCode");
		var rulName=riskoverview_interface_dataset.getValue("rulName");
		var rulTheme=riskoverview_interface_dataset.getValue("rulTheme");
		var eliminateFlag=riskoverview_interface_dataset.getValue("eliminateFlag");
		var removeFlag=riskoverview_interface_dataset.getValue("removeFlag");
		var warnDt=riskoverview_interface_dataset.getValue("warnDt");
		var endwarnDt=riskoverview_interface_dataset.getValue("endwarnDt");
		var warnStatus=riskoverview_interface_dataset.getValue("warnStatus");

		riskoverview_dataset.setParameter("warningtype",warningtype);
		riskoverview_dataset.setParameter("warnCode",warnCode);
		riskoverview_dataset.setParameter("rulName",rulName);
		riskoverview_dataset.setParameter("rulTheme",rulTheme);
		riskoverview_dataset.setParameter("eliminateFlag",eliminateFlag);
		riskoverview_dataset.setParameter("removeFlag",removeFlag);
		riskoverview_dataset.setParameter("warnDt",warnDt);
		riskoverview_dataset.setParameter("endwarnDt",endwarnDt);
		riskoverview_dataset.setParameter("warnStatus",warnStatus);
		btMore1_onClick();
		riskoverview_dataset.flushData(riskoverview_dataset.pageIndex);	
	}
	//����
	function btMore_onClick(){
		if(queryflag=='true'){
			$('#table1').css('display','none');
			$('#table2').css('display','block');
			riskoverview_dataset.setParameter("flag","false");
			riskoverview_dataset.flushData(riskoverview_dataset.pageIndex);	
			$('#table1').focus;
		}
	}
	function btMore1_onClick(){
		if(queryflag=='true'){
			$('#table1').css('display','block');
			$('#table2').css('display','none');
			riskoverview_dataset.setParameter("flag","true");
			riskoverview_dataset.flushData(riskoverview_dataset.pageIndex);	
		}
	}
	var casesWin=null;
	function casesWin_close(){
		casesWin.close();
	}
	function caseWin_and_parWin_close(){
		casesWin.close();
		subwindow_SingleRulWarningFW.close();
		flushCurrentPage();
	}
	//��������
	function btAddCases_onClick(){
		var warningId=SingleRulWarning_dataset.getValue("id");
		casesWin=openSubWin("casesWin","��������","/gbicc-com-pages/single/ftl/single_rul_cases_add.ftl?warningId="+warningId,"950","300");
	}
	//���밸��
	function btJoinCases_onClick(){
		var warningId=SingleRulWarning_dataset.getValue("id");
		casesWin=openSubWin("casesWin","���밸��","/gbicc-com-pages/single/ftl/single_rul_cases_join.ftl?warningId="+warningId,"950","350");
	}
	//�����ų�
	function btRiskElim_onClick(){
		subwindow_RiskEliminateFW.show();
	}
	//�ύ����¼�
	function btnSubmit_onClickCheck(button){
		var op="riskEliminate";
		SingleRulWarning_dataset.setParameter("op",op);
	}
	//�˻ؼ���¼�
	function btnBack_onClickCheck(button){
		var op="back";
		SingleRulWarning_dataset.setParameter("op",op);
	}
	//ͬ�����¼�
	function btnAgree_onClickCheck(button){
		var op="agree";
		SingleRulWarning_dataset.setParameter("op",op);
	}
	//ȡ��
	function btCancel_onClick(){
		subwindow_RiskEliminateFW.close();
	}
	function readFinaAnal_onClick(){
		top.easyMsg.info("���޴˹��ܣ�");
	}
	function readFinaInte_onClick(){
		top.easyMsg.info("���޴˹��ܣ�");
	}
	function readFundMoni_onClick(){
		top.easyMsg.info("���޴˹��ܣ�");
	}
	//�ύ��ر�ҳ�棬ˢ�±��
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("����ɹ���");
		subwindow_RiskEliminateFW.close();
		subwindow_SingleRulWarningFW.close();
		flushCurrentPage();
	}
	//�˻غ�ر�ҳ�棬ˢ�±��
	function btnBack_postSubmit(button){
		button.url="#";
		top.easyMsg.info("����ɹ���");
		subwindow_SingleRulWarningFW.close();
		flushCurrentPage();
	}
	//ͬ���ر�ҳ�棬ˢ�±��
	function btnAgree_postSubmit(button){
		button.url="#";
		top.easyMsg.info("����ɹ���");
		subwindow_SingleRulWarningFW.close();
		flushCurrentPage();
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		SingleRulWarning_dataset.flushData(SingleRulWarning_dataset.pageIndex);
	}
	//�鿴���
	function btnOpinion_onClick(button){
		subwindow_taskApprovalHistoryFW.show();
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>