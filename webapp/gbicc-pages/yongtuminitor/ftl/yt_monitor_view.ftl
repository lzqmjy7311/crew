<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<@CommonQueryMacro.page title="用途监控">
	<@CommonQueryMacro.CommonQuery id="YtMonitorAcctView" init="true" submitMode="current" >
		<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm=6  showButton="false" />
		<tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.InterfaceButton desc="查询"  />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
				</div>
			</td>
		</tr>
		
		<@CommonQueryMacro.DataTable id="datatable"     paginationbar="BtnAdd"  readonly="true"  fieldStr="duebillno,begindate,contno,loanacno,prodName,custid,custname,tcapi,tterm,busitype,operName,bankName" />
		<div style="display:none;">
	  		<@CommonQueryMacro.Button id="BtnSave"/>
		</div>
	</@CommonQueryMacro.CommonQuery>
	
	<script>
		function BtnSave_postSubmit(){
			alert('提交成功');
		}
		
		function btnReset_onClick(button){
			YtMonitorAcctView_interface_dataset.clearData();
		}
	
		function datatable_onDbClick(){
			BtnAdd_onClick();
		}
	
		function BtnAdd_onClick(){
			var record=(YtMonitorAcctView_dataset.record);
			if(record){
				top.easyMsg.confirm("发起用户监控报告流程，是否确认?", function(){
					YtMonitorAcctView_dataset.setParameter("duebillno",record.getValue("duebillno"));
					BtnSave.click();
                }, function(){
                } );
			}
		}
	</script>
</@CommonQueryMacro.page>