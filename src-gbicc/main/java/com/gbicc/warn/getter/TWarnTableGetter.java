package com.gbicc.warn.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import net.sf.json.JSONArray;

import com.gbicc.common.CommonService;

public class TWarnTableGetter {

	@SuppressWarnings("rawtypes")
	public static List get(String loadAccount, String ruleId, String createDate) {

		StringBuffer hql = new StringBuffer(
				"select * from T_PL_TASK_RULE_TRIG_REL_DETAIL where FD_ACC_ID='"
						+ loadAccount + "'");

		if (StringUtils.hasText(ruleId)) {
			hql.append(" and FD_RULE_ID='" + ruleId + "'");
		}

		if (StringUtils.hasText(createDate)) {

			hql.append(" and FD_TRIG_DATE='" + createDate + "'");
		}

		List<Map<String, Object>> list = CommonService.getInstance()
				.getJdbcTempldate().queryForList(hql.toString());

		List<Object> listAll = new ArrayList<Object>();
		List<String> head = new ArrayList<String>();

		for (Map<String, Object> map : list) {
			JSONArray jsonArrayHeader = JSONArray.fromObject(map
					.get("FD_RELHEADER"));
			Iterator it=jsonArrayHeader.iterator();
			while(it.hasNext()){
				head.add((String) it.next());
			}
			break;
		}

		listAll.add(head);

		for (Map<String, Object> map : list) {
			List<String> content = new ArrayList<String>();
			JSONArray jsonArrayBody = JSONArray.fromObject(map
					.get("FD_RELDATA"));
			Iterator it=jsonArrayBody.iterator();
			while(it.hasNext()){
				content.add((String) it.next());
			}
			listAll.add(content);
		}

		return listAll;

	}
}