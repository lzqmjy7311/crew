package com.huateng.ebank.business.management.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.huateng.common.CommonFunction;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.entity.data.mng.PasswordHis;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.security.EncryptFactory;
import com.huateng.ebank.framework.security.EncryptFactory.Algorithm;
import com.huateng.ebank.framework.security.Md5;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class PasswordService {
	private static final Logger logger = Logger.getLogger(PasswordService.class);
	
	/**
	 * Default constructor
	 */
	protected PasswordService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static PasswordService getInstance() {
		return (PasswordService)ApplicationContextUtils.getBean(PasswordService.class.getName());
	}
	/**
	 * 
	 * @param sInputPassword 输入密码
	 * @param sRightPassword 正确密码
	 * @param sEncMethod 加密方式
	 * @return 密码相同则true，否则false
	 */
	public boolean ComparePassword(String sInputPassword,String sRightPassword,String sEncMethod){
		String sTransPassword = "";
		if( sEncMethod == null || sEncMethod.equalsIgnoreCase("") || sEncMethod.equalsIgnoreCase("none") )
		{
			sTransPassword = sInputPassword;
		}
		else if(sEncMethod.equalsIgnoreCase("md5"))
		{
			Md5 objMd5 = new Md5();
			sTransPassword = objMd5.getMD5ofStr(SystemConstant.DEFAULT_PASSWORD_KEY + sInputPassword);
		}
		// add by zhaozhiguo 2012/03/12 BMSA-200 密码强度升级 begin 
		else {
			sTransPassword = EncryptFactory.getEncryption(Algorithm.valueOf(sEncMethod.toUpperCase())).encrypt(sInputPassword, SystemConstant.DEFAULT_PASSWORD_KEY);
		}
		// add by zhaozhiguo 2012/03/12 BMSA-200 密码强度升级 end 
		return sTransPassword.equals(sRightPassword);
	}
	
	public String EncryptPassword(String sInputPassword,String sEncMethod){
		String sTransPassword = "";
		if( sEncMethod == null || sEncMethod.equalsIgnoreCase("") || sEncMethod.equalsIgnoreCase("none") )
		{
			sTransPassword = sInputPassword;
		}
		else if(sEncMethod.equalsIgnoreCase("md5"))
		{
			Md5 objMd5 = new Md5();
			sTransPassword = objMd5.getMD5ofStr(SystemConstant.DEFAULT_PASSWORD_KEY + sInputPassword);
		}
		// add by zhaozhiguo 2012/03/12 BMSA-200 密码强度升级 begin 
		else {
			sTransPassword = EncryptFactory.getEncryption(Algorithm.valueOf(sEncMethod.toUpperCase())).encrypt(sInputPassword, SystemConstant.DEFAULT_PASSWORD_KEY);
		}
		// add by zhaozhiguo 2012/03/12 BMSA-200 密码强度升级 end 
		return sTransPassword;
	}
	
	public void savePasswordHis(String userid, String password, String enc)
			throws CommonException {
		//
		int repeatInterval = Integer.valueOf(CommonService.getInstance()
				.getSysParamDef("PSWD", "REPEAT_INTERVAL", "6"));
		if (repeatInterval > 0) {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(PasswordHis.class);
			criteria.add(Restrictions.eq("userid", userid));
			criteria.addOrder(Order.desc("modifiedTime"));
			List<PasswordHis> passHisList = DAOUtils.getHQLDAO()
					.getHibernateTemplate()
					.findByCriteria(criteria, 0, repeatInterval);
			for (PasswordHis pdHis : passHisList) {
				if (password.equalsIgnoreCase(pdHis.getPassword())) {
					ExceptionUtil.throwCommonException(
							ErrorCode.ERROR_CODE_REPEAT_INTERVAL,
							new Object[] { repeatInterval });
				}
			}
		}
		PasswordHis ph = new PasswordHis();
		ph.setEncMode(enc);
		ph.setModifiedTime(CommonFunction.getLocalDateTime14());
		ph.setPassword(password);
		ph.setUserid(userid);
		DAOUtils.getHQLDAO().getHibernateTemplate().save(ph);
	}
}
