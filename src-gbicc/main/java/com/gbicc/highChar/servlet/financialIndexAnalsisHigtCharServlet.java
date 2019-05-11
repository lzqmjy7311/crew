package com.gbicc.highChar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.springframework.jdbc.core.JdbcTemplate;

import net.sf.json.JSONObject;

import com.gbicc.highChar.entity.Highcharts;
import com.gbicc.highChar.entity.HighchartsColorVisiable;
import com.gbicc.util.DateUtils;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.mysql.jdbc.log.LogFactory;

public class financialIndexAnalsisHigtCharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JSONObject jsonData;
	public financialIndexAnalsisHigtCharServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter pw=response.getWriter();
			String caliber=request.getParameter("caliber");
			String jzyear=request.getParameter("jzyear");
			String customerNum=request.getParameter("customerNum");
			String repno=request.getParameter("repno");
			String month=null;
			Date t2=new Date();
			List<String> datelist= new ArrayList<String>();
			String caliberquery="";
			String startDates="";
			String endDates="";
	        jsonData = new JSONObject();
	        List<String> xdataList = new ArrayList<String>();  //x轴数据 list
	        StringBuffer sql=null;
			if(caliber.equals("709")){
				caliberquery=" AND G.FINANCE_STATEMENT_TYPE_CD = '3'";
				if(repno.equals("1")){
					month="3";
				}else if(repno.equals("2")){
					month="6";
				}
				else if(repno.equals("3")){
					month="9";
				}
				else if(repno.equals("4")){
					month="12";
				}
				Date endDate=DateUtils.getLastDayOfMonth(Integer.valueOf(jzyear),Integer.valueOf(month) );
				Calendar startCal=Calendar.getInstance();
				startCal.setTime(endDate);
				Calendar ctimetemp=Calendar.getInstance();
				ctimetemp.setTime(endDate);
				startCal.add(Calendar.MONTH, -15);
				Date startDate=startCal.getTime();
				DateFormat df=new SimpleDateFormat("yyyyMMdd");
				startDates=df.format(startDate);
				endDates=df.format(endDate);
        		for(int i=1;i<7;i++){
        			t2=ctimetemp.getTime();
        			t2=DateUtils.getLastDayOfMonth(t2);
		    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		    		String datea=sdf.format(t2);
		    		datelist.add(datea);
		    		ctimetemp.add(Calendar.MONTH,-3);
        		}
        		Collections.reverse(datelist);
			}else if(caliber.equals("707")){
				caliberquery=" AND G.FINANCE_STATEMENT_TYPE_CD = '1'";
				Date endDate=DateUtils.getLastDayOfMonth(Integer.valueOf(jzyear),Integer.valueOf("12") );
				Calendar startCal=Calendar.getInstance();
				startCal.setTime(endDate);
				Calendar ctimetemp=Calendar.getInstance();
				ctimetemp.setTime(endDate);
				startCal.add(Calendar.YEAR, -5);
				Date startDate=startCal.getTime();
				DateFormat df=new SimpleDateFormat("yyyyMMdd");
				startDates=df.format(startDate);
				endDates=df.format(endDate);
        		for(int i=1;i<7;i++){
        			t2=ctimetemp.getTime();
        			t2=DateUtils.getLastDayOfMonth(t2);
		    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		    		String datea=sdf.format(t2);
		    		datelist.add(datea);
		    		ctimetemp.add(Calendar.YEAR,-1);
        		}
        		Collections.reverse(datelist);
				System.out.print("开始时间："+startDates+"\n 结束时间："+endDates);
			}
        	sql=new StringBuffer("SELECT * FROM (SELECT g.INDEX_VALUE_DATA_TYPE AS typecore,g.INDEX_DISP AS name, g.INDEX_CD AS typename,g.FINANCE_STATEMENT_DEADLINE AS dateflag  ,w.UP_VALUE upvalue,w.DOWN_VALUE downvalue ,ROW_NUMBER() OVER(PARTITION BY g.CUSTOMER_NUM,g.FINANCE_STATEMENT_DEADLINE,g.INDEX_CD ORDER BY g.CAL_DATE) RM  FROM T_CM_INTEGRITY_INDEX_DATA_G G LEFT JOIN T_ODS_CMS_CORPORATION n on g.CUSTOMER_NUM=n.CUSTOMER_NUM left join  T_CM_FINANCE_INDEX_HY_FW W ON G.INDEX_CD=W.INDEX_CD AND G.FINANCE_STATEMENT_DEADLINE=W.FINANCE_STATEMENT_DEADLINE AND G.FINANCE_STATEMENT_TYPE_CD=W.FINANCE_STATEMENT_TYPE_CD and substr(n.PBC_INDUSTRY_CD,1,1)=w.INDUSTRY_LEVEL where 1=1 ");
	        sql.append("  AND G.FINANCE_STATEMENT_DEADLINE BETWEEN '"+startDates+"' and '"+endDates+"'");
	        sql.append(caliberquery);
	        sql.append(" AND G.CUSTOMER_NUM='"+customerNum+"'");
	        StringBuffer Querysql=new StringBuffer("SELECT D.INDEX_NAME AS typeName,D.INDEX_CD AS typeCd  FROM T_CM_FINANCE_INDEX_CD D");
	        /*drawpict方法中空代表周转期，1代表周围期变化率，2代表金融债务状况，3代表实物性资产，4代表经常收支合理性分析，5代表资产系数*/
	        drawpict(xdataList, sql,Querysql, "'3900008'", datelist, "");
        	sql=new StringBuffer("SELECT * FROM (SELECT g.INDEX_VALUE_DATA_TYPE AS typecore,g.INDEX_DISP AS name, g.INDEX_CD AS typename,g.FINANCE_STATEMENT_DEADLINE AS dateflag  ,w.UP_VALUE upvalue,w.DOWN_VALUE downvalue ,ROW_NUMBER() OVER(PARTITION BY g.CUSTOMER_NUM,g.FINANCE_STATEMENT_DEADLINE,g.INDEX_CD ORDER BY g.CAL_DATE) RM  FROM T_CM_INTEGRITY_INDEX_DATA_G G LEFT JOIN T_ODS_CMS_CORPORATION n on g.CUSTOMER_NUM=n.CUSTOMER_NUM left join  T_CM_FINANCE_INDEX_HY_FW W ON G.INDEX_CD=W.INDEX_CD AND G.FINANCE_STATEMENT_DEADLINE=W.FINANCE_STATEMENT_DEADLINE AND G.FINANCE_STATEMENT_TYPE_CD=W.FINANCE_STATEMENT_TYPE_CD and substr(n.PBC_INDUSTRY_CD,1,1)=w.INDUSTRY_LEVEL where 1=1 ");
	        sql.append("  AND G.FINANCE_STATEMENT_DEADLINE BETWEEN '"+startDates+"' and '"+endDates+"'");
	        sql.append(caliberquery);
	        sql.append(" AND G.CUSTOMER_NUM='"+customerNum+"'");
	        drawpict(xdataList, sql,Querysql,  "'3900009'", datelist, "1");
        	sql=new StringBuffer("SELECT * FROM (SELECT g.INDEX_VALUE_DATA_TYPE AS typecore,g.INDEX_DISP AS name, g.INDEX_CD AS typename,g.FINANCE_STATEMENT_DEADLINE AS dateflag  ,w.UP_VALUE upvalue,w.DOWN_VALUE downvalue ,ROW_NUMBER() OVER(PARTITION BY g.CUSTOMER_NUM,g.FINANCE_STATEMENT_DEADLINE,g.INDEX_CD ORDER BY g.CAL_DATE) RM  FROM T_CM_INTEGRITY_INDEX_DATA_G G LEFT JOIN T_ODS_CMS_CORPORATION n on g.CUSTOMER_NUM=n.CUSTOMER_NUM left join  T_CM_FINANCE_INDEX_HY_FW W ON G.INDEX_CD=W.INDEX_CD AND G.FINANCE_STATEMENT_DEADLINE=W.FINANCE_STATEMENT_DEADLINE AND G.FINANCE_STATEMENT_TYPE_CD=W.FINANCE_STATEMENT_TYPE_CD and substr(n.PBC_INDUSTRY_CD,1,1)=w.INDUSTRY_LEVEL where 1=1 ");
	        sql.append("  AND G.FINANCE_STATEMENT_DEADLINE BETWEEN '"+startDates+"' and '"+endDates+"'");
	        sql.append(caliberquery);
	        sql.append(" AND G.CUSTOMER_NUM='"+customerNum+"'");
	        drawpict(xdataList, sql,Querysql,  "'3900006','3900007'", datelist, "2");
        	sql=new StringBuffer("SELECT * FROM (SELECT g.INDEX_VALUE_DATA_TYPE AS typecore,g.INDEX_DISP AS name, g.INDEX_CD AS typename,g.FINANCE_STATEMENT_DEADLINE AS dateflag  ,w.UP_VALUE upvalue,w.DOWN_VALUE downvalue ,ROW_NUMBER() OVER(PARTITION BY g.CUSTOMER_NUM,g.FINANCE_STATEMENT_DEADLINE,g.INDEX_CD ORDER BY g.CAL_DATE) RM  FROM T_CM_INTEGRITY_INDEX_DATA_G G LEFT JOIN T_ODS_CMS_CORPORATION n on g.CUSTOMER_NUM=n.CUSTOMER_NUM left join  T_CM_FINANCE_INDEX_HY_FW W ON G.INDEX_CD=W.INDEX_CD AND G.FINANCE_STATEMENT_DEADLINE=W.FINANCE_STATEMENT_DEADLINE AND G.FINANCE_STATEMENT_TYPE_CD=W.FINANCE_STATEMENT_TYPE_CD and substr(n.PBC_INDUSTRY_CD,1,1)=w.INDUSTRY_LEVEL where 1=1 ");
	        sql.append("  AND G.FINANCE_STATEMENT_DEADLINE BETWEEN '"+startDates+"' and '"+endDates+"'");
	        sql.append(caliberquery);
	        sql.append(" AND G.CUSTOMER_NUM='"+customerNum+"'");
	        drawpict(xdataList, sql,Querysql,  "'3900004','3900005'", datelist, "3");
        	sql=new StringBuffer("SELECT * FROM (SELECT g.INDEX_VALUE_DATA_TYPE AS typecore,g.INDEX_DISP AS name, g.INDEX_CD AS typename,g.FINANCE_STATEMENT_DEADLINE AS dateflag  ,w.UP_VALUE upvalue,w.DOWN_VALUE downvalue ,ROW_NUMBER() OVER(PARTITION BY g.CUSTOMER_NUM,g.FINANCE_STATEMENT_DEADLINE,g.INDEX_CD ORDER BY g.CAL_DATE) RM  FROM T_CM_INTEGRITY_INDEX_DATA_G G LEFT JOIN T_ODS_CMS_CORPORATION n on g.CUSTOMER_NUM=n.CUSTOMER_NUM left join  T_CM_FINANCE_INDEX_HY_FW W ON G.INDEX_CD=W.INDEX_CD AND G.FINANCE_STATEMENT_DEADLINE=W.FINANCE_STATEMENT_DEADLINE AND G.FINANCE_STATEMENT_TYPE_CD=W.FINANCE_STATEMENT_TYPE_CD and substr(n.PBC_INDUSTRY_CD,1,1)=w.INDUSTRY_LEVEL where 1=1 ");
	        sql.append("  AND G.FINANCE_STATEMENT_DEADLINE BETWEEN '"+startDates+"' and '"+endDates+"'");
	        sql.append(caliberquery);
	        sql.append(" AND G.CUSTOMER_NUM='"+customerNum+"'");
	        drawpict(xdataList, sql,Querysql,  "'3900001','3900002'", datelist, "4");
        	sql=new StringBuffer("SELECT * FROM (SELECT g.INDEX_VALUE_DATA_TYPE AS typecore,g.INDEX_DISP AS name, g.INDEX_CD AS typename,g.FINANCE_STATEMENT_DEADLINE AS dateflag  ,w.UP_VALUE upvalue,w.DOWN_VALUE downvalue ,ROW_NUMBER() OVER(PARTITION BY g.CUSTOMER_NUM,g.FINANCE_STATEMENT_DEADLINE,g.INDEX_CD ORDER BY g.CAL_DATE) RM  FROM T_CM_INTEGRITY_INDEX_DATA_G G LEFT JOIN T_ODS_CMS_CORPORATION n on g.CUSTOMER_NUM=n.CUSTOMER_NUM left join  T_CM_FINANCE_INDEX_HY_FW W ON G.INDEX_CD=W.INDEX_CD AND G.FINANCE_STATEMENT_DEADLINE=W.FINANCE_STATEMENT_DEADLINE AND G.FINANCE_STATEMENT_TYPE_CD=W.FINANCE_STATEMENT_TYPE_CD and substr(n.PBC_INDUSTRY_CD,1,1)=w.INDUSTRY_LEVEL where 1=1 ");
	        sql.append("  AND G.FINANCE_STATEMENT_DEADLINE BETWEEN '"+startDates+"' and '"+endDates+"'");
	        sql.append(caliberquery);
	        sql.append(" AND G.CUSTOMER_NUM='"+customerNum+"'");
	        drawpict(xdataList, sql,Querysql,  "'3900003'", datelist, "5");
	        String result=jsonData.toString();
	        pw.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//返回前台highcharts参数的方法
	public void drawpict(List<String> xdataList,StringBuffer sql,StringBuffer Querysql,String zbid,List<String> datelist,String num){
	        xdataList = new ArrayList<String>();  							//x轴数据 list
	        sql.append(" AND G.INDEX_CD IN ("+zbid+")) T WHERE T.RM=1");
	        JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
	        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql.toString());
	        List<Map<String,Object>> list1=jdbcTemplate.queryForList(Querysql.toString());
	        xdataList = new ArrayList<String>();
	        List<HighchartsColorVisiable>  dataListcommon = new ArrayList<HighchartsColorVisiable>();
			Iterator<String> ittemp=ChangetoList(zbid);
			int i=0;
			while(ittemp.hasNext()){										//主题循环匹配--start
				 i++;
				String strtemp11=(String)ittemp.next();
//				 String zbname=null;
//				 for(Map<String,Object> en1:list){
//					 if(strtemp11.equals((String)en1.get("typename"))){
//						 zbname=(String)en1.get("name");
//					 }
//				 }
				 List<BigDecimal> project1 = new ArrayList<BigDecimal>(); 
				 List<BigDecimal> project2 = new ArrayList<BigDecimal>(); 
				 List<BigDecimal> project3 = new ArrayList<BigDecimal>(); 
				 HighchartsColorVisiable highchart1 = new HighchartsColorVisiable();
				 HighchartsColorVisiable highchart2 = new HighchartsColorVisiable(); 
				 HighchartsColorVisiable highchart3 = new HighchartsColorVisiable(); 
				Iterator<String> dateit=datelist.iterator();
				 while(dateit.hasNext()){									//期数循环匹配--start
					
					 boolean fl=false;										//fl 相应期数有数据true,否则false
					 String dateflag=(String)dateit.next();
					 for(Map<String,Object> en1:list){						//遍历数据List
						 String datetem=(String)en1.get("dateflag");
						 if(dateflag.equals(datetem)){						//数据List匹配到期数，进入设置数据。
						 	if(strtemp11.equals((String)en1.get("typename"))){
						 		fl=true;
							 	BigDecimal corestr=(BigDecimal)en1.get("typecore");	
							 	BigDecimal upvalue=(BigDecimal)en1.get("upvalue");	
							 	BigDecimal downvalue=(BigDecimal)en1.get("downvalue");	
							 	project1.add(corestr); 
							 	project2.add(upvalue); 
							 	project3.add(downvalue); 

							 	if(!xdataList.contains(dateflag)){			
							 		xdataList.add(dateflag);				//依次加入x轴期数，datelist中已经排好顺序
							 	}
						 	}
						 }
					}	
					 if(!fl){												//相应期数没有对应数据，赋值0
						 BigDecimal corestr=null;	
						 project1.add(corestr);
						 project2.add(corestr);
						 project3.add(corestr);
						 if(!xdataList.contains(dateflag)){
						 	xdataList.add(dateflag);
						 }
					 }
				 }
			 	highchart1.setData(project1);
			 	highchart2.setData(project2);
			 	highchart3.setData(project3);
			 	Iterator<Map<String,Object>> itList1=list1.iterator();
			 	while(itList1.hasNext()){
			 		Map<String,Object> map=itList1.next();
			 		if(strtemp11.equals(map.get("typeCd"))){
			 			strtemp11=(String) map.get("typeName");
			 		}
			 	}
			 	if(i==1){
			 		highchart1.setVisible(true);
			 		highchart2.setVisible(true);
			 		highchart3.setVisible(true);
			 	}else{
			 		highchart1.setVisible(false);
			 		highchart2.setVisible(false);
			 		highchart3.setVisible(false);
			 	}
				highchart1.setName(strtemp11);
				highchart2.setName(strtemp11+"行业指标均值上限");
				highchart2.setColor("red");
				highchart3.setName(strtemp11+"行业指标均值下限");
				highchart3.setColor("green");
				dataListcommon.add(highchart1);
				dataListcommon.add(highchart2);
				dataListcommon.add(highchart3);
			}
			jsonData.put("data"+num, dataListcommon); 
			jsonData.put("listXdata"+num, xdataList);	
		}
	
	public Iterator<String> ChangetoList(String zbid){				//由指标ID获取指标名称Iterator方法
		zbid=zbid.replace("'", "");
		zbid=zbid.trim();
		String[] abc=zbid.split(",");
        List<String> temp1=new ArrayList<String>();
        for(int i=0;i<abc.length;i++){
        	temp1.add(abc[i]);
        }
        Iterator<String> ittemp=temp1.iterator();
		return ittemp;
	}
	
	//暂时未用
	public String findnzbame(String strtemp11){					
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		String querySql="select * from  where  =''";
		try {
			rootdao.queryBySQL(querySql);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strtemp11;
		
	}
}
