<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="任务管理  &gt; 监控任务查询">
	<@CommonQueryMacro.CommonQuery id="ImportExcel" init="true" submitMode="current" >
			<@CommonQueryMacro.Interface id="interface1" colNm="4" label="操作记录查询" showButton="false"/>
			<tr>
				<td>
					<div align="center" style="margin-bottom:10px">
						<@CommonQueryMacro.InterfaceButton desc="查询" />
						<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
					</div>
				</td>
			</tr>
			<@CommonQueryMacro.DataTable id="QualityTable" width="600" fieldStr="username,sucesscount,errorcount,date" paginationbar="btImport" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="TxtFW" modal="true" label="Excel数据导入" 
		resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
		<form id="uploadForm" action="${contextPath}/this/ImportExcelServlet" method="post" enctype="multipart/form-data" target="aa">
			<div style="margin-left:150px;margin-bottom:5px;margin-top:5px"><label>请选择导入类型：</label><input type="radio" name="editortype" value="00" id="editortype"/><label>月报</label>&nbsp;&nbsp;&nbsp;<input type="radio" name="editortype" value="11" id="editortype"/><label>季报</label></div>
			<hr>
			<div style="margin-left:50px;margin-bottom:5px;margin-top:5px">文件：<input id="fileUpload" name="file" type="file"/><@CommonQueryMacro.Button id= "btUpload"/><@CommonQueryMacro.Button id= "btCancel"/></div>	
		</form>
		</@CommonQueryMacro.FloatWindow>
 	</@CommonQueryMacro.CommonQuery>
 	<script type="text/javascript">
 	//上传文件
	function btUpload_onClickCheck(button) { 
		if (checkFile()) {
			//异步提交表单		
			$("btUpload").disabled=true;
			$.messager.progress({title:'请稍候',msg:'正在上传...'});
			$('#uploadForm').ajaxSubmit({
				type:"post", 
				data:{editor_type:"type"},
				success:function(data){
					var obj = eval('('+data+')');
					$.messager.progress('close');
					if(obj.success=="true"){
						subwindow_TxtFW.close();
						top.easyMsg.info(obj.msg);
						ImportExcel_dataset.flushData(ImportExcel_dataset.pageIndex);
					}else{
						top.easyMsg.error(obj.msg);
					}
				}
			});
		}
	}
	//检查上传文件
	function checkFile() {
	   var file=$("#fileUpload");
	  var editor=$('input:radio[name="editortype"]').is(":checked");
	   var filename=file.val();
	   if (filename == "") {
	   	  alert('请选择要导入数据的文件','错误提示');
	      file.focus();
	      return false;
	   }
	   if (editor==false) {
		   	  alert('请选择要导入文件的类型','错误提示');
		      return false;
		   }
	   var str=filename.substring(filename.indexOf("."));
	   if((str!='.xls')){
		   alert("请检查文件类型，支持97-2003版EXCEL文件，格式要求XLS！","错误提示");
		   return false;
	   }
		   
	  return true;
	}
	function btImport_onClick(button) {
		subwindow_TxtFW.show();
	}

	function btCancel_onClickCheck(button){
		subwindow_TxtFW.close();
	}
	//重置查询条件
	function btnReset_onClick(button){
		ImportExcel_interface_dataset.clearData();
	}
 	</script>
 	<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>