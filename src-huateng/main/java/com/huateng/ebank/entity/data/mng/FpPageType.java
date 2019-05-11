package com.huateng.ebank.entity.data.mng;

import java.util.ArrayList;
import java.util.List;

import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.data.mng.base.BaseFpPageType;



public class FpPageType extends BaseFpPageType {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FpPageType () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FpPageType (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FpPageType (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String type,
		java.lang.String parent,
		java.lang.String status) {

		super (
			id,
			name,
			descInfo,
			type,
			parent,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/
  
    private String text = "";   //节点文本,必须
    private boolean hasChild;   //是否有子节点,必须
    /** 可选属性 */
    private String state = "closed";//是否展开 open:展开;closed:关闭.默认是关闭
    private boolean canSelected;//选中状态
    private String pid = "";    //父ID
    private String iconCls = "";//图标
    private Object attributes = "";//其它属性
    private List<TreeNode> children = new ArrayList<TreeNode>();//子节点
    private boolean checked;//是否被选中

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isCanSelected() {
		return canSelected;
	}

	public void setCanSelected(boolean canSelected) {
		this.canSelected = canSelected;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
    
}