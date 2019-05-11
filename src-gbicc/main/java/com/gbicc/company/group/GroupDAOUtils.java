package com.gbicc.company.group;

import java.util.List;

import org.springframework.util.StringUtils;

import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

public class GroupDAOUtils {
	public String getPartyId(String customerNum) throws CommonException {

//		StringBuffer select_sql = new StringBuffer("SELECT g.PARTY_ID  "
//				+ "FROM T_ODS_CMS_CREDIT_GROUP G  " + "WHERE "
//				+ "G.BPK_CUSTOMER_CD LIKE '" + customerNum + "'");
		StringBuffer hql=new StringBuffer(
				"from TOdsCmsCreditGroup where 1=1 ");
		if(StringUtils.hasText(customerNum)){
			hql.append("and bpkCustomerCd = '"+customerNum+"'");
		}else{
			return null;
		}
		// String hql="FROM TOdsCmsCreditGroup G  "
		// + "WHERE "
		// + "G.BPK_CUSTOMER_CD LIKE '"
		// + customerNum
		// + "'";
		//
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<TOdsCmsCreditGroup> group = rootdao.queryListHQL(hql.toString());
		if(group.size()>0){
			return group.get(0).getPartyId();
		}
//		if (null != group && null!= group.next()) {
//			return group.next();
//		}
		return null;
	}

}
