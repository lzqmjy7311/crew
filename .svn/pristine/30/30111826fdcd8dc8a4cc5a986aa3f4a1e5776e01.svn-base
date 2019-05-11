package com.huateng.ebank.business.approve.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.huateng.ebank.framework.exceptions.CommonException;

public class GetSubFileListImpleByTT implements IGetSubFileList{

	public List getSubFileResultList(Map<String, Object> paramMap) throws CommonException {
		List<String> fileNameList = new ArrayList<String>();
		String fileType = (String) paramMap.get(IGetSubFileList.IN_FILE_TYPE);
		String controlFileTypeName = (String) paramMap.get(IGetSubFileList.IN_CONTROL_NAME);
		if (fileType.equals(controlFileTypeName)) {
			Object obj = paramMap.get(IN_PARAM_OTHER);
			if (obj!=null) {
				LinkedHashSet<String> fileNameSet = (LinkedHashSet<String>) obj;
				for (Iterator<String> iterator = fileNameSet.iterator(); iterator.hasNext();) {
					fileNameList.add(iterator.next());
				}
			}
		}
		return fileNameList;
	}

}
