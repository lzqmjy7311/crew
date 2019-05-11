package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author yjw
 * 
 */
public class DownBrcodeSelectGetter extends BaseGetter {

	
	public Result call() throws AppException {
		try {
			String currentCode = GlobalInfo.getCurrentInstance().getBrcode();

			List list = new ArrayList();

			Bctl head = BaseDAOUtils.getBctlDAO().getHeadBranch();
			Bctl current = BaseDAOUtils.getBctlDAO().getBranchBrcode(currentCode);
			
			if (currentCode.equals(head.getBrcode())) {// 如果是总行
				list.addAll(BctlService.getInstance().getAllDownBrcodeListWithoutSubBranch(currentCode));
			}else if(current.getBrclass().equals( SystemConstant.BRCODE_CLASS_SUBBRANCH)){// 如果是支行
				//加入总行
				list.add(head);
				//加入上级机构
				list.add(BaseDAOUtils.getBctlDAO().getBranchBrcode(current.getBlnUpBrcode()));
				//加入本行
				list.add(current);
			}else{//如果是分行
				//加入总行
				list.add(head);
				list.addAll(BctlService.getInstance().getAllDownBrcodeListWithoutSubBranch(currentCode));
			}
			
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list, getResult());
			result.setContent(list);
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
