package soen487.service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * Created by ericl on 2/27/2017.
 */
//EntityManager util function
public class EMF implements ServletContextListener {

    private static EntityManagerFactory emf;


    public void contextInitialized(ServletContextEvent event) {
        emf = Persistence.createEntityManagerFactory("NewTestPU");
    }


    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return emf.createEntityManager();
    }

}
