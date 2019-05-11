package com.huateng.ebank.business.management.getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.management.bean.Icon;
import com.huateng.ebank.business.management.bean.IconRow;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


public class IconSelectGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			List list = getIconData();
			List resultlist=new ArrayList();
			String id=getCommQueryServletRequest().getParameter("qid");
			if(StringUtils.isBlank(id)){
				resultlist=list;
			}else{
				for(int i=0;i<list.size();i++){
					Icon icon=(Icon)list.get(i);
					if(icon.getId().toLowerCase().contains(id.toLowerCase())){
						resultlist.add(icon);
					}
						
				}
			}
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultlist, getResult());
			result.setContent(resultlist);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	public List getIconData() throws IOException{
		List resultlist = new ArrayList();
		String path=getHttpReq().getRealPath("/");
		if(!path.endsWith("/")){
			path="/"+path;
		}
	    FileReader iconFile=new FileReader(path+"templets/ui/themes/icon.css");
	    BufferedReader br=new BufferedReader(iconFile);
	    int charAsc;
	    boolean idFlag=false,urlFlag=false;
    	Icon icon=new Icon(); 
    	StringBuffer id=new StringBuffer();
    	StringBuffer url=new StringBuffer();
	    while((charAsc=br.read())!=-1){
	    	char word=(char)charAsc;
	        //以()内的，为地址存入
	        if(charAsc==41){
	        	urlFlag=false;
	        	icon.setUrl(url.toString());
	        	resultlist.add(icon);
	    		id=new StringBuffer();
	        	url=new StringBuffer();
	    		icon=new Icon();
	        }
	        if(charAsc==40||urlFlag){
	        	urlFlag=true;
	        	if(charAsc!=40&&charAsc!=39&&charAsc!=41){
		           url.append(word);
	        	}
	        } 
	    	//以.开头，以{收尾，中间的为名字，存入
	    	if(charAsc==123){
	    		idFlag=false;
	    		icon.setId(id.toString());
	    	}
	        if((charAsc==46||idFlag)&&!urlFlag){	        	
	        	idFlag=true;
	        	if(charAsc!=46&&charAsc!=123){
		        	id.append(word);
	        	}
	        }
	    }
	    return resultlist;
	}
}
