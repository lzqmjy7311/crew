var _fileIncluded_dropdown=true;

var _dropdown_parentwindow=null;
var _dropdown_parentbox=null;
var _dropdown_box=null;
var _dropdown_table=null;
var _dropdown_frame=null;
var _dropdown_dataset=null;
var _date_dropdown_box=null;

var _array_dropdown = new Array();

var _calendarControl=null;
var _tmp_dataset_date=null;

function createDropDown(id) {
	var dropdown=new Object();
	dropdown.id=id;
	dropdown.clearCache=dropdown_clearCache;
	return dropdown;
}

function initDropDown(dropdown){
	_array_dropdown[_array_dropdown.length]=dropdown;
}
//yjw
function getDropDownByID(ID){
	for(var i=0; i<_array_dropdown.length; i++){
		if (_array_dropdown[i].id==ID) return _array_dropdown[i];
	}
	var result=null;
	eval("if (typeof("+ID+")!=\"undefined\") result="+ID+";");
	return result;
}
//yjw
function getDropDowns(){
	return _array_dropdown;
}
function dropdown_clearCache(){
	var dropdown=this;
	dropdown.dropdownbox=null;
}

function initDropDownBox(dropDownType){
	try{
		_isDropDownPage=true;
		if (typeof(_dropdown_succeed)!="undefined" && !isTrue(_dropdown_succeed)){
			throw getDecodeStr(_dropdown_error);
		}
		else{
			if (dropDownType=="dynamic"){
				if (typeof(datasetDropDown)!="undefined") _dropdown_dataset=datasetDropDown;
			}
			initDocument();
			_initDropDownBox(dropDownType);
		}
		return true;
	}
	catch(e){
		processException(e);
		hideDropDown();
		hideStatusLabel(window.parent);
		return false;
	}
}

function _initDropDownBox(dropDownType){
	_document_loading=true;

	switch (dropDownType){
		case "dynamic":{
			_dropdown_div.onkeydown=_dropdown_onkeydown;
		}

		case "custom":{
			_dropdown_parentwindow=window.parent;
			_dropdown_parentbox=_dropdown_parentwindow._dropdown_box;
			if (_dropdown_parentbox==null) return;

			_dropdown_parentwindow._dropdown_window=window;

			if (!_dropdown_parentbox || _dropdown_parentbox.style.visibility=="hidden") return;

			var editor=_dropdown_parentbox.editor;
			_dropdown_div.style.width=
				(_dropdown_parentbox.offsetWidth>editor.offsetWidth)?_dropdown_parentbox.offsetWidth:editor.offsetWidth;

			_dropdown_parentwindow.sizeDropDownBox();

			with (_dropdown_parentwindow._dropdown_frame){
				width="100%";
	            /* shen_antonio SCR begin .*/
				style.visibility="visible";
				/*
				if (filters.blendTrans.status!=2) {
					if (getIEVersion()<"5.5"){
						style.visibility="visible";
					}
					else{
						filters.blendTrans.apply();
						style.visibility="visible";
						filters.blendTrans.play();
					}
				}
				.*/
				/* shen_antonio SCR end .*/
			}

			_dropdown_parentbox.dropDown.dropdownbox=_dropdown_parentbox;
			hideStatusLabel(_dropdown_parentwindow);
			break;
		}
		/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
        case "predate":;
        case "postdate":;
        /*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
		case "date":{
			_dropdown_parentwindow=window;
			_dropdown_parentbox=_dropdown_parentwindow._dropdown_box;
			_dropdown_parentwindow._dropdown_window=window;
			sizeDropDownBox();
			/* shen_antonio SCR begin .*/
			/* old code
			if ((getIEVersion()>="5.5") &&
				_dropdown_parentbox.filters.blendTrans.status!=2)
				_dropdown_parentbox.filters.blendTrans.play();
			.*/
			/* shen_antonio SCR end .*/
			break;
		}

		default:{
			_dropdown_parentwindow=window;
			_dropdown_parentbox=_dropdown_parentwindow._dropdown_box;
			_dropdown_parentwindow._dropdown_window=window;
			_dropdown_dataset=getElementDataset(_dropdown_table);
			sizeDropDownBox();
			/* shen_antonio SCR begin .*/
			/* old code 
			if ((getIEVersion()>="5.5") &&
				_dropdown_parentbox.filters.blendTrans.status!=2)
				_dropdown_parentbox.filters.blendTrans.play();
			.*/
			/* shen_antonio SCR end .*/
			break;
		}
	}

	_dropdown_parentbox.prepared=true;
	var editor=_dropdown_parentbox.editor;
	if (editor) dropDownLocate();
	_document_loading=false;
}

