package com.huateng.ebank.entity.dao.mng;

import com.huateng.ebank.entity.data.mng.TblCronTaskJobLog;

public interface IBaseTblCronTaskJobLogDAO extends IQueryObj, IProcessObj {

	public abstract Class getReferenceClass();

	public abstract  TblCronTaskJobLog get(java.lang.String key);

	public abstract  TblCronTaskJobLog load(java.lang.String key);

    public abstract java.lang.String save( TblCronTaskJobLog tblCronTaskJobLog);

    public abstract void saveOrUpdate( TblCronTaskJobLog tblCronTaskJobLog);

    public abstract void update( TblCronTaskJobLog tblCronTaskJobLog);

    public abstract void delete(java.lang.String id);

    public abstract void delete( TblCronTaskJobLog tblCronTaskJobLog);

    public abstract void refresh ( TblCronTaskJobLog tblCronTaskJobLog);

}