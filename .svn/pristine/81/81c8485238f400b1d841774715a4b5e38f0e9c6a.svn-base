<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="节假日维护">
<style>
	.holiday-month{
		border:1px solid #E7F0F5;
	}
	.holiday-month td {
		width:18px;
		height:18px;
		text-align:center;
		display: table-cell;
		vertical-align: center;
	}
	.calendar-monthtr td{
		background:#E0ECFF;
		height:22px;
	}
	.calendar-weektr td{
		background:#FAFAFA;
		color:#888;
		font-weight: bold;
	}
</style>
<@CommonQueryMacro.CommonQuery id="parammng_HolidayDetail" init="true" >
<table>
<tr><td>
	<table align="left">
	      <tr>
      		<td valign="top">
      			<@CommonQueryMacro.DataTable id ="datatableDetail" hasFrame="false" fieldStr="year[100],sunWorkDay[100],sunHoliDay[100]" width="600" readonly="true" /></br>
      		</td>
      	  </tr>
      	  <tr>
      		<td valign="CENTER">
      			<CENTER>
         			<@CommonQueryMacro.Button id= "btUpdate"/>
         			<#--added by Sophie.sun 20090923 jira:bms-1971 begin-->
         			&nbsp;&nbsp;&nbsp;&nbsp;
         			<@CommonQueryMacro.Button id= "btCancel"/>
         			<#--added by Sophie.sun 20090923 jira:bms-1971 end-->
         		</CENTER>
      		</td>
      </tr>
	</table>
</td></tr>
<tr><td>
	<table class="calendar-holiday">
	<tr>
		<td id="一月">
		</td>
		<td id="二月">
		</td>
		<td id="三月">
		</td>
	</tr>
	<tr>
		<td id="四月">
		</td>
		<td id="五月">
		</td>
		<td id="六月">
		</td>
	</tr>
	<tr>
		<td id="七月">
		</td>
		<td id="八月">
		</td>
		<td id="九月">
		</td>
	</tr>
	<tr>
		<td id="十月">
		</td>
		<td id="十一月">
		</td>
		<td id="十二月">
		</td>
	</tr>
</table>
</td></tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
var holidayDef = new Array();
var saved = true;

function btUpdate_postSubmit(button){
	alert("保存成功!");
	win.close();
	parammng_Holiday_dataset.flushData(parammng_Holiday_dataset.pageIndex);
}
<#--added by Sophie.sun 20090923 jira:bms-1971 begin-->
function btCancel_onClickCheck(button){
    unloadPageWindows("pageWin");
    return false;
}
<#--added by Sophie.sun 20090923 jira:bms-1971 end-->
function parammng_HolidayDetail_dataset_flushDataPost(dataset){
	var strHoliday = dataset.getValue("holidayDef");
	holidayDef.splice(0,holidayDef.length);
	for(var i=0;i<366;i++)
	{
		if(strHoliday.substr(i,1)=="1")
			holidayDef.push(false);
		else
			holidayDef.push(true);
	}
	saved = true;
	genCalendar(dataset.getValue("year"));
}
function genCalendar(year)
{
	var sunDay = 0;
	for(var i=0;i<12;i++)
	{
		sunDay = genOneMonth(year,i,sunDay);
	}
}
function genOneMonth(year,month,startSunDay)
{
	var date = new Date(year,month,1,0,0,0,0);
	var monthTable = ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
	var day = ["日 ","一 ","二 ","三 ","四 ","五 ","六 "];
	var container = document.getElementById(monthTable[month]);
	container.vAlign="top";
	var table = document.createElement("table");
	table.className="holiday-month";
	var rowHeader = table.insertRow(table.rows.length);
	rowHeader.className="calendar-monthtr";
	var cell = rowHeader.insertCell(0);
	cell.colSpan = "7";
	cell.innerHTML = monthTable[month];
	cell.align="center";
	var rowHeader = table.insertRow(table.rows.length);
	for(var i=0;i<7;i++)
	{
		var cell = rowHeader.insertCell(i);
		cell.innerHTML=day[i];
	}
	rowHeader.className="calendar-weektr";
	rowHeader = table.insertRow(table.rows.length);
	rowHeader.className="calendar-day";
	for(var i=0;i<date.getDay();i++)
	{
		var cell = rowHeader.insertCell(i);
		$(cell).addClass('calendar-day');
	}
	for(var i=0;i<31;i++)
	{
		if(date.getDay()==0){
			rowHeader = table.insertRow(table.rows.length);
			rowHeader.className="holiday-day";
		}
		var cell = rowHeader.insertCell(date.getDay()%7);
		$(cell).html(date.getDate());
		$(cell).addClass('calendar-day');
		date.setDate(i+2);
		cell.sunDay=startSunDay;
		if(!holidayDef[startSunDay]){
			$(cell).removeClass('calendar-selected');
		}else{
			$(cell).addClass('calendar-selected');
		}
		$(cell).click(function(){
			holidayDef[this.sunDay]=!holidayDef[this.sunDay];
			if(holidayDef[this.sunDay]){
				$(this).addClass('calendar-selected');
			}else{
				$(this).removeClass('calendar-selected');
			}
			saved = false;
		});
		cell.id="holiday_"+startSunDay;
		startSunDay++;
		if(date.getDate()==1)break;
	}
	var childNode = container.firstChild;
	if(childNode!=null)
		container.removeChild(container.firstChild);
	container.appendChild(table);
	return startSunDay;
}

function btUpdate_onClickCheck(button){
	saveHoliday(parammng_HolidayDetail_dataset.getValue("year"));
	return true;
}
<#--modified by Sophie.sun 20090924 jira:bms-1999 begin-->
function confrimSave()
{
	if(confirm("设置尚未保存，需要保存当前节假日设置么？"))
	{
		saveHoliday(parammng_HolidayDetail_dataset.getValue("year"));
		btUpdate.click();
	} else {
		return false;
	}
}
<#--modified by Sophie.sun 20090924 jira:bms-1999 end-->

function saveHoliday(year)
{
	var strHoliday = "";
	for(var i=0;i<366;i++)
	{
		if(holidayDef[i])
			strHoliday+="0";
		else
			strHoliday+="1";
	}
	if(!((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)){
		strHoliday=strHoliday.substring(365,0);
	}

	saved = true;
	parammng_HolidayDetail_dataset.setValue("holidayDef",strHoliday);
	return true;
}
</script>
</@CommonQueryMacro.page>