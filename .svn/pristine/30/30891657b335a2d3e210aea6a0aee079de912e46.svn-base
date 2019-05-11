<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign userInfo_=Session["USER_SESSION_INFO"] />

<@CommonQueryMacro.page title="检查任务分派处理">
<table>
	<@CommonQueryMacro.CommonQuery id="LoanAccountDutyDistribute" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="LoanAccountDutyDistributeTable" readonly="true" paginationbar="btnHandle,btnDel,btnRead" 
		fieldStr="distFlag,status,operOrgName,operUserName,distDt" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.FloatWindow id="LoanAccountDutyDistributeFW" modal="true" label="检查任务分派处理(单笔)" 
	resize="true" minimize="false" width="900" height="550" maximize="true" closure="true" show="false" defaultZoom="normal">
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="LoanAccount" init="false" submitMode="selected">
					<@CommonQueryMacro.Group id="LoanAccountGroup" label="基本信息" colNm=4 labelwidth="150" 
					fieldStr="loanacno,bankidName,prodid,prodname,custid,custname,acflag,riskflag"/>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="LoanAccountDutyDistribute" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="distributeGroup" label="分派信息" colNm=4 labelwidth="150" 
					fieldStr="oldCheckUser,checkUser,distDt,remark,operOrgName,operUserName,opinion3"/>
					<br/><center>
						<@CommonQueryMacro.Button id="btnSubmit" />
						<@CommonQueryMacro.Button id="btnAgree" />
						<@CommonQueryMacro.Button id="btnBack" />
						<@CommonQueryMacro.Button id="btnCancel" />
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable" paginationbar="btnOpinion"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW" modal="true" label="查看意见" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup" label="" colNm=4 fieldStr="opinion"/>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</@CommonQueryMacro.FloatWindow>
	<@CommonQueryMacro.FloatWindow id="LoanAccountDutyMuchDistributeFW" modal="true" label="检查任务分派处理(批量)" 
	resize="true" minimize="false" width="1000" height="650" maximize="true" closure="true" show="false" defaultZoom="normal">
	<div name='group1' class="group" style="width:98%">
	    <table width="100%" class="grouptable" height="100%" style="table-layout: auto;">
	    	<tr>
	    		<td align="left" nowrap style="width:45%">
					<@CommonQueryMacro.CommonQuery id="OldCheckUser" init="true" submitMode="current">
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
				<@CommonQueryMacro.CommonQuery id="LoanAccountDutyDistribute" mode="1" init="true" submitMode="current">
					<@CommonQueryMacro.Group id="muchDistributeGroup" label="分派信息" colNm=4 labelwidth="150" 
					fieldStr="distPrinciple,distQuantity,distDt,remark,operUserName,operOrgName,opinion2"/>
					<br/><center>
						<@CommonQueryMacro.Button id="btnTaskMuchSubmit" />
						<@CommonQueryMacro.Button id="btnMuchAgree" />
						<@CommonQueryMacro.Button id="btnMuchBack" />
						<@CommonQueryMacro.Button id="btnTaskMuchCancel" />
					</center>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="TaskApprovalHistory" mode="1" init="true" submitMode="current">
					<@CommonQueryMacro.GroupBox id="taskApprovalHistoryBox2" label="审批历史">
						<@CommonQueryMacro.DataTable id="taskApprovalHistoryTable2" paginationbar="btnOpinion2"
						fieldStr="taskName,assignee,startTime,endTime,operation,opinionGrid" width="100%" hasFrame="true"/>
						<@CommonQueryMacro.FloatWindow id="taskApprovalHistoryFW2" modal="true" label="查看意见" position="center" 
							closure="true" show="false" defaultZoom="normal">
							<@CommonQueryMacro.Group id="taskApprovalHistoryGroup2" label="" colNm=4 fieldStr="opinion"/>
						</@CommonQueryMacro.FloatWindow>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
	</@CommonQueryMacro.FloatWindow>
