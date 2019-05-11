
function initUpLoadify(dataset, s, u) {

	$("#uploadify")
			.uploadify(
					{
						'swf' : s,
						'uploader' : u,
						'method' : 'GET',
						'formData' : {
							'someKey' : 'someValue',
							'someOtherKey' : 1
						},
						'simUploadLimit' : 1,
						'sizeLimit' : 19871202,
						'buttonText' : '上传文件',
						'queueSizeLimit' : 500,
						'onSelect' : function(file) {
							var id = file.name.split('.')[0]+file.name.split('.')[1];
							cancelUploadify(file.name, dataset, id);
							$('#' + id + 'progress').css("display", "inline");
						},
						'onUploadComplete' : function(file) {
							var id = file.name.split('.')[0]+file.name.split('.')[1];
							// $('#'+id+'answer').html('上传成功');
							$('#' + id + 'ishave').html('已存在');
							$('#' + id + 'ishavehave').val('true');
							// $('#'+id+'upstatus').html('结束上传');
						},
						'onUploadError' : function(file, errorCode, errorMsg,errorString) {
							   var id = file.name.split('.')[0]+file.name.split('.')[1];
							   if($('#'+id+'progress').css("width")=='308px'){
								  return;
							   }
							   $('#'+id+'progress').css("display","none");
						},
						'onUploadStart' : function(file) {
							var id = file.name.split('.')[0]+file.name.split('.')[1];
							// $('#'+id+'upstatus').html('开始上传');
						},
						'onUploadProgress' : function(file, bytesUploaded,
								bytesTotal, totalBytesUploaded, totalBytesTotal) {
							var id = file.name.split('.')[0]+file.name.split('.')[1];
							var widthp = (bytesUploaded / bytesTotal) * 100;
							$('#' + id + 'progress').find(
									".uploadify-progress-bar").css("width",
									widthp + "%");
							// $('#'+id+'progress').find("span").text(widthp +
							// "%");
							$('#' + id + 'progressspan').html(
									Math.floor(widthp) + "%");

						},
						'onClearQueue' : function(queueItemCount) {

						}
					});
}

// 有待优化
function cancelUploadify(name, dataset, id) {
	var record = dataset.getFirstRecord();
	var upFileName = new Array();
	while (record) {
		upFileName.push(record.getValue('fileName'));
		record = record.getNextRecord();
	}
	var flag = true;
	for ( var i = 0; i < upFileName.length; i++) {
		if (name == upFileName[i]) {
			flag = false;
			break;
		}
	}
	if (flag) {
		$("#uploadify").uploadify('cancel', '*');
		alert('文件名为:"' + name + '" 的文件，不在允许上传的表名中，请选择表中存在的文件名来上传！');
		return;
	}
	var isUp = $("#isUp")[0].checked;
	var ishave = $('#' + id + 'ishavehave').val();
	if (!isUp) {
		if (ishave == "true") {
			$("#uploadify").uploadify('cancel', '*');
			alert('文件名为:"' + name + '" 的文件已存在，请勿重复上传！');
		}
	}
}