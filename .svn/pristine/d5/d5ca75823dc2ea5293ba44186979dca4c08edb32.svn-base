package com.gbicc.person.zxrf.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.gbicc.person.zxrf.opration.TPlZxrfInfoCalculteOperation;
import com.gbicc.person.zxrf.service.TPlZxrfInfoService;
import com.gbicc.warn.entity.TWarnSignal;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月12日 上午19:55:08
 * 类说明：中小融辅新增
 */
public class TPlZxrfInfoCalculteUpdate extends BaseUpdate {
	private static final String DATASET_ID = "TPlZxrfInfo";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			
			String businessId = updateResultBean.getParameter("businessId");
			//处理报告基础信息
			TPlZxrfInfo ajReport = new TPlZxrfInfo();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String  id=(String) map.get("id");
				ajReport = TPlZxrfInfoService.getInstance().get(id);
			}
			TPlZxrfInfoService service=TPlZxrfInfoService.getInstance();
			if("10".equals(ajReport.getProductType())){//个人消费类 不用查找财报
				updateReturnBean.setParameter("success", "true");
			}else{
				Map<String,String> tmap=service.findReport(businessId);
				//查找财报 如缺失或者少于两个月 则返回计算失败
				if(tmap!=null){
					if("false".equals(tmap.get("success"))){
						updateReturnBean.setParameter("msg", tmap.get("message"));
						updateReturnBean.setParameter("success", "false");
						return updateReturnBean;
					}else{
						updateReturnBean.setParameter("success", "true");
					}
				}
			}
			service.calculteWarnSigal(ajReport, updateReturnBean);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
