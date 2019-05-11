<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="���������˻�">
<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="TriggerRuleAcctHistory" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.Interface id="intface" label="�������ѯ����" colNm=4 showButton="false"/>
						<div align="center" style="margin-bottom:10px">
							<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
							<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
						</div>
				<@CommonQueryMacro.DataTable id ="triggerRuleAcctHistoryTable" paginationbar="btnRead"
				fieldStr="loanacno[150],custname[150],prodid[100],prodname[100],acflag[80],acflag2[100],riskflag[80],overbal[100],operidName[100],bankidName[100],launchPer[50],date[60]" readonly="true" width="100%"/></br>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.FloatWindow id="triggerRuleAcctHistory" modal="true" label="�����ų�/�ָ���ʷ��¼" position="top" 
			resize="true" minimize="false" width="800" maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.CommonQuery id="TriggerRuleAcctHistory" init="true" submitMode="current" navigate="false">
					<@CommonQueryMacro.Group id="triggerRuleAcctGroup" label="" colNm=4
					fieldStr="loanacno,custname,prodid,prodname,riskflag,bankidName"/>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="TriggerWarningRuleHistory" init="false" submitMode="selected" navigate="false">
					<@CommonQueryMacro.DataTable height="300" id ="triggerWarningRuleTable" paginationbar="" pagination="false"
					fieldStr="select,ruleCode,ruleName" readonly="true" width="100%"/>
					<span><font color="red">&nbsp;PS:��ѡ�ļ�¼Ϊ�ų��ļ�¼</font></span>
				</@CommonQueryMacro.CommonQuery>
				<@CommonQueryMacro.CommonQuery id="RuleEliminateHistory" init="true" submitMode="current" navigate="false">
					<@CommonQueryMacro.Group id="ruleEliminateGroup" label="" colNm=4 labelwidth="250"
					fieldStr="eliminateRuleDesc"/>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.FloatWindow>
		</td>
	</tr>
</table>
<script language="JavaScript">
	function btnReset_onClick(){
		TriggerRuleAcctHistory_interface_dataset.clearData();
	}
	function btnRead_onClick(button){
		subwindow_triggerRuleAcctHistory.show();
		var ruleElimId=TriggerRuleAcctHistory_dataset.getValue("id");
		//��ǰ��¼��id
		var id=TriggerRuleAcctHistory_dataset.getValue("id");
		//��ǰѡ�м�¼���û�id
		var triggerRuleAcctId=TriggerRuleAcctHistory_dataset.getValue("loanacno");
		TriggerWarningRuleHistory_dataset.setParameter("accId",triggerRuleAcctId);
		TriggerWarningRuleHistory_dataset.flushData(1);
		
		RuleEliminate.dwrFindEliminateHistoryList(ruleElimId,function(y){
			var record=TriggerWarningRuleHistory_dataset.getFirstRecord();
			if(null!=y && y.length>0){
				while(record){
					for(var i=0;i<y.length;i++){
						if(y[i]==record.getValue("ruleCode")){
							record.setValue("select",true);
						}
					}
					record=record.getNextRecord();
				}
			}else{
				while(record){
					record.setValue("select",false);
					record=record.getNextRecord();
				}
			}
		});
		TriggerWarningRuleHistory_dataset.setFieldReadOnly("select",true);
		
		RuleEliminateHistory_dataset.setParameter("id",id);
		RuleEliminateHistory_dataset.flushData();
		RuleEliminateHistory_dataset.setFieldReadOnly("eliminateRuleDesc",false);
	}
	//������ǰ
	function bankName_DropDown_beforeOpen(dropDown){
		subAutoOrgTree_DropDownDataset.setParameter("currentUserOrgId",user_info.orgId);
	}
	//�������
	function bankName_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/RuleEliminate.js'> </script>
</@CommonQueryMacro.page>