<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign taskId=RequestParameters["taskId"]?default("")>
<#assign customerId=RequestParameters["customerId"]?default("")>
<@CommonQueryMacro.page title="预警处置  &gt;  我的任务">
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TCmWarnDisposalAjax.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/upLoadNumsAjax.js'> </script>

	<table style="width: 100%">
		<tr>
			<td>
			<center>
				<span style="padding:7px 0 0  0;">
					<a id="readFinaAnal" onclick="readFinaAnal_onClick()"  href="javascript:void(0)">查看风险视图</a>
					<a id="readFinaInte" onclick="readFinaInte_onClick()" href="javascript:void(0)">查看财务分析</a>
					<a id="readFundMoni" onclick="readFundMoni_onClick()" href="javascript:void(0)">查看财务诚信度</a>
					<a id="readZHReport" onclick="readZHReport_onClick()" href="javascript:void(0)">总行视图</a>
				</span>
				</center>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmCustomer" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="group2" label="基本信息" colNm=4
					fieldStr="taskCode,custcode,custname,loanAmount,loanBalance,businessCode,legalRep,operBankNam,operatorNam"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TCmWarnTaskRel" init="true" submitMode="all">	
					<@CommonQueryMacro.GroupBox id="box1" label="预警信息">
						<@CommonQueryMacro.DataTable id="warnSignalTabled" paginationbar="lookBtn" pagination="true" 
			             fieldStr="warnCode,warnLevel,warnSubject,warnName,warnStatus,warnDate,riskDesc" width="100%" hasFrame="true"/>
		           <@CommonQueryMacro.FloatWindow id="warnSignalFW" modal="true" label="预警情况"  position="center"
							resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
								<table style="width: 100%"><tr><td>
								<@CommonQueryMacro.Group id="group3" label="" colNm=4
								fieldStr="warnCode,warnLevel,warnSubject,warnName,warnDate,riskDesc,dddd,dddd"/>
							<center>
							<@CommonQueryMacro.Button id="warnSignalConfirm" />
							</center>
							</td></tr></table>
					    </@CommonQueryMacro.FloatWindow>
		           </@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TRulDefinitionList" init="true" submitMode="all">	
						<@CommonQueryMacro.FloatWindow id="TRulDefinitionWin" modal="true" label="定性规则选择"  position="center"
							resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
							<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
					<@CommonQueryMacro.DataTable id="TRulDefinitionTable" paginationbar="ruleAddBtn" pagination="true" 
			             fieldStr="ruleCode,ruleName" width="100%" hasFrame="true"/>
					    </@CommonQueryMacro.FloatWindow>	
							</td></tr></table>
					
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="false" submitMode="current">
				<@CommonQueryMacro.Group id="group4" label="预警核查信息" colNm=4 fieldStr="inspectorsNam,inspeCitDate,inspeMethod,inspeDate,inspeInfo,contMeasure,contOth,contDesc"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="group5" label="预警处置信息" colNm=4 fieldStr="disposalPerNam,disposalDate,dispoCitDate,disposalInfo"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="group6" label="其他信息" colNm=4 fieldStr="isContinue,overRc,dddd,dddd"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<div name="group9" class="group" noextra="true">
				<h5 noextra="true">附件</h5>
				<center style="padding-top: 5px;padding-bottom: 10px;">
					<a id="fupload" href="javascript:void()">上传/下载（<font id="Nums"></font>）</a>
				</center>
			</div>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistorySelectAll" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="box2" label="审批历史">
						<@CommonQueryMacro.DataTable id="TaskApprovalHistorySelectAllTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="TaskApprovalHistorySelectAllFW" modal="true" label="查看意见" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
							<@CommonQueryMacro.Group id="TaskApprovalHistorySelectAllGroup" label="" colNm=4 fieldStr="opinion"/>
							</td></tr></table>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		
	</table>

