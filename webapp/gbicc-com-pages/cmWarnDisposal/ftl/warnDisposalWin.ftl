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
						<@CommonQueryMacro.DataTable id="warnSignalTabled" paginationbar="lookBtn,disposalBtn" pagination="true" 
			             fieldStr="warnCode[70],warnLevel[70],warnSubject[100],warnName[220],warnDesc[250],warnDate[100],warnStatus[70],warnElimIs[70],warnElimDesc[200]" width="100%" hasFrame="true"/>
		           <@CommonQueryMacro.FloatWindow id="warnSignalFW" modal="true" label="预警情况"  position="center"
							resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
							<table style="width: 100%"><tr><td>
								<@CommonQueryMacro.Group id="group3" label="" colNm=4
								fieldStr="warnCode,warnLevel,warnSubject,warnName,warnDesc,warnStatus,warnDate,warnElimIs,warnElimDesc,dddd,dddd"/>
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
				<@CommonQueryMacro.DynamicTabSet id="BusinInfoTab" hasMenu="false" fit="true" height="350" selected="A01">
			    </@CommonQueryMacro.DynamicTabSet>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
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
			<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="group7" label="流程退回/提交" colNm=4 fieldStr="opinionResult,backPerson,opinion,dddd,dddd"/>
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
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
				<center>
					<@CommonQueryMacro.Button id= "warnTaskSubmit" />
					<@CommonQueryMacro.Button id= "btnSubmit" />
					<@CommonQueryMacro.Button id= "warnTaskSave" />
					<span name="warnTaskEnd">
					<@CommonQueryMacro.Button id= "warnTaskEnd" />
					</span>
				</center>
				</@CommonQueryMacro.CommonQuery>
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
var readOnly="0";//默认不可文件 上传
var nextRole="";
/**
 * 添加于20160805
 */
//列表刷新触发
function warnSignalTabled_warndesc_onRefresh(cell,value,record) {
	if (record) {//当存在记录时
		if(record.getValue("warnCode")=="CW015" && record.getValue("warnDesc").indexOf("实际主营业务利润")>-1){
			var str=record.getValue("warnDesc").replace("实际主营业务利润","<a href='#' title='报表主营业务利润扣除管理、财务及营业费用'>实际主营业务利润</a>");
			str=str.replace("利润总额","<a href='#' title='报表主营业务利润+其它业务利润+补贴收入'>利润总额</a>");
			cell.innerHTML=str;
		}else if(record.getValue("warnCode")=="CW001" && record.getValue("warnDesc").indexOf("我行贷款余额")>-1){
			var str=record.getValue("warnDesc").replace("我行贷款余额","<a href='#' title='客户在我行所有未结清的纯贷款的余额之和'>我行贷款余额</a>");
			str=str.replace("财报借款科目之和","<a href='#' title='长期借款、短期借款、1年内到期的长期借款三个科目的余额之和'>财报借款科目之和</a>");
			cell.innerHTML=str;
		}else if(record.getValue("warnCode")=="CW002" && record.getValue("warnDesc").indexOf("财报借款科目之和")>-1){
			var str=record.getValue("warnDesc").replace("财报借款科目之和","<a href='#' title='长期借款、短期借款、1年内到期的长期借款三个科目的余额之和'>财报借款科目之和</a>");
			cell.innerHTML=str;
		}else if(record.getValue("warnCode")=="CW014" && record.getValue("warnDesc").indexOf("短期融资")>-1){
			var str=record.getValue("warnDesc").replace("短期融资","<a href='#' title='短期借款+应付票据'>短期融资</a>");
			cell.innerHTML=str;
		}else{
			cell.innerHTML=record.getValue("warnDesc");
		}
	} 
};

