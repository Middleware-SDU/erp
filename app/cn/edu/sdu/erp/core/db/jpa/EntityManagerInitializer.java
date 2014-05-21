package cn.edu.sdu.erp.core.db.jpa;


/**
 * Initialize an EntityManager after it is created
 * 
 * @author Peter Fu
 */
public interface EntityManagerInitializer {

    void initialize();

}
