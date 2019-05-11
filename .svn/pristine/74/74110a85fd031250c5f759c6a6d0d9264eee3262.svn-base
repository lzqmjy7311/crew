<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign casesId=RequestParameters["casesId"]?default("")>
<#assign warningIds=RequestParameters["warningIds"]?default("")>
<#assign inveId=RequestParameters["inveId"]?default("")>

<@CommonQueryMacro.page title="单规则预警处置-发起协查">
<script type='text/javascript' src='${contextPath}/dwr/interface/upLoadNumsAjax.js'> </script>
<table>
	<tr>
		<td>
			<@CommonQueryMacro.GroupBox id="SingleRulWarningSelectBox" label="已选择的预警信号" expand="true">
				<@CommonQueryMacro.CommonQuery id="SingleRulWarningSelect" init="false" submitMode="current">
					<@CommonQueryMacro.DataTable id="SingleRulWarningSelectTable" readonly="true" paginationbar="" 
					fieldStr="warnCode[80],taskCode[110],rulType[100],rulName[150],rulDesc[150],warnStatus[100],warnDt[100],mainOrg[100]" width="100%" hasFrame="true"/>
				</@CommonQueryMacro.CommonQuery>
			</@CommonQueryMacro.GroupBox>
		</td>
	</tr>
</table>
<@CommonQueryMacro.CommonQuery id="SingleRulInvestigation" init="false" submitMode="current">
<div name='group1' class="group" style="width:98%">
   <table width="100%" class="grouptable" height="100%" style="table-layout: auto;">
    	<tr>
    		<td align="right" nowrap style="width:15%">
    			协查任务编号:
			</td>
			<td align="left" nowrap style="width:35%">
				<@CommonQueryMacro.SingleField fId="inveCode"/>
			</td>
			<td align="right" nowrap style="width:15%">
    			协查任务名称:
			</td>
			<td align="left" nowrap style="width:35%">
    			<@CommonQueryMacro.SingleField fId="inveName"/>
			</td>
    	</tr>
    	<tr>
    		<td>
    			&nbsp;
    		</td>
    	</tr>
    	<tr>
    		<td align="right" nowrap style="width:15%">
    			任务到期日:
			</td>
			<td align="left" nowrap style="width:35%">
				<@CommonQueryMacro.SingleField fId="matureDt"/>
			</td>
			<td align="right" nowrap style="width:15%">
    			协查人员:
			</td>
			<td align="left" nowrap style="width:35%">
    			<@CommonQueryMacro.SingleField fId="inveUser"/>
				<@CommonQueryMacro.SimpleButton id="btnSelect" desc="选择" icon="" plain="false" />
			</td>
    	</tr>
    	<tr>
    		<td>
    			&nbsp;
    		</td>
    	</tr>
    	<tr>
    		<td colspan='1' align="right" nowrap style="width:15%">
    			协查内容:
			</td>
			<td colspan='3' align="left" nowrap style="width:85%">
    			<@CommonQueryMacro.SingleField fId="inveCont"/>
			</td>
    	</tr>
     </table>
	协查任务说明：<a id="fupload" href="javascript:void()">浏览（<font id="Nums1"></font>）</a><br/>
	<center>
		<@CommonQueryMacro.Button id="btnSave" />
		<@CommonQueryMacro.Button id="btnSubmit" />
		<@CommonQueryMacro.Button id="btCancel" />
	</center>
