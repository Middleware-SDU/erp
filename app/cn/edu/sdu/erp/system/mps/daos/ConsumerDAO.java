package cn.edu.sdu.erp.system.mps.daos;

import cn.edu.sdu.erp.system.commons.daos.BaseModelDAO;
import cn.edu.sdu.erp.system.commons.models.Consumer;


public interface ConsumerDAO extends BaseModelDAO<Consumer> {

    Consumer findByName(String name);

}
