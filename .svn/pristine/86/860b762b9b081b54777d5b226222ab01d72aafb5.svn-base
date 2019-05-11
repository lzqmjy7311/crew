<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="汇率手工录入">
<@CommonQueryMacro.CommonQuery id="CurrrateMng" init="ture" submitMode="current">
<table width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="查询条件" />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable2" paginationbar="btNew"  fieldStr="currrateDate,curcd,tocurcd,buyrate,exchgrate,sellrate,opr[50]"  readonly="true"/></br>
		</td>
	</tr>
	<tr>
 		<td style="display: none">
 			<@CommonQueryMacro.Button id="btDel"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">

	function datatable2_opr_onRefresh(cell, value, record){
		if(record){
			var id = record.getValue("id");
			cell.innerHTML = "<center><a href=\"JavaScript:doDetail('" + id + "')\">查看</a>&nbsp;&nbsp;<a href=\"JavaScript:doMov('" + id + "')\">修改</a>&nbsp;&nbsp;<a href=\"JavaScript:doDel('" + id+ "')\">删除</a></center>";
		} else {
			cell.innerHTML = "";
		}
	}

	//新增按钮点击事件
	function btNew_onClick(button){
		var url = "/fpages/management/ftl/currrateDetailMng.ftl?op=add";
		roleAuthView = openSubWin("roleAuthWin", "新增", url,600,400);
	}

	//修改按钮点击事件
	function doMov(id){
		var url = "/fpages/management/ftl/currrateDetailMng.ftl?op=modify&id="+id;
		roleAuthView = openSubWin("roleAuthWin", "修改", url,600,400);

	}

	//查看按钮显示
	function doDetail(id){
	    var url = "/fpages/management/ftl/currrateDetailMng.ftl?op=find&id="+id;
		roleAuthView = openSubWin("roleAuthWin", "查看", url,600,250);
	}

	//删除点击按钮事件
	function doDel(id){
	    if(confirm("是否确定删除此记录？")){
			CurrrateMng_dataset.setValue2("id",id);
			btDel.click();
		}
	}

	//删除成功提示
	function btDel_postSubmit(button){
		top.easyMsg.correct("删除成功");
		CurrrateMng_dataset.flushData(CurrrateMng_dataset.pageIndex);
	}


</script>
</@CommonQueryMacro.page>


