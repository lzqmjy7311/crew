package com.gbicc.person.collection.opration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.collection.entity.TCollectionInfo;
import com.gbicc.person.collection.service.TCollectionInfoService;
import com.gbicc.person.creditMemo.entity.TPlCreditMemo;
import com.gbicc.person.creditMemo.service.TPlCreditMemoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author liufei
 * @time   2015年11月23日17:25:46
 * @desc   催收管理控流程结束操作类
 */
public class TCollectionInfoProcessEndOperation extends BaseOperation {
	public static final String ID = "TCollectionInfoProcessEndOperation";
	public static final String HANDLE_COMPLETE_STATUS="7";//处理完成状态
	public static final String OPINION="OPINION";//意见
	public static final String BUSINESSID="BUSINESSID";//业务主键
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String businessId = (String) context.getAttribute(BUSINESSID);
		
		TCollectionInfoService service = TCollectionInfoService.getInstance();
		TPlCreditMemoService domainService = TPlCreditMemoService.getInstance();
		TCollectionInfo dd = null;
		if(StringUtils.isNotBlank(businessId)){
			dd=service.get(businessId);
		}
		if(dd!=null){
			dd.setStatus("3");
			dd.setUpdated(new Date());
			service.update(dd);
			if(dd.getControlMeasure()!=null && !"".equals(dd.getControlMeasure())){
				TPlCreditMemo domain = new TPlCreditMemo();
				if(dd.getControlMeasure()!=null && !"".equals(dd.getControlMeasure())){
					domain.setBusinessId(businessId);
					domain.setCustcode(dd.getCustCode());
					domain.setCustname(dd.getCustName());
					domain.setControlmeasure(dd.getControlMeasure());
					domain.setLoanAccount(dd.getLoanAccount());
					domain.setReprotCode(dd.getId());
					domain.setOperator(dd.getOperator());
					domain.setOperBank(dd.getOperBank());
					domain.setStartDate(dd.getCredited());
					domain.setStartType("CS");
					domain.setStartRemark(dd.getRemark());
					String str="控制措施编号："+dd.getControlMeasure();
					if(dd.getColleDate()!=null){
						str=str+";催收日期:"+new SimpleDateFormat("yyyy-MM-dd").format(dd.getColleDate());
					}
					str=str+";催收情况说明:"+dd.getSituationExplain();
					str=str+";催收通知回执:"+dd.getReceiptInfo();
					
					domainService.save(domain);
				}
			}
			if(dd.getExprctReturnDate()!=null){
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				rootdao.executeSql("UPDATE ECUSER.T_PL_TASK_DEBT_COLLECT SET FD_EXP_PAY_DATE=date('"+new SimpleDateFormat("yyyy-MM-dd").format(dd.getExprctReturnDate())+"') WHERE FD_ACC_ID='"+dd.getLoanAccount()+"' ");
			}
		}
	}
}
