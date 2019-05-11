package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.management.bean.BiNationregionEntryDetail;
import com.huateng.ebank.business.management.service.BiNationregionService;
import com.huateng.ebank.entity.data.mng.BiNationregion;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.entity.data.mng.SysTaskLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;

/**
 *
 * author by 计翔 2012.9.5 国家地区代码维护的getter
 */
public class BiNationregionEntryDetailGetter extends BaseGetter {
	public Result call() throws AppException {
		String action = this.getCommQueryServletRequest().getParameter("action");
		String st = this.getCommQueryServletRequest().getParameter("st");
		List list = new ArrayList();

		String id = this.getCommQueryServletRequest().getParameter("id");
		String flag = this.getCommQueryServletRequest().getParameter("flag");
		String tskId = this.getCommQueryServletRequest().getParameter("tskId");

		try {

			if ("detail".equals(action)) {
				// 从审计任务中获取
				ReportTaskUtil rt = new ReportTaskUtil();
				if ("0".equals(flag)) {
					// rt=new ReportTaskUtil();

					Iterator it = ReportShowDetailService.getInstance().selectByKey(id);
					Class cls = null;
					BiNationregionEntryDetail ber = new BiNationregionEntryDetail();

					BiNationregion oldbean = BiNationregionService.getInstance().selectById(id);
					BiNationregion newBean = null;

					ber.setOld_binationregion(oldbean);
					while (it.hasNext()) {
						SysTaskInfo tem = (SysTaskInfo) it.next();
						Object temp = rt.getObjctBySysTaskInfo(tem);
						cls = temp.getClass();
						if (cls.equals(BiNationregion.class)) {
							newBean = (BiNationregion) temp;
						}

					}
					ber.setBinationregion(newBean);
					list.add(ber);

				} else if ("1".equals(flag)) {
					SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(tskId);

					BiNationregion newValue = null;
					BiNationregion oldValue = null;
					BiNationregionEntryDetail bination = new BiNationregionEntryDetail();

					if (systasklog.getOldVal1() != null) {

						oldValue = (BiNationregion) rt.getOldObjectByTaskLog(systasklog);

					}
					if (systasklog.getNewVal1() != null) {

						newValue = (BiNationregion) rt.getNewObjectByTaskLog(systasklog);

					}
					// 新增的时候
					if (st.equals("1")) {
						bination.setOld_binationregion(newValue);

					}
					// 修改的时候
					else if (st.equals("2")) {
						bination.setBinationregion(newValue);
						bination.setOld_binationregion(oldValue);
					}
					// 删除的时候
					else if (st.equals("3")) {
						bination.setOld_binationregion(oldValue);
					}
					list.add(bination);

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
