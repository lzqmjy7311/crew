package com.gbicc.company.single.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.company.single.entity.TCmSingleRulInvestigation;
import com.gbicc.company.single.operation.TCmSingleRulInvestigationOperation;
import com.gbicc.company.single.service.TCmSingleRulCasesService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmSingleRulInvestigationUpdate extends BaseUpdate {
	
	private static final String DATASET_ID ="SingleRulInvestigation";
	public static String entityId="";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		try {
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCmSingleRulInvestigation entity = new TCmSingleRulInvestigation();
			OperationContext oc = new OperationContext();
			String op = updateResultBean.getParameter("op");
			String inveUserId="";
			inveUserId = updateResultBean.getParameter("inveUserId");
			String inveOrg="";
			inveOrg = updateResultBean.getParameter("inveOrg");
			String casesId = updateResultBean.getParameter("casesId");
			String warningIds = updateResultBean.getParameter("warningIds");
			BctlService bctlService=BctlService.getInstance();
			TlrInfoService tlrService=TlrInfoService.getInstance();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				if(map.get("inveOrg")!=null&&StringUtils.isNotBlank((String) map.get("inveOrg"))){
					inveOrg=(String) map.get("inveOrg");
				}
				String createOrgId="";
				if(map.get("createOrgId")!=null){
					createOrgId=(String) map.get("createOrgId");
				}
				String createUserId="";
				if(map.get("createUserId")!=null){
					createUserId=(String) map.get("createUserId");
				}
				if(StringUtils.isBlank(inveUserId)){
					inveUserId=(String) map.get("inveUserId");
				}
				String againCreateUserId="";
				if(map.get("againCreateUserId")!=null){
					againCreateUserId=(String) map.get("againCreateUserId");
				}
				map.remove("inveOrg");
				map.remove("createOrg");
				map.remove("createUser");
				map.remove("inveUser");
				mapToObject(entity,map);
				if(StringUtils.isNotEmpty(inveOrg)){
					entity.setInveOrg(bctlService.getBctlByBrcode(inveOrg));
				}
				if(StringUtils.isNotEmpty(createOrgId)){
					entity.setCreateOrg(bctlService.getBctlByBrcode(createOrgId));
				}
				if(StringUtils.isNotEmpty(createUserId)){
					entity.setCreateUser(tlrService.getTlrInfoByTlrno(createUserId));
				}
				if(StringUtils.isNotEmpty(inveUserId)){
					entity.setInveUser(tlrService.getTlrInfoByTlrno(inveUserId));
				}
				if(StringUtils.isNotEmpty(againCreateUserId)){
					entity.setAgainCreateUser(tlrService.getTlrInfoByTlrno(againCreateUserId));
				}
			}
			oc.setAttribute("cases",TCmSingleRulCasesService.getInstance().get(casesId));
			oc.setAttribute("investigation",entity);
			oc.setAttribute("op", op);
			oc.setAttribute("warningIds",warningIds);
			OPCaller.call(TCmSingleRulInvestigationOperation.ID,oc);
			updateReturnBean.setParameter("id",entityId);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		} 
	}

}
