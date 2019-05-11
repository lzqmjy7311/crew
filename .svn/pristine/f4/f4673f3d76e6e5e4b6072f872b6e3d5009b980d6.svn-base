//jianxue.zhang
var approve = {
	getApprovePage:function(taskIdArr,type){
		var tids="";
		var url="";
		for(var i=0;i<taskIdArr.length;i++){
			tids+=taskIdArr[i]+"@";
		}
		if(type=="100199"){
			url = "/fpages/system/approveftl/approve_bctl.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="100299"){
			url = "/fpages/system/approveftl/approve_role.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="100399"){
			url = "/fpages/system/approveftl/approve_tlrInfo.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="100599"){
			url = "/fpages/system/approveftl/approve_workdate.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="100799"){
			url = "/fpages/system/approveftl/approve_sysParam.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="100899"){
			url = "/fpages/system/approveftl/approve_pfSysParam.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="110199"){
			url = "/fpages/system/approveftl/approve_currency.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="110499"){
			url = "/fpages/system/approveftl/approve_biNation.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="110599"){
			url = "/fpages/system/approveftl/approve_biMonth.ftl?taskIds="+tids+"&type="+type;
		}else if(type=="110699"){
			url = "/fpages/system/approveftl/approve_biDay.ftl?taskIds="+tids+"&type="+type;
		}
		return url;
	}
};
var detail = {
		showUodoTaskDetail:function(type,sta,rcdPk){
			//type记录类型,sta操作说明,rcdpk原纪录主键
			var st = sta;
			if(sta=="01"){
				st = "1";
			}else if(sta=="02"){//修改
				st = "2";
			}else if(sta == "03"){
				st = "3";
			}

			var paramMap = new Map();
			paramMap.put("id",rcdPk);
			paramMap.put("st",st);
			paramMap.put("action","detail");
			paramMap.put("type",type);
			paramMap.put("flag","0");
			if(type=="100199"){
				loadPageWindows("partWin", "机构管理详细信息","/fpages/regonization/ftl/branchManageDetail.ftl", paramMap, "winZone");
			}else if(type=="100299"){
				//loadPageWindows("partWin", "角色管理详细信息","#", paramMap, "winZone");
				showWin("角色管理详细信息","/fpages/system/ftl/RoleFuncMngWithEdit.ftl?id="+rcdPk+"&flag=0&st="+st+"&type=" + type,null,null,window);
			}else if(type=="100399"){
				showWin("用户详细信息","/fpages/regonization/ftl/OperMngRoleCompare.ftl?id=" + rcdPk + "&st=" + st + "&flag=0&type=" + type,"","",window);
				//loadPageWindows("partWin", "用户管理详细信息","#", paramMap, "winZone");
			}else if(type=="100599"){
				showWin("工作日期详细信息","/fpages/system/ftl/BiWorkDateDetail.ftl?id="+rcdPk+"&flag=0&st="+sta+"&type="+type,"","",window);
			}else if(type=="100799"){
				loadPageWindows("partWin", "系统参数详细信息","/fpages/system/ftl/SysParamsEntryDetail.ftl", paramMap, "winZone");
			}else if(type=="100899"){
				loadPageWindows("partWin", "安全参数详细信息","/fpages/system/ftl/SysParamsSecDetail.ftl", paramMap, "winZone");
			}else if(type=="110199"){
				loadPageWindows("partWin", "币种信息维护详细信息","/fpages/basis/ftl/CurrencyManEntryDetail.ftl", paramMap, "winZone");
			}else if(type=="110499"){
				loadPageWindows("partWin", "国家/地区代码维护详细信息","/fpages/basis/ftl/BiNationregionEntryDetail.ftl", paramMap, "winZone");
			}else if(type=="110599"){
				loadPageWindows("partWin", "外汇月牌价维护详细信息","/fpages/basis/ftl/BiMonthExchangeRateDetail.ftl", paramMap, "winZone");
			}else if(type=="110699"){
				loadPageWindows("partWin", "外汇日牌价维护详细信息","/fpages/basis/ftl/BiDayExchangeRateDetail.ftl", paramMap, "winZone");
			}
		}
};

var Compdetail = {
		showCompTaskDetail:function(type,sta,rcdPk,tskId){
			//type记录类型,sta操作说明,rcdpk原纪录主键,tskId日志表中记录主键。
			var st = sta;
			if(sta=="01"){
				st = "1";
			}else if(sta=="02"){//修改
				st = "2";
			}else if(sta == "03"){
				st = "3";
			}

			var paramMap = new Map();
			paramMap.put("id",rcdPk);
			paramMap.put("tskId",tskId);
			paramMap.put("st",st);
			paramMap.put("action","detail");
			paramMap.put("flag","1");
			if(type=="100199"){
				loadPageWindows("partWin", "机构管理详细信息","/fpages/regonization/ftl/branchManageDetail.ftl", paramMap, "winZone");
			}else if(type=="100299"){
				//loadPageWindows("partWin", "角色管理详细信息","/fpages/regonization/ftl/OperMngRoleInfoCompare.ftl", paramMap, "winZone");
				showWin("角色管理详细信息","/fpages/system/ftl/RoleFuncMngWithEdit.ftl?id="+rcdPk+"&flag=1&st="+st+"&tskId="+tskId,null,null,window);
			}else if(type=="100399"){
				//loadPageWindows("partWin", "用户管理详细信息","/fpages/regonization/ftl/OperMngRoleInfoCompare.ftl", paramMap, "winZone");
				showWin("用户详细信息","/fpages/regonization/ftl/OperMngRoleCompare.ftl?id=" + rcdPk + "&st=" + st + "&flag=1&type=" + type+"&tskId=" + tskId,"","",window);
			}else if(type=="100599"){
				showWin("工作日期详细信息","/fpages/system/ftl/BiWorkDateDetail.ftl?id="+rcdPk+"&flag=1&st="+sta+"&type="+type+"&tskId="+tskId,"","",window);
			}else if(type=="100799"){
				loadPageWindows("partWin", "系统参数详细信息","/fpages/system/ftl/SysParamsEntryDetail.ftl", paramMap, "winZone");
			}else if(type=="100899"){
				loadPageWindows("partWin", "安全参数详细信息","/fpages/system/ftl/SysParamsSecDetail.ftl", paramMap, "winZone");
			}else if(type=="110199"){
				loadPageWindows("partWin", "币种信息维护详细信息","/fpages/basis/ftl/CurrencyManEntryDetail.ftl", paramMap, "winZone");
			}else if(type=="110499"){
				loadPageWindows("partWin", "国家/地区代码维护详细信息","/fpages/basis/ftl/BiNationregionEntryDetail.ftl", paramMap, "winZone");
			}else if(type=="110599"){
				loadPageWindows("partWin", "外汇月牌价维护详细信息","/fpages/basis/ftl/BiMonthExchangeRateDetail.ftl", paramMap, "winZone");
			}else if(type=="110699"){
				loadPageWindows("partWin", "外汇日牌价维护详细信息","/fpages/basis/ftl/BiDayExchangeRateDetail.ftl", paramMap, "winZone");
			}
		}
};