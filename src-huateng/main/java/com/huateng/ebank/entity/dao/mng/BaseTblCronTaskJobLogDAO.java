package com.huateng.ebank.entity.dao.mng;

import com.huateng.ebank.entity.data.mng.TblCronTaskJobLog;



/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseTblCronTaskJobLogDAO extends _BaseRootDAO implements IBaseTblCronTaskJobLogDAO {

	// query name references


	public Class getReferenceClass () {
		return TblCronTaskJobLog.class;
	}


	public TblCronTaskJobLog get(java.lang.String key)
	{
		return (TblCronTaskJobLog) get(getReferenceClass(), key);
	}

	public TblCronTaskJobLog load(java.lang.String key)
	{
		return (TblCronTaskJobLog) load(getReferenceClass(), key);
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param tblCronTaskJobLog a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.String save(TblCronTaskJobLog tblCronTaskJobLog)
	{
		return (java.lang.String) super.save(tblCronTaskJobLog);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param tblCronTaskJobLog a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(TblCronTaskJobLog tblCronTaskJobLog)
	{
		super.saveOrUpdate(tblCronTaskJobLog);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param tblCronTaskJobLog a transient instance containing updated state
	 */
	public void update(TblCronTaskJobLog tblCronTaskJobLog) 
	{
		super.update(tblCronTaskJobLog);
	}


	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.String id)
	{
		super.delete(load(id));
	}


	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param tblCronTaskJobLog the instance to be removed
	 */
	public void delete(TblCronTaskJobLog tblCronTaskJobLog)
	{
		super.delete(tblCronTaskJobLog);
	}

	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (TblCronTaskJobLog tblCronTaskJobLog)
	{
		super.refresh(tblCronTaskJobLog);
	}



}