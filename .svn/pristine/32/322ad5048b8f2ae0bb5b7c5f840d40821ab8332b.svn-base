<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="逾期清单  &gt; 工作台">
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<table align="left"><tr><td>
<@CommonQueryMacro.CommonQuery id="TEdwPlsAccount" init="true" submitMode="current">
<table width="100%">
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="" fieldStr="loanacno[100],custid[80],prodname[140],tcapi[70],tterm[50],bal[70],overbal[70],overinte[70],overStartDate[70],begindate[70],enddate[70]"  width="100%" hasFrame="true"/>
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

/*
	function moreHandle_onClick(){
		parent.parent.parent.GTab.addTab('TCollectionInfo_DESK',"催收管理",'	/gbicc-pages/collectionManage/ftl/TCollectionInfo.ftl?flag=desk');
	}
	
	function registInfoBtn_onClick(button) {
		var businessId=TCollectionInfo_dataset.getValue("id");
		if(businessId){
			TaskVariable.findTaskVariable(businessId,function(y){
				var title="审核";
					var custName=TCollectionInfo_dataset.getValue("custName");
					var loanAccount=TCollectionInfo_dataset.getValue("loanAccount");
				if(y.nowRoleName=="ejzhhz"){
					title="审核";
					//tCollectionInfoCheckWin=openSubWin("TCollectionInfoCheckWin",title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoCheckWin.ftl?id="+businessId,"1000","700");
					parent.parent.parent.GTab.addTab('TCollectionInfoCheckWin',title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?id="+businessId);
					//tCollectionInfoWin=openSubWin("TCollectionInfoWin",title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?id="+businessId,"1000","700");
				}else{
					title="催收登记";
					parent.parent.parent.GTab.addTab('TCollectionInfoCheckWin',title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?queryType=registBtn&id="+businessId);
					//tCollectionInfoWin=openSubWin("TCollectionInfoWin",title,"/gbicc-pages/collectionManage/ftl/TCollectionInfoWin.ftl?queryType=registBtn&id="+businessId,"1000","700");
				}
				
			});
		}else{
			top.easyMsg.info("请选择一行！");
		}
	}
	*/
</script>
</@CommonQueryMacro.page>