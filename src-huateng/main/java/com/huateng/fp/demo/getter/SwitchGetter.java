package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.flowswitch.micro.common.Context;
import com.huateng.flowswitch.micro.ctl.ClientFactory;
import com.huateng.flowswitch.micro.model.server.base.IClient;
import com.huateng.fp.demo.bean.SwitchAddBean;
import com.huateng.fs.micro.demo.bean.Purchase;
import com.huateng.fs.micro.demo.bean.TestFailBean;
import com.huateng.fs.micro.demo.bean.TestInputBean;
import com.huateng.fs.micro.demo.bean.TestOutputBean;

public class SwitchGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			String type = this.getCommQueryServletRequest().getParameter("type");
			List list = new ArrayList();
			if("add".equalsIgnoreCase(type)){
				SwitchAddBean bean = new SwitchAddBean();
				bean.setVersion("1.0");
				bean.setXtype("1001");
				bean.setXclass("1");
				list.add(bean);
			}else{
				TestInputBean in = new TestInputBean();
				in.setVersion("1.0");
				in.setXclass("1");
				in.setXtype("1002");//交易码
				
				String qpan = this.getCommQueryServletRequest().getParameter("qpan");
				if(StringUtils.isNotBlank(qpan)){
					in.setPan(qpan);
				}
				list = getSwitchQueryList(in);
			}
			result.setContent(list);
			result.getPage().setTotalPage(1);
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	
	private List  getSwitchQueryList(TestInputBean in) throws AppException{
		IClient client = ClientFactory.getInstance().getEntry("SocketXMLClient");
		Context ctx =client.doProcess(in);
		if(!ctx.isSuccess()){
			logger.info(ctx.getInErrMsg());
			TestFailBean failbean =  (TestFailBean) ctx.getFailBean();
			ExceptionUtil.throwAppException( failbean.getRspcode(),failbean.getRspmsg());
			return null;
		}else{
			logger.info("return msg:"+ctx.getInMsg());
			
			TestOutputBean outBean = (TestOutputBean) ctx.getInBean();
			List<Purchase> plist = outBean.getArray();
			return plist;
		}
	}
	

}
