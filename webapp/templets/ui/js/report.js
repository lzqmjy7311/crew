/**项目通用js***/
var getwinsize = function(par) {
	return [par.document.body.clientWidth, par.document.body.clientHeight];
};

var jscontextpath = {
	contextpath:null,
	setContextPath:function(path){
		this.contextpath = path;
	}
};

function showWin(tit,uri,conwin,methodnm,par,wh,hh,winpos){
	if(par == null ||par == "undefined" || par == undefined){
		par = window.parent;
	}
	var wid_heig=getwinsize(par);
	if(wh == null || (wid_heig[0]>0 && wid_heig[0]<=wh)){
		wh =wid_heig[0]-10;
	}
	if(hh==null||(wid_heig[1]>0 && wid_heig[1]<=hh)){
		hh= wid_heig[1]-10;
	}
	if(winpos==null || winpos == "undefined" || winpos == undefined){
		winpos = [1,1];
	}
	par.ymPrompt.win({width:wh,height:hh,title:tit,maxBtn:true,minBtn:true,iframe:{id:'myIf',name:'myIf',src:uri},handler:function(tp){winHandler(tp,conwin,methodnm)},fixPosition:true,useSlide:false,winPos:winpos, maskAlphaColor: '#fff', maskAlpha: 0.8});
}
function showPickup(tit,uri,wh,hh){
	var wid_heig=getwinsize(window);
	if(wh == null || (wid_heig[0]>0 && wid_heig[0]<=wh)){
		wh =wid_heig[0]-50;
	}
	if(hh==null||(wid_heig[1]>0 && wid_heig[1]<=hh)){
		hh= wid_heig[1]-50;
	}

	ymPrompt.win({width:wh,height:hh,title:tit,maxBtn:false,minBtn:false,iframe:{id:'pickup',name:'pickup',src:uri},useSlide:false,fixPosition:true,maskAlphaColor: '#fff', maskAlpha: 0.5});
}


function showWin(tit,uri,conwin,methodnm,par,wh,hh,winpos){
	window.ymPrompt = openSubWin('myIf', tit, uri, wh,hh, false, true, function(tp){winHandler(tp,conwin,methodnm);}, true);
}
function showPickup(tit,uri,wh,hh){
	window.ymPrompt = openSubWin('pickup', tit, uri, wh,hh, false, true, null, true);
}
function winHandler(tp,conwin,methodnm){
	if(tp!="ref" || conwin==null){
		return;
	}
	if(tp=="ref"){
		if(conwin=="report"){
			var wn = window.parent.document.getElementById('leftNavgframe') || window.parent.parent.document.getElementById('leftNavgframe');
			var cwin =wn.contentWindow;
			var eventName= methodnm.substring(0,methodnm.length-2);
			eval("if(cwin."+eventName+"){cwin."+methodnm+"}else{"+methodnm+"}");
		}else{
			eval(methodnm);
		}
	}
}


function closeWin(isref,par){
	if(par == null ||par == "undefined" || par == undefined){
		par = window.parent;
	}
	if(isref== null || isref ==  "undefined" || isref == undefined){
		isref = false;
	}else{
		isref = true;
	}
	if(isref){
		par.ymPrompt.doHandler('ref');
	}
	par.ymPrompt.close();
	var emement =par.document.getElementById("myIf");
	if(emement!=null){
		emement.parentNode.removeChild(emement);
	}
}

function closeWin(isref,par){
	if(par == null ||par == "undefined" || par == undefined){
		par = window.parent;
	}
	if(isref== null || isref ==  "undefined" || isref == undefined){
		isref = false;
	}else{
		isref = true;
	}
	if(isref){
		par.ymPrompt.doHandler('ref');
	}
	par.ymPrompt.close();
}

