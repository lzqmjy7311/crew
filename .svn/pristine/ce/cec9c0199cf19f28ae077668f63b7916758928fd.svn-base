package com.huateng.ebank.business.branchmng.operation;

import java.io.IOException;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.BctlDAO;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

public class BranchMngOperation extends BaseOperation {

	public static final String ID = "management.BranchMngOperation";
	public static final String CMD = "cmd";
	public static final String IN_BRHID = "IN_BRHID";
	public static final String IN_PARAM = "IN_PARAM";

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
	 * ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		BctlDAO bctlDAO = DAOUtils.getBctlDAO();
		if ("status".equals(context.getAttribute(CMD))) {
			String brhid = (String) context.getAttribute(IN_BRHID);
			String status = (String) context.getAttribute(IN_PARAM);
			//往bctl表中插入数据的bean
			Bctl bctl = bctlDAO.query(brhid);
			//有效变为无效的处理
			if("0".equals(status)){


				//序列华后往taskInfo中插入数据

				SysTaskInfo taskInfo;
				try {
					Bctl bctlTaskInfo=bctlDAO.query(brhid);
					bctlTaskInfo.setLock(true);
					bctlTaskInfo.setStatus(status);

					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100199.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,bctlTaskInfo, bctlTaskInfo.getBrcode(),bctlTaskInfo.getSt() );
					ReportShowDetailService.getInstance().addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//bctl.setLock(true);
				bctl.setSt(ReportEnum.REPORT_ST1.ET.value);

                bctl.setStatus(ReportEnum.REPORT_VAILD.YES.value);
				bctlDAO.getHibernateTemplate().update(bctl);


			}
			//无效变为 有效的处理
			else{

				SysTaskInfo taskInfo;
				try {
					Bctl bctlTaskInfo=bctlDAO.query(brhid);
					bctlTaskInfo.setLock(true);
					bctlTaskInfo.setStatus(status);

					taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100199.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,bctlTaskInfo, bctlTaskInfo.getBrcode(),bctlTaskInfo.getSt() );
					ReportShowDetailService.getInstance().addTosystaskinfo(taskInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bctl.setSt(ReportEnum.REPORT_ST1.ET.value);

                bctl.setStatus(ReportEnum.REPORT_VAILD.NO.value);
				bctlDAO.getHibernateTemplate().update(bctl);



			}



		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}