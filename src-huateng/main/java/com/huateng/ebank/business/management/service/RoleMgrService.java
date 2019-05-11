package com.huateng.ebank.business.management.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.RoleInfoDAO;
import com.huateng.ebank.entity.dao.mng.TlrRoleRelDAO;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.view.RoleBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class RoleMgrService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RoleMgrService.class);
	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static RoleMgrService getInstance() {
		return (RoleMgrService)ApplicationContextUtils.getBean(RoleMgrService.class.getName());
	}

	public RoleMgrService() {
	}

    /**
     * 获得角色管理表
     * @author guolitao
     * @param none
     * @return List
     * @throws CommonException
     */
	public List getRoleInfo()throws CommonException
	{
		List resultList = new ArrayList();
		RoleInfoDAO roleDao = BaseDAOUtils.getRoleInfoDAO();
		resultList = roleDao.findAll();
		List results = new ArrayList();
		for(int i = 0; i < resultList.size();i++)
		{
			RoleBean rb = new RoleBean();
			RoleInfo  r = (RoleInfo) resultList.get(i);
			rb.setRoleid(r.getId());
			rb.setRolename(r.getRoleName());
			rb.setStatus(r.getStatus());
			results.add(rb);
		}
		return results;
	}

	/**
	 * @param roleId
	 * @return
	 * @throws CommonException
	 */
	public RoleInfo getRoleById(Integer roleId)throws CommonException{
		RoleInfoDAO roleDao = BaseDAOUtils.getRoleInfoDAO();
		return roleDao.findById(roleId);
	}
    /**
     * 获得角色管理表
     * @author guolitao
     * @param pageSize, pageIndex
     * @return PageQueryResult
     * @throws CommonException
     */
	public PageQueryResult getRoleInfo(int pageSize, int pageIndex)throws CommonException
	{
		if (logger.isDebugEnabled()) {
			logger.debug("getRoleInfo() - start"); //$NON-NLS-1$
		}
		StringBuffer hqlstr = new StringBuffer(512);
		hqlstr.append("select r.roleid, r.rolename, r.status from RoleInfo r");
		PageQueryCondition pqc = new PageQueryCondition();
		pqc.setPageIndex(pageIndex);
		pqc.setPageSize(pageSize);
		pqc.setQueryString(hqlstr.toString());

		PageQueryResult queryResult = new PageQueryResult();
		PageQueryResult pageQueryResult = new PageQueryResult();
		List resultList = new ArrayList();

		try {
			queryResult = BaseDAOUtils.getHQLDAO().pageQueryByQL(pqc);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List list = queryResult.getQueryResult();
		for(int i = 0; i < list.size(); i++)
		{
			Object[] result = (Object[])list.get(i);
			RoleBean role = new RoleBean();
			role.setRoleid((Integer)result[0]);
			role.setRolename((String)result[1]);
			role.setStatus((String)result[2]);
			resultList.add(role);
			pageQueryResult.setQueryResult(resultList);
			pageQueryResult.setTotalCount(resultList.size());
		}
		pageQueryResult.setTotalCount(queryResult.getTotalCount());
		return pageQueryResult;
	}
	/**
	 * 保存角色管理信息
	 * @author guolitao
	 * @return void
	 * @param delList,insertList,updateList,context
	 * @throws CommonException
	 */
	public void updateRoleInfo(List delList,List insertList, List updateList, OperationContext context)
	throws CommonException
	{
		if (logger.isDebugEnabled()) {
			logger.debug("updateRoleInfo(List delList,List insertList, List updateList, OperationContext context) - start"); //$NON-NLS-1$
		}
		RoleInfoDAO roleDao = BaseDAOUtils.getRoleInfoDAO();
		GlobalInfo globalData = GlobalInfo.getCurrentInstance();
		//新增list
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			RoleBean rb = (RoleBean)it.next();
			RoleInfo role = new RoleInfo();
			role.setId(rb.getRoleid());
			role.setRoleName(rb.getRolename());
			role.setStatus(rb.getStatus());
			roleDao.save(role);
		}
		//更新list
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			RoleBean rb = (RoleBean)it.next();
			RoleInfo role = roleDao.findById(rb.getRoleid());
			role.setRoleName(rb.getRolename());
			role.setStatus(rb.getStatus());
			roleDao.getHibernateTemplate().update(role);
		}
		//删除list
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			RoleBean rb = (RoleBean)it.next();
			Integer ID = rb.getRoleid();
			RoleInfo role = roleDao.findById(ID);
			roleDao.delete(role);
		}
	}

	/**
	 * 根据id查询 RoleInfo
	 *
	 * @param roleName
	 */

	public String getRoleName(int id) {
		RoleInfoDAO dao = BaseDAOUtils.getRoleInfoDAO();
		RoleInfo role = new RoleInfo();
		role = dao.findById(id);
		String roleName = role.getRoleName();
		return roleName;
	}
	/**
	 * 查询登陆柜员是否有某岗位（暂）
	 *
	 * @param userId
	 * @param roleId
	 */
	public boolean hasRole(int userId,int roleId)throws CommonException
	{

		TlrRoleRelDAO userRoleRelDAO = BaseDAOUtils.getTlrRoleRelDAO();
		String sql = "po.userid="+userId+" and po.roleid="+roleId;
		List results   = userRoleRelDAO.queryByCondition(sql);
		if(results!=null && results.size()>0){
			return true;
		}
		return false;
	}

}
