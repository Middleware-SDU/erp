package cn.edu.sdu.erp.system.mps.models;
import javax.persistence.Entity;
import javax.persistence.PersistenceUnit;

import cn.edu.sdu.erp.system.commons.models.BaseModel;
import cn.edu.sdu.erp.system.mps.daos.ConsumerDAO;
import cn.edu.sdu.erp.system.mps.daos.impls.ConsumerDAOImpl;

/**
 * 
 * @author sdcsyyg
 *
 */
@Entity
@PersistenceUnit(name="mpsUnit")
public class Consumer extends BaseModel {

    private static final long serialVersionUID = -2910331695946923507L;

    private String name;

    public static final ConsumerDAO dao = new ConsumerDAOImpl();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
