package cn.edu.sdu.erp.system.mrp.daos.impls;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cn.edu.sdu.erp.system.commons.daos.AbstractBaseModelDAO;
import cn.edu.sdu.erp.system.mrp.daos.UserDAO;
import cn.edu.sdu.erp.system.mrp.models.User;


@Repository
public class UserDAOImpl extends AbstractBaseModelDAO<User> implements UserDAO {

    @Override
    public User findByName(String name) {
        String hql = "from Consumer where name = :name";
        TypedQuery<User> query = createQuery(hql).setParameter("name", name);
        return getSingleResultOrNull(query);
    }

}
