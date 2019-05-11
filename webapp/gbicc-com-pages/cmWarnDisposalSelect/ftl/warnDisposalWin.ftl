<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign taskId=RequestParameters["taskId"]?default("")>
<#assign customerId=RequestParameters["customerId"]?default("")>
<@CommonQueryMacro.page title="Ԥ������  &gt;  �ҵ�����">
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/upLoadNumsAjax.js'> </script>

	<table style="width: 100%">
	<tr>
			<td>
			<center>
				<span style="padding:7px 0 0  0;">
					<a id="readFinaAnal" onclick="readFinaAnal_onClick()"  href="javascript:void(0)">�鿴������ͼ</a>
					<a id="readFinaInte" onclick="readFinaInte_onClick()" href="javascript:void(0)">�鿴�������</a>
					<a id="readFundMoni" onclick="readFundMoni_onClick()" href="javascript:void(0)">�鿴������Ŷ�</a>
					<a id="readZHReport" onclick="readZHReport_onClick()" href="javascript:void(0)">������ͼ</a>
				</span>
				</center>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmCustomer" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="group2" label="������Ϣ" colNm=4
					fieldStr="taskCode,custcode,custname,loanAmount,loanBalance,businessCode,legalRep,operBankNam,operatorNam"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TCmWarnTaskRel" init="true" submitMode="all">	
					<@CommonQueryMacro.GroupBox id="box1" label="Ԥ����Ϣ">
						<@CommonQueryMacro.DataTable id="warnSignalTabled" paginationbar="lookBtn" pagination="true" 
			             fieldStr="warnCode[70],warnLevel[70],warnSubject[100],warnName[220],warnDesc[250],warnDate[100],warnStatus[70],warnElimIs[70],warnElimDesc[200]" width="100%" hasFrame="true"/>
		           <@CommonQueryMacro.FloatWindow id="warnSignalFW" modal="true" label="Ԥ�����"  position="center"
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
				<@CommonQueryMacro.Group id="group4" label="Ԥ���˲���Ϣ" colNm=4 fieldStr="inspectorsNam,inspeCitDate,inspeMethod,inspeDate,inspeInfo,contMeasure,contOth,contDesc"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="group5" label="Ԥ��������Ϣ" colNm=4 fieldStr="disposalPerNam,disposalDate,dispoCitDate,disposalInfo"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<@CommonQueryMacro.CommonQuery id="TCmWarnTask" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="group6" label="������Ϣ" colNm=4 fieldStr="isContinue,overRc,dddd,dddd"/>
			</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
			<div name="group9" class="group" noextra="true">
				<h5 noextra="true">����</h5>
				<center style="padding-top: 5px;padding-bottom: 10px;">
					<a id="fupload" href="javascript:void()">�ϴ�/���أ�<font id="Nums"></font>��</a>
				</center>
			</div>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistorySelectAll" init="true" submitMode="all">
					<@CommonQueryMacro.GroupBox id="box2" label="������ʷ">
						<@CommonQueryMacro.DataTable id="TaskApprovalHistorySelectAllTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="TaskApprovalHistorySelectAllFW" modal="true" label="�鿴���" position="center" 
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

