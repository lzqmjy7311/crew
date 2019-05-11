package com.gbicc.generator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DbDefaultVariableGenerator {
	private static Map<String,IVariableGenerator<?>> variableGenerators =new HashMap<String,IVariableGenerator<?>>();
	
	static{
		variableGenerators.put("VARCHAR", new VariableGenerator<String>().addNull().add("c"));
		variableGenerators.put("CHAR", new VariableGenerator<String>().addNull().add("c"));
		variableGenerators.put("DATE", new VariableGenerator<Date>().addNull().add(new Date()));
		variableGenerators.put("INT", new VariableGenerator<Integer>().addNull().add(-1).add(0).add(1));
		variableGenerators.put("INTEGER", new VariableGenerator<Integer>().addNull().add(-1).add(0).add(1));
		variableGenerators.put("DOUBLE", new VariableGenerator<Double>().addNull().add(-1d).add(0d).add(1d));
		variableGenerators.put("FLOAT", new VariableGenerator<Float>().addNull().add(-1f).add(0f).add(1f));
	}
	
	public static IVariableGenerator<?> getVariableGenerator(String dbType){
		return variableGenerators.get(dbType);
	}
	
	public static IPrimaryGenerator<?> getPrimaryGenerator(String dbType,int length){
		if("VARCHAR".equalsIgnoreCase(dbType)){
			if(length>0){
				return new StringPrimaryGenerator(length);
			}else{
				return new StringPrimaryGenerator();
			}
		}else if("INT".equalsIgnoreCase(dbType) || "INTEGER".equalsIgnoreCase(dbType)){
			return new IntegerPrimaryGenerator();
		}
		return null;
	}
}
