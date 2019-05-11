<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<@CommonQueryMacro.page title="��;���">
	<@CommonQueryMacro.CommonQuery id="YtMonitorAcctView" init="true" submitMode="current" >
		<@CommonQueryMacro.Interface id="interface1" label="�������ѯ����" colNm=6  showButton="false" />
		<tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.InterfaceButton desc="��ѯ"  />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
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
			alert('�ύ�ɹ�');
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
				top.easyMsg.confirm("�����û���ر������̣��Ƿ�ȷ��?", function(){
					YtMonitorAcctView_dataset.setParameter("duebillno",record.getValue("duebillno"));
					BtnSave.click();
                }, function(){
                } );
			}
		}
	</script>
</@CommonQueryMacro.page>