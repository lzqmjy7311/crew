package com.gbicc.person.great.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.great.entity.TPlGreatEvent;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TPlGreatEventGetter extends BaseGetter {
	
	/**
	 * 客户重大事件内容数据字典编号
	 */
	public static final Integer CUST_GREAT_EVENT_DIC=118;
	/**
	 * 法人客户重大事件内容数据字典编号
	 */
	public static final Integer CUST2_GREAT_EVENT_DIC=126;
	/**
	 * 合作方重大事件内容数据字典编号
	 */
	public static final Integer PROJ_GREAT_EVENT_DIC=119;

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings({ "rawtypes"})
	protected PageQueryResult getData() throws Exception {
		String regiDateStart = (String) getCommQueryServletRequest().getParameterMap().get("regiDateStart");
		String regiDateEnd = (String) getCommQueryServletRequest().getParameterMap().get("regiDateEnd");
		String atteMain = (String) getCommQueryServletRequest().getParameterMap().get("atteMain");
		String explain = (String) getCommQueryServletRequest().getParameterMap().get("explain");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//CommonService service=CommonService.getInstance();
		StringBuffer hql = new StringBuffer("from TPlGreatEvent t where 1=1 ");
		if(StringUtils.isNotEmpty(regiDateStart)){
			hql.append(" and regiDate>=to_date('"+regiDateStart+"','YYYY-MM-DD') ");
		}
		if(StringUtils.isNotEmpty(regiDateStart)){
			hql.append(" and regiDate<to_date('"+regiDateEnd+"','YYYY-MM-DD') ");
		}
		if(StringUtils.isNotEmpty(atteMain)){
			hql.append(" and atteMain='"+atteMain+"' ");
		}
		if(StringUtils.isNotEmpty(explain)){
			hql.append(" and explain like '%"+explain+"%' ");
		}
		hql.append(" and regiUser.tlrno='").append(GlobalInfo
				.getCurrentInstance().getTlrno()).append("'");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		List list=pageQueryResult.getQueryResult();
		for(int i=0;i<list.size();i++){
			TPlGreatEvent ge=(TPlGreatEvent) list.get(i);
			if(ge.getAtteMain().equals(SubAutoGreatEventGetter.ZRR_DTL_DIC)){
//				List<TEdwPlsCust> custs=service.findSqlListBySpringJdbc("select * from t_edw_pls_cust where custid='"+ge.getMainObj()+"' ",TEdwPlsCust.class);
//				if(null!=custs && custs.size()>0){
//					ge.setMainObjName(custs.get(0).getCustname());
//				}
				String name=DataDicService.getInstance().getNameByTypeNo(CUST_GREAT_EVENT_DIC,ge.getContent());
				ge.setContentDesc(name);
			}else if(ge.getAtteMain().equals(SubAutoGreatEventGetter.FR_DTL_DIC)){
//				List<TEdwPlsLegalPerson> legals=service.findSqlListBySpringJdbc("select * from t_edw_pls_legal_person where custid='"+ge.getMainObj()+"' ",TEdwPlsLegalPerson.class);
//				if(null!=legals && legals.size()>0){
//					ge.setMainObjName(legals.get(0).getCustname());
//				}
				String name=DataDicService.getInstance().getNameByTypeNo(CUST2_GREAT_EVENT_DIC,ge.getContent());
				ge.setContentDesc(name);
			}else if(ge.getAtteMain().equals(SubAutoGreatEventGetter.HZF_DTL_DIC)){
//				List<TEdwPlsBuilding> bulidings=service.findSqlListBySpringJdbc("select * from t_edw_pls_building where projid='"+ge.getMainObj()+"' ",TEdwPlsBuilding.class);
//				if(null!=bulidings && bulidings.size()>0){
//					ge.setMainObjName(bulidings.get(0).getCorpname());
//				}
				String name=DataDicService.getInstance().getNameByTypeNo(PROJ_GREAT_EVENT_DIC,ge.getContent());
				ge.setContentDesc(name);
			}
		}
		return pageQueryResult;
	}
}
