package com.gbicc.rule.update;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gbicc.engine.rule.GroovyScriptExecutor;
import com.gbicc.rule.entity.TRulDefinition;
import com.gbicc.rule.operation.TRulDefinitionOperation;
import com.gbicc.rule.service.TRulDefinitionService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TRuleDefinitionCheck extends BaseUpdate {
	private static final Logger log=LoggerFactory.getLogger(TRuleDefinitionCheck.class);
	private static final String DATASET_ID =TRulDefinition.class.getSimpleName();
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TRulDefinition dd = new TRulDefinition();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String content=map.get("ruleContent").toString();
				String op = updateResultBean.getParameter("op");
				if(StringUtils.hasText(content)){
					dd=TRulDefinitionService.getInstance().get(map.get("id").toString());
					oc.setAttribute(TRulDefinitionOperation.IN_CONTENT, 
							content);
					oc.setAttribute(TRulDefinitionOperation.IN_PARAM, dd);
					if("check".equals(op)){
						oc.setAttribute(TRulDefinitionOperation.CMD, 
								TRulDefinitionOperation.CMD_UPDATE_VALID);
						oc.setAttribute(TRulDefinitionOperation.IN_PARAM, dd);
						OPCaller.call(TRulDefinitionOperation.ID, oc);
					}else if("execute".equals(op)){
						try {
							Map<String,Object> data=new HashMap<String, Object>();
							data.put("规则定义对象", dd);
							String str=TRulDefinitionOperation.form(dd);
							if(map.get(TRulDefinitionOperation.IN_PARAM_DATE)!=null){
								String date=(String) map.get(TRulDefinitionOperation.IN_PARAM_DATE);
								SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
								data.put("总调度程序跑批时传入的数据处理日期", dateFormat.parse(date));
							}
							if(map.get(TRulDefinitionOperation.IN_PARAM_EXT)!=null){//增加扩展字段
								Map<String,Object> extParams=(Map)map.get(TRulDefinitionOperation.IN_PARAM_EXT);
								data.put("_EXT_PARAMETERS", extParams);
							}
							GroovyScriptExecutor.getInstance().eval(str,data);
						} catch (Exception e) {
							ExceptionUtil.throwCommonException(e.getMessage());
						}
					}
				}
			}
			return updateReturnBean;
		} catch (AppException ex) {
			log.error("",ex);
			throw ex;
		} catch (Exception ex) {
			log.error("",ex);
			ex.printStackTrace();
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
