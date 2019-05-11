<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="�������Ƶ���˻�">
<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="TPlTriggerFrequencyAcct" init="true" submitMode="current" navigate="false">
				<@CommonQueryMacro.Interface id="intface" label="�������ѯ����" colNm=4 showButton="false"/>
					<div align="center" style="margin-bottom:10px">
						<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
						<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
					</div>
				<@CommonQueryMacro.DataTable id ="triggerFrequencyAcctTable" paginationbar="btn_Add,btn_Read"
				fieldStr="loanAcct,custName,warnLevel,warnDate,loanVariety,loanAmt,loanBalance,loanTerm,frequency,status" readonly="true" width="100%"/></br>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.FloatWindow id="triggerFrequencyAcctFW" modal="true" label="�������Ƶ��" position="top" 
			resize="true" minimize="false"  maximize="true" closure="true" show="false" defaultZoom="normal">
				<@CommonQueryMacro.CommonQuery id="TPlTriggerFrequencyAcct" init="true" submitMode="selected" navigate="false">
				<table>
				 <tr>
		    		<td class="labeltd" align="center" width="width:20%">
		    		   �����˺�:
					</td>
					<td align="left" nowrap style="width:80%">
						<@CommonQueryMacro.SingleField fId="loanAcct"/>
						<@CommonQueryMacro.SimpleButton id="btnSelect" desc="ѡ��" onclick="selectMainObj();" icon="" plain="false" />
					</td>
		    	</tr>
				</table>
					<@CommonQueryMacro.Group id="triggerFrequencyAcctGroup" label="" colNm=4
					fieldStr="warnLevel,custName,loanAmt,loanVariety,loanBalance,sysFrequency,frequency,loanTerm,launchPer,launchBank"/>
					<center>
					<@CommonQueryMacro.Button id= "btn_Submit"/>
					<@CommonQueryMacro.Button id= "btn_SubmitTrue"/>
					<span id="msgLabel">�ô����˺��ѷ��͵������Ƶ��������������������ʱ�޷��������ȴ���˽�����</span>
					</center>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.FloatWindow>
		</td>
	</tr>
	
	
</table>
<@CommonQueryMacro.FloatWindow id="AccW" modal="true" label="�����˻�ѡ��" 
	resize="true" minimize="false" width="1000" height="500" maximize="true" closure="true" show="false" defaultZoom="normal">
 <table>	
	<@CommonQueryMacro.CommonQuery id="TPlTrigFrequencyAcctV" init="true" submitMode="current">
	<tr>
	   <td>	
	       <@CommonQueryMacro.Interface id="interface1" label="�������ѯ����" colNm=6 />
	   </td>
	<tr>
	   <td>
		<@CommonQueryMacro.DataTable id="taskTable"   fieldStr="loanAccount,custname,productCode[150],loanAmount,loanBalance,loanPeriod,operator,operBank[150],trigRate,rankFinal" paginationbar="chanceAcc" width="100%" hasFrame="true"/>
	  </td>
	
	</@CommonQueryMacro.CommonQuery>
 </table>	
