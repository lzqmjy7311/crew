<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="���չ���  &gt;  �ҵ�����">
<@CommonQueryMacro.CommonQuery id="TCollectionInfoSelect" init="true" submitMode="current">
			<@CommonQueryMacro.Interface id="interface" label="�������ѯ����"  showButton="false"/>
			<center>
				<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
			</center>
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="registInfoBtn" fieldStr="loanAccount[120],custCode[100],custName[60],productName[140],riskStatus[70],loanBalance[70],arrearAmt[70],arrearInterests[70],arrearCount[80],matureDate[90],collectionType[140],status[60]"  width="100%" hasFrame="true"/>
</@CommonQueryMacro.CommonQuery>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script language="JavaScript">
	//���ò�ѯ����
	function btnReset_onClick(button){
		TCollectionInfoSelect_interface_dataset.clearData();
	}
	//��λһ�м�¼
	function locate(id) {
		var record = TCollectionInfoSelect_dataset.find(["id"],[id]);
		if(record) {
			TCollectionInfoSelect_dataset.setRecord(record);
		}
	}
	
	 function btCancel_onClickCheck(button){
	     jobschedulermanage_dataset.cancelRecord();
	     subwindow_detailFW.close();
	  }  
	var TCollectionInfoSelectWin;
	var TCollectionInfoSelectCheckWin;
	function registInfoBtn_onClick(button) {
		var businessId=TCollectionInfoSelect_dataset.getValue("id");
		if(businessId){
			var custName=TCollectionInfoSelect_dataset.getValue("custName");
			var loanAccount=TCollectionInfoSelect_dataset.getValue("loanAccount");
			var title="�鿴";
			TCollectionInfoSelectWin=openSubWin("TCollectionInfoSelectWin",title,"/gbicc-pages/collectionManageSelect/ftl/TCollectionInfoSelectWin.ftl?id="+businessId+"&businessId="+businessId,"1000","700");
		}else{
			top.easyMsg.info("��ѡ��һ�У�");
		}
	}
	function datatable1_onDbClick(){
		registInfoBtn.click();
	}

	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TCollectionInfoSelect_dataset.flushData(TCollectionInfoSelect_dataset.pageIndex);
	}
	
</script>
</@CommonQueryMacro.page>