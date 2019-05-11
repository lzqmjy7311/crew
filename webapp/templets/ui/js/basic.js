function processException(e){
	switch (typeof(e)){
		case "string":{
			if (e!="abort"){
				if (e)
					errAlert(e);
				else
					errAlert(constErrUnknown);
			}
			break;
		}
		case "object":{
			if(e.name == "GD0101"){
				//GD0101=操作员无此功能权限
				errAlert(e.description);
				window.open(_application_root, "_self");
			}else if(e.name == "GD0102"){
				//GD0102=操作员会话无效
				errAlert(e.description);
				window.open(_application_root, "_self");
			}else{
				errAlert(e.description+"\n"+constErrType+":"+(e.number & 0xFFFF));
			}
			break;
		}
	}
}

function isNumber(value){
	if(value == null || value == "" || value == "undefined"){
		return false;
	}
	var newVal = value.trim();
	return /^\d+$/.test(newVal);
}

function trimStr(str){
	str=getValidStr(str);
	if (!str) return "";
	for(var i=str.length-1; i>=0; i--){
		if (str.charCodeAt(i, 10)!=32) break;
	}
	return str.substr(0, i+1);
}

function getValidStr(str) {
	str+="";
	if (str=="undefined" || str=="null")
		return "";
	else
		return str;
}

function encode(strIn)
{
	var intLen=strIn.length;
	var strOut="";
	var strTemp;

	for(var i=0; i<intLen; i++)
	{
		strTemp=strIn.charCodeAt(i);
		if (strTemp>255)
		{
			tmp = strTemp.toString(16);
			for(var j=tmp.length; j<4; j++) tmp = "0"+tmp;
			strOut = strOut+"^"+tmp;
		}
		else
		{
			if (strTemp < 48 || (strTemp > 57 && strTemp < 65) || (strTemp > 90 && strTemp < 97) || strTemp > 122)
			{
				tmp = strTemp.toString(16);
				for(var j=tmp.length; j<2; j++) tmp = "0"+tmp;
				strOut = strOut+"~"+tmp;
			}
			else
			{
				strOut=strOut+strIn.charAt(i);
			}
		}
	}
	return (strOut);
}

function decode(strIn)
{
	var intLen = strIn.length;
	var strOut = "";
	var strTemp;

	for(var i=0; i<intLen; i++)
	{
		strTemp = strIn.charAt(i);
		switch (strTemp)
		{
			case "~":{
				strTemp = strIn.substring(i+1, i+3);
				strTemp = parseInt(strTemp, 16);
				strTemp = String.fromCharCode(strTemp);
				strOut = strOut+strTemp;
				i += 2;
				break;
			}
			case "^":{
				strTemp = strIn.substring(i+1, i+5);
				strTemp = parseInt(strTemp,16);
				strTemp = String.fromCharCode(strTemp);
				strOut = strOut+strTemp;
				i += 4;
				break;
			}
			default:{
				strOut = strOut+strTemp;
				break;
			}
		}

	}
	strOut = strOut.replace(/\^p/g,"\n");
	return (strOut);
}

function getEncodeStr(str) {
	return encode(getValidStr(str));
}

function getDecodeStr(str) {
	return ((str)?decode(getValidStr(str)):"");
}

function compareText(str1, str2){
	str1=getValidStr(str1);
	str2=getValidStr(str2);
	if (str1==str2) return true;
	if (str1=="" || str2=="") return false;
	return (str1.toLowerCase()==str2.toLowerCase());
}

function isTrue(value){
	return (value==true || (typeof(value)=="number" && value!=0) ||
		compareText(value, "true") || compareText(value, "T") ||
		compareText(value, "yes") || compareText(value, "on"));
}

function getStringValue(value){
	if (typeof(value)=="string" || typeof(value)=="object")
		return "\""+getValidStr(value)+"\"";
	else if (typeof(value)=="date")
		return "\""+(new Date(value))+"\"";
	else if (getValidStr(value)=="")
		return "\"\"";
	else
		return value;
}

function getInt(value){
	var result=parseInt(value);
	if (isNaN(result)) result=0;
	return result;
}

function getFloat(value){
	var result=parseFloat(value);
	if (isNaN(result)) result=0;
	return result;
}

