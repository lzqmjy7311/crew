package com.huateng.ebank.business.management.service;

import java.util.Iterator;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.BiNationregion;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

/*
 * 国家/地区维护service
 * 
 */
public class BiNationregionService {
	/*
	 * 获取自身实例
	 * 
	 */
	public static synchronized BiNationregionService getInstance() {
		return (BiNationregionService) ApplicationContextUtils.getBean("biNationregionService");
	}
	
	/*
	 * 分页查询
	 * @param pageIndex pageSize
	 */
	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize,String hql) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		try {
			queryCondition.setQueryString(hql);
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);
			pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+"分页查询服务出错!");
		}
		return pageQueryResult;
	}
	/*
	 * 删除实体
	 * @param biNationregion
	 */
	public void removeEntity(BiNationregion biNationregion) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.delete(biNationregion);
			System.out.println(this.getClass().getName()+"已删除实体biNationregion");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+"删除biNationregion实体出错！ ");
		}
	}
	/*
	 * 插入实体
	 * @param biNationregion
	 */
	public void addEntity(BiNationregion biNationregion) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		if(isExists(biNationregion.getId())) {
			ExceptionUtil.throwCommonException("国家/地区代码重复", ErrorCode.ERROR_CODE_DUP_INSERT);
		}
		try {
			rootDAO.save(biNationregion);
			System.out.println(this.getClass().getName()+" 已插入或更新实体biNationregion");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入或更新实体biNationregion出错！ ");
		}
	}
	
	/*
	 * 
	 * 更新实体
	 * @param biNationregion
	 */
	public void modEntity(BiNationregion biNationregion) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.update(biNationregion);
			System.out.println(this.getClass().getName()+" 已插入或更新实体biNationregion");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入或更新实体biNationregion出错！ ");
			e.printStackTrace();
		}
	}
	/*
	 * 判断是否存在该实体
	 * @param id
	 */
	public boolean isExists(String id) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			BiNationregion bn = (BiNationregion) rootDAO.query(BiNationregion.class, id);
			if(bn == null) {
				return false;
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.out.println(this.getClass().getName()+"判断实体是否重复出错");
		}
		return true;
	}
	 //author  by  计翔 2012.9.5 序列化对象写入taskinfo表
	public void addTosystaskinfo(SysTaskInfo systackinfo){
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.saveOrUpdate(systackinfo);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得要操作的Item
	public Iterator selectByid(String id){
			
			
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		
			try {
			return	rootDAO.queryByQL("from BiNationregion biNationregion where biNationregion.id='"+id+"'");
				//return	rootDAO.queryBySQL("select * from sys_params  where PARAMGROUP_ID ='"+paramgroupid+"'  and PARAM_ID='"+paramid+"'" 
							//);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
				
			
			
		}
	 public BiNationregion  selectById(String id){
		  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		  BiNationregion  binationregion = null;
		  try {
			
			  binationregion=  (BiNationregion)rootdao.query(BiNationregion.class, id);
			 
			 	} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return binationregion;
	  }
	
}
