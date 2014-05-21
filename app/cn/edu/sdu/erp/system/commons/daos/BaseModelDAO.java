package cn.edu.sdu.erp.system.commons.daos;

import cn.edu.sdu.erp.core.db.dao.DAO;
import cn.edu.sdu.erp.system.commons.models.BaseModel;

public interface BaseModelDAO<T extends BaseModel> extends DAO<T, Long> {

}
