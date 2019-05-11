package com.gbicc.bpm.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.entity.TLoanAccountDutyDistribute;
import com.gbicc.bpm.operation.TLoanAccountDutyDistributeOperation;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class LoanAccountCollDistributeUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "LoanAccountCollDistribute";
	private static final String DATASET_ID2 = "CheckUser";

	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			UpdateResultBean collUserBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID2);
			OperationContext oc = new OperationContext();
			String op=updateResultBean.getParameter("op");
			String loanacnos=updateResultBean.getParameter("loanacnos");
			String taskAssignee=updateResultBean.getParameter("taskAssignee");
			if(StringUtils.isEmpty(op)){
				op="";
			}
			if(StringUtils.isEmpty(loanacnos)){
				loanacnos="";
			}
			if(StringUtils.isEmpty(taskAssignee)){
				taskAssignee="";
			}
			TLoanAccountDutyDistribute distribute=new TLoanAccountDutyDistribute();
			String opinion="";
			if(updateResultBean.hasNext()){
				Map map=updateResultBean.next();
				if(map.get("opinion3")!=null){
					opinion=map.get("opinion3").toString();
				}
				if(map.get("opinion2")!=null && StringUtils.isNotEmpty(map.get("opinion2").toString())){
					opinion=map.get("opinion2").toString();
				}
				mapToObject(distribute,map);
				if(map.get("operOrgId")!=null){
					distribute.setOperOrg(BctlService.getInstance().getBctlByBrcode(map.get("operOrgId").toString()));
				}
				if(map.get("operUserId")!=null){
					distribute.setOperUser(TlrInfoService.getInstance().getTlrInfoByTlrno(map.get("operUserId").toString()));
				}
				if(map.get("loanacnoId")!=null){
					distribute.setLoanacno(ROOTDAOUtils.getROOTDAO().query(TEdwPlsAccount.class,map.get("loanacnoId").toString()));
				}
			}
			List<Map> list=new ArrayList<Map>();
			while(collUserBean.hasNext()){
				Map map=collUserBean.next();
				list.add(map);
			}
			oc.setAttribute("op",op);
			oc.setAttribute("opinion",opinion);
			oc.setAttribute("loanacnos",loanacnos);
			oc.setAttribute("taskAssignee",taskAssignee);
			distribute.setDistType(TLoanAccountDutyDistributeOperation.DIST_TYPE_COLL);
			oc.setAttribute("TLoanAccountDutyDistribute",distribute);
			oc.setAttribute("recordList",list);
			OPCaller.call(TLoanAccountDutyDistributeOperation.ID,oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
