<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="用户登录日志查询">
<#assign jzyear=RequestParameters["jzyear"]?default("")>
<#assign caliber=RequestParameters["caliber"]?default("")>
<#assign repno=RequestParameters["repno"]?default("")>
<#assign finType=RequestParameters["finType"]?default("")>
<style>
div.form1{
    width:30px;height:10px;
	text-align:left;
	color:blue;
	background-color:gray;
	font-size:100%;
	}

span.style1{
	color:blue;
	background-color:gray;
	font-size:150%;
}
</style>
<@CommonQueryMacro.CommonQuery id="TbCsmFinanceStatementData" init="false" submitMode="current" navigate="false">
<span id='title2'  class="style1"> </span>
<table align="left" width="100%">


	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatablefincour" fieldStr="financeStatementName,科目值{projectValue|sProjectValue|ssProjectValue|projectAddValue}" readonly="true" height="260"  width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	var jzyear='${jzyear}';
	var caliber='${caliber}';
	var repno='${repno}';
//页面初始化
	function initCallGetter_post(){
	 TbCsmFinanceStatementData_dataset.setParameter("jzyear",jzyear);
	 TbCsmFinanceStatementData_dataset.setParameter("caliber",caliber);
	 TbCsmFinanceStatementData_dataset.setParameter("repno",repno);
	 TbCsmFinanceStatementData_dataset.flushData(TbCsmFinanceStatementData_dataset.pageIndex);
	}
	function TbCsmFinanceStatementData_dataset_flushDataPost(dataset){
		var chineseName =TbCsmFinanceStatementData_dataset.getValue('chineseName');
		if(chineseName==null||chineseName==''){

		}else{
			var kj='';
			if(caliber==707){
				kj='年报';
			}else if(caliber==708){
				kj='半年报';
			}else if(caliber==709){
				kj='季报';
			}else if(caliber==710){
				kj='月报';
			}
//			var title='>>财务比较分析-展示结果（'+chineseName+'  '+jzyear+'年 '+repno+'期 ' + kj+' ）';
//			document.getElementById('title2').innerText=title;  //插入到span 
		}
	}


</script>
</@CommonQueryMacro.page>
