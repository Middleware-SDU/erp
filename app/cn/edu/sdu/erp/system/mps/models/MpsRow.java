package cn.edu.sdu.erp.system.mps.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import cn.edu.sdu.erp.system.commons.models.BaseModel;

/**
 * 描述MPS表的所有行(MPS的详细信息表)
 * @author sdcsyyg
 *
 */
@Entity
public class MpsRow extends BaseModel {

    private static final long serialVersionUID = -7398180798157455614L;

    @OneToOne
    private MpsColumn column;
    // 预测量
    private String plan;
    // 合同量
    private String bargaint;
    // 毛需求量
    private String gr;
    // 计划接收量
    private String sr;
    // 净需求量
    private String nr;
    // 初期库存
    private String pab;
    // 计划产出量
    private String product;
    // 可供销售量
    private String atp;

    public MpsColumn getColumn() {
        return column;
    }
    public void setColumn(MpsColumn column) {
        this.column = column;
    }
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
    public String getBargaint() {
        return bargaint;
    }
    public void setBargaint(String bargaint) {
        this.bargaint = bargaint;
    }
    public String getGr() {
        return gr;
    }
    public void setGr(String gr) {
        this.gr = gr;
    }
    public String getSr() {
        return sr;
    }
    public void setSr(String sr) {
        this.sr = sr;
    }
    public String getNr() {
        return nr;
    }
    public void setNr(String nr) {
        this.nr = nr;
    }
    public String getPab() {
        return pab;
    }
    public void setPab(String pab) {
        this.pab = pab;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getAtp() {
        return atp;
    }
    public void setAtp(String atp) {
        this.atp = atp;
    }

}
