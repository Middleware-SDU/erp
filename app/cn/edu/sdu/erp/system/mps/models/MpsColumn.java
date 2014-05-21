package cn.edu.sdu.erp.system.mps.models;

import javax.persistence.Entity;
import cn.edu.sdu.erp.system.commons.models.BaseModel;

/**
 * 描述MPS表的所有列（MPS基本信息表）
 * @author sdcsyyg
 *
 */
@Entity
public class MpsColumn extends BaseModel {

    private static final long serialVersionUID = -7398180798157455614L;

    private Material material;
    // 总周期
    private int totalCycle = 12;
    // 需求期到 3，即[1, 3]
    private int requiretAt = 3;
    // 计划期到 8，即[4, 8]
    private int planAt = 8;

    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public int getTotalCycle() {
        return totalCycle;
    }
    public void setTotalCycle(int totalCycle) {
        this.totalCycle = totalCycle;
    }
    public int getRequiretAt() {
        return requiretAt;
    }
    public void setRequiretAt(int requiretAt) {
        this.requiretAt = requiretAt;
    }
    public int getPlanAt() {
        return planAt;
    }
    public void setPlanAt(int planAt) {
        this.planAt = planAt;
    }

}
