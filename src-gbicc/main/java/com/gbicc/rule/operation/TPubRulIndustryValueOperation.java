package com.gbicc.rule.operation;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.rule.entity.TPubRulIndustryValue;
import com.gbicc.rule.service.TPubRulIndustryValueService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPubRulIndustryValueOperation extends BaseOperation {

	public static final String ID = TPubRulIndustryValueOperation.class.getSimpleName();
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
		String op = (String) context.getAttribute("op");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		List<TPubRulIndustryValue> list=(List<TPubRulIndustryValue>) context.getAttribute("list");
		TPubRulIndustryValueService service = TPubRulIndustryValueService.getInstance();
		if(op.equals("add")){
			for(int i=0;i<list.size();i++){
				TPubRulIndustryValue value=list.get(i);
				value.setId(null);
				value.setUpdateUser(userId);
				value.setUpdateDt(new Date());
				service.save(value);
			}
		}else if(op.equals("update")){
			for(int i=0;i<list.size();i++){
				TPubRulIndustryValue value=list.get(i);
				value.setUpdateUser(userId);
				value.setUpdateDt(new Date());
				if(StringUtils.isEmpty(value.getIndustryCode())){
					value.setIndustryCode(null);
				}
				service.update(value);
			}
		}
	}
}
