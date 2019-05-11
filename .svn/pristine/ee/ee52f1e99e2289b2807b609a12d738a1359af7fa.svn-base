package com.gbicc.company.single.operation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.company.single.entity.TCmSingleRulWarning;
import com.gbicc.company.single.service.TCmSingleRulWarningService;
import com.gbicc.person.monitor.operation.GenerateDqMonitorTaskOperation;
import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class GenerateSingleRulWarningTaskOperation extends BaseOperation {

	public static final String ID = GenerateSingleRulWarningTaskOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	public static final String HEAD_BANK_FXJC="head_bank_fxjc";//总行风险监测岗
	public static final String SUBBRANCH_FXJC="subbranch_fxjc";//分支行风险监测岗
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(OperationContext context) throws CommonException {
		try {
			String id=(String) context.getAttribute("id");
			String orgId=(String) context.getAttribute("orgId");
			TCmSingleRulWarning warning=TCmSingleRulWarningService.getInstance().get(id);
			ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
			//任务机构
			warning.setTaskOrg(orgId);
			//任务编号
			String sql="SELECT 'DR'||to_char(current date,'YYYYMMDD')||substr('000000'||SINGLE_RUL_WARN_NO.nextval,"
			+ "length('000000'||SINGLE_RUL_WARN_NO.nextval)-5) FROM dual";
			Iterator it=rootdao.queryBySQL(sql);
			while(it.hasNext()){
				warning.setTaskCode(it.next().toString());
			}
			
			ProcessManagerService pms=ProcessManagerService.getInstace();
			//根据处理机构标识获取流程关键字及角色ID
			String procKey=FileUpDownProperties.readValue(TCmSingleRulRemoveWarningOperation.SINGLE_RULE_WARN_PROCESS_BRANCH);
			String roleId=FileUpDownProperties.readValue(SUBBRANCH_FXJC);
			if(warning.getHandleOrgFlag().equals(TCmSingleRulWarningOperation.HEAD_FLAG)){
				procKey=FileUpDownProperties.readValue(TCmSingleRulRemoveWarningOperation.SINGLE_RULE_WARN_PROCESS);
				roleId=FileUpDownProperties.readValue(HEAD_BANK_FXJC);
			}
			//启动流程
			List<String> list=pms.findUserIdByRoleidAndOrgid(roleId,orgId);
			if(null==list || list.size()==0){
				Integer dicType=Integer.parseInt(FileUpDownProperties.readValue(GenerateDqMonitorTaskOperation.TASK_DISTRIBUTE_MNG_TYPE));
				String dicNo=FileUpDownProperties.readValue(GenerateDqMonitorTaskOperation.TASK_DISTRIBUTE_MNG_CODE);
				String dicName=DataDicService.getInstance().getNameByTypeNo(dicType,dicNo);
				list.add(TlrInfoService.getInstance().getTlrInfoByTlrno(dicName).getTlrno());
			}
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("assignee",list.get(0));
			map.put("desc","业务ID:"+warning.getId()+",预警编号:"+warning.getWarnCode()+",规则编号:"+warning.getRulCode());
			pms.startProcess(warning.getId(),procKey,list.get(0),map);
			//更改预警记录表状态
			warning.setWarnStatus(TCmSingleRulWarningOperation.WAIT_HANDLE_STATUS);
			TCmSingleRulWarningService.getInstance().update(warning);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