function sizeDropDownBox(){
	function _sizeDropDownBox(new_width, new_height){
		with (_dropdown_box){
			var editor=_dropdown_box.editor;
			var dropdown=_dropdown_box.dropDown;
			var maxHeight=parseInt(dropdown.height);
			if (isNaN(maxHeight) || maxHeight<20) maxHeight=300;

			var pos=getAbsPosition(editor, document.body);
			var _posLeft=pos[0];
			var _posTop=pos[1]+editor.offsetHeight+1;

			if (new_height>maxHeight &&
				!(dropdown.type=="dynamic" && getInt(dropdown.pageSize)>0)){
				new_height=maxHeight;
				new_width+=16;
				if (!(getIEVersion()<"5.5"))
					style.overflowY="scroll";
				else
					style.overflowY="visible";
			}
			else{
				style.overflowY="hidden";
			}

			var document_width=document.body.clientWidth + document.body.scrollLeft;
			var document_height=document.body.clientHeight + document.body.scrollTop;

			if (_posLeft+new_width>document_width && document_width>new_width) _posLeft=document_width-new_width;
			if (_posTop+new_height>document_height && pos[1]>new_height) _posTop=pos[1]-new_height-5;
			style.posLeft=_posLeft;
			style.posTop=_posTop;
			style.posHeight=new_height+4;
			if (Math.abs(new_width+4-style.posWidth)>4) style.posWidth=new_width+4;
			style.borderWidth="2px";
		}
	}
	if (!isDropdownBoxVisible()) return;

	try{
		var _width, _height;
		switch (_dropdown_box.dropDown.type){
			case "dynamic":;
			case "custom":{
				with (_dropdown_frame){
					_height=_dropdown_window._dropdown_div.offsetHeight;
					_width=_dropdown_window._dropdown_div.offsetWidth;
					style.posWidth=_width;
					style.posHeight=_height;
				}
				break;
			}
			/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
	        case "predate":;
	        case "postdate":;
	        /*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
			case "date":{
				_width=CalendarTable.offsetWidth;
				_height=CalendarTable.offsetHeight;
				break;
			}

			default:{
				_width=_dropdown_table.offsetWidth;
				_height=_dropdown_table.offsetHeight;
				break;
			}
		}
		_sizeDropDownBox(_width, _height);
	}
	catch(e){
		//do nothing
	}
}

function canDropDown(editor){
	var field=getElementField(editor);
	var hasDropDown = ((field && field.dropDown) || editor.getAttribute("dropDown"));
	return (hasDropDown && !compareText(editor.type, "checkbox"));
}

function getDropDownBox(dropdown){
	var box=null;
	//shen_antonio
	if(dropdown.cached==false){
		if(dropdown.cache){
			dropdown.clearCache();
		}
	}
	//
	if (dropdown.cache){
		box=dropdown.dropdownbox;
	}

	if (!box){
		box=document.createElement("<DIV class=\"dropdown_frame\" style=\"overflow-X: hidden; position: absolute; visibility: hidden; z-index: 10000\"></DIV>");
		document.body.appendChild(box);
		box.dropDown = dropdown;
	}
	_dropdown_box=box;
}

function getDropDownBtn(){
	if  (typeof(_dropdown_btn)=="undefined"){
		obj=document.createElement("<INPUT class=\"dropdown_button\" id=_dropdown_btn type=button tabindex=-1 value=6 hidefocus=true"+
			" style=\"position: absolute; visibility: hidden; z-index: 9999\""+
			" LANGUAGE=javascript onmousedown=\"return _dropdown_btn_onmousedown(this)\" onfocus=\"return _dropdown_btn_onfocus(this)\">");
		obj.style.background = "url("+_theme_root+"/dropdown_button.gif)";
		document.body.appendChild(obj);
		return obj
	}
	else{
		return _dropdown_btn;
	}
}

function showDropDownBox(_editor){
	try{
		if (!canDropDown(_editor)) return;
		if (!isDropdownBoxVisible()){
			var dropDownId=_editor.getAttribute("dropDown");
			if (!dropDownId) {
				var field=getElementField(_editor);
				if (field) dropDownId=field.dropDown;
			}

			eval("var dropdown=" + dropDownId);
			var eventName=getElementEventName(dropdown, "beforeOpen");
			var event_result=fireUserEvent(eventName, [dropdown]);
			if (event_result) throw event_result;

			getDropDownBox(dropdown);
			_dropdown_box.editor=_editor;
			_dropdown_box.prepared=false;
		    /* shen_antonio for SCR begin .*/
			/* old code
			if (_dropdown_box.filters.blendTrans.status==2) return;
			.*/
			/* shen_antonio for SCR end .*/

			var dataset=getElementDataset(_editor);
			if (dataset){
				if (!dataset.record) dataset.insertRecord();
			}

			with (_dropdown_box){
				style.overflowY="hidden";
				switch (dropdown.type){
					case "dynamic":;
					case "custom":{
						style.visibility="visible";
						style.length="1";
						if (_editor.offsetWidth>128)
							style.width=editor.offsetWidth
						else
							style.width=128;
						break;
					}

					default:{
						/* shen_antonio SCR begin .*/
						style.visibility="visible";
						/* old code 
						if (filters.blendTrans.status!=2) {
							if (!(getIEVersion()<"5.5")) filters.blendTrans.apply();
							style.visibility="visible";
						}
						.*/
						/* shen_antonio SCR end .*/
						break;
					}
				}
				if (!_dropdown_box.cached){
					switch (dropdown.type){
						case "dynamic":{
							showStatusLabel(window, constDownLoadingData, _editor);
							if (dropdown.sessionKey){
								var dyDDUrl = _dynamicDropDownUrl;
							    if(dropdown.viewType=="table"){
									dyDDUrl = _dynamicDropDownUrl;
								}else if(dropdown.viewType=="tree"){
									dyDDUrl = _dynamicDropDownTreeUrl;
								}else{
									dyDDUrl = _dynamicDropDownUrl;
								}
								var _url=_extra_library+ dyDDUrl +"?sessionkey="+dropdown.sessionKey+
									"&fields="+getValidStr(dropdown.fields)+"&showheader="+((dropdown.showHeader)?"1":"0")+
									"&fieldmeta="+dropdown.fieldMeta;
								var _dataset=dropdown.dataset;
								if (typeof(_dataset)=="string") _dataset=getDatasetByID(_dataset);
								if (_dataset){
								/* shen_antonio 20080129.*/
								/*
									for(var i=0; i<_dataset.parameters.length; i++){
										_url+="&paramname="+_dataset.parameters[i].name+"&paramvalue="+getEncodeStr(_dataset.parameters[i].value);
									}
									*/
								/* .*/
									_url+= "&paramstr=" + converDateSetParameter2Str(_dataset);
									_url+= "&CQId=" + _dataset.getParameter("CQId");
									_url+= "&init=" + _dataset.init;
									_url+= "&require=" + _dataset.require;
									_url+= "&viewField=" + dropdown.fields;
								}
								_dropdown_box.innerHTML="<IFRAME height=0 frameborder=0 marginheight=0 marginwidth=0 scrolling=no"+
									" src=\""+_url+"\""+
									" style=\"position:_absolute;visibility:hidden;border-style: none\"></IFRAME>";
								_dropdown_frame=_dropdown_box.firstChild;
							}
							break;
						}

						case "custom":{
							showStatusLabel(window, constDownLoadingData, _editor);
							var _url = dropdown.url;
							if (_url.substring(0,1)=="/")
							{
								_url = _application_root+_url;
							}
							var fieldMapStr = dropdown.fieldMap;
							var viewField = dropdown.fields;
							var fieldId = dropdown.fieldId;
							if( _url.lastIndexOf("?")!=-1){
								_url += "&sessionkey="+dropdown.sessionKey+"&fieldMapStr="+fieldMapStr+"&viewField="+viewField+"&fieldId="+fieldId;
							}else{
								_url += "?sessionkey="+dropdown.sessionKey+"&fieldMapStr="+fieldMapStr+"&viewField="+viewField+"&fieldId="+fieldId;
							}
							var _targetDataset=dropdown.targetDataset;
							if (typeof(_targetDataset)=="string") _targetDataset=getDatasetByID(_targetDataset);
							if(_targetDataset){
								var targetFieldStr = converDateSet2Str(_targetDataset);
								_url +="&targetFieldStr="+targetFieldStr;
							}
							var _dataset=dropdown.dataset;
							if (typeof(_dataset)=="string") _dataset=getDatasetByID(_dataset);
							if(_dataset){
								var paramStr = converDateSetParameter2Str(_dataset);
								_url +="&paramStr="+paramStr;
							}
							_dropdown_box.innerHTML="<IFRAME height=0 frameborder=0 marginheight=0 marginwidth=0 scrolling=no"+
								" src=\""+_url+"\""+
								" style=\"overflow: hidden; position:_absolute; visibility:hidden; border-style: none\"></IFRAME>";
							_dropdown_frame=_dropdown_box.firstChild;
							break;
						}
						/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
				        case "predate":;
				        case "postdate":;
				        /*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
						case "date":{
							/*modified by wangpeng 20091119 日历改造 BMS-2269 begin*/
							var field=getElementField(_editor);
							createCalendar(_dropdown_box,field,_editor);
							/*modified by wangpeng 20091119 日历改造  BMS-2269 end*/
							_initDropDownBox(dropdown.type);
							_dropdown_box.onkeydown=_calendar_onkeydown;
							break;
						}

						default:{
							style.width=_editor.offsetWidth;
							createListTable(_dropdown_box);
							_dropdown_table.onkeydown=_dropdown_onkeydown;

							var _dataset;
							if (dropdown.type=="list"){
								_dataset=getDropDownItems(dropdown);
								if (!dropdown.fields){
									if (isTrue(dropdown.mapValue))
										dropdown.fields="label";
									else
										dropdown.fields="value";
								}
							}
							else{
								_dataset=dropdown.dataset;
								if (typeof(_dataset)=="string") _dataset=getDatasetByID(_dataset);
							}

							if (_dataset){
							/*shen_antonio.*/
								//showStatusLabel(window, constDownLoadingData, _editor);
								setElementDataset(_dropdown_table, _dataset);
								_dropdown_table.fields=dropdown.fields;
								initElements(_dropdown_table);
								refreshTableData(_dropdown_table);
							}
							_initDropDownBox(dropdown.type);
							break;
						}
					}
				}
				else{
					switch (dropdown.type){
						case "dynamic":;
						case "custom":{
							_dropdown_frame=_dropdown_box.firstChild;
							dropdown.dropdown_window._initDropDownBox(dropdown.type);
							break;
						}

						default:{
							for (var i=0; i<_dropdown_box.children.length; i++){
								var obj=_dropdown_box.children[i];
								obj.style.visibility="visible";
								if (compareText(obj.getAttribute("extra"), "datatable")){
									if (obj.needRefresh) {
										obj.refreshData();
									}
								}
							}
							_dropdown_table=dropdown.dropdown_table;
							_initDropDownBox(dropdown.type);
							break;
						}
					}
				}
			}
			_editor.dropDownVisible=true;
			if  (typeof(_dropdown_btn)!="undefined") _dropdown_btn.value="5";
			/*added by wangpeng 20091218 BMS-2274 dynamiceditor begin*/
			/*
			if (_dropdown_window && _dropdown_window._dropdown_div && _dropdown_window._dropdown_div.afterShow) 
				eval("_dropdown_window."+_dropdown_window._dropdown_div.afterShow+"()");
				*/
			/*added by wangpeng 20091218 BMS-2274 dynamiceditor end*/
		}
	}
	catch(e){
		processException(e);
	}
}

