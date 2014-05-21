package cn.edu.sdu.erp.system.mrp.models;
import javax.persistence.Entity;
import javax.persistence.PersistenceUnit;

import cn.edu.sdu.erp.system.commons.models.BaseModel;
import cn.edu.sdu.erp.system.mrp.daos.UserDAO;
import cn.edu.sdu.erp.system.mrp.daos.impls.UserDAOImpl;

/**
 * 
 * @author sdcsyyg
 *
 */
@Entity
@PersistenceUnit(name="mrpUnit")
public class User extends BaseModel {

    private static final long serialVersionUID = -2910331695946923507L;

    private String name;

    public static final UserDAO dao = new UserDAOImpl();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
