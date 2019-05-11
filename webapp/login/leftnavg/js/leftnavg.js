function ChangeFocus(tid){
	var cutid = document.getElementById("curretnTab").value;
	if(cutid==tid){
		return;
	}
	var url = document.getElementById("tab_url_"+tid).value;
	var frm  = document.getElementById("leftNavgframe");
	var msgDiv = document.getElementById("msgDiv");
	if(url!=null && url.length>0){
		frm.style.display="";
		msgDiv.style.display="none";
		frm.src = url;
	}else{
		frm.style.display="none";
		msgDiv.style.display="";
		msgDiv.innerHTML = "功能菜单未设置！";
	}
	document.getElementById("curretnTab").value = tid;
	document.getElementById("tab_"+cutid).className = "DivAround_blur";
	document.getElementById("tab_"+tid).className = "DivAround_focus";
}

function tabMouseOver(obj){
	obj.style.backgroundColor="#cce6f9";
	obj.style.color="#000";
}
function tabMouserOut(obj){
	obj.style.backgroundColor="";
	obj.style.color="";
}

function showOrHiddenLeft(wd){
	var tmp = document.getElementById("leftTd");
	var tmpWd = tmp.width;
	var tabs = document.getElementsByName("leftTab");

	var frmdiv = document.getElementById("frmDiv");

	var disp = "";
	if(tmpWd>wd){
		disp = "none";
		if(wd<=0){
			tmpWd = wd;
		}else{
			tmpWd = wd+"px";
		}
		frmdiv.className="DivAround_contentMax";

	}else{
		disp = "";
		tmpWd = "140px";
		frmdiv.className="DivAround_content";
	}
	for(var i=0;i<tabs.length;i++){
		var tid = tabs[i].value;
		document.getElementById("tab_"+tid).style.display = disp;
	}
	if(tmpWd <= 0){
		tmp.style.display = "none";
	}else{
		tmp.width=tmpWd;
	}
}

function initLeft(sel){
	var tabs = document.getElementsByName("leftTab");
	if(tabs.length==0){
		return;
	}
	if(sel==null || tabs.length<=sel){
		sel = 0;
	}
	var seltabId = tabs[sel].value;
	var url = document.getElementById("tab_url_"+seltabId).value;
	var frm  = document.getElementById("leftNavgframe");
	var msgDiv = document.getElementById("msgDiv");
	if(url!=null && url.length>0){
		frm.style.display="";
		msgDiv.style.display="none";
		frm.src = url;
	}else{
		frm.style.display="none";
		msgDiv.style.display="";
		msgDiv.innerHTML = "功能菜单未设置！";
	}
	document.getElementById("curretnTab").value = seltabId;
	document.getElementById("tab_"+seltabId).className = "DivAround_focus";

	if(tabs.length==1){
		showOrHiddenLeft(0);
	}

}