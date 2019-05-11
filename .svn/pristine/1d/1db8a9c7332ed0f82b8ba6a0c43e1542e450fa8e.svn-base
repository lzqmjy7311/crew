package com.huateng.ebank.business.management.operation;

import com.huateng.ebank.business.management.service.HolidayService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class HolidayDetailUpdateOperation extends BaseOperation {
	public static final String ID = "Management.HolidayDetailUpdateOperation";
	public static final String INPUT_YEAR = "INPUT_YEAR";
	public static final String INPUT_CMD = "INPUT_CMD";
	public static final String INPUT_CMD_ADD = "INPUT_CMD_ADD";
	public static final String INPUT_CMD_UPDATE = "INPUT_CMD_UPDATE";
	public static final String INPUT_HOLIDAYDEF = "INPUT_HOLIDAYDEF";

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {

		//add by mengying.wang 20090819 jira:1537 begin
		/* 此处加入权限控制 */
//		GlobalInfo gi = GlobalInfo.getCurrentInstance();
//		String brClass = gi.getBrhClass();
//		if ( brClass.equalsIgnoreCase(SystemConstant.BRCODE_CLASS_HEAD) != true ){
//			ExceptionUtil.throwAppException("非总行级操作员！不可修改参数", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//		}
		//add by mengying.wang 20090819 jira:1537 end


		String year = (String)context.getAttribute(INPUT_YEAR);
		String holidayDef = (String)context.getAttribute(INPUT_HOLIDAYDEF);
		String cmd = (String)context.getAttribute(INPUT_CMD);
		if( cmd.equals(INPUT_CMD_UPDATE)){
			HolidayService.getInstance().updateHoliday(year,holidayDef);
		}else if(cmd.equals(INPUT_CMD_ADD)){
			//holidayDef = HolidayService.getInstance().getWeekendInfo(new Integer(year).intValue());
			HolidayService.getInstance().addHoliday(year,holidayDef);
		}
	}

}
