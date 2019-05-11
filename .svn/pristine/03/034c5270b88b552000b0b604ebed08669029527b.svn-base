package com.gbicc.testOut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
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
			System.out.println("----------------代码生成开始-----------------------");
			change("应收账款","流动资产合计","01","流动比率","T_CM_FINANCE_STATEMENT_CODE");
			System.out.println("----------------代码生成完成-----------------------");
			pw.println();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	public  void change(String a,String b,String FINANCE_REPORT_SORT_CD,String name,String tablename){
		String PROJECT_CD_A="";
		String PROJECT_CD_B="";
		StringBuffer sqla=new StringBuffer("SELECT PROJECT_CD as PROJECT_CD FROM "+tablename+" CO  WHERE CO.PROJECT_NAME= ");
		sqla.append("'"+a+"' AND FINANCE_REPORT_SORT_CD='"+FINANCE_REPORT_SORT_CD+"'");
		StringBuffer sqlb=new StringBuffer("SELECT PROJECT_CD as PROJECT_CD FROM "+tablename+" CO  WHERE CO.PROJECT_NAME= ");
		sqlb.append("'"+b+"' AND FINANCE_REPORT_SORT_CD='"+FINANCE_REPORT_SORT_CD+"'");
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		 

		List<Map<String,Object>> lista=jdbcTemplate.queryForList(sqla.toString());
		Iterator<Map<String, Object>> ita=lista.iterator();
		while(ita.hasNext()){
			PROJECT_CD_A=(String)ita.next().get("PROJECT_CD");
		}
		List<Map<String,Object>> listb=jdbcTemplate.queryForList(sqlb.toString());
		Iterator<Map<String, Object>> itb=listb.iterator();
		while(itb.hasNext()){
			PROJECT_CD_B=(String)itb.next().get("PROJECT_CD");
		}
		
		String command="SELECT DECODE(IND"+PROJECT_CD_B+",0,0,IND"+PROJECT_CD_A+"/IND"+PROJECT_CD_B+")  VAK FROM T_CM_FINANCE_STATEMENT_DATA_01 T ----"+name;
		System.out.println(command);
	}
	
	
}
