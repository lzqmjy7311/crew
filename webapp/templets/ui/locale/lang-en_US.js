if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = 'Page';
	$.fn.pagination.defaults.afterPageText = 'of {pages}';
	$.fn.pagination.defaults.displayMsg = 'Displaying {from} to {to} of {total} items';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = 'Processing, please wait ...';
    $.fn.datagrid.defaults.emptyMsg = 'No data!';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = 'Ok';
	$.messager.defaults.yes = 'Yes';
	$.messager.defaults.no = 'No';
	$.messager.defaults.cancel = 'Cancel';
	$.messager.defaults.info = 'Cancel';
	$.messager.defaults.error = 'Error';
	$.messager.defaults.info = 'Information';
	$.messager.defaults.warn = 'Warning';
	$.messager.defaults.correct = 'Success';
	$.messager.defaults.confirm = 'Confirmation?';
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = 'This field is required.';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = 'This field is required.';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = 'This field is required.';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = 'This field is required.';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = 'This field is required.';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['S','M','T','W','T','F','S'];
	$.fn.calendar.defaults.months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = 'Today';
	$.fn.datebox.defaults.closeText = 'Close';
	$.fn.datebox.defaults.okText = 'Ok';
	$.fn.datebox.defaults.missingMessage = 'This field is required.';
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}

if ($.fn.tabs){
    $.fn.tabs.defaults.m_close="close";
    $.fn.tabs.defaults.m_closeAll="closeAll";
    $.fn.tabs.defaults.m_closeOther="closeOther";
    $.fn.tabs.defaults.m_closeRight="closeRight";
    $.fn.tabs.defaults.m_closeLeft="closeLeft";
    $.fn.tabs.defaults.m_refresh="refresh";
    $.fn.tabs.defaults.m_favorite="favorite";
}
if ($.fn.combo){
    $.fn.combo.defaults.placeholder="please select...";
    $.fn.combo.defaults.missingMessage = 'This field is required.';
}

/* Constants */
var constErrType = "Error Type";
var constErrDescription = "Error Description";
var constErrUnknown = "Unknown error!";
var constErrUnsupportBrowser = "Because you are not using Microsoft Internet Explorer 5.0 or later browser, you will have access to this page may not be able to correct the result will be displayed! / n Please upgrade your browser.";
var constErrDownLoadFailed = "Download data failed!";
var constErrUpdateFailed = "Save data failed!";
var constErrAddDataField = "You can not have completed the initialization of the recordset to add the field!";
var constErrEmptyFieldName = "Field names can not be empty!";
var constErrCantFindField = "Can not find the specified field [%s]!";
var constErrCantFindMasterField = "Main table field [%s] does not exist!";
var constErrCantFindDetailField = "Field from the table [%s] does not exist!";
var constErrLoadPageOnDetailDataset = "Master-slave has been established to bind the recordset from the table is unable to perform batch downloads!";
var constErrLoadPageAfterSort = "Client has been set to sort the records can not be implemented in batches Download!";
var constErrFieldValueRequired = "Field [%s] can not empty the contents!";
var constErrKeyFieldRequired = "Primary key field is not defined!";
var constErrUpdateFieldRequired = "Field there is no update!";
var constErrTypeInt = "You enter a value [%s] is not a valid integer!";
var constErrTypeNumber = "You enter a value [%s] is not a valid digital!";
var constErrTypeDate = "You enter a value [%s] is not a valid date-type value!";
var constErrTypeDateTime = "You enter a value [%s] is not a valid date + time-based value!";
var constErrTypeTime = "You enter a value [%s] is not a valid time-value!";
var constErrOutOfDropDownList = "You entered an invalid value!";
var constErrInputMask = "You have entered the value of [%s] not in conformity with the rules of the checksum field!";
var constErrNoCurrentRecord = "Because there is no current record recordset and the field values can not be modified!";
var constErrNoMasterRecord = "There is no master record as a result of the current record set can not add details!";
var constFieldSizeError = "Record set size error";
var constFieldSizeErrorString = "Set the type of error records";

var constDatasetConfirmCancel = "Are you sure you want to withdraw the amendment on the current record it?";
var constDatasetConfirmDelete = "Are you sure you want to delete the current record?";
var constDatasetMoveFirst = "Move to first record";
var constDatasetPrevPage = "Forward page";
var constDatasetMovePrev = "A move to the previous record";
var constDatasetMoveNext = "A move to the next record";
var constDatasetNextPage ="Back flip";
var constDatasetMoveLast = "Move to the last record";
var constDatasetInsertRecord = "Insert a new record";
var constDatasetAppendRecord = "Add a new record";
var constDatasetDeleteRecord = "Delete the current record";
var constDatasetEditRecord = "Modify the current record";
var constDatasetCancelRecord = "The lifting of the current record changes";
var constDatasetUpdateRecord = "Confirmed that changes the current record";

var constBtnInsertRecord = "Insert";
var constBtnAppendRecord = "Add";
var constBtnDeleteRecord = "Remove";
var constBtnEditRecord = "Modified";
var constBtnCancelRecord = "Revocation";
var constBtnUpdateRecord = "Confirmed";

var constMonday = "Mon";
var constTuesday = "Tue";
var constWednesday = "Wed";
var constThursday = "Thu";
var constFriday = "Fri";
var constSaturday = "Sat";
var constSunday = "Sun";

var constLastYear = "The previous year";
var constNextYear = "Next year";
var constLastMonth = "Last month";
var constNextMonth = "Next month";
var constToday = "Today";

var constDownLoadingData = "Downloading data ...";
var constCancelSort = "Not sort";

var constNoFoundRecode = "There is no record of query!";
var constCheckModify="Please revise the content and then submit!";

var constDatasetConfirmDeleteRecordSubmit="";
var constDatasetConfirmSubmitModifiedRecordsSameTime="";

var constGroupBoxExpandAlt="expand";
var constGroupBoxCollapseAlt="collapse";

var constDateTimeRangeSingle="";
var constDateTimeRangeMultiple="";
var constDateTimeRangeUnique="";
var constDateTimeRangeLeft="";
var constDateTimeRangeRight="";
var constDateTimeOutRange="";

var constCSVExport="download csv file";
var constXLSExport="download Excel file";
var constPDFExport="download PDF file";

var constAlertTipFailed = "Failed";
var constAlertTipInfo = "Info";
var constAlertMsgSysErr = "System Error!";

var constBatchDownloadTitle = "message";
var constBatchDownloadSuccess = "Success.";
var constBatchDownloadFailed = "Failed:";
var constLength="You enter the value's length is %a ,but the valid length is %b ,please enter a new value again! ";
var constRadio="The field [%a]'s value is must required lease enter a value ,then submit!";
var constScaleErr="The field is set precision attribute must be less than the field length attribute, please modify the XML configuration!";
var constIntLength="The length of the input value is not more than a%.";
var constErrFieldValueValide="The field[%s] 's content is unvalidate!";
var constExpInfo="The start page value is greater than the value of the end of the page, please re-enter!";
var	constErrValide="There are not legitimate page fields, check before you submit!";

var constTraversalRecords="please select one record!";