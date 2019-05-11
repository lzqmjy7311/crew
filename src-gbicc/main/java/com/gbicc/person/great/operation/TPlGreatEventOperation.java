package com.gbicc.person.great.operation;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.great.entity.TPlGreatEvent;
import com.gbicc.person.great.service.TPlGreatEventService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPlGreatEventOperation extends BaseOperation {

	public static final String ID = TPlGreatEventOperation.class.getSimpleName();
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

	@Override
	public void execute(OperationContext context) throws CommonException {
		TPlGreatEvent ge = (TPlGreatEvent) context.getAttribute(IN_PARAM);
		TPlGreatEventService service = TPlGreatEventService.getInstance();
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String[] str=ge.getContent().split("_");
		ge.setContentCode(str[0]);
		ge.setLevel(str[1]);
		if(StringUtils.isNotEmpty(ge.getId())){
			service.update(ge);
		}else{
			ge.setRegiDate(new Date());
			ge.setRegiUser(TlrInfoService.getInstance().getTlrInfoByTlrno(userId));
			service.save(ge);
		}
	}
}