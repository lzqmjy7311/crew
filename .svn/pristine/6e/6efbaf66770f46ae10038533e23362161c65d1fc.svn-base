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

public class TestOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String a;
	String b;
	public TestOutServlet() {
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
			
			a=request.getParameter("a");
			b=request.getParameter("b");
			String functionname=request.getParameter("functionname");//客户号 
			String tablename=request.getParameter("tablename");
			String zbname=request.getParameter("zbname");//客户号 
			String zbnum=request.getParameter("zbnum");
			String by=request.getParameter("by");//客户号 
			String id=request.getParameter("id");//客户号 
			String[] atemp=a.split(",");
			String[] btemp=b.split(",");
			System.out.println("----------------代码生成开始-----------------------");
			String jsonstr=change(a,b,id,functionname,tablename,zbname,zbnum);
			System.out.println("----------------代码生成完成-----------------------");
//			String jsonstr="-- 3400001 净利润增长率(环比) = (本期五、净利润(净亏损以“—”号填列)-上期五、净利润(净亏损以“—”号填列))/上期五、净利润(净亏损以“—”号填列)--季报<br>INSERT INTO T_CM_FINANCE_INDEX_DATA_G  (INDEX_DATA_ID,CUSTOMER_FINANCE_ID,INDEX_VALUE_DATA_TYPE,STRING_TYPE,INDEX_DISP,INDEX_CD,CAL_DATE,CUSTOMER_NUM,FINANCE_STATEMENT_TYPE_CD,FINANCE_STATEMENT_DEADLINE)<br>SELECT  UUID(),T.CUSTOMER_FINANCE_ID,ROUND(T.VAL,6),NULL,\\'净利润增长率(环比) = (本期五、净利润(净亏损以“—”号填列)-上期五、净利润(净亏损以“—”号填列))/上期五、净利润(净亏损以“—”号填列)--季报 \\',\\'3400001\\',CAL_DATE1,T.CUSTOMER_NUM,T.FINANCE_STATEMENT_TYPE_CD,T.FINANCE_STATEMENT_DEADLINE FROM ( SELECT E.CUSTOMER_FINANCE_ID CUSTOMER_FINANCE_ID, CASE  WHEN (E.e00030016 -B.e00030016 )=0 AND  B.e00030016  =0  THEN NULL  WHEN (E.E00030016 -B.E00030016 )  is  null or (B.e00030016 ) is null THEN NULL  WHEN (E.E00030016 -B.E00030016 )<>0 AND B.e00030016  =0  THEN (E.E00030016 -B.E00030016 )/0.000000000001  ELSE (E.E00030016 -B.E00030016 )/B.E00030016   END AS VAL, E.CUSTOMER_NUM,  E.FINANCE_STATEMENT_TYPE_CD, E.FINANCE_STATEMENT_DEADLINE   FROM  T_CM_FINANCE_STATEMENT_DATA_V_03 E, T_CM_FINANCE_STATEMENT_DATA_V_03 B , T_DIM_DATE T WHERE E.CUSTOMER_FINANCE_ID = B.CUSTOMER_FINANCE_ID AND E.FINANCE_STATEMENT_TYPE_CD=B.FINANCE_STATEMENT_TYPE_CD AND E.FINANCE_STATEMENT_TYPE_CD=\\'3\\' AND E.FINANCE_STATEMENT_DEADLINE=T.FD_DT AND B.FINANCE_STATEMENT_DEADLINE=T.FD_LAST_Q) T;<br><br>";
			pw.println("{'url':'"+jsonstr+"'}");
//  -- 3400001 净利润增长率(环比) = (本期五、净利润(净亏损以“—”号填列)-上期五、净利润(净亏损以“—”号填列))/上期五、净利润(净亏损以“—”号填列)--季报<br>INSERT INTO T_CM_FINANCE_INDEX_DATA_G  (INDEX_DATA_ID,CUSTOMER_FINANCE_ID,INDEX_VALUE_DATA_TYPE,STRING_TYPE,INDEX_DISP,INDEX_CD,CAL_DATE,CUSTOMER_NUM,FINANCE_STATEMENT_TYPE_CD,FINANCE_STATEMENT_DEADLINE)<br>SELECT  UUID(),T.CUSTOMER_FINANCE_ID,ROUND(T.VAL,6),NULL,\'净利润增长率(环比) = (本期五、净利润(净亏损以“—”号填列)-上期五、净利润(净亏损以“—”号填列))/上期五、净利润(净亏损以“—”号填列)--季报 \',\'3400001\',CAL_DATE1,T.CUSTOMER_NUM,T.FINANCE_STATEMENT_TYPE_CD,T.FINANCE_STATEMENT_DEADLINE FROM ( SELECT E.CUSTOMER_FINANCE_ID CUSTOMER_FINANCE_ID, CASE  WHEN (E.e00030016 -B.e00030016 )=0 AND  B.e00030016  =0  THEN NULL  WHEN (E.E00030016 -B.E00030016 )  is  null or (B.e00030016 ) is null THEN NULL  WHEN (E.E00030016 -B.E00030016 )<>0 AND B.e00030016  =0  THEN (E.E00030016 -B.E00030016 )/0.000000000001  ELSE (E.E00030016 -B.E00030016 )/B.E00030016   END AS VAL, E.CUSTOMER_NUM,  E.FINANCE_STATEMENT_TYPE_CD, E.FINANCE_STATEMENT_DEADLINE   FROM  T_CM_FINANCE_STATEMENT_DATA_V_03 E, T_CM_FINANCE_STATEMENT_DATA_V_03 B , T_DIM_DATE T WHERE E.CUSTOMER_FINANCE_ID = B.CUSTOMER_FINANCE_ID AND E.FINANCE_STATEMENT_TYPE_CD=B.FINANCE_STATEMENT_TYPE_CD AND E.FINANCE_STATEMENT_TYPE_CD='3' AND E.FINANCE_STATEMENT_DEADLINE=T.FD_DT AND B.FINANCE_STATEMENT_DEADLINE=T.FD_LAST_Q) T;<br><br>
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	//change 方法   获取输入参数atemp1,以逗号分隔成数组atemp[],for循环拿出单个参数anum，通过deletechar()方法获得公式中包含字段代码anumtemp[]，通过for循环取出单个字段并查询对应的名称a，写入sql查询语句模板。
	public  String change(String atemp1,String btemp1,String zbid,String name,String tablename,String zbnametemp,String zbnumtemp){
		
		String json="";
		String[] atemp=atemp1.split(",");
		String[] btemp=btemp1.split(",");
		String[] zbnametemp1=zbnametemp.split(",");
		String[] zbnumtemp1=zbnumtemp.split(",");
		StringBuffer jsonstr=new StringBuffer("");
		String flaggs="1";
	if(flaggs.equals("1")){
		for(int i=0;i<atemp.length;i++){
			List zbidarray=new ArrayList();
			
			String PROJECT_NAME_A="";
			String PROJECT_NAME_B="";
			String anum=atemp[i];
			String bnum="";
			if(btemp[i].equals("")||btemp[i]==null){
				bnum="";
			}else{
				bnum=btemp[i];
			}
			String[] anumtemp=deletechar(anum);
			String[] bnumtemp={};
			String outsql1="";
			if(bnum.equals("")){
				outsql1=anum;
			}
			else{
				bnumtemp=deletechar(bnum);
				outsql1=anum+"/"+bnum;
			}
			JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
			for(int j=0;j<anumtemp.length;j++){
				
				String flaga="";
				String a=anumtemp[j];//1,2,3
				zbid=a.substring(2, 4);
				if(!zbidarray.contains(zbid)){
					zbidarray.add(zbid);
				}
				
				
				StringBuffer sqla=new StringBuffer("SELECT PROJECT_NAME as PROJECT_NAME FROM T_CM_FINANCE_STATEMENT_CODE CO  WHERE CO.PROJECT_CD= ");
				sqla.append("'"+a+"' AND FINANCE_REPORT_SORT_CD='"+zbid+"'");
				List<Map<String,Object>> lista=jdbcTemplate.queryForList(sqla.toString());
				Iterator<Map<String, Object>> ita=lista.iterator();
				while(ita.hasNext()){
					flaga=(String)ita.next().get("PROJECT_NAME");
				}
				
				String abc="e"+a;
				abc=abc.trim();
				anum=anum.replaceAll(abc, "T"+zbid+"."+abc);
				abc=abc.trim();
				outsql1=outsql1.replace(abc,flaga);
			}
			for(int j=0;j<bnumtemp.length;j++){
				String flagb="";
				String b=bnumtemp[j];//1,2,3
				zbid=b.substring(2, 4);
				if(!zbidarray.contains(zbid)){
					zbidarray.add(zbid);
				}
				StringBuffer sqlb=new StringBuffer("SELECT PROJECT_NAME as PROJECT_NAME FROM T_CM_FINANCE_STATEMENT_CODE CO  WHERE CO.PROJECT_CD= ");
				sqlb.append("'"+b+"' AND FINANCE_REPORT_SORT_CD='"+zbid+"'");
				if(b.equals("")){
					sqlb.append(" and 1=0 ");
				}
				List<Map<String,Object>> listb=jdbcTemplate.queryForList(sqlb.toString());
				Iterator<Map<String, Object>> itb=listb.iterator();
				while(itb.hasNext()){
					flagb=(String)itb.next().get("PROJECT_NAME");
				}
				b=b.trim();
				String abc="e"+b;
				bnum=bnum.replaceAll(abc, "T"+zbid+"."+abc);
				outsql1=outsql1.replaceAll(abc, flagb);
				
			}
			StringBuffer outfin=new StringBuffer("-- "+zbnumtemp1[i]+" "+zbnametemp1[i]+" = "+outsql1);
		    StringBuffer outfin1=new StringBuffer("INSERT INTO T_CM_FINANCE_INDEX_DATA_G  (INDEX_DATA_ID,CUSTOMER_FINANCE_ID,INDEX_VALUE_DATA_TYPE,STRING_TYPE,INDEX_DISP,INDEX_CD,CAL_DATE,CUSTOMER_NUM,FINANCE_STATEMENT_TYPE_CD,FINANCE_STATEMENT_DEADLINE)<br>");
//			outfin1.append("SELECT  DECODE("+bnum+",0,0,"+anum+"/"+bnum+")  VAK FROM T_CM_FINANCE_STATEMENT_DATA_"+zbid);
			outfin1.append("SELECT  UUID(),T.CUSTOMER_FINANCE_ID,ROUND(T.VAL,6),NULL,\\'"+zbnametemp1[i]+" = "+outsql1+" \\',\\'"+zbnumtemp1[i]+"\\',CAL_DATE1,T.CUSTOMER_NUM,T.FINANCE_STATEMENT_TYPE_CD,T.FINANCE_STATEMENT_DEADLINE FROM (SELECT T01.CUSTOMER_FINANCE_ID CUSTOMER_FINANCE_ID, CASE WHEN "+anum+"=0 AND "+bnum+" =0  THEN NULL WHEN "+anum+" <>0 AND "+bnum+" =0 THEN "+anum+"/0.000000000001 ELSE    "+anum+"/"+bnum+" END AS VAL,T01.CUSTOMER_NUM,T01.FINANCE_STATEMENT_TYPE_CD,T01.FINANCE_STATEMENT_DEADLINE FROM T_CM_FINANCE_STATEMENT_DATA_V_01 T01,");
			
//			SELECT  UUID(),T.CUSTOMER_FINANCE_ID,T.VAL,TO_CHAR(T.VAL),'"+zbnametemp1[i]+" = "+outsql1+" ','"+zbnumtemp1[i]+"',CAL_DATE FROM (SELECT T01.CUSTOMER_FINANCE_ID CUSTOMER_FINANCE_ID, CASE WHEN ("+anum+")=0 AND  ("+bnum+")=0  THEN NULL WHEN   ("+anum+")<>0 AND   ("+bnum+")=0 THEN  ("+anum+")/0.000000000001 ELSE    ("+anum+")/("+bnum+") END   AS VAL FROM 
			
			
			Iterator it=zbidarray.iterator();
			Iterator it1=zbidarray.iterator();
			int flag=0;
			while(it.hasNext()){
				String zbidtemp=(String)it.next();
				if(!zbidtemp.equals("01")){
					outfin1.append("T_CM_FINANCE_STATEMENT_DATA_V_"+zbidtemp+" T"+zbidtemp+",");
				}
				flag++;
			}
			
			outfin1.deleteCharAt(outfin1.length()-1);
			if(flag>=2){
				outfin1.append(" WHERE");
				while(it1.hasNext()){
					String zbidtemp=(String)it1.next();
					outfin1.append(" T"+zbidtemp+".CUSTOMER_FINANCE_ID =");
				}
				outfin1=outfin1.deleteCharAt(outfin1.length()-1);
			}
			outfin1.append(") T;");
			System.out.print(outfin.toString()+"\n");
			System.out.print(outfin1.toString()+"\n");
			
			jsonstr.append(outfin+"<br>"+outfin1+"<br><br>");
			json=jsonstr.toString();
			
			
		}
	}else if(flaggs.equals("2")){
		for(int i=0;i<atemp.length;i++){
			List zbidarray=new ArrayList();
			
			String PROJECT_NAME_A="";
			String PROJECT_NAME_B="";
			String anum=atemp[i];
			String bnum="";
			if(btemp[i].equals("")||btemp[i]==null){
				bnum="";
			}else{
				bnum=btemp[i];
			}
			String[] anumtemp=deletechar(anum);
			String[] bnumtemp={};
			String outsql1="";
			if(bnum.equals("")){
				outsql1=anum;
			}
			else{
				bnumtemp=deletechar(bnum);
				outsql1=anum+"/"+bnum;
			}
			String aaa="";
			JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
//			for(int j=0;j<anumtemp.length;j++){
//				
				String flaga="";
				String a=anumtemp[0];//1,2,3
				zbid=a.substring(2, 4);
//				if(!zbidarray.contains(zbid)){
//					zbidarray.add(zbid);
//			}
				
				
				StringBuffer sqla=new StringBuffer("SELECT PROJECT_NAME as PROJECT_NAME FROM T_CM_FINANCE_STATEMENT_CODE CO  WHERE CO.PROJECT_CD= ");
				sqla.append("'"+a+"' AND FINANCE_REPORT_SORT_CD='"+zbid+"'");
				List<Map<String,Object>> lista=jdbcTemplate.queryForList(sqla.toString());
				Iterator<Map<String, Object>> ita=lista.iterator();
				while(ita.hasNext()){
					flaga=(String)ita.next().get("PROJECT_NAME");
				}
				
				String abc="e"+a;
				abc=abc.trim();
				anum=anum.replaceAll(abc, "T"+zbid+"."+abc);
				abc=abc.trim();
				outsql1=outsql1.replace(abc,"本期"+flaga);
				abc="b"+a;
				abc=abc.trim();
				outsql1=outsql1.replace(abc,"上期"+flaga);
				aaa=a;
//			}

			StringBuffer outfin=new StringBuffer("-- 半年报   "+zbnumtemp1[i]+" "+zbnametemp1[i]+" = "+outsql1);
		    StringBuffer outfin1=new StringBuffer("INSERT INTO T_CM_FINANCE_INDEX_DATA_G  (INDEX_DATA_ID,CUSTOMER_FINANCE_ID,INDEX_VALUE_DATA_TYPE,STRING_TYPE,INDEX_DISP,INDEX_CD,CAL_DATE,CUSTOMER_NUM,FINANCE_STATEMENT_TYPE_CD,FINANCE_STATEMENT_DEADLINE)<br>");
//			outfin1.append("SELECT  DECODE("+bnum+",0,0,"+anum+"/"+bnum+")  VAK FROM T_CM_FINANCE_STATEMENT_DATA_"+zbid);
			outfin1.append("SELECT  UUID(),T.CUSTOMER_FINANCE_ID,ROUND(T.VAL,6),NULL,\\'"+zbnametemp1[i]+" = "+outsql1+" \\',\\'"+zbnumtemp1[i]+"\\',CAL_DATE1,T.CUSTOMER_NUM,T.FINANCE_STATEMENT_TYPE_CD,T.FINANCE_STATEMENT_DEADLINE FROM ( SELECT E.CUSTOMER_FINANCE_ID CUSTOMER_FINANCE_ID, CASE  WHEN (E.e"+aaa+"-B.e"+aaa+")=0 AND  B.e"+aaa+" =0  THEN NULL  WHEN (E.E"+aaa+"-B.E"+aaa+")  is  null or (B.e"+aaa+") is null THEN NULL  WHEN (E.E"+aaa+"-B.E"+aaa+")<>0 AND B.e"+aaa+" =0  THEN (E.E"+aaa+"-B.E"+aaa+")/0.000000000001  ELSE (E.E"+aaa+"-B.E"+aaa+")/B.E"+aaa+"  END AS VAL, E.CUSTOMER_NUM,  E.FINANCE_STATEMENT_TYPE_CD, E.FINANCE_STATEMENT_DEADLINE   FROM  T_CM_FINANCE_STATEMENT_DATA_V_"+zbid+" E, T_CM_FINANCE_STATEMENT_DATA_V_"+zbid+" B , T_DIM_DATE T WHERE E.CUSTOMER_FINANCE_ID = B.CUSTOMER_FINANCE_ID AND E.FINANCE_STATEMENT_TYPE_CD=B.FINANCE_STATEMENT_TYPE_CD AND E.FINANCE_STATEMENT_TYPE_CD=\\'2\\' AND E.FINANCE_STATEMENT_DEADLINE=T.FD_DT AND B.FINANCE_STATEMENT_DEADLINE=T.FD_LAST_BN) T;"); 
			
//			FROM ( SELECT E.CUSTOMER_FINANCE_ID CUSTOMER_FINANCE_ID, CASE  WHEN (E.e"+a+"-B.e"+a+")=0 AND  B.e"+a+" =0  THEN NULL  WHEN (E.E"+a+"-B.E"+a+")  is  null or (B.e"+a+") is null THEN NULL  WHEN (E.E"+a+"-B.E"+a+")<>0 AND B.e"+a+" =0  THEN (E.E"+a+"-B.E"+a+")/0.000000000001  ELSE (E.E"+a+"-B.E"+a+")/B.E"+a+"  END AS VAL, E.CUSTOMER_NUM,  E.FINANCE_STATEMENT_TYPE_CD, E.FINANCE_STATEMENT_DEADLINE   FROM  T_CM_FINANCE_STATEMENT_DATA_V_"+zbid+" E, T_CM_FINANCE_STATEMENT_DATA_V_"+zbid+" B , T_DIM_DATE T WHERE E.CUSTOMER_FINANCE_ID = B.CUSTOMER_FINANCE_ID AND E.FINANCE_STATEMENT_TYPE_CD=B.FINANCE_STATEMENT_TYPE_CD AND E.FINANCE_STATEMENT_TYPE_CD='3' AND E.FINANCE_STATEMENT_DEADLINE=T.FD_DT AND B.FINANCE_STATEMENT_DEADLINE=T.FD_LAST_Q) T;  
/*			
			
			Iterator it=zbidarray.iterator();
			Iterator it1=zbidarray.iterator();
			int flag=0;
			while(it.hasNext()){
				String zbidtemp=(String)it.next();
				if(!zbidtemp.equals("01")){
					outfin1.append("T_CM_FINANCE_STATEMENT_DATA_V_"+zbidtemp+" T"+zbidtemp+",");
				}
				flag++;
			}
			
			outfin1.deleteCharAt(outfin1.length()-1);
			if(flag>=2){
				outfin1.append(" WHERE");
				while(it1.hasNext()){
					String zbidtemp=(String)it1.next();
					outfin1.append(" T"+zbidtemp+".CUSTOMER_FINANCE_ID =");
				}
				outfin1=outfin1.deleteCharAt(outfin1.length()-1);
			}
			outfin1.append(") T;");*/
			System.out.print(outfin.toString()+"\n");
			System.out.print(outfin1.toString()+"\n");
			
			jsonstr.append(outfin+"<br>"+outfin1+"<br><br>");
			json=jsonstr.toString();
			
			
		}
	}
		return json;
	}
	public String[] deletechar(String str){
		str=str.replaceAll("\\+"," ");
		str=str.replaceAll("\\-1"," ");
		str=str.replaceAll("\\-"," ");
		str=str.replaceAll("\\*"," ");
		str=str.replaceAll("100%"," ");
		str=str.replaceAll("/2"," ");
		str=str.replaceAll("\\["," ");
		str=str.replaceAll("\\]"," ");
		str=str.replaceAll("\\("," ");
		str=str.replaceAll("\\)"," ");
		str=str.replaceAll("b","e");
		
		str=str.trim();
		str=str.substring(1);
		String[] num=str.split("e");
		return num;
	}
	
	
}
