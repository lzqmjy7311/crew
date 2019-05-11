package com.huateng.fp.demo.bean;

import com.huateng.ebank.business.common.bean.TreeNode;

public class TreeField extends TreeNode {

	private String[] fd;

	public String[] getFd() {
		return fd;
	}

	public void setFd(String[] fd) {
		this.fd = fd;
	}

	public static void main(String[] args) {
		int N = 30;
		for (int i = 0; i < N; i++) {
			System.out.println("<Field id=\"f" + i + "\" desc=\"测试字段" + i + "\" xpath=\"/fd[" + i + "]\" />");
		}
		for (int i = 0; i < N; i++) {
			System.out.print("f" + i + ",");
		}
	}
}
