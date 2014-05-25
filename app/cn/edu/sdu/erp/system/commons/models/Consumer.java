package cn.edu.sdu.erp.system.commons.models;
import javax.persistence.Entity;

import cn.edu.sdu.erp.system.mps.daos.ConsumerDAO;
import cn.edu.sdu.erp.system.mps.daos.impls.ConsumerDAOImpl;

/**
 * 
 * @author sdcsyyg
 *
 */
@Entity
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
