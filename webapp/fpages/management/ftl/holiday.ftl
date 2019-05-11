<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="节假日维护">

<@CommonQueryMacro.CommonQuery id="parammng_Holiday" init="true" >
	<table align="left">
	      <tr>
      		<td valign="top">
      			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9"/>
      			<@CommonQueryMacro.DataTable id ="datatable1" hasFrame="false" fieldStr="year[100],sunWorkDay[100],sunHoliDay[100]" readonly="true" width="600" height="300"/>
      		</td>
      	  </tr>
      	  <tr>
      		<td valign="CENTER">
      			<CENTER>
         			<@CommonQueryMacro.Button id= "btAddHoliday"/>
         			<@CommonQueryMacro.Button id= "btDetail"/>
         		</CENTER>
      		</td>
      </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function unloadFunction(){
	unfireUserEvent("parammng_HolidayDetail_dataset_afterChange");
	unfireUserEvent("btUserModifySave_onClick");
	unfireUserEvent("init");
	unfireUserEvent("genOneMonth");
}
function btDetail_onClick(button){
	unloadFunction();
	var _year = parammng_Holiday_dataset.getString("year");
	var paramMap = new Map();
  	paramMap.put("year",_year);
  	loadPageWindows("pageWin", "节假日维护", "/fpages/management/ftl/holidayDetail.ftl", paramMap, "winZone");
}
function pageWin_onCloseCheck() {
	if(!saved) {
		confrimSave();
	}
	return true;
}
function btAddHoliday_onClick(button){
	unloadFunction();
	var paramMap = new Map();
	loadPageWindows("pageWin", "节假日新增", "/fpages/management/ftl/holidayAdd.ftl", paramMap, "winZone");
}
</script>
</@CommonQueryMacro.page>