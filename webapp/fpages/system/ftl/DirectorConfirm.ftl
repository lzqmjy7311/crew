<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#--jianxue.zhang-->
<@CommonQueryMacro.page title="����ȷ��">
<table width="90%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="UndoConfirm" init="true" submitMode="current">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="�������ѯ����" colNm=4 showButton="true" />
        	</td>
        </tr>
		<tr>
   			<td colspan="2">
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>

  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btDo,-,btSee" fieldStr="select,id,intInsId,updTransCd,intOperId,insCd,crtDt" width="100%"  readonly="true"/></br>
        	</td>
        </tr>

   </table>
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>

<script language="javascript" src="${contextPath}/templets/ui/js/topTsk.js"></script>
 <script language="javascript">
function initCallGetter_post() {
	 var intInsId = "${RequestParameters["intInsId"]?default('')}";
	 if(intInsId!=null && intInsId.length>0){
	 	UndoConfirm_interface_dataset.setValue("intInsId", intInsId);
	 	UndoConfirm_dataset.flushData(UndoConfirm_dataset.pageIndex);
	 }
 }

//��λһ����¼
function locate(id) {
	var record = UndoConfirm_dataset.find(["id"],[id]);
	if (record) {
		UndoConfirm_dataset.setRecord(record);
	}
}
//��id�б�ɳ�����,��Ҫ��¼����,����˵��,ԭ��¼����,��¼����
//TODO
 function datatable1_id_onRefresh(cell, value, record){
	if(record){
		var type = record.getValue("intInsId");
		var sta = record.getValue("updTransCd");
		var rcdpk = record.getValue("adtRcdPk");
		cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:detail.showUodoTaskDetail('"+type+"','"+sta+"','"+rcdpk+"')\">"+value+"</a>";
	}else{
		cell.innerHTML = "";
	}
}
//���������ť�ļ��,��Ҫ������,ҵ������,
function btDo_onClickCheck(button){
	var record = UndoConfirm_dataset.firstUnit;
	var chk=0;
	var bizArr = new Array();
	var taskIdArr = new Array();
	while(record){
		var temp = record.getValue("select");
		if(temp){
			bizArr[chk] = record.getValue("intInsId");
			taskIdArr[chk] = record.getValue("id");
			chk++;
		}
		record=record.nextUnit;
	}
	if(chk==0){
		alert("��ѡ��Ҫ�����ļ�¼!");
		return false;
	}

	var type = bizArr[0];
	for(var i=1;i<bizArr.length;i++){
		if(type!=bizArr[i]){
			alert("��ѡ����ͬҵ��������а���!");
			return false;
		}
	}
	//�����񼯺Ϻ�ҵ�����ʹ���ȥ
	button.url = approve.getApprovePage(taskIdArr,type);
	return true;
}

</script>

</@CommonQueryMacro.page>