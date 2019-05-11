package com.gbicc.engine.rule.decision;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbicc.engine.rule.GroovyScriptExecutor;

/**
 * 决策表类
 * 为 Groovy 提供决策表功能
 * @author wangshaoping
 *
 */
public class DecisionTable {
	private String[][] conditions;
	private String[][] actions;
	private String script ="";
	
	/**
	 * 决策表构建器
	 * @param conditions 条件表（二位数组，本可使用 String[][] 形式作为参数，但 Groovy 不支持[][],只支持 List）
	 * @param actions 动作表（二位数组，本可使用 String[][] 形式作为参数，但 Groovy 不支持[][],只支持 List）
	 */
	public DecisionTable(List<List<String>> conditions,List<List<String>> actions){
		this.conditions =new String[conditions.size()][conditions.get(0).size()];
		for(int i=0;i<conditions.size();i++){
			this.conditions[i] =conditions.get(i).toArray(new String[]{});
		}
		
		this.actions =new String[actions.size()][actions.get(0).size()];
		for(int i=0;i<actions.size();i++){
			this.actions[i] =actions.get(i).toArray(new String[]{});
		}
		
		this.script =transform2groovyScript(this.conditions,this.actions);
	}
	
	/**
	 * 决策表构建器
	 * @param conditions 条件表二维数组
	 * @param actions 动作表二维数组
	 */
	public DecisionTable(String[][] conditions,String[][] actions){
		this.conditions =conditions;
		this.actions =actions;
		
		this.script =transform2groovyScript(this.conditions,this.actions);
	}
	
	/**
	 * 执行决策表
	 * @param context 上下文(条件变量集合)
	 * @return 决策结果
	 * @throws Exception
	 */
	public Object eval(Map<String,Object> context) throws Exception{
		return eval(context,null);
	}
	
	/**
	 * 执行决策表
	 * @param context 上下文(条件变量集合)
	 * @param defaultValue 缺省值（当在定义的决策表中找不到满足条件的决策时返回会的默认值）
	 * @return 决策结果
	 * @throws Exception
	 */
	public Object eval(Map<String,Object> context,Object defaultValue) throws Exception{
		if(actions.length==1){
			return evalSingleResultValue(context,actions[0][0],defaultValue);
		}else{
			String[] _actions =new String[actions.length];
			for(int i=0;i<actions.length;i++){
				_actions[i] =actions[i][0];
			}
			
			if(defaultValue==null){
				Map<String,Object> _defaultValues =new HashMap<String,Object>();
				for(int i=0;i<actions.length;i++){
					_defaultValues.put(_actions[i],null);
				}
				return evalMulitiResultValue(context,_actions,_defaultValues);
			}else{
				return evalMulitiResultValue(context,_actions,defaultValue);
			}
		}
	}
	
	private Object evalSingleResultValue(Map<String,Object> context,String key,Object defaultValue) throws Exception{
		Map<String,Object> bindings =GroovyScriptExecutor.getInstance().execute(script, context);
		Object singleResult =bindings.get(key);
		if(singleResult!=null){
			return singleResult;
		}else{
			return defaultValue;
		}
	}
	
	private Object evalMulitiResultValue(Map<String,Object> context,String[] keys,Object defaultValue) throws Exception{
		Map<String,Object> bindings =GroovyScriptExecutor.getInstance().execute(script, context);
		Map<String,Object> result =new HashMap<String,Object>();
		for(int i=0;i<keys.length;i++){
			String key =keys[i];
			Object value =bindings.get(key);
			if(value!=null){
				result.put(key, value);
			}
		}
		if(result.size()==keys.length){
			return result;
		}else{
			return defaultValue;
		}
	}
	
	/**
	 * 获取条件表
	 * @return 条件表二维数组
	 */
	public String[][] getConditions() {
		return conditions;
	}

	/**
	 * 设置条件表
	 * @param conditions 条件表二维数组
	 */
	public void setConditions(String[][] conditions) {
		this.conditions = conditions;
	}

	/**
	 * 获取动作表
	 * @return 动作表二维数组
	 */
	public String[][] getActions() {
		return actions;
	}

	/**
	 * 设置动作表
	 * @param actions 动作表二维数组
	 */
	public void setActions(String[][] actions) {
		this.actions = actions;
	}

	/**
	 * 获取决策表的 Groovy 脚本
	 * @return Groovy 脚本
	 */
	public String getScript() {
		return script;
	}

	/**
	 * 设置决策表的 Groovy 脚本
	 * @param script Groovy 脚本
	 */
	public void setScript(String script) {
		this.script = script;
	}
	
	/**
	 * 将决策表定义转换成可执行的 Groovy 脚本
	 * @param conditions 条件表
	 * @param actions 动作表
	 * @return 转换后的 Groovy 脚本
	 */
	private String transform2groovyScript(String[][] conditions,String[][] actions){
		StringBuilder sb =new StringBuilder();
		for(int j=1;j<conditions[0].length;j++){
			if(j==1){
				sb.append("if(");
			}else{
				sb.append("else if(");
			}
			for(int i=0;i<conditions.length;i++){
				String c =transformValue(conditions[i][j]);
				if(i==0){
					sb.append(buildLogic(conditions[i][0],c));
				}else{
					sb.append(" && ").append(buildLogic(conditions[i][0],c));
				}
			}
			sb.append("){").append("\n");
			for(int i=0;i<actions.length;i++){
				sb.append("    ").append(actions[i][0]).append(" =").append(actions[i][j]).append(";\n");
			}
			sb.append("}");
		}
		return sb.toString();
	}
	
	/**
	 * 处理条件表达式结果字面意思转化成 groovy 可识别的语句，简化定义语句，即将 y-->true,n-->false
	 * @param src 字面意思
	 * @return 转换后的语句
	 */
	private String transformValue(String src){
		if(
			"Y".equalsIgnoreCase(src) || 
			"T".equalsIgnoreCase(src)
		){
			return "true";
		}else if(
			src==null ||
			"".equals(src.trim()) ||
			"N".equalsIgnoreCase(src) ||
			"F".equalsIgnoreCase(src)
		){
			return "false";
		}else{
			return src;
		}
	}
	
	private String buildLogic(String condition,String logic){
		if("true".equalsIgnoreCase(logic)){
			return "(" + condition + ")";
		}else if("false".equalsIgnoreCase(logic)){
			return "!(" + condition + ")";
		}else{
			return "(" + condition + ")==(" + logic + ")";
		}
	}
	
	public static DecisionTable getSample(){
		DecisionTable result =new DecisionTable(
			new String[][]{
				{"客户类型=='普通客户'"	,"y"	 ,"y"	 ,"n"	 ,"n"},
				{"评分结果>=60"			,"y"	 ,"n"	 ,"y"	 ,"n"}
			},
			new String[][]{
				{"决策"					,"'A'"	 ,"'D'"	 ,"'A'"	 ,"'A'"	},
				{"动作"					,"'do1'" ,"'do2'","'do3'","'do4'"}
			}
		);
		return result;
	}
	
	public static DecisionTable getSample2(){
		DecisionTable result =new DecisionTable(
			new String[][]{
				{"客户类型=='普通客户'"	,"y"},
				{"评分结果>=60"			,"y"}
			},
			new String[][]{
				{"决策"					,"'A'"},
				{"动作"					,"'do1'"}
			}
		);
		return result;
	}
}
