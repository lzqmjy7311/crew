<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign userInfo_=Session["USER_SESSION_INFO"] />

<@CommonQueryMacro.page title="检查任务分派信息">
	<@CommonQueryMacro.CommonQuery id="LoanAccount" init="true" submitMode="selected">
		<@CommonQueryMacro.Interface id="LoanAccountInterface" label="请输入查询条件" showButton="false" labelwidth="100" colNm=8 />
		<div align="center" style="margin-bottom:10px">
			<@CommonQueryMacro.InterfaceButton desc="查询" />
			<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
		</div>
		<@CommonQueryMacro.DataTable id="LoanAccountTable" readonly="true" paginationbar="btnDistribute,btnDistributes,btnDistributeAll" 
		fieldStr="select,loanacno[150],custname[150],dutyInfo[200],prodid[100],prodname[200],acflag[80],acflag2[100],riskflag[80],overbal[100],operidName[100],bankidName[100]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.FloatWindow id="distributeFW" modal="true" label="检查任务分派(单笔)" 
	resize="true" minimize="false" width="900" height="480" maximize="true" closure="true" show="false" defaultZoom="normal">
	<table>
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.CommonQuery id="LoanAccount" init="true" submitMode="selected">
					<@CommonQueryMacro.Group id="distributeGroup" label="基本信息" colNm=4 labelwidth="150" 
					fieldStr="loanacno,bankidName,prodid,prodname,custid,custname,acflag,riskflag"/>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<@CommonQueryMacro.CommonQuery id="LoanAccountDutyDistribute" init="false" submitMode="current">
					<@CommonQueryMacro.Group id="distributeGroup" label="分派信息" colNm=4 labelwidth="150" 
					fieldStr="oldCheckUser,checkUser,distDt,remark,operOrgName,operUserName"/>
					<br/><center>
						<@CommonQueryMacro.Button id="btnSubmit" />
						<@CommonQueryMacro.Button id="btnSubmitTrue" />
						<@CommonQueryMacro.Button id="btnCancel" />
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
	</@CommonQueryMacro.FloatWindow>
	<@CommonQueryMacro.FloatWindow id="muchDistributeFW" modal="true" label="检查任务分派(批量)" 
	resize="true" minimize="false" width="1000" height="650" maximize="true" closure="true" show="false" defaultZoom="normal">
	<div name='group1' class="group" style="width:98%">
	    <table width="100%" class="grouptable" height="100%" style="table-layout: auto;">
	    	<tr>
				<td align="left" nowrap style="width:45%">
					<@CommonQueryMacro.CommonQuery id="OldCheckUser" init="true" submitMode="all">
						<@CommonQueryMacro.DataTable id="OldCheckUserTable" title="分派前检查人" height="100" simpleMode="true" nowrap="true" readonly="true" pageCache="false" pagination="false"
							fieldStr="brcode[60],brname[150],tlrno[70],tlrname[80]" width="100%" hasFrame="true"/>
					</@CommonQueryMacro.CommonQuery>
				</td>
				<td width="width:10%"></td>
				<td class="labeltd" valign=center align="left" nowrap style="width:45%">
				</td>
	    	</tr>
	    	<tr>
	    		<td>
	    			&nbsp;
	    		</td>
	    	</tr>
	        <tr id="text_TR" fieldId="text">
				<td align="left" nowrap style="width:45%">
					<@CommonQueryMacro.CommonQuery id="SelectCheckUser" init="true" submitMode="current">
						<@CommonQueryMacro.DataTable id="SelectCheckUserTable" title="可选择检查人" height="150" simpleMode="true" nowrap="true" readonly="true" pageCache="false" pagination="false"
							fieldStr="select,brcode[60],brname[150],tlrno[70],tlrname[80]" width="100%" hasFrame="true"/>
					</@CommonQueryMacro.CommonQuery>
				</td>
				<td width="width:10%">
					<center>
						<@CommonQueryMacro.SimpleButton id="btn5" desc="添加->" onclick="addMoveOption()" icon="" plain="false" />
					</center>
					<br/>
					<center>
						<@CommonQueryMacro.SimpleButton id="btn6" desc="<-删除" onclick="delMoveOption()" icon="" plain="false" />
					</center>
				</td>
				<td valign=center align="left" nowrap style="width:45%">
					<@CommonQueryMacro.CommonQuery id="CheckUser" init="true" submitMode="all">
						<@CommonQueryMacro.DataTable id="CheckUserTable" title="分派后检查人" height="150" simpleMode="true" nowrap="true" readonly="true" pageCache="false" pagination="false"
							fieldStr="select,brcode[60],brname[150],tlrno[70],tlrname[80]" width="100%" hasFrame="true"/>
					</@CommonQueryMacro.CommonQuery>
				</td>
			</tr>
	     </table>
	</div>
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="LoanAccountDutyDistribute" init="false" submitMode="current">
					<@CommonQueryMacro.Group id="muchDistributeGroup" label="分派信息" colNm=4 labelwidth="150" 
					fieldStr="distPrinciple,distQuantity,distDt,remark,operUserName,operOrgName"/>
					<br/><center>
						<@CommonQueryMacro.Button id="btnMuchSubmit" />
						<@CommonQueryMacro.Button id="btnMuchSubmitTrue" />
						<@CommonQueryMacro.Button id="btnMuchSubmitAll" />
						<@CommonQueryMacro.Button id="btnMuchSubmitAllTrue" />
						<@CommonQueryMacro.Button id="btnMuchCancel" />
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
	</@CommonQueryMacro.FloatWindow>