function formatFloat(value, decimalLength){
	if(typeof value=="string" && value=="") {
		return "";
	}
	decimalLength=getInt(decimalLength);
	value = Math.round(getFloat(value) * Math.pow(10, decimalLength));
	value = value / Math.pow(10, decimalLength);

	var v = value.toString().split(".");
	if (v[0]==""){
		v[0]="0";
	}

	if (v.length > 1) {
		var len = v[1].length;
		if (len > decimalLength) {
			v[1] = v[1].substring(0, decimalLength);
		}
		else {
			 for (var i=v[1].length; i<decimalLength; i++) {
				v[1] += "0";
			}
		}
	}
	else {
		v[1] = "";
		for (var i=v[1].length; i<decimalLength; i++) {
			v[1] += "0";
		}
	}

	if (decimalLength > 0) {
		return v[0] + "." + v[1];
	}
	else {
		return v[0];
	}
}

function formatDateTime(date, mode){
	date=new Date(date);
	function getDateString(date){
		var years=date.getFullYear();
		var months=date.getMonth()+1;
		var days=date.getDate();

		if (months<10) months="0"+months;
		if (days<10) days="0"+days;
		return unParseDate(years,months,days);
		//return years+"-"+months+"-"+days;
	}

	function getTimeString(date){
		var hours=date.getHours();
		var minutes=date.getMinutes();
		var seconds=date.getSeconds();

		if (hours<10) hours="0"+hours;
		if (minutes<10) minutes="0"+minutes;
		if (seconds<10) seconds="0"+seconds;

		return hours+":"+minutes+":"+seconds;
	}

	if (typeof(date)=="object" && !isNaN(date)){
		if (!mode) mode="timestamp";
		switch (mode){
		    case "predate":;
		    case "postdate":;
			case "date":{
				return getDateString(date);
				break;
			}
			case "time":{
				return getTimeString(date);
				break;
			}
			case "timestamp":{
				return getDateString(date)+" "+getTimeString(date);
				break;
			}
			default:{
				return getDateString(date)+" "+getTimeString(date);
				break;
			}
		}
	}
	else
		return "";
}

function formatViewDateTime(date, mode){
	function getDateString(date){
		var years=date.getFullYear();
		var months=date.getMonth()+1;
		var days=date.getDate();

		if (months<10) months="0"+months;
		if (days<10) days="0"+days;
		return years+"-"+months+"-"+days;
	}

	function getTimeString(date){
		var hours=date.getHours();
		var minutes=date.getMinutes();
		var seconds=date.getSeconds();

		if (hours<10) hours="0"+hours;
		if (minutes<10) minutes="0"+minutes;
		if (seconds<10) seconds="0"+seconds;

		return hours+":"+minutes+":"+seconds;
	}

	if (typeof(date)=="object" && !isNaN(date)){
		if (!mode) mode="timestamp";
		switch (mode){
	        case "predate":;
	        case "postdate":;
			case "date":{
				return getDateString(date);
				break;
			}
			case "time":{
				return getTimeString(date);
				break;
			}
			case "timestamp":{
				return getDateString(date)+" "+getTimeString(date);
				break;
			}
			default:{
				return getDateString(date)+" "+getTimeString(date);
				break;
			}
		}
	}
	else
		return "";
}

function getTypedValue(value, dataType){
	var result="";
	switch (dataType){
		case "string":{
			result=getValidStr(value);
			break;
		}
		case "byte":;
		case "short":;
		case "int":;
		case "long":{
			if(typeof value == 'string') {
				value = value.replace(/,/g, '');
			}
			result=Math.round(parseFloat(value));
			if(isNaN(result)){
				result = value;
			}
			break;
		}
		case "float":;
		case "double":;
		case "currency":;
		case "bigdecimal":{
			if(typeof value == 'string') {
				value = value.replace(/,/g, '');
			}
			result=parseFloat(value);
			if(isNaN(result)){
				result = value;
			}
			break;
		}
        case "predate":;
        case "postdate":;
		case "date":{
			if($.type(value)=='date') {
				result = value;
			} else {
				value=getValidStr(value);
				if(typeof(value)=="undefined"){
					result="";
				}else {
					result = parseDate(value);
				}
			}
			break;
		}
		case "time":;
		case "timestamp":{
			if($.type(value)=='date') {
				result = value;
			} else {
				value=getValidStr(value);
				result = parseTimestamp(value);
			}
			break;
		}
		case "boolean":{
			result=isTrue(value);
			break;
		}
		default:{
			result=getValidStr(value);
			break;
		}
	}
	return result;
}

