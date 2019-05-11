package com.huateng.ebank.business.rolemng.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.data.mng.FunctionInfo;

public final class RoleFuncTreeNode extends TreeNode implements Comparable<RoleFuncTreeNode> {

	String pagepath;

	String location = "2";

	String desc;

	String status;

	String isdirectory;

	String showseq;
	
	String funcType;
	
	String upFuncCode;
	
	String funcClass;

	public RoleFuncTreeNode() {
	}

	public RoleFuncTreeNode(FunctionInfo fi) {
		this.showseq = fi.getShowseq() == null ? "" : String.valueOf(fi.getShowseq());
		this.pagepath = fi.getPagepath();
		this.setId(fi.getId());
		this.setCanSelected(true);
		this.setIconCls(fi.getIconCls());
		this.setText(fi.getFuncname());
		this.setPid(String.valueOf(fi.getLastdirectory()));
		this.setHasChild(fi.getIsdirectory() == 1);
		this.setLocation(String.valueOf(fi.getLocation()));
		this.setDesc(fi.getFuncDesc());
		this.setStatus(fi.getStatus());
		this.setIsdirectory(String.valueOf(fi.getIsdirectory()));
		this.setFuncType(fi.getFuncType());
		this.setUpFuncCode(fi.getUpFuncCode());
		this.setFuncClass(fi.getFuncClass());
	}

	
	
	public String getFuncClass() {
		return funcClass;
	}

	public void setFuncClass(String funcClass) {
		this.funcClass = funcClass;
	}

	public String getIsdirectory() {
		return isdirectory;
	}

	public String getShowseq() {
		return showseq;
	}

	public void setShowseq(String showseq) {
		this.showseq = showseq;
	}

	public void setIsdirectory(String isdirectory) {
		this.isdirectory = isdirectory;
	}

	public FunctionInfo toFunctionInfo() {
		FunctionInfo re = new FunctionInfo();
		re.setId(this.getId());
		re.setIconCls(this.getIconCls());
		re.setFuncname(this.getText());
		if (StringUtils.isNotBlank(this.getPid())) {
			re.setLastdirectory(this.getPid());
		}
		re.setPagepath(this.pagepath);
		if (StringUtils.isNotBlank(this.location) && StringUtils.isNumeric(this.location)) {
			re.setLocation(Integer.valueOf(this.location));
		}
		re.setFuncDesc(this.getDesc());
		re.setStatus(this.getStatus());
		re.setIsdirectory(Integer.valueOf(this.getIsdirectory()));
		re.setShowseq(StringUtils.isNotBlank(this.getShowseq()) ? Integer.valueOf(this.getShowseq()) : null);
		re.setFuncType(this.getFuncType());
		re.setUpFuncCode(this.getUpFuncCode());
		re.setFuncClass(this.getFuncClass());
		return re;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getFuncType() {
		return funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getUpFuncCode() {
		return upFuncCode;
	}

	public void setUpFuncCode(String upFuncCode) {
		this.upFuncCode = upFuncCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int compareTo(RoleFuncTreeNode o) {
		if (StringUtils.isBlank(this.getShowseq()) && StringUtils.isBlank(o.getShowseq())) {
			return 0;
		} else if (StringUtils.isBlank(this.getShowseq())) {
			return 1;
		} else if (StringUtils.isBlank(o.getShowseq())) {
			return -1;
		}
		int v1 = Integer.valueOf(this.showseq);
		int v2 = Integer.valueOf(o.getShowseq());
		if (v1 > v2) {
			return 1;
		} else if (v1 < v2) {
			return -1;
		}
		return 0;
	}

}