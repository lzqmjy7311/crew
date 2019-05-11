/**
 * Title: MaterialCallGetter
 * Description:
 * Copyright: Copyright (c) 2007
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author xubin
 * @version 1.0, 12/25/07 （版本号，开发日子）
 */
package com.huateng.ebank.business.parammng.cqGetter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TlrInfo3Getter extends BaseGetter {

	public Result call() throws AppException {
		try {
			int totalPage = 0;
			List list = new ArrayList();

			String action = (String) getCommQueryServletRequest()
					.getParameterMap().get("action");

			TlrInfo tlrInfo = new TlrInfo();
			// 操作员查询的时候
			if (action != null && action.equals("query")) {
				if (this.getHttpReq().getAttribute("tlrInfo") != null) {
					tlrInfo = (TlrInfo) this.getHttpReq().getAttribute(
							"tlrInfo");
					/** added by junzhong.duan 20120422 LNDN-202 begin */
					//因为在传值过程中出现乱码，所以重新查询一次
					tlrInfo = DAOUtils.getTlrInfoDAO().queryById(tlrInfo.getTlrno());
					/** added by junzhong.duan 20120422 LNDN-202 end */
				} else {
					BeanUtilsEx(tlrInfo, getCommQueryServletRequest()
							.getParameterMap());
					TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
					tlrInfo = dao.queryById(tlrInfo.getTlrno());
				}
				totalPage = 1;
				// 新增操作员的时候
			} else {
				String brno = getValueFromDataBus("brno");
				String tlrno = getValueFromDataBus("tlrno");
				tlrInfo.setBrcode(BctlService.getInstance().getInBrno(brno));
				tlrInfo.setBrno(brno);
				tlrInfo.setTlrno(tlrno);
				tlrInfo.setStatus(SystemConstant.VALID_FLAG_VALID);// 有效
				totalPage = 1;
			}
			ResultMng.fillResultByObject(getCommonQueryBean(),
					getCommQueryServletRequest(), tlrInfo, getResult());
			List content = new ArrayList();
			content.add(tlrInfo);
			result.setContent(content);
			result.getPage().setTotalPage(1);
			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
