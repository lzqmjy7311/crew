package com.gbicc.company.warnDisposal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.warnDisposal.entity.UpLoadNums;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class UpLoadNumsService {
	public Map<String, String> getNums(String realId) {
		Map<String, String> result = new HashMap<String, String>();

		StringBuffer mailSql = new StringBuffer(
				" SELECT FD_RELA_ID AS REALID, "
				+ " COUNT(*) AS NUMS " 
				+ " FROM T_PUB_FILE_UPLOAD "
				+ "GROUP BY FD_RELA_ID ");
		StringBuffer sql=new StringBuffer(
				" SELECT REALID AS REALID, "
				+" NUMS AS NUMS "
				+" FROM ( ");
		sql.append(mailSql);
		sql.append(" ) ");
		if(StringUtils.hasText(realId)){
			sql.append(" WHERE REALID LIKE '"+realId+"'");
		}else{
			result.put("flag", "false");
			return result;
		}
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<UpLoadNums> list = jdbcTemplate.query(sql.toString(),
				BeanPropertyRowMapper.newInstance(UpLoadNums.class));
		if (list.size() > 0) {
			result.put("realId", list.get(0).getRealId());
			result.put("nums", list.get(0).getNums());
			result.put("flag", "true");
		} else {
			result.put("flag", "false");
		}
		return result;
	}
	
	public Map<String, String> getRuleNums(String realId,String relaType) {
		Map<String, String> result = new HashMap<String, String>();

		StringBuffer mailSql = new StringBuffer(
				" SELECT FD_RELA_ID AS REALID, "
				+ " COUNT(*) AS NUMS " 
				+ " FROM T_PUB_FILE_UPLOAD "
				+ " where FD_RELA_TYPE='"+relaType+"'" 
				+ " GROUP BY FD_RELA_ID ");
		StringBuffer sql=new StringBuffer(
				" SELECT REALID AS REALID, "
				+" NUMS AS NUMS "
				+" FROM ( ");
		sql.append(mailSql);
		sql.append(" ) ");
		if(StringUtils.hasText(realId)){
			sql.append(" WHERE REALID LIKE '"+realId+"'");
		}else{
			result.put("flag", "false");
			return result;
		}
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<UpLoadNums> list = jdbcTemplate.query(sql.toString(),
				BeanPropertyRowMapper.newInstance(UpLoadNums.class));
		if (list.size() > 0) {
			result.put("realId", list.get(0).getRealId());
			result.put("nums", list.get(0).getNums());
			result.put("flag", "true");
		} else {
			result.put("flag", "false");
		}
		return result;
	}
}