</@CommonQueryMacro.FloatWindow>
<script language="JavaScript">
    var submitWindow=null;  
  //���ò�ѯ����
	function btnReset_onClick(button){
		TPlTriggerFrequencyAcct_interface_dataset.clearData();
	}
    function initCallGetter_post(){
		$("a[id=btnBack]").hide();
		$("a[id=btn_SubmitTrue]").hide();//�ύ ����
		$("span[id=msgLabel]").hide();
				
	}
	function chanceAcc_onClick(){
		//warnLevel,custName,loanAmt,loanVariety,loanBalance,sysFrequency,frequency,loanTerm,status,launchPer,launchBank Ŀ��
		//loanAccount,custname,productCode,loanAmount,loanBalance,loanPeriod,operator,operBank,trigRate,rankFinal Դ
		var loanAccount=TPlTrigFrequencyAcctV_dataset.getValue("loanAccount");//��ȡ�˻���
		var custName=TPlTrigFrequencyAcctV_dataset.getValue("custname");//�ͻ�����
		var loanAmt=TPlTrigFrequencyAcctV_dataset.getValue("loanAmount");//������
		var loanVariety=TPlTrigFrequencyAcctV_dataset.getValue("productCode");//��Ʒ����
		var loanBalance=TPlTrigFrequencyAcctV_dataset.getValue("loanBalance");//�������
		var sysFrequency=TPlTrigFrequencyAcctV_dataset.getValue("trigRate");//ϵͳƵ��
		var loanTerm=TPlTrigFrequencyAcctV_dataset.getValue("loanPeriod");//��������
		var launchPer=TPlTrigFrequencyAcctV_dataset.getValue("operator");//������
		var launchBank=TPlTrigFrequencyAcctV_dataset.getValue("operBank");//������
		var warnLevel=TPlTrigFrequencyAcctV_dataset.getValue("rankFinal");//���շ��յȼ�
		if(loanAccount==null || loanAccount==""){
			top.easyMsg.info("����ѡ���˻���");
			return;
		}
		TPlTriggerFrequencyAcct_dataset.setValue("loanAcct",loanAccount);
		TPlTriggerFrequencyAcct_dataset.setValue("custName",custName);
		TPlTriggerFrequencyAcct_dataset.setValue("loanAmt",loanAmt);
		TPlTriggerFrequencyAcct_dataset.setValue("loanVariety",loanVariety);
		TPlTriggerFrequencyAcct_dataset.setValue("loanBalance",loanBalance);
		TPlTriggerFrequencyAcct_dataset.setValue("sysFrequency",sysFrequency);
		TPlTriggerFrequencyAcct_dataset.setValue("loanTerm",loanTerm);
		TPlTriggerFrequencyAcct_dataset.setValue("launchPer",launchPer);
		TPlTriggerFrequencyAcct_dataset.setValue("launchBank",launchBank);
		TPlTriggerFrequencyAcct_dataset.setValue("warnLevel",warnLevel);
		
		
	     TaskVariable.findRuningTaskByBusinessKey(loanAccount,function(y){
		   
		   if(null!=y && y=="true"){ 
			       TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",true);
		            $("a[id=btn_Submit]").hide();
					$("span[id=msgLabel]").show();
		   }else{
			        
			        TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",false);
		            $("a[id=btn_Submit]").show();
					$("span[id=msgLabel]").hide();
		   } 
		});
		
		subwindow_AccW.close();
	}

	function selectMainObj(){

		
		subwindow_AccW.show();
		
	}
	
	//�˻ذ�ť�ύ����¼�
	function btnBack_onClickCheck(button){
		var op="back";	
		var businessId=TPlTriggerFrequencyAcct_dataset.getValue('loanAcct');
		TPlTriggerFrequencyAcct_dataset.setParameter("businessId",businessId);
		TPlTriggerFrequencyAcct_dataset.setParameter("op",op);
	}

	function btn_Submit_onClick(button){
		 var frequency=TPlTriggerFrequencyAcct_dataset.getValue('frequency');
		 var businessId=TPlTriggerFrequencyAcct_dataset.getValue('loanAcct');
		    if(frequency==""){
		    	top.easyMsg.info("��ѡ����Ƶ�ʣ�");
		    	return false;
		    }
		    var orgId=user_info.orgId;
		  
			submitWindow=openSubWin("submitWindow","��������","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+557,"600","400");
				
		
	}
	//ȡ��
	function cancelFun(){
		TPlTriggerFrequencyAcct_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//�ύ
	function submitFun(taskAssignee){
		TPlTriggerFrequencyAcct_dataset.setParameter("taskAssignee",taskAssignee);
		btn_SubmitTrue.click();
	}
	//�ύ��ť�ύ����¼�
	function btn_SubmitTrue_onClickCheck(button){
		var op="one_submit";	
	
		TPlTriggerFrequencyAcct_dataset.setParameter("op",op);
	}
	//�ύ��ر�ҳ�棬ˢ�±��
	function btn_SubmitTrue_postSubmit(button) {
		button.url="#";
		if(submitWindow){
			submitWindow.close();
		}
		top.easyMsg.info("����ɹ���");
		subwindow_triggerFrequencyAcctFW.close();
		
		TPlTriggerFrequencyAcct_dataset.flushData(TPlTriggerFrequencyAcct_dataset.pageIndex);
	}
	
 	function btn_Add_onClick(button){
 		            TPlTriggerFrequencyAcct_dataset.insertRecord("end");		   			
		            $("a[id=btn_Submit]").hide();
		            $("a[id=btnSelect]").show();
					//$("span[id=msgLabel]").show();
					TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",true);
		  
					$("span[id=msgLabel]").hide();
 	                subwindow_triggerFrequencyAcctFW.show();
	}
 	
 	function triggerFrequencyAcctFW_floatWindow_beforeClose(subwindow) {
 		TPlTriggerFrequencyAcct_dataset.cancelRecord();
 		return true;
 	}
 	
	function btn_Read_onClick(button){
	     
	     TPlTriggerFrequencyAcct_dataset.setFieldReadOnly("frequency",true);
	     $("a[id=btnSelect]").hide();
	     var businessId=TPlTriggerFrequencyAcct_dataset.getValue('loanAcct');
 	     TaskVariable.findRuningTaskByBusinessKey(businessId,function(y){
		   
		   if(null!=y && y=="true"){ 
		            $("a[id=btn_Submit]").hide();
					$("span[id=msgLabel]").show();
		   }else{
		          $("a[id=btn_Submit]").hide();
					$("span[id=msgLabel]").hide();
		   } 
		});
	    subwindow_triggerFrequencyAcctFW.show();
	
	}
	
 	function btnAdd_onClick(button){
 	    var businessId=TPlTriggerFrequencyAcctTask_dataset.getValue('loanAcct');
		
		TPlTriggerFrequencyAcct_dataset.setParameter("businessId",businessId);
 	     TaskVariable.findTaskVariable(businessId,function(y){
		   if(y.back!=null&&y.back=='show'){ 
		     $("a[id=btnBack]").show();
		   } 
		});
 	    TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
 	     subwindow_triggerFrequencyAcctTaskFW.show();
	}
		

	

	
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>

</@CommonQueryMacro.page>