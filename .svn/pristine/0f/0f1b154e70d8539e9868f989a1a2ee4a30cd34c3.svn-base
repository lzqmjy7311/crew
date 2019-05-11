package com.gbicc.highChar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ZxinfoGetHigtCharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ZxinfoGetHigtCharServlet() {
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
			
			String indexId=request.getParameter("indexId");
			String fdReportdate=request.getParameter("fdReportdate");
			String customerNum=request.getParameter("customerNum");//客户号 
			String indexName=request.getParameter("indexName");
			String loanCardNum=request.getParameter("loanCardNum");

			Highcharts highchart1 = new Highcharts(); 
			List<Highcharts> dataList = new ArrayList<Highcharts>();  //highchar  数据集合
	        List<String> xdataList = new ArrayList<String>();  //x轴数据 list
	        List<BigDecimal> project1 = new ArrayList<BigDecimal>(); 

	        JSONObject jsonData = new JSONObject();
	        
	        StringBuffer sql=null;
	        
	        sql=new StringBuffer(" SELECT TO_CHAR(T1.FD_REPORTDATE,'YYYY-MM-DD') AS FDREPORTDATE,  T1."+ indexId+" AS VAL1 from ECUSER.T_CM_COMPANY_CREDIT_INDEX T1 where 1=1 and FD_LOANCARDNO= '"+loanCardNum+"' ");
	      
	        if(StringUtils.hasText(fdReportdate)){
	        	sql.append("and  date(FD_REPORTDATE) <='" + fdReportdate+"' order by FD_REPORTDATE desc fetch first 6 rows only");
	        }else{sql.append(" and 1=0");}
	        
	        JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
			 List<Map<String,Object>> list=jdbcTemplate.queryForList(sql.toString());
			 for(Map<String,Object> en:list){
		            xdataList.add((String)en.get("FDREPORTDATE")); 
		            BigDecimal a=null;
		            if(en.get("VAL1")!=null){
			            if(en.get("VAL1").getClass().hashCode()==Integer.class.hashCode()){
			            	a=new BigDecimal((Integer)en.get("VAL1"));
			            	project1.add(a);  
			            }else if(en.get("VAL1").getClass().hashCode()==BigDecimal.class.hashCode()){
			            	a=(BigDecimal) en.get("VAL1");
			            	project1.add(a);  
			            }
		            }else{
		            	project1.add(a);  
		            }
		            
			 }
			 
		       
			 	Collections.reverse(project1);
		        highchart1.setData(project1);
		        highchart1.setName(indexName);
		        dataList.add(highchart1);
		        Collections.reverse(xdataList);
		        jsonData.put("data", dataList);  
		        jsonData.put("listXdata", xdataList);  
		          
			 
			String result=jsonData.toString();
			pw.println(result);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
