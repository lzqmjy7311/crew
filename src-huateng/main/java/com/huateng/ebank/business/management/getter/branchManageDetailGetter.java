package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.management.bean.branchManageDetail;
import com.huateng.ebank.business.management.service.branchManageDetailService;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.entity.data.mng.SysTaskLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;

public class branchManageDetailGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		String action = this.getCommQueryServletRequest().getParameter("action");
		String st = this.getCommQueryServletRequest().getParameter("st");
		List list = new ArrayList();

		String id = this.getCommQueryServletRequest().getParameter("id");
		String flag = this.getCommQueryServletRequest().getParameter("flag");
		String tskId = this.getCommQueryServletRequest().getParameter("tskId");
		try {
			ReportTaskUtil rt = new ReportTaskUtil();
			if ("detail".equals(action)) {
				if ("0".equals(flag)) {
					branchManageDetail ber = new branchManageDetail();

					Bctl oldbean = branchManageDetailService.selectById(id);

					Bctl newBean = null;

					ber.setOld_bctl(oldbean);

					// 从审计任务中获取

					Iterator it = ReportShowDetailService.getInstance().selectByKey(id);
					Class cls = null;
					while (it.hasNext()) {
						SysTaskInfo tem = (SysTaskInfo) it.next();
						Object temp = rt.getObjctBySysTaskInfo(tem);
						cls = temp.getClass();
						if (cls.equals(Bctl.class)) {
							newBean = (Bctl) temp;
						}

					}

					ber.setBctl(newBean);
					list.add(ber);

				}else if ("1".equals(flag)) {
					SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(tskId);
					Bctl oldValue = null;
					Bctl newValue = null;
					branchManageDetail bmd = new branchManageDetail();

					if (systasklog.getOldVal1() != null) {

						oldValue = (Bctl) rt.getOldObjectByTaskLog(systasklog);

					}
					if (systasklog.getNewVal1() != null) {

						newValue = (Bctl) rt.getNewObjectByTaskLog(systasklog);

					}
					// 新增的时候
					if (st.equals("1")) {
						bmd.setOld_bctl(newValue);

					}
					// 修改的时候
					else if (st.equals("2")) {
						bmd.setBctl(newValue);
						bmd.setOld_bctl(oldValue);
					}
					// 删除的时候
					else if (st.equals("3")) {
						bmd.setOld_bctl(oldValue);
					}

					list.add(bmd);

				}

			}

			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
			getResult().setContent(list);
			getResult().getPage().setTotalPage(1);
			getResult().init();
			

			return getResult();
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}
}
