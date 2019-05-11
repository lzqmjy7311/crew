<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="工作日期切换">
<table align="left" width="100%">
	<tr>
		<td width="100%">
			主页 &gt; 系统维护 &gt; 工作日期切换
		</td>
	</tr>
	<tr>
		<td width="100%">
			<hr />
		</td >
	</tr>
	<tr>
		<td valign="top" align="left" width="100%">
			<table>
				<tr>
					<td width="400">
						<@CommonQueryMacro.CommonQuery id="cutoverWorkDate" init="true" navigate="false" submitMode="current">
							<FIELDSET><LEGEND>切换工作日期</LEGEND>
							<table width="100%">
								<tr>
									<td class="labeltd">
									上一工作日
									</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="lastDate"/>
									</td>
									<td class="labeltd" id="lastDateDay"  width="100px" style="text-align: center;"></td>
								</tr>
								<tr><td colspan="3"><br></td></tr>
								<tr>
									<td class="labeltd">
									当前工作日
									</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="currentDate"/>
									</td>
									<td class="labeltd" id="currentDateDay" width="100px"  style="text-align: center;"></td>
								</tr>
								<tr><td colspan="3"><br></td></tr>
								<tr>
									<td class="labeltd">
									下一工作日
									</td>
									<td class="datatd">
										<@CommonQueryMacro.SingleField fId="nextDate"/>
									</td>
									<td class="labeltd" width="100px" id="nextDateDay" style="text-align: center;"></td>
								</tr>
							</table>
							</FIELDSET>
							<br>
							<@CommonQueryMacro.Button id= "btSave" />
						</@CommonQueryMacro.CommonQuery>
					</td>

				<tr>
			</table>
		</td>
	</tr>
</table>
<script language="javascript">
	function initCallGetter_post(){
		var lastDate = cutoverWorkDate_dataset.getValue("lastDate");
		document.getElementById("lastDateDay").innerHTML=dayStr(lastDate.getDay());
		var currentDate = cutoverWorkDate_dataset.getValue("currentDate");
		document.getElementById("currentDateDay").innerHTML=dayStr(currentDate.getDay());
    	var nextDate= cutoverWorkDate_dataset.getValue("nextDate");
		document.getElementById("nextDateDay").innerHTML=dayStr(nextDate.getDay());
	}

	function dayStr(day){
		if (day == 0) {
			return "星期天";
		} else if (day == 1) {
			return "星期一";
		}else if (day == 2) {
			return "星期二";
		}else if (day == 3) {
			return "星期三";
		}else if (day == 4) {
			return "星期四";
		}else if (day == 5) {
			return "星期五";
		}else if (day == 6) {
			return "星期六";
		}
	}

	function date_afterClick(date){
	 	document.getElementById("nextDateDay").innerHTML=dayStr(date.getDay());
	}

	function btSave_onClickCheck(){
		var flag = false;


		//var flag = false;
		//var record = biExecConfirmed_dataset.getFirstRecord();
		//while(record){
		//	var v_finishStatus = record.getValue("finishStatus");
		//	//判断是否数据处理完成
		//	if(v_finishStatus == "02"){
		//		flag = true;
		//		break;
		//	}
		//	record=record.getNextRecord();
	   	//}
	   	//if(flag){
	   	//	alert("当前工作日期的数据处理未完成不能切换工作日期！");
	   	//	return false;
	   	//}
	   	return true;
	}


</script>
</@CommonQueryMacro.page>
