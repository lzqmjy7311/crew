if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '\u7b2c';
	$.fn.pagination.defaults.afterPageText = '\u5171{pages}\u9875';
	$.fn.pagination.defaults.displayMsg = '\u663e\u793a{from}\u5230{to},\u5171{total}\u8bb0\u5f55';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '\u6b63\u5728\u5904\u7406\uff0c\u8bf7\u7a0d\u5f85\u3002\u3002\u3002';
	$.fn.datagrid.defaults.emptyMsg = '\u65e0\u53ef\u7528\u6570\u636e!';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '\u786e\u5b9a';
	$.messager.defaults.yes = '\u662f';
	$.messager.defaults.no = '\u5426';
	$.messager.defaults.cancel = '\u53d6\u6d88';
	$.messager.defaults.error = '\u64cd\u4f5c\u5931\u8d25';
	$.messager.defaults.info = '\u6d88\u606f\u63d0\u793a';
	$.messager.defaults.warn = '\u8b66\u544a\u63d0\u793a';
	$.messager.defaults.correct = '\u64cd\u4f5c\u6210\u529f';
	$.messager.defaults.confirm = '\u786e\u8ba4?';
	
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = '\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['\u65e5','\u4e00','\u4e8c','\u4e09','\u56db','\u4e94','\u516d'];
	$.fn.calendar.defaults.months = ['\u4e00\u6708','\u4e8c\u6708','\u4e09\u6708','\u56db\u6708','\u4e94\u6708','\u516d\u6708','\u4e03\u6708','\u516b\u6708','\u4e5d\u6708','\u5341\u6708','\u5341\u4e00\u6708','\u5341\u4e8c\u6708'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '\u4eca\u5929';
	$.fn.datebox.defaults.closeText = '\u5173\u95ed';
	$.fn.datebox.defaults.okText = '\u786e\u5b9a';
	$.fn.datebox.defaults.missingMessage = '\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879';
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
	$.fn.tabs.defaults.m_close="\u5173\u95ed";
	$.fn.tabs.defaults.m_closeAll="\u5173\u95ed\u6240\u6709";
	$.fn.tabs.defaults.m_closeOther="\u5173\u95ed\u5176\u5b83";
	$.fn.tabs.defaults.m_closeRight="\u5173\u95ed\u53f3\u4fa7";
	$.fn.tabs.defaults.m_closeLeft="\u5173\u95ed\u5de6\u4fa7";
	$.fn.tabs.defaults.m_refresh="\u5237\u65b0";
    $.fn.tabs.defaults.m_favorite="\u6536\u85cf";
}
if ($.fn.combo){
	$.fn.combo.defaults.placeholder="\u8bf7\u9009\u62e9...";
	$.fn.combo.defaults.missingMessage = '\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879';
}

