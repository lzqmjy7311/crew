/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.opermng.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.user.entity.TModifiedRoleid;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.approve.bean.TlrInfoAuditBean;
import com.huateng.ebank.business.approve.service.TaskListService;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.service.PasswordService;
import com.huateng.ebank.business.management.service.UserMgrService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.dao.mng.TlrRoleRelDAO;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.entity.data.mng.TlrBctlRel;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.entity.data.mng.UserOrgRoleRel;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.RepList;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngOperation extends BaseOperation {

	private static final HtLog htlog = HtLogFactory.getLogger(OperMngOperation.class);

	public static final String ID = "management.OperMngOperation";
	public static final String CMD = "cmd";
	public static final String IN_TLRINFO = "IN_TLRINFO";
	public static final String IN_TLRNO = "IN_TLRNO";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_ROLELIST = "IN_ROLELIST";
	public static final String IN_BCTLLIST = "IN_BCTLLIST";
	public static final String IN_RELLIST = "IN_RELLIST";

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
	 * ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		// GlobalInfo就相当于一个session
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
		TlrRoleRelDAO relationDao = DAOUtils.getTlrRoleRelDAO();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if ("new".equals(context.getAttribute(CMD))) {
			TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
			List<Bctl> bctls = (List<Bctl>) context.getAttribute(IN_BCTLLIST);
			List<RoleInfo> roles = (List<RoleInfo>) context.getAttribute(IN_ROLELIST);
			List<UserOrgRoleRel> orgRoleRels= (List<UserOrgRoleRel>) context.getAttribute(IN_RELLIST);
			if (tlrInfoDAO.query(tlrInfo.getTlrno()) == null) {
				tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
				// 设置有效标志
				tlrInfo.setFlag(SystemConstant.FLAG_ON);
				String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
				String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
				String password = PasswordService.getInstance().EncryptPassword(sysDefaultPwd, encMethod);
				tlrInfo.setPassword(password);// 设置默认操作员密码
				// 为操作员密码错误次数付初始值
				tlrInfo.setTotpswderrcnt(new Integer(0));
				tlrInfo.setPswderrcnt(new Integer(0));
				tlrInfo.setPasswdenc(encMethod);
				tlrInfo.setCreateDate(DateUtil.dateToNumber(GlobalInfo.getCurrentInstance().getTxdate()));
				tlrInfo.setIsLock(SystemConstant.FLAG_OFF);
				tlrInfo.setIsLockModify("1");
				tlrInfo.setSt(ReportEnum.REPORT_ST1.CR.value);
				tlrInfoDAO.saveOrUpdate(tlrInfo);

				//保存授权机构
				RepList<TlrBctlRel> bctlRellist = new RepList<TlrBctlRel>();
				for(Bctl bc : bctls){
					TlrBctlRel tlrBctlRel = new TlrBctlRel();
					tlrBctlRel.setBrNo(bc.getBrno());
					tlrBctlRel.setTlrNo(tlrInfo.getTlrno());
					rootdao.save(tlrBctlRel);
					bctlRellist.add(tlrBctlRel);
				}
				//保存角色岗位
				RepList<TlrRoleRel> roleRellist = new RepList<TlrRoleRel>();
				for(RoleInfo rl : roles){
					TlrRoleRel tlrRoleRel = new TlrRoleRel();
					tlrRoleRel.setRoleId(rl.getId());
					tlrRoleRel.setTlrno(tlrInfo.getTlrno());
					tlrRoleRel.setStatus("1");
					rootdao.save(tlrRoleRel);
					roleRellist.add(tlrRoleRel);
				}
				RepList<UserOrgRoleRel> saveRellist = new RepList<UserOrgRoleRel>();//保存ID的机构关系
				for(UserOrgRoleRel f : orgRoleRels){
					UserOrgRoleRel nf=new UserOrgRoleRel();
					BeanUtils.copyProperties(f, nf);
					rootdao.save(nf);
					saveRellist.add(nf);
				}
				
				try {
					TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
					tlrInfoAuditBean.setTlrInfo(tlrInfo);
					tlrInfoAuditBean.setBctlRellist(bctlRellist);
					tlrInfoAuditBean.setRoleRellist(roleRellist);
					tlrInfoAuditBean.setRellist(saveRellist);
					
					SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
							ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
							ReportEnum.REPORT_TASK_TRANS_CD.NEW.value,
							tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),null);
					rootdao.saveOrUpdate(tskInf);
				} catch (IOException e) {
					ExceptionUtil.throwCommonException("操作员新增保存，双岗复核序列化到数据库出错！");
					e.printStackTrace();
				}
			} else {
				ExceptionUtil.throwCommonException("该操作员已经存在，不能新增", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"新增用户编号[" + tlrInfo.getTlrno() + "]"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"新增用户编号[" + tlrInfo.getTlrno() + "]"});
		} else if ("modify".equals(context.getAttribute(CMD))){
			TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
			List<Bctl> bctls = (List<Bctl>) context.getAttribute(IN_BCTLLIST);
			List<RoleInfo> roles = (List<RoleInfo>) context.getAttribute(IN_ROLELIST);
			List<UserOrgRoleRel> orgRoleRels= (List<UserOrgRoleRel>) context.getAttribute(IN_RELLIST);
			
			//授权机构
			RepList<TlrBctlRel> bctlRellist = new RepList<TlrBctlRel>();
			for(Bctl bc : bctls){
				TlrBctlRel tlrBctlRel = new TlrBctlRel();
				tlrBctlRel.setBrNo(bc.getBrno());
				tlrBctlRel.setTlrNo(tlrInfo.getTlrno());
				bctlRellist.add(tlrBctlRel);
			}
			//角色岗位
			RepList<TlrRoleRel> roleRellist = new RepList<TlrRoleRel>();
			for(RoleInfo rl : roles){
				TlrRoleRel tlrRoleRel = new TlrRoleRel();
				tlrRoleRel.setRoleId(rl.getId());
				tlrRoleRel.setTlrno(tlrInfo.getTlrno());
				tlrRoleRel.setStatus("1");
				tlrRoleRel.setIsDefault("0");
				roleRellist.add(tlrRoleRel);
			}
			//角色岗位中间表
			RepList<UserOrgRoleRel> saveRellist = new RepList<UserOrgRoleRel>();//保存ID的机构关系
			for(UserOrgRoleRel f : orgRoleRels){
				saveRellist.add(f);
			}
			TlrInfo dbTrlInfo = rootdao.query(TlrInfo.class, tlrInfo.getTlrno());
			dbTrlInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
			String oldTlrName = dbTrlInfo.getTlrName();

			//新的值序列化数据库
			dbTrlInfo.setTlrName(tlrInfo.getTlrName());
			dbTrlInfo.setBrcode(tlrInfo.getBrcode());
			dbTrlInfo.setRoleid(tlrInfo.getRoleid());
			try {
				TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
				tlrInfoAuditBean.setTlrInfo(dbTrlInfo);
				tlrInfoAuditBean.setBctlRellist(bctlRellist);
				tlrInfoAuditBean.setRoleRellist(roleRellist);
				tlrInfoAuditBean.setRellist(saveRellist);
				
				SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
						ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
						ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
						tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),dbTrlInfo.getSt());
				rootdao.saveOrUpdate(tskInf);
				//20160719更改，如果操作ID不是管理员，则直接调用审批方法通过  "01"代表通过   100399 代表更新
				JdbcTemplate jt=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
				String roleId=globalInfo.getWorkflowRoleId();
				if(!roleId.equals("615")&&!roleId.equals("616")&&!roleId.equals("111")){
					List updateList = new ArrayList();
					List insertList = new ArrayList();
					List delList = new ArrayList();
					String approveResult = "01";    //审查结果
					String approveRemark = DAOUtils.getRoleInfoDAO().findById(Integer.valueOf(globalInfo.getWorkflowRoleId())).getRoleName()+"修改";  //备注
					TaskListService ts=TaskListService.getInstance();
					updateList.add(tskInf);
					ts.approveList(insertList, updateList, delList,approveResult ,approveRemark , ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value);
					jt.execute("DELETE FROM SYS_TASK_INFO O WHERE O.INS_CD!='00001' ");  //执行结束，删除待办表SYS_TASK_INFO的相关记录
				}

			} catch (IOException e) {
				ExceptionUtil.throwCommonException("操作员修改保存，双岗复核序列化到数据库出错！");
				e.printStackTrace();
			}
			dbTrlInfo.setTlrName(oldTlrName);
			rootdao.saveOrUpdate(dbTrlInfo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"修改用户编号[" + dbTrlInfo.getTlrno() + "]"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"修改用户编号[" + dbTrlInfo.getTlrno() + "]"});
		} else if ("del".equals(context.getAttribute(CMD))) {
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			tlrInfoDAO.delete(tlrno);

			List urrlist = relationDao.queryByCondition(" po.tlrno = '" + tlrno + "'");
			for (Iterator it = urrlist.iterator(); it.hasNext();) {
				TlrRoleRel ref = (TlrRoleRel) it.next();
				relationDao.delete(ref);
			}

		} else if ("mod".equals(context.getAttribute(CMD))) {
			TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
			TlrInfo ti = tlrInfoDAO.query(tlrInfo.getTlrno());
			if (ti != null) {
				ti.setTlrName(tlrInfo.getTlrName());
				ti.setBrcode(tlrInfo.getBrcode());
				ti.setEffectDate(tlrInfo.getEffectDate());
				ti.setExpireDate(tlrInfo.getExpireDate());
				ti.setEmail(tlrInfo.getEmail());
				tlrInfoDAO.saveOrUpdate(ti);
			}
		} else if ("auth".equals(context.getAttribute(CMD))) {
			List roleList = (List) context.getAttribute(IN_ROLELIST);
			TlrRoleRel rr = null;
			for (int i = 0; i < roleList.size(); i++) {
				TlrRoleRelationView inurr = (TlrRoleRelationView) roleList.get(i);
				List urrlist = relationDao.queryByCondition(" po.tlrno = '" + inurr.getTlrno() + "'  and po.roleId = " + inurr.getRoleId());
				// 选中的岗位
				if (inurr.isSelected()) {
					// 原先无数据,则插入新数据
					if (urrlist == null || urrlist.size() == 0) {
						rr = new TlrRoleRel();
						rr.setRoleId(Integer.valueOf(inurr.getRoleId()));
						rr.setTlrno(inurr.getTlrno());
						rr.setStatus("1");// 1有效 0无效
						relationDao.getHibernateTemplate().saveOrUpdate(rr);
					}
					// 原先有数据，则更新status
					else {
						for (int j = 0; j < urrlist.size(); j++) {
							rr = (TlrRoleRel) urrlist.get(j);
							if (!"1".equals(rr.getStatus())) {
								rr.setStatus("1");
								relationDao.getHibernateTemplate().saveOrUpdate(rr);
							}
						}
					}
				}
				// 没有选中的岗位
				else {
					for (int k = 0; k < urrlist.size(); k++) {
						rr = (TlrRoleRel) urrlist.get(k);
						relationDao.delete(rr);
					}
				}

			}
		} else if ("resetPwd".equals(context.getAttribute(CMD))) {
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			// 修改用户密码
//			UserMgrService userMgrService = new UserMgrService();
//			userMgrService.updatePassword(tlrno, SystemConstant.DEFAULT_PASSWORD);
			TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
			List<TlrBctlRel> bctlRellist = rootdao.queryByQL2List("from TlrBctlRel where tlrNo = '" + tlrno + "'");
			List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
			List<UserOrgRoleRel> orgRoleRels = rootdao.queryByQL2List("from UserOrgRoleRel where userId = '" + tlrno + "'");
			//授权机构
			RepList<TlrBctlRel> repBctlList = new RepList<TlrBctlRel>();
			for(TlrBctlRel tlrBctlRel : bctlRellist){
				repBctlList.add(tlrBctlRel);
			}
			//角色岗位
			RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
			for(TlrRoleRel tlrRoleRel : roleRellist){
				repRoleList.add(tlrRoleRel);
			}
			//角色岗位中间表
			RepList<UserOrgRoleRel> saveRellist = new RepList<UserOrgRoleRel>();//保存ID的机构关系
			for(UserOrgRoleRel f : orgRoleRels){
				saveRellist.add(f);
			}

			//设置修改中
			tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
			//设置充值密码标识
			tlrInfo.setRestFlg("reset");
			try {
				TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
				tlrInfoAuditBean.setTlrInfo(tlrInfo);
				tlrInfoAuditBean.setBctlRellist(repBctlList);
				tlrInfoAuditBean.setRoleRellist(repRoleList);
				tlrInfoAuditBean.setRellist(saveRellist);
				SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
						ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
						//这儿得改成修改
						ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
						tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),tlrInfo.getSt());
				rootdao.saveOrUpdate(tskInf);
				//20160719更改，如果操作ID不是管理员，则直接调用审批方法通过  "01"代表通过   100399 代表更新
				JdbcTemplate jt=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
				String roleId=globalInfo.getWorkflowRoleId();
				if(!roleId.equals("615")&&!roleId.equals("616")&&!roleId.equals("111")){
					List updateList = new ArrayList();
					List insertList = new ArrayList();
					List delList = new ArrayList();
					String approveResult = "01";    //审查结果
					String approveRemark = DAOUtils.getRoleInfoDAO().findById(Integer.valueOf(globalInfo.getWorkflowRoleId())).getRoleName()+"修改";  //备注
					TaskListService ts=TaskListService.getInstance();
					updateList.add(tskInf);
					ts.approveList(insertList, updateList, delList,approveResult ,approveRemark , ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value);
					jt.execute("DELETE FROM SYS_TASK_INFO O WHERE O.INS_CD!='00001' ");  //执行结束，删除待办表SYS_TASK_INFO的相关记录
				}
			} catch (IOException e) {
				ExceptionUtil.throwCommonException("操作员重置密码，双岗复核序列化到数据库出错！");
				e.printStackTrace();
			}
			rootdao.saveOrUpdate(tlrInfo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"重置用户编号[" + tlrInfo.getTlrno() + "]的密码"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"重置用户编号[" + tlrInfo.getTlrno() + "]的密码"});
		} else if ("unlock".equals(context.getAttribute(CMD))) {// 解锁
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
			List<TlrBctlRel> bctlRellist = rootdao.queryByQL2List("from TlrBctlRel where tlrNo = '" + tlrno + "'");
			List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
			List<UserOrgRoleRel> orgRoleRels = rootdao.queryByQL2List("from UserOrgRoleRel where userId = '" + tlrno + "'");
			//授权机构
			RepList<TlrBctlRel> repBctlList = new RepList<TlrBctlRel>();
			for(TlrBctlRel tlrBctlRel : bctlRellist){
				repBctlList.add(tlrBctlRel);
			}
			//角色岗位
			RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
			for(TlrRoleRel tlrRoleRel : roleRellist){
				repRoleList.add(tlrRoleRel);
			}
			//角色岗位中间表
			RepList<UserOrgRoleRel> saveRellist = new RepList<UserOrgRoleRel>();//保存ID的机构关系
			for(UserOrgRoleRel f : orgRoleRels){
				saveRellist.add(f);
			}

			//设置修改中
			tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
			String oldIsLock = tlrInfo.getIsLock();
			tlrInfo.setIsLock("0");
			try {
				TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
				tlrInfoAuditBean.setTlrInfo(tlrInfo);
				tlrInfoAuditBean.setBctlRellist(repBctlList);
				tlrInfoAuditBean.setRoleRellist(repRoleList);
				tlrInfoAuditBean.setRellist(saveRellist);
				SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
						ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
						ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
						tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),tlrInfo.getSt());
				rootdao.saveOrUpdate(tskInf);
			} catch (IOException e) {
				ExceptionUtil.throwCommonException("操作员解锁，双岗复核序列化到数据库出错！");
				e.printStackTrace();
			}
			//改回原值
			tlrInfo.setIsLock(oldIsLock);
			rootdao.saveOrUpdate(tlrInfo);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]解锁操作"});
			htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]解锁操作"});
		} else if ("status".equals(context.getAttribute(CMD))) {// 有效/无效  强行签退
			String tlrno = (String) context.getAttribute(IN_TLRNO);
			String status = (String) context.getAttribute(IN_PARAM);

			TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);

			if (SystemConstant.FLAG_ON.equals(status) || SystemConstant.FLAG_OFF.equals(status)) {
				List<TlrBctlRel> bctlRellist = rootdao.queryByQL2List("from TlrBctlRel where tlrNo = '" + tlrno + "'");
				List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
				List<UserOrgRoleRel> orgRoleRels = rootdao.queryByQL2List("from UserOrgRoleRel where userId = '" + tlrno + "'");
				//授权机构
				RepList<TlrBctlRel> repBctlList = new RepList<TlrBctlRel>();
				for(TlrBctlRel tlrBctlRel : bctlRellist){
					repBctlList.add(tlrBctlRel);
				}
				//角色岗位
				RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
				for(TlrRoleRel tlrRoleRel : roleRellist){
					repRoleList.add(tlrRoleRel);
				}
				//角色岗位中间表
				RepList<UserOrgRoleRel> saveRellist = new RepList<UserOrgRoleRel>();//保存ID的机构关系
				for(UserOrgRoleRel f : orgRoleRels){
					saveRellist.add(f);
				}

				//设置修改中
				tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
				String oldFlag = tlrInfo.getFlag();
				String oldStatus = tlrInfo.getStatus();
				tlrInfo.setFlag(status);
				try {
					TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
					tlrInfoAuditBean.setTlrInfo(tlrInfo);
					tlrInfoAuditBean.setBctlRellist(repBctlList);
					tlrInfoAuditBean.setRoleRellist(repRoleList);
					tlrInfoAuditBean.setRellist(saveRellist);
					SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(
							ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
							ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
							tlrInfoAuditBean,tlrInfoAuditBean.getTlrInfo().getTlrno(),tlrInfo.getSt());
					rootdao.saveOrUpdate(tskInf);
				} catch (IOException e) {
					ExceptionUtil.throwCommonException("操作员有效无效，双岗复核序列化到数据库出错！");
					e.printStackTrace();
				}
				//改回原值
				tlrInfo.setFlag(oldFlag);
				rootdao.saveOrUpdate(tlrInfo);
			} else if ("logout".equals(status)) {
				tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
				rootdao.saveOrUpdate(tlrInfo);
			}
			if("logout".equals(status)){
				globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]强行签退操作"});
				htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]强行签退操作"});
			} else {
				globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "]有效无效操作"});
				htlog.info("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"用户编号[" + tlrInfo.getTlrno() + "有效无效操作"});
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}