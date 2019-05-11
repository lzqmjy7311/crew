package com.gbicc.person.importtext.service;

import com.gbicc.person.importtext.ImporttextDao;
import com.gbicc.person.importtext.entity.Importpublictext;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ImporttextService {
	protected ImporttextService() {
	}

	public synchronized static ImporttextService getInstance() {
		return (ImporttextService) ApplicationContextUtils
				.getBean(ImporttextService.class.getSimpleName());
	}
	
	private ImporttextDao getDao(){
		return (ImporttextDao) ApplicationContextUtils.getBean("ImporttextDao");
	}
	
	public Importpublictext get(String id) throws CommonException{
		ImporttextDao dao=getDao();
		return dao.query(id);
	}
	
	public void save(Importpublictext tQuality) throws CommonException{
		ImporttextDao dao=getDao();
		dao.insert(tQuality);
	}
	
	public void update(Importpublictext tQuality) throws CommonException{
		ImporttextDao dao=getDao();
		dao.update(tQuality);
	}
	
	public void delete(String id) throws CommonException{
		ImporttextDao dao=getDao();
		dao.delete(id);
	}
}