/* Constants */
var constErrType = "\u9519\u8bef\u7c7b\u578b";
var constErrDescription = "\u9519\u8bef\u63cf\u8ff0";
var constErrUnknown = "\u672a\u77e5\u9519\u8bef\uff01";
var constErrUnsupportBrowser = "\u7531\u4e8e\u60a8\u4f7f\u7528\u7684\u4e0d\u662f Microsoft Internet Explorer 5.0 \u6216\u66f4\u9ad8\u7248\u672c\u7684\u6d4f\u89c8\u5668\uff0c\u60a8\u5c06\u6709\u53ef\u80fd\u65e0\u6cd5\u83b7\u5f97\u672c\u9875\u9762\u6b63\u786e\u7684\u663e\u793a\u7ed3\u679c\uff01/n\u8bf7\u5347\u7ea7\u60a8\u7684\u6d4f\u89c8\u5668\u3002";
var constErrDownLoadFailed = "\u4e0b\u8f7d\u6570\u636e\u5931\u8d25\uff01";
var constErrUpdateFailed = "\u4fdd\u5b58\u6570\u636e\u5931\u8d25\uff01";
var constErrAddDataField = "\u60a8\u4e0d\u80fd\u5bf9\u5df2\u5b8c\u6210\u521d\u59cb\u5316\u7684\u8bb0\u5f55\u96c6\u6dfb\u52a0\u5b57\u6bb5\uff01";
var constErrEmptyFieldName = "\u5b57\u6bb5\u540d\u4e0d\u80fd\u4e3a\u7a7a\uff01";
var constErrCantFindField = "\u627e\u4e0d\u5230\u6307\u5b9a\u7684\u5b57\u6bb5[%s]\uff01";
var constErrCantFindMasterField = "\u4e3b\u8868\u5b57\u6bb5[%s]\u4e0d\u5b58\u5728\uff01";
var constErrCantFindDetailField = "\u4ece\u8868\u5b57\u6bb5[%s]\u4e0d\u5b58\u5728\uff01";
var constErrLoadPageOnDetailDataset = "\u5df2\u5efa\u7acb\u4e3b\u4ece\u7ed1\u5b9a\u7684\u4ece\u8868\u8bb0\u5f55\u96c6\u4e0d\u80fd\u6267\u884c\u5206\u6279\u4e0b\u8f7d\uff01";
var constErrLoadPageAfterSort = "\u5df2\u8fdb\u884c\u5ba2\u6237\u7aef\u6392\u5e8f\u7684\u8bb0\u5f55\u96c6\u4e0d\u80fd\u6267\u884c\u5206\u6279\u4e0b\u8f7d\uff01";
var constErrFieldValueRequired = "\u5b57\u6bb5[ %s ]\u7684\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a\uff01";
var constErrKeyFieldRequired = "\u6ca1\u6709\u5b9a\u4e49\u4e3b\u952e\u5b57\u6bb5\uff01";
var constErrUpdateFieldRequired = "\u6ca1\u6709\u53ef\u66f4\u65b0\u7684\u5b57\u6bb5\uff01";
var constErrTypeInt = "\u60a8\u8f93\u5165\u7684\u503c[%s]\u4e0d\u662f\u4e00\u4e2a\u6709\u6548\u7684\u6574\u6570\uff01";
var constErrTypeNumber = "\u60a8\u8f93\u5165\u7684\u503c[%s]\u4e0d\u662f\u4e00\u4e2a\u6709\u6548\u7684\u6570\u5b57\uff01";
var constErrTypeDate = "\u60a8\u8f93\u5165\u7684\u503c[%s]\u4e0d\u662f\u4e00\u4e2a\u6709\u6548\u7684\u65e5\u671f\u578b\u503c\uff01";
var constErrTypeDateTime = "\u60a8\u8f93\u5165\u7684\u503c[%s]\u4e0d\u662f\u4e00\u4e2a\u6709\u6548\u7684\u65e5\u671f+\u65f6\u95f4\u578b\u503c\uff01";
var constErrTypeTime = "\u60a8\u8f93\u5165\u7684\u503c[%s]\u4e0d\u662f\u4e00\u4e2a\u6709\u6548\u7684\u65f6\u95f4\u578b\u503c\uff01";
var constErrOutOfDropDownList = "\u60a8\u8f93\u5165\u4e86\u65e0\u6548\u7684\u503c\uff01";
var constErrInputMask = "\u60a8\u8f93\u5165\u4e86\u7684\u503c[%s]\u4e0d\u7b26\u5408\u8be5\u5b57\u6bb5\u7684\u6821\u9a8c\u89c4\u5219\uff01";
var constErrNoCurrentRecord = "\u7531\u4e8e\u8bb0\u5f55\u96c6\u6ca1\u6709\u5f53\u524d\u8bb0\u5f55\u800c\u65e0\u6cd5\u4fee\u6539\u5b57\u6bb5\u503c\uff01";
var constErrNoMasterRecord = "\u7531\u4e8e\u4e3b\u8bb0\u5f55\u96c6\u6ca1\u6709\u5f53\u524d\u8bb0\u5f55\u800c\u65e0\u6cd5\u6dfb\u52a0\u660e\u7ec6\uff01";
var constFieldSizeError = "\u8bb0\u5f55\u96c6\u5927\u5c0f\u9519\u8bef";
var constFieldSizeErrorString = "\u8bb0\u5f55\u96c6\u7c7b\u578b\u9519\u8bef";

