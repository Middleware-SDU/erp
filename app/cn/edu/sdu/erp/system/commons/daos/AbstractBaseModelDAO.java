package cn.edu.sdu.erp.system.commons.daos;

import cn.edu.sdu.erp.core.db.dao.AbstractDAO;
import cn.edu.sdu.erp.system.commons.models.BaseModel;


public abstract class AbstractBaseModelDAO<T extends BaseModel> extends AbstractDAO<T, Long> implements BaseModelDAO<T> {

    public AbstractBaseModelDAO() {
        this.typeOfID = Long.class;
    }

}
