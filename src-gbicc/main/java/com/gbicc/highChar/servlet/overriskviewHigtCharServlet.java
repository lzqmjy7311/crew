package com.gbicc.highChar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
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
import com.gbicc.highChar.entity.HighchartsColor;
import com.gbicc.highChar.entity.commonHighcharts;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.util.DateUtils;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.util.ApplicationContextUtils;


public class overriskviewHigtCharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public overriskviewHigtCharServlet() {
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
		try{
			PrintWriter pw=response.getWriter();
			String userId = request.getParameter("userId");
			String roleId = request.getParameter("roleId");
			String brcode = request.getParameter("orgId");
			String startDt=request.getParameter("startDt");
			String endDt=request.getParameter("endDt");
			String customerManager=request.getParameter("customerManager");
			String warnLevel=request.getParameter("warnLevel");
			String rulTheme=request.getParameter("rulTheme");
			String flag=request.getParameter("flag");
			String operator=null;
			String deptCd=request.getParameter("deptCd");
	        List<String> temp1=new ArrayList<String>();
	        if(flag==null){
	        	flag="";
	        }
	        List<String> xdataList = new ArrayList<String>();  //x轴数据 list
	        JSONObject jsonData = new JSONObject();
	        StringBuffer sql=null;
	        Map<String,String> flagMap=new HashMap<String, String>();
//			flagMap.put("R04002004","财务风险预警");
//			flagMap.put("R04002005","账户账页预警");
//			flagMap.put("R04002003","政策流程风险预警");
//			flagMap.put("R04002006","关联关系风险预警");
//			flagMap.put("R04002002","征信风险预警");
//			flagMap.put("R04002001","重大事项预警");
	        Map<String,String> mapx=new HashMap<String, String>();
	        mapx.put("0", "绿");
	        mapx.put("1", "黄");
	        mapx.put("2", "橙");
	        mapx.put("3", "红");
        	java.util.Date t=new java.util.Date();
        	java.util.Date t1=null;
        	String datea="";
        	String dateb="";
        	List<String> datelist=new ArrayList<String>();
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
    		if((startDt!=null) && (endDt!=null)&&!(startDt.equals("")) && !(endDt.equals(""))){
    			datelist=getmonthList(startDt, endDt);
	    		dateb=startDt;
	    		datea=endDt;
    		}else{
        		Calendar ctime=Calendar.getInstance();
        		ctime.add(Calendar.MONTH, -1);
        		t=ctime.getTime();
        		Calendar ctimetemp =  Calendar.getInstance();
        		ctimetemp.setTime(t);
        		ctime.add(Calendar.MONTH, -5);
        		t1=ctime.getTime();
        		java.util.Date t2=null;
        		for(int i=1;i<7;i++){
        			t2=ctimetemp.getTime();
		    		datea=sdf.format(t2);
		    		datelist.add(datea);
		    		ctimetemp.add(Calendar.MONTH,-1);
        		}
        		Collections.reverse(datelist);
	    		datea=sdf.format(t);
	    		dateb=sdf.format(t1);
    		}
    		String sql1="";
    		String sql2="";
    		String sql3="";
    		String sql4="";
			String v1sql="";
			String v2sql="";
			if(!flag.equals("o2")){
	    		if(StringUtils.hasText(roleId)){
	    			if(roleId.equals("601")){
	    				operator=userId;
	    				if(StringUtils.hasText(operator)){
				    		sql2=" AND R.FD_OPERATOR='"+operator+"'";
				        	sql1=" WHERE R.FD_OPER_BANK='"+brcode+"'";
	    				}
	    			}else if(roleId.equals("559")||roleId.equals("560")||roleId.equals("111")){
	    		    	if(StringUtils.hasText(deptCd)){
	    		        	sql1=" WHERE R.FD_OPER_BANK='"+deptCd+"'";
	    		    	}
	    		    	if(StringUtils.hasText(customerManager)){
	    		    		sql2=" AND R.FD_OPERATOR='"+customerManager+"'";
	    		    	}
	
	    			}else if(StringUtils.hasText(brcode)){
	    				BctlService bctlService = BctlService.getInstance();
	    				String brcodes=bctlService.getAllSubListStr(brcode);
	    				TPlTaskService tts=TPlTaskService.getInstance();
	    				String userIds=tts.getUserIdsByBrcodes(brcodes)	;
	    				v1sql=" WHERE R.FD_OPER_BANK in ("+brcodes+")";
	    		    	if(StringUtils.hasText(deptCd)){
	    		        	sql1=" AND R.FD_OPER_BANK='"+deptCd+"'";
	    		    	}
	    		    	if(StringUtils.hasText(customerManager)){
	    		    		sql2=" AND R.FD_OPERATOR='"+customerManager+"'";
	    		    	}
	    			}else{
	    				v1sql=" WHERE 1=0";
	    			}
	    		}else{
					v1sql=" WHERE 1=0";
	    		}
	    		sql=new StringBuffer("SELECT COUNT(L.CUSTOMER_NUM) NB,L.WARN_Y_LEVEL WARNLEVEL,SUBSTR(TO_CHAR(L.WARN_DATE,'YYYYMMDD'),1,6) WARNDT FROM ECUSER.T_CM_CUSTOMER_WARN_LEV_DTL L LEFT JOIN T_CM_WARN_CUSTOMER R ON L.CUSTOMER_NUM=R.FD_CUSTCODE "+v1sql+sql1+sql2);
			}
		    if(flag.equals("o2")){
				if(StringUtils.hasText(roleId)){
					if(roleId.equals("601")){										//如果登录用户角色ID为601，则默认将其机构号，用户ID作为查询条件。前台已经做相关限制。
						operator=userId;
						if(StringUtils.hasText(operator)){										
				        	sql1=" WHERE T1.FD_ORGANKEY='"+brcode+"'";
				    		sql2=" AND T1.FD_HANDLER='"+operator+"'";
				        	sql3=" WHERE T3.FD_OPER_BANK='"+brcode+"'";
				    		sql4=" AND T3.FD_OPERATOR='"+operator+"'";
						}
					}else if(roleId.equals("559")||roleId.equals("560")||roleId.equals("111")){		//如果登录用户角色ID为559、560、111中的一个，则默认不设查询条件，根据其传入的查询条件进行查询。
						deptCd=request.getParameter("deptCd");
				    	if(StringUtils.hasText(deptCd)){
				        	sql1=" WHERE T1.FD_ORGANKEY='"+deptCd+"'";
				        	sql3=" WHERE T3.FD_OPER_BANK='"+deptCd+"'";
				    	}
				    	if(StringUtils.hasText(customerManager)){                  //如果客户经理有值，机构号空值，则SQL语句会报错。所以在前台进行了处理，不选择机构号，客户经理无法选取
				    		sql2=" AND T1.FD_HANDLER='"+customerManager+"'";
				    		sql4=" AND T3.FD_OPERATOR='"+customerManager+"'";
				    	}
					}else if(StringUtils.hasText(brcode)){							//如果当前登录用户角色ID不属于客户经理，不属于总行贷后岗或者超级管理员。则判断其为各分行支行管理岗，根据其所在机构号查询其机构号及下属机构号，以此作为条件限定查询范围
						BctlService bctlService = BctlService.getInstance();
						String brcodes=bctlService.getAllSubListStr(brcode);
						TPlTaskService tts=TPlTaskService.getInstance();
						String userIds=tts.getUserIdsByBrcodes(brcodes)	;
						v1sql=" WHERE T1.FD_ORGANKEY in ("+brcodes+")";
						v2sql=" WHERE T3.FD_OPER_BANK in ("+brcodes+")";
				    	if(StringUtils.hasText(deptCd)){
				        	sql1=" AND T1.FD_ORGANKEY='"+deptCd+"'";
				        	sql3=" AND T3.FD_OPER_BANK='"+deptCd+"'";
				    	}
				    	if(StringUtils.hasText(customerManager)){
				    		sql2=" AND T1.FD_HANDLER='"+customerManager+"'";
				    		sql4=" AND T3.FD_OPERATOR='"+customerManager+"'";
				    	}
					}else{															//如果当前登录用户角色ID既不属于客户经理601，不属于559、560总行贷后岗位，不属于111最高管理员，也没有所在机构号，就执行SQL where 1=0  ，查询空语句。
						v1sql=" WHERE 1=0";
						v2sql=" WHERE 1=0";
					}
				}else{																//如果没有获取当前登录用户角色ID，则执行空语句查询
					v1sql=" WHERE 1=0";
					v2sql=" WHERE 1=0";
				}
		        sql=new StringBuffer("SELECT COUNT(1) as nb,THEMECD,WARNDT FROM (SELECT  X.FD_RUL_THEME_CD AS THEMECD, X.FD_WARN_DT AS WARNDT,X.FD_CUSTOMER_ID AS FD_CUSTOMER_ID FROM "
		        		+ "(	SELECT T1.FD_FCETTYPECODE FD_CUSTOMER_ID, T1.FD_ELIMINATE_FLAG, T1.FD_RUL_THEME_CD, T1.FD_WARN_CODE , "
		        		+ "T1.FD_WARN_LEVEL, SUBSTR(TO_CHAR(T1.FD_WARN_DT,'YYYYMMDD'),1,6) FD_WARN_DT , T1.FD_RUL_NAME, T1.FD_WARN_STATUS, "
		        		+ "T1.FD_ELIMINATE_DT, T1.FD_WARNING_RELIEVE_DT, T1.FD_HANDLER, T1.FD_RUL_TYPE, T1.FD_RUL_CODE FROM T_CM_SINGLE_RUL_WARNING T1 "+v1sql+sql1+sql2
		        		+ " UNION ALL 	SELECT T3.FD_CUSTCODE FD_CUSTOMER_ID, T0.FD_WARN_ELIM_IS FD_ELIMINATE_FLAG, CASE WHEN T2.FD_START_TYPE='1' THEN 'R04002001' ELSE T0.FD_WARN_SUBJECT END FD_RUL_THEME_CD, T0.FD_WARN_CODE , "
		        		+ "T0.FD_WARN_LEVEL, SUBSTR(TO_CHAR(T0.FD_WARN_DATE,'YYYYMMDD'),1,6) FD_WARN_DT, T0.FD_WARN_NAME FD_RUL_NAME, T0.FD_WARN_STATUS, "
		        		+ "T0.FD_WARN_ELIM_DATE FD_ELIMINATE_DT, T0.FD_WARNING_RELIEVE_DT, T3.FD_OPERATOR FD_HANDLER , T0.FD_WARN_TYPE FD_RUL_TYPE, T0.FD_WARN_CODE "
		        		+ "FROM T_CM_WARN_TASK_REL T0 LEFT JOIN T_CM_WARN_TASK T2 ON T0.FD_TASK_ID=T2.FD_ID LEFT JOIN T_CM_WARN_CUSTOMER T3 ON T2.FD_CUSTOMER_ID=T3.FD_ID"+v2sql+sql3+sql4+") X "
		        		+ "WHERE X.FD_WARN_DT BETWEEN '"+dateb+"' and '"+datea+"'");
		    	if(rulTheme==null){
		    		rulTheme="";
		        }
		        String[] rultheme=rulTheme.split(",");
		        StringBuffer sb=new StringBuffer();
		        if((rultheme.length<2)&&(rultheme[0].equals(""))){
		        	temp1.add("R04002006");
		        	temp1.add("R04002002");
		        	temp1.add("R04002003");
		        	temp1.add("R04002004");
		        	temp1.add("R04002005");
		        	temp1.add("R04002001");
		        }else{
		            for(int i=0;i<rultheme.length;i++){
		            	if(rultheme[i].equals("")){
		            	}else{
		                	temp1.add(rultheme[i]);
		                	sb.append("'"+rultheme[i]+"',");
		            	}
		
		            }
		            sb.deleteCharAt(sb.length()-1);
		            sql.append(" AND X.FD_RUL_THEME_CD in ("+sb.toString()+")");
		        }
		        sql.append(" GROUP BY FD_RUL_THEME_CD, FD_WARN_DT , FD_CUSTOMER_ID) GROUP BY THEMECD,WARNDT");
		    }else{
		    	if(warnLevel==null){
		        	warnLevel="";
		        }
		        String[] warnlevel=warnLevel.split(",");
		        StringBuffer sb=new StringBuffer();
		        if((warnlevel.length<2)&&(warnlevel[0].equals(""))){
		        	temp1.add("0");
		        	temp1.add("1");
		        	temp1.add("2");
		        	temp1.add("3");
		        }else{
		            for(int i=0;i<warnlevel.length;i++){
		            	if(warnlevel[i].equals("")){
		            		
		            	}else{
		                	temp1.add(warnlevel[i]);
		                	sb.append("'"+warnlevel[i]+"',");
		            	}
		            }
		            sb.deleteCharAt(sb.length()-1);
		            sql.append(" AND L.WARN_Y_LEVEL in ("+sb.toString()+")");
		        }
		        sql.append(" GROUP BY WARN_Y_LEVEL, WARN_DATE ");
		    }
	        JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
	        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql.toString());
	        if(flag.equals("o2")){
	            StringBuffer nameQuery=new StringBuffer("SELECT C.DATA_TYPE_NO,c.DATA_NO as typeCd,C.DATA_NAME as typename FROM ECUSER.DATA_DIC C where C.DATA_TYPE_NO='727'");
	            List<Map<String,Object>> namelist=jdbcTemplate.queryForList(nameQuery.toString());
	            
	            Iterator<String> temIt=temp1.iterator();
	            while(temIt.hasNext()){
	            	Iterator<Map<String,Object>> nameit=namelist.iterator();
	        		String key=temIt.next();
	            	while(nameit.hasNext()){
	            		Map<String,Object> nameMap=nameit.next();
	            		if((boolean)nameMap.get("TYPECD").equals(key)){
	            			flagMap.put(key, (String)nameMap.get("TYPENAME"));
	            		}
	            	}
	            }
	        }
	        xdataList = new ArrayList<String>();
	        List<Highcharts> dataListcommon = new ArrayList<Highcharts>();
	        