function getOrigEditorValueStr(value,dataType){
	var result="";
	switch (dataType){
		case "currency":{
			result = currencyToMoney(value);
			break;
		}
		default:{
			result = value;
			break;
		}
	}
	return result;
}

function pArray(){
	this.firstUnit=null;
	this.lastUnit=null;
	this.length=0;

	this.clearAll=_pArray_clearAll;
	this.insertUnit=_pArray_insertUnit;
	this.insertArray=_pArray_insertArray;
	this.deleteUnit=_pArray_deleteUnit;
	this.insertWithData=_pArray_insertWithData;
	this.deleteByData=_pArray_deleteByData;
}

function pArray_clear(pArray){
	var unit=pArray.firstUnit;
	var _unit;
	while (unit){
		_unit=unit;
		unit=unit.nextUnit;
		if (_unit.data) delete _unit.data;
		delete _unit;
	}
	pArray.firstUnit=null;
	pArray.lastUnit=null;
	pArray.length=0;
}

function _pArray_clearAll(){
	pArray_clear(this);
}

function pArray_insert(pArray, mode, unit, newUnit){
	var u1, u2;
	switch (mode){
		case "begin":{
			u1=null;
			u2=pArray.firstUnit;
			break;
		}
		case "before":{
			u1=(unit)?unit.prevUnit:null;
			u2=unit;
			break;
		}
		case "after":{
			u1=unit;
			u2=(unit)?unit.nextUnit:null;
			break;
		}
		default:{
			u1=pArray.lastUnit;
			u2=null;
			break;
		}
	}

	newUnit.prevUnit=u1;
	newUnit.nextUnit=u2;
	if (u1) u1.nextUnit=newUnit; else pArray.firstUnit=newUnit;
	if (u2) u2.prevUnit=newUnit; else pArray.lastUnit=newUnit;
	pArray.length++;
}

function _pArray_insertUnit(mode, unit, newUnit){
	pArray_insert(this, mode, unit, newUnit);
}

function pArray_insertArray(pArray, mode, unit, subArray){
	if (!subArray || !subArray.firstUnit) return;

	var u1, u2;
	switch (mode){
		case "begin":{
			u1=null;
			u2=pArray.firstUnit;
			break;
		}
		case "before":{
			u1=(unit)?unit.prevUnit:null;
			u2=unit;
			break;
		}
		case "after":{
			u1=unit;
			u2=(unit)?unit.nextUnit:null;
			break;
		}
		default:{
			u1=pArray.lastUnit;
			u2=null;
			break;
		}
	}

	subArray.firstUnit.prevUnit=u1;
	subArray.lastUnit.nextUnit=u2;
	if (u1) u1.nextUnit=subArray.firstUnit; else pArray.firstUnit=subArray.firstUnit;
	if (u2) u2.prevUnit=subArray.lastUnit; else pArray.lastUnit=subArray.lastUnit;
	pArray.length+=subArray.length;
}

function _pArray_insertArray(mode, unit, subArray){
	pArray_insertArray(this, mode, unit, subArray);
}

function pArray_delete(pArray, unit){
	var u1, u2;
	u1=unit.prevUnit;
	u2=unit.nextUnit;
	if (u1) u1.nextUnit=u2; else pArray.firstUnit=u2;
	if (u2) u2.prevUnit=u1; else pArray.lastUnit=u1;
	pArray.length--;
	delete unit;
}

function _pArray_deleteUnit(unit){
	pArray_delete(this, unit);
}

function pArray_ex_insert(pArray, data){
	var found=false;
	var _unit=pArray.firstUnit;
	while (_unit){
		if (_unit.data==data){
			found=true;
			break;
		}
		_unit=_unit.nextUnit;
	}

	var newUnit=new Object();
	newUnit.data=data;
	if (!found) pArray_insert(pArray, "end", null, newUnit);
}

