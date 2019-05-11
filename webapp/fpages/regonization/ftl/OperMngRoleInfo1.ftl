<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign op=RequestParameters["op"]?default("")>
<#assign brcode=RequestParameters["brcode"]?default("")>
<@CommonQueryMacro.page title="����Ա��ɫ����">
	<table align="left" width="100%">
		<tr align="center">
			<td width="100%" colspan="2">
				<@CommonQueryMacro.CommonQuery id="operMngMod"  init="true" navigate="false" submitMode="all" >
					<@CommonQueryMacro.Group id ="table1" label="��ϸ��Ϣ" fieldStr="tlrno,tlrName" colNm="4"/>
					<#--��������<@CommonQueryMacro.SingleField fId="brcode"/>
					
					<FIELDSET name='guoup1' style="padding: 6px;">
					<LEGEND extra="groupboxtitle">����Ա��Ϣ</LEGEND>
						<table frame=void class="grouptable" width="100%">
						<tr>
							<td align="center" nowrap class="labeltd" width="25%"> ����Ա�� </td>
							<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrno"/></td>
							<td align="center" nowrap class="labeltd"  width="25%"> ����Ա���� </td>
							<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrName" /></td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd"  width="25%"> ����Ա���� </td>
							<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="brname" /></td>
						</tr>
					   </table>
				  	</FIELDSET>
				  	-->
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr id="tlrBctlRel">
			<td width="45%">
				<@CommonQueryMacro.CommonQuery id="bctlMngEntry" init="false" submitMode="all" navigate="false">
					<table width="100%">
					<tr>
						<td width="100%">
						<FIELDSET name='guoup3' style="padding: 6px;">
							<LEGEND extra="groupboxtitle">��Ȩ������Ϣ</LEGEND>
								<table frame=void width="100%">
							      	<tr>
							      		<td valign="top">
												<@CommonQueryMacro.DataTable height="450" id ="datatable1" readonly="false" fieldStr="brno[80],brname" width="100%"   />
										</td>
								 	</tr>
								 </table>
						</FIELDSET>
						 </td>
					 </tr>
					</table>
				</@CommonQueryMacro.CommonQuery>
		 	</td>
		 	<td width="55%"  >
		 		<@CommonQueryMacro.CommonQuery id="operMngRoleInfo" init="false" submitMode="selected" navigate="false">
					<table width="100%" >
					<tr>
						<td width="100%">
						<FIELDSET name='guoup3' style="padding: 6px;">
							<LEGEND extra="groupboxtitle">��λ��Ϣ</LEGEND>
								<table frame=void width="100%">
							      	<tr>
							      		<td valign="top">
												<@CommonQueryMacro.DataTable height="450" id ="datatable2" fieldStr="select[60],roleId[80],roleName[150]" width="100%" readonly="false"/>
										</td>
								 	</tr>
								 </table>
						</FIELDSET>
						 </td>
					 </tr>
					</table>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr align="center">
			<td width="100%" colspan="2">
			<@CommonQueryMacro.CommonQuery id="operMngRoleInfo" init="true" submitMode="current" navigate="false">
	      		<@CommonQueryMacro.Button id= "btRoleSave" />
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
</table>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script language="javascript">
	var op = "${op}";
	var brcode = "${brcode}";
	var showRel = '1';//${statics["com.huateng.ebank.business.management.service.SystemParamService"].queryParameter("ISAUTH","BCTL")};
	var flag=false;
	/*function datatable1_onDbClick(){
		var tlrno=operMngMod_dataset.getValue('tlrno');
		var orgId=bctlMngEntry_dataset.getValue('brno');
		operMngRoleInfo_dataset.setParameter("orgId",orgId);
		operMngRoleInfo_dataset.setParameter("tlrno",tlrno);
		operMngRoleInfo_dataset.flushData(operMngRoleInfo_dataset.pageIndex);
	}*/
	
	//�����ظ������ͬ����
	function brname_DropDown_onSelect(r,rd){
		var record=bctlMngEntry_dataset.getFirstRecord();
		var id=rd.getValue("id");
		var records=[];
		var has=true;
		while(record){
			if(record.getValue("brno")==id){
				has=false;
				return;
			}
			record=record.getNextRecord();
		}
		
		return has;
	}
	
	//����ѡ��ı��ʱ��
	function bctlMngEntry_dataset_afterScroll(){
		var tlrno=operMngMod_dataset.getValue('tlrno');
		var orgId=bctlMngEntry_dataset.getValue('brno');
		if(orgId!=""){
			operMngRoleInfo_dataset.setParameter("orgId",orgId);
			operMngRoleInfo_dataset.setParameter("tlrno",tlrno);
			operMngRoleInfo_dataset.flushData(operMngRoleInfo_dataset.pageIndex);	
			//alert('��������.....'+ JSON.stringify(myselects));
		}
	}
	function datatable1_onFilterRecord(dataset,record){
		if(record.getValue('brno')==brcode){
			return false;
		}else{
			return true;
		}
	}
	function datatable2_onFilterRecord(dataset,record){
		if(record.getValue('roleId')=='333'||record.getValue('roleId')=='602'||record.getValue('roleId')=='601'||record.getValue('roleId')=='222'){
			return false;
		}else{
			return true;
		}
	}
	loadDefaultConfig();
	
	function bctlMngEntry_dataset_flushDataPost(){
		var record=bctlMngEntry_dataset.getFirstRecord();
		while(record){
			if(record.getValue('brno')==brcode){
				bctlMngEntry_dataset.setRecord(record);
				bctlMngEntry_dataset.setValue('brcodetemp',brcode);
			}
			if(record.getValue("brno")!=null){
				if(myselects[record.getValue("brno")]==null){
					myselects[record.getValue("brno")]=[];
				}
			}
			record=record.getNextRecord();
		}
	}
	
	//�������ݱ仯ʱ
	var myselects={};
	function bctlMngEntry_dataset_afterChange(dt,f,a){
		if(f.fieldName=="brno"){
			var record=bctlMngEntry_dataset.getFirstRecord();
			var records=[];
			while(record){
				if(record.getValue("brno")!=null){
					if(myselects[record.getValue("brno")]==null){
						myselects[record.getValue("brno")]=[];
					}
				}
				record=record.getNextRecord();
			}
			bctlMngEntry_dataset_afterScroll();
		}
	}
	
	//��λѡ���¼�
	function operMngRoleInfo_dataset_afterChange(dt,f,a){
		var record=operMngRoleInfo_dataset.getFirstRecord();
		var brno=bctlMngEntry_dataset.getValue("brno");
		var roles=[];
		if(f.fieldName=="select"){
			//alert('��������.....'+ JSON.stringify(myselects));
			/*setTimeout(function(){
			while(record){
				//���ڻ������úõĸ�λ��ӵ���ʱ�ֶ���
				if(record.getValue("select")){
					roles.push(record.getValue("roleId"));
					myselects[brno]=[];
					addRoles(myselects[brno],record.getValue("roleId"));
				}
				record=record.getNextRecord();
			}
			},200);*/
			//alert(roles.length+"----------ѡ��.."+brno);
			setTimeout(function(){
				var brno=bctlMngEntry_dataset.getValue("brno");
				var roles=getSelections();
				myselects[brno]=[];
				$.each(roles,function(i,r){
					addRoles(myselects[brno],r);
				});
			},200);
		}
	}
	
	
	
	function addRoles(array,val){
		if(!array){
			return;
		}
		var f=false;
		for(var i=0;i<array.length;i++){
			if(val==array[i]){
				f=true;
			}
		}
		if(!f){
			array.push(val);
		}
	}
	
	function getSelections(){
		var records=$("div.datagrid-view1 table[gridname=datatable2_tbody] tr.datagrid-row input[type=checkbox][name=select]");
		var recordRoles=$("div.datagrid-view2 table[gridname=datatable2_tbody] tr.datagrid-row td[field=roleId]");
		var cIndexs=[];
		$.each(records,function(i,r){
			if($(this).attr("checked")=="checked"){
				cIndexs.push(i);
			}
		});
		var roles=[];
		$.each(cIndexs,function(i,r){
			$.each(recordRoles,function(i2,r2){
				if(r==i2){
					roles.push($(this).text());
				}
			});
		});
		return roles;
	}
	//��λˢ��ʱ����ѡ
	function operMngRoleInfo_dataset_flushDataPost(){
		///ԭ��λ����
		//alert('��λˢ��'+JSON.stringify(myselects));
		var record=operMngRoleInfo_dataset.getFirstRecord();
		var brno=bctlMngEntry_dataset.getValue("brno");
		/*while(record){
			//���ڻ������úõĸ�λ��ӵ���ʱ�ֶ���
			if(record.getValue("select")){
				if(myselects[brno]==null){
					myselects[brno]=[];
				}
				addRoles(myselects[brno],record.getValue("roleId"));
			}
			record=record.getNextRecord();
		}
		var roles=getSelections();
		alert(roles.length);
		$.each(roles,function(i,r){
			addRoles(myselects[brno],r);
		});*/
		
		//ԭ���ݻ�ѡ����
		var record=operMngRoleInfo_dataset.getFirstRecord();
		while(record){
				var arr=myselects[brno];
				if(arr!=null&&brno==brcode){
					for(var k=0;k<arr.length;k++){

						if(arr[k]=='333'||arr[k]=='602'||arr[k]=='601'||arr[k]=='222'){
							if(arr[k]==record.getValue("roleId")){
								record.setValue("select","1");
							}
						}else if(arr[k]!='333'&&arr[k]!='602'&&arr[k]!='601'&&arr[k]!='222'){
							flag=true;
						}
					}
				}
			record=record.getNextRecord();
		}
	}
	 
	function initCallGetter_post(dataset) {
		loadDefaultConfig();
		
		if (op == "new") {
			operMngMod_dataset.setFieldReadOnly("tlrno",false);
			operMngMod_dataset.setValue('brcode',brcode);
		}else{
			operMngMod_dataset.setFieldReadOnly("tlrno",true);
		}
		operMngMod_dataset.setParameter("op",op);
		if(showRel!='1'){
			$('#tlrBctlRel').css('display','none');
		}
	}
	
	//��ʼ��
	function loadDefaultConfig(){
		DWREngine.setAsync(false);
		var tlrno=operMngMod_dataset.getValue('tlrno');
		TaskVariable.getUserAllOrg(tlrno,function(data){
			if(data!=null){
				myselects=data;
			}
			DWREngine.setAsync(true);
			bctlMngEntry_dataset.flushData(bctlMngEntry_dataset.pageIndex);
		});
	}
	
	function btRoleSave_onClickCheck(){
		var tlrno = operMngMod_dataset.getValue("tlrno");
		var tlrName = operMngMod_dataset.getValue("tlrName");
		var brcode = operMngMod_dataset.getValue('brcode');
		if (tlrno.length==0 || tlrName.length==0 ) {
			alert("����Ա�š�����Ա���ƺͷ�֧�����ű�����д��");
			return false;
		}
		var hasBctlSelected = false;
		var bctlRecord = bctlMngEntry_dataset.getFirstRecord();
		while(bctlRecord){
			var v_selected = bctlRecord.getValue("brno");
			if(v_selected){
				hasBctlSelected=true;
			}
			bctlRecord=bctlRecord.getNextRecord();
	   	}
	   	if (showRel=='1' && !hasBctlSelected) {
	   		alert("����ѡ��һ����Ȩ������");
	   		return false;
	   	}

	   	var hasRoleSelected = false;
		var roleRecord = operMngRoleInfo_dataset.getFirstRecord();
		while(roleRecord){
			var v_selected = roleRecord.getValue("select");
			if( v_selected == true ){
				hasRoleSelected=true;
			}
			roleRecord=roleRecord.getNextRecord();
	   	}
	   	if (!hasRoleSelected) {
	   		alert("����ѡ��һ����λ��");
	   		return false;
	   	}

	   	return true;
	}
	
	function btRoleSave_onClickCheck(){
		if(flag){
			alert("�޷��޸ľ���������λ��ɫ���û�����Ҫ���й���ԱȨ�ޣ�");
			return false;
		}
		operMngRoleInfo_dataset.setParameter("myselects", JSON.stringify(myselects));
	}
	
	function btRoleSave_postSubmit(){
		alert('����ɹ���');
		window.parent.closeSubWin();
	}
</script>
</@CommonQueryMacro.page>
