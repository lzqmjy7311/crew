package com.huateng.ebank.entity.dao.mng;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.FunctionInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class FunctionInfoDAO extends HibernateDaoSupport {
	public FunctionInfoDAO() {
		super();
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return FunctionInfo
	 * @throws CommonException
	 */
	public FunctionInfo query(String id) throws CommonException {
		try {
			return (FunctionInfo) this.getHibernateTemplate().load(
					FunctionInfo.class, id);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据业务主键查询，如果没有找到记录，则返回null
	 *
	 * @param key1
	 * @param key2
	 * @return FunctionInfo
	 * @throws CommonException
	 *             public FunctionInfo query(String key1, String key2) throws
	 *             CommonException { List list = new ArrayList(); try {
	 *             StringBuffer whereString = new StringBuffer();
	 *             whereString.append("po.key1 = '").append(key1).append( "' and
	 *             po.key2 = '").append(key2).append("'"); list =
	 *             queryByCondition(whereString.toString()); } catch (Exception
	 *             e) { ExceptionUtil.throwCommonException(e.getMessage(),
	 *             ErrorCode.ERROR_CODE_FUNCTION_INFO_SELECT, e); }
	 *
	 * if (list.size() != 1) { return null; } else { return (FunctionInfo)
	 * list.get(0); } }
	 */

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return 包含FunctionInfo对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString, Object[] objArray,
			Type[] typeArray) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from FunctionInfo po where " + whereString, objArray);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含FunctionInfo对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from FunctionInfo po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_SELECT, e);
		}
		return null;
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(FunctionInfo po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_UPDATE, e);
		}
	}

	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(FunctionInfo po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_INSERT, e);
		}
	}

	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(FunctionInfo po) throws CommonException {
		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_DELETE, e);
		}
	}

	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_DELETE, e);
		}
	}

	/**
	 *
	 * add by NT 2007-09-21
	 *
	 * 根据输入的组合条件查询对象集合
	 *
	 * @param Set
	 *            conditionSet 条件集合 例如 Set set = new HashSet(); QueryCondition
	 *            qc; qc = new QueryCondition("oprId", "=", "'1'"); set.add(qc);
	 *            qc = new QueryCondition("bizId", "=", "'2'"); set.add(qc);
	 *            List list = bizLogDAO.queryByCondition(set, 1, 0);
	 *
	 * @param int
	 *            startPage 展现层的开始页数
	 * @param int
	 *            maxRows 展现层的每页记录数 -1 :全部; 0 :默认值; 其他:实际值
	 * @return List 对象集合
	 * @throws DAOException
	 */
	// public List queryByCondition(Set conditionSet, int startPage, int
	// maxRows)
	// throws CommonException {
	// List returnValue = new ArrayList();
	// FunctionInfo pojo;
	// startPage = startPage >= 1 ? startPage : 1;
	// int firstResult = (startPage - 1)
	// * (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
	// int rows = maxRows;
	// rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);
	//
	// try {
	//
	// String hql = "from FunctionInfo as po ";
	// if (conditionSet.size() > 0) {
	// hql = hql + "where 0=0 ";
	// Iterator it = conditionSet.iterator();
	// while (it.hasNext()) {
	// QueryCondition qc = (QueryCondition) it.next();
	// hql = hql + "and po." + qc.getProperty() + " "
	// + qc.getCondition() + " " + qc.getValue() + " ";
	// }
	// }
	//
	// Query query = this.getSession().createQuery(hql);
	// query.setFirstResult(firstResult);
	// if (rows != -1) {
	// query.setMaxResults(rows + 1);
	// }
	// returnValue = query.list();
	//
	// } catch (HibernateException e) {
	// ExceptionUtil.throwCommonException(e.getMessage(),
	// ErrorCode.ERROR_CODE_ERR_CODE_DEFINE_SELECT, e);
	// }
	// return returnValue;
	// }
	/**
	 * add by NT 2007-09-21 根据输入的条件字串查询对象集合
	 *
	 * @param String
	 *            whereString 条件集合 例如 "po.name = 'user1' and po.level = '1' or
	 *            ...."
	 * @param int
	 *            startPage 展现层的开始页数
	 * @param int
	 *            maxRows 展现层的每页记录数 -1 :全部; 0 :默认值; 其他:实际值
	 * @return List 对象集合
	 * @throws DAOException
	 */
	public List queryByCondition(String whereString, int startPage, int maxRows)
			throws CommonException {
		List returnValue = new ArrayList();
		startPage = startPage >= 1 ? startPage : 1;
		int firstResult = (startPage - 1)
				* (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
		int rows = maxRows;
		rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);

		try {

			String hql = "from FunctionInfo as po where ";
			hql = hql + whereString;

			Query query = this.getSession().createQuery(hql);
			query.setFirstResult(firstResult);
			if (rows != -1) {
				query.setMaxResults(rows + 1);
			}
			returnValue = query.list();

		} catch (HibernateException e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_SELECT, e);
		}
		return returnValue;
	}

	public List queryAllBySort() throws CommonException {
		List list = null;
		try {
			String hql = "from FunctionInfo as po where po.menuFlag = '1' or po.funcType = '4' order by po.id";
			list = this.getSession().createQuery(hql).list();

		} catch (HibernateException e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_FUNCTION_INFO_SELECT, e);
		}
		return list;
	}
	public List findAll() {
		try {
			String queryString = "from FunctionInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
