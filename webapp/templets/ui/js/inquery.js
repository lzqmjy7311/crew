
function openMerchant(value)
{
	path = _application_root + "/fpages/MerChantMng/ftl/SingleMerChant.ftl?singleMerchantId=" + value ;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

function openPreApplyInfo(value){
	path = _application_root + "/fpages/preloan/ftl/StartPreLoanApplyQuery.ftl?preApplyNo=" + value +"&queryFlag=true" ;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

function openAcceptanceBaseInfo(value){
	path = _application_root + "/fpages/entityaccept/ftl/AcceptanceDetailsQuery.ftl?acceptId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openElcAcceptBaseInfo(value){
	path = _application_root + "/fpages/elcaccept/ftl/AcceptanceDetailsQuery.ftl?acceptId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openTransDiscountBaseInfo(value){
	path = _application_root + "/fpages/entityaccept/ftl/TransDiscountInfoQuery.ftl?contractId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

function openDiscountBaseInfo(value){
	path = _application_root + "/fpages/entitydiscounted/ftl/DiscountInfoQuery.ftl?contractId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

function openAcceptanceDetail(value){
	path = _application_root + "/fpages/entityaccept/ftl/AcceptanceDetailsQuery.ftl?acceptId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

function openSellBatchMod(value){
	path = _application_root + "/fpages/elcdiscounted/ftl/sell/sellBatchMod.ftl?readOnly='1'&contractId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openBuyContract(value){
	path = _application_root + "/fpages/elcdiscounted/ftl/CreateBuyContractQry.ftl?contractId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

/*---业务提醒详情中打开窗口有误-modified by HuangWeijing 2009-09-23 jira:BMS-1992 begin---------------*/
function openEntityBuyContract(value){
	path = _application_root + "/fpages/entitydiscounted/ftl/DiscountInfoQuery.ftl?contractId=" + value;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
/*---业务提醒详情中打开窗口有误-modified by HuangWeijing 2009-09-23 jira:BMS-1992 end----------------*/

function openCustomer(value){
	path = _application_root + "/fpages/custindv/ftl/CustInfoTypeIn.ftl";
			path += "?custcd="+value;
		    var readOnlyFlag="true";
		    path +="&readOnlyFlag="+readOnlyFlag;
	window.open(path,"_blank","height=800,width=1000,fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0;");

}

function openScoreInfo(value){
	path = _application_root + "/fpages/preloan/ftl/GradeResultInfo.ftl?preApplyNo=" + value +"&queryFlag=true" ;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
/**
 * 根据核心客户号显示客户的信息，系统会判断该客户是法人还是自然人
 * @param custno 核心客户号
 * @param type 类型，保留目前不起作用
 */
function showCustInfoByCustno(custno,type) {


	var path = _application_root + "/customerInfoQuery.do";

	path += "?actionType=2";//2代表通过custno查询客户信息
	path += "&custno="+custno;//核心客户号
	path += "&type="+type;//目前type参数还不起任何作用

	window.open(path,"_SEMS_WINDOW","fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0");
}

/**
 * 根据内部客户号显示客户的信息，系统会判断该客户是法人还是自然人
 * @param custcd 内部客户号
 * @param type 类型，保留目前不起作用
 */
function showCustInfoByCustcd(custcd,type) {

	var path = _application_root + "/customerInfoQuery.do";

	path += "?actionType=1";//1代表通过custcd查询客户信息
	path += "&custcd="+custcd;//内部客户号
	path += "&type="+type;//目前type参数还不起任何作用

	window.open(path,"_SEMS_WINDOW","fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0");
}

/**
 * 根据产品授信编号显示授信信息
 * @param productCreditNo 产品授信编号
 * @param type 类型，保留目前不起作用
 */
function showProductCreditInfoByProductCreditNo(productCreditNo,type) {

	var path = _application_root + "/productCreditInfoQuery.do";

	path += "?productCreditNo="+productCreditNo;//产品授信编号
	path += "&type="+type;//目前type参数还不起任何作用
	window.open(path,"_SEMS_WINDOW","fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0");
}

/**
 * 根据APPNO显示审批意见
 * @param appno 申请号
 * @param type 类型，1:显示所有的审批意见   2:显示审批岗的审批意见
 */
function showApplyDtlByAppno(appno,type) {

	var path = _application_root + "/fpages/credit/ftl/CreditCustApplyDtlQry.ftl";

	path += "?appno="+appno;//申请编号
	path += "&type="+type;//目前type参数还不起任何作用

	window.open(path,"_SEMS_WINDOW","fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0");
}

/**
 * 根据APPNO历史监控详细信息
 * @param appno 申请号
 * @param monitorClass 监控类型
 */
function showMonitorHistoryDtl(appno,monitorClass) {

	var path = _application_root + "/MonitorHist.do";

	path += "?appno="+appno;//申请号
	path += "&monitorClass="+monitorClass;//监控类型

	window.open(path,"_SEMS_WINDOW","fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0");
}
function openDraftInfo(draftId,srcType){

    if(srcType=="01"){//承兑业务
    	path = _application_root + "/fpages/draftquery/ftl/AcceptDraftInfo.ftl?DRAFTID="+draftId ;
	}
	else if(srcType=="02"||srcType=="03"){//贴现业务
		path = _application_root + "/fpages/draftquery/ftl/DisountDraftInfo.ftl?DRAFTID="+draftId ;
	}
	else if(srcType=="04"){//保管业务
		path = _application_root + "/fpages/draftquery/ftl/DraftQuery.ftl?DRAFTID="+draftId ;
	}
	else if(srcType=="05"){//保证业务
		path = _application_root + "/fpages/draftquery/ftl/GuaranteDraftInfo.ftl?DRAFTID="+draftId ;
	}
	else if(srcType=="06"){//质押业务
		path = _application_root + "/fpages/draftquery/ftl/CollztnDraftInfo.ftl?DRAFTID="+draftId ;
	}
	else if(srcType=="06"){//质押业务
		path = _application_root + "/fpages/draftquery/ftl/CollztnDraftInfo.ftl?DRAFTID="+draftId ;
	}
	else{
		path = _application_root + "/fpages/draftquery/ftl/DraftQuery.ftl?DRAFTID="+draftId ;
	}
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

/**
 * 选择对公客户
 * 返回值:是一个数组或者null
 * 返回值第0位：custcd
 * 返回值第1位：custno
 * 返回值第2位：regionNo
 * 返回值第3位：regionNoName
 * 返回值第4位：custType
 * 返回值第5位：cname
 * 返回值第6位：ename
 * 返回值第7位：orgCode
 * 返回值第8位：directorCreditBrno
 * 返回值第9位：directorCreditBrnoName
 * 返回值第10位：directorManagerNo
 * 返回值第11位：directorManagerNoName
 * 返回值第12位：custStatus
 */
function selectCorpCustomer() {
	var path = _application_root + "/fpages/customer/ftl/SelectCorpCustomer.ftl";
	return window.showModalDialog (path,null,"dialogWidth:900px;dialogHeight:620px;center:yes;help:no;resizable:yes;status:no");
}

/**
 * 选择自然人客户
 * 返回值:是一个数组或者null
 * 返回值第0位：custcd
 * 返回值第1位：custno
 * 返回值第2位：regionNo
 * 返回值第3位：regionNoName
 * 返回值第4位：custType
 * 返回值第5位：cname
 * 返回值第6位：ename
 * 返回值第7位：idtype
 * 返回值第8位：idno
 * 返回值第9位：directorCreditBrno
 * 返回值第10位：directorCreditBrnoName
 * 返回值第11位：directorManagerNo
 * 返回值第12位：directorManagerNoName
 * 返回值第13位：custStatus
 */
function selectIndvCustomer() {
	var path = _application_root + "/fpages/customer/ftl/SelectIndvCustomer.ftl";
	return window.showModalDialog (path,null,"dialogWidth:900px;dialogHeight:620px;center:yes;help:no;resizable:yes;status:no");
}

/**
 * 选择客户
 * 返回值:是一个数组或者null
 * 返回值第0位：custcd
 * 返回值第1位：custno
 * 返回值第2位：regionNo
 * 返回值第3位：regionNoName
 * 返回值第4位：custType
 * 返回值第5位：cname
 * 返回值第6位：ename
 * 返回值第7位：idtype
 * 返回值第8位：idno
 * 返回值第9位：directorCreditBrno
 * 返回值第10位：directorCreditBrnoName
 * 返回值第11位：directorManagerNo
 * 返回值第12位：directorManagerNoName
 * 返回值第13位：custStatus
 */
function selectCustomer() {
	var path = _application_root + "/fpages/customer/ftl/SelectCustomer.ftl";
	return window.showModalDialog (path,null,"dialogWidth:970px;dialogHeight:660px;center:yes;help:no;resizable:yes;status:no");
}

function openLoanRuleInfo(value,ruleType){
	var path = _application_root + "/LoanRuleInfoQuery.do";
	path += "?flag=1&id="+value+"&ruleType="+ruleType+"";
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

function openCustno(value){
	path = _application_root + "/fpages/customer/ftl/CustomerInfoDetail.ftl";
			path += "?id="+value;
	window.open(path,"_blank","height=800,width=1000,fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0;");

}


function openRepurchaseDetails(value){
	path = _application_root + "/fpages/entitydue/ftl/addRepurchaseDetails.ftl";
			path += "?batchId="+value;
	window.open(path,"_blank","height=800,width=1000,fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0;");

}

function openRepurchaseDetails4Elc(value){
	path = _application_root + "/fpages/elcduebuy/ftl/addRepurchaseDetails.ftl";
			path += "?batchId="+value;
	window.open(path,"_blank","height=800,width=1000,fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0;");

}


function openTaskDetail(appno,piid){
	path = _application_root + "/fpages/approve/ftl/workflowQuery.ftl";
			path += "?appno="+appno;
		    path +="&piid="+piid;
	window.open(path,"_blank","height=800,width=1000,fullscreen=no,toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no,menubar=no,top=0,left=0;");

}
//added by mengjiao.zhang 20090912 BMS-1904 start
function openReconcilDtl(reconcilDate, sndRcvFlag, msgType, acctSvcr, detailType) {
	//var targetUrl = _application_root + "/fpages/elcmng/ftl/dayReconcilResultDetailQuery.ftl?reconcilDate=" + reconcilDate + "&sndRcvFlag=" + sndRcvFlag + "&msgType=" + msgType + "&acctSvcr="+ acctSvcr+ "&detailType=" + detailType;
	//window.open(targetUrl, "_blank", "resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
	var paramMap = new Map();
	paramMap.put("reconcilDate",reconcilDate);
	paramMap.put("sndRcvFlag",sndRcvFlag);
	paramMap.put("msgType",msgType);
	paramMap.put("acctSvcr",acctSvcr);
	paramMap.put("detailType",detailType);
	loadPageWindows("userWin","","/fpages/elcmng/ftl/dayReconcilResultDetailQuery.ftl",paramMap,"winZone");
}
//added by mengjiao.zhang 20090912 BMS-1904 end
//added 2009.09.10,bms-,start
function openAcceptTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_acceptInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openCollztnTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_collztnInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openPrmtpayTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_prmtpayInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openRebuyTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_rebuyInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openRecourseAgreeTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_recourseAgreeInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openRecourseNotifiTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_recourseNotifiInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openSellTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_sellInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openUncollztnTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_uncollztnInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}

function openDraftGuaranteeTaskPool(id) {
	path = _application_root + "/fpages/draftquery/ftl/TaskPoolQuery_draftGuaranteeInfo.ftl";
	path += "?id=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=900,height=600");
}
//added 2009.09.10,bms-,end

//added by mengjiao.zhang 20090912 BMS-1904 start
function openReconcilDrl(reconcilDate, sndRcvFlag, msgType, acctSvcr, detailType) {
	//var targetUrl = _application_root + "/fpages/elcmng/ftl/dayResultQuery.ftl?reconcilDate=" + reconcilDate + "&sndRcvFlag=" + sndRcvFlag + "&msgType=" + msgType + "&acctSvcr="+acctSvcr+"&detailType=" + detailType;
	//window.open(targetUrl, "_blank", "resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
	var paramMap = new Map();
	paramMap.put("reconcilDate",reconcilDate);
	paramMap.put("sndRcvFlag",sndRcvFlag);
	paramMap.put("msgType",msgType);
	paramMap.put("acctSvcr",acctSvcr);
	paramMap.put("detailType",detailType);
	loadPageWindows("userWin","","/fpages/elcmng/ftl/dayResultQuery.ftl",paramMap,"winZone");
}
//added by mengjiao.zhang 20090912 BMS-1904 end
//add by kangbyron 20090918 BMS-1963 begin
function openResellContract(id, draftAttr){
	if(draftAttr=="1"){
  		path = _application_root + "/fpages/entityresale/ftl/SellInfoQuery.ftl?contractId=" + id ;
  		}else{
     path = _application_root + "/fpages/elcdiscounted/ftl/sell/SellInfoQuery.ftl?contractId=" + id ;
      }

      window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}

function openDraftInfoView(draftNum){
	var path=_application_root+"/fpages/common/ftl/DraftInfoView.ftl?draftno=" + draftNum;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}

function openBatchInfoView(batchId){
	var path=_application_root+"/fpages/common/ftl/BatchInfoView.ftl?batchId=" + batchId;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
//BMS-2850 add by chenming.ma 2010-08-06 begin
function openElcGuarApplyCont(id){
	var path=_application_root+"/fpages/elcguarcont/ftl/ElcGuarApplyContNewQry.ftl?contractId="+id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openElcGuarSignCont(id){
	var path=_application_root+"/fpages/elcguarcont/ftl/ElcGuarSignContNewQry.ftl?contractId="+id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
// BMS-2850 add by chenming.ma 2010-08-06 end
//add by jornezhang 20091114 BMS-2187 begin
function openCollztnContract(id){
	var path=_application_root+"/fpages/entitycollztn/ftl/CollztnContractQuery.ftl?contractId=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
//add by jornezhang 20091114 BMS-2187 end
/** add by jornezhang 20091202 BMS-2244  begin */
function openCollztnContractSend(id){
	var path=_application_root+"/fpages/elcbusiness/ftl/CollztnContractSendQuery.ftl?contractId=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openCollztnContractSign(id){
	var path=_application_root+"/fpages/elcbusiness/ftl/CollztnContractSignQuery.ftl?contractId=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openUnCollztnContractSend(id){
	/** add by jornezhang 20100707 BMS-2797 begin */
	//var path=_application_root+"/fpages/elcbusiness/ftl/CollztnContractSendQuery.ftl?contractId=" + id;
	var path=_application_root+"/fpages/elcbusiness/ftl/UnCollztnContractSendQuery.ftl?contractId=" + id;
	/** add by jornezhang 20100707 BMS-2797 end */
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openUnCollztnContractSign(id){
	/** add by jornezhang 20100707 BMS-2797 begin */
	//var path=_application_root+"/fpages/elcbusiness/ftl/CollztnContractSignQuery.ftl?contractId=" + id;
	var path=_application_root+"/fpages/elcbusiness/ftl/UnCollztnContractSignQuery.ftl?contractId=" + id;
	/** add by jornezhang 20100707 BMS-2797 end */
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
/** add by jornezhang 20091202 BMS-2244 end */
/** add by jornezhang 20100310 BMS-2501 public method for downfile begin */
function downloan(value){
	var filepath = encodeURIComponent(value);
	submitForm(filepath);
	return false;
}

function submitForm(filepath){
var form = document.createElement("FORM");
	form.method = "post";
	form.action=_application_root +"/filedownload/FileDownloadAction.do";
	form.insertAdjacentHTML("beforeEnd","<input type=\"hidden\" name=\"downloadinfo\" value=\""+filepath+"\">");
	form.style.visibility ="hidden";
	document.body.appendChild(form);
	form.submit();
}
/** add by jornezhang 20100310 BMS-2501 public method for downfile end */
/** add by jornezhang 20100707 BMS-2797 begin */
function openUnCollztnContract(id){//entity uncollztn query
	var path=_application_root+"/fpages/entitycollztn/ftl/UnCollztnContractDetailsPageView.ftl?contractId=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
/** add by jornezhang 20100707 BMS-2797 end */

/** add by weikun.wang 20100701   BMS-2788 锟斤拷锟斤拷票锟捷憋拷证锟斤拷锟叫拷锟斤拷锟斤拷锟?1?7 begin */
function openElcGuarContractSendInfo(id){
	var path=_application_root+"/fpages/elcguarcont/ftl/ElcGuarApplyContNewQry.ftl?contractId=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openElcGuarContractSignInfo(id){
	var path=_application_root+"/fpages/elcguarcont/ftl/ElcGuarSignContNewQry.ftl?contractId=" + id;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
/** add by weikun.wang 20100701   BMS-2788 锟斤拷锟斤拷票锟捷憋拷证锟斤拷锟叫拷锟斤拷锟斤拷锟?1?7 end */
/** add by fanrong 20101117 BMS-2885 begin */
function openEntityRegisterAcceptance(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/acceptanceRegister.ftl?_cds_=0&stdbusstyp=01&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterDiscount(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/discountRegister.ftl?_cds_=0&stdbusstyp=03&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterRediscount1(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/rediscountRegister1.ftl?_cds_=0&stdbusstyp=04&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterRediscount2(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/rediscountRegister2.ftl?_cds_=0&stdbusstyp=05&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterCollateralization(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/collateralizationRegister.ftl?_cds_=0&stdbusstyp=06&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterCollateralRepurchased(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/CollateralRepurchasedReg.ftl?_cds_=0&stdbusstyp=07&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterCollection(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/DraftCollectionReg.ftl?_cds_=0&stdbusstyp=08&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterSettlement(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/DraftSettlementReg.ftl?_cds_=0&stdbusstyp=09&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterPaymentRefused(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/DraftPaymentRefusedReg.ftl?_cds_=0&stdbusstyp=10&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterSuspendingPayment(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/DraftSuspendingPaymentReg.ftl?_cds_=0&stdbusstyp=11&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterAnnulingSuspendingPayment(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/DraftAnnulingSuspendingPaymentReg.ftl?_cds_=0&stdbusstyp=12&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openEntityRegisterDrawBack(value1,value2,value3){
	path = _application_root + "/fpages/entityRegister/ftl/drawBackRegister.ftl?_cds_=0&stdbusstyp=13&txtype=1&txnDate=" + value1+"&sendStatus="+value2+"&srcType="+value3;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openHref(url){
	path = megerURL(_application_root,url);
	window.location.href = path;
}
/** add by fanrong 20101117 BMS-2885 end */

function openCollztnContractSendQ(id,newFlag){
	var path=_application_root+"/fpages/elcbusiness/ftl/CollztnContractSendQuery.ftl?contractId=" + id + "&taskId=" + newFlag;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openCollztnContractSignQ(id,newFlag){
	var path=_application_root+"/fpages/elcbusiness/ftl/CollztnContractSignQuery.ftl?contractId=" + id + "&taskId=" + newFlag;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openUnCollztnContractSendQ(id,newFlag){
	var path=_application_root+"/fpages/elcbusiness/ftl/UnCollztnContractSendQuery.ftl?contractId=" + id + "&taskId=" + newFlag;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openUnCollztnContractSignQ(id,newFlag){
	var path=_application_root+"/fpages/elcbusiness/ftl/UnCollztnContractSignQuery.ftl?contractId=" + id + "&taskId=" + newFlag;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
function openCollztnContractQ(id,newFlag){
	var path=_application_root+"/fpages/entitycollztn/ftl/CollztnContractQuery.ftl?contractId=" + id + "&taskId=" + newFlag;
	window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=700");
}
