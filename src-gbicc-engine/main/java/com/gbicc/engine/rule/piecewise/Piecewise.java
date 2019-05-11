package com.gbicc.engine.rule.piecewise;

import java.util.HashMap;
import java.util.Map;

import com.gbicc.engine.rule.GroovyScriptExecutor;

public abstract class Piecewise {
	public static final String INPUT_KEY ="input";
	public static final String RESULT_KEY ="result";
	private String script;
	
	/**
	 * 获取分段函数执行 Groovy 脚本
	 * @param segments 分段函数配置对象
	 * @return Groovy 脚本
	 */
	protected abstract String getGroovyScript();
	
	/**
	 * 执行分段函数
	 * @param context 上下文(条件变量集合)
	 * @return 决策结果(如果在分段中找不到满足条件的返回 null)
	 * @throws Exception
	 */
	public Object eval(Object context) throws Exception{
		return eval(context,null);
	}
	
	/**
	 * 执行分段函数
	 * @param parameter 上下文参数
	 * @param defaultValue 缺省值（当在定义的分段函数中找不到满足条件时返回会的默认值）
	 * @return 结果值
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Object eval(Object parameter,Object defaultValue) throws Exception{
		if(script==null || "".equals(script.trim())){
			script =getGroovyScript();
		}
		Map<String,Object> context =null;
		if(parameter instanceof Map){
			context =(Map<String,Object>)parameter;
		}else{
			context =new HashMap<String,Object>();
			context.put(INPUT_KEY, parameter);
		}
		Map<String,Object> bindings =GroovyScriptExecutor.getInstance().execute(script, context);
		Object result =bindings.get(RESULT_KEY);
		if(result==null){
			return defaultValue;
		}else{
			return result;
		}
	}

	/**
	 * 获取可执行的 Groovy 脚本
	 * @return Groovy 脚本
	 */
	public String getScript() {
		if(script==null){
			script =getGroovyScript();
		}
		return script;
	}
}
