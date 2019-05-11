package com.gbicc.engine.rule.api.task;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gbicc.engine.rule.GroovyScriptExecutor;
import com.gbicc.util.FileUtil;

public class TaskGenerator {
	/**
	 * 生成催收任务
	 * @param date 总调度程序跑批时传入的数据处理日期
	 * @throws Exception
	 */
	public static void generateDebtCollectTask(Date date) throws Exception{
		GroovyScriptExecutor.getInstance().eval(getGroovyScript("催收任务生成器"),buildContext(date));
	}
	
	/**
	 * 获取任务的 groovy 脚本
	 * @param taskId 任务ID
	 * @return 任务 groovy 脚本
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private static String getGroovyScript(String taskId) throws UnsupportedEncodingException, IOException{
		return FileUtil.readString(TaskGenerator.class.getResourceAsStream("/com/gbicc/engine/rule/api/task/" + taskId + ".groovy"));
	}
	
	/**
	 * 构建 groovy 脚本执行的上下文
	 * @param date 总调度程序跑批时传入的数据处理日期
	 * @return groovy 脚本执行的上下文
	 */
	private static Map<String,Object> buildContext(Date date){
		Map<String,Object> result =new HashMap<String,Object>();
		result.put("总调度程序跑批时传入的数据处理日期", date);
		return result;
	}
}
