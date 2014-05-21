package cn.edu.sdu.erp.core.db.jpa;

import play.Logger;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.SimpleResult;

/**
 * Wraps an action in an optional JPA transaction. (So there might be no transaction)
 */
public class OptionalTransactionalAction extends Action.Simple {

    public Promise<SimpleResult> call(final Context ctx) throws Throwable {
        Logger.debug("OptionalTransactionalAction.call");

        if (TransactionalHelper.isTransactionEnabled()) {
            Logger.debug("  Transaction enabled" + (TransactionalHelper.isTransactionReadOnly() ? " (readOnly)" : ""));
            return JPA.withTransaction(
                    TransactionalHelper.getTransactionPersistenceUnitName(),
                    TransactionalHelper.isTransactionReadOnly(),
                    new play.libs.F.Function0<Promise<SimpleResult>>() {
                        public Promise<SimpleResult> apply() throws Throwable {
                            return delegate.call(ctx);
                        }
                    });
        } else {
            Logger.debug("  Transaction disabled");

            return delegate.call(ctx);
        }
    }

}
