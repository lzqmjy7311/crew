package com.gbicc.common.filemng;

import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class FileUploadOperation extends BaseOperation{
	public static final String ID = FileUploadOperation.class.getSimpleName();
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String CMD = "CMD";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext arg0) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext arg0) throws CommonException {
	}

	
	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		if(cmd.equals(CMD_INSERT)){
			FileUpload f = (FileUpload) context.getAttribute(IN_PARAM);
			ROOTDAOUtils.getROOTDAO().save(f);
		}else if(cmd.equals(CMD_DELETE)){
			String id = (String) context.getAttribute(IN_PARAM);
			FileUploadSevice.getInstance().delete(id);
		}
	}

}