function _pArray_insertWithData(data){
	pArray_ex_insert(this, data);
}

function pArray_ex_delete(pArray, data){
	var _unit=pArray.firstUnit;
	while (_unit){
		if (_unit.data==data){
			pArray_delete(pArray, _unit);
			break;
		}
		_unit=_unit.nextUnit;
	}
}

function _pArray_deleteByData(data){
	pArray_ex_delete(this, data);
}

/* shen_antonio.*/
function converStr2Map(str){
	var paramMap = new Object();
	var list = str.split(";");
	var value,ary;
	for(var i=0;i<list.length;i++){
		value = list[i];
		ary = value.split(",");
		if( ary[1]!=null ){
			paramMap[ary[0]] = ary[1];
		}
	}
	return paramMap;
}
//mod by abudula at 2010-9-1 by citiBank start
function replaceEscapeStr(str){

	if(str.indexOf("&#x28;")>-1){
	 	 var reg=new RegExp("&#x28;","g");
	 	 str = str.replace(reg,"(");
	}
	if(str.indexOf("&#x29;")>-1){
		var reg1=new RegExp("&#x29;","g");
		str = str.replace(reg1,")");
	}
	return str;
}
//mod by abudula at 2010-9-1 by citiBank end

function converStr2DataSetParameter(str,dataset){
	str = replaceEscapeStr(str);
	var list = str.split(";");
	var value,ary;
	for(var i=0;i<list.length;i++){
		value = list[i];
		ary = value.split(",");
		if( ary[1]!=null ){
			var val = value.substring(ary[0].length + 1);
			dataset.setParameter(ary[0],getDecodeStr(val));
		}
	}
	return;
}
function converDateSet2Map(dataset){
	var fId,fVal;
	var paramMap = new Object();
	for (var i=0; i<dataset.fields.fieldCount; i++){
		fId  = dataset.getField(i).fieldName;
		fVal = dataset.getString(i);
		if( fVal!=null ){
			paramMap[fId] = fVal;
		}
	}
	paramMap["_session_key"] = dataset.sessionKey;
	return paramMap;
}

function converDateSet2Str(dataset){
	var fId,fVal;
	var str = "";
	for (var i=0; i<dataset.fields.fieldCount; i++){
		fId  = dataset.getField(i).fieldName;
		fVal = dataset.getString(i);
		if( fVal!=null ){
			if(str==""){
				str += fId + "," + fVal;
			}else{
				str += ";" + fId + "," + fVal;
			}
		}
	}
	return str;
}

function converDateSetParameter2Map(dataset){
	var pId,pVal;
	var paramMap2 = new Object();
	for (var i=0; i<dataset.parameters.length; i++){
		pId  = dataset.parameters[i].name;
		pVal = dataset.parameters[i].value;
		if( pVal!=null ){
			paramMap2[pId] = pVal;
		}
	}
	paramMap2["_dataset_id"] = dataset.id;
	return paramMap2;
}

function converDateSetParameter2Map(dataset,paramMap){
var pId,pVal;
for (var i=0; i<dataset.parameters.length; i++){
		pId  = dataset.parameters[i].name;
		pVal = dataset.parameters[i].value;
		if( pVal!=null ){
			paramMap[pId] = pVal;
		}
	}
	paramMap["_dataset_id"] = dataset.id;
	return paramMap;
}

function converDateSetParameter2Str(dataset){
	var pId,pVal;
	var paramStr = "";
	for (var i=0; i<dataset.parameters.length; i++){
		pId  = dataset.parameters[i].name;
		pVal = dataset.parameters[i].value;
		if( pVal!=null ){
			if(paramStr == ""){
				paramStr = pId + "," + getEncodeStr(pVal);
			}else{
				paramStr += ";" + pId + "," + getEncodeStr(pVal);
			}
		}
	}
	return paramStr;
}

function copyDateSetParameter(datasetOrig,datasetNew){
	var pId,pVal;
	for (var i=0; i<datasetOrig.parameters.length; i++){
		pId  = datasetOrig.parameters[i].name;
		pVal = datasetOrig.parameters[i].value;
		if( pVal!=null ){
			datasetNew.setParameter(pId,getDecodeStr(pVal));
		}
	}
}



