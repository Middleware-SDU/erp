package cn.edu.sdu.erp.system.mrp.daos;

import java.util.List;

import cn.edu.sdu.erp.system.commons.daos.BaseModelDAO;
import cn.edu.sdu.erp.system.mrp.models.BOM;

public interface BOMDAO extends BaseModelDAO<BOM> {

    List<BOM> findRootBOM();

}
