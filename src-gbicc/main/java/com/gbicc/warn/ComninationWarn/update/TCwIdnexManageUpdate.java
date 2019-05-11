package com.gbicc.warn.ComninationWarn.update;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.warn.ComninationWarn.entity.TCwIdnexManage;
import com.gbicc.warn.ComninationWarn.entity.TCwThresholdversion;
import com.gbicc.warn.ComninationWarn.operation.TCwIdnexManageOperation;
import com.gbicc.warn.ComninationWarn.service.TCwIdnexManageService;
import com.gbicc.warn.ComninationWarn.service.TCwThresholdversionService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCwIdnexManageUpdate extends BaseUpdate {
	private static final String DATASET_ID ="thresholdtable";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCwIdnexManage dd = new TCwIdnexManage();
			TCwThresholdversion ddt=new TCwThresholdversion();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String op = updateResultBean.getParameter("op");
				if(null==op){
					op="mod";
				}
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new TCwIdnexManage();
					oc.setAttribute(TCwIdnexManageOperation.CMD,TCwIdnexManageOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = TCwIdnexManageService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TCwIdnexManageOperation.CMD,TCwIdnexManageOperation.CMD_UPDATE);
				}
				if(dd.getThresholdVersion()!=null){
					ddt.setVersion(dd.getThresholdVersion());
				}
				if(dd.getUpdateUser()!=null){
					ddt.setOperator(dd.getUpdateUser());
				}
				if(dd.getUpdateed()!=null){
					ddt.setUpdatetime(dd.getUpdateed());
				}
//				ddt.setOperator(dd.getUpdateUser());
//				ddt.setRed(dd.getThreshold1().toString());
//				ddt.setYellow(dd.getThreshold2().toString());
//				ddt.setUpdatetime(dd.getUpdateed());
				ddt.setIndexCode(dd.getIndexCode());
				ddt.setId(uuId);
				if("0".equals(dd.getIndexType2())){
					if(dd.getThreshold1()>dd.getThreshold2()){
						ddt.setYellow(dd.getThreshold1().toString());
						ddt.setRed(dd.getThreshold2().toString());
					}else{
						ddt.setYellow(dd.getThreshold2().toString());
						ddt.setRed(dd.getThreshold1().toString());
					}
				}else if("1".equals(dd.getIndexType2())){
					if(dd.getThreshold1()>dd.getThreshold2()){
						ddt.setYellow(dd.getThreshold2().toString());
						ddt.setRed(dd.getThreshold1().toString());
					}else{
						ddt.setYellow(dd.getThreshold1().toString());
						ddt.setRed(dd.getThreshold2().toString());
					}
				}
				mapToObject(dd, map);
				
				GlobalInfo info=GlobalInfo.getCurrentInstance();
				String userId=info.getTlrno();
				dd.setUpdateUser(userId);
				double intemp=Double.parseDouble(dd.getThresholdVersion());
				Double abc=intemp+1;
				String str11=abc.toString();
				dd.setThresholdVersion(str11);
				Date dat=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String str=sdf.format(dat);
				dat=sdf.parse(str);
				dd.setUpdateed(dat);
				
			}
			
			oc.setAttribute(TCwIdnexManageOperation.IN_PARAM, dd);
			OPCaller.call(TCwIdnexManageOperation.ID, oc);
			TCwThresholdversionService service= TCwThresholdversionService.getInstance();
			service.save(ddt);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
