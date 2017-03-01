/**
 * Created by ericl on 2/28/2017.
 */

import soen487.DiscountCode;
import soen487.service.EMF;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CustomerTest {

    public static void main(String[] args) {
        EntityManager entityManager = EMF.getEntityManager();
        DiscountCode dc = new DiscountCode();
        dc.setDiscountCode("Z");
        dc.setRate(new BigDecimal(12.0));

        entityManager.getTransaction().begin();
        entityManager.persist(dc);
        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();
        /*
        entityManager.getTransaction().begin();
        DiscountCode dc = new DiscountCode();
        dc.setDiscountCode("Y");
        dc.setRate(new BigDecimal(9.0));

        entityManager.persist(dc);
        entityManager.getTransaction().commit();
        entityManager.close();
        EMF.close();
        */
        System.out.println("Entity saved.");
    }
}
