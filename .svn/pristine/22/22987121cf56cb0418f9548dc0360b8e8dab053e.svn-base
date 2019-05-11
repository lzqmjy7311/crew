package com.gbicc.engine.rule.decision;

import java.util.List;
import java.util.Map;

import com.gbicc.engine.rule.GroovyScriptExecutor;

/**
 * 决策表类2
 * 为 Groovy 提供决策表功能
 * @author wangshaoping
 *
 */
public class DecisionTable2D {
	public static final String RESULT_KEY ="result";
	private String[][] table;
	private String script ="";
	
	/**
	 * 决策表构建器
	 * @param conditions 条件表（二位数组，本可使用 String[][] 形式作为参数，但 Groovy 不支持[][],只支持 List）
	 * @param actions 动作表（二位数组，本可使用 String[][] 形式作为参数，但 Groovy 不支持[][],只支持 List）
	 */
	public DecisionTable2D(List<List<String>> table){
		this.table =new String[table.size()][table.get(0).size()];
		for(int i=0;i<this.table.length;i++){
			this.table[i] =table.get(i).toArray(new String[]{});
		}
		this.script =transform2groovyScript(this.table);
	}
	
	/**
	 * 决策表构建器
	 * @param conditions 条件表二维数组
	 * @param actions 动作表二维数组
	 */
	public DecisionTable2D(String[][] table){
		this.table =table;
		this.script =transform2groovyScript(this.table);
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
		Map<String,Object> bindings =GroovyScriptExecutor.getInstance().execute(script, context);
		Object result =bindings.get(RESULT_KEY);
		if(result==null){
			return defaultValue;
		}else{
			return result;
		}
	}
	
	/**
	 * 获取条件表
	 * @return 条件表二维数组
	 */
	public String[][] getTable() {
		return table;
	}

	/**
	 * 设置条件表
	 * @param conditions 条件表二维数组
	 */
	public void setTable(String[][] table) {
		this.table = table;
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
	private String transform2groovyScript(String[][] table){
		String[] condition1 =new String[table.length-1];
		String[] condition2 =new String[table[0].length-1];
		for(int i=0;i<condition1.length;i++){
			condition1[i] =table[i+1][0];
		}
		for(int i=0;i<condition2.length;i++){
			condition2[i] =table[0][i+1];
		}
		
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<condition1.length;i++){
			for(int j=0;j<condition2.length;j++){
				if(i==0 && j==0){
					sb.append("if(");
				}else{
					sb.append("else if(");
				}
				sb.append("(").append(condition1[i]).append(")");
				sb.append(" && ");
				sb.append("(").append(condition2[j]).append(")");
				sb.append("){").append("\n");
				sb.append("\t").append(RESULT_KEY).append(" =").append(table[i+1][j+1]).append(";").append("\n");
				sb.append("}");
			}
		}
		return sb.toString();
	}
	
	public static DecisionTable2D getSample(){
		DecisionTable2D result =new DecisionTable2D(
		new String[][]{
			{""				,"客户类型=='普通客户'"	,"客户类型=='VIP客户'"	,"客户类型=='临时客户'"},
			{"评分结果<60"	,"'1'"					,"'2'"				,"5"				},
			{"评分结果>=60"	,"'3'"					,"'4'"				,"6"				}
		});
		return result;
	}
}
