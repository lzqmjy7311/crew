<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign businessId=RequestParameters["businessId"]?default("")>
<#assign rptStatus=RequestParameters["rptStatus"]?default("")>
<#assign pageReadOnly=RequestParameters["pageReadOnly"]?default('0')>

<@CommonQueryMacro.page title="��;��ر���">
	<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="YtMonitorReportWin" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box1" label="���������Ϣ">
						<@CommonQueryMacro.Group id="group1" label="" colNm=4
						fieldStr="lendCode,custCode,custName,custTrade,custPhone,custAddress,productCode,guarType,loanAmt,loanBalance,checkWay,checkAddress,assistSurvPer,mainSurvPer,surveyDate"/>
					</@CommonQueryMacro.GroupBox>
					
					<@CommonQueryMacro.GroupBox id="box2" label="��;��ؽ���">
						<@CommonQueryMacro.Group id="group2" label="" colNm=4
						fieldStr="operResult,buesResult,guarResult,earnResult,hasCert,loanResult"/>
						<center>
						<a id="fupload" href="javascript:void()">�����ϴ�/����</a>
						</center>
					</@CommonQueryMacro.GroupBox>
					
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="Yt_PlWarnSignal" init="false" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box3" label="Ԥ����Ϣ">
						<@CommonQueryMacro.DataTable id="warnSignalTable" readonly="true"  paginationbar="warnSignalUpd" 
						fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="warnSignalFW" modal="true" label="Ԥ�����"  position="center"
							resize="true" minimize="false"  maximize="true" closure="true" show="false" defaultZoom="normal">
								<table style="width: 100%"><tr><td>
								<@CommonQueryMacro.Group id="group2" label="" colNm=2
								fieldStr="warnCode,affPerDesc,warnLEvel,checkStatus,checkDesc"/>
								</td></tr>
								</table>
					    </@CommonQueryMacro.FloatWindow>	
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="YtMonitorReportWin" init="false" submitMode="current">
					<@CommonQueryMacro.GroupBox id="box5" label="���ƴ�ʩ">
							<@CommonQueryMacro.Group id="group5" labelwidth="400" label="" colNm=2
							fieldStr="lmtCtrl,riskCtrl,otherCtrlDesc,appendCtrl,frequency,applyOpin"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box6"  label="������">
							<@CommonQueryMacro.Group labelwidth="400"  id="group6" label="" colNm=2
							fieldStr="opinion"/>
					</@CommonQueryMacro.GroupBox>
					<@CommonQueryMacro.GroupBox id="box7" label="��ʩ���ʱ��">
							<@CommonQueryMacro.Group id="group7" labelwidth="400" label="" colNm=2
							fieldStr="measCompleteDate"/>
					</@CommonQueryMacro.GroupBox>
					
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox" label="������ʷ">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="�鿴���" position="top" 
							closure="true" show="false" defaultZoom="normal">
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="YtMonitorReportWin" init="false" submitMode="current">
					<center>
						<@CommonQueryMacro.Button id= "btnSave"/>
						<@CommonQueryMacro.Button id= "btnSelect"/>
						<@CommonQueryMacro.Button id= "btnSubmit"/>
						<@CommonQueryMacro.Button id= "btnBack"/>
						<@CommonQueryMacro.Button id= "btnPrint"/>
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
<script>
	var readOnly="0";//Ĭ�Ͽ��ļ� �ϴ�
	function openUploadWin(){
		openSubWin("uploadFile", "��������", 
			"/gbicc-pages/upload/commonupload.ftl?relaID=${businessId}&relaType=YT&readOnly="+readOnly,
		null,400);
	}
	$("#fupload").linkbutton({"iconCls":"icon-upload"}).click(openUploadWin);
	
	$("a[id=btnSubmit]").hide();
	
	//ҳ���ʼ��-����post����֮ǰ
	var opinion=true;
	var kf=true;
	var fldlabel_measCompleteDate=false;
	function initCallGetter_post(){
		var businessId='${businessId}';
		var rptStatus='${rptStatus}';
		YtMonitorReportWin_dataset.setParameter("businessId",businessId);
		Yt_PlWarnSignal_dataset.setParameter("businessId",null);
		Yt_PlWarnSignal_dataset.setParameter("loanAccount",YtMonitorReportWin_dataset.getValue("loanNo"));
		Yt_PlWarnSignal_dataset.flushData(Yt_PlWarnSignal_dataset.pageIndex);
		TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		
		$("#fldlabel_opinion").html($("#fldlabel_opinion").text()+"<span style='color:red;'>*</span>");
		$("#fldlabel_measCompleteDate").html($("#fldlabel_measCompleteDate").text()+"<span style='color:red;'>*</span>");
		
		TaskVariable.taskIsCompile(businessId,function(y){if(y){readOnly="1";}});
		if(YtMonitorReportWin_dataset.getValue('checkWay')=="2"){
			YtMonitorReportWin_dataset.setFieldRequired("checkAddress",false);
		}else{
			YtMonitorReportWin_dataset.setFieldRequired("checkAddress",true);
		}
		//��������ͼÿһ�ڵ��������ʼ��ҳ��
		TaskVariable.findTaskVariable(businessId,function(y){
			if(y.pageReadOnly!=null && y.pageReadOnly=="true"){
				//����ҳ��ֻ��
        		setPageReadOnlyFun();
        		$("#warnSignalUpd").hide();
        		$("fieldset[name=box7]").hide();
			}else{
				//������������Ϊ�����á��򵣱��Ƿ���ʵ�ɱ༭ ����֮���ػ����.
				var guarType=YtMonitorReportWin_dataset.getValue('guarType');
				if(guarType=="1"){
					YtMonitorReportWin_dataset.setFieldReadOnly("guarResult",true);
				}else{
					YtMonitorReportWin_dataset.setFieldReadOnly("guarResult",false);
				}
				//�ͻ�����ɱ༭
				TaskVariable.getSystemCurrentDate(null,function(y){
					YtMonitorReportWin_dataset.setValue("surveyDate",y);
				});
			}
			
        	if(y.backBtn!=null && y.backBtn=="hide"){
        		//�����˻ذ�ť
        		$("a[id=btnBack]").hide();
        		//����������
        		//$("fieldset[name=box6]").hide();
        	}else{
        		var editFields=["opinion"];
        		setPageCanWriteFun(editFields);
        	}
        	if(y.ctrlMeas!=null && y.ctrlMeas=="hide"){
        		//���ؿ��ƴ�ʩ
        		$("fieldset[name=box5]").hide();
        	}
        	if(y.ctrlMeasReadOnly!=null && y.ctrlMeasReadOnly=="false"){
        		//�����ֶο�д
        		kf=false;
        		var editFields=["lmtCtrl","frequency","riskCtrl","otherCtrlDesc","appendCtrl","applyOpin","opinion"];
        		setPageCanWriteFun(editFields);
        		YtMonitorReportWin_dataset.setFieldHidden("frequency",true);//Ĭ�����ؼ��Ƶ��
        		YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",true);
        	}
        	if(y.measDate==null || y.measDate=="hide"){
        		//��ʾ��ʩ���ʱ��
        		$("fieldset[name=box7]").hide();
        	}else{
        		var editFields=["measCompleteDate"];
        		//YtMonitorReportWin_dataset.setFieldRequired("measCompleteDate",true);
        		setPageCanWriteFun(editFields);
        		opinion=false;
        		$("fieldset[name=box6]").hide();
        		$("fieldset[name=box7]").show();
        		fldlabel_measCompleteDate=true;
        	}
        	
        	if('${pageReadOnly}'=='1'){
				setPageReadOnlyFun();
        		readOnly="1";
        		$("#warnSignalUpd").hide();
        		$("a[id=btnSave]").hide();
        		$("a[id=btnSubmit]").hide();
        		$("a[id=btnSelect]").hide();
        		$("a[id=btnBack]").hide();
        		//$("a[id=btnPrint]").hide();
        		$("fieldset[name=box6]").hide();
        		$("fieldset[name=box7]").show();
			}
			
			var frequency=YtMonitorReportWin_dataset.getValue("frequency");
        	if(frequency){
        		YtMonitorReportWin_dataset.setFieldHidden("frequency",false);
        	}
        	var riskCtrl=YtMonitorReportWin_dataset.getValue("riskCtrl");
        	if(riskCtrl && riskCtrl!="" && riskCtrl.indexOf("SS")>-1){
				YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",false);
			}
       	});
		
       	MonitorReportCtrl.dwrFindCtrl(businessId,function(y){
			if(y && y.length>0){
				var apdCtrl="";
				for(var i=0;i<y.length;i++){
					var obj=eval("("+y[i]+")");
					if(obj.ctrlType=="1"){
						YtMonitorReportWin_dataset.setValue("lmtCtrl",obj.conmeasCode);
					}else if(obj.ctrlType=="2"){
						YtMonitorReportWin_dataset.setValue("riskCtrl",obj.conmeasCode);
						YtMonitorReportWin_dataset.setValue("otherCtrlDesc",obj.otherCtrlDesc);
					}else if(obj.ctrlType=="3"){
						apdCtrl=apdCtrl+obj.conmeasCode+",";
					}
				}
				if(apdCtrl!=""){
					apdCtrl=apdCtrl.substring(0,apdCtrl.length-1);
				}
				YtMonitorReportWin_dataset.setValue("appendCtrl",apdCtrl);
			}
		});
		MonitorReportCtrl.dwrFindFrequency(businessId,function(y){					
			if(y){						
				YtMonitorReportWin_dataset.setValue("frequency",y[0]);
				YtMonitorReportWin_dataset.setValue("frequencyName",y[1]);
				YtMonitorReportWin_dataset.setFieldHidden("frequency",false);
			}else{
				YtMonitorReportWin_dataset.setFieldHidden("frequency",true);
			}
		});				
	}
	
	function riskCtrl_selectedFun(val){
		if(val && val!="" && val.indexOf("SS")>-1){
			YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",false);
		}else{
			YtMonitorReportWin_dataset.setFieldHidden("otherCtrlDesc",true);
			YtMonitorReportWin_dataset.setValue("otherCtrlDesc",null);
		}
	}
	
	function YtMonitorReportWin_dataset_onSetValue(ds,curretField,val){
		if(curretField.name=='appendctrl'){
			appendCtrl_selectedFun(val);
		}else if(curretField.name=='riskctrl'){
			riskCtrl_selectedFun(val);
		}
		return val;
	}
	
	function appendCtrl_selectedFun(val){
		if(val && val!="" && val.indexOf("1")>-1){
			YtMonitorReportWin_dataset.setFieldHidden("frequency",false);
			YtMonitorReportWin_dataset.setValue("frequency","0.5");
			YtMonitorReportWin_dataset.setValue("frequencyName","0.5��");
		}else{
			YtMonitorReportWin_dataset.setFieldHidden("frequency",true);
			YtMonitorReportWin_dataset.setValue("frequency",null);
			YtMonitorReportWin_dataset.setValue("frequencyName",null);
		}
	}
	
	function frequency_DropDown_beforeOpen(dropDown){
		var businessId='${businessId}';
		subAutoDataDic_DropDownDataset.setParameter("businessId",businessId);
		subAutoDataDic_DropDownDataset.setParameter("dicCode",703);
		frequency_DropDown.cached=false;//��qGroupId�����뻺��
	}
	function YtMonitorReportWin_dataset_afterChange(dataset,field){
		if(field.fieldName=='checkWay'){			
			if(YtMonitorReportWin_dataset.getValue('checkWay')=="2"){
				YtMonitorReportWin_dataset.setFieldRequired("checkAddress",false);
			}else{
				YtMonitorReportWin_dataset.setFieldRequired("checkAddress",true);
			}
		}
	}
	//���水ť�ύ����¼�
	function btnSave_onClickCheck(button){
		YtMonitorReportWin_dataset.setParameter("op","save");
	}
	//�ύ��ť�ύ����¼�-ѡ�������ύ��
	function btnSelect_onClickCheck(button){
		if(opinion && YtMonitorReportWin_dataset.getValue("opinion")==""){
			alert('����������Ϊ��!');
			return false;
		}
		if(fldlabel_measCompleteDate && 
			YtMonitorReportWin_dataset.getValue("measCompleteDate")==""){//��Ҫ��д���ƴ�ʩ���ʱ�� 
			alert('���ƴ�ʩ���ʱ�䲻��Ϊ��!');
			return false;
		}
		var orgId=user_info.orgId;
		var roleId="";
		var businessId='${businessId}';
		/////û��ѡ����ƴ�ʩ�Ͳ���Ҫѡ ��-ֱ���ύ///
		if(!kf && YtMonitorReportWin_dataset.getValue("lmtCtrl")=="" &&
			YtMonitorReportWin_dataset.getValue("riskCtrl")=="" &&
			YtMonitorReportWin_dataset.getValue("appendCtrl")==""){
			btnSubmit.click();
			return false;
		}
		TaskVariable.findTaskVariable(businessId,function(y){
			if(y && y.nextRole){//��ȡ����ɫID�򿪴��ڡ�
				submitWindow=openSubWin("submitWindow","��������","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+y.nextRole,"600","400");
			}else{//��ȡ������ֱ���ύ
				btnSubmit.click();
			}
		});
	}
	function cancelFun(){
		YtMonitorReportWin_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//�ύ
	function submitFun(taskAssignee){
		YtMonitorReportWin_dataset.setParameter("taskAssignee",taskAssignee);
		btnSubmit.click();
	}
	
	//ʵ���ύ��
	function btnSubmit_onClickCheck(button){
		var op="submit";
		YtMonitorReportWin_dataset.setParameter("op",op);
	}
	
	//�˻ذ�ť�ύ����¼�
	function btnBack_onClickCheck(button){
		var op="back";
		YtMonitorReportWin_dataset.setParameter("op",op);
		if(YtMonitorReportWin_dataset.getValue("opinion")==""){
			alert('����������Ϊ��!');
			return false;
		}
	}
	
	//����ҳ�������ֶ�ֻ��
	function setPageReadOnlyFun(){
		var fieldName="";
		for(var i=0;i<YtMonitorReportWin_dataset.fields.length;i++){
			fieldName=YtMonitorReportWin_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				YtMonitorReportWin_dataset.setFieldReadOnly(fieldName,true);
			}
		}
	}
	//����ҳ���ֶο�д
	function setPageCanWriteFun(editFields){
		for(var i=0;i<editFields.length;i++){
			YtMonitorReportWin_dataset.setFieldReadOnly(editFields[i],false);
		}
	}

	function warnSignalUpd_onClick(button){
		if(Yt_PlWarnSignal_dataset.record){
			subwindow_warnSignalFW.show();
		}else{
			alert('û�����ݿ�����ʾ��');
		}
	}
	function warnSignalConfirm_onClick(button){
		subwindow_warnSignalFW.close();
	}
	
	//�����ر�ҳ�棬ˢ�±��
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("����ɹ���");
		//if(parent.parent.GTab){parent.parent.GTab.closeTab();}
		//window.parent.ajMonitorReportWin_close();
	}
	//�����ر�ҳ�棬ˢ�±��
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("�����ɹ���");
		if(parent.parent.GTab){parent.parent.GTab.closeTab();}
		window.parent.ajMonitorReportWin_close();
	}
	//�˻غ�ر�ҳ�棬ˢ�±��
	function btnBack_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("�����ɹ���");
		if(parent.parent.GTab){parent.parent.GTab.closeTab();}
		window.parent.ajMonitorReportWin_close();
	}
	//�鿴���
	function btnOpinion_onClick(button){
		subwindow_taskApprovalHistoryFW.show();
	}
	//��ӡ
	function btnPrint_onClick(){
		var reportId=YtMonitorReportWin_dataset.getValue("id");
		var businessId='${businessId}';
		window.open("${contextPath}/common/donloadWord?reportType=YTR&reportId="+reportId+"&businessId="+businessId);
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/MonitorReportCtrl.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>