/*
 * map
 * add by yjw
 *
 * function
 * size()       get the size of the map
 * isEmpty()    the map is Empty
 * clear()      clear map
 * put(key, value)   put the value-key to the map
 * remove(key)       remove the key to the map
 * get(key)          get the key's value from the map,else return null
 * element(index)    use element.key, element.value  get KEY VALUE, else return null
 * containsKey(key)    if the map contain the key
 * containsValue(value) if the map contain the value
 * values()
 * keys()
 *
 * example
 * var map = new Map();
 *
 * map.put("key", "value");
 * var val = map.get("key")
 *
 *
 */
function Map()
{
 this.elements = new Array();

 this.size = function() {
  	return this.elements.length;
 };

 this.isEmpty = function() {
  	return (this.elements.length < 1);
 };

 this.clear = function() {
  	this.elements = new Array();
 };

 this.put = function(_key, _value) {
 	if(this.containsKey(_key)){
 		this.remove(_key);
 	}
  	this.elements.push({key:_key, value:_value});
 };

 this.remove = function(_key) {
	  var bln = false;
	  try  {
	   for (var i = 0; i < this.elements.length; i++) {
	    if (this.elements[i].key == _key){
	     this.elements.splice(i, 1);
	     return true;
	    }
	   }
	  }catch(e){
	   bln = false;
	  }
	  return bln;
 };

 this.get = function(_key) {
	  try{
	   for (var i = 0; i < this.elements.length; i++) {
	    if (this.elements[i].key == _key) {
	     return this.elements[i].value;
	    }
	   }
	  }catch(e) {
	   return null;
	  }
 };

 this.element = function(_index) {
	  if (_index < 0 || _index >= this.elements.length)
	  {
	   return null;
	  }
	  return this.elements[_index];
 };

 this.containsKey = function(_key) {
	  var bln = false;
	  try {
	   for (var i = 0; i < this.elements.length; i++) {
	    if (this.elements[i].key == _key){
	     bln = true;
	    }
	   }
	  }catch(e) {
	   bln = false;
	  }
	  return bln;
 };

 this.containsValue = function(_value) {
	  var bln = false;
	  try {
	   for (var i = 0; i < this.elements.length; i++) {
	    if (this.elements[i].value == _value){
	     bln = true;
	    }
	   }
	  }catch(e) {
	   bln = false;
	  }
	  return bln;
 };

 this.values = function() {
	  var arr = new Array();
	  for (var i = 0; i < this.elements.length; i++) {
	   arr.push(this.elements[i].value);
	  }
	  return arr;
 };

 this.keys = function() {
	  var arr = new Array();
	  for (var i = 0; i < this.elements.length; i++) {
	   arr.push(this.elements[i].key);
	  }
	  return arr;
	 };
}

function calcPageCount(recordCount,pageSize)
{
	var pageCount = 1;
	if( recordCount/pageCount < 1 ) pageCount = 1;
	else{
		pageCount = parseInt(recordCount/pageSize);
		if( recordCount%pageSize > 0 ) pageCount++;
	}
	return pageCount;
}

String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
};

//将数字金额进行千位分隔
function formatCurrency(orgValue){
	var minusIndex = orgValue.indexOf("-");
	if(minusIndex == 0){
		orgValue = orgValue.substring(1,orgValue.length);
	}

	var v_return_value;
	var digit = orgValue.indexOf("."); // 取得小数点的位置
	var int = orgValue.substr(0,digit); // 取得小数中的整数部分
	var i;
	var mag = new Array();
	var word;
	if (orgValue.indexOf(".") == -1) { // 整数时
		i = orgValue.length; // 整数的个数
		while(i > 0) {
			word = orgValue.substring(i,i-3); // 每隔3位截取一组数字
			i-= 3;
			mag.unshift(word); // 分别将截取的数字压入数组
		}
	v_return_value = mag.join(',');
	}
	else{ // 小数时
		i = int.length; // 除小数外，整数部分的个数
		while(i > 0) {
			word = int.substring(i,i-3); // 每隔3位截取一组数字
			i-= 3;
			mag.unshift(word);
		}
		v_return_value = mag.join(',') + orgValue.substring(digit);
	}

	if(minusIndex == 0){
		v_return_value = "-" + v_return_value;
	}
	return v_return_value;
}