function hideDropDownBox(){
	if (!_dropdown_box) return;
	if (isDropdownBoxVisible()){
		_skip_activeChanged=true;
		var editor=_dropdown_box.editor;
		var dropdown=_dropdown_box.dropDown;
		if (_dropdown_box.prepared && dropdown.cache){
			dropdown.dropdown_box=_dropdown_box;
			_dropdown_box.cached=true;
			switch (dropdown.type){
				case "list":;
				case "dataset":{
					dropdown.dropdown_table=_dropdown_table;
					break;
				}
				case "dynamic":;
				case "custom":{
					dropdown.dropdown_window=_dropdown_window;
					break;
				}
			}

			for (var i=0; i<_dropdown_box.children.length; i++){
				_dropdown_box.children[i].style.visibility="hidden";
			}
			_dropdown_box.style.visibility="hidden";
			_dropdown_window=null;
		}
		else{
			_dropdown_box.editor=null;
			switch (_dropdown_box.dropDown.type){
				case "list":
				case "dataset":{
					setElementDataset(_dropdown_table, null);
					break;
				}
				case "dynamic":;
				case "custom":{
					if (typeof(_dropdown_frame)!="undefined"){
						_dropdown_frame.style.visibility="hidden";
						_dropdown_frame.removeNode(true);
					}
					break;
				}
			}
			_dropdown_window=null;

			for (var i=0; i<_dropdown_box.children.length; i++){
				_dropdown_box.children[i].style.visibility="hidden"
			}
			_dropdown_box.style.visibility="hidden";
			_dropdown_box.removeNode(true);
			_dropdown_box=null;
		}

		editor.dropDownVisible=false;
		if  (typeof(_dropdown_btn)!="undefined") _dropdown_btn.value="6";
	}
}

