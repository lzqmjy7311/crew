package com.gbicc.rule.operation;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.common.CommonService;
import com.gbicc.rule.entity.TPubRulIndustryValue;
import com.gbicc.rule.service.TPubRulIndustryValueService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPubRulIndustryValueDelOperation extends BaseOperation {

	public static final String ID = TPubRulIndustryValueDelOperation.class.getSimpleName();
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
		String rulCode = (String) context.getAttribute("rulCode");
		String industryCode = (String) context.getAttribute("industryCode");
		CommonService service=CommonService.getInstance();
		TPubRulIndustryValueService valueService = TPubRulIndustryValueService.getInstance();
		if(StringUtils.isNotEmpty(rulCode) && StringUtils.isNotEmpty(industryCode)){
			List<TPubRulIndustryValue> list=valueService.dao().queryByCondition("from TPubRulIndustryValue where rulCode='"+rulCode+"' and industryCode='"+industryCode+"' ");
			if(null!=list && list.size()>0){
				for(int i=0;i<list.size();i++){
					service.delete(list.get(i));
				}
			}
		}
	}
}