<script>
	var submitWindow=null;
	var submitAllWindow=null;
	var distType="1";
	function initCallGetter_post(){
		$("a[id=btnSubmitTrue]").hide();
		$("a[id=btnMuchSubmitAll]").hide();
		$("a[id=btnMuchSubmitTrue]").hide();
		$("a[id=btnMuchSubmitAllTrue]").hide();
	}
	//查询区贷后检查人按键弹起事件
	function dutyid_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}
	//查询区贷后检查人打开前事件
	function dutyid_DropDown_beforeOpen(dropDown){
		var bank=LoanAccount_interface_dataset.getValue("bank");
		subAutoUserTree_DropDownDataset.setParameter("orgId",bank);
		dutyid_DropDown.cached=false;//让qGroupId不存入缓存
	}
	function btnMuchSubmitAll_onClick(){
		var record=CheckUser_dataset.getFirstRecord();
        if(!record){
        	top.easyMsg.info("请选择分派后检查人！");
    		return;
        }
        var count=0;
        while(record){
        	count++;
			record=record.getNextRecord();
		}
		var distPrinciple=LoanAccountDutyDistribute_dataset.getValue("distPrinciple");
		var distQuantity=LoanAccountDutyDistribute_dataset.getValue("distQuantity");
		if(distPrinciple=="1" && count>distQuantity){
			top.easyMsg.info("选择【本次分派总量平均原则】时[分派后检查人]数量不能大于[分派笔数]！");
    		return;
		}
		var vd=LoanAccountDutyDistribute_dataset.validate();
		if(!vd){
			top.easyMsg.info("页面中存在不合法的字段，请检查后再提交！");
			return false;
		}
		var orgId=user_info.orgId;
		var roleId="555";
		submitAllWindow=openSubWin("submitAllWindow","任务发送至","/gbicc-pages/bpm/ftl/loan_account_duty_task_assignee.ftl?orgId="+orgId+"&roleId="+roleId,"600","400");
	}
	function btnMuchSubmitAllTrue_onClickCheck(){
		var bank=LoanAccount_interface_dataset.getValue("bank");
		var acctNo=LoanAccount_interface_dataset.getValue("loanacno");
		var prodname=LoanAccount_interface_dataset.getValue("prodname");
		var custname=LoanAccount_interface_dataset.getValue("custname");
		var acflag=LoanAccount_interface_dataset.getValue("acflag");
		var acflag2=LoanAccount_interface_dataset.getValue("acflag2");
		var riskflag=LoanAccount_interface_dataset.getValue("riskflag");
		var dutyid=LoanAccount_interface_dataset.getValue("dutyid");
		var condition='{acctNo:"'+acctNo+'",prodname:"'+prodname+'",custname:"'+custname+'",acflag:"'+acflag+'",acflag2:"'+acflag2+'",riskflag:"'+riskflag+'",dutyid:"'+dutyid+'"}';
		LoanAccountDutyDistribute_dataset.setParameter("condition",condition);
		LoanAccountDutyDistribute_dataset.setParameter("bankid",bank);
		LoanAccountDutyDistribute_dataset.setParameter("op","submit");
	}
	function btnDistributeAll_onClick(){
		var bank=LoanAccount_interface_dataset.getValue("bank");
		var bankName=LoanAccount_interface_dataset.getValue("bankName");
		var acctNo=LoanAccount_interface_dataset.getValue("loanacno");
		var prodname=LoanAccount_interface_dataset.getValue("prodname");
		var custname=LoanAccount_interface_dataset.getValue("custname");
		var acflag=LoanAccount_interface_dataset.getValue("acflag");
		var acflag2=LoanAccount_interface_dataset.getValue("acflag2");
		var riskflag=LoanAccount_interface_dataset.getValue("riskflag");
		var dutyid=LoanAccount_interface_dataset.getValue("dutyid");
		var dutyidName=LoanAccount_interface_dataset.getValue("dutyidName");
		if(bank==null || bank==""){
			top.easyMsg.info("请在查询区先过滤要全部分派的经办行！");
			return;
		}
		if(bank==bankName){
			top.easyMsg.info("经办行手输无效！");
			return;
		}
		if(dutyid && dutyid==dutyidName){
			top.easyMsg.info("贷后检查人手输无效！");
			return;
		}
		if(acctNo==null){
			acctNo="";
		}
		if(prodname==null){
			prodname="";
		}
		if(custname==null){
			custname="";
		}
		if(acflag==null){
			acflag="";
		}
		if(acflag2==null){
			acflag2="";
		}
		if(riskflag==null){
			riskflag="";
		}
		if(dutyid==null){
			dutyid="";
		}
		var condition='{acctNo:"'+acctNo+'",prodname:"'+prodname+'",custname:"'+custname+'",acflag:"'+acflag+'",acflag2:"'+acflag2+'",riskflag:"'+riskflag+'",dutyid:"'+dutyid+'"}';
		DWREngine.setAsync(false);
		var bool=true;
		var elimLoan="";
		var count=0;
		AccountDutyDistribute.dwrGetLoanAccountNos(bank,condition,distType,function(y){
			if(y[0]!=null && y[0]!=""){
				elimLoan=y[0];
			}
			if(y[1]==null || y[1]=="0"){
				bool=false;
			}else{
				count=y[1];
			}
		});
		if(bool){
			if(elimLoan!=""){
				top.easyMsg.info("以下贷款帐号已发送分派申请，本次申请将排除："+elimLoan);
			}
			$("a[id=btnMuchSubmitAll]").show();
			$("a[id=btnMuchSubmit]").hide();
			setPageFieldsNullFun();
			subwindow_muchDistributeFW.show();
			//加载分派前检查人
			OldCheckUser_dataset.setParameter("loanacnos",null);
			OldCheckUser_dataset.setParameter("flag","all");
			OldCheckUser_dataset.setParameter("type",distType);
			OldCheckUser_dataset.setParameter("condition",condition);
			OldCheckUser_dataset.setParameter("bankid",bank);
			OldCheckUser_dataset.flushData(1);
			//加载可选择检查人
			SelectCheckUser_dataset.setParameter("orgId",bank);
			SelectCheckUser_dataset.setParameter("checkUserIds",null);
			SelectCheckUser_dataset.flushData(1);
			
			LoanAccountDutyDistribute_dataset.setValue("distQuantity",count);
			TaskVariable.getSystemCurrentDate(null,function(y){
				LoanAccountDutyDistribute_dataset.setValue("distDt",y);
			});
			LoanAccountDutyDistribute_dataset.setValue("operUserId",'${userInfo_.tlrNo}');
			LoanAccountDutyDistribute_dataset.setValue("operUserName",'${userInfo_.tlrName}');
			LoanAccountDutyDistribute_dataset.setValue("operOrgId",'${userInfo_.brCode}');
			LoanAccountDutyDistribute_dataset.setValue("operOrgName",'${userInfo_.brName}');
			LoanAccountDutyDistribute_dataset.setFieldRequired("distPrinciple",true);
		}else{
			top.easyMsg.info("该机构下无任何可转移的数据！");
		}
		DWREngine.setAsync(true);
	}
	//取消
	function mushSubmitAllCancelFun(){
		LoanAccountDutyDistribute_dataset.setParameter("taskAssignee",null);
		submitAllWindow.close();
	}
	//提交
	function muchSubmitAllFun(taskAssignee){
		LoanAccountDutyDistribute_dataset.setParameter("taskAssignee",taskAssignee);
		btnMuchSubmitAllTrue.click();
	}
	function btnDistribute_onClick(){
		var record=LoanAccount_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("select")==true){
				records.push(record);
			}
			record=record.getNextRecord();
		}
		if(!(records.length>0)){
			top.easyMsg.info("请选择要分派的任务！");
			return;
		}
		if(records.length>1){
			top.easyMsg.info("多任务分派请使用【批量分派】功能！");
			return;
		}
		//检查该帐号是否已发送分派任务，且尚未审核完成。
		var loanacno=records[0].getValue("loanacno");
		AccountDutyDistribute.dwrFindDistributeRuningProcess(loanacno,distType,function(y){
			if(y=="false"){
				setPageFieldsNullFun();
				subwindow_distributeFW.show();
				LoanAccountDutyDistribute_dataset.setValue("oldCheckUser",records[0].getValue("dutyInfo"));
				LoanAccountDutyDistribute_dataset.setFieldRequired("checkUser",true);
				TaskVariable.getSystemCurrentDate(null,function(y){
					LoanAccountDutyDistribute_dataset.setValue("distDt",y);
				});
				LoanAccountDutyDistribute_dataset.setValue("operUserId",'${userInfo_.tlrNo}');
				LoanAccountDutyDistribute_dataset.setValue("operUserName",'${userInfo_.tlrName}');
				LoanAccountDutyDistribute_dataset.setValue("operOrgId",'${userInfo_.brCode}');
				LoanAccountDutyDistribute_dataset.setValue("operOrgName",'${userInfo_.brName}');
				LoanAccountDutyDistribute_dataset.setValue("loanacnoId",loanacno);
			}else{
				top.easyMsg.info("该货款帐号已发送分派申请，请等待审核结束后再执行操作！");
				return;
			}
		});
	}
	
	//机构打开前
	function bank_DropDown_beforeOpen(dropDown){
		subAutoOrgTree_DropDownDataset.setParameter("currentUserOrgId",user_info.orgId);
	}
	//输入机构
	function bank_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}
	
	//分派后检查人
	function checkUser_DropDown_beforeOpen(dropDown){
		var bankidId=LoanAccount_dataset.getValue("bankidId");//获取经办行
		if(!bankidId){
			return "经办行为空,无法进行分派操作!";
		}
		subAutoUserAndOrg_DropDownDataset.setParameter("orgId",bankidId);
		
		var oldCheckUser=LoanAccountDutyDistribute_dataset.getValue("oldCheckUser");
		if(oldCheckUser.indexOf(",")>-1){
			var str=oldCheckUser.split(",");
			subAutoUserAndOrg_DropDownDataset.setParameter("currAssignee",str[1]);
		}else{
			subAutoUserAndOrg_DropDownDataset.setParameter("currAssignee","");
		}
		checkUser_DropDown.cached=false;//让qGroupId不存入缓存
	}
	//分派后检查人按键弹起事件
	function checkUser_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}
	function btnDistributes_onClick(){
		var record=LoanAccount_dataset.getFirstRecord();
		var records=[];
		while(record){
			if(record.getValue("select")==true){
				records.push(record);
			}
			record=record.getNextRecord();
		}
		if(!(records.length>0)){
			top.easyMsg.info("请选择要分派的任务！");
			return;
		}
		if(records.length<2){
			top.easyMsg.info("单任务分派请使用【分派】功能！");
			return;
		}
		var records2=records;
		for(var i=0;i<records.length;i++){
			for(var k=0;k<records2.length;k++){
				if(records[i].getValue("bankidId")!=records2[k].getValue("bankidId")){
					top.easyMsg.info("只能同时分派同一机构下的任务！");
					return;
				}
			}
		}
		var bool="false";
		DWREngine.setAsync(false);
		var loanacnos="";
		var orgId=records[0].getValue("bankidId");
		for(var i=0;i<records.length;i++){
			var loanacno=records[i].getValue("loanacno");
			loanacnos=loanacnos+loanacno+",";
			AccountDutyDistribute.dwrFindDistributeRuningProcess(loanacno,distType,function(y){
				if(y=="true"){
					bool="true";
				}
			});
		}
		if(bool=="false"){//弹出窗口，初始化页面
			$("a[id=btnMuchSubmitAll]").hide();
			$("a[id=btnMuchSubmit]").show();
			setPageFieldsNullFun();
			subwindow_muchDistributeFW.show();
			
			//加载分派前检查人
			OldCheckUser_dataset.setParameter("loanacnos",loanacnos);
			OldCheckUser_dataset.setParameter("flag",null);
			OldCheckUser_dataset.setParameter("type",distType);
			OldCheckUser_dataset.flushData(1);
			//加载可选择检查人
			SelectCheckUser_dataset.setParameter("orgId",orgId);
			SelectCheckUser_dataset.setParameter("checkUserIds",null);
			SelectCheckUser_dataset.flushData(1);
			
			LoanAccountDutyDistribute_dataset.setValue("distQuantity",records.length);
			TaskVariable.getSystemCurrentDate(null,function(y){
				LoanAccountDutyDistribute_dataset.setValue("distDt",y);
			});
			LoanAccountDutyDistribute_dataset.setValue("operUserId",'${userInfo_.tlrNo}');
			LoanAccountDutyDistribute_dataset.setValue("operUserName",'${userInfo_.tlrName}');
			LoanAccountDutyDistribute_dataset.setValue("operOrgId",'${userInfo_.brCode}');
			LoanAccountDutyDistribute_dataset.setValue("operOrgName",'${userInfo_.brName}');
			LoanAccountDutyDistribute_dataset.setFieldRequired("distPrinciple",true);
		}else{
			top.easyMsg.info("货款帐号【"+loanacno+"】已发送分派申请，请等待审核结束后再执行操作！");
		}
		DWREngine.setAsync(true);
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
	//添加
    function addMoveOption(){
    	var record=SelectCheckUser_dataset.getFirstRecord();
    	var bool=false;
    	while(record){
			if(record.getValue("select")==true){
				bool=true;
				//复制
				CheckUser_dataset.insertRecord("end");
				record.setValue("select",false);//复制前把勾选框取消
				CheckUser_dataset.copyRecord(record);
				//删除
				SelectCheckUser_dataset.setRecord(record);
				SelectCheckUser_dataset.deleteRecord();
			}
			record=record.getNextRecord();
		}
    	if(!bool){
    		top.easyMsg.info("请先勾选左侧要添加的检查人！");
    		return;
    	}
    }
	//删除
	function delMoveOption(){
		var record=CheckUser_dataset.getFirstRecord();
    	var bool=false;
    	while(record){
			if(record.getValue("select")==true){
				bool=true;
				//复制
				SelectCheckUser_dataset.insertRecord("end");
				record.setValue("select",false);//复制前把勾选框取消
				SelectCheckUser_dataset.copyRecord(record);
				//删除
				CheckUser_dataset.setRecord(record);
				CheckUser_dataset.deleteRecord();
			}
			record=record.getNextRecord();
		}
    	if(!bool){
    		top.easyMsg.info("请先勾选右侧要删除的检查人！");
    		return;
    	}
	}
	//设置dataset所有字段值为Null
	function setPageFieldsNullFun(){
		var fieldName="";
		for(var i=0;i<LoanAccountDutyDistribute_dataset.fields.length;i++){
			fieldName=LoanAccountDutyDistribute_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				LoanAccountDutyDistribute_dataset.setValue(fieldName,null);
			}
		}
	}
	function distributeFW_floatWindow_beforeClose(){
		LoanAccountDutyDistribute_dataset.setFieldRequired("checkUser",false);
		CheckUser_dataset.flushData(1);
		return true;
	}
	function distributeFW_floatWindow_beforeHide(){
		LoanAccountDutyDistribute_dataset.setFieldRequired("checkUser",false);
		CheckUser_dataset.flushData(1);
		return true;
	}
	function muchDistributeFW_floatWindow_beforeClose(){
		LoanAccountDutyDistribute_dataset.setFieldRequired("distPrinciple",false);
		CheckUser_dataset.flushData(1);
		return true;
	}
	function muchDistributeFW_floatWindow_beforeHide(){
		LoanAccountDutyDistribute_dataset.setFieldRequired("distPrinciple",false);
		CheckUser_dataset.flushData(1);
		return true;
	}
	function btnMuchSubmit_onClick(){
		var record=CheckUser_dataset.getFirstRecord();
        if(!record){
        	top.easyMsg.info("请选择分派后检查人！");
    		return;
        }
        var count=0;
        while(record){
        	count++;
			record=record.getNextRecord();
		}
		var distPrinciple=LoanAccountDutyDistribute_dataset.getValue("distPrinciple");
		var distQuantity=LoanAccountDutyDistribute_dataset.getValue("distQuantity");
		if(distPrinciple=="1" && count>distQuantity){
			top.easyMsg.info("选择【本次分派总量平均原则】时[分派后检查人]数量不能大于[分派笔数]！");
    		return;
		}
		var vd=LoanAccountDutyDistribute_dataset.validate();
		if(!vd){
			top.easyMsg.info("页面中存在不合法的字段，请检查后再提交！");
			return false;
		}
		var orgId=user_info.orgId;
		var roleId="555";
		submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+roleId,"600","400");
	}
	function btnMuchSubmitTrue_onClickCheck(){
		var record=LoanAccount_dataset.getFirstRecord();
		var loanacnos="";
		while(record){
			if(record.getValue("select")==true){
				loanacnos=loanacnos+record.getValue("loanacno")+",";
			}
			record=record.getNextRecord();
		}
        LoanAccountDutyDistribute_dataset.setParameter("op","submit");
        if(loanacnos!=""){
        	loanacnos=loanacnos.substring(0,loanacnos.length-1);
			LoanAccountDutyDistribute_dataset.setParameter("loanacnos",loanacnos);
        }
	}
	//取消
	function cancelFun(){
		LoanAccountDutyDistribute_dataset.setParameter("taskAssignee",null);
		submitWindow.close();
	}
	//提交
	function submitFun(taskAssignee){
		LoanAccountDutyDistribute_dataset.setParameter("taskAssignee",taskAssignee);
		var distQuantity=LoanAccountDutyDistribute_dataset.getValue("distQuantity");
		if(distQuantity && distQuantity>1){
			btnMuchSubmitTrue.click();
		}else{
			btnSubmitTrue.click();
		}
	}
	function btnSubmit_onClick(){
		var orgId=user_info.orgId;
		var roleId="555";//对私-一级支行贷后主管岗角色ID
		var checkUser=LoanAccountDutyDistribute_dataset.getValue("checkUser");
		if(!checkUser){
			top.easyMsg.info("请选择分派后检查人！");
			return false;
		}
		var vd=LoanAccountDutyDistribute_dataset.validate();
		if(!vd){
			top.easyMsg.info("页面中存在不合法的字段，请检查后再提交！");
			return false;
		}
		submitWindow=openSubWin("submitWindow","任务发送至","/gbicc-pages/bpm/ftl/task_assignee.ftl?orgId="+orgId+"&roleId="+roleId,"600","400");
	}
	function btnSubmitTrue_onClickCheck(){
		LoanAccountDutyDistribute_dataset.setParameter("op","submit");
	}
	function btnReset_onClick(){
		LoanAccount_interface_dataset.clearData();
	}
 	//提交后关闭页面，刷新表格
	function btnSubmitTrue_postSubmit(button) {
		if(submitWindow){
			submitWindow.close();
		}
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_distributeFW.close();
		flushCurrentPage();
	}
	function btnMuchSubmitTrue_postSubmit(button) {
		if(submitWindow){
			submitWindow.close();
		}
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_muchDistributeFW.close();
		flushCurrentPage();
		CheckUser_dataset.flushData(1);
	}
	function btnMuchSubmitAllTrue_postSubmit(button) {
		if(submitAllWindow){
			submitAllWindow.close();
		}
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_muchDistributeFW.close();
		flushCurrentPage();
		CheckUser_dataset.flushData(1);
	}
 	function btnCancel_onClick(){
 		subwindow_distributeFW.close();
 	}
 	function btnMuchCancel_onClick(){
 		subwindow_muchDistributeFW.close();
 	}
	//刷新当前页
	function flushCurrentPage() {
		LoanAccount_dataset.flushData(LoanAccount_dataset.pageIndex);
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/AccountDutyDistribute.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>