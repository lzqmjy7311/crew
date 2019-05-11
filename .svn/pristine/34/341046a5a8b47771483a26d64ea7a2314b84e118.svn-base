package com.gbicc.person.customer.opration;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.common.CommonService;
import com.gbicc.person.customer.entity.GreatEvent;
import com.gbicc.person.customer.entity.TPlCustGreatEvent;
import com.gbicc.person.customer.entity.TPlCustGreatEventDtl;
import com.gbicc.person.customer.service.TPlCustGreatEventDtlService;
import com.gbicc.person.customer.service.TPlCustGreatEventService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPlCustGreatEventDtlOperation extends BaseOperation {

	public static final String ID = TPlCustGreatEventDtlOperation.class.getSimpleName();
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
		String custId=(String) context.getAttribute("custId");
		GreatEvent greatEvent = (GreatEvent) context.getAttribute(IN_PARAM);
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		TPlCustGreatEventDtlService service = TPlCustGreatEventDtlService.getInstance();
		TPlCustGreatEventService eventService=TPlCustGreatEventService.getInstance();
		CommonService commonService=CommonService.getInstance();
		Field[] fields=GreatEvent.class.getDeclaredFields();
		
		//不需要走流程，也不会被引用，修改记录时直接删除当前记录，再新增。
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		commonService.executeHQL("delete from TPlCustGreatEventDtl where eventId=(select id from TPlCustGreatEvent where custId='"+custId+"' and TO_DATE(registerDate,'yyyy-mm-dd')='"+simple.format(new Date())+"') ");
		commonService.executeHQL("delete from TPlCustGreatEvent where custId='"+custId+"' and TO_DATE(registerDate,'yyyy-mm-dd')='"+simple.format(new Date())+"' ");
		
		TPlCustGreatEvent custGreatEvent=new TPlCustGreatEvent();
		custGreatEvent.setCustId(custId);
		custGreatEvent.setId(null);
		custGreatEvent.setRegisterDate(new Date());
		custGreatEvent.setRegisterUser(TlrInfoService.getInstance().getTlrInfoByTlrno(userId));
		eventService.save(custGreatEvent);
		
		for(int i=0;i<fields.length;i++){
			Field f=fields[i];
			try {
				if(f.getName().indexOf("Desc")<0){
					TPlCustGreatEventDtl dtl=new TPlCustGreatEventDtl();
					dtl.setEventName(f.getName());
					
					Field field=GreatEvent.class.getField(f.getName());
					Object obj=field.get(greatEvent);
					if(null!=obj && StringUtils.isNotBlank(obj.toString())){
						dtl.setEventValue(obj.toString());
					}
					Field field2=GreatEvent.class.getField(f.getName()+"Desc");
					Object obj2=field2.get(greatEvent);
					if(null!=obj2 && StringUtils.isNotBlank(obj2.toString())){
						dtl.setEventDesc(obj2.toString());
					}
					
					dtl.setEventId(custGreatEvent.getId());
					dtl.setEventLevel("1");
					service.save(dtl);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
}
