package com.huateng.ebank.business.management.operation;

import com.huateng.ebank.business.management.service.SystemParamService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class SystemParamOperation extends BaseOperation {
	public static final String ID = "Management.SystemParamOperation";
	public static final String CMD = "CMD";
	public static final String OUT_BIG_GAGE_CLASS_LIST = "OUT_BIG_GAGE_CLASS_LIST";
	public static final String OUT_SMALL_GAGE_CLASS_LIST = "OUT_SMALL_GAGE_CLASS_LIST";
	public static final String INSERT_GAGE_CLASS_LIST = "INSERT_GAGE_CLASS_LIST";
	public static final String UPDATE_GAGE_CLASS_LIST = "UPDATE_GAGE_CLASS_LIST";
	public static final String CMD_SELECT_WARNING_CODE_LIST = "CMD_SELECT_WARNING_CODE_LIST";
	public static final String OUT_WARNING_CODE_LIST = "OUT_WARNING_CODE_LIST";
	public static final String CMD_MODIFY_WARNING_CODE = "CMD_MODIFY_WARNING_CODE";

	public void afterProc(OperationContext context) throws CommonException {

	}

	public void beforeProc(OperationContext context) throws CommonException {

	}

	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		String gageUpCode = (String) context.getAttribute("gageUpCode");
		String gageCode = (String) context.getAttribute("gageCode");
		SystemParamService sps = SystemParamService.getInstance();
		// 获得所有押品大类列表
//		if (cmd.equals("SELECT_BIG_GAGE_CLASS")) {
//			context.setAttribute(OUT_BIG_GAGE_CLASS_LIST, sps
//					.getAllBigGageClass(gageCode));
//		}
//		// 获得所有押品小类列表
//		else if (cmd.equals("SELECT_SMALL_GAGE_CLASS")) {
//			context.setAttribute(OUT_SMALL_GAGE_CLASS_LIST, sps
//					.getSmallGageClassList(gageUpCode));
//		}
//		// 新增更新押品大类
//		else if (cmd.equals("UPDATE_BIG_GAGE_CLASS")) {
//			sps.iuBigGageClass((List) context
//					.getAttribute(INSERT_GAGE_CLASS_LIST), (List) context
//					.getAttribute(UPDATE_GAGE_CLASS_LIST));
//		}
//		// 新增更新押品小类
//		else if (cmd.equals("UPDATE_SMALL_GAGE_CLASS")) {
//			sps.iuSmallGageClass((List) context
//					.getAttribute(INSERT_GAGE_CLASS_LIST), (List) context
//					.getAttribute(UPDATE_GAGE_CLASS_LIST));
//		}
//		// 查询预警信号代码列表
//		else if (StringUtils.equals(cmd, CMD_SELECT_WARNING_CODE_LIST)) {
//			context.setAttribute(OUT_WARNING_CODE_LIST, sps
//					.getWarningCodeList());
//		}
//		// 增删改预警信号代码
//		else if (StringUtils.equals(cmd, CMD_MODIFY_WARNING_CODE)) {
//			List insertList = (List) context.getAttribute("insertList");
//			List updateList = (List) context.getAttribute("updateList");
//			List deleteList = (List) context.getAttribute("deleteList");
//			sps.modifyWarningCode(insertList, updateList, deleteList);
//		}
//		// 根据条件获取押品类型信息
//		else if (cmd.equals("SELECT_GAGE_CLASSINFO")) {
//			String gageLevel = (String) context.getAttribute("gageLevel");
//			String gageType = (String) context.getAttribute("gageType");
//			context.setAttribute(OUT_BIG_GAGE_CLASS_LIST, sps
//					.getGageClassByCondition(gageLevel, gageType));
//		}
//		// 根据押品大类获取押品小类信息
//		else if (cmd.equals("SELECT_SMALL_GAGE_CLASSINFO")) {
//			String gageLevel = (String) context.getAttribute("gageLevel");
//			context.setAttribute(OUT_SMALL_GAGE_CLASS_LIST, sps
//					.getSmallGageClassByCondition(gageUpCode, gageLevel));
//		} else if (cmd.equals("SELECT_POSS_SMALL_GAGE_CLASSINFO")) {
//			String gageType = (String) context.getAttribute("gageType");
//			context.setAttribute(OUT_SMALL_GAGE_CLASS_LIST, sps
//					.getGageClassByCondition("2", gageType));
//		}
	}

}
