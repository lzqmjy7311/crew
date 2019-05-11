<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign businessId=RequestParameters["businessId"]?default("")>
<#assign rptStatus=RequestParameters["rptStatus"]?default("")>
<#assign userInfo_=Session["USER_SESSION_INFO"] />
<@CommonQueryMacro.page title="基本信息">
	<table>
		<tr>
			<td>
				<@CommonQueryMacro.CommonQuery id="RiskMonitorBaseinfo1" init="false" submitMode="current">
					<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" fieldStr="customerNum,chineseName,deptName,customerManagerName,isBlackName,warnYlevel" showButton="false"/>
					<center><@CommonQueryMacro.Button id="btQuery"/>&nbsp;&nbsp;&nbsp;&nbsp;<@CommonQueryMacro.Button id="btRest"/></center>
					<@CommonQueryMacro.GroupBox id="Baseinfo" label="基本信息">
						<@CommonQueryMacro.DataTable id="table12" paginationbar="btHandle,btZjlx,btCwfx,btCwcxd,btQxz" fieldStr="customerNum,chineseName,deptName,customerManagerName,loanBalance,warnYlevel,isBlackName"/>
					</@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
	<div>
	</div>
<script>
	var windows;
	var roleId=user_info.roleId;
	var businessId='${businessId}';
	function initCallGetter_post(){
		
//		if(user_info.roleId=="559"||roleId=="560"||roleId=="605"||roleId=="111"){
//			$("a[id=btZjlx]").show();
//		}else{
//			$("a[id=btZjlx]").hide();
//		}
		if(user_info.roleId=="601"){
			RiskMonitorBaseinfo1_interface_dataset.setFieldReadOnly("customerManagerName",true);
			RiskMonitorBaseinfo1_interface_dataset.setFieldReadOnly("deptName",true);
		}
		simlpVist();
	}
	function deptName_DropDown_onSelect(dropDown,record,editor){
		RiskMonitorBaseinfo1_interface_dataset.setValue('customerManagerName','');
		RiskMonitorBaseinfo1_interface_dataset.setValue('customerManager','');
		return true;
	}
	function customerManagerName_DropDown_beforeOpen(dropDown){

		var deptCd = RiskMonitorBaseinfo1_interface_dataset.getValue('deptCd');//根据第一个selectId获得第一个select值
		if(!deptCd){
			RiskMonitorBaseinfo1_interface_dataset.setValue('customerManagerName',''); 
			RiskMonitorBaseinfo1_interface_dataset.setValue('customerManager',''); 
			return "请选择机构!";
			}//判断第一个select的值是否为空，如果为空直接返回一个字符串
		TlrInfo_DropDownDataset.setParameter("brcode",deptCd); 
		TlrInfo_DropDownDataset.setParameter("flag","yes");
		customerManagerName_DropDown.cached=false;//让qGroupId不存入缓存
	}
	function btHandle_onClick(button){
		var customerNum =RiskMonitorBaseinfo1_dataset.getValue("customerNum");
		var chineseName =RiskMonitorBaseinfo1_dataset.getValue("chineseName");
		var loanCardNum =RiskMonitorBaseinfo1_dataset.getValue("loanCardNum");
		var industryCd =RiskMonitorBaseinfo1_dataset.getValue("industryCd");
		windows = openSubWin("warninfoWin", "客户风险视图\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName, "/gbicc-com-pages/riskview/ftl/riskView.ftl?customerNum="+customerNum+"&chineseName="+encodeURI(encodeURI(chineseName))+"&loanCardNum="+loanCardNum,"1150","600",false,true,windows_close,true);
		btHandle.disable(true);
	}
	function btZjlx_onClick(button){
		var customerNum =RiskMonitorBaseinfo1_dataset.getValue("customerNum");
		ajMonitorReportWin = openSubWin('1',"账户帐页","/gbicc-com-pages/accountpage/ftl/TAccountPage.ftl"+"?customerNum="+customerNum,"1200","700");
	}
	function btCwfx_onClick(button){
		var customerNum =RiskMonitorBaseinfo1_dataset.getValue("customerNum");
		var chineseName =RiskMonitorBaseinfo1_dataset.getValue("chineseName");
		var paramMap=new Map();
		paramMap.put("customerNum",customerNum);
		paramMap.put("chineseName",chineseName);
		windows = openSubWin("warninfoWin", "财务分析\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName, "/gbicc-com-pages/FinanciaAnalysis/ftl/FinanceAnalysis.ftl?customerNum="+customerNum+"&chineseName="+chineseName,"1150","600",false,true,windows_close,true);
		btHandle.disable(true);
	}
	function btCwcxd_onClick(button){
		var customerNum =RiskMonitorBaseinfo1_dataset.getValue("customerNum");
		var chineseName =RiskMonitorBaseinfo1_dataset.getValue("chineseName");
		var industryCd =RiskMonitorBaseinfo1_dataset.getValue("industryCd");
		windows = openSubWin("warninfoWin", "财务诚信度\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName,"/gbicc-com-pages/financialIndexAnalsis/ftl/financialIndexAnalsis.ftl?customerNum="+customerNum+"&industryCd="+industryCd,"1150","600",false,true,windows_close,true);
	}
	function btRest_onClick(button){
		RiskMonitorBaseinfo1_interface_dataset.clearData();
	}
	function btQxz_onClick(button){
			var customerNum =RiskMonitorBaseinfo1_dataset.getValue("customerNum");
		var chineseName =RiskMonitorBaseinfo1_dataset.getValue("chineseName");
		var industryCd =RiskMonitorBaseinfo1_dataset.getValue("industryCd");
		if(customerNum!='000000094071'){
			alert("请选择客户：000000094071/东方证券股份有限公司，其他暂未开放");
		}else{
			windows = openSubWin("warninfoWin", "企业全景查询\t&nbsp;&nbsp;&nbsp;客户编号："+customerNum+"   客户名称："+chineseName,"/gbicc-com-pages/warning_test/ftl/quanjing.ftl?customerNum="+customerNum+"&industryCd="+industryCd,"1150","600",false,true,windows_close,true);
		}
	}
	function btQuery_onClick(button){
		var customerNum=RiskMonitorBaseinfo1_interface_dataset.getValue("customerNum");
		var chineseName=RiskMonitorBaseinfo1_interface_dataset.getValue("chineseName");
		var deptCd=RiskMonitorBaseinfo1_interface_dataset.getValue("deptCd");
		var customerManager=RiskMonitorBaseinfo1_interface_dataset.getValue("customerManager");
		var isBlackName=RiskMonitorBaseinfo1_interface_dataset.getValue("isBlackName");
		var warnYlevel=RiskMonitorBaseinfo1_interface_dataset.getValue("warnYlevel");
		
		RiskMonitorBaseinfo1_dataset.setParameter("warnYlevel",warnYlevel);
		RiskMonitorBaseinfo1_dataset.setParameter("roleId",user_info.roleId);
		RiskMonitorBaseinfo1_dataset.setParameter("orgId",user_info.orgId);
		RiskMonitorBaseinfo1_dataset.setParameter("userId",user_info.userId);
		RiskMonitorBaseinfo1_dataset.setParameter("customerNum",customerNum);
		RiskMonitorBaseinfo1_dataset.setParameter("chineseName",chineseName);
		RiskMonitorBaseinfo1_dataset.setParameter("bankName",deptCd);
		RiskMonitorBaseinfo1_dataset.setParameter("operator",customerManager);
		RiskMonitorBaseinfo1_dataset.setParameter("isBlackName",isBlackName);
		RiskMonitorBaseinfo1_dataset.setParameter("deptCd",deptCd);
		RiskMonitorBaseinfo1_dataset.setParameter("roleId",roleId);
		RiskMonitorBaseinfo1_dataset.flushData();
	}
	function windows_close(){
		btHandle.disable(false);
	}
	//设置页面所有字段只读
	function setPageReadOnlyFun(){
		var fieldName="";
		for(var i=0;i<RiskMonitorBaseinfo_dataset.fields.length;i++){
			fieldName=RiskMonitorBaseinfo_dataset.fields[i].name;
			if(fieldName.substring(0,1)!="_"){
				RiskMonitorBaseinfo_dataset.setFieldReadOnly(fieldName,true);
			}
		}
	}
	//保存后关闭页面，刷新表格
	function btnSave_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("保存成功！");
		window.parent.ajMonitorReportWin_close();
	}
	//保存后关闭页面，刷新表格
	function btnSubmit_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		window.parent.ajMonitorReportWin_close();
	}
	//退回后关闭页面，刷新表格
	function btnBack_postSubmit(button) {
		button.url="#";
		top.easyMsg.info("操作成功！");
		window.parent.ajMonitorReportWin_close();
	}
	
	function simlpVist(button){
		var redirectFlag='${Session["redirectFlag"]}';
		if(redirectFlag=='true'){
			var partyId='${Session["partyId"]}';
			RiskMonitorBaseinfo1_dataset.setParameter("partyId",partyId);
			RiskMonitorBaseinfo1_dataset.setParameter("redirectFlag",redirectFlag);
			$("a[id=btQuery]").hide();
			$("a[id=btRest]").hide();
			var interface1=document.getElementsByName('interface1')[0];
			interface1.hidden="hidden";
			
			RiskMonitorBaseinfo1_dataset.flushData();
		}
	}
</script>
</@CommonQueryMacro.page>