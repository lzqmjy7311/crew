package com.gbicc.company.single.operation;

import java.util.List;

import com.gbicc.common.CommonService;
import com.gbicc.company.single.entity.TCmSingleRulCasesDutyinfo;
import com.gbicc.company.single.service.TCmSingleRulCasesDutyinfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCmSingleRulCasesDutyinfoOperation extends BaseOperation {

	public static final String ID = TCmSingleRulCasesDutyinfoOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		String casesId=(String) context.getAttribute("casesId");
		List<TCmSingleRulCasesDutyinfo> list = (List<TCmSingleRulCasesDutyinfo>) context.getAttribute("list");
		TCmSingleRulCasesDutyinfoService service = TCmSingleRulCasesDutyinfoService.getInstance();
		CommonService commonService=CommonService.getInstance();
		if(null!=list && list.size()>0){
			//删除原数据（若有）
			commonService.executeHQL("delete from TCmSingleRulCasesDutyinfo where casesId='"+casesId+"' ");
			for(TCmSingleRulCasesDutyinfo dutyinfo:list){
				dutyinfo.setId(null);
				dutyinfo.setCasesId(casesId);
				service.save(dutyinfo);
			}
		}
	}
}