function currencyToMoney(value){
	strValue  = value.replace(/,/g,'');
	return strValue;
}

function parseDate(value){
	 return cast(value,'date');
}
//add by zhaozhiguo
function parseTimestamp(value){
	return cast(value,'timestamp');
}
function unParseDate(years,months,days){
	var format = _DATA_FORMAT_;
	switch (format)
	{
		case "YYYY-MM-DD":{
			return years+"-"+months+"-"+days;
			break;
		}
		case "YYYYMMDD":{
			return years.toString()+months.toString()+days.toString();
			break;
		}
		default:{
			return years+"-"+months+"-"+days;
			break;
		}
	}
}

function cast(value, _to) {
	var _from = $.type(value);
	var result = value;
	switch (_to) {
		case "date": {
			if(_from == "string") {
				var reg = new RegExp("^\\d{4}([-/]?)\\d{1,2}\\1\\d{1,2}$");
			 	if(reg.test(value)) {
			 		if(value.indexOf("-")>-1||value.indexOf("/")>-1) {
			 			result = new Date(value.replace(/-/g, "/"));
			 		} else {
			 			if(value.length==8){
			 				result = new Date(value.substr(0,4)+"/"+value.substr(4,2)+"/"+value.substr(6,2));
			 			}
			 		}
			 	}
			} else if(_from == "date") {
				result = value;
			}
			if(result !='NaN' && result != 'Invalid Date') {
				return result;
			} else {
				return value;
			}
			break;
		}
		case "timestamp": {
			if(_from == "string") {
				var reg1 = new RegExp("^\\d{4}([-/])\\d{1,2}\\1\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");//19
				var reg2 = new RegExp("^\\d{4}\\d{2}\\d{2} \\d{2}\\d{2}\\d{2}$");//15
				var reg3 = new RegExp("^\\d{4}\\d{2}\\d{2}\\d{2}\\d{2}\\d{2}$");//14
				if(reg3.test(value)) {
					value = value.substr(0,4)+"/"+value.substr(4,2)+"/"+value.substr(6,2)+" " + value.substr(8,2)+":"+value.substr(10,2)+":"+value.substr(12,2);
					result = new Date(value);
				} else if(reg2.test(value)) {
					value = value.substr(0,4)+"/"+value.substr(4,2)+"/"+value.substr(6,2)+" " + value.substr(9,2)+":"+value.substr(11,2)+":"+value.substr(13,2);
					result = new Date(value);
				} else if(reg1.test(value)) {
					value = value.replace(/-/g, "/");
					result = new Date(value);
				}
			} else if(_from == "date") {
				result = value;
			}
			if(result !='NaN' && result != 'Invalid Date') {
				return result;
			} else {
				return value;
			}
			break;
		}
	}
}

function openNewTab(id,url,vtitle,vticket,vdata){
	var win = this;
	url =  megerURL(_application_root,url);
	while(true){
		if(typeof(win._openTab)!="undefined"){
			win._openTab(id,url,vtitle,vticket,vdata);
			break;
		}else{
			if(win.parent == win){
				return;
			}else{
				win = win.parent;
			}
		}
	}
}

