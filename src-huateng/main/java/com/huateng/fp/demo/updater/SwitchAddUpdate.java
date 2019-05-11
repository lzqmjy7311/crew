package com.huateng.fp.demo.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.flowswitch.micro.common.Context;
import com.huateng.flowswitch.micro.ctl.ClientFactory;
import com.huateng.flowswitch.micro.model.server.base.IClient;
import com.huateng.fp.demo.bean.SwitchAddBean;
import com.huateng.fs.micro.demo.bean.Merchant;
import com.huateng.fs.micro.demo.bean.Purchase;
import com.huateng.fs.micro.demo.bean.TestFailBean;
import com.huateng.fs.micro.demo.bean.TestInputBean;

public class SwitchAddUpdate extends BaseUpdate {
	private HtLog logger = HtLogFactory.getLog(SwitchAddUpdate.class);
	private static final String DATASET_ID = "SwitchAdd";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			// 返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			// 结果集对象
			UpdateResultBean resultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			
			if(resultBean.hasNext()){
				Map<String,String> map = resultBean.next();
				SwitchAddBean bean = new SwitchAddBean();
				mapToObject(bean, map);
				
				Merchant merchant = new Merchant();
				mapToObject(merchant, map);
				
				
				Purchase purchase = new Purchase();
				mapToObject(purchase, map);
				
				
				TestInputBean in = new TestInputBean();
				in.setVersion("1.0");
				in.setXclass("1");
				in.setXtype("1001");//交易码
				in.setPan(bean.getPan());
				in.setMerchant(merchant);
				in.getArray().add(purchase);
				IClient client = ClientFactory.getInstance().getEntry("SocketXMLClient");
				Context ctx =client.doProcess(in);
				if(!ctx.isSuccess()){
					logger.info(ctx.getInErrMsg());
					TestFailBean failbean =  (TestFailBean) ctx.getFailBean();
					ExceptionUtil.throwAppException( failbean.getRspcode(),failbean.getRspmsg());
				}else{
					logger.info(ctx.getInMsg());
				}
			}
			return updateReturnBean;
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage(), e);
		}
	}

}
