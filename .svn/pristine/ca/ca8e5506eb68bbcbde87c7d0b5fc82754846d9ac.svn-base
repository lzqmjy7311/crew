package com.gbicc.engine.rule.util;

import groovy.sql.Sql;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

public class TaskExceptionRecorder {
	private static String insertSql;
	private String name;
		
	public TaskExceptionRecorder(){
		insertSql ="insert into T_PL_BATCH_ERROR_LOG(";
		insertSql +="	FD_TASK_NAME,";
		insertSql +="	FD_TASK_RUN_DATE,";
		insertSql +="	FD_BUS_ID,";
		insertSql +="	FD_EXCEPTION";
		insertSql +="	) values (";
		insertSql +="		?,current timestamp,?,?";
		insertSql +=" )";
	}
	
	public TaskExceptionRecorder(String name){
		this();
		this.name =name;
	}
	
	public void error(Sql sql,String id,Exception e) throws SQLException{
		StringWriter writer =new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		sql.execute(insertSql, new Object[]{this.name,id,writer.toString()});
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
