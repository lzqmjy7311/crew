<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="任务管理  &gt; 监控任务查询">
	<@CommonQueryMacro.CommonQuery id="TImportpublictext" init="true" submitMode="current" >
			<@CommonQueryMacro.Interface id="interface"label="请输入查询条件" showButton="false"/>
			<tr>
				<td>
					<div align="center" style="margin-bottom:10px">
						<@CommonQueryMacro.InterfaceButton desc="查询" />
						<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
					</div>
				</td>
			</tr>
			<@CommonQueryMacro.DataTable id="QualityTable" width="600" fieldStr="bankCode,middleSigncode,organizationCode,informationCode,creatTime" paginationbar="btImport" width="100%" hasFrame="true"/>
		<@CommonQueryMacro.FloatWindow id="TxtFW" modal="true" label="上传TXT文件" 
		resize="true" minimize="false" maximize="true" closure="true" show="false" defaultZoom="normal">
		<form id="uploadForm" action="${contextPath}/common/TxtImportServlet" method="post" enctype="multipart/form-data">
			文件：<input id="fileUpload" name="file" type="file"/>
			<@CommonQueryMacro.Button id= "btUpload"/>
		</form>
		</@CommonQueryMacro.FloatWindow>
 	</@CommonQueryMacro.CommonQuery>
 	<script language="JavaScript">
 	//重置查询条件
	function btnReset_onClick(button){
		TImportpublictext_interface_dataset.clearData();
	}
 	//上传文件
	function btUpload_onClickCheck(button) { 
		if (checkFile()) {
			//异步提交表单
			$.messager.progress({title:'请稍候',msg:'正在上传...'});
			$('#uploadForm').ajaxSubmit({
				type:"post",
				success:function(data){
					var obj=eval('('+data+')');
					$.messager.progress('close');
					if(obj.success=="true"){
						subwindow_TxtFW.close();
						top.easyMsg.info(obj.msg);
						TImportpublictext_dataset.flushData(TImportpublictext_dataset.pageIndex);
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
	   var filename=file.val();
	   if (filename == "") {
	   	  alert('请选择要导入数据的文件','错误提示');
	      file.focus();
	      return false;
	   }
	   var str=filename.substring(filename.indexOf("."));
	   if(str!='.txt'){
		   alert("请检查文件类型，上传正确的数据文件！","错误提示");
		   return false;
	   }
		   
	  return true;
	}
	function btImport_onClick(button) {
		subwindow_TxtFW.show();
	}
 	</script>
 	<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>