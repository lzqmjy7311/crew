package com.gbicc.common.filemng;

import java.io.File;
import java.util.List;

import com.gbicc.common.CommonService;
import com.gbicc.common.FileUpDownProperties;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class FileUploadSevice {
	static String upload_path;
	static{
		String rootPath = FileUpDownProperties.readValue("rootPath");
		String projectPath = FileUpDownProperties.readValue("projectPath");
		String tempPath = FileUpDownProperties.readValue("tempPath");
		upload_path=rootPath+File.separator+projectPath+File.separator+tempPath+File.separator;
	}

	protected FileUploadSevice() {
	}

	public synchronized static FileUploadSevice getInstance() {
		return (FileUploadSevice) ApplicationContextUtils
				.getBean(FileUploadSevice.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	@SuppressWarnings("unchecked")
	public void deleteByRelaID(String relaID) throws CommonException{
		List<FileUpload> list=dao().queryByCondition("from FileUpload where relaID='"+relaID+"'");
		for(FileUpload f:list){
			File file=new File(upload_path+f.getFilePath());
			if(file.exists()){
				file.delete();
			}
		}
		CommonService.getInstance().executeHQL("delete from FileUpload where relaID='"+relaID+"'");
	}
	
	public void delete(String id) throws CommonException{
		FileUpload f=dao().query(FileUpload.class, id);
		File file=new File(upload_path+f.getFilePath());
		if(file.exists()){
			file.delete();
		}
		dao().delete(f);
	}
}
