package com.gbicc.highChar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.util.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import net.sf.json.JSONObject;

import com.gbicc.highChar.entity.Highcharts;
import com.gbicc.highChar.entity.commonHighcharts;
import com.gbicc.util.DateUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;


public class riskoverviewHigtCharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public riskoverviewHigtCharServlet() {
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
			
			String type=request.getParameter("type");
			String startDt=request.getParameter("startDt");
			String endDt=request.getParameter("endDt");
			String customerNum=request.getParameter("customerNum");
	        List<String> xdataList = new ArrayList<String>();  //x轴数据 list
	        JSONObject jsonData = new JSONObject();
	        StringBuffer sql=null;
	        StringBuffer sqldate=null;
	        if(type.equals("ldt")){
				List<String> strList=new ArrayList<String>();
				strList.add("财务风险预警");
				strList.add("账户账页预警");
				strList.add("政策流程风险预警");
				strList.add("关联关系风险预警");
				strList.add("征信风险预警");
	        	List<commonHighcharts> dataList = new ArrayList<commonHighcharts>();  //highchar  数据集合
			    sqldate=new StringBuffer("select X.FD_CAL_DATE as DATEFLAG from T_CM_RADAR_INDEX X order by X.FD_CAL_DATE desc fetch first 1 rows only");  
		        JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		        List<Map<String,Object>> listdate=jdbcTemplate.queryForList(sqldate.toString());
		        String dateFlag="-";
		        if(listdate.isEmpty()!=true){
		        	dateFlag=listdate.get(0).get("DATEFLAG").toString();
		        }
	        	
			 	List<BigDecimal> project1 = new ArrayList<BigDecimal>(); 
			 	commonHighcharts highchart1 = new commonHighcharts(); 
			 	sql=new StringBuffer("SELECT b.FD_CAL_DATE as DATEFLAG,b.FD_RUL_THEME_CD,b.FD_RUL_THEME_NAME as typename,b.FD_SCORE as TYPECORE from (SELECT t.FD_CAL_DATE ,t.FD_RUL_THEME_CD,t.FD_RUL_THEME_NAME ,t.FD_SCORE,t.rk from (select x.FD_CAL_DATE,x.FD_RUL_THEME_CD,x.FD_RUL_THEME_NAME,x.FD_SCORE,rank() over(partition by x.FD_RUL_THEME_CD order by x.FD_CAL_DATE desc) rk FROM ECUSER.T_CM_RADAR_INDEX x where 1=1 AND x.FD_CUSTOMER_CODE='"+customerNum+"')t) b where b.rk<2");
			 	List<Map<String,Object>> list=jdbcTemplate.queryForList(sql.toString());
			 	
			 	for(int i=0;i<strList.size();i++){
			 		Iterator<Map<String,Object>> itList=list.iterator();
			 		String itListstr=(String)strList.get(i);
			 		Boolean flag=false;
			 		BigDecimal corestrnull=null;
			 		while(itList.hasNext()){
			 			String temp=(String)itList.next().get("typename");
			 			if(itListstr.equals(temp)){
			 				flag=true;
			 			}
			 		}
			 		if(flag==false){
			 			Map<String,Object> maptempMap= new HashMap<String, Object>();
			 			maptempMap.put("typename", itListstr);
			 			maptempMap.put("TYPECORE", corestrnull);
			 			maptempMap.put("DATEFLAG", dateFlag);
			 			list.add(maptempMap);
			 		}
			 	}
			 	for(Map<String,Object> en1:list){
			 			if(dateFlag.equals(en1.get("DATEFLAG").toString())){
				            xdataList.add((String)en1.get("typename")); 
				            BigDecimal corestr=(BigDecimal)en1.get("typecore");	
				            project1.add(corestr);  
			 			}else{
				            xdataList.add((String)en1.get("typename")); 
				            BigDecimal corestr=null;	
				            project1.add(corestr);  
			 			}
				 } 
		        highchart1.setData(project1);
		        highchart1.setName(dateFlag);
		        highchart1.setpointPlacement("on");
		        dataList.add(highchart1);
		        jsonData.put("data", dataList); 
				 List<String> listtemp=new ArrayList<String>();
				 Iterator<String> ittemp=xdataList.iterator();
				 while(ittemp.hasNext())
				 {
					 String temp=(String)ittemp.next();
					 if(!listtemp.contains(temp))
						 listtemp.add(temp);
				 }
				 jsonData.put("listXdata", listtemp);
	        }
	        /*-- 预警等级趋势图 --*/
	        if(type.equals("ldt")){ 
		        sql=new StringBuffer("select ti.PL as typename ,ti.WARN_LEVEL as typecore,ti.WARN_DATE as dateflag FROM ECUSER.T_CM_CUSTOMER_WARN_LEV_DTL_V ti where 1=1 AND CUSTOMER_NUM= '"+customerNum+"'");
		        Calendar cd=Calendar.getInstance();
		        cd.set(Calendar.DAY_OF_MONTH, 0);
		        Date endDate=cd.getTime();
		        Date t2=new Date();
		        List<String> datelist= new ArrayList<String>();
				Calendar ctimetemp=Calendar.getInstance();
				ctimetemp.setTime(endDate);
		        cd.add(Calendar.MONTH,-6);
		        Date startDt1=cd.getTime();
        		for(int i=1;i<7;i++){
        			t2=ctimetemp.getTime();
        			t2=DateUtils.getLastDayOfMonth(t2);
		    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    		String datea=sdf.format(t2);
		    		datelist.add(datea);
		    		ctimetemp.add(Calendar.MONTH,-1);
        		}
        		Collections.reverse(datelist);
		        sql.append(" and  ti.WARN_DATE between '"+String.format("%tF", startDt1)+"' AND '"+String.format("%tF", endDate)+"'");		        		        
		        sql.append(" order by ti.WARN_DATE ");
		        JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql.toString());
		        xdataList = new ArrayList<String>();
		        List<Highcharts>  dataListcommon = new ArrayList<Highcharts>();
		        List<String> temp1=new ArrayList<String>();
		        temp1.add("年度预警等级");
		        temp1.add("月度预警等级");
		        Iterator<String> tempit=temp1.iterator();
		        while(tempit.hasNext()){
		        	Iterator<String> dateit=datelist.iterator();
		        	String strtemp11=(String)tempit.next();
					List<BigDecimal> project1 = new ArrayList<BigDecimal>(); 
					Highcharts highchart1 = new Highcharts(); 
					while(dateit.hasNext()){									//期数循环匹配--start
						 boolean fl=false;										//fl 相应期数有数据true,否则false
						 String dateflag=(String)dateit.next();
						 for(Map<String,Object> en1:list){						//遍历数据List
							 String datetem=String.format("%tF", en1.get("dateflag"));
							 if(dateflag.equals(datetem)){
								if(strtemp11.equals((String)en1.get("typename"))){
								 	fl=true;										//数据List匹配到期数，进入设置数据。
								 	String te=(String)en1.get("typecore");
								 	Long lo=Long.parseLong(te);
								 	BigDecimal corestr=BigDecimal.valueOf(lo+0.5);	
								 	project1.add(corestr); 
								 	if(!xdataList.contains(dateflag)){			
								 		xdataList.add(dateflag);				//依次加入x轴期数，datelist中已经排好顺序
								 	}
								}
							 }
						}	
						 if(!fl){												//相应期数没有对应数据，赋值0
							 BigDecimal corestr=null;	
							 project1.add(corestr); 
							 if(!xdataList.contains(dateflag)){
							 	xdataList.add(dateflag);
							 }
						 }
					}
				 	highchart1.setData(project1);
					highchart1.setName(strtemp11);
					dataListcommon.add(highchart1);
		        }
				jsonData.put("data3", dataListcommon); 
				jsonData.put("listXdata3", xdataList);	
	        }
	        /*-- 预警分布情况图 --*/
	        if(type.equals("yjfb")){ 	 
		        String flag=request.getParameter("flag");
		        if(startDt.equals("00000000")){
		        	Calendar cd=Calendar.getInstance();
		        	Date endDate=cd.getTime();
		    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		    		endDt=sdf.format(endDate);
		    		cd.add(Calendar.MONTH, -6);
		    		endDate=cd.getTime();
		    		startDt=sdf.format(endDate);
		        }
		        sql=new StringBuffer("select V.FD_RUL_THEME_CD as typename ,COUNT(V.FD_RUL_THEME_CD) as typecore FROM T_CM_RISK_VIEW_RUL_WARNING_V V  where 1=1 and V.FD_RUL_THEME_CD IS NOT NULL");
		        if(StringUtils.hasText(startDt)){
		        	sql.append(" AND V.FD_WARN_DT BETWEEN TO_DATE('" + startDt+"','yyyy-mm-dd')");
		        }
		        if(StringUtils.hasText(endDt)){
		        	sql.append(" and TO_DATE('" + endDt+"','yyyy-mm-dd')");
		        }else{
		        	sql.append(" and 1=0");
		        }
		        if(StringUtils.hasText(flag)){
		        	if(flag.equals("true")){
		        		sql.append(" and V.FD_ELIMINATE_FLAG='0'");
		        	}
		        }

		        sql.append(" AND V.FD_CUSTOMER_ID='"+customerNum+"' GROUP BY V.FD_RUL_THEME_CD");
		        StringBuffer nameQuery=new StringBuffer("SELECT C.DATA_TYPE_NO,c.DATA_NO as typeCd,C.DATA_NAME as typename FROM ECUSER.DATA_DIC C where C.DATA_TYPE_NO='212' AND C.DATA_TYPE_NAME='规则主题'");
		        JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql.toString());
		        List<Map<String,Object>> namelist=jdbcTemplate.queryForList(nameQuery.toString());
		        List<String> xdataListtemp= new ArrayList<String>();
		        xdataList = new ArrayList<String>();
		        List<Highcharts>  dataListcommon = new ArrayList<Highcharts>();
		        List<String> temp1=new ArrayList<String>();
		        Map<String,String> mapx=new HashMap<String, String>();
		        for(Map<String,Object> en:namelist){
		        	if(!temp1.contains((String)en.get("typeCd"))){
		        		temp1.add((String)en.get("typeCd"));
		        		mapx.put((String)en.get("typeCd"),(String)en.get("typename"));
		        	}
		        }
				Iterator<String> ittemp=temp1.iterator();
				String datetem=startDt+"-"+endDt;
				boolean xflag=false;
				while(ittemp.hasNext()){
					 String strtemp11=(String)ittemp.next();
					 List<BigDecimal> project1 = new ArrayList<BigDecimal>(); 
					 Highcharts highchart1 = new Highcharts(); 
					 for(Map<String,Object> en1:list){
					 	if(strtemp11.equals((String)en1.get("typename"))){
					 		xflag=true;
						 	BigDecimal corestr=new BigDecimal((Integer)en1.get("typecore"));
						 	project1.add(corestr); 
						 	xdataList.add(datetem);
						 	xdataListtemp.add(" ");
					 	}
					}
					 if(!xflag){
						 	BigDecimal corestr=BigDecimal.ZERO;
						 	project1.add(corestr); 
						 	xdataList.add(datetem);
						 	xdataListtemp.add(" ");
					 }
				 	highchart1.setData(project1);
					highchart1.setName(mapx.get(strtemp11));
					dataListcommon.add(highchart1);
				}
				jsonData.put("data1", dataListcommon); 
				jsonData.put("listXdata1", xdataList);
				jsonData.put("listXdatatemp", xdataListtemp);
	        }
			/*-- 预警数量统计图 --*/
	        if(type.equals("kjt")){ 
	        	String flag=request.getParameter("editor");
	        	java.util.Date t=new java.util.Date();
	        	java.util.Date t1=null;
	        	String koujing=request.getParameter("koujing");
	        	String datequery="";
	        	String datea="";
	        	String dateb="";
	        	List<String> datelist=new ArrayList<String>();
	        	if(koujing.equals("710")){
	        		Calendar ctime=Calendar.getInstance();
	        		ctime.add(Calendar.MONTH, -1);
	        		t=ctime.getTime();
	        		Calendar ctimetemp =  Calendar.getInstance();
	        		ctimetemp.setTime(t);
	        		ctime.add(Calendar.MONTH, -5);
	        		t1=ctime.getTime();
	        		datequery=" AND KJ= '"+4+"'";
	        		java.util.Date t2=null;
	        		for(int i=1;i<7;i++){
	        			t2=ctimetemp.getTime();
			    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			    		datea=sdf.format(t2);
			    		datelist.add(datea);
			    		ctimetemp.add(Calendar.MONTH,-1);
	        		}
	        		Collections.reverse(datelist);
	        	}else if(koujing.equals("707")){
	        		Calendar ctime=Calendar.getInstance();
	        		ctime.add(Calendar.YEAR, -1);
	        		t=ctime.getTime();
	        		Calendar ctimetemp =  Calendar.getInstance();
	        		ctimetemp.setTime(t);
	        		ctime.add(Calendar.YEAR, -5);
	        		t1=ctime.getTime();
	        		datequery=" AND KJ= '"+1+"'";
	        		java.util.Date t2=null;
	        		for(int i=1;i<7;i++){
	        			t2=ctimetemp.getTime();
			    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			    		datea=sdf.format(t2);
			    		datelist.add(datea);
			    		ctimetemp.add(Calendar.YEAR,-1);
	        		}
	        		Collections.reverse(datelist);
	        	}else if(koujing.equals("708")){
	        		Calendar ctime=Calendar.getInstance();
	        		int month=ctime.get(Calendar.MONTH);
	        		if(month<=6){
	        			ctime.set(Calendar.MONTH, 0);
	        		}
	        		if(month>6){
	        			ctime.set(Calendar.MONTH, 5);
	        		}
	        		ctime.add(Calendar.MONTH, -1);
	        		t=ctime.getTime();
	        		Calendar ctimetemp =  Calendar.getInstance();
	        		ctimetemp.setTime(t);
	        		ctime.add(Calendar.MONTH, -35);
	        		t1=ctime.getTime();
	        		datequery=" AND KJ= '"+2+"'";
	        		java.util.Date t2=null;
	        		for(int i=1;i<7;i++){
	        			t2=ctimetemp.getTime();
			    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			    		datea=sdf.format(t2);
			    		datelist.add(datea);
			    		ctimetemp.add(Calendar.MONTH,-6);
	        		}
	        		Collections.reverse(datelist);
	        	}else if(koujing.equals("709")){
	        		Calendar ctime=Calendar.getInstance();
	        		int month=ctime.get(Calendar.MONTH)+1;
	        		if(month>=1&&month<=3){
	        			ctime.set(Calendar.MONTH, 0);
	        		}
	        		if(month>=4&&month<=6){
	        			ctime.set(Calendar.MONTH, 3);
	        		}
	        		if(month>=7&&month<=9){
	        			ctime.set(Calendar.MONTH, 6);
	        		}
	        		if(month>=10&&month<=12){
	        			ctime.set(Calendar.MONTH, 9);
	        		}
	        		ctime.add(Calendar.MONTH, -1);
	        		t=ctime.getTime();
	        		Calendar ctimetemp = Calendar.getInstance();
	        		ctimetemp.setTime(t);
	        		ctime.add(Calendar.MONTH, -17);
	        		java.util.Date t2=null;
	        		t1=ctime.getTime();
	        		datequery=" AND KJ= '"+3+"'";
	        		for(int i=1;i<7;i++){
	        			t2=ctimetemp.getTime();
			    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			    		datea=sdf.format(t2);
			    		datelist.add(datea);
			    		ctimetemp.add(Calendar.MONTH,-3);
	        		}
	        		Collections.reverse(datelist);
	        	}
	        	if(koujing.equals("707")){
		    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		    		datea=sdf.format(t);
		    		dateb=sdf.format(t1);
	        	}else{
		    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		    		datea=sdf.format(t);
		    		dateb=sdf.format(t1);
	        	}
	        sql=new StringBuffer("SELECT V.TJRQ AS dateflag,V.SL AS typecore,V.FD_RUL_THEME_CD AS typename FROM T_CM_WARNGIN_STATISTICS_V V WHERE 1=1 ");
	        if(StringUtils.hasText(flag)){
	        	if(flag.equals("true")){
	        		sql=new StringBuffer(" SELECT V.TJRQ AS dateflag,V.SL AS typecore,V.FD_RUL_THEME_CD AS typename FROM T_CM_WARNGIN_STATISTICS_YPC_V V WHERE 1=1 and V.FD_ELIMINATE_FLAG<>'1' ");
	        	}
	        }
	        sql.append("  AND V.TJRQ BETWEEN '"+dateb+"' and '"+datea+"'");
	        sql.append(datequery);
	        sql.append(" AND V.CUSTOMER_ID='"+customerNum+"'");
	        StringBuffer nameQuery=new StringBuffer("SELECT C.DATA_TYPE_NO,c.DATA_NO as typeCd,C.DATA_NAME as typename FROM ECUSER.DATA_DIC C where C.DATA_TYPE_NO='212' AND C.DATA_TYPE_NAME='规则主题'");
	        JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
	        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql.toString());
	        List<Map<String,Object>> namelist=jdbcTemplate.queryForList(nameQuery.toString());
	        xdataList = new ArrayList<String>();
	        List<Highcharts>  dataListcommon = new ArrayList<Highcharts>();
	        List<String> temp1=new ArrayList<String>();
	        Map<String,String> mapx=new HashMap<String, String>();
	        for(Map<String,Object> en:namelist){
	        	if(!temp1.contains((String)en.get("typeCd"))){
	        		temp1.add((String)en.get("typeCd"));
	        		mapx.put((String)en.get("typeCd"),(String)en.get("typename"));
	        	}
	        }
			Iterator<String> ittemp=temp1.iterator();
			while(ittemp.hasNext()){										//主题循环匹配--start
				 String strtemp11=(String)ittemp.next();
				 List<BigDecimal> project1 = new ArrayList<BigDecimal>(); 
				 Highcharts highchart1 = new Highcharts(); 
				 Iterator<String> dateit=datelist.iterator();
				 while(dateit.hasNext()){									//期数循环匹配--start
					 boolean fl=false;										//fl 相应期数有数据true,否则false
					 String dateflag=(String)dateit.next();
					 for(Map<String,Object> en1:list){						//遍历数据List
						 String datetem=((String)en1.get("dateflag")).trim();
						 datetem=datetem.trim();
						 if(dateflag.equals(datetem)){						//数据List匹配到期数，进入设置数据。
						 	if(strtemp11.equals((String)en1.get("typename"))){
							 	fl=true;
							 	BigDecimal corestr=new BigDecimal((Integer)en1.get("typecore"));	
							 	project1.add(corestr); 
							 	if(!xdataList.contains(dateflag)){			
							 		xdataList.add(dateflag);				//依次加入x轴期数，datelist中已经排好顺序
							 	}
						 	}
						 }
					}	
					 if(!fl){												//相应期数没有对应数据，赋值0
						 BigDecimal corestr=null;	
						 project1.add(corestr); 
						 if(!xdataList.contains(dateflag)){
						 	xdataList.add(dateflag);
						 }
					 }
				 }
			 	highchart1.setData(project1);
				highchart1.setName(mapx.get(strtemp11));
				dataListcommon.add(highchart1);
			}
			jsonData.put("data2", dataListcommon); 
			jsonData.put("listXdata2", xdataList);	
	        }
	        String result=jsonData.toString();
	        pw.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
