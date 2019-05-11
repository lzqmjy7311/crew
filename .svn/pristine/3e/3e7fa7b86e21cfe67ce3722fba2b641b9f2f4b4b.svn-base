if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '第';
	$.fn.pagination.defaults.afterPageText = '共{pages}頁';
	$.fn.pagination.defaults.displayMsg = '顯示{from}到{to},共{total}記錄';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '正在處理，請稍待。。。';
	$.fn.datagrid.defaults.emptyMsg = '無可用數據!';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '確定';
	$.messager.defaults.yes = '是';
	$.messager.defaults.no = '否';
	$.messager.defaults.error = '操作失敗';
	$.messager.defaults.info = '消息提示';
	$.messager.defaults.warn = '警告提示';
	$.messager.defaults.correct = '操作成功';
	$.messager.defaults.confirm = '確認?';
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = '該輸入項為必輸項';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '該輸入項為必輸項';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '該輸入項為必輸項';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '該輸入項為必輸項';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '該輸入項為必輸項';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['日','一','二','三','四','五','六'];
	$.fn.calendar.defaults.months = ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '今天';
	$.fn.datebox.defaults.closeText = '關閉';
	$.fn.datebox.defaults.okText = '確定';
	$.fn.datebox.defaults.missingMessage = '該輸入項為必輸項';
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
    $.fn.tabs.defaults.m_close="關閉";
    $.fn.tabs.defaults.m_closeAll="關閉所有";
    $.fn.tabs.defaults.m_closeOther="關閉其它";
    $.fn.tabs.defaults.m_closeRight="關閉右側";
    $.fn.tabs.defaults.m_closeLeft="關閉左側";
    $.fn.tabs.defaults.m_refresh="刷新";
    $.fn.tabs.defaults.m_favorite="收藏";
}
if ($.fn.combo){
    $.fn.combo.defaults.placeholder="請選擇...";
    $.fn.combo.defaults.missingMessage = '該輸入項為必輸項';
}

/* Constants */
var constErrType = "錯誤類型";
var constErrDescription = "錯誤描述";
var constErrUnknown = "未知錯誤！";
var constErrUnsupportBrowser = "由于您使用的不是 Microsoft Internet Explorer 5.0 或更高版本的浏覽器，您將有可能無法獲得本頁面正確的顯示結果！/n請升級您的浏覽器。";
var constErrDownLoadFailed = "下載數據失敗！";
var constErrUpdateFailed = "保存數據失敗！";
var constErrAddDataField = "您不能對已完成初始化的記錄集添加字段！";
var constErrEmptyFieldName = "字段名不能爲空！";
var constErrCantFindField = "找不到指定的字段[%s]！";
var constErrCantFindMasterField = "主表字段[%s]不存在！";
var constErrCantFindDetailField = "從表字段[%s]不存在！";
var constErrLoadPageOnDetailDataset = "已建立主從綁定的從表記錄集不能執行分批下載！";
var constErrLoadPageAfterSort = "已進行客戶端排序的記錄集不能執行分批下載！";
var constErrFieldValueRequired = "字段[ %s ]的內容不能爲空！";
var constErrKeyFieldRequired = "沒有定義主鍵字段！";
var constErrUpdateFieldRequired = "沒有可更新的字段！";
var constErrTypeInt = "您輸入的值[%s]不是一個有效的整數！";
var constErrTypeNumber = "您輸入的值[%s]不是一個有效的數字！";
var constErrTypeDate = "您輸入的值[%s]不是一個有效的日期型值！";
var constErrTypeDateTime = "您輸入的值[%s]不是一個有效的日期+時間型值！";
var constErrTypeTime = "您輸入的值[%s]不是一個有效的時間型值！";
var constErrOutOfDropDownList = "您輸入了無效的值！";
var constErrInputMask = "您輸入了的值[%s]不符合該字段的校驗規則！";
var constErrNoCurrentRecord = "由于記錄集沒有當前記錄而無法修改字段值！";
var constErrNoMasterRecord = "由于主記錄集沒有當前記錄而無法添加明細！";
var constFieldSizeError = "記錄集大小錯誤";
var constFieldSizeErrorString = "記錄集類型錯誤";

