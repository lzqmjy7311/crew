package com.gbicc.person.monitor.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.BpmDescUtil;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.CommonService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.person.monitor.entity.TPlYjMonitor;
import com.gbicc.person.monitor.service.TPlYjMonitorService;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
import com.gbicc.personCommon.entity.TEdwPlsCust;
import com.gbicc.personCommon.entity.TPlTaskRuleTrig;
import com.gbicc.personCommon.entity.TPlTaskRuleTrigInfo;
import com.gbicc.warn.service.TPlTaskRuleTrigService;
import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * 
 * @author xudongdong
 *
 * 版本：2015年11月6日 下午2:47:27
 * 类说明：预警处置报告操作类
 */
public class TPlYjMonitorOperationBf extends BaseOperation {
	public static final String ID = "TPlYjMonitorOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_PARAM2 = "IN_PARAM2";
	public static final String YJ_MONITOR_PROCESS = "yj_monitor_process";
	/**
	 * 任务分发管理员-字典类型编码
	 */
	public static final String TASK_DISTRIBUTE_MNG_TYPE="task_distribute_mng_type";
	/**
	 * 任务分发管理员-字典码
	 */
	public static final String TASK_DISTRIBUTE_MNG_CODE="task_distribute_mng_code";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		String duty=null;
		TPlYjMonitor monitor = context.getAttribute(IN_PARAM)==null?null:(TPlYjMonitor) context.getAttribute(IN_PARAM);
		TPlTaskRuleTrig tPlTaskRuleTrig =context.getAttribute(IN_PARAM2)==null?null:(TPlTaskRuleTrig) context.getAttribute(IN_PARAM2);
		TPlYjMonitorService service = TPlYjMonitorService.getInstance();
		TPlTaskRuleTrigService  tPlTaskRuleTrigService=TPlTaskRuleTrigService.getInstance();
		ProcessManagerService processManagerService=ProcessManagerService.getInstace();
		TlrInfoService tlrService=TlrInfoService.getInstance();
		TPlTaskRuleTrigInfo trigInfo=new TPlTaskRuleTrigInfo();
		//业务实体 为空则退出
		if(monitor==null){
			return;
		}
		
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			//查询账户 表
			List<TEdwPlsAccount> list=CommonService.getInstance()
				.findSqlListBySpringJdbc("select * from t_edw_pls_account_v where loanacno='"+monitor.getLoanAcct()+"'", TEdwPlsAccount.class);
			if(null==list||list.size()<=0){
				return;
			}
			TEdwPlsAccount info=list.get(0);
			duty= processManagerService.findCheckDutyUserId(monitor.getLoanAcct());
			trigInfo=processManagerService.findTPlTrigInfo(monitor.getLoanAcct());
			TEdwPlsCust cust=null;
			//查询客户表
			List<TEdwPlsCust> list2=CommonService.getInstance()
				.findSqlListBySpringJdbc("select * from T_EDW_PLS_CUST  where CUSTID='"+info.getCustid()+"'", TEdwPlsCust.class);
			if(null!=list2&&list2.size()>0){
				cust=list2.get(0);
			}
			 
			
			if(StringUtils.isNotEmpty(duty)){
				monitor.setHandler(tlrService.getTlrInfoByTlrno(duty));
			}else{
				Integer dicType=Integer.parseInt(FileUpDownProperties.readValue(TASK_DISTRIBUTE_MNG_TYPE));
				String dicNo=FileUpDownProperties.readValue(TASK_DISTRIBUTE_MNG_CODE);
				String dicName=DataDicService.getInstance().getNameByTypeNo(dicType,dicNo);
				monitor.setHandler(tlrService.getTlrInfoByTlrno(dicName));
			}
			monitor.setLoanVariety(info.getProdname()); //产品代码
			monitor.setCustName(info.getCustname());//客户名称
			monitor.setCustCode(info.getCustid());//客户编号
			monitor.setLoanAmt(info.getTcapi()==null?0:(info.getTcapi()).doubleValue());//贷款金额
			monitor.setLoanBalance(info.getBal()==null?0:(info.getBal()).doubleValue());//贷款余额
			monitor.setLoanTerm(info.getTterm()==null?"":(info.getTterm()).toString());//贷款期限
			monitor.setWaykind(cust==null?"":cust.getWaykind());//所属行业
			monitor.setAssukind(info.getAssukind());//担保方式
			monitor.setFloatinterate(info.getFloatinterate()==null?0:(info.getFloatinterate()).doubleValue());//浮动比例
			monitor.setAcflag(info.getAcflag());//账户状态
			monitor.setRiskflag(info.getRiskflag());//风险分类
			monitor.setBankId(info.getBankid());//经办人业务机构
			//设置预警等级
			String level=(String)CommonService.getInstance().findSqlOneBySpringJdbc(
					"select  t.FD_RANK_FINAL from T_PL_TASK_RISK_RANK t where t.FD_ACC_ID='"+monitor.getLoanAcct()+"'",String.class);
			monitor.setWarnLevel(level);

			service.save(monitor);
//		    if(tPlTaskRuleTrig.getRuleCode()==null&&tPlTaskRuleTrig.getId()==null){//未触发规则客户
//				tPlTaskRuleTrig.setAccId(monitor.getLoanAcct());
//				tPlTaskRuleTrigService.save(tPlTaskRuleTrig);
//			}else {
//				tPlTaskRuleTrigService.update(tPlTaskRuleTrig);//修改规则预警 结果表
//			}
		    if(tPlTaskRuleTrig!=null){//人工触发预警处置报告
				tPlTaskRuleTrigService.update(tPlTaskRuleTrig);//修改规则预警 结果表 	
			}
			
			//启动任务
			String procKey=FileUpDownProperties.readValue(YJ_MONITOR_PROCESS);
			ProcessManagerService pms=ProcessManagerService.getInstace();
			Map<String, Object> map=new HashMap<String, Object>();
			
			if(monitor.getHandler()==null){
				Integer dicType=Integer.parseInt(FileUpDownProperties.readValue(GenerateDqMonitorTaskOperation.TASK_DISTRIBUTE_MNG_TYPE));
				String dicNo=FileUpDownProperties.readValue(GenerateDqMonitorTaskOperation.TASK_DISTRIBUTE_MNG_CODE);
				String dicName=DataDicService.getInstance().getNameByTypeNo(dicType,dicNo);
				TlrInfo tlr=TlrInfoService.getInstance().getTlrInfoByTlrno(dicName);
				map.put("assignee",tlr.getTlrno());
			}else{
				map.put("assignee",monitor.getHandler().getTlrno());
			}
			
			//map.put("assignee",monitor.getHandler().getTlrno());
			map.put("desc",BpmDescUtil.getDesc(monitor.getId(),monitor.getLoanAcct(),monitor.getCustName()));
			pms.startProcess(monitor.getId(),procKey,(String)map.get("assignee"),map);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(monitor);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(monitor);
		}
	}
}
