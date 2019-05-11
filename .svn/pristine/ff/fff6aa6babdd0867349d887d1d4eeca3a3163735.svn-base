//package com.huateng.ebank.business.rolemng.getter;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang.StringUtils;
//
//import com.huateng.commquery.result.Result;
//import com.huateng.ebank.business.common.BaseDAOUtils;
//import com.huateng.ebank.business.common.bean.TreeNode;
//import com.huateng.ebank.entity.data.mng.FunctionInfo;
//import com.huateng.ebank.framework.exceptions.CommonException;
//import com.huateng.ebank.framework.web.commQuery.BaseGetter;
//import com.huateng.exception.AppException;
//
///**
// * 后台静态生成HTML的方式
// * @author zhao_zhiguo
// *
// */
//@SuppressWarnings("unchecked")
//public class RoleFuncTree2Getter extends BaseGetter {
//
//	@Override
//	public Result call() throws AppException {
//		List<TreeNode> li = null;
//		try {
//			li = this.getAll();
//			li = buildTree(li);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		result.setParameter("treeHTML", TreeNode.toHTML(li));
//		result.init();
//		return result;
//	}
//	/**
//	 * 将一个集合转化成树
//	 * @param nodes
//	 * @return
//	 */
//	public List<TreeNode> buildTree(List<TreeNode> nodes) {
//		List<TreeNode> roots = new ArrayList<TreeNode>();
//		Map<String, TreeNode> map = new HashMap<String, TreeNode>();
//		for (TreeNode node : nodes) {
//			map.put(node.getId(), node);
//		}
//		for (TreeNode node : nodes) {
//			String pid = node.getPid();
//			TreeNode parent = map.get(pid);
//			if (parent != null) {
//				parent.addChild(node);
//			} else {
//				roots.add(node);
//			}
//		}
//		return roots;
//	}
//	private List<TreeNode> getAll() throws CommonException, IllegalAccessException, InvocationTargetException {
//		String pid = this.commQueryServletRequest.getParameter("_id");
//		if(StringUtils.isNotBlank(pid) || StringUtils.equals("0", pid)){
//			return new ArrayList<TreeNode>();
//		}
//		String roleId = this.commQueryServletRequest.getParameter("id");
//		String mode = this.commQueryServletRequest.getParameter("mode");
//		List<TreeNode> re = null;
//		Map<String, TreeNode> li = new HashMap<String, TreeNode>();
//		Map<String, List<TreeNode>> map = new HashMap<String, List<TreeNode>>();
//		String str = "from FunctionInfo func where 1=1";
//		if (StringUtils.isNotBlank(mode)) {
//			str += " and func.location=" + mode;
//		}
//		List<FunctionInfo> tmp = BaseDAOUtils.getHQLDAO().queryByQL2List(str);
//		for (FunctionInfo foo : tmp) {
//			TreeNode bar = this.convert2Node(foo);
//			li.put(bar.getId(), bar);
//			if (!map.containsKey(bar.getPid())) {
//				map.put(bar.getPid(), new ArrayList<TreeNode>());
//			}
//			map.get(bar.getPid()).add(bar);
//		}
//		if (StringUtils.isNotBlank(roleId)) {
//			List<String> arr = this.getRoleFuncByid(roleId);
//			for (String foo : arr) {
//				li.get(foo).setChecked(true);
//			}
//		}
//		re = new ArrayList<TreeNode>(li.values());
//		return re;
//	}
//
//	private RoleFuncTreeNode convert2Node(FunctionInfo fi) throws IllegalAccessException, InvocationTargetException {
//		RoleFuncTreeNode result = new RoleFuncTreeNode(fi);
//		return result;
//	}
//
//	private List<String> getRoleFuncByid(String roleId) throws CommonException {
//		// and funInfo.isdirectory=0"
//		String str = "select trim(funInfo.id) from FunctionInfo funInfo,RoleFuncRel rolefun where funInfo.id= rolefun.funcid"
//				+ " and rolefun.roleId = " + roleId;
//		List<String> list = BaseDAOUtils.getHQLDAO().queryByQL2List(str);
//		return list;
//	}
//
//}
