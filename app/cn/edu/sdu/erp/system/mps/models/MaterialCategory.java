package cn.edu.sdu.erp.system.mps.models;
import javax.persistence.Entity;
import javax.persistence.PersistenceUnit;

import cn.edu.sdu.erp.system.commons.models.BaseModel;

/**
 * 
 * @author sdcsyyg
 *
 */
@Entity
@PersistenceUnit(name="mpsUnit")
public class MaterialCategory extends BaseModel {

    private static final long serialVersionUID = 6515867687488752179L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
