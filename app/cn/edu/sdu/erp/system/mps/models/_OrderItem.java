package cn.edu.sdu.erp.system.mps.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceUnit;

import cn.edu.sdu.erp.system.commons.models.BaseModel;

/**
 * TODO: 需要在save之前
 * @author sdcsyyg
 *
 */
@Entity
@PersistenceUnit(name="mpsUnit")
public class _OrderItem extends BaseModel {

    private static final long serialVersionUID = 4148708010624528395L;

    private Material material;
    private int count;
    private Date createTime;

    @ManyToOne
    private _Order _order;

    public _OrderItem() {
        this.createTime = new Date();
    }

    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public _Order get_order() {
        return _order;
    }

    public void set_order(_Order _order) {
        this._order = _order;
    }

}
