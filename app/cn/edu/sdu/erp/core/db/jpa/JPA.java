package cn.edu.sdu.erp.core.db.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import play.Application;
import play.Logger;
import play.Play;
import play.db.jpa.JPAPlugin;

/**
 * JPA Helpers.
 */
public class JPA {

    static ThreadLocal<EntityManager> currentEntityManager = new ThreadLocal<EntityManager>();

    static List<EntityManagerInitializer> entityManagerInitializers = new ArrayList<EntityManagerInitializer>();

    public static void registerEntityManagerInitializer(EntityManagerInitializer entityManagerInitializer) {
        entityManagerInitializers.add(entityManagerInitializer);
        Logger.debug("  " + entityManagerInitializer.getClass() + " registered");
    }

    /**
     * Get the EntityManager for specified persistence unit for this thread.
     */
    public static EntityManager em(String key) {
        Application app = Play.application();
        if (app == null) {
            throw new RuntimeException("No application running");
        }

        JPAPlugin jpaPlugin = app.plugin(JPAPlugin.class);
        if (jpaPlugin == null) {
            throw new RuntimeException("No JPA EntityManagerFactory configured for name [" + key + "]");
        }

        EntityManager em = jpaPlugin.em(key);
        if (em == null) {
            throw new RuntimeException("No JPA EntityManagerFactory configured for name [" + key + "]");
        }

        return em;
    }

    /**
     * Get the default EntityManager for this thread.
     */
    public static EntityManager em() {
        EntityManager em = currentEntityManager.get();
        if (em == null) {
            throw new RuntimeException("No EntityManager bound to this thread. Try to annotate your action method with @play.db.jpa.Transactional");
        }
        return em;
    }

    /**
     * Bind an EntityManager to the current thread.
     */
    public static void bindForCurrentThread(EntityManager em) {
        if (em != null && currentEntityManager.get() != null) {
            throw new RuntimeException("Nested transaction is not allowed.");
        }

        currentEntityManager.set(em);
    }

    /**
     * Run a block of code in a JPA transaction.
     * 
     * @param block Block of code to execute.
     */
    public static <T> T withTransaction(play.libs.F.Function0<T> block) throws Throwable {
        return withTransaction("default", false, block);
    }

    /**
     * Run a block of code in a JPA transaction.
     * 
     * @param block Block of code to execute.
     */
    public static void withTransaction(String name, boolean readOnly, final play.libs.F.Callback0 block) {
        try {
            withTransaction(name, readOnly, new play.libs.F.Function0<Void>() {
                public Void apply() throws Throwable {
                    block.invoke();
                    return null;
                }
            });
        } catch (Throwable t) {
            throw new RuntimeException(t);

        }
    }

    public static void withTransaction(boolean readOnly, final play.libs.F.Callback0 block) {
        withTransaction("default", readOnly, block);
    }

    public static void withTransaction(String name, final play.libs.F.Callback0 block) {
        withTransaction(name, false, block);
    }

    public static void withTransaction(final play.libs.F.Callback0 block) {
        withTransaction("default", false, block);
    }

    /**
     * Run a block of code in a JPA transaction.
     * 
     * @param name The persistence unit name
     * @param readOnly Is the transaction read-only?
     * @param block Block of code to execute.
     */
    public static <T> T withTransaction(String name, boolean readOnly, play.libs.F.Function0<T> block) throws Throwable {
        Logger.trace("JPA.withTransaction starts for " + Thread.currentThread());

        EntityManager em = null;
        EntityTransaction tx = null;
        try {

            em = JPA.em(name);
            JPA.bindForCurrentThread(em);

            for (EntityManagerInitializer entityManagerInitializer : entityManagerInitializers) {
                entityManagerInitializer.initialize();
            }

            if (!readOnly) {
                tx = em.getTransaction();
                tx.begin();
            }

            T result = block.apply();

            if (tx != null) {
                if (tx.getRollbackOnly()) {
                    tx.rollback();
                } else {
                    tx.commit();
                }
            }

            return result;

        } catch (Throwable t) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (Throwable e) {}
            }
            throw t;
        } finally {
            JPA.bindForCurrentThread(null);
            if (em != null) {
                em.close();
            }

            Logger.trace("JPA.withTransaction ends for " + Thread.currentThread());
        }
    }

}
