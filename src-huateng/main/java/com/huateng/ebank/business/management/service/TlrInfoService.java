package com.huateng.ebank.business.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.entity.dao.mng.BctlDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.dao.mng.RoleInfoDAO;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.dao.mng.TlrRoleRelDAO;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.entity.view.TlrRoleChangeView;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 *
 *
 * @author zxj
 *
 */
public class TlrInfoService {

	private static final Logger logger = Logger.getLogger(TlrInfoService.class);

	protected TlrInfoService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static TlrInfoService getInstance() {
		return (TlrInfoService) ApplicationContextUtils
				.getBean(TlrInfoService.class.getName());
	}

	/**
	 * 查询操作员信息
	 *
	 * @param brcode
	 * @param tlrno
	 * @return
	 * @throws CommonException
	 */
	public List selectTlrInfo(String brcode, String tlrno)
			throws CommonException {
		if (DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
			ExceptionUtil.throwCommonException("机构号与操作员号必输其一",
					ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		}
		List tlrInfoList = new ArrayList();
		if (!DataFormat.isEmpty(brcode)) {
			BctlDAO bctlDao = BaseDAOUtils.getBctlDAO();
			try {
				bctlDao.query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在",
						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			String bctlList = BctlService.getInstance().getAllBlnBrcodeStr(
					globalInfo.getBrcode());
			if (bctlList.indexOf(brcode) < 0) {
				ExceptionUtil.throwCommonException("输入机构号不为本机构或者下属机构",
						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
		}
		TlrInfoDAO dao = BaseDAOUtils.getTlrInfoDAO();
		// 输入了机构号，没有输入操作员号
		if (!DataFormat.isEmpty(brcode) && DataFormat.isEmpty(tlrno)) {
			// 机构号不为空操作员为空返回该机构下的操作员列表
			tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode + "'");
			// 输入了操作员号 ，没有输入机构号
		} else if (DataFormat.isEmpty(brcode) && !DataFormat.isEmpty(tlrno)) {
			TlrInfo tlrInfo = dao.queryById(tlrno);
			if (tlrInfo != null) {
				tlrInfoList.add(tlrInfo);
			}
			// 都输入了
		} else {
			tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode
					+ "'and po.tlrno ='" + tlrno + "'");

		}
		return tlrInfoList;
	}

	/**
	 * 查询所有岗位信息
	 *
	 * @return
	 * @throws CommonException
	 */
	public List selectAllRoles() throws CommonException {
		RoleInfoDAO roleDAO = BaseDAOUtils.getRoleInfoDAO();
		List allRoleList = roleDAO.queryByCondition("1=1");
		return allRoleList;
	}

	/**
	 * 查询有效岗位信息
	 *
	 * @return
	 * @throws CommonException
	 */
	public List selectRolesWithoutNullification() throws CommonException {
		RoleInfoDAO roleDAO = BaseDAOUtils.getRoleInfoDAO();
		List allRoleList = roleDAO.queryByCondition("po.status='1'");
		return allRoleList;
	}

	public List selectRolesByTlr(String tlrno) throws CommonException {
		TlrRoleRelDAO relationDAO = (TlrRoleRelDAO) ApplicationContextUtils
				.getBean("TlrRoleRelationDAO");
		RoleInfoDAO roleDAO = BaseDAOUtils.getRoleInfoDAO();
		List roleList = new ArrayList();

		List tlrRoleList = new ArrayList();
		tlrRoleList = relationDAO.queryByCondition("po.tlrno ='" + tlrno + "'");
		if (tlrRoleList.size() == 0) {
			tlrRoleList = new ArrayList();
		}
		for (int i = 0; i < tlrRoleList.size(); i++) {
			TlrRoleRel tlrRoleRelation = (TlrRoleRel) tlrRoleList
					.get(i);
			RoleInfo roleInfo = roleDAO.query(tlrRoleRelation.getRoleId()
					.intValue());
			roleList.add(roleInfo);
		}
		return roleList;
	}

	public List selectTlrRolesInfo(String brcode, String tlrno)
			throws CommonException {
		List tlrInfoList = new ArrayList();
		TlrInfoDAO dao = BaseDAOUtils.getTlrInfoDAO();
		tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode
				+ "'and po.tlrno ='" + tlrno + "'");
		if (tlrInfoList.size() == 0) {
			TlrInfo tlrInfo = new TlrInfo();
			tlrInfo = new TlrInfo();
			tlrInfo.setBrcode(brcode);
			tlrInfo.setTlrno(tlrno);
			tlrInfo.setStatus(SystemConstant.VALID_FLAG_VALID);
			tlrInfoList.add(tlrInfo);
		}
		return tlrInfoList;
	}

	public List selectTlrRolesInfo2(String brcode, String tlrno)
			throws CommonException {
		List tlrInfoList = new ArrayList();
		TlrInfoDAO dao = BaseDAOUtils.getTlrInfoDAO();
		tlrInfoList = dao.queryByCondition("po.brcode = '" + brcode
				+ "'and po.tlrno ='" + tlrno + "'");
		if (tlrInfoList.size() == 0) {
			TlrInfo tlrInfo = new TlrInfo();
			tlrInfo = new TlrInfo();
			tlrInfo.setBrcode(brcode);
			tlrInfo.setTlrno(tlrno);
			tlrInfo.setStatus(SystemConstant.VALID_FLAG_VALID);
			String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
			tlrInfo.setPassword(sysDefaultPwd);
			tlrInfoList.add(tlrInfo);
		}
		return tlrInfoList;
	}

	/**
	 * 操作员增加查询
	 *
	 * @param brcode
	 * @param tlrno
	 * @return
	 * @throws CommonException
	 */
	public List selectTlrInfoAdd(String brcode, String tlrno)
			throws CommonException {
		if (DataFormat.isEmpty(brcode) || DataFormat.isEmpty(tlrno)) {
			ExceptionUtil.throwCommonException("机构号与操作员号必须输入",
					ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		}

		if (!DataFormat.isEmpty(brcode)) {
			BctlDAO bctlDao = BaseDAOUtils.getBctlDAO();
			try {
				bctlDao.query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在",
						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			String bctlList = BctlService.getInstance().getAllBlnBrcodeStr(
					globalInfo.getBrcode());
			if (bctlList.indexOf(brcode) < 0) {
				ExceptionUtil.throwCommonException("输入机构号不为本机构或者下属机构",
						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
		}

		TlrInfoDAO dao = BaseDAOUtils.getTlrInfoDAO();
		TlrInfo tlrInfo = dao.queryById(tlrno);
		List tlrInfoList = new ArrayList();
		if (tlrInfo != null) {
			ExceptionUtil.throwCommonException("该操作员已经存在，不能新增",
					ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
		} else {
			tlrInfo = new TlrInfo();
			tlrInfo.setBrcode(brcode);
			tlrInfo.setTlrno(tlrno);
			tlrInfoList.add(tlrInfo);
		}
		return tlrInfoList;
	}

	/**
	 * 新增修改操作员信息
	 *
	 * @param insertRoleList
	 * @param deleteRoleList
	 * @param tlrInfo
	 * @return
	 * @throws CommonException
	 */
	public List updateTlrInfo(List insertRoleList, List deleteRoleList,
			TlrInfo tlrInfo) throws CommonException {
		TlrInfoDAO dao = BaseDAOUtils.getTlrInfoDAO();
		String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");

		String pwd = PasswordService.getInstance().EncryptPassword(tlrInfo.getPassword(), encMethod);
		tlrInfo.setPassword(pwd);
		tlrInfo.setRoleid(tlrInfo.getRoleid());

//		if (this.dateJudge(tlrInfo.getEffectDate(), tlrInfo.getExpireDate()))
//			dao.saveOrUpdate(tlrInfo);
//		else
//			ExceptionUtil.throwCommonException("失效日期必须在生效日期之后", "错误");

		TlrRoleRelDAO tlrRoleDAO = (TlrRoleRelDAO) ApplicationContextUtils
				.getBean("TlrRoleRelationDAO");
		for (int i = 0; i < insertRoleList.size(); i++) {
			TlrRoleRelationView tlrRoleInfoView = (TlrRoleRelationView) insertRoleList
					.get(i);
			TlrRoleRel tlrRole = new TlrRoleRel();
			tlrRole.setRoleId(new Integer(tlrRoleInfoView.getRoleId()));
			tlrRole.setTlrno(tlrRoleInfoView.getTlrno());
			tlrRoleDAO.insert(tlrRole);
		}
		for (int i = 0; i < deleteRoleList.size(); i++) {
			TlrRoleRelationView tlrRoleInfoView = (TlrRoleRelationView) deleteRoleList
					.get(i);
			TlrRoleRel tlrRole = new TlrRoleRel();
			tlrRole.setRoleId(new Integer(tlrRoleInfoView.getRoleId()));
			tlrRole.setTlrno(tlrRoleInfoView.getTlrno());
			tlrRoleDAO.delete(tlrRole);
		}
		return new ArrayList();
	}

	/**
	 * 删除操作员
	 *
	 * @param tlrInfo
	 */
	public void deleteTlr(TlrInfo tlrInfo) {
		TlrInfoDAO tid = BaseDAOUtils.getTlrInfoDAO();
		try {
			tlrInfo.setStatus("0");
			tid.saveOrUpdate(tlrInfo);
		} catch (CommonException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 操作员激活
	 *
	 * @param TlrInfo
	 */
	public void TlrActivation(TlrInfo tlrInfo) {
		TlrInfoDAO tid = BaseDAOUtils.getTlrInfoDAO();
		try {
			tlrInfo.setStatus("1");
			tid.saveOrUpdate(tlrInfo);
		} catch (CommonException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 有效期判断
	 */
	private boolean dateJudge(Date effectDate, Date ExpireDate) {
		if (effectDate.before(ExpireDate))
			return true;
		return false;
	}

	// /**
	// * 修改操作员密码
	// */
	// public void changeTlrPassword(String userLoginId, String oldPwd,
	// String newPwd, String againNewPwd) throws CommonException {
	// UserMgrService ums = new UserMgrService();
	// ums.checkUserPwd(userLoginId, oldPwd);
	// ums.checkPwdFields(oldPwd, newPwd, againNewPwd);
	// ums.updatePassword(userLoginId, newPwd);
	// }
	// /**
	// * 返回操作员岗位切换视图
	// *
	// * @throws CommonException
	// */
	// public TlrRoleChangeView getTlrRoleChangeView() throws CommonException{
	// TlrRoleChangeView trcv=new TlrRoleChangeView();
	// UserMgrService ums=new UserMgrService();
	// String tlrno=GlobalData.getCurrentInstance().getTlrno();
	// String brname=ums.getUserBctl(new
	// TlrInfoDAO().query(tlrno).getBrcode()).getBrname();
	// String currentRole=
	// }
	/**
	 * 查询当前岗位信息
	 */
	public List getTlrRoleChange() throws CommonException {
		List tlrRoleChangeList = new ArrayList();
		TlrRoleChangeView tcv = new TlrRoleChangeView();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		TlrInfo ti = BaseDAOUtils.getTlrInfoDAO().queryById(gi.getTlrno());
		tcv.setTlrno(GlobalInfo.getCurrentInstance().getTlrno());
		tcv.setRolename(BaseDAOUtils.getRoleInfoDAO().query(
				ti.getRoleid().intValue()).getRoleName());
		tcv.setBrname(BaseDAOUtils.getBctlDAO().query(gi.getBrcode()).getBrname());
		tlrRoleChangeList.add(tcv);
		return tlrRoleChangeList;
	}

	/**
	 * 查询兼任岗位信息
	 */
	public List getPluRole() throws CommonException {
		List pluRoleList = new ArrayList();
		TlrInfo ti = BaseDAOUtils.getTlrInfoDAO().queryById(
				GlobalInfo.getCurrentInstance().getTlrno());
		List tlrRoleRelationList = BaseDAOUtils.getTlrRoleRelDAO()
				.queryByCondition(
						"po.tlrno='"
								+ GlobalInfo.getCurrentInstance().getTlrno()
								+ "'");
		for (int i = 0; i < tlrRoleRelationList.size(); i++) {
			TlrRoleRel trr = (TlrRoleRel) tlrRoleRelationList.get(i);
			RoleInfo ri = BaseDAOUtils.getRoleInfoDAO().query(
					trr.getRoleId().intValue());
			if (ri.getId().compareTo(ti.getRoleid()) == 0) {
				continue;
			}
			pluRoleList.add(ri);
		}
		return pluRoleList;
	}

	/**
	 *
	 * Description: 通过核心操作员号,查询该操作员是否是客户经理
	 *
	 * @param
	 * @return boolean
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-9-19
	 */
	public boolean judgeTlrIsCustManager(String extTlrno)
			throws CommonException {
		boolean flag = false;
		TlrInfoDAO tiDao = BaseDAOUtils.getTlrInfoDAO();
		TlrRoleRelDAO trrDao = BaseDAOUtils.getTlrRoleRelDAO();
		TlrInfo tlrInfo = null;
		List tlrInfoList = tiDao.queryByCondition("po.tlrno=?",
				new Object[] { extTlrno }, null);
		if (tlrInfoList.size() == 0) {
			ExceptionUtil
					.throwCommonException("没有找到操作员:" + extTlrno, "操作员查询失败");
		} else {
			tlrInfo = (TlrInfo) tlrInfoList.get(0);
		}
		List roleList = trrDao.queryByCondition("po.tlrno=?",
				new Object[] { tlrInfo.getTlrno() }, null);
		if (roleList.size() == 0) {
			ExceptionUtil.throwCommonException("操作员:" + extTlrno + "无岗位",
					"操作员岗位查询失败");
		} else {
			TlrRoleRel trr = null;
			for (int i = 0; i < roleList.size(); i++) {
				trr = (TlrRoleRel) roleList.get(i);
				if (trr.getRoleId().equals(
						new Integer(SystemConstant.ROLE_CUST_MANAGER))) {
					flag = true;
				}
			}
		}
		return flag;
	}

	public TlrInfo getTlrInfoByTlrno(String tlrno) throws CommonException {
		TlrInfoDAO dao = BaseDAOUtils.getTlrInfoDAO();
		TlrInfo tlrInfo = dao.query(tlrno);
		return tlrInfo;
	}

	/**
	 *
	 * Description: 通过外部操作员号获得内部操作员号
	 *
	 * @param
	 * @return String
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-8-18
	 */
	public String getTlrno(String extTlrno) throws CommonException {
		TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
		List tlrInfoList = tlrInfoDAO.queryByCondition("po.tlrno=?", new Object[] { extTlrno }, new Type[] { Hibernate.STRING });
		String tlrno = null;
		if (tlrInfoList.size() != 0) {
			tlrno = ((TlrInfo) tlrInfoList.get(0)).getTlrno();
			return tlrno;
		} else {
			ExceptionUtil.throwCommonException("没有该操作员");
		}
		return tlrno;
	}

	/**
	 *
	 * Description: 输入内部机构号 内部操作员号 判断该操作员是否属于该机构
	 *
	 * @param
	 * @return boolean
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-8-18
	 * @throws CommonException
	 */
	public boolean judgeTlrAttach(String tlrno, String brcode) throws CommonException {
		TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
		TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
		if (StringUtils.equals(tlrInfo.getBrcode(), brcode)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * Description: 通过内部操作员号获得外部操作员号
	 *
	 * @param
	 * @return String
	 * @exception
	 * @author hyurain_yang
	 * @version v1.0,2008-8-18
	 */
	public String getExtTlrno(String tlrno) throws CommonException {
		TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
		TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
		return tlrInfo.getTlrno();
	}
	/**
	 * Description: 判断操作员是否已经登录,判断操作员登录的Session Id是否一致
	 *
	 * @param tlrno
	 *            内部操作员号 sessionId 会话ID号
	 * @return boolean
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2008-10-7
	 */
	public boolean isLogin(String tlrno, String sessionId){
		try {
			TlrInfo tlrInfo = getTlrInfoByTlrno(tlrno);
			if (tlrInfo.getStatus().equals(SystemConstant.TLR_NO_STATE_LOGIN) && tlrInfo.getSessionId().equals(sessionId)) {
				return true;
			}
		} catch (CommonException e) {
			logger.error(e.getMessage());
			return false;
		}

		return false;
	}

	/**
	 * 根据机构ID与角色ID获取用户
	 *
	 * @param brcode
	 * @param roleId
	 * @return ??TlrInfo?????List
	 * @throws CommonException
	 */
	public List queryByBrcodeAndRoleId(String brcode,String roleId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String sql="select t1.TLRNO,t1.TLR_NAME,t2.ROLE_ID,t1.BRCODE from ecuser.TLR_INFO t1,ecuser.TLR_ROLE_REL t2  where t1.TLRNO=t2.TLRNO ";
		if(brcode!=null && !"".equals(brcode)){
			sql=sql+"  and t1.BRCODE='"+brcode+"'";
		}
		if(roleId!=null && !"".equals(roleId)){
			sql=sql+" and t2.ROLE_ID="+roleId;
		}
		
		Iterator funcName = null;
		try {
			funcName = rootdao.queryBySQL(sql);
		} catch (CommonException e) {
			e.printStackTrace();
		}
		List funList = new ArrayList();
		while (funcName.hasNext()) {
			Object[] object = (Object[]) funcName.next();
			funList.add(object);
		}
		return funList;
	}
	
	
}
