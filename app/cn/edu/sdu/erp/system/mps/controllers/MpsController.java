package cn.edu.sdu.erp.system.mps.controllers;

import java.util.List;

import cn.edu.sdu.erp.system.mps.models._Order;
import cn.edu.sdu.erp.system.mps.views.html.index;
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
public class MpsController extends Controller {

    @Transactional
    public Result index() {
        List<_Order> orders = _Order.dao.findAll();
        return ok(index.render(orders));
    }

}
