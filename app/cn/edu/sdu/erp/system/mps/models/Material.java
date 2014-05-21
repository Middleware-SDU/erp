package cn.edu.sdu.erp.system.mps.models;
import javax.persistence.Entity;
import javax.persistence.PersistenceUnit;

import cn.edu.sdu.erp.system.commons.models.BaseModel;
import cn.edu.sdu.erp.system.mps.daos.MaterialDAO;
import cn.edu.sdu.erp.system.mps.daos.impls.MaterialDAOImpl;

/**
 * 
 * @author sdcsyyg
 *
 */
@Entity
@PersistenceUnit(name="mpsUnit")
public class Material extends BaseModel {

    private static final long serialVersionUID = -5218995222556754550L;

    private String name;
    private MaterialCategory category;
    private String code;
    private int earlyDays;
    private int stack = 80;
    private int safeStack = 50;

    public static MaterialDAO dao = new MaterialDAOImpl();


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public MaterialCategory getCategory() {
        return category;
    }
    public void setCategory(MaterialCategory category) {
        this.category = category;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getEarlyDays() {
        return earlyDays;
    }
    public void setEarlyDays(int earlyDays) {
        this.earlyDays = earlyDays;
    }
    public int getStack() {
        return stack;
    }
    public void setStack(int stack) {
        this.stack = stack;
    }
    public int getSafeStack() {
        return safeStack;
    }
    public void setSafeStack(int safeStack) {
        this.safeStack = safeStack;
    }

}
