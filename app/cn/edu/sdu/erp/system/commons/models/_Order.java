package cn.edu.sdu.erp.system.commons.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import cn.edu.sdu.erp.system.mps.daos._OrderDAO;
import cn.edu.sdu.erp.system.mps.daos.impls._OrderDAOImpl;

/**
 * 
 * @author sdcsyyg
 *
 */
@Entity
public class _Order extends BaseModel {

    private static final long serialVersionUID = -2446725619512650221L;

    @ManyToOne
    private Consumer consumer;
    private Date createTime;
    @OneToOne
    private Material material;
    private String bargaint;

    public static _OrderDAO dao = new _OrderDAOImpl();

    public _Order() {
        this.createTime = new Date();
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBargaint() {
        return bargaint;
    }

    public void setBargaint(String bargaint) {
        this.bargaint = bargaint;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
