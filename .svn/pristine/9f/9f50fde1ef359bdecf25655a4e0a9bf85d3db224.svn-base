package com.gbicc.person.importtext.service;

import com.gbicc.person.importtext.ImportpersontextDao;
import com.gbicc.person.importtext.entity.Importpersontext;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ImporttextPersonService {
	protected ImporttextPersonService() {
	}

	public synchronized static ImporttextPersonService getInstance() {
		return (ImporttextPersonService) ApplicationContextUtils
				.getBean(ImporttextPersonService.class.getSimpleName());
	}
	
	private ImportpersontextDao getDao(){
		return (ImportpersontextDao) ApplicationContextUtils.getBean("ImportpersontextDao");
	}
	
	public Importpersontext get(String id) throws CommonException{
		ImportpersontextDao dao=getDao();
		return dao.query(id);
	}
	
	public void save(Importpersontext tQuality) throws CommonException{
		ImportpersontextDao dao=getDao();
		dao.insert(tQuality);
	}
	
	public void update(Importpersontext tQuality) throws CommonException{
		ImportpersontextDao dao=getDao();
		dao.update(tQuality);
	}
	
	public void delete(String id) throws CommonException{
		ImportpersontextDao dao=getDao();
		dao.delete(id);
	}
}