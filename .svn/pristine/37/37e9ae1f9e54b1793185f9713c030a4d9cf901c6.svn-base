package com.gbicc.tools.dbmeta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DbMetaUtil {
	public static Table getTable(Connection connection,String catalog,String schemaPattern,String tableName) throws Exception{
		Table table =new Table();
		table.setName(tableName);
		
		List<Column> columns =new ArrayList<Column>();
		DatabaseMetaData meta =connection.getMetaData();
		ResultSet rs =meta.getColumns(catalog, schemaPattern, tableName, "%");
		while(rs.next()){
			Column column =new Column();
			column.setName(rs.getString("COLUMN_NAME"));
			column.setDescription(rs.getString("REMARKS"));
			column.setType(rs.getString("TYPE_NAME"));
			column.setSize(rs.getInt("COLUMN_SIZE"));
			int nullable =rs.getInt("NULLABLE");
			switch(nullable){
				case ResultSetMetaData.columnNoNulls:
					column.setNullAble(false);
					break;
				case ResultSetMetaData.columnNullable:
					column.setNullAble(true);
					break;
				default:
					column.setNullAble(true);
			}
			columns.add(column);
		}
		
		rs =meta.getPrimaryKeys(null, null, tableName);
		while(rs.next()){
			String colName =rs.getString("COLUMN_NAME");
			for(Column column : columns){
				if(colName.equalsIgnoreCase(column.getName())){
					column.setPrimary(true);
					break;
				}
			}
		}
		table.setColumns(columns);
		
		return table;
	}
	
	public static Table getTable(Connection connection,String tableName) throws Exception{
		return getTable(connection,null,null,tableName);
	}
}