function isDropDownBtnVisible(){
	if  (typeof(_dropdown_btn)!="undefined")
		return (_dropdown_btn.style.visibility=="visible")
	else
		return false;
}

function sizeDropDownBtn(_editor){
	if (!isDropDownBtnVisible()) return;
	with (_dropdown_btn){
		var pos=getAbsPosition(_editor);

		style.height=_editor.offsetHeight-2;
		style.width=16;
		style.posLeft=pos[0]+_editor.offsetWidth-offsetWidth-1;
		style.posTop=pos[1]+1;
	}
}

function showDropDownBtn(_editor){
	if (!canDropDown(_editor)) return;
	getDropDownBtn();
	if (typeof(_dropdown_btn)=="undefined") return;

	with (_dropdown_btn){
		if (!isDropDownBtnVisible()){
			setAttribute("editor", _editor);
			style.visibility="visible";
			sizeDropDownBtn(_editor);

			var oldWidth=_editor.offsetWidth;
			_editor.style.borderRightWidth=18;
			_editor.style.width=oldWidth;
		}
	}
}

function hideDropDownBtn(){
	if  (typeof(_dropdown_btn)=="undefined") return;

	if (isDropDownBtnVisible()){
		var editor=_dropdown_btn.editor;
		if (editor){
			var oldWidth=editor.offsetWidth;
			editor.style.borderRightWidth=1;
			editor.style.width=oldWidth;
		}
		_dropdown_btn.style.visibility="hidden";
		_dropdown_btn.editor=null;
	}
}

function _dropdown_btn_onmousedown(button){
	var obj=button.editor;
	if (!isDropdownBoxVisible()){
		if (obj) showDropDownBox(obj);
	}
	else
		hideDropDownBox();
}

function _dropdown_btn_onfocus(button){
	var obj=button.editor;
	if (obj) obj.focus();
}

function createListTable(parent_element){
	_dropdown_table=document.createElement("<table extra=datatable isDropDownTable=true readOnly=true width=100% "+
		" cellspacing=0 cellpadding=2 rules=all></table>");

	if (parent_element)
		parent_element.appendChild(_dropdown_table);
	else
		document.body.appendChild(_dropdown_table);
}

function dropDownLocate(){
	var editor=_dropdown_parentbox.editor;
	var dropdown=_dropdown_parentbox.dropDown;
	switch (dropdown.type){
		/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
	    case "predate":;
	    case "postdate":;
	    /*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
		case "date":{
			/*modified by wangpeng 20091119  日历改造 ,编辑框和日历联动 BMS-2269  begin*/
			//var _date=new Date(editor.value);
			var _date=convertStr2Date_new(editor.value);
			/*modified by wangpeng 20091119 日历改造 BMS-2269 end*/
			if (!isNaN(_date)) setCalendarDate(_date);
			break;
		}
		default:{
			if (_dropdown_dataset){
				var fieldName;

				if (dropdown.type=="list"){
					fieldName=(isTrue(dropdown.mapValue))?"label":"value";
				}
				else{
					fieldName=dropdown.dataField;
					if (!fieldName) fieldName=editor.getAttribute("dataField");
				}

				var value=editor.value;
				var record=_dropdown_dataset.locate(fieldName, value);
				if (record) _dropdown_dataset.setRecord(record);
			}
			break;
		}
	}
}

function hideDropDown() {
	var editor=_dropdown_parentbox.editor;
	_dropdown_parentwindow.hideDropDownBox();
	editor.focus();
}

function _standard_dropdown_keyDown(keycode){
	switch(keycode){
		//PageUp
		case 33:{
			if (_dropdown_dataset){
				var pageIndex=(_dropdown_dataset.record)?_dropdown_dataset.record.pageIndex-1:1;
				_dropdown_dataset.moveToPage(pageIndex);
			}
			break;
		}
		//PageDown
		case 34:{
			if (_dropdown_dataset){
				var pageIndex=(_dropdown_dataset.record)?_dropdown_dataset.record.pageIndex+1:1;
				_dropdown_dataset.moveToPage(pageIndex);
			}
			break;
		}
		//Up
		case 38:{
			if (_dropdown_dataset){
				_dropdown_dataset.movePrev();
			}
			break;
		}
		//Down
		case 40:{
			if (_dropdown_dataset){
				_dropdown_dataset.moveNext();
			}
			break;
		}
	}
}