<script language="JavaScript">
var roleName="aa";
var isShowSubmitNext=false;
function initCallGetter_post(dataset) {
	//document.getElementsByTagName("div").group44.firstChild.remove();
	//document.getElementsByTagName("div").group2.firstChild.remove()
	//document.getElementsByTagName("table")[12].childNodes[1].childNodes[0].childNodes[3].style.cssText="width: 200px";
    var businessId='${taskId}';
    TCmWarnTask_dataset.setParameter("flag","true");
    TCmWarnTask_dataset.flushData();
    TCmWarnTask_dataset.setParameter("flag","");
  //根据角色，显示或者隐藏按钮
	TaskVariable.findTaskVariable(businessId,function(y){
		var taskType=TCmWarnTask_dataset.getValue("taskType");
		roleName=y.nowRole;

		if(roleName=="khjl"){//客户经理
			readOnly="1";//默认不可文件 上传
			setAllReadOnlyFun()
			if(taskType){
				if(taskType=="RC"){
					setPageReadOnlyFun();
					TCmWarnTask_dataset.setFieldHidden("isContinue",true);
					TCmWarnTask_dataset.setFieldReadOnly("overRc",false);
				}else{
					$("div[name=group6]").hide();
					$("div[name=group5]").hide();
				}
			}else{
				$("div[name=group6]").hide();
			}
			$("span[name=warnTaskEnd]").hide();
		}else{
			setPageReadOnlyFun();
			if(taskType=="RC"){
				TCmWarnTask_dataset.setFieldHidden("isContinue",true);
				$("span[name=warnTaskEnd]").hide();
			}else{
				TCmWarnTask_dataset.setFieldHidden("overRc",true);
				$("div[name=group5]").hide();
			}
		}
		if(taskType=="DC"){
			if(y.canAddProcess=="false"||y.canAddProcess==undefined){
				TCmWarnTask_dataset.setFieldReadOnly("isContinue",true);
			}else{
				TCmWarnTask_dataset.setFieldReadOnly("isContinue",false);
			}
			if(y.showAP=="false"){
				$("div[name=group6]").hide();
			}
		}else{
			TCmWarnTask_dataset.setFieldHidden("isContinue",true);
		}
		
		if(roleName=="khjlqr"){//客户经理确认
			$("span[name=warnTaskEnd]").hide();
		}
		if(roleName!="zhfxjc"&&roleName!="zhfxjczg"){
		  	$("a[id=readZHReport]").hide();
	  	}else{
		  	TCmWarnTask_dataset.setFieldReadOnly("isContinue",true);
	  	}
	});
	
	var contMeasure=TCmWarnTask_dataset.getValue("contMeasure");
	if(contMeasure){
		if(contMeasure.indexOf("SS")>-1){
			TCmWarnTask_dataset.setFieldHidden("contOth",false);
		}else{
			TCmWarnTask_dataset.setFieldHidden("contOth",true);
		}
	}else{
		TCmWarnTask_dataset.setFieldHidden("contOth",true);
	}
	//添加于2016-06-30
	//页面显示上传次数
	showNums();
	
}
//添加于2016-06-30
//页面显示上传次数
function showNums(){
	var numsDom=document.getElementById('Nums');
	numsDom.innerHTML="0";
	numsDom.setAttribute('color','black');
	var realId='${taskId}';
	upLoadNumsAjax.getNums(realId,function(result){
		if(result.flag=="true"){
			if(parseInt(result.nums)>0){
				numsDom.innerHTML=result.nums;
				numsDom.setAttribute('color','red');
			}
		}
	});
}
function setAllReadOnlyFun(){
	var fieldName="";
	TCmWarnTask_dataset.setFieldReadOnly("taskCode",true);
	TCmWarnTask_dataset.setFieldReadOnly("warnLevel",true);
	TCmWarnTask_dataset.setFieldReadOnly("inspectors",true);
	TCmWarnTask_dataset.setFieldReadOnly("inspeCitDate",true);
	//禁用客户管理
	for(var i=0;i<TCmCustomer_dataset.fields.length;i++){
		fieldName=TCmCustomer_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmCustomer_dataset.setFieldReadOnly(fieldName,true);
		}
	}
}
//设置页面所有字段只读
function setPageReadOnlyFun(){
	var fieldName="";
	for(var i=0;i<TCmWarnTask_dataset.fields.length;i++){
		fieldName=TCmWarnTask_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmWarnTask_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	//禁用客户管理
	for(var i=0;i<TCmCustomer_dataset.fields.length;i++){
		fieldName=TCmCustomer_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmCustomer_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	//禁用预警信息
	for(var i=0;i<TCmWarnTaskRel_dataset.fields.length;i++){
		fieldName=TCmWarnTaskRel_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmWarnTaskRel_dataset.setFieldReadOnly(fieldName,true);
		}
	}
}
function initSel(val,selId){
    if(val!=null && val.length>0){
        var obj = document.getElementById(selId);
        var vals = val.split(";");
        for(var i=0;i<vals.length;i++){
            var tmp = vals[i];
            if(tmp!=null && tmp.length>0){
                var tmps = tmp.split("=");
                var opt = null;
                if(tmps.length>1){
                    opt = new Option(tmps[1],tmps[0]);
                }else{
                    opt = new Option(tmps[0],tmps[0]);
                }
                obj.options.add(opt);
            }
        }
    }
}
function moveOption(obj1, obj2){
	for(var i = obj1.options.length - 1 ; i >= 0 ; i--){
		if(obj1.options[i].selected){
			var opt = new Option(obj1.options[i].text,obj1.options[i].value);
			obj2.options.add(opt);
			obj1.remove(i);
		}
	}
}

function TCmWarnTask_dataset_onSetValue(ds,curretField,val){
	if((curretField.name=="contmeasure"||curretField.name=="contmeasurename")){
		if(val.indexOf("SS")>-1){
			TCmWarnTask_dataset.setFieldHidden("contOth",false);
		}else{
			TCmWarnTask_dataset.setFieldHidden("contOth",true);
		}
	}
	return val;
}
//查看意见
function btnOpinion_onClick(button){
	subwindow_TaskApprovalHistorySelectAllFW.show();
}
var selectWarnWin;
function selectCustomerWin_close(){
	selectWarnWin.close();
}



function lookBtn_onClick(button){
	var fieldName="";
	//禁用预警信息
	for(var i=0;i<TCmWarnTaskRel_dataset.fields.length;i++){
		fieldName=TCmWarnTaskRel_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmWarnTaskRel_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	subwindow_warnSignalFW.show();
}
function warnSignalConfirm_onClick(button){
	subwindow_warnSignalFW.close();
}


function openUploadWin(){
	openSubWin("uploadFile", "附件管理", 
		"/gbicc-pages/upload/commonupload.ftl?relaID=${taskId}&relaType=11&readOnly=1",
	null,400);
}
$("#fupload").linkbutton({"iconCls":"icon-upload"}).click(openUploadWin);
function readFinaAnal_onClick(){
	var customerNum =TCmCustomer_dataset.getValue("custcode");
	var chineseName =TCmCustomer_dataset.getValue("custname");
	var loanCardNum =TCmCustomer_dataset.getValue("loanAccount");
	var paramMap=new Map();
	paramMap.put("customerNum",customerNum);
	paramMap.put("chineseName",chineseName);
	parent.parent.GTab.addTab("warninfoWin", "客户风险视图\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName, "/gbicc-com-pages/riskview/ftl/riskView.ftl?customerNum="+customerNum+"&chineseName="+encodeURI(encodeURI(chineseName))+"&loanCardNum="+loanCardNum);
}
function readFinaInte_onClick(){
	var customerNum =TCmCustomer_dataset.getValue("custcode");
	var chineseName =TCmCustomer_dataset.getValue("custname");
	var paramMap=new Map();
	paramMap.put("customerNum",customerNum);
	paramMap.put("chineseName",chineseName);
	parent.parent.GTab.addTab("warninfoWin2", "财务分析\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName, "/gbicc-com-pages/FinanciaAnalysis/ftl/FinanceAnalysis.ftl?customerNum="+customerNum+"&chineseName="+chineseName);
}
function readFundMoni_onClick(){
	var customerNum =TCmCustomer_dataset.getValue("custcode");
	var chineseName =TCmCustomer_dataset.getValue("custname");
	parent.parent.GTab.addTab("warninfoWin3", "财务诚信度\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName,"/gbicc-com-pages/financialIndexAnalsis/ftl/financialIndexAnalsis.ftl?customerNum="+customerNum+"&chineseName="+chineseName);
}
function readZHReport_onClick(){
	alert("此功能暂未开发！");
}
function TaskApprovalHistorySelectAllTable_onDbClick(){
	btnOpinion.click();
}
</script>
</@CommonQueryMacro.page>
