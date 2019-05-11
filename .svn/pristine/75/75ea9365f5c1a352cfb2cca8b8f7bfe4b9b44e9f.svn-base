<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="树形表格">
	<@CommonQueryMacro.CommonQuery id="TreeNode" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="datatable2" treeGrid="true" hasFrame="true" readonly=""
		   treeField="name" fieldStr="select,name[300],_parentId,_id,_hasChild_" >		
		</@CommonQueryMacro.DataTable>
		
		<@CommonQueryMacro.Button id="btDel"/>
		<@CommonQueryMacro.Button id="btAdd"/>
		<@CommonQueryMacro.SimpleButton id="before" desc="before"/>
		<@CommonQueryMacro.SimpleButton id="after" desc="after"/>
		<@CommonQueryMacro.SimpleButton id="addchild" desc="addchild"/>
		<@CommonQueryMacro.SimpleButton id="fresh" desc="fresh"/>
		<@CommonQueryMacro.SimpleButton id="moveup" desc="moveup"/>
		<@CommonQueryMacro.SimpleButton id="movedown" desc="movedown"/>
	</@CommonQueryMacro.CommonQuery>
	<script>
		function datatable2_pid_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				cell.innerHTML="<a href='JavaScript:showDetail("+record.getValue('_id')+")'>"+value+"</a>";
			} else {//当不存在记录时
				cell.innerHTML="&nbsp;";
			}
		}
		function addchild_onClick(){
			TreeNode_dataset.insertRecord('child');
		}
		function before_onClick(){
			TreeNode_dataset.insertRecord('before');
		}
		function after_onClick(){
			TreeNode_dataset.insertRecord('after');
		}
		function fresh_onClick(){
			TreeNode_dataset.flushData(TreeNode_dataset.pageIndex);
		}
		function moveup_onClick(){
			moveTreegridRecord(datatable2,'up');return;
		}
		
		function movedown_onClick(){
			moveTreegridRecord(datatable2,'down');return;
		}
	</script>
</@CommonQueryMacro.page>