			Iterator<String> ittemp=temp1.iterator();
			while(ittemp.hasNext()){										//主题循环匹配--start
				 String strtemp11=(String)ittemp.next();
				 List<BigDecimal> project1 = new ArrayList<BigDecimal>(); 
				 Iterator<String> dateit=datelist.iterator();
				 while(dateit.hasNext()){									//期数循环匹配--start
					 boolean fl=false;										//fl 相应期数有数据true,否则false
					 String dateflag=(String)dateit.next();
					 for(Map<String,Object> en1:list){						//遍历数据List
						 String datetem=((String)en1.get("WARNDT")).trim();
						 datetem=datetem.trim();
						 if(dateflag.equals(datetem)){						//数据List匹配到期数，进入设置数据。
							 String compStr=null;
							 if(flag.equals("o2")){
								 	compStr=(String)en1.get("THEMECD");
							 }else{
							 		compStr=(String)en1.get("WARNLEVEL");
							 }
						 	if(strtemp11.equals(compStr)){
							 	fl=true;
							 	BigDecimal corestr=new BigDecimal((Integer)en1.get("nb"));	
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
		        if(flag.equals("o2")){
		        	Highcharts highchart1 = new Highcharts(); 
		        	highchart1.setData(project1);
					highchart1.setName(flagMap.get(strtemp11));
					dataListcommon.add(highchart1);
		        }else{
		        	HighchartsColor highchart1 = new HighchartsColor(); 
		        	highchart1.setData(project1);
					highchart1.setName(mapx.get(strtemp11));
					switch (Integer.parseInt(strtemp11)) {
					case 0:
						highchart1.setColor("green");
						break;
					case 1:
						highchart1.setColor("yellow");
						break;
					case 2:
						highchart1.setColor("#FF7F27");
						break;
					case 3:
						highchart1.setColor("red");
						break;
	
					default:
						break;
					}
					dataListcommon.add(highchart1);
		        }
			}
			jsonData.put("data", dataListcommon); 
			jsonData.put("listXdata", xdataList);	
	        String result=jsonData.toString();
	        pw.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public List<String> getmonthList(String startDt1,String endDt1){
		List<String> datelist=new ArrayList<String>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		Date endDt = null;
		Date startDt = null;
		try {
			startDt=sdf.parse(startDt1);
			endDt = sdf.parse(endDt1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cd1=Calendar.getInstance();
		cd1.setTime(startDt);
		Calendar cd2=Calendar.getInstance();
		cd2.setTime(endDt);
		int xx=cd1.compareTo(cd2);
		if(xx>0){
			while((cd1.compareTo(cd2)!=0)){
				cd1.add(Calendar.MONTH, -1);
				Date dt=new Date();
				dt=cd1.getTime();
				String str=sdf.format(dt);
				datelist.add(str);
			}
		}else if(xx==0){
			String str=sdf.format(startDt);
			datelist.add(str);
		}else if(xx<0){
			Date dt=new Date();
			dt=cd1.getTime();
			String str=sdf.format(dt);
			datelist.add(str);
			while((cd1.compareTo(cd2)!=0)){
				cd1.add(Calendar.MONTH, 1);
				dt=cd1.getTime();
				str=sdf.format(dt);
				datelist.add(str);
			}
		}
		return datelist;
	}
}
