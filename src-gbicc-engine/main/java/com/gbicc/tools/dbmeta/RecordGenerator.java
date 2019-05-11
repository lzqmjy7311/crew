package com.gbicc.tools.dbmeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbicc.generator.CompositeVariableGenerator;
import com.gbicc.generator.DbDefaultVariableGenerator;
import com.gbicc.generator.IPrimaryGenerator;
import com.gbicc.generator.IVariableGenerator;

public class RecordGenerator {
	private Table table;
	private Map<String,IVariableGenerator<?>> columnGenerators =new HashMap<String,IVariableGenerator<?>>();
	private Map<String,IPrimaryGenerator<?>> primaryGenerators =new HashMap<String,IPrimaryGenerator<?>>();
	
	private List<IPrimaryGenerator<?>> _primaryGenerators =new ArrayList<IPrimaryGenerator<?>>();
	private CompositeVariableGenerator _compositeVariableGenerator =new CompositeVariableGenerator();
	private boolean initialized;
	
	public RecordGenerator(Table table){
		this.table =table;
	}

	public RecordGenerator addColumnGenerator(String columnName,IVariableGenerator<?> generator){
		this.columnGenerators.put(columnName, generator);
		return this;
	}
	
	public RecordGenerator addColumnGenerator(Map<String,IVariableGenerator<?>> columnGenerators){
		columnGenerators.putAll(columnGenerators);
		return this;
	}
	
	public RecordGenerator addPrimaryGenerator(String columnName,IPrimaryGenerator<?> generator){
		this.primaryGenerators.put(columnName, generator);
		return this;
	}
	
	public RecordGenerator addPrimaryGenerator(Map<String,IPrimaryGenerator<?>> primaryGenerators){
		primaryGenerators.putAll(primaryGenerators);
		return this;
	}
	
	private void initialize(){
		for(Column column :table.getColumns()){
			if(column.isPrimary()){
				IPrimaryGenerator<?> generator =primaryGenerators.get(column.getName());
				if(generator==null){
					_primaryGenerators.add(DbDefaultVariableGenerator.getPrimaryGenerator(column.getType(),column.getSize()));
				}
			}else{
				IVariableGenerator<?> generator =columnGenerators.get(column.getName());
				if(generator!=null){
					_compositeVariableGenerator.add(generator);
				}else{
					_compositeVariableGenerator.add(DbDefaultVariableGenerator.getVariableGenerator(column.getType()));
				}
			}
		}
		initialized =true;
	}
	
	public boolean hasNext(){
		if(!initialized){
			initialize();
		}
		return _compositeVariableGenerator.hasNext();
	}
	
	public List<Object> next(){
		if(!initialized){
			initialize();
		}
		List<Object> result =new ArrayList<Object>();
		for(IPrimaryGenerator<?> generator : _primaryGenerators){
			result.add(generator.next());
		}
		result.addAll(_compositeVariableGenerator.next());
		return result;
		
	}
	
	public String getInsertSql(){
		StringBuilder sb =new StringBuilder();
		sb.append("insert into ").append(table.getName()).append(" (").append("\n");
		
		List<Column> columns =getColumns(true);
		for(Column column : columns){
			sb.append("\t").append(column.getName()).append(",").append("\n");
		}
		
		columns =getColumns(false);
		for(int i=0;i<columns.size();i++){
			if(i==columns.size()-1){
				sb.append("\t").append(columns.get(i).getName()).append("\n");
			}else{
				sb.append("\t").append(columns.get(i).getName()).append(",").append("\n");
			}
		}
		
		sb.append(") values (");
		for(int i=0;i<table.getColumns().size();i++){
			if(i==table.getColumns().size()-1){
				sb.append("?");
			}else{
				sb.append("?,");
			}
		}
		sb.append(")").append("\n");
		return sb.toString();
	}
	
	private List<Column> getColumns(boolean primary){
		List<Column> result =new ArrayList<Column>();
		for(Column column :table.getColumns()){
			if(primary){
				if(column.isPrimary()){
					result.add(column);
				}
			}else{
				if(!column.isPrimary()){
					result.add(column);
				}
			}
		}
		return result;
	}
}
