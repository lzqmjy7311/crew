package com.gbicc.rule.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gbicc.common.CommonService;
import com.gbicc.engine.rule.GroovyScriptExecutor;
import com.gbicc.rule.entity.TRulDefinition;
import com.gbicc.rule.operation.TRulDefinitionOperation;
import com.gbicc.rule.operation.TRulExecuteLogOperation;
import com.gbicc.rule.servlet.RuleExecuteLog;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TRulDefinitionService {
	private static Logger logger=LoggerFactory.getLogger(TRulDefinitionService.class);
	protected TRulDefinitionService() {
	}

	public synchronized static TRulDefinitionService getInstance() {
		return (TRulDefinitionService) ApplicationContextUtils
				.getBean(TRulDefinitionService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TRulDefinition get(String id) throws CommonException{
		return dao().query(TRulDefinition.class, id);
	}
	
	public void save(TRulDefinition rulDefinition) throws CommonException{
		dao().save(rulDefinition);
	}
	
	public List<TRulDefinition> findPublishGlobalDefByCode(String code) throws CommonException{
		List<TRulDefinition> data=CommonService.getInstance().queryListSql("select t1.* from T_PUB_RUL_DEFINITION t1 join T_PUB_RUL_CATEGORY t2 on "+
			"t2.FD_ID=t1.FD_CATEGORY_ID "+
			"where t2.FD_CATEGORY_CODE like '"+code+"%' order by t2.FD_CATEGORY_CODE asc "
					 //+" and t1.FD_RULE_ENABLE='1'"
					//+" and t1.FD_RULE_STATUS='1'"
			,TRulDefinition.class);
		return data;
	}
	
	/**
	 * 根据编号查询到规格定义
	 * @param code
	 * @return
	 * @throws CommonException
	 */
	public TRulDefinition findPublishDefByCode(String code) throws CommonException{
		List<TRulDefinition> data=CommonService.getInstance().queryListSql("select t1.* from T_PUB_RUL_DEFINITION t1 join T_PUB_RUL_CATEGORY t2 on "+
			"t2.FD_ID=t1.FD_CATEGORY_ID "+
			"where t2.FD_CATEGORY_CODE='"+code+"'"
					 //+" and t1.FD_RULE_ENABLE='1'"
					 //+" and t1.FD_RULE_STATUS='1'"
			,TRulDefinition.class);
		if(data!=null && !data.isEmpty()){
			return data.get(0);
		}
		return null;
	}
	
	public void execute(String ruleId){
		
	}
	
	public void update(TRulDefinition rulDefinition) throws CommonException{
		dao().update(rulDefinition);
	}
	public void upload(String id) throws CommonException{
		//0 草稿 1 发布 2历史
		TRulDefinition def=get(id);
		CommonService.getInstance().executeHQL("update TRulDefinition  set ruleStatus='2' "
				+ " where ruleCode='"+def.getRuleCode()+"' and ruleStatus='1' ");
		def.setRuleUpdateddate(new Date());
		def.setRuleStatus("1");//发布状态
		dao().save(def);
	}
	
	public Integer getMaxVersion(String code)throws CommonException{
		Object max=dao().queryByHqlMax("select max(ruleVersion) from TRulDefinition where ruleCode='"+code+"'");
		if(max==null){
			return 1;
		}
		return ((Integer) max+1);
	}
	
	public void deleteByCategoryId(String categoryId) throws CommonException{
		CommonService.getInstance().executeHQL("delete from TRulDefinition t where t.categoryId='"+categoryId+"'");
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(get(id));
	}
	
	/**
	 * 根据目录编号查询出分类 下的所有规则 -已发布-启用状态的
	 * @param categoryCode
	 * @return
	 * @throws CommonException
	 */
	public LinkedList<TRulDefinition> queryAllByCode(String categoryCode) throws CommonException{
		LinkedList<TRulDefinition> list=new LinkedList<TRulDefinition>();
		eachTree(categoryCode,list);
		return list;
	}
	
	public List<TRulDefinition> queryAllByNamePaths(String namePaths) throws CommonException{
		LinkedList<TRulDefinition> list=new LinkedList<TRulDefinition>();
		getCategoryByNamePaths(namePaths);
		return list;
	}
	
	public LinkedList<TRulDefinition> getCategoryByNamePaths(String namePaths) throws CommonException{
 		String[] names=namePaths.split("[.]");
		if(names.length==1){
			List<String> result=CommonService.getInstance()
					.findSqlSimpleListBySpringJdbc("select FD_RULE_CODE from  T_PUB_RUL_CATEGORY "
						+ "	 t where  t.FD_CATEGORY_NAME='"+names[0]+"'", String.class);
			return queryAllByCode(result.get(0));
		}
		
		String fid=names[0];
		StringBuilder sbf=new StringBuilder("select ")
			.append(names[names.length-1]).append(".FD_CATEGORY_CODE ")
			.append(" from T_PUB_RUL_CATEGORY "+fid);
		StringBuilder wh=new StringBuilder(" where  ");
		wh.append(fid).append(".FD_CATEGORY_NAME=").append("'").append(names[0]).append("'");
		for(int i=1;i<names.length;i++){
			sbf.append(" join  T_PUB_RUL_CATEGORY "+names[i]+" on "+fid+".FD_ID="+names[i]+".FD_PARENT_ID");
			wh.append("  and  ").append(names[i]).append(".FD_CATEGORY_NAME=").append("'").append(names[i]).append("'");
		}
		fid=sbf.append(wh).toString();
		List<String> result=CommonService.getInstance()
				.findSqlSimpleListBySpringJdbc(fid, String.class);
		LinkedList<TRulDefinition> list=new LinkedList<TRulDefinition>();
		for(String s:result){
			list.addAll(queryAllByCode(s));
		}
		return list;
	}
	
	public void eachTree(String categoryCode,LinkedList<TRulDefinition> lists) throws CommonException{
		Iterator<Object[]> rows=dao().queryBySQL("select t1.FD_id,t1.FD_RULE_CODE,t1.FD_RULE_NAME"
				+ " from T_PUB_RUL_DEFINITION t1 join T_PUB_RUL_CATEGORY t2 on t1.FD_CATEGORY_ID=t2.FD_ID where t2.FD_PARENT_ID='"+categoryCode+"'");
		if(rows!=null){
			while(rows.hasNext()){
				Object [] r=rows.next();
				TRulDefinition tRulDefinition=new TRulDefinition();
				tRulDefinition.setId(r[0].toString());
				tRulDefinition.setRuleCode(r[1].toString());
				tRulDefinition.setRuleName(r[2].toString());
				lists.add(tRulDefinition);
				eachTree(r[1].toString(),lists);
			}
		}
	}
	
	public class RuleExecuteThread extends Thread{
		TRulDefinition def;
		RuleCallResult result;
		Map<String,String> ext_params;
		public RuleExecuteThread(TRulDefinition def,RuleCallResult result,Map<String,String> ext_params){
			this.def=def;
			this.result=result;
			this.ext_params=ext_params;
			super.setName("RuleExecute"+this.def.getRuleCode());
		}
		
		@Override
		public void run() {
			RuleExecuteLog executeLog=new RuleExecuteLog();
			executeLog.setStartTime(new Date());
			executeLog.setRowDate(result.getRowdate());
			executeLog.setRuleCode(this.def.getRuleCode());
			executeLog.setRuleId(this.def.getId());
			executeLog.setSuccess(0);
			executeLog.setExecId(this.result.getExecid());
			boolean success=false;
			try {
				logger.error("#execute[start]--"+def.getRuleCode()+"--"+result.getRowdate());
				Map<String,Object> data=new HashMap<String, Object>();
				data.put("规则定义对象", def);
				String str=TRulDefinitionOperation.form(def);
				if(result.getRowdate()!=null){
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
					data.put("总调度程序跑批时传入的数据处理日期", dateFormat.parse(result.getRowdate()));
				}
				if(ext_params!=null){//增加扩展字段
					data.put("_EXT_PARAMETERS", ext_params);
				}
				GroovyScriptExecutor.getInstance().eval(str,data);
				success=true;
			} catch (Exception e) {
				executeLog.setErrorMsg(e.getMessage());
				logger.error("#execute[run]--"+def.getRuleCode()+"--"+result.getRowdate()+" error", e);
			} finally{
				if(success){
					executeLog.setSuccess(1);
				}
				executeLog.setEndTime(new Date());
				executeLog.setExecTime(Double.valueOf((executeLog.getEndTime().getTime()
						-executeLog.getStartTime().getTime()))/1000);
				OperationContext oc = new OperationContext();
				oc.setAttribute(TRulExecuteLogOperation.IN_PARAM,executeLog);
				oc.setAttribute(TRulExecuteLogOperation.CMD,TRulExecuteLogOperation.CMD_UPT);
				try {
					OPCaller.call(TRulExecuteLogOperation.ID, oc);
					logger.error("#execute[end]--"+def.getRuleCode()+"--"+result.getRowdate()+"--time["+executeLog.getExecTime()+"]s");
				} catch (CommonException e) {
					logger.error("#execute[update]-----"+def.getRuleCode(), e);
				}
			}
		}
		
	}
	
	
	public RuleCallResult runRule(String rulecode,Map<String,String> extParams,boolean isSynchronize){
		RuleCallResult result=new RuleCallResult();
		result.setExecid(UUID.randomUUID().toString());
		if(extParams.get("rowdate")!=null){
			result.setRowdate(extParams.get("rowdate").toString());
		}
		result.setRulecode(rulecode);
		
		if(!StringUtils.hasText(rulecode)){
			result.setMessage("调用的规则编号["+rulecode+"]不能为空");
			result.setSuccess(false);
			logger.error("error "+ result.getMessage());
		}
		TRulDefinition def=null;
		try {
			def=TRulDefinitionService.getInstance().findPublishDefByCode(rulecode);
			if(def==null){
				result.setMessage("规则编号["+rulecode+"]无效，找不到记录");
				result.setSuccess(false);
				logger.error("error "+result.getMessage());
			}else if("0".equals(def.getEnable())){
				result.setMessage("规则编号["+rulecode+"]无效，已经被禁用");
				result.setSuccess(true);
				logger.error("error "+result.getMessage());
			}else{
				//logger.error("#execute[start]--"+def.getRuleCode()+"--"+result.getRowdate());
				RuleExecuteLog executeLog=new RuleExecuteLog();
				executeLog.setStartTime(new Date());
				executeLog.setRowDate(result.getRowdate());
				executeLog.setRuleCode(def.getRuleCode());
				executeLog.setRuleId(def.getId());
				executeLog.setSuccess(-1);
				executeLog.setExecId(result.getExecid());
				OperationContext oc = new OperationContext();
				oc.setAttribute(TRulExecuteLogOperation.IN_PARAM,executeLog);
				oc.setAttribute(TRulExecuteLogOperation.CMD,TRulExecuteLogOperation.CMD_INT);
				try {
					OPCaller.call(TRulExecuteLogOperation.ID, oc);
				} catch (CommonException e) {
					throw e;
				}
				Thread thread=new RuleExecuteThread(def,result,extParams);
				if(!isSynchronize){
					thread.start();
				}else{
					thread.run();
				}
			}
		} catch (Exception e) {
			result.setSuccess(false);
			StringWriter writer =new StringWriter();
			e.printStackTrace(new PrintWriter(writer));
			String message=writer.toString();
			if(message.length()>3000){
				message=message.substring(0,3000);
			}
			result.setMessage(message);
			logger.error("error ", e);
		} 
		return result;
	}
}
