<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="预警处置任务触发规则">
<@CommonQueryMacro.CommonQuery id="TPlTaskRuleTrigAll" init="true" submitMode="current" navigate="false">
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	    <@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm=6 showButton="false"/>
			<center>
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</center>
			<@CommonQueryMacro.DataTable id ="datatable1"  height="560"  paginationbar="rgyjReportUpd"  fieldStr="accId[150],custname,productName[180],loanPeriod[80],operator[100],operBank[150],ruleName[190],ruleRank,ruleType,trigDate,trigType"     readonly="true" width="100%"/></br>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	//重置查询条件
	function btnReset_onClick(button){
		TPlTaskRuleTrigAll_interface_dataset.clearData();
	}
   //触发确认
  	function rgyjReportUpd_onClickCheck(button) {
  	    var accId=TPlTaskRuleTrigAll_dataset.getValue("accId");
  	    var ruleCode=TPlTaskRuleTrigAll_dataset.getValue("ruleCode");
  	    var trigId=TPlTaskRuleTrigAll_dataset.getValue("id");
  	    
  	    DWREngine.setAsync(false);//设置同步
  	    if(accId==null){
  	      top.easyMsg.info("请选择需要人工触发预警处置报表的记录！");	             
  	      return false;
  	      
  	    }
  	    bool=true;
  	    //判断是否在流程中
//		TaskVariable.isProcessingByAccid(accId,ruleCode,trigId,function(y){
//			
//		   if(y){
//			  bool=false;	      
//		   }
//		});
//		if(!bool){
//			 top.easyMsg.error("该记录已出发预警处置报告并且在流程中！");	
//			return false;
//		}else{
			 return confirm("确认是否人工触发该条记录对应预警处置报告？");
//		}
       DWREngine.setAsync(true);		
	}
	//删除后刷新当前页
	function rgyjReportUpd_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("人工触发预警报告成功！");
		flushCurrentPage();
	}
	//刷新当前页
	function flushCurrentPage() {
		TPlTaskRuleTrigAll_dataset.flushData(TPlTaskRuleTrigAll_dataset.pageIndex);
	}


</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
</@CommonQueryMacro.page>
