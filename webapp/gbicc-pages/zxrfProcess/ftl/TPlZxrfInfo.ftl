<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="��С�ڸ�  &gt;  �ҵ�����">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TPlZxrfInfo" init="false" submitMode="current">
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="�������ѯ����" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="registInfoBtn,btnUpt,checkBtn" fieldStr="loanAccount,custcode,custname,productName,productType,loanBalance,status"  width="100%" hasFrame="true"/>
		</td>
	</tr>
		<tr>
      	<td colspan="2">
  		</td>
  	</tr>
  		
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">
	//��λһ�м�¼
	function locate(id) {
		var record = TPlZxrfInfo_dataset.find(["id"],[id]);
		if(record) {
			TPlZxrfInfo_dataset.setRecord(record);
		}
	}
	
	 function btCancel_onClickCheck(button){
	     jobschedulermanage_dataset.cancelRecord();
	     subwindow_detailFW.close();
	  }  
	var tPlZxrfInfoWin;
	function registInfoBtn_onClick(button) {
		var businessId=TPlZxrfInfo_dataset.getValue("id");
		var custname=TPlZxrfInfo_dataset.getValue("custname");
		var title="��С�ڸ����󱨸�";
		tPlZxrfInfoWin=openSubWin("TPlZxrfInfoWin",title,"/gbicc-pages/zxrfProcess/ftl/TPlZxrfInfoWin.ftl?queryType=registBtn&id="+businessId,"1000","700");
	}

	var tPlZxrfInfoCheckWin;
	function checkBtn_onClick(button) {
		
		var businessId=TPlZxrfInfo_dataset.getValue("id");
		var custname=TPlZxrfInfo_dataset.getValue("custname");
		var title="���";
		tPlZxrfInfoCheckWin=openSubWin("TPlZxrfInfoCheckWin",title,"/gbicc-pages/zxrfProcess/ftl/TPlZxrfInfoCheckWin.ftl?id="+businessId,"1000","700");
	}
	
	function btnUpt_postSubmit(button) {
		TPlZxrfInfo_dataset.flushData(TPlZxrfInfo_dataset.pageIndex);
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TPlZxrfInfo_dataset.flushData(TPlZxrfInfo_dataset.pageIndex);
	}
	
</script>
</@CommonQueryMacro.page>