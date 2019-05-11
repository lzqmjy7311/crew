
function changSelect(tid){
	var cutid = document.getElementById("curretnTab").value;
	if(cutid==tid){
		return;
	}
	var url = document.getElementById("topNavg_url_"+tid).value;
	var frm  = document.getElementById("TopNavgframe");
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
	if(cutid!=null&&cutid.length>0){
		document.getElementById("topNavg_Link_"+cutid).className = "normalMenu";
	}
	document.getElementById("topNavg_Link_"+tid).className = "selectedMenu";
}

function initTopNavg(sel){
	var navgs = document.getElementsByName("topNavg");
	if(navgs.length==0){
		return;
	}
	if(sel==null || navgs.length<=sel){
		sel = 0;
	}
	var seltabId = navgs[sel].value;
	var url = document.getElementById("topNavg_url_"+seltabId).value;
	var frm  = document.getElementById("TopNavgframe");
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
	document.getElementById("topNavg_Link_"+seltabId).className = "selectedMenu";
}

function buttonMouseOver(obj){
	obj.style.backgroundImage="";
	obj.style.backgroundColor = "#ededed";
}

function buttonMouseOut(obj){
	obj.style.backgroundImage = "url(images/button.gif)";
}