</div>
</@CommonQueryMacro.CommonQuery>
<script>
	var readOnly="0";//默认可文件 上传
	var submitAllWindow=null;
	$("#fupload").linkbutton({"iconCls":"icon-upload"}).click(openUploadWin);
	function openUploadWin(){
		var businessId=SingleRulInvestigation_dataset.getValue("id");
		if(businessId){
			openSubWin("uploadFile", "附件管理","/gbicc-pages/upload/commonupload.ftl?relaID="+businessId+"&relaType=taskDesc&readOnly="+readOnly,null,400);
		}else{
			top.easyMsg.info("请保存基本信息后再上传附件！");
			return;
		}
	}
	//页面初始化
	function initCallGetter_post(){
		SingleRulInvestigation_dataset.setFieldReadOnly("inveCode",true);
		var nowDate=new Date();
		nowDate=nowDate.valueOf();
		nowDate=nowDate+15*24*60*60*1000;
		nowDate=new Date(nowDate);
		SingleRulInvestigation_dataset.setValue("matureDt",nowDate);
		var warningIds='${warningIds}';
		var inveId='${inveId}';
		SingleRulWarningSelect_dataset.setParameter("warningIds",warningIds);
		SingleRulWarningSelect_dataset.flushData(SingleRulWarningSelect_dataset.pageIndex);
		if(inveId!=""){
			SingleRulInvestigation_dataset.setParameter("id",inveId);
			SingleRulInvestigation_dataset.flushData(1);
		}
		var taskCheckFields=["inveFeedDt","inveConc"];
		setPageRequiredFieldsFun(taskCheckFields,false);
		
		var matureDt=SingleRulInvestigation_dataset.getValue("matureDt");
		if(!matureDt || matureDt==null || matureDt==""){
			TaskVariable.getSystemCurrentDate(5,function(y){
				SingleRulInvestigation_dataset.setValue("matureDt",y);
			});
		}
		showNums1();
	}
	//页面显示上传次数
	function showNums1(){
		var numsDom=document.getElementById('Nums1');
		numsDom.innerHTML="0";
		numsDom.setAttribute('color','black');
		var realId=SingleRulInvestigation_dataset.getParameter("id");
		var relaType="taskDesc";
		upLoadNumsAjax.getRuleNums(realId,relaType,function(result){
			if(result.flag=="true"){
				if(parseInt(result.nums)>0){
					numsDom.innerHTML=result.nums;
					numsDom.setAttribute('color','red');
				}
			}
		});
		//var inveConc=SingleRulInvestigation_dataset.getValue("inveConc");
		//SingleRulInvestigation_dataset.flushData();
		//SingleRulInvestigation_dataset.setValue("inveConc",inveConc);
	}
	function showNums2(){}
	//设置页面字段必填
	function setPageRequiredFieldsFun(fields,bool){
		for(var i=0;i<fields.length;i++){
			SingleRulInvestigation_dataset.setFieldRequired(fields[i],bool);
		}
	}
	//保存
	function btnSave_onClickCheck(){
		var casesId='${casesId}';
		var warningIds='${warningIds}';
		var inveOrg=SingleRulInvestigation_dataset.getValue("inveOrg");
		SingleRulInvestigation_dataset.setParameter("inveOrg",inveOrg);
		
		var inveUserId=SingleRulInvestigation_dataset.getParameter("inveUserId");
		SingleRulInvestigation_dataset.setParameter("inveUserId",inveUserId);
		
		SingleRulInvestigation_dataset.setParameter("casesId",casesId);
		SingleRulInvestigation_dataset.setParameter("warningIds",warningIds);
		SingleRulInvestigation_dataset.setParameter("op","saveInve");
	}
	//保存
	function btnSave_postSubmit(button){
		top.easyMsg.info("保存成功！");
		var id = button.returnParam.id;
		var inveUserId=SingleRulInvestigation_dataset.getParameter("inveUserId",inveUserId);
		SingleRulInvestigation_dataset.setParameter("inveUserId",inveUserId);
		SingleRulInvestigation_dataset.setParameter("id",id);
		SingleRulInvestigation_dataset.flushData(1);
		window.parent.singleRulInvestigation_flush_data();
	}
	//提交
	function btnSubmit_onClickCheck(){
		var casesId='${casesId}';
		var warningIds='${warningIds}';
		var inveOrg=SingleRulInvestigation_dataset.getValue("inveOrg",inveOrg);
		var inveUserId=SingleRulInvestigation_dataset.getParameter("inveUserId",inveUserId);
		var inveUser=SingleRulInvestigation_dataset.getValue("inveUser",inveUser);
		SingleRulInvestigation_dataset.setParameter("inveOrg",inveOrg);
		SingleRulInvestigation_dataset.setParameter("casesId",casesId);
		SingleRulInvestigation_dataset.setParameter("warningIds",warningIds);
		SingleRulInvestigation_dataset.setParameter("op","submitInve");
		if((inveUserId==""||inveUserId==null)&&(inveUser==""||inveUser==null)){
			top.easyMsg.info("请选择协查人员！");
			return false;
		}
	}
	function btnSubmit_postSubmit(button){
		window.parent.investigationWin_and_parWin_close();
	}
	//取消
	function btCancel_onClick(){
		window.parent.investigationWin_close();
	}
	function btnSelect_onClick(button){
		submitAllWindow=openSubWin("submitAllWindow","协查人员选择","/gbicc-com-pages/single/ftl/single_rul_cases_investigation.ftl","1100","550");
	}
	//回调函数
	function SubmitInveOrgAndInveUserId(inveOrg,inveUserId,tlrName){
		SingleRulInvestigation_dataset.setValue("inveUser",tlrName);
		SingleRulInvestigation_dataset.setValue("inveOrg",inveOrg);
		SingleRulInvestigation_dataset.setParameter("inveOrg",inveOrg);
		SingleRulInvestigation_dataset.setParameter("inveUserId",inveUserId);
		submitAllWindow.close();
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>