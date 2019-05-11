<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="工作日期维护">
<script type="text/javascript" src="${contextPath}/js/workdate.js"></script>
<link rel='stylesheet' type="text/css" href="${contextPath}/css/workdate.css" />
<table align="left" width="900px"><tr><td>
<@CommonQueryMacro.CommonQuery id="biWorkDate" init="false">
<table align="left" class="grouptable" width="100%">
	<tr>
		<td class="labeltd" width="100px">
		&nbsp;&nbsp;年份&nbsp;&nbsp;
		</td>
		<td class="datatd" width="100px">
			<@CommonQueryMacro.SingleField fId="biYear"/>
		</td>
		<td align="left">
			&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btSave" />
		</td>
		<td align="left">
			<strong id="test"></strong>
		</td>
		<td align="right"  nowrap="nowrap">
			<span style='height:4px;background-color:#c2dcfc;border:1px solid #ddd'>&nbsp;&nbsp;&nbsp;</span>&nbsp;工作日
			<span style='height:4px;background-color:#ffffff;border:1px solid #ddd'>&nbsp;&nbsp;&nbsp;</span>&nbsp;非工作日
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</td></tr>
<tr><td>
<table width="100%" cellpadding='10' cellspacing='0' border='1' class='tablerowStyleColor'>
	<tr>
		<td><div id="month1"></div></td>
		<td><div id="month2"></div></td>
		<td><div id="month3"></div></td>
		<td><div id="month4"></div></td>
	</tr>
	<tr>
		<td><div id="month5"></div></td>
		<td><div id="month6"></div></td>
		<td><div id="month7"></div></td>
		<td><div id="month8"></div></td>
	</tr>
	<tr>
		<td><div id="month9"></div></td>
		<td><div id="month10"></div></td>
		<td><div id="month11"></div></td>
		<td><div id="month12"></div></td>
	</tr>
</table>
</td></tr></table>
<script language="javascript">
	<#assign curdate = statics["com.huateng.ebank.framework.util.DateUtil"].getWorkDate()/>

	function initCallGetter_post(){
		if (biWorkDate_dataset.length==0) {
			biWorkDate_dataset.insertRecord("end");
			var tempDate = new Date();
	    	biWorkDate_dataset.setValue2("biYear", tempDate.getYear());
		}

		var yr = biWorkDate_dataset.getValue("biYear");
		PrivAction.checkWorkdateLock(yr,checkflag);
		showBiWorkDate(yr);
	}

	function biYear_DropDown_onSelect(dropDown,record,editor){
		var year  = record.getValue("yr").trim();
		var yr = biWorkDate_dataset.getValue("biYear").trim();
	   	if (yr == year) {
			return false;
	  	}

	   	showBiWorkDate(year);
	   	PrivAction.checkWorkdateLock(year,checkflag);
	   	return true;
	}

	//显示工作日期 并且查询是否已设置
	function showBiWorkDate(year){
		var selDays= null;
		dwr.engine.setAsync(false);
		PrivAction.getWorkDateByYear(year, function(data){
			showWorkDate(year,data);
		});
	}

	function showWorkDate(year,selDays){
		for(var i = 1; i <=12; i++){
			var str = workdate.createCalendar(year,i,selDays,'${curdate}');
			document.getElementById("month" + i).innerHTML = str;
		}
	}

	//工作日期保存
	function btSave_onClick(){
		var yr = biWorkDate_dataset.getValue("biYear").trim();

		var selDays = workdate.getCheckDate();
		if (selDays.length==0) {
			alert("没有工作日不符合");
		}

		PrivAction.saveOrUpdateWorkDate(yr, selDays, checkResult);
	}
	//jianxue.zhang
	function checkflag(data){
		if(data == 1){
			document.getElementById("test").innerHTML="选中的年份正在复核中,已锁定";
			document.getElementById("btSave").disabled="true";
		}else{
			document.getElementById("btSave").disabled="";
			document.getElementById("test").innerHTML="";
		}
	}
	//jianxue.zhang
	function checkResult(data){
		if(data == 0){
			alert("保存成功！");
			document.getElementById("btSave").disabled="true";
			document.getElementById("test").innerHTML="选中的年份正在复核中,已锁定";
		}else{
			alert("保存失败！");
			document.getElementById("btSave").disabled="";
			document.getElementById("test").innerHTML="";
		}
	}

</script>
</@CommonQueryMacro.page>
