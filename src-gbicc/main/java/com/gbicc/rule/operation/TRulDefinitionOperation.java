package com.gbicc.rule.operation;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbicc.engine.rule.GroovyScriptExecutor;
import com.gbicc.rule.entity.TRulDefinition;
import com.gbicc.rule.service.TRulDefinitionService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class TRulDefinitionOperation extends BaseOperation {

	public static final String ID = TRulDefinitionOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_UPLOAD = "CMD_UPLOAD";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String CMD_UPDATE_VALID = "CMD_UPDATE_VALID";
	public static final String CMD_UPDATE_EXCUTE = "CMD_UPDATE_EXECUTE";
	public static final String CMD_EXCUTE = "CMD_EXCUTE";
	public static final String CMD_ENABLED = "CMD_ENABLED";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_PARAM_EXT = "IN_PARAM_EXT";//扩展参数
	public static final String IN_PARAM_DATE = "IN_PARAM_DATE";
	public static final String IN_CONTENT= "IN_CONTENT";
	private static final String GLOBAL_CONFIG_CODE="SR_GLOBAL";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		TRulDefinition def = (TRulDefinition) context.getAttribute(IN_PARAM);
		TRulDefinitionService service = TRulDefinitionService.getInstance();
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("规则定义对象", def);
		
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(def);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(def);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(def.getId());
		} else if (CMD_UPLOAD.equals(cmd)) {
			service.upload(def.getId());
		}else if (CMD_UPDATE_VALID.equals(cmd)||CMD_UPDATE_EXCUTE.equals(cmd)) {
			try {
				String content=(String) context.getAttribute(IN_CONTENT);
				def.setRuleContent(content);
				String str=form(def);
				if(CMD_UPDATE_VALID.equals(cmd)){
					GroovyScriptExecutor.getInstance().validate(str);
				} else if(CMD_UPDATE_EXCUTE.equals(cmd)){
					GroovyScriptExecutor.getInstance().eval(str,data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				ExceptionUtil.throwCommonException(e.getMessage());
			}
		}else if (CMD_EXCUTE.equals(cmd)) {
			try {
				String str=form(def);
				if(context.getAttribute(IN_PARAM_DATE)!=null){
					String date=(String) context.getAttribute(IN_PARAM_DATE);
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyymmdd");
					data.put("总调度程序跑批时传入的数据处理日期", dateFormat.parse(date));
				}
				if(context.getAttribute(IN_PARAM_EXT)!=null){//增加扩展字段
					Map<String,Object> extParams=(Map)context.getAttribute(IN_PARAM_EXT);
					data.put("_EXT_PARAMETERS", extParams);
				}
				GroovyScriptExecutor.getInstance().eval(str,data);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException(e.getMessage());
			}
		}else if (CMD_ENABLED.equals(cmd)) {
			if("1".equals(def.getEnable())){
				def.setEnable("0");
				service.update(def);
			}else if("0".equals(def.getEnable())){
				def.setEnable("1");
				service.update(def);
			}
		}
	}
	
	public static String form(TRulDefinition def) throws CommonException{
		//获取全局变量脚本，按顺序
		List<TRulDefinition> global=TRulDefinitionService
			.getInstance().findPublishGlobalDefByCode(GLOBAL_CONFIG_CODE);
		StringBuilder builder=new StringBuilder();
		if(global!=null ){
			for(TRulDefinition t:global){
				builder.append(t.getRuleContent());
				builder.append("\n");
			}
		}
		builder.append(def.getRuleContent());
		return builder.toString();
	}
	
}
