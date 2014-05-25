package cn.edu.sdu.erp.system.commons.controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class HomepageController extends Controller {

    public Result index() {
        return ok(index.render("ERP ------- MPS ＆ MRP"));
    }

}
