package com.huateng.ebank.business.approve.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/*
 * 系统参数service
 *
 */
public class SysParamsService {
	private static final HtLog htlog = HtLogFactory
	.getLogger(SysParamsService.class);
	/*
	 * 获得自身的实例
	 *
	 */
	public static synchronized SysParamsService getInstance() {
		return (SysParamsService) ApplicationContextUtils.getBean("sysParamsService");
	}



/*
 *
 * 查询某条需要修改的ITEM
 */
	public Iterator selectByid(String paramgroupid,String paramid){


		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();

		try {
		return	rootDAO.queryByQL("from SysParams sysParams where sysParams.id.paramgroupId='"+paramgroupid+"'and sysParams.id.paramId='"+paramid+"'");
			//return	rootDAO.queryBySQL("select * from sys_params  where PARAMGROUP_ID ='"+paramgroupid+"'  and PARAM_ID='"+paramid+"'"
						//);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * 对象序列化后写入taskinfo auto by 计翔
	 * */
	public void addTosystaskinfo(SysTaskInfo systackinfo){
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.saveOrUpdate(systackinfo);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


   /*获取安全参数操作对象
	 public PfSysParam  selectId(PfSysParamPK id){
		  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		  PfSysParam  pfsysparam = null;
		  try {

			  pfsysparam= (PfSysParam)rootdao.query(PfSysParam.class, id);

			 	} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pfsysparam;
	  }

	  */
	 public Iterator selectID(String magicId,String paramId){
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			try {
			return	rootDAO.queryByQL("from PfSysParam pfsysparam where pfsysparam.id.magicId='"+magicId+"'and pfsysparam.id.paramId='"+paramId+"'");
			} catch (CommonException e) {

				e.printStackTrace();
				return null;
			}
		}
	 /**
		 * @Description 安全参数查询
		 * @return
		 * @throws CommonException
		 * @throws IllegalAccessException
		 * @throws InvocationTargetException
		 */
		public PageQueryResult querySysParam(int pageIndex, int pageSize, String qst)
				throws CommonException {
			StringBuffer sb = new StringBuffer("");
			sb.append(" FROM PfSysParam where 1=1");

			Object[] parameters = null;
			if(StringUtils.isNotBlank(qst)){
				sb.append(" AND st = ? ");
				parameters = new Object[]{qst};
			}

			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			PageQueryCondition queryCondition = new PageQueryCondition();
			queryCondition.setQueryString(sb.toString());
			if(null != parameters) {
				queryCondition.setObjArray(parameters);
			}

			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);

			PageQueryResult pageQueryResult = rootdao.pageQueryByQL(queryCondition);
			return pageQueryResult;
		}

		/**
		 *
		 * @desc 安全参数修改
		 * @param insertList
		 * @param delList
		 * @param updateList
		 * @throws CommonException
		 */
		public void saveSecParam(PfSysParam param) throws CommonException {

			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

			PfSysParam sysparam = (PfSysParam) rootdao.query(PfSysParam.class,
					param.getId());
			sysparam.setParamValueTx(param.getParamValueTx());
			rootdao.update(sysparam);
			GlobalInfo.getCurrentInstance().addBizLog("Updater.log",
					new String[] { gi.getTlrno(), gi.getBrno(), "修改安全参数" });
			htlog.info("Updater.log", new String[] { gi.getTlrno(), gi.getBrno(),
					"修改安全参数" });

		}
		public void savePfParam(PfSysParam param){
			ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
			try {
				rootdao.saveOrUpdate(param);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
