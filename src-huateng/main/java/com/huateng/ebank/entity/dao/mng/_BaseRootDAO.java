package com.huateng.ebank.entity.dao.mng;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




public abstract class _BaseRootDAO extends HibernateDaoSupport implements IQueryObj, IProcessObj {


	/**
	 * Return the specific Object class that will be used for class-specific
	 * implementation of this DAO.
	 * @return the reference Class
	 */
	protected abstract Class getReferenceClass();

	/**
     * Used by the base DAO classes but here for your modification
     * Get object matching the given key and return it.
     */
    protected Object get(Class refClass, Serializable key) {
        return getHibernateTemplate().get(refClass, key);
    }

    protected Object getForUpdate(Class refClass, Serializable key) {
        return getHibernateTemplate().get(refClass, key, LockMode.UPGRADE);
    }
    
     /**
     * Used by the base DAO classes but here for your modification
     * Load object matching the given key and return it.
     */
    protected Object load(Class refClass, Serializable key) {
        return getHibernateTemplate().load(refClass, key);
    }
 
    /**
     * Execute a query.
     * @param query a query expressed in Hibernate's query language
     * @return a distinct list of instances (or arrays of instances)
     */
    public List find(String query) {
        return getHibernateTemplate().find(query);
    }

    /**
     * Return all objects related to the implementation of this DAO with no filter.
     */
    public List findAll () {
        return getHibernateTemplate().loadAll(getReferenceClass());
    }

    /**
     * Obtain an instance of Query for a named query string defined in the mapping file.
     * @param name the name of a query defined externally
     * @return Query
     */
    public List findByNamedQuery(String name) {
        return getHibernateTemplate().findByNamedQuery(name);
    }

    public List findByNamedQuery(final String name, final int begin, final int count) {
        return getHibernateTemplate().executeFind(
            new HibernateCallback() { 
                public Object doInHibernate(Session session) 
                    throws HibernateException, SQLException { 
                    Query query = session.getNamedQuery(name); 
                    if( begin >= 0 ) {
                        query.setFirstResult(begin); 
                        query.setMaxResults(count); 
                    }
                    return query.list(); 
                } 
            }
        ); 
    }

    /**
     * Obtain an instance of Query for a named query string defined in the mapping file.
     * Use the parameters give
     * @param name the name of a query defined externally
     * @param params the parameter Map
     * @return Query
     */
    public List findByNamedQuery(final String name, final Map params) {
        return findByNamedQuery(name, params, -1, -1);
    }

    public List findByNamedQuery(final String name, final Map params, final int begin, final int count) {
        return getHibernateTemplate().executeFind(
            new HibernateCallback() { 
                public Object doInHibernate(Session session) 
                    throws HibernateException, SQLException { 
                    Query query = session.getNamedQuery(name); 
                    if (null != params) {
                        for (Iterator i=params.entrySet().iterator(); i.hasNext(); ) {
                            Map.Entry entry = (Map.Entry) i.next();
                            if (entry.getValue() instanceof Collection){
                            	query.setParameterList((String) entry.getKey(), (Collection)entry.getValue());
                            }else{
                            	query.setParameter((String) entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if( begin >= 0 ) {
                        query.setFirstResult(begin); 
                        query.setMaxResults(count);
                    } 
                    return query.list(); 
                } 
            }
        ); 
    }

    /**
     * Obtain an instance of Query for a named query string defined in the mapping file.
     * Use the parameters give
     * @param name the name of a query defined externally
     * @param params the parameter array
     * @return Query
     */
    public List findByNamedQuery(final String name, final Serializable[] params) {
        return findByNamedQuery(name, params, -1, -1);
    }

    public List findByNamedQuery(final String name, final Serializable[] params, final int begin, final int count) {
        return getHibernateTemplate().executeFind(
            new HibernateCallback() { 
                public Object doInHibernate(Session session) 
                    throws HibernateException, SQLException { 
                    Query query = session.getNamedQuery(name); 
                    if (null != params) {
                        for (int i = 0; i < params.length; i++) {
                            query.setParameter(i, params[i]);
                        }
                    }
                    if( begin >= 0 ) {
                        query.setFirstResult(begin); 
                        query.setMaxResults(count); 
                    }
                    return query.list(); 
                } 
            }
        ); 
    }


    /**
     * Used by the base DAO classes but here for your modification
     * Persist the given transient instance, first assigning a enerated identifier.
     * (Or using the current value of the identifier property if the assigned generator is used.)
     */
    protected Serializable save(Object obj) {
		return getHibernateTemplate().save(obj);
    }

    /**
     * Used by the base DAO classes but here for your modification
     * Either save() or update() the given instance, depending upon the value of its
     * identifier property.
     */
    protected void saveOrUpdate(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
    }

    /**
     * Used by the base DAO classes but here for your modification
     * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
     * instance with the same identifier in the current session.
     * @param obj a transient instance containing updated state
     */
    protected void update(Object obj) {
		getHibernateTemplate().update(obj);
    }

    /**
     * Used by the base DAO classes but here for your modification
     * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
     * Session or a transient instance with an identifier associated with existing persistent state.
     */
    protected void delete(Object obj) {
		getHibernateTemplate().delete(obj);
    }

    /**
     * Used by the base DAO classes but here for your modification
     * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
     * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
     */
    protected void refresh(Object obj) {
		getHibernateTemplate().refresh(obj);
    }

    public void clear() {
		getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
    }
    
    public void flush() {
		getHibernateTemplate().flush();
    }

}