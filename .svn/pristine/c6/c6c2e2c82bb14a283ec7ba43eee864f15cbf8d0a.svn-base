package com.gbicc.company.warnDisposal.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gbicc.bpm.BpmDescUtil;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.company.warnDisposal.entity.TCmCustomer;
import com.gbicc.company.warnDisposal.entity.TCmWarnControlmeasure;
import com.gbicc.company.warnDisposal.entity.TCmWarnTask;
import com.gbicc.company.warnDisposal.entity.TCmWarnTaskRel;
import com.gbicc.company.warnDisposal.service.TCmCustomerService;
import com.gbicc.company.warnDisposal.service.TCmWarnControlmeasureService;
import com.gbicc.company.warnDisposal.service.TCmWarnTaskRelService;
import com.gbicc.company.warnDisposal.service.TCmWarnTaskService;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.gbicc.warn.entity.TWarnSignal;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCmWarnTaskStartProOperation extends BaseOperation {

	public static final String ID = TCmWarnTaskStartProOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String OP = "op";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String OPINION = "opinion";
	
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		TCmWarnTask dd = (TCmWarnTask) context.getAttribute(IN_PARAM);
		String op = (String) context.getAttribute(OP);
		
		TCmWarnTaskService service = TCmWarnTaskService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(dd);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(dd);
//			customerService.update(tCmCustomer);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getId());
		}
		//更新预警信号状态
		this.disposalWarnTaskRel(dd);
		try {
			ProcessManagerService pms=ProcessManagerService.getInstace();
			if("false".equals(pms.findRuningTaskByBusinessKey(dd.getId()))){
				Map<String, Object> processMap=new HashMap<String, Object>();
				processMap.put("assignee", dd.gettCmCustomer().getOperator());
				processMap.put("operation","人工发起处置反馈流程");
				pms.startProcess(dd.getId(),"CM_CustWranDisposalProcess",dd.gettCmCustomer().getOperator(),processMap);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 更新预警信号状态
	 * @param task
	 * @throws CommonException
	 */
	public void disposalWarnTaskRel(TCmWarnTask task) throws CommonException {
		TCmWarnTaskRelService service = TCmWarnTaskRelService.getInstance();
		List<TCmWarnTaskRel> list = service.findByBusinessId(task.getId());
		for (TCmWarnTaskRel tCmWarnTaskRel : list) {
			if ("4".equals(tCmWarnTaskRel.getWarnStatus())) {
				continue;
			}else{
				//待处理
				tCmWarnTaskRel.setWarnStatus("0");
				service.update(tCmWarnTaskRel);
			}
		}

	}
	
}