var report_checkbox ={
	create:function(str,sep,name,vals,isSeq){
		var html="";
		var strArr = str.split(";");
		var valArr = null;
		if(vals!=null&&vals.length>0){
			valArr = vals.split(",");
		}

		for(var i = 0; i < strArr.length; i++){
			var chk="";
			if(strArr[i]!=null&&strArr[i].length>0){
				var txts = strArr[i].split(",");
				var code = txts[0];
				var txt = txts[1];
				if(valArr!=null){
					for(var j=0;j<valArr.length;j++){
						var sel = valArr[j];
						if(code==sel){
							chk="checked=true";
							break;
						}
					}
				}
				if(isSeq){
					html+="<input type=\"text\" class=\"editor\" name=\"seq_"+name+"\" id=\"seq_" + name +"_"+ code + "\" value=\"\" style=\"width:50px;\" title=\"����˳��\"/>";
				}
				html += "<input type=\"checkbox\" "+chk+" name=\""+name+"\" id=\"" + name +"_"+ code + "\" value=\""+code+"\"><label for=\"" + name +"_"+ code +"\">" + txt+"</label>";
				if(sep!=null&&sep.length>0&&i!=strArr.length-1){
					html+=sep;
				}
			}
		}
		return html;
	},
	setCheckBoxCheckedBySeq:function(name,vals){
		var valArr = null;
		if(vals!=null&&vals.length>0){
			valArr = vals.split(",");
		}
		var checkArr = document.getElementsByName(name);
		for(var i=0;i<checkArr.length;i++){
			var code = checkArr[i].value;
			var ckid = checkArr[i].id;
			var seqobj = document.getElementById("seq_"+ckid);
			var seq = "";
			var bl = false;
			if(valArr!=null){
				for(var j=0;j<valArr.length;j++){
					var vals = valArr[j].split("=");
					var sel = vals[1];
					if(code==sel){
						bl = true;
						seq = vals[0];
						break;
					}
				}
			}
			seqobj.value = seq;
			checkArr[i].checked = bl;
		}
	},
	setCheckBoxChecked:function(name,vals){
		var valArr = null;
		if(vals!=null&&vals.length>0){
			valArr = vals.split(",");
		}
		var checkArr = document.getElementsByName(name);
		for(var i=0;i<checkArr.length;i++){
			var code = checkArr[i].value;
			var bl = false;
			if(valArr!=null){
				for(var j=0;j<valArr.length;j++){
					var sel = valArr[j];
					if(code==sel){
						bl = true;
						break;
					}
				}
			}
			checkArr[i].checked = bl;
		}
	},
	getCheckedValueBySeq:function(name){
		var vals="";
		var checkArr = document.getElementsByName(name);
		for(var i=0;i<checkArr.length;i++){
			if(checkArr[i].checked){
				var ckid = checkArr[i].id;
				var seq = document.getElementById("seq_"+ckid).value;
				if(seq==null||seq.length==0 || seq=="0"){
					alert("��ָ������˳�򣬴�1��ʼ");
					return false;
				}

				vals+=seq+"="+checkArr[i].value+",";
			}
		}
		if(vals.length>0){
			vals = vals.substring(0,vals.length-1);
		}
		return vals;
	},
	getCheckedValue:function(name){
		var vals="";
		var checkArr = document.getElementsByName(name);
		for(var i=0;i<checkArr.length;i++){
			if(checkArr[i].checked){
				vals+=checkArr[i].value+",";
			}
		}
		if(vals.length>0){
			vals = vals.substring(0,vals.length-1);
		}
		return vals;
	},
	getCheckedNum:function(name){
		var num = 0;
		var checkArr = document.getElementsByName(name);
		for(var i=0;i<checkArr.length;i++){
			if(checkArr[i].checked){
				num++;
			}
		}
		return num;
	},
	getCheckedArray:function(name){
		var vals=new Array();
		var checkArr = document.getElementsByName(name);
		for(var i=0;i<checkArr.length;i++){
			if(checkArr[i].checked){
				vals.push(checkArr[i].value);
			}
		}
		return vals;
	}
};