function processDropDownKeyDown(keycode) {
	switch(keycode){
		//Enter
		case 13:{
			/*modified by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
			/*added by wangpeng 20091120 日历改造,可设置日期范围 BMS-2269   begin*/
			if(_dropdown_parentbox.dropDown.type=="date" || _dropdown_parentbox.dropDown.type=="predate" 
				|| _dropdown_parentbox.dropDown.type=="postdate"){
			var validateResult=validateCalendarDateValue();
			if(validateResult[0]==false){
				alert(validateResult[1]);
				return;
			}
			}
			/*added by wangpeng 20091120 日历改造,可设置日期范围 BMS-2269   end*/
			/*modified by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
			dropDownSelected();
			break;
		}
		//ESC
		case 27:{
			hideDropDown();
			break;
		}
		//F2
		case 113:{
			hideDropDown();
			break;
		}
		//F7
		case 118:{
			hideDropDown();
			break;
		}
		default:{
			switch (_dropdown_parentbox.dropDown.type){
				case "list":
				case "dataset":
				case "dynamic":{
					_standard_dropdown_keyDown(keycode);
					break;
				}
				/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
		        case "predate":;
		        case "postdate":;
		        /*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
				case "date":{
					_calendar_onkeydown();
					break;
				}
				default:{
					if (typeof(dropDown_onKeyDown)!="undefined") dropDown_onKeyDown(keycode);
					break;
				}
			}
		}
	}
}

function dropDownSelected(){
	var record;
	switch (_dropdown_parentbox.dropDown.type){
		case "list":
		case "dataset":
		case "dynamic":{
			if (_dropdown_dataset) record=_dropdown_dataset.record;
			if(typeof(record) == "undefined"){
				hideDropDown();
				break;
			}
			if(_dropdown_parentbox.editor.value==record.getValue(0))
			{
				hideDropDown();
				return;
			}
			break;
		}
		/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
        case "predate":;
        case "postdate":;
        /*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
		case "date":{
			_tmp_dataset_date=createDataset("_tmp_dataset_date");
			_tmp_dataset_date.addField("value");
			initDataset(_tmp_dataset_date);
			_tmp_dataset_date.insertRecord();
			_tmp_dataset_date.setValue("value", new Date(_calendarControl.year, _calendarControl.month, _calendarControl.day));
			_tmp_dataset_date.updateRecord();
			record=_tmp_dataset_date.record;
			break;
		}
		default:{
			if (typeof(dropDown_onGetRecord)!="undefined") record=dropDown_onGetRecord();
			break;
		}
	}

	if (record){
		_dropdown_parentwindow.processDropDownSelected(_dropdown_parentbox.editor, record, false);
		hideDropDown();
	}
	if (_tmp_dataset_date) freeDataset(_tmp_dataset_date);
}

function _dropdown_onkeydown(){
	processDropDownKeyDown(event.keyCode);
}

function _dropdown_onclick(){
	dropDownSelected();
}

function getDropDownItems(dropdown){
        var items=dropdown._items;
        if (!items){
                initDropDownItems(dropdown);
                items=dropdown._items;
        }
        return items;
}

function _initDropDownItems(itemsStr, mapValue){
        if (!itemsStr) return null;
        var splitStr=";";
        var arrayItem=createDataset();
        arrayItem.id="_dropDown_items";
        arrayItem.readOnly=true;

        if (mapValue){
                var field;
                field=arrayItem.addField("label");
                field=arrayItem.addField("value");
                field.visible=false;

                var tmp=itemsStr.split(splitStr);
                var index;
                for (var i=0; i<tmp.length; i++ ){
                        index=tmp[i].indexOf("=");
                        record=new Array();
                        record[0]=getDecodeStr(tmp[i].substr(0, index));
                        record[1]=getDecodeStr(tmp[i].substr(index+1));
                        pArray_insert(arrayItem, "end", null, record);
                }

        }
        else{
                arrayItem.addField("value");

                var tmp=itemsStr.split(splitStr);
                for (var i=0; i<tmp.length; i++ ){
                        record=new Array();
                        record[0]=getDecodeStr(tmp[i]);
                        pArray_insert(arrayItem, "end", null, record);
                }
        }
        return arrayItem;
}

function initDropDownItems(dropdown){
        if (!dropdown.items) return;
        var items=_initDropDownItems(dropdown.items, isTrue(dropdown.mapValue));
        if (!items) return;
        initDataset(items);
        dropdown._items=items;
}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

var _calendar_days;

function _calendar_year_onpropertychange(){
	if (!_calender_year.processing && event.propertyName=="value"){
		if (_calender_year.value.length==4){
			_calender_year.processing=true;
			changeCalendarDate(getInt(_calender_year.value), _calendarControl.month);
			_calender_year.processing=false;
		}
	}
}

function _calendar_month_onpropertychange(){
	if (!_calender_month.processing && _activeElement==_calender_month && event.propertyName=="value"){
		if (_calender_month.value.length>0){
			_calender_month.processing=true;
			changeCalendarDate(_calendarControl.year, getInt(_calender_month.value-1));
			_calender_month.processing=false;
		}
	}
}

/*modified by wangpeng 20091124 日历改造 BMS-2269  begin*/
function createCalendar(parent_element,field,editor){
	function calendar(){
		var today=NaN;
		var oldDate=NaN;
		if(editor){
			oldDate=convertStr2Date_new(editor.value);
		}
		
		if(typeof(_today_date)=="object"){
		 	today=_today_date;
		}else{
	 		today=new Date();
	 	}
		
		if(isNaN(oldDate)){
			oldDate=today;
		}
	 	this.todayDay=today.getDate();
		this.todayMonth=today.getMonth();
		this.todayYear=today.getFullYear();
	 	this.activeCellIndex=0;
	 	this.oldDate=oldDate;
	}

	if (typeof(CalendarTable)=="object") {
		CalendarTable.removeNode(true);
	}

	_calendar_days=new Array(constSunday, constMonday, constTuesday, constWednesday, constThursday, constFriday, constSaturday);
	_calendarControl=new calendar();

	_calendarControl.minDate=NaN;
	_calendarControl.maxDate=NaN;
	_calendarControl.editor=null;
	if(editor){
		_calendarControl.editor=editor;
	}
	
	/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  begin*/
	if(field && field.dataType){
		if(field.dataType=="predate"){
			_calendarControl.maxDate=new Date(_calendarControl.todayYear,_calendarControl.todayMonth,_calendarControl.todayDay-1);
		}else if(field.dataType=="postdate"){
			_calendarControl.minDate=new Date(_calendarControl.todayYear,_calendarControl.todayMonth,_calendarControl.todayDay+1);
		}
	}
	/*added by wangpeng 20091126 BMS-2274 添加predate和postdate的数据类型支持  end*/
	
	if(field && field.name && field.dataset && field.dataset.id){
	var eventName=field.dataset.id+"_"+field.name+"_onInitCalendar";
	var event_result=fireUserEvent(eventName, [_calendarControl,field]);
	if (event_result) throw event_result;
	}

	var tmpHTML="";
	tmpHTML+="<TABLE id=\"CalendarTable\" class=\"calendar\" width=200px cellspacing=0 cellpadding=1 rule=all>";
	tmpHTML+="<TR class=\"title\" valign=top><TD>";
	tmpHTML+="<TABLE WIDTH=100% CELLSPACING=1 CELLPADDING=0>";
	tmpHTML+="<TR><TD align=right>";
	tmpHTML+="<INPUT type=button extra=button value=3 title=\""+constLastYear+"\" style=\"FONT-SIZE:8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px\" onclick=\"changeCalendarDate(_calendarControl.year-1,_calendarControl.month)\">";
	tmpHTML+="</TD><TD width=1>";
	tmpHTML+="<INPUT id=\"_calender_year\" type=text class=editor size=4 maxlength=4 onpropertychange=\"return _calendar_year_onpropertychange()\">";
	tmpHTML+="</TD><TD align=left width=20px>";
	tmpHTML+="<INPUT type=button extra=button value=4 title=\""+constNextYear+"\" style=\"FONT-SIZE:8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px\" onclick=\"changeCalendarDate(_calendarControl.year+1,_calendarControl.month)\">";
	tmpHTML+="</TD>";
	tmpHTML+="<TD align=right width=20px>";
	tmpHTML+="<INPUT type=button extra=button value=3 title=\""+constLastMonth+"\" style=\"FONT-SIZE:8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px\" onclick=\"changeCalendarDate(_calendarControl.preYear,_calendarControl.preMonth)\">";
	tmpHTML+="</TD><TD width=1>";
	tmpHTML+="<INPUT id=\"_calender_month\" type=text class=editor size=2 maxlength=2 onpropertychange=\"return _calendar_month_onpropertychange()\">";
	tmpHTML+="</TD><TD align=left>";
	tmpHTML+="<INPUT type=button extra=button value=4 title=\""+constNextMonth+"\" style=\"FONT-SIZE: 8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px\" onclick=\"changeCalendarDate(_calendarControl.nextYear,_calendarControl.nextMonth)\">";
	tmpHTML+="</TD></TR>";
	tmpHTML+="</TABLE></TD></TR>";

	tmpHTML+="<TR><TD>";
	tmpHTML+="<TABLE border=1 bordercolor=silver id=\"calendarData\" HEIGHT=100% WIDTH=100% CELLSPACING=0 CELLPADDING=0 style=\"BORDER-COLLAPSE: collapse\"";
	tmpHTML+="onclick=\"_calendar_cell_onclick(event.srcElement)\">";
	tmpHTML+="<TR height=20px style=\"background-image: url("+_theme_root+"/table_title.gif)\">";
	for (var i=0;i<=6;i++){
		tmpHTML+="<TD align=center>"+_calendar_days[i]+"</TD>";
	}
	tmpHTML+="</TR>";
	for(var i=0;i<=5;i++){
		tmpHTML+="<TR>";
		for(var j=0;j<=6;j++){
			tmpHTML+="<TD align=center></TD>";
		}
		tmpHTML+="</TR>";
	}
	tmpHTML+="</TABLE></TD></TR>";

	tmpHTML+="<TR class=\"footer\"><TD align=right>";
	tmpHTML+="<INPUT extra=button type=button id=\"button_today\" value=\""+constToday+" "+_calendarControl.todayYear+"-"+(_calendarControl.todayMonth+1)+"-"+_calendarControl.todayDay+"\" onclick=\"_calendar_today_onclick()\"";
	tmpHTML+="</TD></TR></TABLE>";
	if (parent_element)
		parent_element.innerHTML=tmpHTML;
	else
		document.body.innerHTML=tmpHTML;

	initElements(CalendarTable);
	changeCalendarDate(_calendarControl.oldDate.getFullYear(),_calendarControl.oldDate.getMonth(),_calendarControl.oldDate.getDate());
	
	/*added by wangpeng 20091130 输入框内容选中 BMS-2286 begin*/
	if(editor){
		editor.select();
	}
	/*added by wangpeng 20091130 输入框内容选中 BMS-2286 end*/
}
/*modified by wangpeng 20091124 日历改造 BMS-2269  end*/

function setCalendarDate(date){
	changeCalendarDate(date.getFullYear(),date.getMonth(),date.getDate());
}

/*modified by wangpeng 20091119 日历改造,增加可选择时间范围 BMS-2269  begin*/
function changeCalendarDate(year, month, day){
	if (_calendarControl.year==year && _calendarControl.month==month && (!day || _calendarControl.day==day)) return;

	if (_calendarControl.year!=year || _calendarControl.month!=month){
		_calendarControl.year=year;
		_calendarControl.month=month;

		if (month==0){
			 _calendarControl.preMonth=11
			 _calendarControl.preYear=_calendarControl.year-1
		}else{
			 _calendarControl.preMonth=_calendarControl.month-1
			 _calendarControl.preYear=_calendarControl.year
		}
		if (month==11){
			_calendarControl.nextMonth=0
			_calendarControl.nextYear=_calendarControl.year+1
		}else{
			_calendarControl.nextMonth=_calendarControl.month+1
			_calendarControl.nextYear=_calendarControl.year

		}
		_calendarControl.startday=(new Date(year,month,1)).getDay()
		if (_calendarControl.startday==0) _calendarControl.startday=7
		var curNumdays=getNumberOfDays(_calendarControl.month,_calendarControl.year)
		var preNumdays=getNumberOfDays(_calendarControl.preMonth,_calendarControl.preYear)
		var nextNumdays=getNumberOfDays(_calendarControl.nextMonth,_calendarControl.nextYear)
		var startDate=preNumdays-_calendarControl.startday+1
		var endDate=42-curNumdays-_calendarControl.startday

		_calender_month.value=(_calendarControl.month+1);
		_calender_year.innerText=_calendarControl.year

		var datenum=0;
		var tmpDate;
		for (var i=startDate;i<=preNumdays;i++){
			var cell = calendarData.cells[datenum+7];
			cell.monthAttribute="pre";
			cell.className="cell_trailing";
			cell.innerText=i;
			
			//range
			tmpDate=new Date(_calendarControl.preYear,_calendarControl.preMonth,i);
			if(outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,tmpDate)){
				cell.className="cell_trailing_outrange";
			}
			datenum++;
		}
		for (var i=1;i<=curNumdays;i++){
			var cell = calendarData.cells[datenum+7];
			cell.monthAttribute="cur";
			if (datenum != _calendarControl.activeCellIndex){
				cell.className="cell_day";
			}
			cell.innerText=i;
			
			//range
			tmpDate=new Date(_calendarControl.year,_calendarControl.month,i);
			if(outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,tmpDate)){
				cell.className="cell_day_outrange";
			}
			
			datenum++;
		}
		for (var i=1;i<=endDate;i++){
			var cell = calendarData.cells[datenum+7];
			cell.monthAttribute="next";
			cell.className="cell_trailing";
			cell.innerText=i;
			
			//range
			tmpDate=new Date(_calendarControl.nextYear,_calendarControl.nextMonth,i);
			if(outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,tmpDate)){
				cell.className="cell_trailing_outrange";
			}
			
			datenum++;
		}
	}

	if (day) _calendarControl.day=day;
	//if(!outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,new Date(_calendarControl.year,_calendarControl.month,_calendarControl.day)))
	setCalendarActiveCell(calendarData.cells[_calendarControl.day+_calendarControl.startday-1+7]);
}

