<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign relaID=RequestParameters["relaID"]?default("")>
<#assign relaType=RequestParameters["relaType"]?default("")>
<#assign readOnly=RequestParameters["readOnly"]?default("")>

<@CommonQueryMacro.page title="�ļ��ϴ�">
	<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
	<@CommonQueryMacro.CommonQuery id="FileUpload" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id ="FileUploadDatatable" paginationbar="newupload" fieldStr="fileName[150],fileSize[80],tlrno[100],tlrname[110],uploadTime[110],opr[100]" height="365px"  width="100%"/>
	</@CommonQueryMacro.CommonQuery>
	
	<div id="file-window" class="easyui-window" style="display:none;">
		<form id="file-upload-form" method="post" enctype="multipart/form-data" action="${contextPath}/common/fileupload">
			<input  name="relaID" type="hidden"  value="${relaID}"/>
			<input  name="relaType" type="hidden"  value="${relaType}"/>
			ѡ���ļ�:<input  name="file" type="file"/>
			<a id="file-btn">�ϴ�</a>
		</form>
	</div>
	<script>
		$("#file-btn").linkbutton({iconCls:'icon-search'});
		//$("input[name=file]").filebox({});
		var readOnly="${readOnly}";
		
		var contextPath="${contextPath}";
		function initCallGetter_post(){
			FileUpload_dataset.setParameter("relaID","${relaID}");
			FileUpload_dataset.setParameter("relaType","${relaType}");
			if(readOnly=="1"){
				$("#newupload").css("display","none");
			}
		}
		
		function FileUploadDatatable_opr_onRefresh(cell,value,record) {
			if (record) {//�����ڼ�¼ʱ
				if(readOnly=="1"){
					cell.innerHTML="<a href='JavaScript:doDownload(\""+value+"\")'>����</a>";
				}else{
					cell.innerHTML="<a href='JavaScript:doDownload(\""+value+"\")'>����</a> &nbsp; <a href='JavaScript:doDelete(\""+value+"\")'>ɾ��</a>";
				}
			} else {//�������ڼ�¼ʱ
				cell.innerHTML="&nbsp;";
			}
		}
				
		function doDownload(id){
			window.open(contextPath+"/common/fileupload?method=download&id="+id);
		}
		
		function doDelete(id){
			var tlrno=FileUpload_dataset.getValue('tlrno');
			if(tlrno!=user_info.userId){
				alert('ɾ��ʧ�ܣ�ֻ��ɾ���Լ��ϴ�������');
				return;
			}
			$.get(contextPath+"/common/fileupload?method=delete&id="+id,function(){
				FileUpload_dataset.flushData(FileUpload_dataset.pageIndex);
				flushWin();
			});
		}
		function flushWin(){
			window.parent.showNums1();
			window.parent.showNums2();
		}
		$(function(){
			$("#file-btn").click(function(){
				var f=$("#file-window input[name=file]").val();
				if(f==""){
					return alert("�ϴ��ļ�����Ϊ��!");
				}
				
				$.messager.progress({title:'���Ժ�',msg:'�����ϴ�...'});
				$('#file-upload-form').ajaxSubmit({
					type:"post",
					success:function(data){
						$.messager.progress('close');
						if(data!=""){
							alert(data);
						}
						win.window('close');
						FileUpload_dataset.flushData(FileUpload_dataset.pageIndex);
						flushWin();
					},
					error:function(data){
					}
				});
			});
			var win=null;
			$("#newupload").click(function(){
				$("#file-window input[name=file]").val("");
				$("#file-window").css("display","block");
				win=$("#file-window").window({
					title:"�ϴ��ļ�",
					width:400,
					height:200,
					modal:true
				});
				win.window('open');
			});
		});
	</script>
</@CommonQueryMacro.page>