var constDatasetConfirmCancel = "您確定要撤消對當前記錄的修改嗎？";
var constDatasetConfirmDelete = "您確定要刪除當前記錄嗎？";
var constDatasetMoveFirst = "移動到第一條記錄";
var constDatasetPrevPage = "向前翻頁";
var constDatasetMovePrev = "移動到上一條記錄";
var constDatasetMoveNext = "移動到下一條記錄";
var constDatasetNextPage ="向後翻頁";
var constDatasetMoveLast = "移動到最後一條記錄";
var constDatasetInsertRecord = "插入一條新記錄";
var constDatasetAppendRecord = "添加一條新記錄";
var constDatasetDeleteRecord = "刪除當前記錄";
var constDatasetEditRecord = "修改當前記錄";
var constDatasetCancelRecord = "撤銷對當前記錄的修改";
var constDatasetUpdateRecord = "確認對當前記錄的修改";

var constBtnInsertRecord = "插入";
var constBtnAppendRecord = "添加";
var constBtnDeleteRecord = "刪除";
var constBtnEditRecord = "修改";
var constBtnCancelRecord = "撤銷";
var constBtnUpdateRecord = "確認";

var constMonday = "一";
var constTuesday = "二";
var constWednesday = "三";
var constThursday = "四";
var constFriday = "五";
var constSaturday = "六";
var constSunday = "日";

var constLastYear = "上一年";
var constNextYear = "下一年";
var constLastMonth = "上個月";
var constNextMonth = "下個月";
var constToday = "今天";

var constDownLoadingData = "正在下載數據...";
var constCancelSort = "不排序";

var constNoFoundRecode = "沒有符合查詢條件的記錄!";
var constCheckModify="請對內容進行修改後再進行提交!";

var constDatasetConfirmDeleteRecordSubmit="您確認要刪除當前記錄並提交嗎？";
var constDatasetConfirmSubmitModifiedRecordsSameTime="其它已修改的記錄將被一起提交，您確認刪除當前記錄並提交嗎？";

var constGroupBoxExpandAlt="展開";
var constGroupBoxCollapseAlt="折疊";

var constDateTimeRangeSingle="日期只能在[%s1]和[%s2]之間";
var constDateTimeRangeMultiple="日期只能小于等于[%s1]或者大于等于[%s2]";
var constDateTimeRangeUnique="日期只能等于[%s]";
var constDateTimeRangeLeft="日期必須大于等于[%s]";
var constDateTimeRangeRight="日期必須小于等于[%s]";
var constDateTimeOutRange="日期不在允許的範圍內";

var constCSVExport="下載CSV文件";
var constXLSExport="下載Excel文件";
var constPDFExport="下載PDF文件";

var constAlertTipFailed = "操作失敗";
var constAlertMsgSysErr = "平台異常";
var constAlertTipInfo = "操作提示";

var constBatchDownloadTitle = "消息提示";
var constBatchDownloadSuccess = "批量下載成功.";
var constBatchDownloadFailed = "批量下載失敗:";
var constLength="當前輸入的字段長度為%a,超出規定的%b個長度要求，請重新輸入";
var constRadio="字段[%a]為必選項，請選值后提交！";
var constScaleErr="該字段設置的精度scale屬性必須小於該字段的長度屬性，請修改XML中的配置。";
var constIntLength="輸入值的長度不超過a%位。";
var constErrFieldValueValide = "字段[ %s ]的內容验证没有通过！";
var constExpInfo="起始頁的值必須小於結束頁的值，請重新輸入！";
var constErrValide="頁面中存在不合法的字段，請檢查后再提交！";
var constTraversalRecords="请选中一笔记录";
var constWinTitleNameStr="";