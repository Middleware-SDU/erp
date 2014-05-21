package cn.edu.sdu.erp.core.db.jpa;

import play.mvc.Http.Context;

class TransactionalHelper {

    static final String CTX_KEY_TRANSACTIONAL = "_transactional";

    static void enableTransaction(String key, boolean readOnly) {
        Context.current().args.put(CTX_KEY_TRANSACTIONAL, new TransactionalConfig(key, readOnly));
    }

    static boolean isTransactionEnabled() {
        return Context.current().args.get(CTX_KEY_TRANSACTIONAL) != null;
    }

    static String getTransactionPersistenceUnitName() {
        return ((TransactionalConfig) Context.current().args.get(CTX_KEY_TRANSACTIONAL)).name;
    }

    static boolean isTransactionReadOnly() {
        return ((TransactionalConfig) Context.current().args.get(CTX_KEY_TRANSACTIONAL)).readOnly;
    }

    static class TransactionalConfig {
        /**
         * The persistence unit name
         */
        String name;

        /**
         * Is the transaction read-only?
         */
        boolean readOnly;

        TransactionalConfig(String name, boolean readOnly) {
            this.name = name;
            this.readOnly = readOnly;
        }
    }

}