var constDatasetConfirmCancel = "\u60a8\u786e\u5b9a\u8981\u64a4\u6d88\u5bf9\u5f53\u524d\u8bb0\u5f55\u7684\u4fee\u6539\u5417\uff1f";
var constDatasetConfirmDelete = "\u60a8\u786e\u5b9a\u8981\u5220\u9664\u5f53\u524d\u8bb0\u5f55\u5417\uff1f";
var constDatasetMoveFirst = "\u79fb\u52a8\u5230\u7b2c\u4e00\u6761\u8bb0\u5f55";
var constDatasetPrevPage = "\u5411\u524d\u7ffb\u9875";
var constDatasetMovePrev = "\u79fb\u52a8\u5230\u4e0a\u4e00\u6761\u8bb0\u5f55";
var constDatasetMoveNext = "\u79fb\u52a8\u5230\u4e0b\u4e00\u6761\u8bb0\u5f55";
var constDatasetNextPage ="\u5411\u540e\u7ffb\u9875";
var constDatasetMoveLast = "\u79fb\u52a8\u5230\u6700\u540e\u4e00\u6761\u8bb0\u5f55";
var constDatasetInsertRecord = "\u63d2\u5165\u4e00\u6761\u65b0\u8bb0\u5f55";
var constDatasetAppendRecord = "\u6dfb\u52a0\u4e00\u6761\u65b0\u8bb0\u5f55";
var constDatasetDeleteRecord = "\u5220\u9664\u5f53\u524d\u8bb0\u5f55";
var constDatasetEditRecord = "\u4fee\u6539\u5f53\u524d\u8bb0\u5f55";
var constDatasetCancelRecord = "\u64a4\u9500\u5bf9\u5f53\u524d\u8bb0\u5f55\u7684\u4fee\u6539";
var constDatasetUpdateRecord = "\u786e\u8ba4\u5bf9\u5f53\u524d\u8bb0\u5f55\u7684\u4fee\u6539";

var constBtnInsertRecord = "\u63d2\u5165";
var constBtnAppendRecord = "\u6dfb\u52a0";
var constBtnDeleteRecord = "\u5220\u9664";
var constBtnEditRecord = "\u4fee\u6539";
var constBtnCancelRecord = "\u64a4\u9500";
var constBtnUpdateRecord = "\u786e\u8ba4";

var constMonday = "\u4e00";
var constTuesday = "\u4e8c";
var constWednesday = "\u4e09";
var constThursday = "\u56db";
var constFriday = "\u4e94";
var constSaturday = "\u516d";
var constSunday = "\u65e5";

var constLastYear = "\u4e0a\u4e00\u5e74";
var constNextYear = "\u4e0b\u4e00\u5e74";
var constLastMonth = "\u4e0a\u4e2a\u6708";
var constNextMonth = "\u4e0b\u4e2a\u6708";
var constToday = "\u4eca\u5929";

var constDownLoadingData = "\u6b63\u5728\u4e0b\u8f7d\u6570\u636e...";
var constCancelSort = "\u4e0d\u6392\u5e8f";

var constNoFoundRecode = "\u6ca1\u6709\u7b26\u5408\u67e5\u8be2\u6761\u4ef6\u7684\u8bb0\u5f55!";
var constCheckModify="\u8bf7\u5bf9\u5185\u5bb9\u8fdb\u884c\u4fee\u6539\u540e\u518d\u8fdb\u884c\u63d0\u4ea4!";

var constDatasetConfirmDeleteRecordSubmit="\u60a8\u786e\u8ba4\u8981\u5220\u9664\u5f53\u524d\u8bb0\u5f55\u5e76\u63d0\u4ea4\u5417\uff1f";
var constDatasetConfirmSubmitModifiedRecordsSameTime="\u5176\u5b83\u5df2\u4fee\u6539\u7684\u8bb0\u5f55\u5c06\u88ab\u4e00\u8d77\u63d0\u4ea4\uff0c\u60a8\u786e\u8ba4\u5220\u9664\u5f53\u524d\u8bb0\u5f55\u5e76\u63d0\u4ea4\u5417\uff1f";