function initCallGetter_post(dataset) {
	$("a[id=warnTaskSubmit]").hide();
	var businessId='${taskId}';
  //根据角色，显示或者隐藏按钮
	TaskVariable.findTaskVariable(businessId,function(y){
		var taskType=TCmWarnTask_dataset.getValue("taskType");
		roleName=y.nowRole;
		nextRole=y.nextRole;
		if(roleName=="khjl"){//客户经理
			//默认不可文件 上传
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
			$("div[name=group7]").hide();
			$("span[name=warnTaskEnd]").hide();
			TCmWarnTask_dataset.setFieldReadOnly("disposalDate",false);
			TCmWarnTask_dataset.setFieldReadOnly("dispoCitDate",false);
			TCmWarnTask_dataset.setFieldReadOnly("disposalInfo",false);
			
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
			if(y.canAddProcess=="false"){
				TCmWarnTask_dataset.setFieldReadOnly("isContinue",true);
			}else{
				TCmWarnTask_dataset.setFieldReadOnly("isContinue",false);
			}
			if(y.showAP=="false"){
				$("div[name=group6]").hide();
			}
			var isSubmitNextss=TCmWarnTask_dataset.getValue("isSubmitNext")
			if(isSubmitNextss=="1"){
				if(roleName!="zhfxjc"&&roleName!="zhfxjczg"){
					$("div[name=group6]").hide();
			  	}
			}
		}else{
			TCmWarnTask_dataset.setFieldHidden("isContinue",true);
		}
		
		if(roleName=="khjlqr"){//客户经理确认
			$("div[name=group7]").hide();
			$("span[name=warnTaskEnd]").hide();
			$(btnSubmit).context.innerHTML="<span class=\"l-btn-left\"><span class=\"l-btn-text icon-ok\" style=\"padding-left:20px\">确认完成</span></span>";
			$(warnTaskSubmit).context.innerHTML="<span class=\"l-btn-left\"><span class=\"l-btn-text icon-ok\" style=\"padding-left:20px\">确认完成</span></span>";
			//$("a[id=warnTaskSave]").attr('disabled',true);
			warnTaskSave.disable(true);
			readOnly="1";
		}
		if(roleName=="zhfxjc"||roleName=="zhfxjczg"){
		  	
	  	}else{
	  		$("a[id=readZHReport]").hide();
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
	TCmWarnTask_dataset.setFieldHidden("backperson",true);
	
	var taskRelId=TCmWarnTaskRel_dataset.getValue("id");
	if(taskRelId){
		selectWarnInfo(taskRelId);
	}
	//添加于2016-06-30
	//页面显示上传次数
	showNums();
}

function setAllReadOnlyFun(){
	var fieldName="";
	TCmWarnTask_dataset.setFieldReadOnly("taskCode",true);
	TCmWarnTask_dataset.setFieldReadOnly("warnLevel",true);
	TCmWarnTask_dataset.setFieldReadOnly("inspectors",true);
	TCmWarnTask_dataset.setFieldReadOnly("inspeCitDate",true);
	TCmWarnTask_dataset.setFieldReadOnly("disposalPer",true);
	TCmWarnTask_dataset.setFieldReadOnly("disposalDate",true);
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
	//隐藏按钮
	disposalBtn.disable(true);
	TCmWarnTask_dataset.setFieldReadOnly("opinionResult",false);
	TCmWarnTask_dataset.setFieldReadOnly("backPerson",false);
	TCmWarnTask_dataset.setFieldReadOnly("opinion",false);
}

function TCmWarnTask_dataset_onSetValue(ds,curretField,val){
	if((curretField.name=="contmeasure"||curretField.name=="contmeasurename")){
		if(val.indexOf("SS")>-1){
			TCmWarnTask_dataset.setFieldHidden("contOth",false);
		}else{
			TCmWarnTask_dataset.setFieldHidden("contOth",true);
		}
	}else if(curretField.name=="opinionresult"){
		if(val=="0"){
			TCmWarnTask_dataset.setFieldHidden("backperson",false);
		}else{
			TCmWarnTask_dataset.setFieldHidden("backperson",true);
		}
	}
	return val;
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

//提交按钮单击事件
function btnSubmit_onClick(button){
	var flg=false;
	var op="submit";	
	var sm=TCmWarnTask_dataset.getValue("inspeInfo");
	var warnElimDesc=TCmWarnTaskRel_dataset.getValue("warnElimDesc");
	if(sm==null||sm==''){
		alert('请输入核查说明！');
		return false;
	}
	
	if("khjl"==roleName||"khjlqr"==roleName){//客户经理时，都隐藏，无需判断
		flg=true;
	}else{
		var opinionResult = TCmWarnTask_dataset.getValue("opinionResult");
		if(opinionResult){
			if(opinionResult=="0"){//退回
				if("khjlzg"==roleName){
					var op="backStart";
				}else{
					var backPerson = TCmWarnTask_dataset.getValue("backPerson");
					if(backPerson){
						if(backPerson=="0"){
							var op="backStart";
						}else{
							var op="backUp";
						}
					}else{
						top.easyMsg.info("请选择退回节点！");
						return false;
					}
				}
				flg=false;
			}else{//同意
				flg=true;
			}
		}else{
			top.easyMsg.info("请填写审核结果！");
			return false;
		}
	}
	TCmWarnTask_dataset.setParameter("op",op);
	if(flg){
		var orgId=user_info.orgId;
		var roleId="";
		var businessId='${taskId}';
		var params=[businessId,orgId];
		TCmWarnDisposalAjax.isOpenNextUserWin(params,function(sy){
			if(sy.success=="true"){
				if(sy.showWin=="true"){
					TaskVariable.findTaskVariable(businessId,function(y){
						if(y && y.nextRole){//获取到角色ID打开窗口。
							submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+sy.orgId+"&roleId="+y.nextRole,"600","400");
						}else{//获取不到，直接提交
							warnTaskSubmit.click();
						}
					});
				}else{//获取不到，直接提交
					warnTaskSubmit.click();
				}
			}else{
				top.easyMsg.info("系统出错，请联系管理员！");
				return false;
			}
		});
	}else{
		warnTaskSubmit.click();
	}
}
function submitFun(taskAssignee){
	TCmWarnTask_dataset.setParameter("taskAssignee",taskAssignee);
	warnTaskSubmit.click();
}
function cancelFun(){
	submitWindow.close();
}
//提交_参数
function warnTaskSubmit_onClickCheck(button){
	var opinion=TCmWarnTask_dataset.getValue("opinion");
	TCmWarnTask_dataset.setParameter("opinion",opinion);
}


function warnTaskEnd_onClickCheck(button){
	if(confirm("是否确定拒绝?")){
		var op="end";	
		var opinion=TCmWarnTask_dataset.getValue("opinion");
		TCmWarnTask_dataset.setParameter("opinion",opinion);
		TCmWarnTask_dataset.setParameter("op",op);
	}else{
		return false;
	}
	
}

//提交成功
function warnTaskEnd_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("提交成功！");
	if(parent.parent.GTab){parent.parent.GTab.closeTab('warnDisposalWin');}
	window.parent.warnDisposalWin_close();
}
//提交成功
function warnTaskSubmit_postSubmit(button) {
	button.url="#";
	top.easyMsg.info("提交成功！");
	if(window.parent.warnDisposalWin){
		window.parent.warnDisposalWin_close();
	}
	if(parent.parent.GTab){
		parent.parent.GTab.closeTab('warnDisposalWin');
	}
}
//保存成功
function warnTaskSave_postSubmit(button) {
	button.url="#";
}
//查看意见
function btnOpinion_onClick(button){
	subwindow_TaskApprovalHistorySelectAllFW.show();
}

//窗口关闭时还原成原值
function warnSignalFW_floatWindow_beforeClose(){
	var warnSubject=TCmWarnTaskRel_dataset.getValue("warnSubject");
	var warnLevel = TCmWarnTaskRel_dataset.getValue("warnLevel");
	if(warnSubject=="R04002004"||warnLevel=="1"||warnSubject=="R03002004" ){
		TCmWarnTaskRel_dataset.setValue("warnElimIs",my_warnElimIs_val);
	}
	return true;
}

var my_warnElimIs_val=0;
function disposalBtn_onClick(button){
	var warnSubject=TCmWarnTaskRel_dataset.getValue("warnSubject");
	var warnLevel = TCmWarnTaskRel_dataset.getValue("warnLevel");
	if(warnSubject=="R04002004"||warnLevel=="1"||warnSubject=="R03002004" ){
		var fieldName="";
		//禁用预警信息
		for(var i=0;i<TCmWarnTaskRel_dataset.fields.length;i++){
			fieldName=TCmWarnTaskRel_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				TCmWarnTaskRel_dataset.setFieldReadOnly(fieldName,true);
			}
		}
		////原值/////
		my_warnElimIs_val=TCmWarnTaskRel_dataset.getValue('warnElimIs');
		////设置规则排除为‘是’
		TCmWarnTaskRel_dataset.setValue("warnElimIs","1");
		
		TCmWarnTaskRel_dataset.setFieldReadOnly("warnElimIs",false);
		TCmWarnTaskRel_dataset.setFieldReadOnly("warnElimDesc",false);
		subwindow_warnSignalFW.show();
	}else{
		top.easyMsg.info("非财务规则或者非黄色预警无法处理！");
		return false;
	}
}
function lookBtn_onClick(button){
	var fieldName="";
	//禁用预警信息
	my_warnElimIs_val=TCmWarnTaskRel_dataset.getValue('warnElimIs');
	for(var i=0;i<TCmWarnTaskRel_dataset.fields.length;i++){
		fieldName=TCmWarnTaskRel_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmWarnTaskRel_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	subwindow_warnSignalFW.show();
}
function warnSignalConfirm_onClick(button){
	my_warnElimIs_val=TCmWarnTaskRel_dataset.getValue('warnElimIs');
	var warnElimIs=TCmWarnTaskRel_dataset.getValue("warnElimIs");
	if(warnElimIs=="1"){
		var warnElimDesc=TCmWarnTaskRel_dataset.getValue("warnElimDesc");
		if(!warnElimDesc){
			top.easyMsg.info("请填写排除说明！");
			return false;
		}
	}
	subwindow_warnSignalFW.close();
}
function warnSignalTabled_onDbClick(){
	var taskRelId=TCmWarnTaskRel_dataset.getValue("id");
	if(taskRelId){
		selectWarnInfo(taskRelId);
	}
}

function selectWarnInfo(businessId){
	
	BusinInfoTab_tabset.closeAll();
	var OUTPUT={
			A01:{id:"A01",title:"帐务交易流水",url:"/gbicc-com-pages/single/output_ftl/a01.ftl?warningId="+businessId},
			A30:{id:"A30",title:"查冻扣登记簿",url:"/gbicc-com-pages/single/output_ftl/a30.ftl?warningId="+businessId},
			A38:{id:"A38",title:"承兑汇票信息",url:"/gbicc-com-pages/single/output_ftl/a38.ftl?warningId="+businessId},
			B01:{id:"B01",title:"自然人借据信息",url:"/gbicc-com-pages/single/output_ftl/b01.ftl?warningId="+businessId},
			C01:{id:"C01",title:"对公贷款借据明细",url:"/gbicc-com-pages/single/output_ftl/c01.ftl?warningId="+businessId},
			C02:{id:"C02",title:"对公贷款还款明细",url:"/gbicc-com-pages/single/output_ftl/c02.ftl?warningId="+businessId},
			C03:{id:"C03",title:"信贷合同",url:"/gbicc-com-pages/single/output_ftl/c03.ftl?warningId="+businessId},
			C05:{id:"C05",title:"对公贴现登记簿",url:"/gbicc-com-pages/single/output_ftl/c05.ftl?warningId="+businessId},
			C06:{id:"C06",title:"信贷支用申请明细",url:"/gbicc-com-pages/single/output_ftl/c06.ftl?warningId="+businessId},
			C08:{id:"C08",title:"对公抵质押物出入库操作流水",url:"/gbicc-com-pages/single/output_ftl/c08.ftl?warningId="+businessId},
			C09:{id:"C09",title:"票据信息",url:"/gbicc-com-pages/single/output_ftl/c09.ftl?warningId="+businessId},
			C11:{id:"C11",title:"跟单背书信息",url:"/gbicc-com-pages/single/output_ftl/c11.ftl?warningId="+businessId},
			C12:{id:"C12",title:"电子票据流转信息",url:"/gbicc-com-pages/single/output_ftl/c12.ftl?warningId="+businessId},
			C13:{id:"C13",title:"关联人信息",url:"/gbicc-com-pages/single/output_ftl/c13.ftl?warningId="+businessId},
			C14:{id:"C14",title:"担保圈信息",url:"/gbicc-com-pages/single/output_ftl/c14.ftl?warningId="+businessId},
			C15:{id:"C15",title:"客户指标信息",url:"/gbicc-com-pages/single/output_ftl/c15.ftl?warningId="+businessId},
			C16:{id:"C16",title:"自然人账户信息",url:"/gbicc-com-pages/single/output_ftl/c16.ftl?warningId="+businessId},
			J02:{id:"J02",title:"对公客户信息",url:"/gbicc-com-pages/single/output_ftl/j02.ftl?warningId="+businessId},
			J04:{id:"J04",title:"对私客户信息",url:"/gbicc-com-pages/single/output_ftl/j04.ftl?warningId="+businessId},
			J09:{id:"J09",title:"员工信息",url:"/gbicc-com-pages/single/output_ftl/j09.ftl?warningId="+businessId},
			J16:{id:"J16",title:"理财账户信息",url:"/gbicc-com-pages/single/output_ftl/j16.ftl?warningId="+businessId},
			J17:{id:"J17",title:"从合同信息",url:"/gbicc-com-pages/single/output_ftl/j17.ftl?warningId="+businessId},
			J18:{id:"J18",title:"授信客户信息",url:"/gbicc-com-pages/single/output_ftl/j18.ftl?warningId="+businessId},
			L01:{id:"L01",title:"外部工商信息",url:"/gbicc-com-pages/single/output_ftl/l01.ftl?warningId="+businessId},
			L02:{id:"L02",title:"工商变更明细",url:"/gbicc-com-pages/single/output_ftl/l02.ftl?warningId="+businessId},
			L03:{id:"L03",title:"工商处罚明细",url:"/gbicc-com-pages/single/output_ftl/l03.ftl?warningId="+businessId},
			L04:{id:"L04",title:"开庭公告信息",url:"/gbicc-com-pages/single/output_ftl/l04.ftl?warningId="+businessId},
			L05:{id:"L05",title:"判决文书信息",url:"/gbicc-com-pages/single/output_ftl/l05.ftl?warningId="+businessId},
			L11:{id:"L11",title:"企业征信信息",url:"/gbicc-com-pages/single/output_ftl/l11.ftl?warningId="+businessId},
			L12:{id:"L12",title:"个人征信信息",url:"/gbicc-com-pages/single/output_ftl/l12.ftl?warningId="+businessId},
			L13:{id:"L13",title:"征信文件信息",url:"/gbicc-com-pages/single/output_ftl/l13.ftl?warningId="+businessId},
			L14:{id:"L14",title:"黑名单信息",url:"/gbicc-com-pages/single/output_ftl/l14.ftl?warningId="+businessId},
			L15:{id:"L15",title:"高能耗信息",url:"/gbicc-com-pages/single/output_ftl/l15.ftl?warningId="+businessId},
			L16:{id:"L16",title:"企业征信未结清贷款信息",url:"/gbicc-com-pages/single/output_ftl/l16.ftl?warningId="+businessId},
			L17:{id:"L17",title:"企业征信未结清承兑汇票信息",url:"/gbicc-com-pages/single/output_ftl/l17.ftl?warningId="+businessId}
		}
		var halfresult=TCmWarnTaskRel_dataset.getValue("halfresult");
		if(halfresult){
			if(halfresult!=null && halfresult!=""){
				var ids=halfresult.split("|");
				for(var i=0;i<ids.length;i++){
					if(ids[i]){
						if(ids[i]!=""&&ids[i]!="<A/>"){
							BusinInfoTab_tabset.add(OUTPUT[ids[i]]);
						}
					}
				}
			}
		}
	
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

function openUploadWin(){
	openSubWin("uploadFile", "附件管理", 
		"/gbicc-pages/upload/commonupload.ftl?relaID=${taskId}&relaType=11&readOnly="+readOnly,
	null,400);
}
$("#fupload").linkbutton({"iconCls":"icon-upload"}).click(openUploadWin);
function operBank_DropDown_beforeOpen(dropDown){
//		var currAssignee="";
//		var record=TaskAfreshAssign_dataset.getFirstRecord();
//		while(record){
//			if(record.getValue("select")==true){
//				currAssignee=record.getValue("assignee");
//			}
//			record=record.getNextRecord();
//		}
	SelectOrgCQTree_DropDownDataset.setParameter("currentUserOrgId","0000");
}
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
