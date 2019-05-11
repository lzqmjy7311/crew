package com.gbicc.engine.rule.util;

import groovy.lang.Closure;
import groovy.sql.Sql;

import java.sql.SQLException;

import com.gbicc.engine.rule.Environment;

@SuppressWarnings("rawtypes")
public class ESql {
	public static void withInstance(Closure c) throws SQLException {
		if(Environment.IS_PRODUCT_ENVIRONMENT){
			withDatasourceInstance(c);
		}else{
			withJdbcInstance(Environment.JDBC_URL,Environment.JDBC_USER,Environment.JDBC_PASSWORD,c);
		}
	}
	
	public static void withDatasourceInstance(Closure c) throws SQLException {
		Sql sql =null;
		try {
			sql = new Sql(Spring4Groovy.getDefaultDataSource());
			c.call(sql);
		} finally {
			if (sql != null) {
				sql.close();
			}
		}
	}
	
	public static void withJdbcInstance(String url,String user,String password,Closure c) throws SQLException {
		Sql sql =null;
		try {
			sql = Sql.newInstance(url, user, password);
			c.call(sql);
		} finally {
			if (sql != null) {
				sql.close();
			}
		}
	}
}
