package com.gbicc.company.single.operation;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.company.single.entity.TCmSingleRulCases;
import com.gbicc.company.single.service.TCmSingleRulCasesService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCmSingleRulCasesMngOperation extends BaseOperation {

	public static final String ID = TCmSingleRulCasesMngOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	public static final String CASES_DRAFT_STATUS="1";//案例-草稿状态
	public static final String SUB_FLAG="sub";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(OperationContext context) throws CommonException {
		TCmSingleRulCases cases = (TCmSingleRulCases) context.getAttribute("cases");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String orgId=info.getBrcode();
		String op=(String) context.getAttribute("op");
		TCmSingleRulCasesService service = TCmSingleRulCasesService.getInstance();
		try {
			if(op.equals("addCases")){
				String sql="SELECT 'AL'||to_char(current date,'YYYYMMDD')||substr('000'||SINGLE_RUL_CASES_NO.nextval,length('000'||SINGLE_RUL_CASES_NO.nextval)-2) FROM dual";
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				Iterator it=rootdao.queryBySQL(sql);
				while(it.hasNext()){
					cases.setCasesCode(it.next().toString());
				}
				cases.setCreateDt(new Date());
				cases.setCreateOrg(BctlService.getInstance().getBctlByBrcode(orgId));
				cases.setCreateUser(TlrInfoService.getInstance().getTlrInfoByTlrno(userId));
				cases.setCasesStatus(CASES_DRAFT_STATUS);
				if(info.getBrClass().equals("1")){
					cases.setHandleOrgFlag(TCmSingleRulWarningOperation.HEAD_FLAG);
				}else{
					cases.setHandleOrgFlag(SUB_FLAG);
				}
				service.save(cases);
				
				//启动案例审核流程
				String procKey=FileUpDownProperties.readValue(TCmSingleRulWarningOperation.SINGLE_RULE_CASES_PROCESS_BRANCH);
				if(cases.getHandleOrgFlag().equals(TCmSingleRulWarningOperation.HEAD_FLAG)){
					procKey=FileUpDownProperties.readValue(TCmSingleRulWarningOperation.SINGLE_RULE_CASES_PROCESS);
				}
				ProcessManagerService processManagerService=ProcessManagerService.getInstace();
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("assignee",userId);
				map.put("desc","业务ID:"+cases.getId()+",案例编号:"+cases.getCasesCode()+",案例名称:"+cases.getCasesName());
				processManagerService.startProcess(cases.getId(),procKey, userId, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("系统异常",e.getMessage());
		}
	}
}
