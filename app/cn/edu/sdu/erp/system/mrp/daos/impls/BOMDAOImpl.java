package cn.edu.sdu.erp.system.mrp.daos.impls;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import cn.edu.sdu.erp.system.commons.daos.AbstractBaseModelDAO;
import cn.edu.sdu.erp.system.mrp.daos.BOMDAO;
import cn.edu.sdu.erp.system.mrp.models.BOM;


@Repository
public class BOMDAOImpl extends AbstractBaseModelDAO<BOM> implements BOMDAO {

    @Override
    public List<BOM> findRootBOM() {
        String hql = "from BOM where level = :level";
        TypedQuery<BOM> query = createQuery(hql).setParameter("level", 0);
        return query.getResultList();
    }

}
