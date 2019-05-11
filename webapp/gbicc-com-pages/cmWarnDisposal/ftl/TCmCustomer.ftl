<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="预警处置  &gt;  我的任务">
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TCmCustomerList" init="true" submitMode="current">
<script type='text/javascript' src='${contextPath}/dwr/interface/TCmWarnDisposalAjax.js'> </script>
<table width="100%">
	<tr>
		<td colspan="2" valign="top">
			<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" showButton="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center" style="margin-bottom:10px">
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</div>
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" frozens="20" paginationbar="selectTheCust" fieldStr="custcode[100],custname[200],custWarnLevel[100],loanAmount[100],loanBalance[100]"  width="100%" hasFrame="true"/>
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
//重置查询条件
function btnReset_onClick(button){
	TCmCustomerList_interface_dataset.clearData();
}
function selectTheCust_onClick(button) {
		var customerId = TCmCustomerList_dataset.getValue("id");
		if(customerId){
			
		}else{
			top.easyMsg.info("请选择一个客户！");
			return;
		}
	top.easyMsg.confirm("是否确认发起该客户预警?", function(){
		TCmWarnDisposalAjax.personStartDC(customerId,function(y){
			 if(y.success=="true"){//
				parent.parent.parent.GTab.addTab("warnDisposalWin","【预警处置】","/gbicc-com-pages/cmWarnDisposal/ftl/personWarnDisposalWin.ftl?taskId="+y.taskId+"&customerId="+y.customerId+"&businessId="+y.taskId);
			 }else{
				 top.easyMsg.info(y.message);
			 }
			   
			
		});
    }, function(){
        top.easyMsg.info("取消");
    } );
}

</script>
</@CommonQueryMacro.page>
