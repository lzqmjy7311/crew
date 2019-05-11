package com.huateng.ebank.business.buttonmng.filter;


import java.util.Map;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;

public class ButtonAuthority {
	
   
	public static String getButtonAuthority(String datasetId,String id) throws CommonException{
	 
		GlobalInfo info=GlobalInfo.getCurrentInstance();	
		datasetId=datasetId.replace("_dataset", "");
		String buttonId=new String(datasetId+"_"+id);
		//ROLE_FUNC_REL
		Map<String,String> map=info.getRoleFuncMap();
	    String buttonFunc=map.get(buttonId);
	    //FUNCTIONINFO
	    String funcId=info.getFuncMap().get(buttonId);
	    String currentTabId=info.getCurrentTabId();
	    if(funcId==null){
	    	funcId=info.getButtonMap().get(currentTabId);
	    	return "true_"+funcId;
	    }else{
	    	if(buttonFunc==null){
	    		return "false_"+funcId;
	    	}else{
	    	 	return "true_"+funcId;
	    	}
	    }
	}	
}
