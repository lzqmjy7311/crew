package com.huateng.ebank.business.approve.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.approve.bean.SysParamsSecDetailBean;
import com.huateng.ebank.business.approve.service.SysParamsService;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.entity.data.mng.PfSysParamPK;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.entity.data.mng.SysTaskLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;

public class SysParamsSecDetailGetter extends BaseGetter {

	public Result call() throws AppException {
		String action = this.getCommQueryServletRequest().getParameter("action");

		List list = new ArrayList();
		String id = this.getCommQueryServletRequest().getParameter("id");
		String st = this.getCommQueryServletRequest().getParameter("st");
		String flag = this.getCommQueryServletRequest().getParameter("flag");
		String tskId = this.getCommQueryServletRequest().getParameter("tskId");

		String sid[] = id.split("\\|");
		String id1 = sid[0];
		String id2 = sid[1];

		PfSysParamPK pk = new PfSysParamPK();
		pk.setMagicId(id1);
		pk.setParamId(id2);

		try {

			if ("detail".equals(action)) {
				SysParamsSecDetailBean ber = new SysParamsSecDetailBean();

				// 从审计任务中获取
				ReportTaskUtil rt = new ReportTaskUtil();
				if ("0".equals(flag)) {
					Iterator its = SysParamsService.getInstance().selectID(id2, id1);
					PfSysParam oldbean = null;
					while (its.hasNext()) {
						oldbean = (PfSysParam) its.next();
					}
					PfSysParam newBean = null;
					ber.setOld_pfsysparam(oldbean);
					Iterator it = ReportShowDetailService.getInstance().selectByKey(id);
					Class cls = null;
					while (it.hasNext()) {
						SysTaskInfo tem = (SysTaskInfo) it.next();
						Object temp = rt.getObjctBySysTaskInfo(tem);
						cls = temp.getClass();
						if (cls.equals(PfSysParam.class)) {
							newBean = (PfSysParam) temp;
							ber.setPfsysparam(newBean);
						}

					}
					list.add(ber);

				} else if ("1".equals(flag)) {
					SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(tskId);
					PfSysParam newBean = null;
					PfSysParam oldbean = null;
					SysParamsSecDetailBean spsb = new SysParamsSecDetailBean();

					if (systasklog.getOldVal1() != null) {

						oldbean = (PfSysParam) rt.getOldObjectByTaskLog(systasklog);

					}
					if (systasklog.getNewVal1() != null) {

						newBean = (PfSysParam) rt.getNewObjectByTaskLog(systasklog);

					}
					// 新增的时候
					if (st.equals("1")) {
						spsb.setOld_pfsysparam(newBean);

					}
					// 修改的时候
					else if (st.equals("2")) {
						spsb.setOld_pfsysparam(oldbean);
						spsb.setPfsysparam(newBean);
					}
					// 删除的时候
					else if (st.equals("3")) {
						spsb.setOld_pfsysparam(oldbean);
					}

					list.add(spsb);

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
