import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import cn.edu.sdu.erp.core.db.jpa.JPA;
import cn.edu.sdu.erp.system.commons.models.BaseModel;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.F.Callback0;
import play.libs.Yaml;
import play.mvc.Action;
import play.mvc.Http.Request;

/**
 * 
 * @author sdcsyyg
 *
 */
public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {

        JPA.withTransaction(new Callback0() {
            @SuppressWarnings("unchecked")
            public void invoke() {

                long count = cn.edu.sdu.erp.system.mps.models.Consumer.dao.findAll().size();

                if(count == 0){
                    Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml.load("initial-data-mps.yml");
                    if(all != null && all.size()>0) {
                        for (Map.Entry<String, List<Object>> entry : all.entrySet()) {
                            List<Object> list = entry.getValue();
                            if (list != null) {
                                for (BaseModel model : getModelFromList(list)) {
                                    JPA.em().persist(model);
                                }
                            }
                        }
                    }
                }

            }
        });

    }

    @SuppressWarnings("rawtypes")
    @Override
    public Action onRequest(Request request, Method method) {
        Logger.debug("---------------------------------------------------------");
        Logger.debug("Global.onRequest");
        Logger.debug("  Request: " + request);
        Logger.debug("  Method: " + method);
        return super.onRequest(request, method);
    }

    @SuppressWarnings("unchecked")
    private static <T extends BaseModel> List<T> getModelFromList(List<Object> objects) {
        if (objects == null) {
            return null;
        }
        List<T> models = new ArrayList<T>();
        for (Object object : objects) {
            T model = (T) object;
            models.add(model);
        }
        return models;
    }
}