//�б�ˢ�´���
function warnSignalTabled_warndesc_onRefresh(cell,value,record) {
	if (record) {//�����ڼ�¼ʱ
		if(record.getValue("warnCode")=="CW015" && record.getValue("warnDesc").indexOf("ʵ����Ӫҵ������")>-1){
			var str=record.getValue("warnDesc").replace("ʵ����Ӫҵ������","<a href='#' title='������Ӫҵ������۳�����������Ӫҵ����'>ʵ����Ӫҵ������</a>");
			str=str.replace("�����ܶ�","<a href='#' title='������Ӫҵ������+����ҵ������+��������'>�����ܶ�</a>");
			cell.innerHTML=str;
		}else if(record.getValue("warnCode")=="CW001" && record.getValue("warnDesc").indexOf("���д������")>-1){
			var str=record.getValue("warnDesc").replace("���д������","<a href='#' title='�ͻ�����������δ����Ĵ���������֮��'>���д������</a>");
			str=str.replace("�Ʊ�����Ŀ֮��","<a href='#' title='���ڽ����ڽ�1���ڵ��ڵĳ��ڽ��������Ŀ�����֮��'>�Ʊ�����Ŀ֮��</a>");
			cell.innerHTML=str;
		}else if(record.getValue("warnCode")=="CW002" && record.getValue("warnDesc").indexOf("�Ʊ�����Ŀ֮��")>-1){
			var str=record.getValue("warnDesc").replace("�Ʊ�����Ŀ֮��","<a href='#' title='���ڽ����ڽ�1���ڵ��ڵĳ��ڽ��������Ŀ�����֮��'>�Ʊ�����Ŀ֮��</a>");
			cell.innerHTML=str;
		}else if(record.getValue("warnCode")=="CW014" && record.getValue("warnDesc").indexOf("��������")>-1){
			var str=record.getValue("warnDesc").replace("��������","<a href='#' title='���ڽ��+Ӧ��Ʊ��'>��������</a>");
			cell.innerHTML=str;
		}else{
			cell.innerHTML=record.getValue("warnDesc");
		}
	} 
}

