package cn.edu.sdu.erp.core.db.dao;

import java.io.Serializable;
import java.util.List;
import com.googlecode.genericdao.dao.jpa.GenericDAO;

public interface DAO<T, ID extends Serializable> extends GenericDAO<T, ID> {

    List<T> find(List<ID> idList);

    List<T> save(List<T> entityList);

    void remove(List<T> entityList);

    void removeByIds(List<ID> idList);

}
