package cn.edu.sdu.erp.system.mps.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;

import cn.edu.sdu.erp.system.commons.models.BaseModel;

/**
 * 
 * @author sdcsyyg
 *
 */
@Entity
@PersistenceUnit(name="mpsUnit")
public class _Order extends BaseModel {

    private static final long serialVersionUID = -2446725619512650221L;

    @ManyToOne
    private Consumer consumer;
    private Date createTime;

    @OneToMany(mappedBy="_order", cascade={CascadeType.PERSIST})
    private List<_OrderItem> orderItems = new ArrayList<_OrderItem>();

    public _Order() {
        this.createTime = new Date();
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public List<_OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<_OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void addItem(_OrderItem item) {
        if(this.orderItems != null && !this.orderItems.contains(item)) {
            this.orderItems.add(item);
        }
    }

    public void removeItem(_OrderItem item) {
        if(this.orderItems != null && this.orderItems.contains(item)) {
            this.orderItems.remove(item);
        }
    }

    public void updateItem(_OrderItem item) {
        if(this.orderItems != null && this.orderItems.contains(item)) {
            this.orderItems.set(this.orderItems.indexOf(item), item);
        }
    }

}
