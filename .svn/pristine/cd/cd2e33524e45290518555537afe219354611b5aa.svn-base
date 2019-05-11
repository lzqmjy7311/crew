<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<script type='text/javascript' src='${contextPath}/dwr/interface/QualityAjax.js'> </script>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="任务管理  &gt; 监控任务查询">
	<@CommonQueryMacro.CommonQuery id="QualitysuPar" init="true" submitMode="current">
<#-- 		<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm=6 /> -->
			<@CommonQueryMacro.DataTable id="QualityTable"  paginationbar="btAdd,btModify"  fieldStr="bankName,productName,riskSignal,assureType,warningLevel,qualitysupPerc,status,startTime,endTime,zhuangtai" width="100%" hasFrame="true"/>
      		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label="质量监督查询"
        			  fieldStr="bankName,productName,riskSignal,assureType,warningLevel,qualitysupPerc,status,startTime,endTime" colNm=4/>
        			<br/>
        			<@CommonQueryMacro.Button id="btModOrAdd" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<@CommonQueryMacro.Button id="btCancel" />
      			</div>
     		</@CommonQueryMacro.FloatWindow>		
	</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	// 改变process 颜色
	function QualityTable_qualitysupPerc_onProgress(value,oldvalue,progressbar,progresstext){
	    if(value<40){
	        progressbar.style.backgroundColor="red";
	    } else if(value>80){
	        progressbar.style.backgroundColor="green";
	    }
	}

	//定位一行记录
	function locate(id) {
		var record = QualitysuPar_dataset.find(["id"],[id]);
		if(record) {
			QualitysuPar_dataset.setRecord(record);
		}
	}

    function  QualityTable_beforeEdit(rowIndex,record){ 
        if(rowIndex==0) return false; 
        else return true; 
    }     

	//系统刷新单元格
	function QualityTable_zhuangtai_onRefresh(cell,value,record) {
		var status = record.getValue("status");
		var id=record.getValue("id");

		if(record) {
				cell.innerHTML="<a href=\"JavaScript:ChangeStatus('"+id+"','"+status+"')\">启用/禁用</a>";
		}
	}
	function ChangeStatus(id,status)
	{
		
		if(status==("启用")||status==("禁用"))
			{
				QualityAjax.ChangeStatus(id,function(y){
					QualitysuPar_dataset.flushData(1);	
				});
			}
		else {
				alert("状态未正确填写");
				return false;
			}
		

	}
	function btModOrAdd_onClick()
	{}
	function btAdd_onClick(button) {
			btNewClick();
	}
	function btModify_onClick(button){
		btModifyClick();
	}

	//取消功能
	function btCancel_onClickCheck(button) {
		//关闭浮动窗口
		subwindow_signWindow.close();
	}
	//关浮动窗口,释放dataset
	function signWindow_floatWindow_beforeClose(subwindow) {
		QualitysuPar_dataset.cancelRecord();
		return true;
	}
	function signWindow_floatWindow_beforeHide(subwindow) {
		return signWindow_floatWindow_beforeClose(subwindow);
	}
	
	//新增功能
	function btNewClick() {
		QualitysuPar_dataset.insertRecord("end");
		QualitysuPar_dataset.setFieldReadOnly("id",true);
		QualitysuPar_dataset.setFieldReadOnly("bankName",false);
		QualitysuPar_dataset.setFieldReadOnly("productName",false);
		QualitysuPar_dataset.setFieldReadOnly("riskSignal",false);
		QualitysuPar_dataset.setFieldReadOnly("assureType",false);
		QualitysuPar_dataset.setFieldReadOnly("warningLevel",false);
		QualitysuPar_dataset.setFieldReadOnly("status",false);
		QualitysuPar_dataset.setFieldReadOnly("startTime",false);
		QualitysuPar_dataset.setFieldReadOnly("endTime",false);
		subwindow_signWindow.show();

	}
	function btModifyClick() {
			var id = QualitysuPar_dataset.getValue('id');
			QualitysuPar_dataset.setFieldReadOnly("bankName",true);
			openModifyWindow(id);
		}
	//展示对比功能的js
	function datatable1_id_onRefresh(cell, value, record){
		if(record!=null){
			var id=record.getValue("id");
			cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"')\">"+id+"</a>";
	
		} else {
			cell.innerHTML = ""
		}
	}

	//修改功能
	function openModifyWindow(id) {
		QualitysuPar_dataset.setFieldReadOnly("id",true);
		QualitysuPar_dataset.setFieldReadOnly("bankName",true);
		QualitysuPar_dataset.setFieldReadOnly("productName",true);
		QualitysuPar_dataset.setFieldReadOnly("riskSignal",true);
		QualitysuPar_dataset.setFieldReadOnly("assureType",true);
		QualitysuPar_dataset.setFieldReadOnly("warningLevel",true);
		QualitysuPar_dataset.setFieldReadOnly("status",true);
		QualitysuPar_dataset.setFieldReadOnly("startTime",true);
		QualitysuPar_dataset.setFieldReadOnly("endTime",true);
		subwindow_signWindow.show();	
	}
	function btModOrAdd_postSubmit(button) {
		button.url="#";
		subwindow_signWindow.close();
		flushCurrentPage();
	}	


	

	



	function showDetail(id,sta){		
		var paramMap = new Map();
		paramMap.put("id",id);
		paramMap.put("st",sta);
		paramMap.put("action","detail");
		paramMap.put("flag","0");
		
	}
	function btModOrAdd_onClickCheck(button) {
		var id = QualitysuPar_dataset.getValue("id");
		return true;
	}
	//保存后刷新当前页

	//刷新当前页
	function flushCurrentPage() {
		QualitysuPar_dataset.flushData(QualitysuPar_dataset.pageIndex);
	}



</script>	
</@CommonQueryMacro.page>