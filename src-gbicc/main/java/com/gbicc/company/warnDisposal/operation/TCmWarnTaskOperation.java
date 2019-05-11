package com.gbicc.company.warnDisposal.operation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

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
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmWarnTaskOperation extends BaseOperation {

	private static final Logger log=LoggerFactory.getLogger(TCmWarnTaskOperation.class);
	public static final String ID = TCmWarnTaskOperation.class.getSimpleName();
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
		String opinion = (String) context.getAttribute("opinion");
		String taskAssignee = (String) context.getAttribute("taskAssignee");
		TCmCustomer tCmCustomer = (TCmCustomer)context.getAttribute("TCmCustomer");
		List<TCmWarnTaskRel> tCmWarnTaskRelList = (List<TCmWarnTaskRel>)context.getAttribute("TCmWarnTaskRel");
		
		
		TCmWarnTaskService service = TCmWarnTaskService.getInstance();
		TCmCustomerService customerService = TCmCustomerService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(dd);
		} else if (CMD_UPDATE.equals(cmd)) {
			if("DC".equals(dd.getTaskType())){
				//赋值审批等级与判断是否需要总行审批
				Map<String, String> map=service.isSubmitNextByList(tCmWarnTaskRelList);
				if("true".equals(map.get("showSubmitNext"))&&"1".equals(dd.getStartType())){
					if(StringUtils.isBlank(dd.getIsSubmitNext())||"0".equals(dd.getIsSubmitNext())){
						dd.setIsSubmitNext("0");
					}else{
						dd.setIsSubmitNext("1");
					}
				}else{
					this.canNext(tCmWarnTaskRelList,dd);
				}
				//控制措施
				if(dd.getContMeasure()!=null){
					this.contMeasureList(dd.getId(), dd.getContMeasure());
				}
			}
			dd.setWarnCunt(tCmWarnTaskRelList.size());
			if(StringUtils.isNotEmpty(op)){
				if(op.equals("end")){
					dd.setIsOver("1");//判断为拒绝
				}
			}
			
			service.update(dd);
			//预警保存/修改
			this.clTCmWarnTaskRel(tCmWarnTaskRelList,dd,op);
			customerService.update(tCmCustomer);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getId());
		}
		
		if(StringUtils.isNotEmpty(op)){
			try {
				taskComplete(dd.getId(),op,dd,opinion,tCmCustomer,tCmWarnTaskRelList,taskAssignee);
				//设置任务超时时间
				if(op.equals("backUp")){
					service.setTaskOverTime(dd, "退回");
				}else if(op.equals("backStart")){
					service.setTaskOverTime(dd, "退回");
//					service.updateWarnCountIsChuLi(dd.getId(), "0");
				}else if(op.equals("submit")){
					service.setTaskOverTime(dd, "审核");
					service.updateWarnCountIsChuLi(dd.getId(), "1");
				}
			} catch (Exception e) {
				log.error("流程调用异常----", e);
				throw new CommonException("系统异常",e.getMessage());
			}
		}
	}
	
	
	/**
	 * 提交
	 * @param businessId
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	public void taskComplete(String businessId,String op,TCmWarnTask domain,String opinion,TCmCustomer tCmCustomer,List<TCmWarnTaskRel> tCmWarnTaskRelList,String taskAssignee) throws Exception{
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		ProcessManagerService processManagerService=ProcessManagerService.getInstace();
		String taskId=processManagerService.findTaskId(businessId, userId);
		TCmWarnTaskService service = TCmWarnTaskService.getInstance();
		TCmWarnTask tCmWarnTask=service.get(businessId);
		Map<String, Object> map=new HashMap<String, Object>();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Map<String,String> variables=processManagerService.findTaskVariable(businessId);
		String nowRole = variables.get("nowRole");
		List<String> assigneeListNext=new ArrayList<String>();
		if(StringUtils.isNotBlank(taskAssignee)){
			assigneeListNext.add(taskAssignee);
		}
		boolean flg_=false;//退回上一级状态
		if(op.equals("backUp")){
			map.put("operation","退回上一级");
			flg_ = true;
			map.put("path","backUp");
			List<String> assigneeList=new ArrayList<String>();
			assigneeList.add(processManagerService.findTopUserIdByBussinessIdAndRolId(businessId,nowRole));
			map.put("assigneeList",assigneeList);
			//map.put("assignee",processManagerService.findTopUserId(businessId));
		}else if(op.equals("backStart")){
			map.put("operation","退回客户经理");
			map.put("path","backStart");
			map.put("assignee",this.firstManage(businessId));//客户经理
//			map.put("assignee",tCmCustomer.getOperator());//客户经理
		}else if(op.equals("submit")){
			map.put("operation","提交");
			//代码
			if("fhfxjczg".equals(nowRole)){//分支行风险监测主管岗审核时
				if("1".equals(domain.getIsSubmitNext())){//判断是否需要总行审批
					map.put("path","next");
				}else{
					map.put("path","end");
				}
			}else if("khjlzg".equals(nowRole)){
				boolean isEnd=false;//默认为人工发起，无需判断是否全部排除
				//若为人工发起预警 则无需进行是否全部排出判断 否则需进行全部排除判断
				if("0".equals(domain.getStartType())){
					//判断是否全部排除,true代表是，流程到客户经理确认
					isEnd=this.elimAll(tCmWarnTaskRelList);
				}else{
					if(tCmWarnTaskRelList.size()<1){
						isEnd=true;
					}
				}
				if(isEnd){
					map.put("path","end");
				}else{
					map.put("path","next");
				}
			}else{
				map.put("path","next");
			}
			if("end".equals(map.get("path"))){//结束时，客户经理接收
				map.put("assignee",this.firstManage(businessId));//客户经理
//				map.put("assignee",tCmCustomer.getOperator());//客户经理
			}else if(StringUtils.isNotEmpty(variables.get("nextRole"))){
//				List<String> assigneeList=processManagerService.findUserIdByRoleidAndCurrOrgid(variables.get("nextRole"),info.getBrcode());
				if(assigneeListNext==null || assigneeListNext.size()<1){
					throw new CommonException("未配置审核人","根据当前机构【"+info.getBrName()+"】查找流程下一节点未找到审核人");
				}
				map.put("assigneeList",assigneeListNext);
			}else if(StringUtils.isNotEmpty(variables.get("nextAssignee"))){//下一个是接受人
				map.put("assignee",tCmCustomer.getOperator());//客户经理
			}
		}else if(op.equals("end")){
			if("zhfxjczg".equals(nowRole)){//总行风险监测主管岗审核时
				map.put("path","next");
			}else{
				map.put("path","end");
				map.put("operation", "终止");
			}
			map.put("assignee",this.firstManage(businessId));//客户经理
//			map.put("assignee",tCmCustomer.getOperator());//客户经理
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if("khjl".equals(nowRole)){//客户经理提交时，保存核查说明与采取措施至备注信息
			String inspDate="";
			if(domain.getInspeDate()!=null){
				inspDate=sdf.format(domain.getInspeDate());
			}else{
				inspDate=sdf.format(new Date());
			}
			opinion="核查日期:"+inspDate+",核查说明："+domain.getInspeInfo()+",采取措施说明："+domain.getContDesc();
			if("RC".equals(domain.getTaskType())){
				String disposalDate="";
				if(domain.getDisposalDate()!=null){
					disposalDate=sdf.format(domain.getDisposalDate());
				}else{disposalDate=sdf.format(new Date());}
				opinion="处置日期："+disposalDate+"处置说明:"+domain.getDisposalInfo();
			}
			if(domain.getTaskMatureDate().getTime()<new Date().getTime()){
				service.updateWarnCountIsChaoShi(domain.getId());
			}
		}
		if(map.get("operation")!=null){
			if("DC".equals(domain.getTaskType())){
				map.put("operation","核查_"+map.get("operation"));
			}else{
				map.put("operation","反馈_"+map.get("operation"));
			}
		}
		map.put("opinion",opinion);//备注信息
		map.put("desc", BpmDescUtil.getDesc(domain.getTaskCode(), tCmCustomer.getCustcode(), tCmCustomer.getCustname()));
		//执行流程
		processManagerService.taskComplete(map, taskId);
		//找到当前流程节点状态
		Map<String,String> newVar=processManagerService.findTaskVariable(businessId);
		if(null!=newVar && newVar.size()>0){
			String status=newVar.get("status");
			if(flg_){
				status="2";//退回上一级
			}
			if(op.equals("end")){
				status="7";//判断为拒绝
			}
			domain.setStatus(status);
			rootdao.flush();
			//更改业务状态
			rootdao.executeSql("UPDATE ECUSER.T_CM_WARN_TASK SET FD_STATUS='"+status+"' WHERE FD_ID='"+businessId+"' ");
		}
	}
	
	/**
	 * 更新预警处置信息
	 * @param context
	 * @param customerId
	 * @throws CommonException
	 */
	private void clTCmWarnTaskRel(List<TCmWarnTaskRel> tCmWarnTaskRelList,TCmWarnTask task,String op) throws CommonException{
		TCmWarnTaskRelService relService = TCmWarnTaskRelService.getInstance();
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		for (TCmWarnTaskRel tCmWarnTaskRel : tCmWarnTaskRelList) {
			if(StringUtils.isBlank(tCmWarnTaskRel.getWarnCode())){
				continue;
			}
			
			if(StringUtils.isNotEmpty(op)){
				if("DC".equals(task.getTaskType())){
					if("0".equals(tCmWarnTaskRel.getWarnStatus())){
						tCmWarnTaskRel.setWarnStatus("1");//处理中
					}
				}else{
					if("2".equals(tCmWarnTaskRel.getWarnStatus())){
						tCmWarnTaskRel.setWarnStatus("3");//处置中
					}
				}
			}
			if(StringUtils.isBlank(tCmWarnTaskRel.getId())){
				tCmWarnTaskRel.setTaskId(task.getId());
				tCmWarnTaskRel.setCustomerId(task.getCustomerId());
				tCmWarnTaskRel.setWarnElimIs("0");//默认未排除
				relService.save(tCmWarnTaskRel);
			}else{
				String sql="select FD_HALFRESULT from T_CM_WARN_TASK_REL where FD_ID='"+tCmWarnTaskRel.getId()+"' ";
				List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
				if(list!=null && list.size()>0){
					Object obj=list.get(0).get("FD_HALFRESULT");
					if(obj!=null){
						tCmWarnTaskRel.setHalfresult((String)obj);
					}
				}
				relService.update(tCmWarnTaskRel);
			}
		}
	}
	
	/**
	 * 控制措施保存
	 * @param businessId
	 * @param contMeasure
	 * @throws CommonException
	 */
	private void contMeasureList(String businessId,String contMeasure) throws CommonException{
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		rootdao.executeSql("DELETE FROM ECUSER.T_CM_WARN_CONTROLMEASURE WHERE FD_TASK_ID='"+businessId+"' ");
		String[] arr=contMeasure.split(",");
		TCmWarnControlmeasureService service = TCmWarnControlmeasureService.getInstance();
		for (String string : arr) {
			if(StringUtils.isNotBlank(string)){
				TCmWarnControlmeasure domain = new TCmWarnControlmeasure();
				domain.setTaskId(businessId);
				domain.setConmeasCode(string);
				domain.setTaskType("DW");
				service.save(domain);
			}
		}
	}

	/**
	 * 判断是否需要总行审批
	 * @param TCmWarnTaskRelList
	 * @return
	 */
	private void canNext(List<TCmWarnTaskRel> tCmWarnTaskRelList,TCmWarnTask task){
		//true 代表需要到总行审批  DIC 12599
		Integer maxLevel=0;
		for (TCmWarnTaskRel tCmWarnTaskRel : tCmWarnTaskRelList) {
			try{
				if("4".equals(tCmWarnTaskRel.getWarnStatus())||"1".equals(tCmWarnTaskRel.getWarnElimIs())){
					continue;
				}
				Integer warnLevel=Integer.valueOf(tCmWarnTaskRel.getProcessLevel());
				if(maxLevel<warnLevel){
					maxLevel=warnLevel;
				}
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
		task.setProcessLevel(maxLevel.toString());
		TCmWarnTaskService service = TCmWarnTaskService.getInstance();
		List<DataDic> dataDicList = service.getDateDicList("12597");
		//if(!"1".equals(task.getStartType())){//非人工发起流程时
			if(maxLevel>=Integer.valueOf(dataDicList.get(0).getDataNo())){
				task.setIsSubmitNext("1");
			}else{
				task.setIsSubmitNext("0");
			}
		//}
		
	}
	
	
	/**
	 * 寻找最近的客户经理
	 * @param businessId
	 * @return
	 */
	private String firstManage(String businessId){
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		String assignee_="";
		try {
			 Iterator it = rootDao.queryBySQL("select id_,act_name_,assignee_,start_time_,end_time_ from act_hi_actinst i "+
			" where i.PROC_INST_ID_ in (select PROC_INST_ID_ from act_hi_actinst where "+ 
			" task_id_ in (select id_ from ACT_HI_TASKINST where proc_inst_id_ in ( select proc_inst_id_ from ACT_HI_PROCINST where "+ 
			" business_key_='"+businessId+"'))) and i.END_TIME_ is not null "+
			" and EXISTS (select t.id_ from ACT_HI_TASKINST t where t.TASK_DEF_KEY_=i.act_id_ and t.delete_reason_<>'deleted') and act_name_='客户经理' order by end_time_ desc");
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			while(it.hasNext()){
				Object[] obj=(Object[]) it.next();
				if(obj[2]!=null){
					assignee_=obj[2].toString();
					break;
				}
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assignee_;
		
	}
	
	/**
	 * 判断是否全部排除
	 * @param TCmWarnTaskRelList
	 * @return
	 */
	private boolean elimAll(List<TCmWarnTaskRel> tCmWarnTaskRelList){
		//true 代表全部排除
		boolean flg_=true;
		for (TCmWarnTaskRel tCmWarnTaskRel : tCmWarnTaskRelList) {
			if("0".equals(tCmWarnTaskRel.getWarnElimIs())){
				//如果有一条不是全部排除，则下一级审批
				flg_=false;
				break;
			}
		}
		return flg_;
	}
	
	public static void main(String[] args) {
		System.out.println(""+(new Date()));
	}
}
