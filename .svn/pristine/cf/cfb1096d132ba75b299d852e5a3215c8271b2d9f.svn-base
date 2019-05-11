package com.huateng.ebank.business.rolemng.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.data.mng.FunctionInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class RoleFuncTreeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List<TreeNode> li = null;
		try {
			li = this.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		genTreeHTML(li);
		ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), li, getResult());
		getResult().setContent(li);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

	private List<TreeNode> getAll() throws CommonException, IllegalAccessException, InvocationTargetException {
		String pid = this.commQueryServletRequest.getParameter("_id");
		if(StringUtils.isNotBlank(pid) || StringUtils.equals("0", pid)){
			return new ArrayList<TreeNode>();
		}
		String roleId = this.commQueryServletRequest.getParameter("id");
		String mode = this.commQueryServletRequest.getParameter("mode");
		List<TreeNode> re = null;
		Map<String, TreeNode> li = new HashMap<String, TreeNode>();
		Map<String, List<TreeNode>> map = new HashMap<String, List<TreeNode>>();
		String str = "from FunctionInfo func where 1=1";
		if (StringUtils.isNotBlank(mode)) {
			str += " and func.location=" + mode;
		}
		List<FunctionInfo> tmp = BaseDAOUtils.getHQLDAO().queryByQL2List(str);
		for (FunctionInfo foo : tmp) {
			TreeNode bar = this.convert2Node(foo);
			li.put(bar.getId(), bar);
			if (!map.containsKey(bar.getPid())) {
				map.put(bar.getPid(), new ArrayList<TreeNode>());
			}
			map.get(bar.getPid()).add(bar);
		}
		if (StringUtils.isNotBlank(roleId)) {
			List<String> arr = this.getRoleFuncByid(roleId);
			for (String foo : arr) {
				li.get(foo).setChecked(true);
			}
		}
//		for (TreeNode node : li.values()) {
//			if (map.containsKey(node.getId())) {
//				node.getChildren().addAll(map.get(node.getId()));
//			}
//			//对目录的处理
////			if(node.isHasChild() && node.getChildren().size()>0){
////				node.setChecked(false);
////			}
//			// node.setHasChild(node.getChildren().size() > 0);
//		}
		re = new ArrayList<TreeNode>(li.values());
		return re;
	}

	private RoleFuncTreeNode convert2Node(FunctionInfo fi) throws IllegalAccessException, InvocationTargetException {
		RoleFuncTreeNode result = new RoleFuncTreeNode(fi);
		return result;
	}

	private List<String> getRoleFuncByid(String roleId) throws CommonException {
		// and funInfo.isdirectory=0"
		String str = "select trim(funInfo.id) from FunctionInfo funInfo,RoleFuncRel rolefun where funInfo.id= rolefun.funcid"
				+ " and rolefun.roleId = " + roleId;
		List<String> list = BaseDAOUtils.getHQLDAO().queryByQL2List(str);
		return list;
	}

}
