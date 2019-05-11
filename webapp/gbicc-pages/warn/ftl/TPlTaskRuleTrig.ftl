<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="Ԥ���������񴥷�����">
<@CommonQueryMacro.CommonQuery id="TPlTaskRuleTrig" init="true" submitMode="current" navigate="false">

<table align="left" width="100%">

    <tr>
		<td>
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"   paginationbar="rgyjReportUpd"  fieldStr="accId[120],custname,ruleCode,ruleName[190],ruleDesc,ruleRank,ruleType,ruleFor,trigDate,trigType,processDate"     readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">


   //����ȷ��
  	function rgyjReportUpd_onClickCheck(button) {
  	    var accId=TPlTaskRuleTrig_dataset.getValue("accId");
  	    var ruleCode=TPlTaskRuleTrig_dataset.getValue("ruleCode");
	    var trigId=TPlTaskRuleTrig_dataset.getValue("id");
  	    DWREngine.setAsync(false);
  	    if(accId==null){
  	      top.easyMsg.info("��ѡ����Ҫ�˹�����Ԥ�����ñ����ļ�¼��");	             
  	      return false;
  	      
  	    }
  	    bool=true;
		TaskVariable.isProcessingByAccid(accId,ruleCode,trigId,function(y){
		   if(y){
			  bool=false;	      
		   }
		});
		if(!bool){
			 top.easyMsg.error("�ü�¼�ѳ���Ԥ�����ñ��沢���������У�");	
			return false;
		}else{
			 return confirm("ȷ���Ƿ��˹�����������¼��ӦԤ�����ñ��棿");
		}
       DWREngine.setAsync(true);		
	}
	//ɾ����ˢ�µ�ǰҳ
	function rgyjReportUpd_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("�˹�����Ԥ������ɹ���");
		flushCurrentPage();
	}
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		TPlTaskRuleTrig_dataset.flushData(TPlTaskRuleTrig_dataset.pageIndex);
	}


</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>