function openBtNewTab(button,path,option){
	//[id=CustCorpInfo,title=F{cname}]
	var id,url,title,ticket;
	url =  path;
	var opts = option.substring(option.indexOf("[")+1,option.indexOf("]")).split(","); 
	var ds = getDatasetByID(button.dataset);
	var optMap = new Map();
	for(var i=0;i<opts.length;i++){
		var item = opts[i].split("=");
		optMap.put(item[0],item[1]);
	}
	if(optMap.get("ticket")!=null){
		ticket =  optMap.get("ticket");
	}else{
		ticket = null;
	}
	
	if(optMap.get("id")!=null){
		var id_v =optMap.get("id");
		if(id_v.match("^F{.*}")!=null){
			var field = id_v.substring(id_v.indexOf("{")+1,id_v.indexOf("}"));
			id = ds.getValue(field);
		}else if(id_v.match("^P{.*}")!=null){
			var param = id_v.substring(id_v.indexOf("{")+1,id_v.indexOf("}"));
			id = ds.getParameter(param);
		}else{
			id = id_v;
		}

	}else{
		id="unknow";
	}
	if(optMap.get("title")!=null){
		var title_v = optMap.get("title");
		if(title_v.match("^F{.*}")!=null){
			var field = title_v.substring(title_v.indexOf("{")+1,title_v.indexOf("}"));
			title = ds.getValue(field);
		}else if(title_v.match("^P{.*}")!=null){
			var param = title_v.substring(title_v.indexOf("{")+1,title_v.indexOf("}"));
			title = ds.getParameter(param);
		}else{
			title = title_v;
		}
	}else{
		title="unknow";
	}
	openNewTab(id,url,title,ticket,{});
}
function unwrapUrl(url) {
	var i = url.indexOf('?');
	var u = url;
	var param = {};
	if (i>-1) {
		url = url.substring(i+1);
		var p = url.split('&');
		for(var j=0;j<p.length;j++) {
			var kv = p[j].split('=');
			if (kv.length==2) {
				param[kv[0]] = kv[1];
			}
		}
		u = u.substring(0,i);
	}
	
	return [u,param];
}

function wrapUrl(url, param) {
	var pstr="";
	for(var k in param) {
		if(typeof param[k] == 'object') continue;
		pstr += "&"+k+"="+param[k];
	}
	if (pstr == "") {
		return url;
	} else {
		var i = url.indexOf('?');
		if (i > -1) {
			url += pstr;
		} else {
			url += "?"+pstr.substring(1);
		}
		return url;
	}
}
/**
 * 禁用指定列的宽度调整功能，如果不指定列则禁用所有列，
 * 如：disableColumnResize('field1'); 或 disableColumnResize();
 */
function disableColumnResizable(field) {
	setTimeout(function() {
		$(".datagrid-header-row .datagrid-cell").each(function(){
			var t = $(this);
			if(field) {
				if(t.attr('field') == field || t.parent().attr('field') == field) {
					t.resizable('disable'); 
				}
			} else {
				t.resizable('disable'); 
			}
		});
	},0);
}

/**
 * 合并列，
 * 支持多级合并
 * 如：mergeColumns('datatable1', ['dataTypeNo,dataNo','dataNo']);
 */
function mergeColumns(tableId, cols, startRow, endRow, level){
	var t = $('#'+tableId).data('rdatagrid').dc.body.children('table');
	var rows = t.find('tr');
	cols = cols || [];
	startRow = startRow || 0;
	endRow = endRow || rows.length-1;
	level = level || 0;
	
	
	function compare(tr1, tr2, cols) {
		var eq = true;
		var td2;
		for (var j=0;j<cols.length;j++) {
			if(cols[j]) {
				var field = 'td[field="'+cols[j]+'"]';
				var cf = tr1.find(field);
				var nf = tr2.find(field);
				if(cf.text() !== nf.text()) {
					eq = false;
					//break;
				}
				td2=td2?td2.add(nf):nf;
			}
		}
		if(eq) {
			td2.hide();
		}
		return eq;
	}
	function gettd(tr, cols) {
		var tds;
		for (var j=0;j<cols.length;j++) {
			if(cols[j]) {
				var field = 'td[field="'+cols[j]+'"]';
				var cf = tr.find(field);
				tds=tds?tds.add(cf):cf;
			}
		}
		return tds;
	}
	
	function _merge(rows, cols, startRow, endRow, level) {
		var colStr = cols[level];
		if(startRow >= endRow || level >= cols.length || !colStr) return;
		
		var col = colStr.split(',');
		var firstrow = rows.eq(startRow);
		var currfields= gettd(firstrow, col);
		rows.each(function(i){
			if (i<=startRow||i>endRow)return;
			var eq = compare(firstrow,  $(this), col);		
			if(eq) {
				currfields.attr('rowSpan', (parseInt(currfields.attr('rowSpan'))||1) +1);
				if (i==endRow-1&&startRow!=endRow) {
					_merge(rows, cols, startRow, endRow, level+1)
				}
			} else {
				firstrow = rows.eq(i);
				currfields= gettd(firstrow, col);
				_merge(rows, cols, startRow, i-1, level+1);
				startRow = i;
			}
			
		});
	}
	_merge(rows, cols, startRow, endRow, level);
}