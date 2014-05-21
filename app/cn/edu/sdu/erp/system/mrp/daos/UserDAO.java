package cn.edu.sdu.erp.system.mrp.daos;

import cn.edu.sdu.erp.system.commons.daos.BaseModelDAO;
import cn.edu.sdu.erp.system.mrp.models.User;


public interface UserDAO extends BaseModelDAO<User> {

    User findByName(String name);

}
