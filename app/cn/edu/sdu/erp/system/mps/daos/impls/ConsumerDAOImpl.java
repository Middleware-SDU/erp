package cn.edu.sdu.erp.system.mps.daos.impls;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cn.edu.sdu.erp.system.commons.daos.AbstractBaseModelDAO;
import cn.edu.sdu.erp.system.commons.models.Consumer;
import cn.edu.sdu.erp.system.mps.daos.ConsumerDAO;


@Repository
public class ConsumerDAOImpl extends AbstractBaseModelDAO<Consumer> implements ConsumerDAO {

    @Override
    public Consumer findByName(String name) {
        String hql = "from Consumer where name = :name";
        TypedQuery<Consumer> query = createQuery(hql).setParameter("name", name);
        return getSingleResultOrNull(query);
    }

}
