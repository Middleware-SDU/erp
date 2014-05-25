package cn.edu.sdu.erp.system.mrp.controllers;

import java.util.List;

import cn.edu.sdu.erp.system.commons.models._Order;
import cn.edu.sdu.erp.system.mrp.models.BOM;
import cn.edu.sdu.erp.system.mrp.views.html.index;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import cn.edu.sdu.erp.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.erp.core.db.jpa.Transactional;

/**
 * 
 * @author sdcsyyg
 *
 */

@With({
    OptionalTransactionalAction.class
})
public class MrpController extends Controller {

    @Transactional
    public Result index() {
        List<BOM> boms = BOM.dao.findAll();
        return ok(index.render(boms));
    }

}
