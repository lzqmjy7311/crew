package com.gbicc.company.financial.analysis.getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.company.financial.analysis.entity.FinanceIndexData;
import com.gbicc.util.DateUtils;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TCmFinanceIndexDataGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
		String indexCd="('3200006', '3200008', '3200009', '3200011', '3300001', '3300002', '3300003', '3300004',"
				+ " '3300005', '3300006', '3300007', '3300008', '3300010', '3300011', '3300012', '3400005', "
				+ "'3400007', '3400008', '3400010','3400011','3400012', '3400013', '3400014', '3500001', '3500002', '3500003', '3600002', "
				+ "'3600004', '3600006', '3600007', '3600008', '3600009', '3600010', '3600013', '3700001', '3700004', "
				+ "'3700005', '3800004', '3800006', '3800007', '3800008', '3800011', '3800012', '3800013', '3900001', '3900002', "
				+ "'3900003', '3900004', '3900005', '3900006', '3900007', '3900008', '3900009')";
//		 String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
	     String pck = getCommQueryServletRequest().getParameter("paramChk");
	     String id = getCommQueryServletRequest().getParameter("_id");
		DateUtils dataUtils=new DateUtils();
		String sjzyear = (String) getCommQueryServletRequest().getParameterMap().get("jzyear");
		int    jzYear=0;
		if(org.apache.commons.lang3.StringUtils.isNotEmpty(sjzyear)||!"".equals(sjzyear)){
			jzYear=Integer.valueOf(sjzyear);
		}
				
		String caliber = (String) getCommQueryServletRequest().getParameterMap().get("caliber");
		String srepno = (String) getCommQueryServletRequest().getParameterMap().get("repno");
		int repno=0;
				
		if(org.apache.commons.lang3.StringUtils.isNotEmpty(srepno)||!"".equals(srepno)){
			repno=Integer.valueOf(srepno);
		}		
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		Date firstDeadline=new Date();
		Date secondDeadline=new Date();
		Date threeDeadline=new Date();
		firstDeadline=dataUtils.getFirstDeadline(jzYear, caliber, repno);//本期
		secondDeadline=dataUtils.getSecondDeadline(jzYear, caliber, repno);//上期
		threeDeadline=dataUtils.getThreeDeadline(jzYear, caliber, repno);//上上期
		
		SimpleDateFormat simple=new SimpleDateFormat("yyyyMMdd ");
		String  firstDeadlines=simple.format(firstDeadline);
		String  secondDeadlines=simple.format(secondDeadline);
		String  threeDeadlines=simple.format(threeDeadline);
		caliber=this.findCaliber(caliber, rootdao);
		String sql=null;
		boolean isP=false;//是否为父节点
		
		String groupSql="SELECT V.INDEX_TYPE_NAME indexTypeName ,V.INDEX_TYPE indexType  FROM T_CM_FINANCE_INDEX_CD V where v.INDEX_CD not in "+indexCd+"  GROUP BY V.INDEX_TYPE_NAME ,V.INDEX_TYPE";

		
		String psql=  "SELECT                                                                                                                                                                         "
				+"	DISTINCT V1.INDEX_CD INDEX_CD,                                                                                                                                               "
				+"	V1.INDEX_NAME indexName,                                                                                                                                                     "
				+"	V1.INDEX_CD indexCd,                                                                                                                                                         "
				+"	V1.INDEX_TYPE_NAME indexTypeName,                                                                                                                                            "
				+"	V1.INDEX_TYPE indexType ,                                                                                                                                                    "
				+"	V1.REMARKS indexDisp,                                                                                                                                                        "
				+"	V1.INDEX_VALUE_DATA_TYPE AS stringType ,                                                                                                                                     "
				+"	V2.INDEX_VALUE_DATA_TYPE AS sStringType,                                                                                                                                     "
				+"	V3.INDEX_VALUE_DATA_TYPE AS ssStringType,                                                                                                                                    "
				+"	(V2.INDEX_VALUE_DATA_TYPE+V3.INDEX_VALUE_DATA_TYPE)/2 avgStringType,                                                                                                         "
				+"	CASE                                                                                                                                                                         "
				+"		WHEN V1.INDEX_VALUE_DATA_TYPE>MAX(V2.INDEX_VALUE_DATA_TYPE,                                                                                                                "
				+"		V3.INDEX_VALUE_DATA_TYPE)                                                                                                                                                  "
				+"		THEN 'S'                                                                                                                                                                   "
				+"		WHEN V1.INDEX_VALUE_DATA_TYPE<MIN(V2.INDEX_VALUE_DATA_TYPE,                                                                                                                "
				+"		V3.INDEX_VALUE_DATA_TYPE)                                                                                                                                                  "
				+"		THEN 'J'                                                                                                                                                                   "
				+"		ELSE ''                                                                                                                                                                   "
				+"	END                          AS upDown                                                                                                                                       "
				+"FROM                                                                                                                                                                           "
				+"	FIN_INDEX_V V1 LEFT JOIN                                                                                                                                                     "
				+"	FIN_INDEX_V V2 ON  V1.INDEX_CD=V2.INDEX_CD AND V1.INDEX_TYPE=V2.INDEX_TYPE AND V1.CUSTOMER_NUM=V2.CUSTOMER_NUM AND V1.REPORT_TYPE=V2.REPORT_TYPE  AND V2.DEADLINE='"+secondDeadlines+"'  "
				+"	 LEFT JOIN  FIN_INDEX_V V3  ON V1.INDEX_CD=V3.INDEX_CD AND  V1.INDEX_TYPE=V3.INDEX_TYPE AND V1.CUSTOMER_NUM=V3.CUSTOMER_NUM AND V1.REPORT_TYPE=V3.REPORT_TYPE   AND	           "
				+"	V3.DEADLINE='"+threeDeadlines+"'                                                                                                                                                      "
				+"WHERE                                                                                                                                                                          "
				+"	                                                                                                                                                                             "
				+"	                                                                                                                                                                             "
				+"	V1.INDEX_TYPE='"+id+"' AND                                                                                                                                                       "
				+"	V1.CUSTOMER_NUM='"+customerNum+"' AND                                                                                                                                           "
				+"	V1.DEADLINE='"+firstDeadlines+"'   AND                                                                                                                                                   "
				+"	V1.REPORT_TYPE='"+caliber+"'                                                                                                                                                      "
				+"  ORDER BY                                                                                                                                                                       "
				+"	V1.INDEX_CD                                                                                                                                                                  ";
		
				
	

         
		 if(org.apache.commons.lang3.StringUtils.isEmpty(id)||"".equals(id)){
			 sql=groupSql;
			 isP=true;
		 }else{
			 sql=psql;
		 }			
		
		 JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		 List<FinanceIndexData> listT=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(FinanceIndexData.class));
		 
		 if(!isP){
			 String groupSql1="SELECT V.INDEX_NAME indexName,V.INDEX_CD indexCd  FROM T_CM_FINANCE_INDEX_CD V where INDEX_TYPE='"+id+"' and v.INDEX_CD not in "+indexCd+"  GROUP BY v.INDEX_NAME,V.INDEX_CD";
			 List<FinanceIndexData> listTN=jdbcTemplate.query(groupSql1, BeanPropertyRowMapper.newInstance(FinanceIndexData.class));
			 Iterator<FinanceIndexData> itf=listTN.iterator();
			 Iterator<FinanceIndexData> ita=listT.iterator();
			 if(listT.isEmpty()){
				 while(itf.hasNext()){
					 FinanceIndexData a=itf.next();
					 listT.add(a);
				 }
			 }
		 }
		 List<FinanceIndexData> list=createNodes(listT,isP);
		
		 int pageSize  = getResult().getPage().getEveryPage();// 分页大小
		 int pageIndex = getResult().getPage().getCurrentPage();// 页码
		 PageQueryResult pageQueryResult = new PageQueryResult();
		 pageQueryResult.setQueryResult(list);
		 pageQueryResult.setTotalCount(listT.size());

		 return pageQueryResult;
	}

	private List<FinanceIndexData> createNodes(List<FinanceIndexData> list1,boolean isP) {
		List<FinanceIndexData> list = new ArrayList<FinanceIndexData>();
		FinanceIndexData node = null;
		if(isP){//父节点
			for(FinanceIndexData financeIndexData:list1){

				node = new FinanceIndexData();
				node.setId(financeIndexData.getIndexType());
				node.setText(financeIndexData.getIndexTypeName());
				node.setHasChild(true);
//				node.setPid(financeIndexData.getIndexType());
				node.setAvgStringType(financeIndexData.getAvgStringType());
				node.setIndexDisp(financeIndexData.getIndexDisp());
				node.setIndexName(financeIndexData.getIndexName());
				node.setSsStringType(financeIndexData.getSsStringType());
				node.setsStringType(financeIndexData.getsStringType());
				node.setStringType(financeIndexData.getStringType());
				node.setUpDown(financeIndexData.getUpDown());
				list.add(node);
				}
			
		}else{//子节点

			for(FinanceIndexData financeIndexData:list1){

				node = new FinanceIndexData();
				node.setId(financeIndexData.getIndexCd());
//				node.setText(financeIndexData.getIndexTypeName());
				node.setHasChild(false);
				node.setPid(financeIndexData.getIndexType());
				node.setAvgStringType(financeIndexData.getAvgStringType());
				node.setIndexDisp(financeIndexData.getIndexDisp());
				node.setText(financeIndexData.getIndexName());
				node.setSsStringType(financeIndexData.getSsStringType());
				node.setsStringType(financeIndexData.getsStringType());
				node.setStringType(financeIndexData.getStringType());
				node.setUpDown(financeIndexData.getUpDown());
				node.setIconCls("");
				list.add(node);
			}
		}
		
		
			

		return list;
	}
	
	public String findCaliber(String caliber,ROOTDAO rootDao) throws Exception{
		
		Iterator<String> it=rootDao.queryBySQL("select DATA_NO from data_dic t where t.DATA_TYPE_NO='726' AND T.DATA_NAME='"+caliber+"'");
		while(it.hasNext()){
			String obj=it.next();
			caliber=obj!=null ? obj: "";
		}
		return caliber;
	}
	
	
}
