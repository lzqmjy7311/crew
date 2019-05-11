package com.gbicc.person.supervision.service;

import com.gbicc.person.supervision.dao.QualitysuParDao;
import com.gbicc.person.supervision.entity.QualitysuPar;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author kfc
 *
 * 版本：2015年10月21日 上午11:17:41
 * 类说明：客户管理 service
 */
public class QualitysuParService {
	protected QualitysuParService() {
	}

	public synchronized static QualitysuParService getInstance() {
		return (QualitysuParService) ApplicationContextUtils
				.getBean(QualitysuParService.class.getSimpleName());
	}
	
	private QualitysuParDao getDao(){
		return (QualitysuParDao) ApplicationContextUtils.getBean("QualitysuParDao");
	}
	
	public QualitysuPar get(String id) throws CommonException{
		QualitysuParDao dao=getDao();
		return dao.query(id);
	}
	
	public void save(QualitysuPar tQuality) throws CommonException{
		QualitysuParDao dao=getDao();
		dao.insert(tQuality);
	}
	
	public void update(QualitysuPar tQuality) throws CommonException{
		QualitysuParDao dao=getDao();
		dao.update(tQuality);
	}
	
	public void delete(String id) throws CommonException{
		QualitysuParDao dao=getDao();
		dao.delete(id);
	}
}

