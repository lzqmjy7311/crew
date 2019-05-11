package com.huateng.ebank.business.parammng.operation;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.BhProcStepDAO;
import com.huateng.ebank.entity.data.mng.BhProcStep;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * @author weikun wang
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BhProcStepAddOperationNew extends BaseOperation{
	public static final String IN_DEL = "IN_DEL";

	public static final String IN_INSERT = "IN_INSERT";

	public static final String IN_UPDATE = "IN_UPDATE";

	private final static Log log = LogFactory.getLog(BhProcStepAddOperationNew.class);

	//----------------------------------覆盖父类的beforeProc（）方法-------------------------------------
	public void beforeProc(OperationContext context) throws CommonException {
	}

	//----------------------------------覆盖execute()方法---------------------------------------------------
	public void execute(OperationContext context) throws CommonException {
		BhProcStepDAO bhProcStepDao = DAOUtils.getBatchProcessStepDAO ();
		List delList = (List) context.getAttribute(IN_DEL);
		List insertList = (List) context.getAttribute(IN_INSERT);
		List updateList = (List) context.getAttribute(IN_UPDATE);
		for (Iterator it = delList.iterator(); it.hasNext();) {

			BhProcStep bhProcStep = (BhProcStep) it.next();
			bhProcStepDao.delete(bhProcStep.getId().intValue());
			//直接删除-----------------------
		}
		//-----------------------插入-------------------------------------------------------------------------------
		for (Iterator it = insertList.iterator(); it.hasNext();) {

			BhProcStep bhProcStep = (BhProcStep) it.next();

			BhProcStep bps = new BhProcStep();
//			try {
//			   bps = bhProcStepDao.query(bhProcStep.getId());
//			} catch(Exception e) {
//			}
//
//			//boolean insert = true;
//			if(bps != null) {
//				ExceptionUtil.throwCommonException("已经存在批量编号：" + bps.getId() + "，不能新增此批量",
//						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//			}else{
//				bps = new BhProcStep();}
//			bps.setId             (bhProcStep.getId             (     ))   ;
			bps.setJobno          (bhProcStep.getJobno          (     ))   ;
			bps.setStep           (bhProcStep.getStep           (     ))   ;
			bps.setSubStep        (bhProcStep.getSubStep        (     ))   ;
			bps.setProcessFunction(bhProcStep.getProcessFunction(     ))   ;
			bps.setProcessParam   (bhProcStep.getProcessParam   (     ))   ;
			bps.setProcessTlrno   (bhProcStep.getProcessTlrno   (     ))   ;
			bps.setRuntime        (bhProcStep.getRuntime        (     ))   ;
			bps.setSubFlag        (bhProcStep.getSubFlag        (     ))   ;
			bps.setReportFlag     (bhProcStep.getReportFlag     (     ))   ;
			bps.setMaxproc        (bhProcStep.getMaxproc        (     ))   ;
			bps.setTempFlag       (bhProcStep.getTempFlag       (     ))   ;
			bps.setSuspend        (bhProcStep.getSuspend        (     ))   ;
			//bps.setSingleFlag     (bhProcStep.getSingleFlag     (     ))   ;
			bps.setDesc0           (bhProcStep.getDesc0           (     ))   ;
			bps.setDesc1          (bhProcStep.getDesc1          (     ))   ;
			bps.setDesc2          (bhProcStep.getDesc2          (     ))   ;

			bhProcStepDao.insert(bps);

		}
		//---------------------------------------------更新--------------------------------------------
		for (Iterator it = updateList.iterator(); it.hasNext();) {

			BhProcStep bhProcStep = (BhProcStep) it.next();

			BhProcStep bps = null;
			try {
			   bps = bhProcStepDao.query(bhProcStep.getId().intValue());
			} catch(Exception e) {
			}

			bps.setId             (bhProcStep.getId             (     ))   ;
			bps.setJobno          (bhProcStep.getJobno          (     ))   ;
			bps.setStep           (bhProcStep.getStep           (     ))   ;
			bps.setSubStep        (bhProcStep.getSubStep        (     ))   ;
			bps.setProcessFunction(bhProcStep.getProcessFunction(     ))   ;
			bps.setProcessParam   (bhProcStep.getProcessParam   (     ))   ;
			bps.setProcessTlrno   (bhProcStep.getProcessTlrno   (     ))   ;
			bps.setRuntime        (bhProcStep.getRuntime        (     ))   ;
			bps.setSubFlag        (bhProcStep.getSubFlag        (     ))   ;
			bps.setReportFlag     (bhProcStep.getReportFlag     (     ))   ;
			bps.setMaxproc        (bhProcStep.getMaxproc        (     ))   ;
			bps.setTempFlag       (bhProcStep.getTempFlag       (     ))   ;
			bps.setSuspend        (bhProcStep.getSuspend        (     ))   ;
			//bps.setSingleFlag     (bhProcStep.getSingleFlag     (     ))   ;
			bps.setDesc0           (bhProcStep.getDesc0           (     ))   ;
			bps.setDesc1          (bhProcStep.getDesc1          (     ))   ;
			bps.setDesc2          (bhProcStep.getDesc2          (     ))   ;

			bhProcStepDao.update(bps);

		}


	}
	//----------------------------覆盖afterProc（）方法---------------------------------------------------------
	public void afterProc(OperationContext context) throws CommonException {

	}

}
