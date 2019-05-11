package com.gbicc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.gbicc.engine.rule.Environment;
import com.gbicc.engine.rule.util.Spring4Groovy;

/**
 * 产品
 * @date    2015年10月11日
 * @author  tangdu
 * @desc	根据产品编号加载对应的子产品编号
 */
public class ProductHelper {
	private static ProductHelper INSTANCE=new ProductHelper();
	private ProductHelper(){}
	public  static ProductHelper getInstance() {
		return INSTANCE;
	}
	private  static Map<String,String> SQL_RESULT=new HashMap<String,String>();
	private  static Map<String,String> RESULT=new HashMap<String,String>();
	private  static Map<String,Map<String,String>> DICT_RESULT=new HashMap<String, Map<String,String>>();

	public void updateProductMap(String code) throws Exception{
		initData(code);
	}
	
	public void updateDictMap(String ...codes) throws Exception{
		initDict(codes);
	}
	
	public Connection getConnection()throws Exception{
		Connection connection=null;
		if(Environment.IS_PRODUCT_ENVIRONMENT){
			connection=Spring4Groovy.getDefaultDataSource().getConnection();
		}else{
			connection=DriverManager.getConnection(Environment.JDBC_URL,
				Environment.JDBC_USER,Environment.JDBC_PASSWORD);
		}
		return connection;
	}
	
	private void initData(String code) throws Exception{
		SQL_RESULT.clear();
		RESULT.clear();
		Connection connection=getConnection();
		PreparedStatement statement=null;
		Map<String,String> sql_result=new HashMap<String,String>();
		Map<String,String> result=new HashMap<String,String>();
		try {
			statement=connection.prepareStatement("SELECT T.DATA_NO,T.DATA_NAME"
				+ "	 FROM DATA_DIC T WHERE T.DATA_TYPE_NO=?");
			statement.setString(1, code);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				String dataNo=resultSet.getString(1);
				statement=connection.prepareStatement("SELECT T.PROD_CODE,T.PROD_NAME "
						+ "FROM T_PL_PARAM_PRODUCT T WHERE T.PROD_TYPE=?");
				statement.setString(1, dataNo);
				ResultSet rs=statement.executeQuery();
				
				StringBuilder sql_sbf=new StringBuilder();
				StringBuilder sbf=new StringBuilder();
				while(rs.next()){
					sql_sbf.append("'").append(rs.getString(1)).append("'").append(",");
					sbf.append(rs.getString(1)).append(",");
				}
				if(sql_sbf.length()>1){
					sql_result.put(dataNo,sql_sbf.substring(0,sql_sbf.lastIndexOf(",")));
					result.put(dataNo,sbf.substring(0,sbf.lastIndexOf(",")));
				}
			}
		} catch (Exception e) {
			throw e;
		} finally{
			if(statement!=null)
				statement.close();
			if(connection!=null)
				connection.close();
		}
		SQL_RESULT.putAll(sql_result);
		RESULT.putAll(result);
	}
	
	private void initDict(String ...codes) throws Exception{
		DICT_RESULT.clear();
		Connection connection=getConnection();
		Map<String,Map<String,String>> result=new HashMap<String,Map<String,String>>();
		PreparedStatement statement=null;
		try {
			if(codes!=null && codes.length>0){
				for(String code:codes){
					statement=connection.prepareStatement("SELECT T.DATA_NO,T.DATA_NAME"
							+ "	 FROM DATA_DIC T WHERE T.DATA_TYPE_NO=?");
						statement.setString(1, code);
						ResultSet resultSet=statement.executeQuery();
						Map<String,String> mp=new HashMap<String, String>();
						while(resultSet.next()){
							mp.put(resultSet.getString(2),resultSet.getString(1));
						}
						result.put(code, mp);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally{
			if(statement!=null)
				statement.close();
			if(connection!=null)
				connection.close();
		}
		DICT_RESULT.putAll(result);
	}
	
	public Map<String,String> getResultMapSQLIn(String code) throws Exception{
		if(SQL_RESULT.isEmpty()){
			updateProductMap(code);
		}
		return SQL_RESULT;
	}
	
	public Map<String,String> getResultMap(String code) throws Exception{
		if(RESULT.isEmpty()){
			updateProductMap(code);
		}
		return RESULT;
	}
	
	public Map<String,Map<String,String>>  getDictResultMap(String ...codes) throws Exception{
		if(DICT_RESULT.isEmpty()){
			updateDictMap(codes);
		}
		return DICT_RESULT;
	}
}