function setCalendarActiveCell(cell){

	function setActiveCell(cellIndex){
		var cell = calendarData.cells[_calendarControl.activeCellIndex+7];
		var tmpDate;
		with(_calendarControl){
		if (cell.monthAttribute=="cur"){
			cell.className="cell_day";
			//range
			tmpDate=new Date(year,month,activeCellIndex-startday+1);
			if(outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,tmpDate)){
				cell.className="cell_day_outrange";
			}
		}
		else if(cell.monthAttribute=="pre"){
			cell.className="cell_trailing";
			//range
			tmpDate=new Date(preYear,preMonth,getNumberOfDays(preMonth,preYear)-startday+activeCellIndex+1);
			if(outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,tmpDate)){
				cell.className="cell_trailing_outrange";
			}
		}else{
			cell.className="cell_trailing";
			//range
			tmpDate=new Date(nextYear,nextMonth,activeCellIndex-getNumberOfDays(month,year)-startday+1);
			if(outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,tmpDate)){
				cell.className="cell_trailing_outrange";
			}
		}
		}

		var cell = calendarData.cells[cellIndex+7];
		cell.className="cell_selected";

		_calendarControl.activeCellIndex=cellIndex;
	}
	
	function setEditorValue(year,month,day){
		with(_calendarControl){
			if(editor){
				var _date=convertStr2Date_new(editor.value);
				if(!isNaN(_date) && _date.getFullYear()==year && _date.getMonth()==month && _date.getDate()==day)
					return;
				
				editor.value=year+"-"+(month+1)+"-"+day;
			}
		}
	}

	if (cell.tagName.toLowerCase()!="td") return false;
	var _activeCellIndex=cell.parentElement.rowIndex*7+cell.cellIndex-7;

	with(_calendarControl){
		if (activeCellIndex==_activeCellIndex) return true;

		var monthAttribute=cell.monthAttribute;
		switch (monthAttribute){
			case "pre":{
				changeCalendarDate(preYear,preMonth,getNumberOfDays(preMonth,preYear)-startday+_activeCellIndex+1);
				setActiveCell(startday+day-1);
				setEditorValue(preYear,preMonth,getNumberOfDays(preMonth,preYear)-startday+_activeCellIndex+1);
				break
			}
			case "cur":{
				changeCalendarDate(year,month,_activeCellIndex-startday+1);
				setActiveCell(_activeCellIndex);
				setEditorValue(year,month,_activeCellIndex-startday+1);
				break
			}
			case "next":{
				changeCalendarDate(nextYear,nextMonth,_activeCellIndex-getNumberOfDays(month,year)-startday+1);
				setActiveCell(startday+day-1);
				setEditorValue(nextYear,nextMonth,_activeCellIndex-getNumberOfDays(month,year)-startday+1);
				break
			}
		}
	}
	return true;
}
/*modified by wangpeng 20091119 日历改造,增加可选择时间范围 BMS-2269 end*/
function _calendar_cell_onclick(cell){
	setCalendarActiveCell(cell);
	/*added by wangpeng 20091120 日历改造，增加可选择时间范围 BMS-2269  begin*/
	var validateResult=validateCalendarDateValue();
	if(validateResult[0]==false){
		return;
	}
	/*added by wangpeng 20091120 日历改造，增加可选择时间范围 BMS-2269  end*/
	dropDownSelected();
}

