package cn.edu.sdu.erp.system.mrp.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import cn.edu.sdu.erp.system.commons.models.BaseModel;
import cn.edu.sdu.erp.system.commons.models.Material;
import cn.edu.sdu.erp.system.mrp.daos.BOMDAO;
import cn.edu.sdu.erp.system.mrp.daos.impls.BOMDAOImpl;

@Entity
public class BOM extends BaseModel {

    private static final long serialVersionUID = 7791657246569271427L;
    @ManyToOne
    private BOM parent;
    @OneToOne
    private Material material;
    private int level;
    private int sum;
    private String unit;
    private String name;

    public static BOMDAO dao = new BOMDAOImpl();

    public BOM getParent() {
        return parent;
    }
    public void setParent(BOM parent) {
        this.parent = parent;
    }
    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
