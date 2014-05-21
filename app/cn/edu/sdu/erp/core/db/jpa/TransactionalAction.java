package cn.edu.sdu.erp.core.db.jpa;

import play.Logger;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

public class TransactionalAction extends Action<Transactional> {

    public Promise<SimpleResult> call(final Http.Context ctx) throws Throwable {
        Logger.debug("TransactionalAction.call");

        TransactionalHelper.enableTransaction(configuration.value(), configuration.readOnly());

        return delegate.call(ctx);
    }

}
