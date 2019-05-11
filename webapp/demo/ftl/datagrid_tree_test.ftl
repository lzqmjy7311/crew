<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="树形表格">
	<@CommonQueryMacro.CommonQuery id="TreeNodeTest" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="datatable2" treeGrid="true" hasFrame="true" readonly=""
		   treeField="name"  fieldStr="select,name[300],_parentId,_id,_hasChild_,f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29" width="100%" height="400" >		
		</@CommonQueryMacro.DataTable>
	</@CommonQueryMacro.CommonQuery>
	
	<script>
	function datatable2_f0_onRefresh(cell,value,record) {
			if (record) {//当存在记录时
				cell.innerHTML="<a href='JavaScript:showDetail("+record.getValue('_id')+")'>"+value+"</a>";
			} else {//当不存在记录时
				cell.innerHTML="&nbsp;";
			}
		}
	</script>
</@CommonQueryMacro.page>