function initCallGetter_post(dataset) {
	TCmWarnTask_dataset.setFieldReadOnly("isContinue",true);
    var businessId='${taskId}';
    TCmWarnTask_dataset.setParameter("flag","true");
    TCmWarnTask_dataset.flushData();
    TCmWarnTask_dataset.setParameter("flag","");
  //���ݽ�ɫ����ʾ�������ذ�ť
	TaskVariable.findTaskVariable(businessId,function(y){
		var taskType=TCmWarnTask_dataset.getValue("taskType");
		roleName=y.nowRole;
		if(roleName=="khjl"){//�ͻ�����
			readOnly="0";//Ĭ�ϲ����ļ� �ϴ�
			setAllReadOnlyFun()
			if(taskType){
				if(taskType=="RC"){
					setPageReadOnlyFun();
					TCmWarnTask_dataset.setFieldReadOnly("overRc",false);
				}else{
					$("div[name=group6]").hide();
					$("div[name=group5]").hide();
				}
			}else{
				$("div[name=group6]").hide();
			}
		}else{
			setPageReadOnlyFun();
			if(taskType=="RC"){
			}else{
				TCmWarnTask_dataset.setFieldHidden("overRc",true);
				$("div[name=group5]").hide();
			}
		}
		
		if(taskType=="DC"){
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
		}
		
		if(roleName=="khjlqr"){//�ͻ�����ȷ��
			//warnTaskSave.disable(true);
		}
		if(roleName!="zhfxjc"&&roleName!="zhfxjczg"){
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
	var taskRelId=TCmWarnTaskRel_dataset.getValue("id");
	if(taskRelId){
		selectWarnInfo(taskRelId);
	}
	//������2016-06-30
	//ҳ����ʾ�ϴ�����
	showNums();
}

//������2016-06-30
//ҳ����ʾ�ϴ�����
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
	TCmWarnTask_dataset.setFieldReadOnly("disposalPer",true);
	TCmWarnTask_dataset.setFieldReadOnly("disposalDate",true);
	//���ÿͻ�����
	for(var i=0;i<TCmCustomer_dataset.fields.length;i++){
		fieldName=TCmCustomer_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmCustomer_dataset.setFieldReadOnly(fieldName,true);
		}
	}
}
//����ҳ�������ֶ�ֻ��
function setPageReadOnlyFun(){
	var fieldName="";
	for(var i=0;i<TCmWarnTask_dataset.fields.length;i++){
		fieldName=TCmWarnTask_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmWarnTask_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	//���ÿͻ�����
	for(var i=0;i<TCmCustomer_dataset.fields.length;i++){
		fieldName=TCmCustomer_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmCustomer_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	//����Ԥ����Ϣ
	for(var i=0;i<TCmWarnTaskRel_dataset.fields.length;i++){
		fieldName=TCmWarnTaskRel_dataset.fields[i].name;
		if(fieldName.substring(0,1)!="_"){
			TCmWarnTaskRel_dataset.setFieldReadOnly(fieldName,true);
		}
	}
	//���ذ�ť
	TCmWarnTask_dataset.setFieldReadOnly("opinion",false);
	
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





//�鿴���
function btnOpinion_onClick(button){
	subwindow_TaskApprovalHistorySelectAllFW.show();
}

function lookBtn_onClick(button){
	var fieldName="";
	//����Ԥ����Ϣ
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
function warnSignalTabled_onDbClick(){
	var taskRelId=TCmWarnTaskRel_dataset.getValue("id");
	if(taskRelId){
		selectWarnInfo(taskRelId);
	}
}

function selectWarnInfo(businessId){
	BusinInfoTab_tabset.closeAll();
	var OUTPUT={
			A01:{id:"A01",title:"��������ˮ",url:"/gbicc-com-pages/single/output_ftl/a01.ftl?warningId="+businessId},
			A30:{id:"A30",title:"�鶳�۵Ǽǲ�",url:"/gbicc-com-pages/single/output_ftl/a30.ftl?warningId="+businessId},
			A38:{id:"A38",title:"�жһ�Ʊ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/a38.ftl?warningId="+businessId},
			B01:{id:"B01",title:"��Ȼ�˽����Ϣ",url:"/gbicc-com-pages/single/output_ftl/b01.ftl?warningId="+businessId},
			C01:{id:"C01",title:"�Թ���������ϸ",url:"/gbicc-com-pages/single/output_ftl/c01.ftl?warningId="+businessId},
			C02:{id:"C02",title:"�Թ��������ϸ",url:"/gbicc-com-pages/single/output_ftl/c02.ftl?warningId="+businessId},
			C03:{id:"C03",title:"�Ŵ���ͬ",url:"/gbicc-com-pages/single/output_ftl/c03.ftl?warningId="+businessId},
			C05:{id:"C05",title:"�Թ����ֵǼǲ�",url:"/gbicc-com-pages/single/output_ftl/c05.ftl?warningId="+businessId},
			C06:{id:"C06",title:"�Ŵ�֧��������ϸ",url:"/gbicc-com-pages/single/output_ftl/c06.ftl?warningId="+businessId},
			C08:{id:"C08",title:"�Թ�����Ѻ�����������ˮ",url:"/gbicc-com-pages/single/output_ftl/c08.ftl?warningId="+businessId},
			C09:{id:"C09",title:"Ʊ����Ϣ",url:"/gbicc-com-pages/single/output_ftl/c09.ftl?warningId="+businessId},
			C11:{id:"C11",title:"����������Ϣ",url:"/gbicc-com-pages/single/output_ftl/c11.ftl?warningId="+businessId},
			C12:{id:"C12",title:"����Ʊ����ת��Ϣ",url:"/gbicc-com-pages/single/output_ftl/c12.ftl?warningId="+businessId},
			C13:{id:"C13",title:"��������Ϣ",url:"/gbicc-com-pages/single/output_ftl/c13.ftl?warningId="+businessId},
			C14:{id:"C14",title:"����Ȧ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/c14.ftl?warningId="+businessId},
			C15:{id:"C15",title:"�ͻ�ָ����Ϣ",url:"/gbicc-com-pages/single/output_ftl/c15.ftl?warningId="+businessId},
			C16:{id:"C16",title:"��Ȼ���˻���Ϣ",url:"/gbicc-com-pages/single/output_ftl/c16.ftl?warningId="+businessId},
			J02:{id:"J02",title:"�Թ��ͻ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j02.ftl?warningId="+businessId},
			J04:{id:"J04",title:"��˽�ͻ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j04.ftl?warningId="+businessId},
			J09:{id:"J09",title:"Ա����Ϣ",url:"/gbicc-com-pages/single/output_ftl/j09.ftl?warningId="+businessId},
			J16:{id:"J16",title:"�����˻���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j16.ftl?warningId="+businessId},
			J17:{id:"J17",title:"�Ӻ�ͬ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/j17.ftl?warningId="+businessId},
			J18:{id:"J18",title:"���ſͻ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j18.ftl?warningId="+businessId},
			L01:{id:"L01",title:"�ⲿ������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l01.ftl?warningId="+businessId},
			L02:{id:"L02",title:"���̱����ϸ",url:"/gbicc-com-pages/single/output_ftl/l02.ftl?warningId="+businessId},
			L03:{id:"L03",title:"���̴�����ϸ",url:"/gbicc-com-pages/single/output_ftl/l03.ftl?warningId="+businessId},
			L04:{id:"L04",title:"��ͥ������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l04.ftl?warningId="+businessId},
			L05:{id:"L05",title:"�о�������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l05.ftl?warningId="+businessId},
			L11:{id:"L11",title:"��ҵ������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l11.ftl?warningId="+businessId},
			L12:{id:"L12",title:"����������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l12.ftl?warningId="+businessId},
			L13:{id:"L13",title:"�����ļ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/l13.ftl?warningId="+businessId},
			L14:{id:"L14",title:"��������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l14.ftl?warningId="+businessId},
			L15:{id:"L15",title:"���ܺ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/l15.ftl?warningId="+businessId},
			L16:{id:"L16",title:"��ҵ����δ���������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l16.ftl?warningId="+businessId},
			L17:{id:"L17",title:"��ҵ����δ����жһ�Ʊ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/l17.ftl?warningId="+businessId}
		}
		var halfresult=TCmWarnTaskRel_dataset.getValue("halfresult");
		if(halfresult){
			if(halfresult!=null && halfresult!=""){
				var ids=halfresult.split("|");
				for(var i=0;i<ids.length;i++){
					if(ids[i]!=""&&ids[i]!="<A/>"){
						BusinInfoTab_tabset.add(OUTPUT[ids[i]]);
					}
				}
			}
		}

	
}


function openUploadWin(){
	openSubWin("uploadFile", "��������", 
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
	parent.parent.GTab.addTab("warninfoWin", "�ͻ�������ͼ\t&nbsp;&nbsp;&nbsp;�ͻ���ţ�"+customerNum+"   �ͻ����ƣ�"+chineseName, "/gbicc-com-pages/riskview/ftl/riskView.ftl?customerNum="+customerNum+"&chineseName="+encodeURI(encodeURI(chineseName))+"&loanCardNum="+loanCardNum);
}
function readFinaInte_onClick(){
	var customerNum =TCmCustomer_dataset.getValue("custcode");
	var chineseName =TCmCustomer_dataset.getValue("custname");
	var paramMap=new Map();
	paramMap.put("customerNum",customerNum);
	paramMap.put("chineseName",chineseName);
	parent.parent.GTab.addTab("warninfoWin2", "�������\t&nbsp;&nbsp;&nbsp;�ͻ���ţ�"+customerNum+"   �ͻ����ƣ�"+chineseName, "/gbicc-com-pages/FinanciaAnalysis/ftl/FinanceAnalysis.ftl?customerNum="+customerNum+"&chineseName="+chineseName);
}
function readFundMoni_onClick(){
	var customerNum =TCmCustomer_dataset.getValue("custcode");
	var chineseName =TCmCustomer_dataset.getValue("custname");
	parent.parent.GTab.addTab("warninfoWin3", "������Ŷ�\t&nbsp;&nbsp;&nbsp;�ͻ���ţ�"+customerNum+"   �ͻ����ƣ�"+chineseName,"/gbicc-com-pages/financialIndexAnalsis/ftl/financialIndexAnalsis.ftl?customerNum="+customerNum+"&chineseName="+chineseName);
}
function readZHReport_onClick(){
	alert("�˹�����δ������");
}
function TaskApprovalHistorySelectAllTable_onDbClick(){
	btnOpinion.click();
}
</script>
</@CommonQueryMacro.page>