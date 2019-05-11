package com.huateng.ebank.business.management.operation;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.bean.FunctionInfoBean;
import com.huateng.ebank.business.management.service.FunctionInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * Title: FunctionInfoMngOperation Description: ��Դ����OP Company: Shanghai
 * Huateng Software Systems Co., Ltd.
 * 
 * @author jimmy.peng
 * @date 2010-11-12
 */
public class FunctionInfoMngOperation extends BaseOperation {

	private static Log log = LogFactory.getLog(FunctionInfoMngOperation.class);

	public static final String IN_PARAM = "IN_PARAM";

	public static final String CMD = "CMD";

	public static final String IN_PARAM_PAGESIZE = "IN_PARAM_PAGESIZE";

	public static final String IN_PARAM_PAGEINDEX = "IN_PARAM_PAGEINDEX";

	public static final String OUT_PARAM = "OUT_PARAM";

	public static final String ID = "systemmng.FunctionInfoMngOperation";

	public static final String IN_DEL = "IN_DEL";

	public static final String IN_INSERT = "IN_INSERT";

	public static final String IN_UPDATE = "IN_UPDATE";

	public static transient final String REBUILD_ALL = "REBUILD_ALL";
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		if (log.isDebugEnabled()) {
			log.debug("enter into execute");
		}

		String cmd = (String) context.getAttribute(CMD);
		FunctionInfoService fiService = FunctionInfoService.getInstance();

		if ("queryFunctionInfoLst".equals(cmd)) // ��ѯ��ԴLST
			queryFunctionInfoLst(context, fiService);
		else if ("queryFunctionInfoSingle".equals(cmd)) // ��ѯָ����Դ��Ϣ
			queryFunctionInfoSingle(context, fiService);
		else if ("saveUpdateDeleteFucInfo".equals(cmd)) // ��ɾ��ָ����Դ��Ϣ
			saveUpdateDeleteFucInfo(context, fiService);
		else if (REBUILD_ALL.equals(cmd)) {
			this.rebuildAll(context, fiService);
		}

		if (log.isDebugEnabled()) {
			log.debug("Exit execute");
		}
	}

	@Override
	public void afterProc(OperationContext paramOperationContext) throws CommonException {
	}

	/**
	 * Description: ��ѯ��Դ�б�
	 * 
	 * @param context
	 * @param fiService
	 * @throws CommonException
	 */
	private void queryFunctionInfoLst(OperationContext context, FunctionInfoService fiService) throws CommonException {
		FunctionInfoBean fibean = (FunctionInfoBean) context.getAttribute(IN_PARAM);
		Integer pageSizeI = (Integer) context.getAttribute(IN_PARAM_PAGESIZE);
		Integer pageIndexI = (Integer) context.getAttribute(IN_PARAM_PAGEINDEX);
		PageQueryResult result = fiService.queryFunctionInfoLst(fibean, pageSizeI.intValue(), pageIndexI.intValue());
		context.setAttribute(OUT_PARAM, result);
	}

	/**
	 * Description: ��ѯ�Զ���Դ��Ϣ
	 * 
	 * @param context
	 * @param fiService
	 * @throws CommonException
	 */
	private void queryFunctionInfoSingle(OperationContext context, FunctionInfoService fiService)
			throws CommonException {
		queryFunctionInfoLst(context, fiService); // ͬ��ѯ��Դ�б?������funcid��λΨһ��
	}

	/**
	 * 
	 * Description: rebuild all functioninfo
	 * 
	 * @param context
	 * @param fiserService
	 * @throws CommonException
	 */
	private void rebuildAll(OperationContext context, FunctionInfoService fiserService) throws CommonException {
		fiserService.rebuildAll((List<FunctionInfoBean>) context.getAttribute(IN_INSERT),Integer.valueOf((String)context.getAttribute("location")));
	}

	/**
	 * 
	 * Description: ��ɾ����Դ��Ϣ
	 * 
	 * @param context
	 * @param tlrMngService
	 * @throws CommonException
	 */
	private void saveUpdateDeleteFucInfo(OperationContext context, FunctionInfoService fiService)
			throws CommonException {
		List delList = (List) context.getAttribute(IN_DEL);
		List insertList = (List) context.getAttribute(IN_INSERT);
		List updateList = (List) context.getAttribute(IN_UPDATE);
		fiService.saveUpdateDeleteFucInfo(delList, insertList, updateList);
	}
}
