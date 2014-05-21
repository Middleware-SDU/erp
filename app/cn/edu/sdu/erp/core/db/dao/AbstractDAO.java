package cn.edu.sdu.erp.core.db.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.hibernate.ejb.HibernateEntityManagerFactory;

import cn.edu.sdu.erp.core.db.jpa.JPA;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.MetadataUtil;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import com.googlecode.genericdao.search.jpa.hibernate.HibernateMetadataUtil;


public abstract class AbstractDAO<T, ID extends Serializable> extends GenericDAOImpl<T, ID> implements DAO<T, ID> {

    protected Class<T> typeOfT;
    protected Class<ID> typeOfID;

    private static Map<MetadataUtil, JPASearchProcessor> searchProcessorMap = new HashMap<MetadataUtil, JPASearchProcessor>();

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (types.length > 0) {
            this.typeOfT = (Class<T>) types[0];
        }
        if (types.length > 1) {
            this.typeOfID = (Class<ID>) types[1];
        }
    }

    // ------------------------------------------------------------------------
    // BaseDAO implementation
    // ------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find(List<ID> idList) {
        return Arrays.asList(find(idList.toArray((ID[]) java.lang.reflect.Array.newInstance(typeOfID, idList.size()))));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> save(List<T> entityList) {
        return Arrays.asList(save(entityList.toArray((T[]) java.lang.reflect.Array.newInstance(typeOfT, entityList.size()))));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void remove(List<T> entityList) {
        remove(entityList.toArray((T[]) java.lang.reflect.Array.newInstance(typeOfT, entityList.size())));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void removeByIds(List<ID> idList) {
        removeByIds(idList.toArray((ID[]) java.lang.reflect.Array.newInstance(typeOfID, idList.size())));
    }

    // ------------------------------------------------------------------------
    // Integrate hibernate-generic-dao with play framework
    // ------------------------------------------------------------------------

    @Override
    protected EntityManager em() {
        return JPA.em();
    }

    @Override
    protected MetadataUtil getMetadataUtil() {
        return HibernateMetadataUtil.getInstanceForEntityManagerFactory((HibernateEntityManagerFactory) JPA.em().getEntityManagerFactory());
    }

    @Override
    protected JPASearchProcessor getSearchProcessor() {
        MetadataUtil metadataUtil = getMetadataUtil();
        JPASearchProcessor searchProcessor = searchProcessorMap.get(metadataUtil);
        if (searchProcessor == null) {
            searchProcessor = new JPASearchProcessor(metadataUtil);
            searchProcessorMap.put(metadataUtil, searchProcessor);
        }
        return searchProcessor;
    }

    // ------------------------------------------------------------------------
    // Common helper methods
    // ------------------------------------------------------------------------

    /**
     * Shortcut to create a generic query for the type of T
     * 
     * @param hql
     * @return
     */
    protected TypedQuery<T> createQuery(String hql) {
        return em().createQuery(hql, typeOfT);
    }

    /**
     * Shortcut to create a generic query for a specific type
     * 
     * @param hql
     * @return
     */
    protected <M> TypedQuery<M> createQuery(String hql, Class<M> clazz) {
        return em().createQuery(hql, clazz);
    }

    /**
     * Used to replace TypedQuery.getSingleResult because that method throws an exception when there is no result
     * 
     * @param hql
     * @return
     */
    protected T getSingleResultOrNull(TypedQuery<T> typedQuery) {
        List<T> result = typedQuery.getResultList();

        if (result.isEmpty()) {
            return null;
        }

        if (result.size() == 1) {
            return result.get(0);
        }

        throw new NonUniqueResultException();
    }

}
