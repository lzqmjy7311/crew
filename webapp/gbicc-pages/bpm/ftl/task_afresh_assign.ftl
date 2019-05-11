<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="���̹���  &gt;  �����ط���">
<table>
	<@CommonQueryMacro.CommonQuery id="TaskAfreshAssign" init="true" submitMode="selected">
		<@CommonQueryMacro.DataTable id="taskAfreshAssignTable" toolbar="mytoolbar" readonly="true" paginationbar="btAdd2" 
		fieldStr="select,taskId[80],procName[120],taskName[150],taskDesc[400],createTime[100],assigneeDesc[200],assigneeOrg[100]" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="afreshAssignFW" modal="true" label="�������·���" 
		resize="true" minimize="false" width="500" height="200" maximize="true" closure="true" show="false" defaultZoom="normal">
		<@CommonQueryMacro.Group id="afreshAssignGroup" label="" colNm=4
		fieldStr="organization,user"/>
		<center>
			<@CommonQueryMacro.Button id= "btnSubmit"/>
		</center>
		</@CommonQueryMacro.FloatWindow>
		<@CommonQueryMacro.FloatWindow id="diagramFW" modal="true" label="����ͼ�鿴" 
		resize="true" minimize="false" width="1000" height="700" maximize="true" closure="true" show="false" defaultZoom="normal">
		<img id="img" data="${contextPath}/common/ProcessDiagramServlet">
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.ToolBar id="mytoolbar">
		<@CommonQueryMacro.InterfaceElement elId="businessId" />
		<@CommonQueryMacro.InterfaceElement elId="procName" />
		<@CommonQueryMacro.InterfaceElement elId="assignee" />
		<@CommonQueryMacro.InterfaceButton desc="btQuery" />
	</@CommonQueryMacro.ToolBar>
</table>
<script>
	function btAdd2_onClick(button){
		//���ݼ��,��ͬһ����ͬһ�������˲���һ�������������·���
		var sl=[];
		var record=TaskAfreshAssign_dataset.getFirstRecord();
		while(record){
			if(record.getValue("select")==true){
				sl.push(record);
			}
			record=record.getNextRecord();
		}
		var sl2=sl;
		for(var i=0;i<sl.length;i++){
			for(var k=0;k<sl2.length;k++){
				if(sl[i].getValue("roleId")!=sl2[k].getValue("roleId")){
					top.easyMsg.info("ֻ��ͬʱ����ͬһ��ɫ����������");
					return;
				}
			}
		}
		if(sl.length==0){
			top.easyMsg.info("�빴ѡҪ���·��������");
			return;
		}
		
		//���ͨ������������
		TaskAfreshAssign_dataset.setFieldRequired("organization",true);
		TaskAfreshAssign_dataset.setFieldRequired("user",true);
		subwindow_afreshAssignFW.show();
		var userId=sl[0].getValue("assignee");
		TaskVariable.findOrgInfoByUserId(userId,function(y){
			if(null!=y){
				TaskAfreshAssign_dataset.setValue('organization',y.orgId);
				TaskAfreshAssign_dataset.setValue('organizationName',y.orgName);
			}
		});
		TaskAfreshAssign_dataset.setFieldReadOnly("organization",true);
	}
	function afreshAssignFW_floatWindow_beforeClose(){
		TaskAfreshAssign_dataset.setFieldRequired("organization",false);
		TaskAfreshAssign_dataset.setFieldRequired("user",false);
		return true;
	}
	function afreshAssignFW_floatWindow_beforeHide(){
		TaskAfreshAssign_dataset.setFieldRequired("organization",false);
		TaskAfreshAssign_dataset.setFieldRequired("user",false);
		return true;
	}
	
	//����ͼ
	function btProcDiag_onClick(button) {
		subwindow_diagramFW.show();
		var src=$("#img").attr("data")+"?flag=runtime&executionId="+TaskAfreshAssign_dataset.getValue("procInstId")+"&t="+new Date();
		$("#img").attr("src",src);
	}
	//�û�
	function user_DropDown_beforeOpen(dropDown){
		var qServerType = TaskAfreshAssign_dataset.getString('organization');//���ݵ�һ��selectId��õ�һ��selectֵ
		if(!qServerType){
			return "��ѡ����������!";
		}
		var roleId="";
		var record=TaskAfreshAssign_dataset.getFirstRecord();
		while(record){
			if(record.getValue("select")==true){
				roleId=record.getValue("roleId");
			}
			record=record.getNextRecord();
		}
		subAutoUserTree_DropDownDataset.setParameter("orgId",qServerType);
		subAutoUserTree_DropDownDataset.setParameter("roleId",roleId);
		subAutoUserTree_DropDownDataset.setParameter("currAssignee",null);
		user_DropDown.cached=false;//��qGroupId�����뻺��
	}
	//����
	function organization_DropDown_onSelect(dropDown,record,editor){
		var oldVal = TaskAfreshAssign_dataset.getValue("organization");//��һ�ε�ֵ
		var newVal = record ? record.getValue('brcode') : '';//���ڵ�ֵ
		if(oldVal!=newVal){
			//�ж����ε�ֵ�Ƿ���ȣ��������Ȱ�ֵ����
			TaskAfreshAssign_dataset.setValue('user','');
			TaskAfreshAssign_dataset.setValue('userName','');
		}
		return true;
	}
	//�������
	function organization_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}
	//����ͻ�����
	function user_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}
	//�ύ����¼�
	function btnSubmit_onClickCheck(){
		var user=TaskAfreshAssign_dataset.getValue("user");
		var userName=TaskAfreshAssign_dataset.getValue("userName");
		if(user!=null && user!="" && user==userName){
			top.easyMsg.info("�ֹ�������û���Ч����ѡ���������е��û���");
			return false;
		}
		TaskAfreshAssign_dataset.setParameter("user",user);
		TaskAfreshAssign_dataset.setParameter("op","oneSubmit");
	}
	//�ύ��ر�ҳ�棬ˢ�±���
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("����ɹ���");
		subwindow_afreshAssignFW.close();
		flushCurrentPage();
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TaskAfreshAssign_dataset.flushData(TaskAfreshAssign_dataset.pageIndex);
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>