function _calendar_onkeydown(){
	switch(event.keyCode){
		case 33:{//PgUp
			if (event.ctrlKey){
				changeCalendarDate(_calendarControl.year-1,_calendarControl.month)
			}else{
				changeCalendarDate(_calendarControl.preYear,_calendarControl.preMonth)
			}
			break
		}
		case 34:{//PgDn
			if (event.ctrlKey){
				 changeCalendarDate(_calendarControl.year+1,_calendarControl.month)
			}else{
				 changeCalendarDate(_calendarControl.nextYear,_calendarControl.nextMonth)
			}
			break
		}
		case 35:{//End
		    	var index=getNumberOfDays(_calendarControl.month,_calendarControl.year) +_calendarControl.startday-1
			setCalendarActiveCell(calendarData.cells[index+7+7])
			break
		}
		case 36:{//Home
			setCalendarActiveCell(calendarData.cells[_calendarControl.startday+7+7])
			break
		}
		case 37:{//<--
			var index=_calendarControl.activeCellIndex-1;
			if (index<0) index=0;
			setCalendarActiveCell(calendarData.cells[index+7])
			break
		}
		case 38:{//上箭头
			if (_calendarControl.activeCellIndex<14){
				var day=getNumberOfDays(_calendarControl.preMonth,_calendarControl.preYear)+_calendarControl.day-7;
				setCalendarDate(new Date(_calendarControl.preYear, _calendarControl.preMonth, day));
			}
			else{
				var index=_calendarControl.activeCellIndex-7;
				setCalendarActiveCell(calendarData.cells[index+7]);
			}
			break
		}
		case 39:{//-->
			var index=_calendarControl.activeCellIndex+1;
			if (index>=calendarData.cells.length-7) index=calendarData.cells.length-8;
			setCalendarActiveCell(calendarData.cells[index+7])
			break
		}
		case 40:{//下箭头
			/*modified by wangpeng 20091125 日历改造,向下键bug BMS-2269 begin*/
			if (_calendarControl.activeCellIndex>34){
			/*modified by wangpeng 20091125 日历改造,向下键bug BMS-2269 end*/
				var day=7-(getNumberOfDays(_calendarControl.month,_calendarControl.year)-_calendarControl.day);
				setCalendarDate(new Date(_calendarControl.nextYear, _calendarControl.nextMonth, day));
			}
			else{
				var index=_calendarControl.activeCellIndex+7;
				setCalendarActiveCell(calendarData.cells[index+7]);
			}
			break
		}
	}
}