</table>
<script>
	var distType="1";
	function initCallGetter_post(){
		//只有一级贷后主管岗才能看到该处理与删除两个按扭。
		if(user_info.roleId=="555"){
			$("a[id=btnHandle]").show();
			$("a[id=btnDel]").show();
		}else{
			$("a[id=btnHandle]").hide();
			$("a[id=btnDel]").hide();
		}
	}
	function LoanAccountDutyDistributeTable_oldcheckuser_onRefresh(cell,value,record){
		if(record && value && value.indexOf(";")>-1){//当存在记录时
			var str=value.replace(";","<br/>");
			cell.innerHTML=str;
		}else{
			cell.innerHTML=value;
		}
	}
	function LoanAccountDutyDistributeTable_checkuserdesc_onRefresh(cell,value,record){
		if(record && value && value.indexOf(";")>-1){//当存在记录时
			var str=value.replace(";","<br/>");
			cell.innerHTML=str;
		}else if(record && value){
			cell.innerHTML=value;
		}
	}
	function btnHandle_onClick(){
		var businessId=LoanAccountDutyDistribute_dataset.getValue("id");
		var distFlag=LoanAccountDutyDistribute_dataset.getValue("distFlag");
		var status=LoanAccountDutyDistribute_dataset.getValue("status");
		var loanacnoId=LoanAccountDutyDistribute_dataset.getValue("loanacnoId");
		LoanAccount_dataset.setParameter("loanacno",loanacnoId);
		LoanAccount_dataset.flushData();
		if(status!="1"){
			top.easyMsg.info("只能处理【待审核】状态的记录！");
			return;
		}
		if(distFlag=="1"){
			subwindow_LoanAccountDutyDistributeFW.show();
			LoanAccountDutyDistribute_dataset.setValue("checkUserName",LoanAccountDutyDistribute_dataset.getValue("checkUserDesc"));
			
			var fields=["opinion3","opinion2"];
			TaskVariable.findTaskVariable(businessId,function(y){
				if(y.pageReadOnly!=null && y.pageReadOnly=="true"){
					//设置页面只读
	        		setPageReadOnlyFun();
	        		setPageReadOnlyFieldsFun(fields,false);
	        		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion3",false);
	        		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion2",false);
	        		$("a[id=btnSubmit]").hide();
	        		$("a[id=btnAgree]").show();
	        		$("a[id=btnBack]").show();
				}else{
					LoanAccountDutyDistribute_dataset.setFieldHidden("opinion3",true);
					LoanAccountDutyDistribute_dataset.setFieldHidden("opinion2",true);
					$("a[id=btnSubmit]").show();
					$("a[id=btnAgree]").hide();
	        		$("a[id=btnBack]").hide();
				}
			});
		}else{
			subwindow_LoanAccountDutyMuchDistributeFW.show();
			var orgId=LoanAccountDutyDistribute_dataset.getValue("orgId");
			var loanacnos=LoanAccountDutyDistribute_dataset.getValue("loanacnos");
			//加载分派前检查人
			OldCheckUser_dataset.setParameter("loanacnos",loanacnos);
			OldCheckUser_dataset.setParameter("flag",null);
			OldCheckUser_dataset.setParameter("type",distType);
			OldCheckUser_dataset.setParameter("condition",null);
			OldCheckUser_dataset.setParameter("bankid",null);
			OldCheckUser_dataset.flushData(1);
			//加载分派后检查人
			CheckUser_dataset.setParameter("distId",businessId);
			CheckUser_dataset.flushData(1);
			//加载可选择检查人
			var checkUserRecord=CheckUser_dataset.getFirstRecord();
			checkUserIds="";
			while(checkUserRecord){
				checkUserIds=checkUserIds+checkUserRecord.getValue("tlrno")+",";
				checkUserRecord=checkUserRecord.getNextRecord();
			}
			if(checkUserIds!=""){
				checkUserIds=checkUserIds.substring(0,checkUserIds.length-1);
			}
			SelectCheckUser_dataset.setParameter("orgId",orgId);
			SelectCheckUser_dataset.setParameter("checkUserIds",checkUserIds);
			SelectCheckUser_dataset.flushData(1);
			
			var fields=["opinion3","opinion2"];
			TaskVariable.findTaskVariable(businessId,function(y){
				if(y.pageReadOnly!=null && y.pageReadOnly=="true"){
					//设置页面只读
	        		setPageReadOnlyFun();
	        		setPageReadOnlyFieldsFun(fields,false);
	        		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion2",false);
	        		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion3",false);
	        		$("a[id=btnTaskMuchSubmit]").hide();
	        		$("a[id=btnMuchAgree]").show();
	        		$("a[id=btnMuchBack]").show();
	        		
	        		$("#oldCheckUser").attr("disabled","disabled");
	    			$("#left").attr("disabled","disabled");
	    			$("#right").attr("disabled","disabled");
	    			btn5.disable(true);
	    			btn6.disable(true);
				}else{
					LoanAccountDutyDistribute_dataset.setFieldHidden("opinion2",true);
					LoanAccountDutyDistribute_dataset.setFieldHidden("opinion3",true);
					$("a[id=btnTaskMuchSubmit]").show();
					$("a[id=btnMuchAgree]").hide();
	        		$("a[id=btnMuchBack]").hide();
	        		
	        		$("#oldCheckUser").removeAttr("disabled");
	    			$("#left").removeAttr("disabled");
	    			$("#right").removeAttr("disabled");
	    			btn5.disable(false);
	    			btn6.disable(false);
				}
			});
		}
		TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
	}
	function btnRead_onClick(){
		var businessId=LoanAccountDutyDistribute_dataset.getValue("id");
		var distFlag=LoanAccountDutyDistribute_dataset.getValue("distFlag");
		var loanacnoId=LoanAccountDutyDistribute_dataset.getValue("loanacnoId");
		LoanAccount_dataset.setParameter("loanacno",loanacnoId);
		LoanAccount_dataset.flushData();
		$("a[id=btnCancel]").hide();
		$("a[id=btnTaskMuchCancel]").hide();
		if(distFlag=="1"){
			subwindow_LoanAccountDutyDistributeFW.show();
			LoanAccountDutyDistribute_dataset.setValue("checkUserName",LoanAccountDutyDistribute_dataset.getValue("checkUserDesc"));
			//设置页面只读
    		setPageReadOnlyFun();
    		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion3",true);
    		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion2",true);
    		$("a[id=btnSubmit]").hide();
    		$("a[id=btnAgree]").hide();
    		$("a[id=btnBack]").hide();
		}else{
			subwindow_LoanAccountDutyMuchDistributeFW.show();
			var orgId=LoanAccountDutyDistribute_dataset.getValue("orgId");
			var loanacnos=LoanAccountDutyDistribute_dataset.getValue("loanacnos");
			//加载分派前检查人
			OldCheckUser_dataset.setParameter("loanacnos",loanacnos);
			OldCheckUser_dataset.setParameter("flag",null);
			OldCheckUser_dataset.setParameter("type",distType);
			OldCheckUser_dataset.setParameter("condition",null);
			OldCheckUser_dataset.setParameter("bankid",null);
			OldCheckUser_dataset.flushData(1);
			//加载分派后检查人
			CheckUser_dataset.setParameter("distId",businessId);
			CheckUser_dataset.flushData(1);
			//加载可选择检查人
			var checkUserRecord=CheckUser_dataset.getFirstRecord();
			checkUserIds="";
			while(checkUserRecord){
				checkUserIds=checkUserIds+checkUserRecord.getValue("tlrno")+",";
				checkUserRecord=checkUserRecord.getNextRecord();
			}
			if(checkUserIds!=""){
				checkUserIds=checkUserIds.substring(0,checkUserIds.length-1);
			}
			SelectCheckUser_dataset.setParameter("orgId",orgId);
			SelectCheckUser_dataset.setParameter("checkUserIds",checkUserIds);
			SelectCheckUser_dataset.flushData(1);
			//设置页面只读
    		setPageReadOnlyFun();
    		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion2",false);
    		LoanAccountDutyDistribute_dataset.setFieldHidden("opinion3",false);
    		$("a[id=btnTaskMuchSubmit]").hide();
    		$("a[id=btnMuchAgree]").hide();
    		$("a[id=btnMuchBack]").hide();
    		
			btn5.disable(true);
			btn6.disable(true);
		}
		TaskApprovalHistory_dataset.setParameter("businessId",businessId);
		TaskApprovalHistory_dataset.flushData(TaskApprovalHistory_dataset.pageIndex);
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
	//移动
    function moveOption(obj1, obj2){
		for(var i = obj1.options.length - 1 ; i >= 0 ; i--){
			if(obj1.options[i].selected){
				var opt = new Option(obj1.options[i].text,obj1.options[i].value);
				obj2.options.add(opt);
				obj1.remove(i);
			}
		}
    }
	//设置页面所有字段只读
	function setPageReadOnlyFun(){
		var fieldName="";
		for(var i=0;i<LoanAccountDutyDistribute_dataset.fields.length;i++){
			fieldName=LoanAccountDutyDistribute_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				LoanAccountDutyDistribute_dataset.setFieldReadOnly(fieldName,true);
			}
		}
	}
	function setPageReadOnlyFieldsFun(fields,bool){
		for(var i=0;i<fields.length;i++){
			LoanAccountDutyDistribute_dataset.setFieldReadOnly(fields[i],bool);
		}
	}
	//分派后检查人
	function checkUser_DropDown_beforeOpen(dropDown){
		var oldCheckUser=LoanAccountDutyDistribute_dataset.getValue("oldCheckUser");//获取分派前检查人机构
		var str=oldCheckUser.split(",");
		var qServerType=str[0];
		if(!qServerType){
			return "分派前检查人为空或者分派前检查人机构为空,无法进行分派操作!";
		}
		subAutoUserAndOrg_DropDownDataset.setParameter("orgId",qServerType);
		subAutoUserAndOrg_DropDownDataset.setParameter("currAssignee",str[2]);
		checkUser_DropDown.cached=false;//让qGroupId不存入缓存
	}
	//分派后检查人按键弹起事件
	function checkUser_DropDown_onKeyup(val){
		if(val.length>=0){
			return true;
		}
		return false;
	}
	function btnAgree_onClickCheck(){
		LoanAccountDutyDistribute_dataset.setParameter("op","submit");
	}
	function btnAgree_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_LoanAccountDutyDistributeFW.close();
		flushCurrentPage();
	}
	function btnMuchAgree_onClickCheck(){
		var str=LoanAccountDutyDistribute_dataset.getValue("checkUser");
 		var loanacnos=LoanAccountDutyDistribute_dataset.getValue("loanacnos");
 		var oldCheckUsers=LoanAccountDutyDistribute_dataset.getValue("oldCheckUser");
 		LoanAccountDutyDistribute_dataset.setParameter("checkUser",str);
        LoanAccountDutyDistribute_dataset.setParameter("loanacnos",loanacnos);
        LoanAccountDutyDistribute_dataset.setParameter("oldCheckUsers",oldCheckUsers);
		LoanAccountDutyDistribute_dataset.setParameter("op","submit");
	}
	function btnMuchAgree_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_LoanAccountDutyMuchDistributeFW.close();
		flushCurrentPage();
	}
	function btnSubmit_onClickCheck(){
		LoanAccountDutyDistribute_dataset.setParameter("op","submit");
	}
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_LoanAccountDutyDistributeFW.close();
		flushCurrentPage();
	}
	function btnTaskMuchSubmit_onClickCheck(){
		var obj = document.getElementById("right");
        var str = "";
        for(var i=0;i<obj.options.length;i++){
            str+=obj.options[i].value+",";
        }
        if(str==""){
        	top.easyMsg.info("请选择分派后检查人！");
    		return false;
        }
        var distPrinciple=LoanAccountDutyDistribute_dataset.getValue("distPrinciple");
		var distQuantity=LoanAccountDutyDistribute_dataset.getValue("distQuantity");
		if(distPrinciple=="1" && obj.options.length>distQuantity){
			top.easyMsg.info("选择【本次分派总量平均原则】时[分派后检查人]数量不能大于[分派笔数]！");
    		return false;
		}
		str=str.substring(0,str.length-1);
		var loanacnos=LoanAccountDutyDistribute_dataset.getValue("loanacnos");
 		var oldCheckUsers=LoanAccountDutyDistribute_dataset.getValue("oldCheckUser");
		LoanAccountDutyDistribute_dataset.setParameter("checkUser",str);
        LoanAccountDutyDistribute_dataset.setParameter("loanacnos",loanacnos);
        LoanAccountDutyDistribute_dataset.setParameter("oldCheckUsers",oldCheckUsers);
		LoanAccountDutyDistribute_dataset.setParameter("op","submit");
	}
	function btnTaskMuchSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_LoanAccountDutyMuchDistributeFW.close();
		flushCurrentPage();
	}
	function btnBack_onClickCheck(){
		LoanAccountDutyDistribute_dataset.setParameter("op","back");
	}
 	function btnBack_postSubmit(button){
 		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_LoanAccountDutyDistributeFW.close();
		flushCurrentPage();
 	}
 	function btnMuchBack_onClickCheck(){
 		var str=LoanAccountDutyDistribute_dataset.getValue("checkUser");
 		var loanacnos=LoanAccountDutyDistribute_dataset.getValue("loanacnos");
 		var oldCheckUsers=LoanAccountDutyDistribute_dataset.getValue("oldCheckUser");
 		LoanAccountDutyDistribute_dataset.setParameter("checkUser",str);
        LoanAccountDutyDistribute_dataset.setParameter("loanacnos",loanacnos);
        LoanAccountDutyDistribute_dataset.setParameter("oldCheckUsers",oldCheckUsers);
 		LoanAccountDutyDistribute_dataset.setParameter("op","back");
 	}
 	function btnMuchBack_postSubmit(button){
 		button.url="#";
		top.easyMsg.info("操作成功！");
		subwindow_LoanAccountDutyMuchDistributeFW.close();
		flushCurrentPage();
 	}
 	function btnCancel_onClick(){
 		subwindow_LoanAccountDutyDistributeFW.close();
 	}
 	function btnTaskMuchCancel_onClick(){
 		subwindow_LoanAccountDutyMuchDistributeFW.close();
 	}
 	function btnDel_onClickCheck(){
 		var status=LoanAccountDutyDistribute_dataset.getValue("status");
		if(status=="3"){
			top.easyMsg.info("【审核通过】状态的记录无法删除！");
			return false;
		}
 		return confirm("是否删除任务？");
 	}
 	function btnDel_postSubmit(button){
 		button.url="#";
		top.easyMsg.info("操作成功！");
		flushCurrentPage();
 	}
	//刷新当前页
	function flushCurrentPage() {
		LoanAccountDutyDistribute_dataset.flushData(LoanAccountDutyDistribute_dataset.pageIndex);
	}
	//查看意见
	function btnOpinion_onClick(button){
		subwindow_taskApprovalHistoryFW.show();
	}
	//查看意见
	function btnOpinion2_onClick(button){
		subwindow_taskApprovalHistoryFW2.show();
	}
</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/AccountDutyDistribute.js'> </script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>