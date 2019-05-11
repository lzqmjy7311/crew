package com.gbicc.warn.ComninationWarn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.highChar.entity.Highcharts;
import com.gbicc.highChar.entity.HighchartsColor;
import com.gbicc.highChar.entity.HighchartsVisiable;
import com.gbicc.util.DateUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ComninationWarnService {
	
	private static final Logger log=LoggerFactory.getLogger(ComninationWarnService.class);
	
	public ComninationWarnService() {
	}

	public synchronized static ComninationWarnService getInstance() {
		return (ComninationWarnService) ApplicationContextUtils
				.getBean(ComninationWarnService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	/**
	 * 预警数量时段统计_条形图
	 * @param selectType
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> warnCountTXT(String[] paramStr) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			System.out.println(paramStr[0]+"---"+paramStr[1]+"---"+paramStr[2]+"---"+paramStr[3]+"---"+paramStr[4]+"---");
			String selectType = paramStr[4];
			if("orgSelect".equals(selectType)){
				this.getSQLByORGReport(paramStr, resultMap);
			}else if("productSelect".equals(selectType)){
				this.getSQLByProductReport(paramStr, resultMap);
			}else if("industrySelect".equals(selectType)){
				this.getSQLByIndustryReport(paramStr, resultMap);
			}
			
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 总体_机构 折线图
	 * @param selectType
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> warnValZXT(String[] paramStr) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//this.getZXT3(ORGCODE, PRODUCT, INDEX_CODE, INDUSTRY, GATHER_TYPE, resultMap);
			//ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE,String THRESHOLD_TYPE,
			Map<String,Object> indexMap=this.findIndexInfoAjx(paramStr[2]);
			String THRESHOLD_TYPE=(String)indexMap.get("THRESHOLD_TYPE");
			String MONITOR_FRE=(String)indexMap.get("MONITOR_FRE");
			Map<String,Object> json;
			Map<String,Object> quanjson;
			if("Q".equals(MONITOR_FRE)){
				json=this.getZXT5(paramStr[0], paramStr[1], paramStr[2], paramStr[3], paramStr[4],THRESHOLD_TYPE);
				System.out.println("--getZXT5-全行值--");
				quanjson=this.getZXT5("00001", "-", paramStr[2], "-", paramStr[4],THRESHOLD_TYPE);
			}else if("M".equals(MONITOR_FRE)){
				json=this.getZXT4(paramStr[0], paramStr[1], paramStr[2], paramStr[3], paramStr[4],THRESHOLD_TYPE);
				System.out.println("--getZXT4-全行值---");
				quanjson=this.getZXT4("00001", "-", paramStr[2], "-", paramStr[4],THRESHOLD_TYPE);
			}else{
				json=this.getZXT3(paramStr[0], paramStr[1], paramStr[2], paramStr[3], paramStr[4],THRESHOLD_TYPE);
				System.out.println("--getZXT3-全行值---");
				quanjson=this.getZXT3("00001", "-", paramStr[2], "-", paramStr[4],THRESHOLD_TYPE);
			}
			List<Highcharts> list=(List<Highcharts>)json.get("data");
			if(!"0".equals(paramStr[0])){//如果是全行,无需添加
				List<Highcharts> quuanlist=(List<Highcharts>)quanjson.get("data");
				Highcharts highcharts=quuanlist.get(0);
				highcharts.setName("全行值");
				list.add(highcharts);
			}
			
			json.put("data", list);
			
			
			JSONObject jsonData = new JSONObject();  
			jsonData.put("data", list);  
			jsonData.put("listXdata", (List<String>)json.get("listXdata"));
			resultMap.put("jsonData1", jsonData);
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 多行业 折线图
	 * @param GATHER_TYPE
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> warnValDDZXT(String[] param) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//this.getZXT3(ORGCODE, PRODUCT, INDEX_CODE, INDUSTRY, GATHER_TYPE, resultMap);
			//ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE,String THRESHOLD_TYPE,
			String indeStr="";
			if(param[1]!=null && param[1]!="" && param[1].length()>2){
				indeStr=param[1].replace(",", "','");
				indeStr="'"+indeStr+"'";
			}
			this.getZXT6(param[0],indeStr, resultMap);
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 指标折线图
	 * @param paramStr
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> industryValZXT(String[] paramStr) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Date selectDate=new Date();
			if(paramStr.length>2&&paramStr[2]!=null && !"".equals(paramStr[2])){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
				try{
					selectDate=sdf.parse(paramStr[2]);
				}catch(Exception e){
					selectDate=sdf2.parse(paramStr[2]);
				}
				selectDate=DateUtils.getNowDateTorDate(selectDate);
			}
			this.getINDUSTRYZXT1("4", paramStr[0], paramStr[1],selectDate, resultMap);
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 指标折线图
	 * @param paramStr
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> industryValZXT2(String[] paramStr) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Date selectDate=new Date();
			if(paramStr.length>2&&paramStr[2]!=null && !"".equals(paramStr[2])){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
				try{
					selectDate=sdf.parse(paramStr[2]);
				}catch(Exception e){
					selectDate=sdf2.parse(paramStr[2]);
				}
				selectDate=DateUtils.getNowDateTorDate(selectDate);
			}
			this.getINDUSTRYZXT2(paramStr[0], paramStr[1],selectDate, resultMap);
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 指标折线图
	 * @param paramStr
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> industryValZXT3(String[] paramStr) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Date selectDate=new Date();
			if(paramStr.length>3&&paramStr[2]!=null && !"".equals(paramStr[2])){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
				try{
					selectDate=sdf.parse(paramStr[2]);
				}catch(Exception e){
					selectDate=sdf2.parse(paramStr[2]);
				}
				selectDate=DateUtils.getNowDateTorDate(selectDate);
			}
			this.getINDUSTRYZXT3(paramStr[0], paramStr[1], paramStr[3],selectDate, resultMap);
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	/**
	 * 手工导入 折线图
	 * @param selectType
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> warnValType3ZXT(String[] paramStr) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//this.getZXT3(ORGCODE, PRODUCT, INDEX_CODE, INDUSTRY, GATHER_TYPE, resultMap);
			//ORG_CODE, PRODUCT_CODE, INDEX_CODE, INDUSTRY_CODE, GATHER_TYPE,String THRESHOLD_TYPE,
			Map<String,Object> indexMap=this.findIndexInfoAjx(paramStr[0]);
			String THRESHOLD_TYPE=(String)indexMap.get("THRESHOLD_TYPE");
			Map<String,Object> json=this.getZXT5("-", "-", paramStr[0], "-", paramStr[1],THRESHOLD_TYPE);
			List<Highcharts> list=(List<Highcharts>)json.get("data");
			
			json.put("data", list);
			JSONObject jsonData = new JSONObject();  
			jsonData.put("data", list);  
			jsonData.put("listXdata", (List<String>)json.get("listXdata"));
			resultMap.put("jsonData1", jsonData);
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 查询指标信息
	 * @param paramStr
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> findIndexInfoAjx(String indexCode) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
			 List<Map<String,Object>> list=jdbcTemplate.queryForList("SELECT * FROM T_CW_IDNEX_MANAGE T WHERE T.INDEX_CODE='"+indexCode+"'");
			 for(Map<String,Object> map:list){
				resultMap.put("INDEX_NAME", (String)map.get("INDEX_NAME"));
				resultMap.put("MONITOR_FRE", (String)map.get("MONITOR_RPE"));
				resultMap.put("GATHER_TYPE", (String)map.get("GATHER_TYPE"));//指标展示类型
				if(map.get("GATHER_TYPE_HAVE")==null){
					resultMap.put("GATHER_TYPE_HAVE", "0,1,2");//指标展示类型
				}else{
					resultMap.put("GATHER_TYPE_HAVE", (String)map.get("GATHER_TYPE_HAVE"));//指标展示类型
				}
				resultMap.put("THRESHOLD_TYPE", (String)map.get("INDEX_TYPE2"));//指标递增还是递减
			 }
			 resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e);
			e.printStackTrace();
		}
		return resultMap;
	}
	
	
	
	
	
	/**
	 * 预警数量时段统计_折线图
	 * @param selectType
	 * @return
	 * @throws ParseException 
	 */
	public Map<String, Object> warnCountZXT(String selectType) throws ParseException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			this.getZXT1(resultMap);
			this.getZXT2(resultMap);
			resultMap.put("success", "true");
		} catch (Exception e) {
			resultMap.put("success", "false");
			log.error("组合风险查询异常----------", e); 
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 按机构查询
	 * @param paramStr
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getSQLByORGReport(String[] paramStr,Map<String, Object> resultMap)
			throws ParseException {
		
		String time1=this.getSelectDate(paramStr, "time1");
		String time2=this.getSelectDate(paramStr, "time2");
		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>();  //x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = DateUtils.getNowDateLastLastQ(sdf.parse(time1), 1);
		StringBuffer sbf = new StringBuffer("");

		
		sbf.append(" SELECT ORG_CODE,SUM(WARNNUM) AS \"WARNCOUNT\" FROM (");
		sbf.append(" SELECT ORG_CODE,");
		sbf.append(" CASE WHEN COLO='LV1' THEN 1");
		sbf.append("     WHEN COLO='LV2' THEN 1");
		sbf.append("      ELSE 0 END AS \"WARNNUM\"");
		sbf.append("  FROM T_CW_CREDIT_INDEX_VAL ");
		sbf.append(" WHERE DATE(DATA_DATE)>='"+startTime+"'");
		sbf.append(" AND DATE(DATA_DATE)<'"+time2+"' ");
		sbf.append(" AND ORG_PARENT='"+paramStr[5]+"' ");
		sbf.append(" AND ORG_CODE<>'"+paramStr[5]+"' ");
		sbf.append(" ) GROUP BY ORG_CODE ORDER BY WARNCOUNT DESC FETCH FIRST 10 ROWS ONLY");
		System.out.println("按机构查询----------"+sbf.toString());
		

		
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		 List<Map<String,Object>> list=jdbcTemplate.queryForList(sbf.toString());
		 List<Integer> datalist= new ArrayList<Integer>();
		 for(Map<String,Object> map:list){
			 xdataList.add(this.getOrgNameAndCodeBycode(map.get("ORG_CODE").toString()));
			 datalist.add((Integer)map.get("WARNCOUNT"));
		 }
		 Highcharts hiGhCharts = new Highcharts();
		 hiGhCharts.setName("机构");
		 hiGhCharts.setData(datalist);
		 dataList.add(hiGhCharts);
		
		 JSONObject jsonData = new JSONObject();  
		 jsonData.put("data", dataList);  
		 jsonData.put("listXdata", xdataList);
		 resultMap.put("jsonData", jsonData);
	}
	
	
	/**
	 * 按产品查询
	 * @param paramStr
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getSQLByProductReport(String[] paramStr, Map<String, Object> resultMap)
			throws ParseException {

		String time1 = this.getSelectDate(paramStr, "time1");
		String time2 = this.getSelectDate(paramStr, "time2");
		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = DateUtils.getNowDateLastLastQ(sdf.parse(time1), 1);
		StringBuffer sbf = new StringBuffer("");

		
		sbf.append(" SELECT PRODUCT_CODE,SUM(WARNNUM) AS \"WARNCOUNT\" FROM (");
		sbf.append(" SELECT PRODUCT_CODE,");
		sbf.append(" CASE WHEN COLO='LV1' THEN 1");
		sbf.append("     WHEN COLO='LV2' THEN 1");
		sbf.append("      ELSE 0 END AS \"WARNNUM\"");
		sbf.append("  FROM T_CW_CREDIT_INDEX_VAL ");
		sbf.append(" WHERE DATE(DATA_DATE)>='"+startTime+"'");
		sbf.append(" AND DATE(DATA_DATE)<'"+time2+"' ");
		sbf.append(" AND PRODUCT_CODE<>'-' AND PRODUCT_CODE<>''");
		sbf.append(" ) GROUP BY PRODUCT_CODE ORDER BY WARNCOUNT DESC FETCH FIRST 10 ROWS ONLY");
		System.out.println("按产品查询----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		List<Integer> datalist = new ArrayList<Integer>();
		for (Map<String, Object> map : list) {
			xdataList.add(this.getProdNameAndCodeBycode(map.get("PRODUCT_CODE").toString()));
			datalist.add((Integer) map.get("WARNCOUNT"));
		}
		Highcharts hiGhCharts = new Highcharts();
		hiGhCharts.setName("产品");
		hiGhCharts.setData(datalist);
		dataList.add(hiGhCharts);

		JSONObject jsonData = new JSONObject();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData", jsonData);
	}
	
	/**
	 * 按行业查询
	 * @param paramStr
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getSQLByIndustryReport(String[] paramStr,
			Map<String, Object> resultMap) throws ParseException {

		String time1 = this.getSelectDate(paramStr, "time1");
		String time2 = this.getSelectDate(paramStr, "time2");
		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("392---"+time1);
		String startTime = DateUtils.getNowDateLastLastQ(sdf.parse(time1), 1);
		StringBuffer sbf = new StringBuffer("");

		sbf.append(" SELECT INDUSTRY_CODE,SUM(WARNNUM) AS \"WARNCOUNT\" FROM (");
		sbf.append(" SELECT INDUSTRY_CODE,");
		sbf.append(" CASE WHEN COLO='LV1' THEN 1");
		sbf.append("     WHEN COLO='LV2' THEN 1");
		sbf.append("      ELSE 0 END AS \"WARNNUM\"");
		sbf.append("  FROM T_CW_CREDIT_INDEX_VAL ");
		sbf.append(" WHERE DATE(DATA_DATE)>='"+startTime+"'");
		sbf.append(" AND DATE(DATA_DATE)<'"+time2+"' ");
		sbf.append(" AND INDUSTRY_CODE<>'-' AND INDUSTRY_CODE<>'' ");
		sbf.append(" AND INDUSTRY_TYPE='2' ");
		sbf.append(" ) GROUP BY INDUSTRY_CODE ORDER BY WARNCOUNT DESC FETCH FIRST 10 ROWS ONLY");
		System.out.println("按行业查询----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		List<Integer> datalist = new ArrayList<Integer>();
		for (Map<String, Object> map : list) {
			xdataList.add(this.getInduNameAndCodeBycode(map.get("INDUSTRY_CODE").toString()));
			datalist.add((Integer) map.get("WARNCOUNT"));
		}
		Highcharts hiGhCharts = new Highcharts();
		hiGhCharts.setName("行业");
		hiGhCharts.setData(datalist);
		dataList.add(hiGhCharts);

		JSONObject jsonData = new JSONObject();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData", jsonData);
	}
	
	
	/**
	 * 预警数量趋势统计-按主题
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getZXT1(Map<String, Object> resultMap) throws ParseException {
		
		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>();  //x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		String startDate = DateUtils.getNowDateLastLastQ(nowDate,4);//起始时间
		String q4Date= DateUtils.getNowDateLastLastQ(nowDate,3);//前四个季度
		String q3Date= DateUtils.getNowDateLastLastQ(nowDate,2);//前三个季度
		String q2Date= DateUtils.getNowDateLastLastQ(nowDate,1);//前二个季度
		String q1Date= DateUtils.getNowDateLastLastQ(nowDate,0);//前一个季度，结束时间
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q4Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q3Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q2Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q1Date)));
		StringBuffer sbf = new StringBuffer("");
		
		
		sbf.append(" SELECT INDEX_TYPE,");
		sbf.append(" MAX(DECODE(QUAETER,'前四季',WARNCOUNT,0)) AS \"Q1_VAL\",");
		sbf.append(" MAX(DECODE(QUAETER,'前三季',WARNCOUNT,0)) AS \"Q2_VAL\",");
		sbf.append(" MAX(DECODE(QUAETER,'前二季',WARNCOUNT,0)) AS \"Q3_VAL\",");
		sbf.append(" MAX(DECODE(QUAETER,'前一季',WARNCOUNT,0)) AS \"Q4_VAL\"");
		sbf.append(" FROM (");
		sbf.append(" SELECT QUAETER,INDEX_TYPE,SUM(WARNNUM) AS \"WARNCOUNT\" FROM (");
		sbf.append(" SELECT CASE ");
		sbf.append("  WHEN DATE(T.DATA_DATE)<'"+q4Date+"' THEN '前四季'");
		sbf.append("  WHEN DATE(T.DATA_DATE)<'"+q3Date+"' THEN '前三季'");
		sbf.append("  WHEN DATE(T.DATA_DATE)<'"+q2Date+"' THEN '前二季'");
		sbf.append("  ELSE '前一季' END AS \"QUAETER\" ");
		sbf.append(" ,CASE WHEN COLO='LV1' THEN 1");
		sbf.append("        WHEN COLO='LV2' THEN 1");
		sbf.append("        ELSE 0 END AS \"WARNNUM\",T.* FROM T_CW_CREDIT_INDEX_VAL T ");
		sbf.append(" WHERE ");
		sbf.append(" DATE(T.DATA_DATE)>='"+startDate+"'");
		sbf.append(" AND DATE(T.DATA_DATE)<'"+q1Date+"'");
		sbf.append(" AND COLO<>'0' AND T.INDEX_TYPE<>'0' ");
		sbf.append(" )   GROUP BY QUAETER,INDEX_TYPE ");
		sbf.append(" ) GROUP BY INDEX_TYPE");
		System.out.println("预警数量趋势统计-按主题----------"+sbf.toString());
		
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		 List<Map<String,Object>> list=jdbcTemplate.queryForList(sbf.toString());
		 for(Map<String,Object> map:list){
			 List<Integer> datalist= new ArrayList<Integer>();
			 datalist.add((Integer)map.get("Q1_VAL"));
			 datalist.add((Integer)map.get("Q2_VAL"));
			 datalist.add((Integer)map.get("Q3_VAL"));
			 datalist.add((Integer)map.get("Q4_VAL"));
			 Highcharts hiGhCharts = new Highcharts();
			 String name=map.get("INDEX_TYPE").toString();
			 if("T1".equals(name)){
				 hiGhCharts.setName("集中度与信贷投向");
			 }else if("T2".equals(name)){
				 hiGhCharts.setName("资产迁徙");
			 }else if("T3".equals(name)){
				 hiGhCharts.setName("减值拨备");
			 }else if("T4".equals(name)){
				 hiGhCharts.setName("资产质量");
			 }
			 hiGhCharts.setData(datalist);
			 dataList.add(hiGhCharts);
		 }
		
		 JSONObject jsonData = new JSONObject();  
		 jsonData.put("data", dataList);  
		 jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData1", jsonData);
	}
	
	/**
	 * 预警数量趋势统计-按预警等级
	 * 
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getZXT2(Map<String, Object> resultMap) throws ParseException {

		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		String startDate = DateUtils.getNowDateLastLastQ(nowDate, 4);// 起始时间
		String q4Date = DateUtils.getNowDateLastLastQ(nowDate, 3);// 前四个季度
		String q3Date = DateUtils.getNowDateLastLastQ(nowDate, 2);// 前三个季度
		String q2Date = DateUtils.getNowDateLastLastQ(nowDate, 1);// 前二个季度
		String q1Date = DateUtils.getNowDateLastLastQ(nowDate, 0);// 前一个季度，结束时间
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q4Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q3Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q2Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q1Date)));
		StringBuffer sbf = new StringBuffer("");
		
		sbf.append(" SELECT COLO,");
		sbf.append(" MAX(DECODE(QUAETER,'前四季',WARNCOUNT,0)) AS \"Q1_VAL\",");
		sbf.append(" MAX(DECODE(QUAETER,'前三季',WARNCOUNT,0)) AS \"Q2_VAL\",");
		sbf.append(" MAX(DECODE(QUAETER,'前二季',WARNCOUNT,0)) AS \"Q3_VAL\",");
		sbf.append(" MAX(DECODE(QUAETER,'前一季',WARNCOUNT,0)) AS \"Q4_VAL\"");
		sbf.append(" FROM (");
		sbf.append(" SELECT QUAETER,COLO,COUNT(COLO) AS \"WARNCOUNT\" FROM (");
		sbf.append(" SELECT CASE ");
		sbf.append("  WHEN DATE(T.DATA_DATE)<'"+q4Date+"' THEN '前四季'");
		sbf.append("  WHEN DATE(T.DATA_DATE)<'"+q3Date+"' THEN '前三季'");
		sbf.append("  WHEN DATE(T.DATA_DATE)<'"+q2Date+"' THEN '前二季'");
		sbf.append("  ELSE '前一季' END AS \"QUAETER\" ");
		sbf.append(" ,T.* FROM T_CW_CREDIT_INDEX_VAL T ");
		sbf.append(" WHERE ");
		sbf.append(" DATE(T.DATA_DATE)>='"+startDate+"'");
		sbf.append(" AND DATE(T.DATA_DATE)<'"+q1Date+"'");
		sbf.append(" AND COLO<>'0'");
		sbf.append(" )   GROUP BY QUAETER,COLO ");
		sbf.append(" ) GROUP BY COLO");
		
		 
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		System.out.println("预警数量趋势统计-按预警等级----------"+sbf.toString());
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		for (Map<String, Object> map : list) {
			List<Integer> datalist = new ArrayList<Integer>();
			datalist.add((Integer) map.get("Q1_VAL"));
			datalist.add((Integer) map.get("Q2_VAL"));
			datalist.add((Integer) map.get("Q3_VAL"));
			datalist.add((Integer) map.get("Q4_VAL"));
			HighchartsColor hiGhCharts = new HighchartsColor();
			hiGhCharts.setData(datalist);
			if("LV1".equals(map.get("COLO").toString())){
				hiGhCharts.setName("红");
				hiGhCharts.setColor("red");
			}else if("LV2".equals(map.get("COLO"))){
				hiGhCharts.setColor("yellow");
				hiGhCharts.setName("黄");
			}else if("LV3".equals(map.get("COLO"))){
				hiGhCharts.setName("绿");
				hiGhCharts.setColor("green");
			}else{
				continue;
			}
			dataList.add(hiGhCharts);
		}

		JSONObject jsonData = new JSONObject();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData2", jsonData);
	}
	
	/**
	 * 指标——折线图——季度
	 * @param ORGCODE
	 * @param PRODUCT
	 * @param INDEX_CODE
	 * @param INDUSTRY
	 * @param GATHER_TYPE
	 * @param resultMap
	 * @throws ParseException
	 */
	private Map<String,Object> getZXT5(String ORG_CODE,String PRODUCT_CODE,String INDEX_CODE,String INDUSTRY_CODE,String GATHER_TYPE,String THRESHOLD_TYPE)
			throws Exception {
		
		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
//		String startDate = DateUtils.getNowDateLastLastQ(nowDate, 4);// 起始时间
		String q4Date = DateUtils.getNowDateLastLastQ(nowDate, 3);// 前四个季度
		String q3Date = DateUtils.getNowDateLastLastQ(nowDate, 2);// 前三个季度
		String q2Date = DateUtils.getNowDateLastLastQ(nowDate, 1);// 前二个季度
		String q1Date = DateUtils.getNowDateLastLastQ(nowDate, 0);// 前一个季度，结束时间
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q4Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q3Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q2Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q1Date)));
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT * FROM (");
		sbf.append(" 	SELECT ");
		sbf.append(" 	CASE WHEN DATE(DATA_DATE)+1 DAYS='"+q4Date+"' THEN 'Q1_VAL'  ");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+q3Date+"' THEN 'Q2_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+q2Date+"' THEN 'Q3_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+q1Date+"' THEN 'Q4_VAL'");
		sbf.append(" 	ELSE '0' END AS \"MCC\",T.NOW_VAL,T.THRESHOLD1,T.THRESHOLD2");
		sbf.append(" 	FROM T_CW_CREDIT_INDEX_VAL T "
				+ "WHERE T.ORG_CODE='"+ORG_CODE+"' AND T.PRODUCT_CODE='"+PRODUCT_CODE+"' AND T.INDUSTRY_CODE='"+INDUSTRY_CODE+"' AND T.MONITOR_FRE='Q' AND T.INDEX_CODE='"+INDEX_CODE+"' AND T.GATHER_TYPE='"+GATHER_TYPE+"' ");
		sbf.append(" 		)  WHERE MCC<>'0'");
		
		System.out.println("指标——折线图——季度----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		
		Map<String,Double> valMap= new HashMap<String, Double>();
		Map<String,Double> THRESHOLD1Map= new HashMap<String, Double>();
		Map<String,Double> THRESHOLD2Map= new HashMap<String, Double>();
		for (Map<String, Object> map : list) {
			String str=(String)map.get("MCC");
			valMap.put(str.trim(), (Double)map.get("NOW_VAL"));
			THRESHOLD1Map.put(str.trim(), (Double)map.get("THRESHOLD1"));
			THRESHOLD2Map.put(str.trim(), (Double)map.get("THRESHOLD2"));
			
		}
		
		List<Double> datalist = new ArrayList<Double>();
		List<Double> datalist1 = new ArrayList<Double>();//阀值1
		List<Double> datalist2 = new ArrayList<Double>();//阀值2
		for (int i = 1; i <= 4; i++) {
			String pStr="Q"+i+"_VAL";
			if(valMap.get(pStr)!=null){
				datalist.add(valMap.get(pStr));
			}else{
				datalist.add(0.0);
			}
			if(THRESHOLD1Map.get(pStr)!=null){
				datalist1.add(THRESHOLD1Map.get(pStr));
			}else{
				datalist1.add(0.0);
			}
			if(THRESHOLD2Map.get(pStr)!=null){
				datalist2.add(THRESHOLD2Map.get(pStr));
			}else{
				datalist2.add(0.0);
			}
		}
		Highcharts hiGhCharts = new Highcharts();
		hiGhCharts.setName("指标值");
		hiGhCharts.setData(datalist);
		dataList.add(hiGhCharts);
		
		HighchartsColor hiGhCharts1 = new HighchartsColor();
		hiGhCharts1.setName("红色边界值");
		hiGhCharts1.setColor("red");
		hiGhCharts1.setData(datalist1);
		dataList.add(hiGhCharts1);
		HighchartsColor hiGhCharts2 = new HighchartsColor();
		hiGhCharts2.setName("黄色边界值");
		hiGhCharts2.setColor("yellow");
		hiGhCharts2.setData(datalist2);
		dataList.add(hiGhCharts2);
		
		Map<String,Object> jsonData = new HashMap<String,Object>();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		return jsonData;
	}
	
	/**
	 * 指标——折线图——月
	 * @param ORGCODE
	 * @param PRODUCT
	 * @param INDEX_CODE
	 * @param INDUSTRY
	 * @param GATHER_TYPE
	 * @param resultMap
	 * @throws ParseException
	 */
	private Map<String,Object> getZXT4(String ORG_CODE,String PRODUCT_CODE,String INDEX_CODE,String INDUSTRY_CODE,String GATHER_TYPE,String THRESHOLD_TYPE)
			throws ParseException {

		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,11))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,10))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,9))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,8))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,7))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,6))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,5))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,4))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,3))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,2))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,1))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,0))));
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT * FROM (");
		sbf.append(" 	SELECT ");
		sbf.append(" 	CASE WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,11)+"' THEN 'M1_VAL'  ");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,10)+"' THEN 'M2_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,9)+"' THEN 'M3_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,8)+"' THEN 'M4_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,7)+"' THEN 'M5_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,6)+"' THEN 'M6_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,5)+"' THEN 'M7_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,4)+"' THEN 'M8_VAL'");
		sbf.append("     WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,3)+"' THEN 'M9_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,2)+"' THEN 'M10_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,1)+"' THEN 'M11_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,0)+"' THEN 'M12_VAL'");
		sbf.append(" 	ELSE '0' END AS \"MCC\",T.NOW_VAL,T.THRESHOLD1,T.THRESHOLD2");
		sbf.append(" 	FROM T_CW_CREDIT_INDEX_VAL T "
				+ "WHERE T.ORG_CODE='"+ORG_CODE+"' AND T.PRODUCT_CODE='"+PRODUCT_CODE+"' AND T.INDUSTRY_CODE='"+INDUSTRY_CODE+"' AND T.MONITOR_FRE='M' AND T.INDEX_CODE='"+INDEX_CODE+"' AND T.GATHER_TYPE='"+GATHER_TYPE+"' ");
		sbf.append(" 		)  WHERE MCC<>'0'");

		System.out.println("指标——折线图——月----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		
		Map<String,Double> valMap= new HashMap<String, Double>();
		Map<String,Double> THRESHOLD1Map= new HashMap<String, Double>();
		Map<String,Double> THRESHOLD2Map= new HashMap<String, Double>();
		for (Map<String, Object> map : list) {
			String str=(String)map.get("MCC");
			valMap.put(str.trim(), (Double)map.get("NOW_VAL"));
			THRESHOLD1Map.put(str.trim(), (Double)map.get("THRESHOLD1"));
			THRESHOLD2Map.put(str.trim(), (Double)map.get("THRESHOLD2"));
			
		}
		
		List<Double> datalist = new ArrayList<Double>();
		List<Double> datalist1 = new ArrayList<Double>();//阀值1
		List<Double> datalist2 = new ArrayList<Double>();//阀值2
		for (int i = 1; i <= 12; i++) {
			String pStr="M"+i+"_VAL";
			if(valMap.get(pStr)!=null){
				datalist.add(valMap.get(pStr));
			}else{
				datalist.add(0.0);
			}
			if(THRESHOLD1Map.get(pStr)!=null){
				datalist1.add(THRESHOLD1Map.get(pStr));
			}else{
				datalist1.add(0.0);
			}
			if(THRESHOLD2Map.get(pStr)!=null){
				datalist2.add(THRESHOLD2Map.get(pStr));
			}else{
				datalist2.add(0.0);
			}
		}
		Highcharts hiGhCharts = new Highcharts();
		hiGhCharts.setName("指标值");
		hiGhCharts.setData(datalist);
		dataList.add(hiGhCharts);
		
		
		HighchartsColor hiGhCharts1 = new HighchartsColor();
		hiGhCharts1.setName("红色边界值");
		hiGhCharts1.setColor("red");
		hiGhCharts1.setData(datalist1);
		dataList.add(hiGhCharts1);
		HighchartsColor hiGhCharts2 = new HighchartsColor();
		hiGhCharts2.setName("黄色边界值");
		hiGhCharts2.setColor("yellow");
		hiGhCharts2.setData(datalist2);
		dataList.add(hiGhCharts2);
		
		
		Map<String,Object> jsonData = new HashMap<String,Object>();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		return jsonData;
	}
	
	/**
	 * 指标——折线图——日
	 * @param ORGCODE
	 * @param PRODUCT
	 * @param INDEX_CODE
	 * @param INDUSTRY
	 * @param GATHER_TYPE
	 * @param resultMap
	 * @throws ParseException
	 */
	private Map<String,Object> getZXT3(String ORG_CODE,String PRODUCT_CODE,String INDEX_CODE,String INDUSTRY_CODE,String GATHER_TYPE,String THRESHOLD_TYPE)
			throws Exception {
		
		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		String nowDateStr=sdf.format(nowDate);
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT * FROM (");
		sbf.append(" 	SELECT ");
		sbf.append(" 	CASE WHEN DATE(DATA_DATE)+15 DAYS='"+nowDateStr+"' THEN 'D1_VAL'  ");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+14 DAYS='"+nowDateStr+"' THEN 'D2_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+13 DAYS='"+nowDateStr+"' THEN 'D3_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+12 DAYS='"+nowDateStr+"' THEN 'D4_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+11 DAYS='"+nowDateStr+"' THEN 'D5_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+10 DAYS='"+nowDateStr+"' THEN 'D6_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+9 DAYS='"+nowDateStr+"' THEN 'D7_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+8 DAYS='"+nowDateStr+"' THEN 'D8_VAL'");
		sbf.append("     WHEN DATE(DATA_DATE)+7 DAYS='"+nowDateStr+"' THEN 'D9_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+6 DAYS='"+nowDateStr+"' THEN 'D10_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+5 DAYS='"+nowDateStr+"' THEN 'D11_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+4 DAYS='"+nowDateStr+"' THEN 'D12_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+3 DAYS='"+nowDateStr+"' THEN 'D13_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+2 DAYS='"+nowDateStr+"' THEN 'D14_VAL'");
		sbf.append(" 	 WHEN DATE(DATA_DATE)+1 DAYS='"+nowDateStr+"' THEN 'D15_VAL'");
		sbf.append(" 	ELSE '0' END AS \"MCC\",T.NOW_VAL,T.THRESHOLD1,T.THRESHOLD2");
		sbf.append(" 	FROM T_CW_CREDIT_INDEX_VAL T "
				+ "WHERE T.ORG_CODE='"+ORG_CODE+"' AND T.PRODUCT_CODE='"+PRODUCT_CODE+"' AND T.INDUSTRY_CODE='"+INDUSTRY_CODE+"' AND T.MONITOR_FRE='D' AND T.INDEX_CODE='"+INDEX_CODE+"' AND T.GATHER_TYPE='"+GATHER_TYPE+"' ");
		sbf.append(" 		)  WHERE MCC<>'0'");
		
		System.out.println("指标——折线图——日----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		
		Map<String,Double> valMap= new HashMap<String, Double>();
		Map<String,Double> THRESHOLD1Map= new HashMap<String, Double>();
		Map<String,Double> THRESHOLD2Map= new HashMap<String, Double>();
		for (Map<String, Object> map : list) {
			String str=(String)map.get("MCC");
			valMap.put(str.trim(), (Double)map.get("NOW_VAL"));
			THRESHOLD1Map.put(str.trim(), (Double)map.get("THRESHOLD1"));
			THRESHOLD2Map.put(str.trim(), (Double)map.get("THRESHOLD2"));
			
		}
		
		List<Double> datalist = new ArrayList<Double>();
		List<Double> datalist1 = new ArrayList<Double>();//阀值1
		List<Double> datalist2 = new ArrayList<Double>();//阀值2
		for (int i = 1; i <= 15; i++) {
			xdataList.add(getYMD(nowDate,16-i));
			String pStr="D"+i+"_VAL";
			if(valMap.get(pStr)!=null){
				datalist.add(valMap.get(pStr));
			}else{
				datalist.add(0.0);
			}
			if(THRESHOLD1Map.get(pStr)!=null){
				datalist1.add(THRESHOLD1Map.get(pStr));
			}else{
				datalist1.add(0.0);
			}
			if(THRESHOLD2Map.get(pStr)!=null){
				datalist2.add(THRESHOLD2Map.get(pStr));
			}else{
				datalist2.add(0.0);
			}
		}
		Highcharts hiGhCharts = new Highcharts();
		hiGhCharts.setName("指标值");
		hiGhCharts.setData(datalist);
		dataList.add(hiGhCharts);
		
		HighchartsColor hiGhCharts1 = new HighchartsColor();
		hiGhCharts1.setName("红色边界值");
		hiGhCharts1.setColor("red");
		hiGhCharts1.setData(datalist1);
		dataList.add(hiGhCharts1);
		HighchartsColor hiGhCharts2 = new HighchartsColor();
		hiGhCharts2.setName("黄色边界值");
		hiGhCharts2.setColor("yellow");
		hiGhCharts2.setData(datalist2);
		dataList.add(hiGhCharts2);
		
		Map<String,Object> jsonData = new HashMap<String,Object>();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		return jsonData;
	}

	
	/**
	 * 多行业——折线图——月
	 * @param ORGCODE
	 * @param PRODUCT
	 * @param INDEX_CODE
	 * @param INDUSTRY
	 * @param GATHER_TYPE
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getZXT6(String GATHER_TYPE,String indexCode,Map<String,Object> resultMap)
			throws ParseException {

		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,11))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,10))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,9))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,8))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,7))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,6))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,5))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,4))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,3))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,2))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,1))));
		xdataList.add(getYM(sdf.parse(DateUtils.getNowDateLastLastM(nowDate,0))));
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT * FROM (");
		sbf.append(" 	SELECT ");
		sbf.append(" 	CASE WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,11)+"' THEN 'M1_VAL'  ");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,10)+"' THEN 'M2_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,9)+"' THEN 'M3_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,8)+"' THEN 'M4_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,7)+"' THEN 'M5_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,6)+"' THEN 'M6_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,5)+"' THEN 'M7_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,4)+"' THEN 'M8_VAL'");
		sbf.append("     WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,3)+"' THEN 'M9_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,2)+"' THEN 'M10_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,1)+"' THEN 'M11_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+DateUtils.getNowDateLastLastM(nowDate,0)+"' THEN 'M12_VAL'");
		sbf.append(" 	ELSE '0' END AS \"MCC\",T.NOW_VAL,T.INDEX_CODE,T.INDEX_NAME ");
		sbf.append(" 	FROM T_CW_CREDIT_INDEX_VAL T "
				+ "WHERE  T.GATHER_TYPE='"+GATHER_TYPE+"' ");
		if(indexCode!=null && indexCode!=""){
			sbf.append(" and T.INDEX_CODE in ("+indexCode+")");
		}
		sbf.append(" 		)  WHERE MCC<>'0'");

		System.out.println("指标——折线图——月----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		
		//有多少行业
		Map<String,Map<String,Double>> industryMap=new HashMap<String, Map<String,Double>>();
		Map<String,String> industryNameMap=new HashMap<String,String>();
		for (Map<String, Object> map : list) {
			String str=(String)map.get("INDEX_CODE");
			String strName=(String)map.get("INDEX_NAME");
			industryNameMap.put(str, strName);
			industryMap.put(str.trim(), new HashMap<String, Double>());
		}
		
		for (Map<String, Object> map : list) {
				String str=(String)map.get("INDEX_CODE");
				if(industryMap.containsKey(str)){
					industryMap.get(str).put(((String)map.get("MCC")).trim(), (Double)map.get("NOW_VAL"));				
				}
		}
		
		for(Entry<String,Map<String,Double>> valuMap: industryMap.entrySet()){
			String indystryCode=valuMap.getKey();
			List<Double> datalist = new ArrayList<Double>();
			Map<String,Double> valMap=industryMap.get(indystryCode);
			for (int i = 1; i <= 12; i++) {
				String pStr="M"+i+"_VAL";
				if(valMap.get(pStr)!=null){
					datalist.add(valMap.get(pStr));
				}else{
					datalist.add(0.0);
				}
			}
			Highcharts hiGhCharts = new Highcharts();
			hiGhCharts.setName(industryNameMap.get(indystryCode));
			hiGhCharts.setData(datalist);
			dataList.add(hiGhCharts);
			
		}
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData1", jsonData);
		
	}
	
	
	
	/**
	 * 多类型——折线图——季
	 * @param INDEX_CODE
	 * @param INDUSTRY_CODE
	 * @param DATA_TYPE
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getINDUSTRYZXT1(String DATA_TYPE,String INDEX_CODE ,String INDUSTRY_CODE,Date nowDate,Map<String,Object> resultMap)
			throws ParseException {

		List<Highcharts> dataList = new ArrayList<Highcharts>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = DateUtils.getNowDateLastLastQ(nowDate, 8);// 起始时间
		String q8Date = DateUtils.getNowDateLastLastQ(nowDate, 7);// 前四个季度
		String q7Date = DateUtils.getNowDateLastLastQ(nowDate, 6);// 前四个季度
		String q6Date = DateUtils.getNowDateLastLastQ(nowDate, 5);// 前四个季度
		String q5Date = DateUtils.getNowDateLastLastQ(nowDate, 4);// 前四个季度
		String q4Date = DateUtils.getNowDateLastLastQ(nowDate, 3);// 前四个季度
		String q3Date = DateUtils.getNowDateLastLastQ(nowDate, 2);// 前三个季度
		String q2Date = DateUtils.getNowDateLastLastQ(nowDate, 1);// 前二个季度
		String q1Date = DateUtils.getNowDateLastLastQ(nowDate, 0);// 前一个季度，结束时间
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q8Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q7Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q6Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q5Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q4Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q3Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q2Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q1Date)));
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT * FROM (");
		sbf.append(" 	SELECT ");
		sbf.append(" 	CASE WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q8Date+"' THEN 'Q1_VAL'  ");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q7Date+"' THEN 'Q2_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q6Date+"' THEN 'Q3_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q5Date+"' THEN 'Q4_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q4Date+"' THEN 'Q5_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q3Date+"' THEN 'Q6_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q2Date+"' THEN 'Q7_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q1Date+"' THEN 'Q8_VAL'");
		sbf.append(" 	ELSE '0' END AS \"QCC\",T.DATA_TYPE,T.NOW_VAL");
		sbf.append(" 	 FROM T_CW_FINANCIAL_VAL T WHERE (T.DATA_TYPE='"+DATA_TYPE+"' OR T.DATA_TYPE='7' OR T.DATA_TYPE='8') AND TO_DATE(T.DATA_DATE,'YYYY-MM-DD')>'"+startDate+"' AND TO_DATE(T.DATA_DATE,'YYYY-MM-DD')<'"+q1Date+"'  AND T.INDEX_CODE='"+INDEX_CODE+"' AND  T.INDUSTRY_CODE='"+INDUSTRY_CODE+"'");
		sbf.append(" 	) T WHERE T.QCC <>'0'");

		System.out.println("行业监测——折线图——季度----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		
		//有多少行业
		Map<String,Map<String,Double>> dataTypeMap=new HashMap<String, Map<String,Double>>();
//		Map<String,String> industryNameMap=new HashMap<String,String>();
		for (Map<String, Object> map : list) {
			String str="IND_"+(String)map.get("DATA_TYPE");
//			industryNameMap.put(str, strName);
			dataTypeMap.put(str.trim(), new HashMap<String, Double>());
		}
		
		for (Map<String, Object> map : list) {
			String str="IND_"+(String)map.get("DATA_TYPE");
			if(dataTypeMap.containsKey(str)){
				dataTypeMap.get(str).put(((String)map.get("QCC")).trim(), (Double)map.get("NOW_VAL"));				
			}
		}
		
		for(Entry<String,Map<String,Double>> valuMap: dataTypeMap.entrySet()){
			String dataTypeCode=valuMap.getKey();
			List<Double> datalist = new ArrayList<Double>();
			Map<String,Double> valMap=dataTypeMap.get(dataTypeCode);
			for (int i = 1; i <= 8; i++) {
				String pStr="Q"+i+"_VAL";
				if(valMap.get(pStr)!=null){
					datalist.add(valMap.get(pStr));
				}else{
					datalist.add(0.0);
				}
			}
			Highcharts hiGhCharts = new Highcharts();
			if("IND_7".equals(dataTypeCode)){
				hiGhCharts.setName("上市公司行业均值");
			}else if("IND_8".equals(dataTypeCode)){
				hiGhCharts.setName("银监会共享行业均值");
			}else{
				hiGhCharts.setName("行内值");
			}
			hiGhCharts.setData(datalist);
			dataList.add(hiGhCharts);
			
		}
		
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData1", jsonData);
		
	}
	/**
	 * 多类型——折线图——季
	 * @param INDEX_CODE
	 * @param INDUSTRY_CODE
	 * @param DATA_TYPE
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getINDUSTRYZXT2(String INDEX_CODE ,String INDUSTRY_CODE,Date nowDate,Map<String,Object> resultMap)
			throws ParseException {
		
		List<HighchartsVisiable> dataList = new ArrayList<HighchartsVisiable>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = DateUtils.getNowDateLastLastQ(nowDate, 8);// 起始时间
		String q8Date = DateUtils.getNowDateLastLastQ(nowDate, 7);// 前四个季度
		String q7Date = DateUtils.getNowDateLastLastQ(nowDate, 6);// 前四个季度
		String q6Date = DateUtils.getNowDateLastLastQ(nowDate, 5);// 前四个季度
		String q5Date = DateUtils.getNowDateLastLastQ(nowDate, 4);// 前四个季度
		String q4Date = DateUtils.getNowDateLastLastQ(nowDate, 3);// 前四个季度
		String q3Date = DateUtils.getNowDateLastLastQ(nowDate, 2);// 前三个季度
		String q2Date = DateUtils.getNowDateLastLastQ(nowDate, 1);// 前二个季度
		String q1Date = DateUtils.getNowDateLastLastQ(nowDate, 0);// 前一个季度，结束时间
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q8Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q7Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q6Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q5Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q4Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q3Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q2Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q1Date)));
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT * FROM (");
		sbf.append(" 	SELECT ");
		sbf.append(" 	CASE WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q8Date+"' THEN 'Q1_VAL'  ");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q7Date+"' THEN 'Q2_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q6Date+"' THEN 'Q3_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q5Date+"' THEN 'Q4_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q4Date+"' THEN 'Q5_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q3Date+"' THEN 'Q6_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q2Date+"' THEN 'Q7_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q1Date+"' THEN 'Q8_VAL'");
		sbf.append(" 	ELSE '0' END AS \"QCC\",T.DATA_TYPE,T.NOW_VAL");
		sbf.append(" 	 FROM T_CW_FINANCIAL_VAL T WHERE TO_DATE(T.DATA_DATE,'YYYY-MM-DD')>'"+startDate+"' AND TO_DATE(T.DATA_DATE,'YYYY-MM-DD')<'"+q1Date+"'  AND T.INDEX_CODE='"+INDEX_CODE+"' AND  T.INDUSTRY_CODE='"+INDUSTRY_CODE+"'");
		sbf.append(" 	) T WHERE T.QCC <>'0'");
		
		System.out.println("行业监测——折线图——季度----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		
		//有多少行业
		Map<String,Map<String,Double>> dataTypeMap=new HashMap<String, Map<String,Double>>();
//		Map<String,String> industryNameMap=new HashMap<String,String>();
		for (Map<String, Object> map : list) {
			String str="IND_"+(String)map.get("DATA_TYPE");
//			industryNameMap.put(str, strName);
			dataTypeMap.put(str.trim(), new HashMap<String, Double>());
		}
		
		for (Map<String, Object> map : list) {
			String str="IND_"+(String)map.get("DATA_TYPE");
			if(dataTypeMap.containsKey(str)){
				dataTypeMap.get(str).put(((String)map.get("QCC")).trim(), (Double)map.get("NOW_VAL"));				
			}
		}
		
		for(Entry<String,Map<String,Double>> valuMap: dataTypeMap.entrySet()){
			String dataTypeCode=valuMap.getKey();
			List<Double> datalist = new ArrayList<Double>();
			Map<String,Double> valMap=dataTypeMap.get(dataTypeCode);
			for (int i = 1; i <= 8; i++) {
				String pStr="Q"+i+"_VAL";
				if(valMap.get(pStr)!=null){
					datalist.add(valMap.get(pStr));
				}else{
					datalist.add(0.0);
				}
			}
			HighchartsVisiable hiGhCharts = new HighchartsVisiable();
			
			
			if("IND_1".equals(dataTypeCode)){
				hiGhCharts.setName("均值");
			}else if("IND_2".equals(dataTypeCode)){
				hiGhCharts.setName("90%分位");
			}else if("IND_3".equals(dataTypeCode)){
				hiGhCharts.setName("70%分位");
			}else if("IND_4".equals(dataTypeCode)){
				hiGhCharts.setName("50%分位");
			}else if("IND_5".equals(dataTypeCode)){
				hiGhCharts.setName("30%分位");
			}else if("IND_6".equals(dataTypeCode)){
				hiGhCharts.setName("10%分位");
			}else if("IND_7".equals(dataTypeCode)){
				hiGhCharts.setName("上市公司行业均值");
			}else if("IND_8".equals(dataTypeCode)){
				hiGhCharts.setName("银监会共享行业均值");
			}else{
				hiGhCharts.setName("行内值");
			}
			hiGhCharts.setData(datalist);
			dataList.add(hiGhCharts);
			
		}
		
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData1", jsonData);
		
	}
	
	/**
	 * 多类型——折线图——季
	 * @param INDEX_CODE
	 * @param INDUSTRY_CODE
	 * @param DATA_TYPE
	 * @param resultMap
	 * @throws ParseException
	 */
	private void getINDUSTRYZXT3(String INDEX_CODE ,String INDUSTRY_CODE,String DATA_TYPE,Date nowDate,Map<String,Object> resultMap)
			throws ParseException {
		
		List<HighchartsVisiable> dataList = new ArrayList<HighchartsVisiable>();
		List<String> xdataList = new ArrayList<String>(); // x轴数据 list
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = DateUtils.getNowDateLastLastQ(nowDate, 8);// 起始时间
		String q8Date = DateUtils.getNowDateLastLastQ(nowDate, 7);// 前四个季度
		String q7Date = DateUtils.getNowDateLastLastQ(nowDate, 6);// 前四个季度
		String q6Date = DateUtils.getNowDateLastLastQ(nowDate, 5);// 前四个季度
		String q5Date = DateUtils.getNowDateLastLastQ(nowDate, 4);// 前四个季度
		String q4Date = DateUtils.getNowDateLastLastQ(nowDate, 3);// 前四个季度
		String q3Date = DateUtils.getNowDateLastLastQ(nowDate, 2);// 前三个季度
		String q2Date = DateUtils.getNowDateLastLastQ(nowDate, 1);// 前二个季度
		String q1Date = DateUtils.getNowDateLastLastQ(nowDate, 0);// 前一个季度，结束时间
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q8Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q7Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q6Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q5Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q4Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q3Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q2Date)));
		xdataList.add(DateUtils.getDateYQStr(sdf.parse(q1Date)));
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT * FROM (");
		sbf.append(" 	SELECT ");
		sbf.append(" 	CASE WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q8Date+"' THEN 'Q1_VAL'  ");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q7Date+"' THEN 'Q2_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q6Date+"' THEN 'Q3_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q5Date+"' THEN 'Q4_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q4Date+"' THEN 'Q5_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q3Date+"' THEN 'Q6_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q2Date+"' THEN 'Q7_VAL'");
		sbf.append(" 	 WHEN TO_DATE(DATA_DATE,'YYYY-MM-DD')+1 DAYS='"+q1Date+"' THEN 'Q8_VAL'");
		sbf.append(" 	ELSE '0' END AS \"QCC\",T.INDUSTRY_CODE,T.INDUSTRY_NAME,T.NOW_VAL");
		sbf.append(" 	 FROM T_CW_FINANCIAL_VAL T WHERE TO_DATE(T.DATA_DATE,'YYYY-MM-DD')>'"+startDate+"' AND TO_DATE(T.DATA_DATE,'YYYY-MM-DD')<'"+q1Date+"'  AND (T.INDUSTRY_CODE='"+INDUSTRY_CODE+"' OR T.INDUSTRY_PARENT='"+INDUSTRY_CODE+"') AND T.DATA_TYPE='"+DATA_TYPE+"' AND T.INDEX_CODE='"+INDEX_CODE+"' ");
		sbf.append(" 	) T WHERE T.QCC <>'0'");
		
		System.out.println("行业报表3——折线图——季度----------"+sbf.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sbf
				.toString());
		
		//有多少行业
		Map<String,Map<String,Double>> dataTypeMap=new HashMap<String, Map<String,Double>>();
		Map<String,String> industryNameMap=new HashMap<String,String>();
		for (Map<String, Object> map : list) {
			String str=(String)map.get("INDUSTRY_CODE");
			String strName=(String)map.get("INDUSTRY_NAME");
			industryNameMap.put(str, strName);
			dataTypeMap.put(str.trim(), new HashMap<String, Double>());
		}
		
		for (Map<String, Object> map : list) {
			String str=(String)map.get("INDUSTRY_CODE");
			if(dataTypeMap.containsKey(str)){
				dataTypeMap.get(str).put(((String)map.get("QCC")).trim(), (Double)map.get("NOW_VAL"));				
			}
		}
		
		for(Entry<String,Map<String,Double>> valuMap: dataTypeMap.entrySet()){
			String dataTypeCode=valuMap.getKey();
			List<Double> datalist = new ArrayList<Double>();
			Map<String,Double> valMap=dataTypeMap.get(dataTypeCode);
			for (int i = 1; i <= 8; i++) {
				String pStr="Q"+i+"_VAL";
				if(valMap.get(pStr)!=null){
					datalist.add(valMap.get(pStr));
				}else{
					datalist.add(0.0);
				}
			}
			HighchartsVisiable hiGhCharts = new HighchartsVisiable();
			hiGhCharts.setName(industryNameMap.get(dataTypeCode));
			hiGhCharts.setData(datalist);
			dataList.add(hiGhCharts);
			
		}
		
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("data", dataList);
		jsonData.put("listXdata", xdataList);
		resultMap.put("jsonData1", jsonData);
		
	}
	
	
	/**
	 * 获取查询日期
	 * @param paramStr
	 * @param selectType
	 * @return
	 */
	private String getSelectDate(String[] paramStr,String selectType){
		String time1="";
		String time2="";
		if("0001".equals(paramStr[0])){
			paramStr[0]="2015";
		}
		if("1".equals(paramStr[1])){
			time1=paramStr[0]+"-04-01";
		}else if("2".equals(paramStr[1])){
			time1=paramStr[0]+"-07-01";
		}else if("3".equals(paramStr[1])){
			time1=paramStr[0]+"-10-01";
		}else{
			time1=Integer.parseInt(paramStr[0])+1+"-01-01";
		}
		
		if("1".equals(paramStr[3])){
			time2=paramStr[2]+"-04-01";
		}else if("2".equals(paramStr[3])){
			time2=paramStr[2]+"-07-01";
		}else if("3".equals(paramStr[3])){
			time2=paramStr[2]+"-10-01";
		}else{
			time2=Integer.parseInt(paramStr[2])+1+"-01-01";
		}
		if("time1".equals(selectType)){
			System.out.println(time1);
			return time1;
		}else{
			System.out.println(time2);
			return time2;
		}
	}
	private  static String getXStr(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(date));
		int yue = calendar.get(Calendar.MONTH) + 1;
		String dateStr = "";
		if (yue == 1) {
			dateStr = calendar.get(Calendar.YEAR)-1 + "年4Q";
		} else if (yue == 4) {
			dateStr = calendar.get(Calendar.YEAR) + "年1Q";
		} else if (yue == 7) {
			dateStr = calendar.get(Calendar.YEAR) + "年2Q";
		} else if (yue == 10) {
			dateStr = calendar.get(Calendar.YEAR) + "年3Q";
		}
		return dateStr;
	}
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse("2015-01-01"));
		System.out.println(sdf.format(DateUtils.getFirstDayOfMonth(sdf.parse("2015-01-01"))));
		System.out.println(DateUtils.getNowDateLastLastM(sdf.parse("2015-01-01"),0));
		System.out.println(getYM(sdf.parse("2015-01-01")));
		
	}
	
	private static String getYM(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String ym="";
		if(calendar.get(Calendar.MONTH)<1){
			return calendar.get(Calendar.YEAR)-1+"年12月";
		}else{
			return calendar.get(Calendar.YEAR)+"年"+calendar.get(Calendar.MONTH)+"月";
		}
	}
	
	
	/**
	 * 根据机构号找到名字
	 * @param orgcode
	 * @return
	 */
	private String getOrgNameAndCodeBycode(String orgcode){
		if(StringUtils.isBlank(orgcode))
			return orgcode;
		String name= "";
		try {
			Bctl bctl=BctlService.getInstance().getBctlByBrcode(orgcode);
			if(bctl!=null){
				name=bctl.getBrname()+name;
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return name;
		}
		
		return name;
	}
	
	/**
	 * 根据产品号找到名字
	 * @param orgcode
	 * @return
	 */
	private String getProdNameAndCodeBycode(String prodcode){
		if(StringUtils.isBlank(prodcode))
			return prodcode;
		String name= "";
		try {
			JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
			List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT PRODUCT_NAME,PRODUCT_TYPE FROM T_CW_PRODUCT WHERE PRODUCT_CODE='"+prodcode+"'");
			if(list!=null&&list.size()>0){
				name=list.get(0).get("PRODUCT_NAME")+name;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return name;
		}
		
		return name;
	}
	
	/**
	 * 根据行业找到名字
	 * @param orgcode
	 * @return
	 */
	private String getInduNameAndCodeBycode(String inducode){
		if(StringUtils.isBlank(inducode))
			return inducode;
		String name= "";
		try {
			JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
			List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT INDUSTRY_NAME,INDUSTRY FROM T_CW_INDUSTRY WHERE INDUSTRY='"+inducode+"'");
			if(list!=null&&list.size()>0){
				name=list.get(0).get("INDUSTRY_NAME")+name;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return name;
		}
		
		return name;
	}
	
	private static String getYMD(Date date,int length){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, -1*length);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(calendar.getTime());
	}
	
	
	
	
	
	
	
	
	
	
}