var constGroupBoxExpandAlt="\u5c55\u5f00";
var constGroupBoxCollapseAlt="\u6298\u53e0";

var constDateTimeRangeSingle="\u65e5\u671f\u53ea\u80fd\u5728[%s1]\u548c[%s2]\u4e4b\u95f4";
var constDateTimeRangeMultiple="\u65e5\u671f\u53ea\u80fd\u5c0f\u4e8e\u7b49\u4e8e[%s1]\u6216\u8005\u5927\u4e8e\u7b49\u4e8e[%s2]";
var constDateTimeRangeUnique="\u65e5\u671f\u53ea\u80fd\u7b49\u4e8e[%s]";
var constDateTimeRangeLeft="\u65e5\u671f\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[%s]";
var constDateTimeRangeRight="\u65e5\u671f\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[%s]";
var constDateTimeOutRange="\u65e5\u671f\u4e0d\u5728\u5141\u8bb8\u7684\u8303\u56f4\u5185";

var constCSVExport="\u4e0b\u8f7dCSV\u6587\u4ef6";
var constXLSExport="\u4e0b\u8f7dExcel\u6587\u4ef6";
var constPDFExport="\u4e0b\u8f7dPDF\u6587\u4ef6";

var constAlertTipFailed = "\u64cd\u4f5c\u5931\u8d25";
var constAlertMsgSysErr = "\u5e73\u53f0\u5f02\u5e38";
var constAlertTipInfo = "\u64cd\u4f5c\u63d0\u793a";

var constBatchDownloadTitle = "\u6d88\u606f\u63d0\u793a";
var constBatchDownloadSuccess = "\u6279\u91cf\u4e0b\u8f7d\u5df2\u6210\u529f\u6267\u884c\uff01";
var constBatchDownloadFailed = "\u6279\u91cf\u4e0b\u8f7d\u6267\u884c\u5931\u8d25:";
var constLength="\u5f53\u524d\u8f93\u5165\u7684\u5b57\u6bb5\u957f\u5ea6\u4e3a%a,\u8d85\u51fa\u89c4\u5b9a\u7684%b\u4e2a\u957f\u5ea6\u8981\u6c42\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165";
var constRadio="\u5b57\u6bb5[%a]\u4e3a\u5fc5\u9009\u9879\uff0c\u8bf7\u9009\u503c\u540e\u63d0\u4ea4\uff01";
var constScaleErr="\u8be5\u5b57\u6bb5\u8bbe\u7f6e\u7684\u7cbe\u5ea6scale\u5c5e\u6027\u5fc5\u987b\u5c0f\u4e8e\u5b57\u6bb5\u7684\u957f\u5ea6\u5c5e\u6027\uff0c\u8bf7\u4fee\u6539XML\u4e2d\u7684\u914d\u7f6e\u3002.";
var constIntLength="\u8F93\u5165\u503C\u7684\u957F\u5EA6\u4E0D\u8D85\u8FC7a%\u4F4D\u3002";
var constErrFieldValueValide="\u5B57\u6BB5[ %s ]\u7684\u5185\u5BB9\u6CA1\u6709\u901A\u8FC7\u9A8C\u8BC1\uFF01";
var constExpInfo="\u8D77\u59CB\u9875\u7684\u503C\u5FC5\u987B\u5C0F\u4E8E\u7ED3\u675F\u9875\u7684\u503C\uFF0C\u8BF7\u91CD\u65B0\u8F93\u5165\uFF01";
var constErrValide="\u9875\u9762\u4E2D\u5B58\u5728\u4E0D\u5408\u6CD5\u7684\u5B57\u6BB5\uFF0C\u8BF7\u68C0\u67E5\u540E\u518D\u63D0\u4EA4\uFF01";

var constTraversalRecords="\u8BF7\u9009\u62E9\u4E00\u7B14\u7EAA\u5F55";

var constPaginationErr="\u8BF7\u8F93\u51651\u81F3%page%\u4E4B\u95F4\u7684\u6570\u3002";