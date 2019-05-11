<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#-- session id -->
<#assign sessionkey = RequestParameters["sessionkey"]>
<#-- dropdown viewField -->
<#assign viewField = RequestParameters["viewField"]>
<#-- dropdown fieldmap -->
<#assign fieldMapStr = RequestParameters["fieldMapStr"]>
<#-- dropdown dataset parameter -->
<#assign paramStr = RequestParameters["paramStr"]>
<#-- dropdown target dataset field value -->
<#assign targetFieldStr = RequestParameters["targetFieldStr"]>
<#-- dropdown fieldId -->
<#assign fieldId = RequestParameters["fieldId"]>

<@CommonQueryMacro.page title="dySelect" body="false">
<div id="_dropdown_div" align=left>
	<TABLE id="CalendarTable" class="ymd-calendar" align=left width=100% cellspacing=0 cellpadding=1 rule=all>
	<TR class="title" valign=top>
		<TD align=left>
		<TABLE WIDTH=100% CELLSPACING=1 CELLPADDING=0>
			<TR>
				<TD align=right><INPUT type=button 
					title="上一年" class="ymd-prevyear" 
					onclick="newChangeCalendarDate(_new_calendarControl.year-1,_new_calendarControl.month)"></TD>
				<TD width=40><INPUT id="_calender_year" type=text 
					maxlength=4 class="ymd-year"
					onpropertychange="return _new_calendar_year_onpropertychange()"></TD>
				<TD align=left width=20px><INPUT type=button 
					title="下一年"  class="ymd-nextyear" 
					onclick="newChangeCalendarDate(_new_calendarControl.year+1,_new_calendarControl.month)"></TD>
				<TD align=right width=20px><INPUT type=button 
					title="上个月"  class="ymd-prevmonth" 
					onclick="newChangeCalendarDate(_new_calendarControl.preYear,_new_calendarControl.preMonth)"></TD>
				<TD width=20><INPUT id="_calender_month" type=text 
					size=2 maxlength=2 class="ymd-month"
					onpropertychange="return _new_calendar_month_onpropertychange()"></TD>
				<TD align=left><INPUT type=button 
					title="下个月" class="ymd-nextmonth" 
					onclick="newChangeCalendarDate(_new_calendarControl.nextYear,_new_calendarControl.nextMonth)"></TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
	<TR class="footer">
		<TD align=left>
			<TABLE><TR><TD>
			<INPUT type=button id="button_today" value="" class="ymd-today" onclick="_new_calendar_today_onclick()">
			</TD><TD>
			<INPUT type=button id="selectBtn" class="ymd-yes" value="确定" onclick="_selectCalender()">
			</TD></TR></TABLE>
		</TD>
	</TR>
</TABLE>
</div>
<script language="javascript">

var _sessionkey = "${sessionkey}";
var _fieldMap = "${fieldMapStr}";
var _paramMap = converStr2Map("${paramStr}");
var _targetFieldStrMap = converStr2Map("${targetFieldStr}");
var _fieldId = "${fieldId}";

	init();
	function calendar(){
		var today = new Date();
		if(_today_date){
			today = _today_date;
		}
	 	this.todayDay=today.getDate();
		this.todayMonth=today.getMonth();
		this.todayYear=today.getFullYear();
	 	this.activeCellIndex=0;
	}

	function init(){
		_calendar_days=new Array(constSunday, constMonday, constTuesday, constWednesday, constThursday, constFriday, constSaturday);
		_new_calendarControl=new calendar();
		initElements(CalendarTable);
		document.getElementById("button_today").value= "本月"+_new_calendarControl.todayYear+"-"+(_new_calendarControl.todayMonth+1);
		initDropDownBox("custom");
		initYYYYMMDataset();
		initValue();
	}

	function initYYYYMMDataset(){
		_yyyyMMds = createDataset("yyyyMMds","yyyyMM","");
		initDataset(_yyyyMMds);
		_yyyyMMds.insertRecord("end");
	}

	function initValue(){
		var fieldVal = _targetFieldStrMap[_fieldId];
		if(typeof(fieldVal)!="undefined" && fieldVal.length==6 && !isNumber(fieldVal)){
			newChangeCalendarDate(parseInt(fieldVal.substring(0,4)),parseInt(fieldVal.substring(4,6))-1);
			_new_setCalendarActiveCell();
		}else{
			_new_calendar_today_onclick();
		}
	}

	function newChangeCalendarDate(year, month){
		if (_new_calendarControl.year==year && _new_calendarControl.month==month ) return;

		if (_new_calendarControl.year!=year || _new_calendarControl.month!=month){
			_new_calendarControl.year=year;
			_new_calendarControl.month=month;
		if (month==0){
			 _new_calendarControl.preMonth=11
			 _new_calendarControl.preYear=_new_calendarControl.year-1
		}else{
			 _new_calendarControl.preMonth=_new_calendarControl.month-1
			 _new_calendarControl.preYear=_new_calendarControl.year
		}
		if (month==11){
			_new_calendarControl.nextMonth=0
			_new_calendarControl.nextYear=_new_calendarControl.year+1
		}else{
			_new_calendarControl.nextMonth=_new_calendarControl.month+1
			_new_calendarControl.nextYear=_new_calendarControl.year

		}
		_new_setCalendarActiveCell();
	}

	}

	function _new_calendar_today_onclick(){
		newChangeCalendarDate(_new_calendarControl.todayYear,_new_calendarControl.todayMonth);
		_new_setCalendarActiveCell();
	}

	function _new_calendar_year_onpropertychange(){
		if (!_calender_year.processing && event.propertyName=="value"){
			if (_calender_year.value.length==4){
				_calender_year.processing=true;
				newChangeCalendarDate(getInt(_calender_year.value), _new_calendarControl.month);
				_calender_year.processing=false;
			}
		}
	}

	function _new_calendar_month_onpropertychange(){
		if (!_calender_month.processing && _activeElement==_calender_month && event.propertyName=="value"){
			if (_calender_month.value.length>0){
				_calender_month.processing=true;
				newChangeCalendarDate(_new_calendarControl.year, getInt(_calender_month.value-1));
				_calender_month.processing=false;
			}
		}
	}

	function _new_setCalendarActiveCell(){
		_calender_year.value=_new_calendarControl.year;
		_calender_month.value=_new_calendarControl.month + 1;
	}

	function _selectCalender(){
		_yyyy = _calender_year.value;
		_MM = _calender_month.value;
		if(_yyyy<0||_yyyy>9999){
			_yyyy = _new_calendarControl.todayYear;
			newChangeCalendarDate(_yyyy,_MM - 1);
			_new_setCalendarActiveCell();
		}
		if(_MM<=0||_MM>12){
			_MM = _new_calendarControl.todayMonth + 1;
			newChangeCalendarDate(_yyyy, _MM - 1);
			_new_setCalendarActiveCell();
		}
		_yyyy = padZero(_calender_year.value, 4);
		_MM = padZero(_calender_month.value, 2);

		_yyyyMMds.setValue("yyyyMM",_yyyy + _MM);
		_dropdown_onclick();
	}

	function dropDown_onGetRecord(){
		return _yyyyMMds.getFirstRecord();
	}

	function padZero (num, length) {
   		 num = String(num);
    	length = parseInt(length) || 2;
    	while (num.length < length)
       	 num = "0" + num;
  	  return num;
	}


</script>
</@CommonQueryMacro.page>