function _calendar_today_onclick(){
	/*added by wangpeng 20091120 日历改造，可设置日期范围 BMS-2269  begin*/
	var validateResult=validateCalendarDateValue(_calendarControl.todayYear,_calendarControl.todayMonth,_calendarControl.todayDay);
	if(validateResult[0]==false){
		alert(validateResult[1]);
		return;
	}
	/*added by wangpeng 20091120 日历改造 BMS-2269  end*/
	changeCalendarDate(_calendarControl.todayYear,_calendarControl.todayMonth,_calendarControl.todayDay)
	var index=_calendarControl.todayDay+_calendarControl.startday-1;
	setCalendarActiveCell(calendarData.cells[index+7]);
	dropDownSelected();
}

function getNumberOfDays(month,year){
	var numDays=new Array(31,28,31,30,31,30,31,31,30,31,30,31)
	n=numDays[month]
	if (month==1 && (year%4==0 && year%100!=0 || year%400==0)) n++
	return n
}

/*added by wangpeng 20091119 日历改造 ，可设置日期范围 BMS-2269  begin*/
/*
 * 日期是否在日期区间之外
 * minDate>maxDate 代表区间为[-∞,maxDate]U[minDate,+∞]
 */
function outTimeRange(minDate,maxDate,date){
	var rangeLeft,rangeRight;
	if(minDate&&date<minDate){
		rangeLeft=true;
	}else{
		rangeLeft=false;
	}
	if(maxDate&&date>maxDate){
		rangeRight=true;
	}else{
		rangeRight=false;
	}
	
	if(minDate>maxDate) 
		return rangeLeft==rangeRight
	else
		return rangeLeft!=rangeRight;
}
function getTimeRangeDesc(minDate,maxDate){
	var result;
	var leftMsg;
	var rightMsg;
	if(!minDate&&!maxDate) {
		result="";
	}
	else if(minDate&&maxDate){
		if(minDate>maxDate){
			result=constDateTimeRangeMultiple.replace("%s1", maxDate.getFullYear()+"/"+(maxDate.getMonth()+1)+"/"+maxDate.getDate());
			result=result.replace("%s2",minDate.getFullYear()+"/"+(minDate.getMonth()+1)+"/"+minDate.getDate());
		}else if(minDate<maxDate){
			result=constDateTimeRangeSingle.replace("%s1",minDate.getFullYear()+"/"+(minDate.getMonth()+1)+"/"+minDate.getDate());
			result=result.replace("%s2",maxDate.getFullYear()+"/"+(maxDate.getMonth()+1)+"/"+maxDate.getDate());
		}else{
			result=constDateTimeRangeUnique.replace("%s", maxDate.getFullYear()+"/"+(maxDate.getMonth()+1)+"/"+maxDate.getDate());
		}
	}else if(minDate){
		result=constDateTimeRangeLeft.replace("%s",minDate.getFullYear()+"/"+(minDate.getMonth()+1)+"/"+minDate.getDate());
	}else{
		result=constDateTimeRangeRight.replace("%s",maxDate.getFullYear()+"/"+(maxDate.getMonth()+1)+"/"+maxDate.getDate());
	}
	
	return result;
}
/*
 * 验证日历的日期值
 * return Array Array[0]-boolean,是否通过验证 ；Array[1]-string,验证失败的信息
 */
function validateCalendarDateValue(year,month,day){
    var result=new Array();
	result[0]=true;
	if(!_calendarControl) return result;
	if(!year) year=_calendarControl.year;
	if(!month)month=_calendarControl.month;
	if(!day)  day=_calendarControl.day;
	var tmpDate=new Date(year,month,day);
	if(isNaN(tmpDate)){
		result[0]=false;
		result[1]=constErrTypeDate;
	}
	else if(outTimeRange(_calendarControl.minDate,_calendarControl.maxDate,tmpDate)){
		result[0]=false;
		result[1]=constDateTimeOutRange+" "+getTimeRangeDesc(_calendarControl.minDate,_calendarControl.maxDate);
	}
	return result;
}
 /*added by wangpeng 20091119 日历改造 BMS-2269  end*/
 
 /*added by wangpeng 20091123 BMS-2274 动态下拉框增加清空功能  begin*/
 function dropDownClear(){
	var record;
	switch (_dropdown_parentbox.dropDown.type){
		case "dynamic":{
			if (_dropdown_dataset) record=_dropdown_dataset.record;
			if(typeof(record) == "undefined"){
				break;
			}
			_dropdown_parentbox.editor.value="";
			break;
		}
		default:{
			break;
		}
	}
	
	if(record){
		_dropdown_parentwindow.processDropDownSelectedClear(_dropdown_parentbox.editor, record);
	}
}
 /*added by wangpeng 20091123 BMS-2274 动态下拉框增加清空功能  end*/
