package com.gbicc.bpm.service;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.entity.TLoanAccountDutyDistribute;
import com.gbicc.bpm.operation.TLoanAccountDutyDistributeOperation;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TLoanAccountDutyDistributeService {
	public TLoanAccountDutyDistributeService() {
	}

	public synchronized static TLoanAccountDutyDistributeService getInstance() {
		return (TLoanAccountDutyDistributeService) ApplicationContextUtils
				.getBean(TLoanAccountDutyDistributeService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TLoanAccountDutyDistribute get(String id) throws CommonException{
		return dao().query(TLoanAccountDutyDistribute.class, id);
	}
	
	public void save(TLoanAccountDutyDistribute tloanaccountdutydistribute) throws CommonException{
		dao().save(tloanaccountdutydistribute);
	}
	
	public void update(TLoanAccountDutyDistribute tloanaccountdutydistribute) throws CommonException{
		dao().update(tloanaccountdutydistribute);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
	
	/**
	 * 查找运行中流程是否有分派任务
	 * @param businessId
	 * @return
	 * @throws CommonException 
	 */
	@SuppressWarnings("rawtypes")
	public String dwrFindDistributeRuningProcess(String loanacno,String distType) throws CommonException{
		List list=TLoanAccountDutyDistributeService.getInstance().dao().queryByCondition("from TLoanAccountDutyDistribute where (loanacno='"+loanacno+"' or id in (select distId from TLoanAccountRelDistribute where loanacno='"+loanacno+"')) and status='"+TLoanAccountDutyDistributeOperation.STATUS_APL_ING+"' and distType='"+distType+"' ");
		String bool="false";
		if(null!=list && list.size()>0){
			for(int i=0;i<list.size();i++){
				TLoanAccountDutyDistribute dist=(TLoanAccountDutyDistribute) list.get(i);
				bool=ProcessManagerService.getInstace().findRuningTaskByBusinessKey(dist.getId());
				if(bool.equals("true")){
					break;
				}
			}
		}
		return bool;
	}
	
	/**
	 * 根据机构号得到所有贷款帐号
	 * @param orgId
	 * @return
	 * @throws CommonException 
	 */
	public String[] dwrGetLoanAccountNos(String orgId,String condition,String type) throws CommonException{
		String runingProcessActnos=getRuningProcessActnos(condition,orgId,type);
		Integer count=getCanDistCount(condition,orgId,type);
		return new String[]{runingProcessActnos,count.toString()};
	}
	
	/**
	 * 全部分派获取在流程中的贷款账号
	 * @return
	 * @throws CommonException 
	 */
	@SuppressWarnings("rawtypes")
	public String getRuningProcessActnos(String condition,String bankid,String type) throws CommonException{
		String sql="";
		if(type.equals(TLoanAccountDutyDistributeOperation.DIST_TYPE_DUTY)){
			sql="SELECT LOANACNO FROM (SELECT A.LOANACNO,A.PRODNAME,A.CUSTNAME,A.ACFLAG,A.ACFLAG2,A.RISKFLAG,"+
			"CASE WHEN RD.FD_DUTYID IS NOT NULL THEN RD.FD_DUTYID "+
			"WHEN A.DUTYID IS NOT NULL THEN A.DUTYID "+
			"ELSE NULL END AS DUTYID FROM T_PL_ACCOUNT_DUTY_DISTRIBUTE D "+
			"JOIN T_EDW_PLS_ACCOUNT A ON D.FD_LOANACNO=A.LOANACNO "+
			"LEFT JOIN T_PL_ACCOUNT_REL_DUTY RD ON A.LOANACNO=RD.FD_LOANACNO "+
			"JOIN ACT_RU_EXECUTION E ON D.FD_ID=E.BUSINESS_KEY_ "+
			"WHERE A.PAYOFFFLAG='00' AND A.PRODID NOT IN ('93010200','96010200','96010100','93010100') "+
			"AND A.BANKID='"+bankid+"' AND D.FD_STATUS='"+TLoanAccountDutyDistributeOperation.STATUS_APL_ING+"' AND FD_DIST_TYPE='"+type+"' AND E.BUSINESS_KEY_ IS NOT NULL "+
			"UNION "+
			"SELECT A.LOANACNO,A.PRODNAME,A.CUSTNAME,A.ACFLAG,A.ACFLAG2,A.RISKFLAG,"+
			"CASE WHEN RD.FD_DUTYID IS NOT NULL THEN RD.FD_DUTYID "+
			"WHEN A.DUTYID IS NOT NULL THEN A.DUTYID "+
			"ELSE NULL END AS DUTYID FROM T_PL_ACCOUNT_REL_DISTRIBUTE R "+
			"JOIN T_PL_ACCOUNT_DUTY_DISTRIBUTE D ON R.FD_DIST_ID=D.FD_ID "+
			"JOIN T_EDW_PLS_ACCOUNT A ON R.FD_LOANACNO=A.LOANACNO "+
			"LEFT JOIN T_PL_ACCOUNT_REL_DUTY RD ON A.LOANACNO=RD.FD_LOANACNO "+
			"JOIN ACT_RU_EXECUTION E ON D.FD_ID=E.BUSINESS_KEY_ "+
			"WHERE A.PAYOFFFLAG='00' AND A.PRODID NOT IN ('93010200','96010200','96010100','93010100') "+
			"AND A.BANKID='"+bankid+"' AND D.FD_STATUS='"+TLoanAccountDutyDistributeOperation.STATUS_APL_ING+"' AND FD_DIST_TYPE='"+type+"' AND E.BUSINESS_KEY_ IS NOT NULL) T WHERE 1=1";
		}else{
			sql="SELECT LOANACNO FROM (SELECT A.LOANACNO,A.PRODNAME,A.CUSTNAME,A.ACFLAG,A.ACFLAG2,A.RISKFLAG,"+
			"CASE WHEN RD.FD_COLLID IS NOT NULL THEN RD.FD_COLLID "+
			"WHEN A.DUTYID2 IS NOT NULL THEN A.DUTYID2 "+
			"ELSE NULL END AS DUTYID FROM T_PL_ACCOUNT_DUTY_DISTRIBUTE D "+
			"JOIN T_EDW_PLS_ACCOUNT A ON D.FD_LOANACNO=A.LOANACNO "+
			"LEFT JOIN T_PL_ACCOUNT_REL_DUTY RD ON A.LOANACNO=RD.FD_LOANACNO "+
			"JOIN ACT_RU_EXECUTION E ON D.FD_ID=E.BUSINESS_KEY_ "+
			"WHERE A.PAYOFFFLAG='00' AND A.PRODID NOT IN ('93010200','96010200','96010100','93010100') "+
			"AND A.BANKID='"+bankid+"' AND D.FD_STATUS='"+TLoanAccountDutyDistributeOperation.STATUS_APL_ING+"' AND FD_DIST_TYPE='"+type+"' AND E.BUSINESS_KEY_ IS NOT NULL "+
			"UNION "+
			"SELECT A.LOANACNO,A.PRODNAME,A.CUSTNAME,A.ACFLAG,A.ACFLAG2,A.RISKFLAG,"+
			"CASE WHEN RD.FD_COLLID IS NOT NULL THEN RD.FD_COLLID "+
			"WHEN A.DUTYID2 IS NOT NULL THEN A.DUTYID2 "+
			"ELSE NULL END AS DUTYID FROM T_PL_ACCOUNT_REL_DISTRIBUTE R "+
			"JOIN T_PL_ACCOUNT_DUTY_DISTRIBUTE D ON R.FD_DIST_ID=D.FD_ID "+
			"JOIN T_EDW_PLS_ACCOUNT A ON R.FD_LOANACNO=A.LOANACNO "+
			"LEFT JOIN T_PL_ACCOUNT_REL_DUTY RD ON A.LOANACNO=RD.FD_LOANACNO "+
			"JOIN ACT_RU_EXECUTION E ON D.FD_ID=E.BUSINESS_KEY_ "+
			"WHERE A.PAYOFFFLAG='00' AND A.PRODID NOT IN ('93010200','96010200','96010100','93010100') "+
			"AND A.BANKID='"+bankid+"' AND D.FD_STATUS='"+TLoanAccountDutyDistributeOperation.STATUS_APL_ING+"' AND FD_DIST_TYPE='"+type+"' AND E.BUSINESS_KEY_ IS NOT NULL) T WHERE 1=1";
		}
		if(StringUtils.isNotEmpty(condition)){
			JSONObject json=JSONObject.fromObject(condition);
			if(json.get("acctNo")!=null && StringUtils.isNotEmpty(json.getString("acctNo"))){
				sql+=" and loanacno='"+json.getString("acctNo")+"' ";
			}
			if(json.get("prodname")!=null && StringUtils.isNotEmpty(json.getString("prodname"))){
				sql+=" and prodname like '%"+json.getString("prodname")+"%' ";
			}
			if(json.get("custname")!=null && StringUtils.isNotEmpty(json.getString("custname"))){
				sql+=" and custname like '%"+json.getString("custname")+"%' ";
			}
			if(json.get("acflag")!=null && StringUtils.isNotEmpty(json.getString("acflag"))){
				sql+=" and acflag='"+json.getString("acflag")+"' ";
			}
			if(json.get("acflag2")!=null && StringUtils.isNotEmpty(json.getString("acflag2"))){
				sql+=" and acflag2='"+json.getString("acflag2")+"' ";
			}
			if(json.get("riskflag")!=null && StringUtils.isNotEmpty(json.getString("riskflag"))){
				sql+=" and riskflag='"+json.getString("riskflag")+"' ";
			}
			if(json.get("dutyid")!=null && StringUtils.isNotEmpty(json.getString("dutyid"))){
				sql+=" and DUTYID='"+json.getString("dutyid")+"' ";
			}
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it=rootdao.queryBySQL(sql);
		String loanacnos="";
		//本来是使用while条件拼接的，全部分派时若数量过大，页面就会卡死。
		if(it.hasNext()){
			String str=(String) it.next();
			if(str!=null && !(str.equals(""))){
				loanacnos=loanacnos+str+",";
			}
		}
		if(!loanacnos.equals("")){
			loanacnos.substring(0,loanacnos.length()-1);
		}
		return loanacnos;
	}
	
	/**
	 * 根据机构获取可转移的账户数
	 * @param condition
	 * @param bankid
	 * @return
	 * @throws CommonException 
	 */
	@SuppressWarnings("rawtypes")
	public Integer getCanDistCount(String condition,String bankid,String type) throws CommonException{
		String sql="SELECT COUNT(LOANACNO) FROM T_EDW_PLS_ACCOUNT A LEFT JOIN T_PL_ACCOUNT_REL_DUTY D ON A.LOANACNO=D.FD_LOANACNO "+
		"WHERE LOANACNO NOT IN (SELECT T.LOANACNO FROM (SELECT A.LOANACNO "+
		"FROM T_PL_ACCOUNT_DUTY_DISTRIBUTE D "+
		"JOIN T_EDW_PLS_ACCOUNT A ON D.FD_LOANACNO=A.LOANACNO "+
		"LEFT JOIN T_PL_ACCOUNT_REL_DUTY RD ON A.LOANACNO=RD.FD_LOANACNO "+
		"JOIN ACT_RU_EXECUTION E ON D.FD_ID=E.BUSINESS_KEY_ "+
		"WHERE A.PAYOFFFLAG='00' AND A.PRODID NOT IN ('93010200','96010200','96010100','93010100') "+
		"AND A.BANKID='"+bankid+"' AND D.FD_STATUS!='"+TLoanAccountDutyDistributeOperation.STATUS_APL_PASS+"' AND FD_DIST_TYPE='"+type+"' AND E.BUSINESS_KEY_ IS NOT NULL "+
		"UNION "+
		"SELECT A.LOANACNO FROM T_PL_ACCOUNT_REL_DISTRIBUTE R "+
		"JOIN T_PL_ACCOUNT_DUTY_DISTRIBUTE D ON R.FD_DIST_ID=D.FD_ID "+
		"JOIN T_EDW_PLS_ACCOUNT A ON R.FD_LOANACNO=A.LOANACNO "+
		"LEFT JOIN T_PL_ACCOUNT_REL_DUTY RD ON A.LOANACNO=RD.FD_LOANACNO "+
		"JOIN ACT_RU_EXECUTION E ON D.FD_ID=E.BUSINESS_KEY_ "+
		"WHERE A.PAYOFFFLAG='00' AND A.PRODID NOT IN ('93010200','96010200','96010100','93010100') "+
		"AND A.BANKID='"+bankid+"' AND D.FD_STATUS!='"+TLoanAccountDutyDistributeOperation.STATUS_APL_PASS+"' AND FD_DIST_TYPE='"+type+"' AND E.BUSINESS_KEY_ IS NOT NULL) T)"+
		"AND A.PAYOFFFLAG='00' "+
		"AND A.PRODID NOT IN ('93010200','96010200','96010100','93010100') AND A.BANKID='"+bankid+"' ";
		if(StringUtils.isNotEmpty(condition)){
			JSONObject json=JSONObject.fromObject(condition);
			if(json.get("acctNo")!=null && StringUtils.isNotEmpty(json.getString("acctNo"))){
				sql+=" and a.loanacno='"+json.getString("acctNo")+"' ";
			}
			if(json.get("prodname")!=null && StringUtils.isNotEmpty(json.getString("prodname"))){
				sql+=" and a.prodname like '%"+json.getString("prodname")+"%' ";
			}
			if(json.get("custname")!=null && StringUtils.isNotEmpty(json.getString("custname"))){
				sql+=" and a.custname like '%"+json.getString("custname")+"%' ";
			}
			if(json.get("acflag")!=null && StringUtils.isNotEmpty(json.getString("acflag"))){
				sql+=" and a.acflag='"+json.getString("acflag")+"' ";
			}
			if(json.get("acflag2")!=null && StringUtils.isNotEmpty(json.getString("acflag2"))){
				sql+=" and a.acflag2='"+json.getString("acflag2")+"' ";
			}
			if(json.get("riskflag")!=null && StringUtils.isNotEmpty(json.getString("riskflag"))){
				sql+=" and a.riskflag='"+json.getString("riskflag")+"' ";
			}
			if(json.get("dutyid")!=null && StringUtils.isNotEmpty(json.getString("dutyid"))){
				if(type.equals(TLoanAccountDutyDistributeOperation.DIST_TYPE_DUTY)){
					sql+=" and (CASE WHEN D.FD_DUTYID IS NOT NULL THEN D.FD_DUTYID ELSE A.DUTYID END)='"+json.getString("dutyid")+"' ";
				}else{
					sql+=" and (CASE WHEN D.FD_COLLID IS NOT NULL THEN D.FD_COLLID ELSE A.DUTYID2 END)='"+json.getString("dutyid")+"' ";
				}
			}
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it= rootdao.queryBySQL(sql);
		Integer count=0;
		if(it.hasNext()){
			count=(Integer) it.next();
		}
		return count;
	}
}
