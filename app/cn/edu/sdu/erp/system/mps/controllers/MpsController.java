package cn.edu.sdu.erp.system.mps.controllers;

import java.util.List;

import cn.edu.sdu.erp.system.mps.views.html.index;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import cn.edu.sdu.erp.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.erp.core.db.jpa.Transactional;
import cn.edu.sdu.erp.system.mps.models.Material;

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
        List<Material> materials = Material.dao.findAll();
        return ok(index.render(materials));
    }

}
