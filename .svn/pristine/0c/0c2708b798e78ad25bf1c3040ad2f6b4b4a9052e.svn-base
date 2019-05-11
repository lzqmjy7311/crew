/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.parammng.operation;

import java.util.ArrayList;
import java.util.List;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.service.PasswordService;
import com.huateng.ebank.business.parammng.bean.TlrRoleInfoView;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.dao.mng.TlrRoleRelDAO;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author wuguangjie
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class TlrInfoOperation extends BaseOperation {

	public static final String IN_LIST = "IN_LIST";
	public static final String IN_TLRINFO = "IN_TLRINFO";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		//GlobalInfo就相当于一个session
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		TlrInfo tlrInfo = (TlrInfo) context
				.getAttribute(TlrInfoOperation.IN_TLRINFO);
		List list = (List) context.getAttribute(TlrInfoOperation.IN_LIST);
		TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
		TlrRoleRelDAO relationDao = DAOUtils.getTlrRoleRelDAO();
		TlrInfo tmpTlrInfo = null;
		try {
			tmpTlrInfo = tlrInfoDAO.query(tlrInfo.getTlrno());
		} catch (Exception e) {
			e.printStackTrace();
		}

		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			TlrRoleInfoView tlrRoleInfoView = (TlrRoleInfoView) list.get(i);
			if (tlrRoleInfoView.isSelect1()) {
				temp++;
			}
		}

		// 新加操作员
		if (tmpTlrInfo == null) {
			String brcode = tlrInfo.getBrcode();
			try {
				Bctl bctl = DAOUtils.getBctlDAO().query(brcode);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("输入机构号不存在",
						ErrorCode.ERROR_CODE_BCTL_SELECT);
			}

			String bctlList = BctlService.getInstance().getAllBlnBrcodeStr(
					globalInfo.getBrcode());
			if (bctlList.indexOf(brcode) < 0) {
				ExceptionUtil.throwCommonException("输入机构号不为本机构或者下属机构",
						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			if (temp == 0) {
				ExceptionUtil.throwCommonException("请至少选择一个岗位。",
						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
			String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
			String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");

			String pwd = PasswordService.getInstance().EncryptPassword(sysDefaultPwd, encMethod);

			insertTlrRoleRelation(tlrInfo.getBrcode(), list, relationDao);
		}
		// 更改操作员信息
		else {
//			if (temp == 0 ) {
//				ExceptionUtil.throwCommonException("请至少选择一个岗位。",
//						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
//			}


			tmpTlrInfo.setTlrName(tlrInfo.getTlrName());
			tmpTlrInfo.setEffectDate(tlrInfo.getEffectDate());
			tmpTlrInfo.setExpireDate(tlrInfo.getExpireDate());
			tmpTlrInfo.setEmail(tlrInfo.getEmail());
			tmpTlrInfo.setStatus(tlrInfo.getStatus());
			for (int i = 0; i < list.size(); i++) {
				TlrRoleInfoView bean = (TlrRoleInfoView) list.get(i);
				if (bean.isSelect1()) {
					tmpTlrInfo.setRoleid(bean.getRoleid());
				}
			}
			tlrInfoDAO.update(tmpTlrInfo);
			updateTlrRoleRelation(tmpTlrInfo.getBrcode(), list, relationDao);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	private void updateTlrRoleRelation(String brcode, List list,
			TlrRoleRelDAO relationDao) throws CommonException {
		String tlrno = "";
		for (int i = 0; i < list.size(); i++) {
			TlrRoleInfoView bean = (TlrRoleInfoView) list.get(i);
			tlrno = bean.getTlrno();
			if (bean.isSelect1()) { // 选中的岗位
				List relationList = null;
				try {
					relationList = relationDao.queryByCondition("po.tlrno='"
							+ bean.getTlrno() + "' and po.roleId="
							+ bean.getRoleid());
				} catch (Exception e) {
				}
				if (relationList == null || relationList.size() == 0) { // 若原来没有这个岗位
					TlrRoleRel relation = new TlrRoleRel();
					relation.setTlrno(bean.getTlrno());
					relation.setRoleId(bean.getRoleid());
					//relation.setBrcode(brcode);
					relationDao.insert(relation);
				}
			} else { // 没有选中的岗位
				List relationList = null;
				try {
					relationList = relationDao.queryByCondition("po.tlrno='"
							+ bean.getTlrno() + "' and po.roleId="
							+ bean.getRoleid());
				} catch (Exception e) {
				}
				if (relationList != null && relationList.size() > 0) { // 若原来有这个岗位则删除
					TlrRoleRel relation = (TlrRoleRel) relationList.get(0);
					relationDao.delete(relation);
				}
			}
		}
		// 检查修改后是否一个岗位都没配
		if (!tlrno.equals("")) {
			List relationList1 = new ArrayList();
			try {
				relationList1 = relationDao.queryByCondition("po.tlrno='"
						+ tlrno + "'");
			} catch (Exception e) {
			}
			if (relationList1.size() == 0) {
				ExceptionUtil.throwCommonException("请至少保留一个岗位。",
						ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
			}
		}

	}

	private void insertTlrRoleRelation(String brcode, List list,
			TlrRoleRelDAO relationDao) throws CommonException {
		for (int i = 0; i < list.size(); i++) {
			TlrRoleInfoView bean = (TlrRoleInfoView) list.get(i);
			if (bean.isSelect1()) {
				TlrRoleRel relation = new TlrRoleRel();
				relation.setTlrno(bean.getTlrno());
				relation.setRoleId(bean.getRoleid());
				//relation.setBrcode(brcode);
				relationDao.insert(relation);
			}
		}
	}
}