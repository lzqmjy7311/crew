package com.huateng.ebank.business.buttonmng.getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.config.bean.base.ICommonQueryOperationElement;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.buttonmng.bean.DatasetButton;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.ebank.parsexml.servlet.ParserFtl;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class DatasetButtonGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<DatasetButton> li = null;
		li = this.getAll();
		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), li, getResult());
		getResult().setContent(li);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

	private List<DatasetButton> getAll() throws AppException {
		List<DatasetButton> re = new ArrayList<DatasetButton>();
//		if(op!=null&&!op.equals("query")){
		    String url="";
//			if(op.equals("btnclick")){
//		     	String funcId=getCommQueryServletRequest().getParameter("funcId");
//			    StringBuffer funcHQL=new StringBuffer("select f from FunctionInfo f where f.id='"+funcId+"'");
//			    List funcList=ROOTDAOUtils.getROOTDAO().queryByQL2List(funcHQL.toString());
//			    if(funcList.size()>0){
//					FunctionInfo functionInfo=(FunctionInfo)funcList.get(0);
//					url=functionInfo.getPagepath();
//			    }
//			}else{
				  url=getCommQueryServletRequest().getParameter("url");
//			}
			  String u= Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1);
			  u=u+"../.."+url;
			  String datasetName=ParserFtl.getDatasetNameByParaseFtlUrl(u);
			  if(datasetName!=null&&!datasetName.equals("")){
				String[] data=datasetName.split(",");
				for(int i=0;i<data.length;i++){
//					List<ICommonQueryOperationElement> btList=datasetButtonMap.get(data[i]);
					ICommonQueryBean commonQueryBean = CommonQueryUtil.getCommonQueryBean(data[i]);
				    Map<String,ICommonQueryOperationElement> operationMap=commonQueryBean.getOperations();
				    Collection<ICommonQueryOperationElement> opCollection=operationMap.values();
			          Iterator<ICommonQueryOperationElement> opIt=opCollection.iterator(); 
			          while(opIt.hasNext()){
			        	ICommonQueryOperationElement button=opIt.next();
						DatasetButton db=new DatasetButton();
						db.setDatasetName(data[i]);
						db.setDesc(button.getAnyValue("desc"));
						db.setId(button.getAnyValue("id"));
						re.add(db);
					}
				 }
			  }	
			  return re;
//		  }else{
//			   String dName=getCommQueryServletRequest().getParameter("valueqdatasetName");
//			   List<ICommonQueryOperationElement> btList=datasetButtonMap.get(dName);
//			   if(btList!=null){
//			     for(int j=0;j<btList.size();j++){
//				  DatasetButton db=new DatasetButton();
//				  db.setDatasetName(dName);
//				  ICommonQueryOperationElement button=btList.get(j);
//				  db.setDesc(button.getAnyValue("desc"));
//				  db.setId(button.getAnyValue("id"));
//				  re.add(db);
//			     }
//			   }
//		   return re;
//
//	  }
	}
}
