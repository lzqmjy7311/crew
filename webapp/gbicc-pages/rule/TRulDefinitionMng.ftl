<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="��������">

<link rel="stylesheet" href="${contextPath}/gbicc-pages/lib/codemirror-5.8/lib/codemirror.css"/>
<link rel="stylesheet" href="${contextPath}/gbicc-pages/lib/codemirror-5.8/theme/cobalt.css"/>

<script type="text/javascript" src='${contextPath}/gbicc-pages/lib/codemirror-5.8/lib/codemirror.js'> </script>
<script type="text/javascript" src='${contextPath}/gbicc-pages/lib/codemirror-5.8/mode/groovy/groovy.js'> </script>


<#assign result = "[{'id':1,'text':'��������','seperator':false,'iconCls':'icon-add','attributes':'','href':'','children':[]},{'id':2,'text':'��������','seperator':false,'iconCls':'icon-add','attributes':'','href':'','children':[]},{'id':3,'text':'�޸�','seperator':false,'iconCls':'icon-edit','attributes':'','href':'','children':[]},{'id':4,'text':'ɾ��','seperator':false,'iconCls':'icon-remove','attributes':'','href':'','children':[]}]">
<@CommonQueryMacro.MenuItem id="mm" json=result />

<@CommonQueryMacro.LayoutPanel id="rule" >
	<style>
	.CodeMirror{
		height:430px;
	}
  </style>
    <@CommonQueryMacro.LayoutWest title="���������" width="300" split="true" >
	  
	  <@CommonQueryMacro.CommonQuery id="TRulCategoryTree" init="false" submitMode="current">
	  		<!--<div style="margin-bottom:20px;">
	  			<a href="javascript:void(0)" id="mb1" class="easyui-menubutton" iconCls="icon-edit">����</a>
	  			<div id="mm1" style="width:150px;">
	  				<div iconCls="icon-add">��������</div>
	  				<div iconCls="icon-add">��������</div>
	  			</div>
	  			<@CommonQueryMacro.Button id="btUpt"/>
	  			<@CommonQueryMacro.Button id="btnDel"/>
	  		</div>-->
	  		
	  		<div style="display:none;">
	  			<@CommonQueryMacro.Button id="btUpt"/>
	  			<@CommonQueryMacro.Button id="btnDel"/>
	  		</div>
			<@CommonQueryMacro.DynamicTree id="tree1" contextmenu="mm" />
	  </@CommonQueryMacro.CommonQuery>
	 
    </@CommonQueryMacro.LayoutWest>
    
    
    <@CommonQueryMacro.LayoutCenter>
    	<@CommonQueryMacro.CommonQuery id="TRulDefinition" init="false" submitMode="current">
    		<@CommonQueryMacro.LayoutNorth  height="260" split="true" >
            	<@CommonQueryMacro.DataTable id="TRulDefinitionddd" height="240" fitColumns="false"   paginationbar="DbtnAdd,-,DbtnUpload,DbtnEnabled"  fieldStr="opr[120],ruleStatus[60],enable[60],ruleCode[120],ruleName[150],ruleUpdateddate[150],ruleType[60],triggerPeriodInterval[150],triggerPeriodUnit[150],ruleLevel[150],ruleApplyobj[150],ruleVersion[80],ruleRemark[250]" readonly="true" width="100%"/></br>
        	</@CommonQueryMacro.LayoutNorth>
        
         	<@CommonQueryMacro.LayoutCenter>
        	 <@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height="500" selected="base_tab1">
        		<@CommonQueryMacro.DynamicTab id="base_tab2" title="������ϸ"> 
        			 <center>
        	  			<div style="display:none;"  id="saveBtn">
        	  			<@CommonQueryMacro.Button id="CDbtnUpt"/>
        	  			<@CommonQueryMacro.Button id="DbtnCheck"/>
        	  			<@CommonQueryMacro.Button id="DbtnExcute"/>
        	  			</div>
        	  		 </center>
        			<@CommonQueryMacro.SingleField fId="ruleContent" />
        		</@CommonQueryMacro.DynamicTab>
        	 </@CommonQueryMacro.DynamicTabSet>
        	  
        	</@CommonQueryMacro.LayoutCenter>
    
    		<@CommonQueryMacro.FloatWindow id="TRulDefinitionForm" label="�޸Ĺ���" closure="true"  modal="true" width="500" height="400" >
			<@CommonQueryMacro.Group id="group1" label=""
    			  fieldStr="ruleName,ruleType,triggerType,triggerPeriodInterval,triggerPeriodUnit,ruleLevel,ruleApplyobj,ruleRemark" colNm=2/>
    			<br/>
    		<center>
				<@CommonQueryMacro.Button id="DbtnUpt"/>
			</center>
			</@CommonQueryMacro.FloatWindow>
			
			<div style="display:none;">
        	  	<@CommonQueryMacro.Button id="CDbtnUpload"/>
        	  	<@CommonQueryMacro.Button id="DbtnCopy"/>
        	  	<@CommonQueryMacro.Button id="DbtnDel"/>
        	</div>
			
	    </@CommonQueryMacro.CommonQuery>
    </@CommonQueryMacro.LayoutCenter>
    
    <@CommonQueryMacro.CommonQuery id="TRulCategory" init="false" submitMode="current">
		<@CommonQueryMacro.FloatWindow id="TRulCategoryForm" label="�༭����" closure="true" modal="true" width="500" height="250" >
			<@CommonQueryMacro.Group id="group1" label=""
    			  fieldStr="categoryCode,categoryName,sno,remark,rulType" colNm=2/>
    			<br/>
    		<center>
				<@CommonQueryMacro.Button id="FbtAddCategory"/>
			</center>
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TRulCategory" init="false" submitMode="current">
		<@CommonQueryMacro.FloatWindow id="TRulCategoryForm2" label="�༭����" closure="true"  modal="true" width="500" height="280" >
			<@CommonQueryMacro.Group id="group1" label=""
    			  fieldStr="categoryCode,categoryName,sno,remark,rulType" colNm=2/>
    			<br/>
    		<center>
				<@CommonQueryMacro.Button id="FbtAddRule"/>
			</center>
		</@CommonQueryMacro.FloatWindow>
	</@CommonQueryMacro.CommonQuery>
	
  </@CommonQueryMacro.LayoutPanel>
  
  <script>
  		var code_eidtor=null;
  		
  		$(function(){
  			$('#mb1').menubutton({
				plain:false,
				menu:'#mm1'
			});
	  		var editorContent=document.getElementById("editor_ruleContent");
			code_eidtor=CodeMirror.fromTextArea(editorContent,{
				lineNumbers:true,
				mode:'text/x-groovy'
			});
  		});
  		
  		function ruleType_DropDown_onSelect(dropDown,record,editor){
  			if(record[0]=="T1" || record[0]=="T2"){
  				$("[id=editor_triggerPeriodInterval]").closest("tr").hide();
  				$("[id=editor_triggerPeriodUnit]").closest("tr").hide();
  				TRulDefinition_dataset.setValue("triggerPeriodInterval","");
  				TRulDefinition_dataset.setValue("triggerPeriodUnit","");
  			}else{
  				$("[id=editor_triggerPeriodInterval]").closest("tr").show();
  				$("[id=editor_triggerPeriodUnit]").closest("tr").show();
  			}
  			return true;
  		}
  		
  		function DynamicTree_tree1_onSelect(){
  			var n = DynamicTree_tree1.getSelected();
  			if(n){
  				var ctype=n.attributes.record.getValue("categoryType");
  				if(ctype=="T1"){
            		return;
            	}
  				TRulDefinition_dataset.setParameter("categoryId",n.id);
  				TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
  				$("#saveBtn").css("display","none");
  				code_eidtor.getDoc().setValue("");
  				code_eidtor.refresh();
  			}
  		}
  		
        function Menu_mm_onClick(node){
        	var n = DynamicTree_tree1.getSelected();
        	if(!n){
        		alert('��ѡ��һ���ڵ�');
				return;
        	}
        	
        	var ctype=n.attributes.record.getValue("categoryType");
        	
        	if(node.id==1){//����Ŀ¼
        		//clear
        		TRulCategory_dataset.setFieldReadOnly("categoryCode",false);
        		TRulCategory_dataset.setValue('categoryCode',"");
        		TRulCategory_dataset.setValue('sno',"");
            	TRulCategory_dataset.setValue('categoryName',"");
            	TRulCategory_dataset.setValue('remark',"");
            	TRulCategory_dataset.setValue('rulType',"");
        		//
        		TRulCategory_dataset.setParameter("op","newcategory");
        		TRulCategory_dataset.setValue("parentId",n.id);
        		TRulCategory_dataset.setValue('categoryType','T1');
            	subwindow_TRulCategoryForm.show();
            }else if(node.id==2){//��������
            	$("div[id=TRulCategoryForm2] label[datafield=categoryCode]").text('������');
            	$("div[id=TRulCategoryForm2] label[datafield=categoryName]").text('��������');
            	
            	if(ctype=="T2"){
            		alert('����ֻ������Ŀ¼��������������!');
            		return;
            	}
            	TRulCategory_dataset.setFieldReadOnly("categoryCode",false);
            	
            	//clear
        		TRulCategory_dataset.setValue('categoryCode',"");
        		TRulCategory_dataset.setValue('sno',"");
            	TRulCategory_dataset.setValue('categoryName',"");
            	TRulCategory_dataset.setValue('remark',"");
            	TRulCategory_dataset.setValue('rulType',"");
        		//
           	    TRulCategory_dataset.setParameter("op","newrule");
           	    TRulCategory_dataset.setValue("parentId",n.id);
        		TRulCategory_dataset.setValue('categoryType','T2');
           	    subwindow_TRulCategoryForm2.show();
            }else if(node.id==3){
	            if(n.id=='Root'){
	        		alert('���ڵ㲻���޸�');
					return;
	        	}
	        	$("div[id=TRulCategoryForm2] label[datafield=categoryCode]").text('������');
            	$("div[id=TRulCategoryForm2] label[datafield=categoryName]").text('��������');
            	
	        	TRulCategory_dataset.setFieldReadOnly("categoryCode",true);
            	TRulCategory_dataset.setValue('id',n.attributes.record.getValue("_id"));
            	TRulCategory_dataset.setValue('categoryName',n.attributes.record.getValue("categoryName"));
            	TRulCategory_dataset.setValue('parentId'," ");
            	
            	TRulCategory_dataset.setValue('categoryCode',n.attributes.record.getValue("categoryCode"));
            	TRulCategory_dataset.setValue('sno',n.attributes.record.getValue("sno"));
            	
            	if(ctype=="T1"){
            		TRulCategory_dataset.setParameter("op","uptcategory");
            		TRulCategory_dataset.setValue('categoryType',"T1");
            		TRulCategory_dataset.setValue('remark',n.attributes.record.getValue("remark"));
            		TRulCategory_dataset.setValue('rulType',n.attributes.record.getValue("rulType"));
            		subwindow_TRulCategoryForm.show();
            	}else if(ctype=="T2"){
            		TRulCategory_dataset.setParameter("op","uptrule");
            		TRulCategory_dataset.setValue('categoryType',"T2");
            		TRulCategory_dataset.setValue('remark',n.attributes.record.getValue("remark"));
            		TRulCategory_dataset.setValue('rulType',n.attributes.record.getValue("rulType"));
            	    subwindow_TRulCategoryForm2.show();
            	}
            }else if(node.id==4){
            	if(n.id=='Root'){
	        		alert('���ڵ㲻��ɾ��');
					return;
	        	}
	        	
           		TRulCategoryTree_dataset.setParameter('id',n.id);
            	top.easyMsg.confirm("�ò�����ͬʱɾ��������ʷ��������Ƿ�ȷ��ɾ��?", function(){
            		btnDel.click();
                }, function(){
                } );
            }
        }
        function btnDel_postSubmit(){
        	DynamicTree_tree1.refresh();
        	TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
        }
        function FbtAddCategory_postSubmit(button){
        	subwindow_TRulCategoryForm.close();
        	DynamicTree_tree1.refresh();
        }
        function FbtAddRule_postSubmit(button){
        	subwindow_TRulCategoryForm2.close();
        	DynamicTree_tree1.refresh();
        }
        //����ѡ���иı��¼�
        //function TRulDefinition_dataset_afterScroll() {
        //	doModify();
        //}
        function TRulDefinitionddd_onDbClick(){
        	doModify();
        }
        //��������������ť
        function TRulDefinitionddd_opr_onRefresh(cell,value,record) {
			if (record) {//�����ڼ�¼ʱ
				cell.innerHTML="<a href='JavaScript:doModify(\""+value+"\")'>�鿴����</a> &nbsp; <a href='JavaScript:doDelete(\""+value+"\")'>ɾ��</a>";
			} else {//�������ڼ�¼ʱ
				cell.innerHTML="&nbsp;";
			}
		}

		function doModify(id){
			var record=(TRulDefinition_dataset.record);
			if(record){
				if(record.getValue("ruleStatus")=="0"){
					$("#saveBtn").css("display","block");
				}else{
					$("#saveBtn").css("display","none");
				}
				var _ruleContent=record.getValue("ruleContent");
				code_eidtor.getDoc().setValue(_ruleContent);
				code_eidtor.refresh();
			}
		}
		function doDelete(id){
		 	var record=(TRulDefinition_dataset.record);
        	if(record.getValue("ruleStatus")=="1"||record.getValue("ruleStatus")=="2"){
        		alert('��״̬����ɾ��');
        		return;
        	}
			top.easyMsg.confirm("��ȷ��ɾ���˼�¼��", function(){
            		DbtnDel.click();
                }, function(){
            } );
		}
		//�޸���� 
		function DbtnUpt_postSubmit(){
        	TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
        	subwindow_TRulDefinitionForm.hide();
        	doModify();
        }
        //�޸Ĺ���ť���֮ǰ
		function DbtnUpt_onClickCheck(){
        	TRulDefinition_dataset.setParameter("op","mod");
        }
        //�������
        function CDbtnUpt_postSubmit(){
        	TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
        	subwindow_TRulDefinitionForm.hide();
        	doModify();
        }
        
        function cleanValue(){
        	var _val=code_eidtor.getDoc().getValue();
        	/*_val=_val.replace(/</g,"&lt;");
        	_val=_val.replace(/>/g,"&gt;");
        	_val=_val.replace(/"/g,"&quot;");
        	_val=_val.replace(/\$/g,"&cmt;");
        	_val=_val.replace(/'/g,"&apos;");*/
        	return _val;
        }
        
        //�������ť֮ǰ
        function CDbtnUpt_onClickCheck(){
        	var _val=cleanValue();
        	
        	TRulDefinition_dataset.setValue("ruleContent",_val);
        	TRulDefinition_dataset.setParameter("op","uptContent");
        }
        //������ť
        function DbtnUpload_onClick(){
       	    var record=(TRulDefinition_dataset.record);
        	if(record.getValue("ruleStatus")=="1"){
        		alert('�������·���');
        		return;
        	}
        	top.easyMsg.confirm("��ȷ��Ҫ�����˰汾��", function(){
            	TRulDefinition_dataset.setParameter("op","upload");
            	CDbtnUpload.click();
            }, function(){
            } );
        }
        //���ý���
        function DbtnEnabled_onClickCheck(){
        	TRulDefinition_dataset.setParameter("op","enabled");
        }
        function DbtnEnabled_postSubmit(){
        	TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
        }
        
        function CDbtnUpload_postSubmit(){
        	TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
        }
        
        //���ݸ��¼
        function DbtnCopy_onClickCheck(){
        	TRulDefinition_dataset.setParameter("op","copy");
        }
        function DbtnCopy_postSubmit(){
        	TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
        }
        
        //ɾ��
        function DbtnDel_onClickCheck(){
        	TRulDefinition_dataset.setParameter("op","del");
        }
        function DbtnDel_postSubmit(){
        	TRulDefinition_dataset.flushData(TRulDefinition_dataset.pageIndex);
        }
        
        //������֤
        function DbtnCheck_onClickCheck(){
        	var _val=cleanValue();
        	var record=(TRulDefinition_dataset.record);
        	TRulDefinition_dataset.setParameter("op","check");
        	TRulDefinition_dataset.setValue("id",record.getValue("id"));
        	TRulDefinition_dataset.setValue("ruleContent",_val);
        }
         //����ִ��
        function DbtnExcute_onClickCheck(){
        	var _val=cleanValue();
        	var record=(TRulDefinition_dataset.record);
        	TRulDefinition_dataset.setParameter("op","execute");
        	TRulDefinition_dataset.setValue("id",record.getValue("id"));
        	TRulDefinition_dataset.setValue("ruleContent",_val);
        }
        function DbtnCheck_postSubmit(){
        	alert('������֤ͨ��');
        }
        function DbtnExcute_postSubmit(){
        	alert('����ִ�гɹ�');
        }
        
        function DbtnAdd_onClick(){
        	var record=(TRulDefinition_dataset.record);
        	var ruleStatus=record.getValue("ruleStatus");
        	if(ruleStatus=="0"){//�ݸ�
        		subwindow_TRulDefinitionForm.show();
        	}else if(ruleStatus=="1"){//����
        		top.easyMsg.confirm("����ֱ���޸ķ����汾�����ȷ�����ɲݸ�", function(){
            		DbtnCopy.click();
                }, function(){
                } );
        	}else if(ruleStatus=="2"){//��ʷ
        		alert('��ʷ״̬�����޸�');
        	}
        }
  </script>
</@CommonQueryMacro.page>