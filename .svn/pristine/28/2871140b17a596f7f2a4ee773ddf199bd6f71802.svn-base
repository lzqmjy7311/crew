package com.gbicc.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gbicc.company.view.entity.TCmCodeIndustryNew;
import com.gbicc.person.product.entity.Product;
import com.huateng.commquery.config.bean.base.ICommonQueryBaseBean;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.exception.HuatengException;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class CQMethod {

	public static String getProcuctNameByProductCode(
			ICommonQueryBaseBean element, String value, ServletRequest request)
			throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List l = rootdao.queryByQL2List("from Product p where  p.prodCode = '"
				+ value + "'");
		if ((l == null) || (l.isEmpty())) {
			return "";
		}
		Product product = (Product) l.get(0);
		return product.getProdName();
	}
	
	public static String getBrhName(
			ICommonQueryBaseBean element, String value, ServletRequest request)
			throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		String sql="select l1.BRNAME from TLR_BCTL_REL l left join bctl l1 on l.BR_NO=l1.BRNO where l.TLR_NO='"+value+"'";
		List<Map<String,Object>> list=com.gbicc.common.CommonService
		.getInstance().getJdbcTempldate().queryForList(sql.toString());
		Iterator<Map<String,Object>> it=list.iterator();
		StringBuffer sb=new StringBuffer("");
		while(it.hasNext()){
			String temp=(String)it.next().get("BRNAME");
			sb.append(temp+"<br>");
		}

		return sb.toString();
	}
	/**
	 * 根据机构编号获取名称
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getOrgNameByCode(
			ICommonQueryBaseBean element, String value, ServletRequest request)
					throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List l = rootdao.queryByQL2List("from Bctl p where  p.brno = '"
				+ value + "'");
		if ((l == null) || (l.isEmpty())) {
			return value;
		}
		Bctl bctl = (Bctl) l.get(0);
		return bctl.getBrname()+"("+value+")";
	}
	/**
	 * 根据用户编号获取名称
	 * @param element
	 * @param value
	 * @param request
	 * @return
	 * @throws HuatengException
	 */
	public static String getUserNameByCode(
			ICommonQueryBaseBean element, String value, ServletRequest request)
					throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List l = rootdao.queryByQL2List("from TlrInfo p where  p.tlrno = '"
				+ value + "'");
		if ((l == null) || (l.isEmpty())) {
			return value;
		}
		TlrInfo tlrInfo = (TlrInfo) l.get(0);
		return tlrInfo.getTlrName()+"("+value+")";
	}

	public static String getindustryLevelTwoCdBytypeCd(
			ICommonQueryBaseBean element, String value, ServletRequest request)
			throws HuatengException {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List l = rootdao
				.queryByQL2List("from TCmCodeIndustryNew p where  p.typeCd = '"
						+ value + "'");
		if ((l == null) || (l.isEmpty())) {
			return "";
		}
		TCmCodeIndustryNew tCmCodeIndustryNew = (TCmCodeIndustryNew) l.get(0);
		return tCmCodeIndustryNew.getTypeValue();
	}

	public static String getDateString(String date) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(date.charAt(0));
		buffer.append(date.charAt(1));
		buffer.append(date.charAt(2));
		buffer.append(date.charAt(3));
		buffer.append('-');
		buffer.append(date.charAt(4));
		buffer.append(date.charAt(5));
		buffer.append('-');
		buffer.append(date.charAt(6));
		buffer.append(date.charAt(7));
		String changDate = buffer.toString();
		return changDate;
	}
}