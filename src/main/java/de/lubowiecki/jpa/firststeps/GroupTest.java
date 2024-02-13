package de.lubowiecki.jpa.firststeps;

import de.lubowiecki.jpa.firststeps.model.Product;
import de.lubowiecki.jpa.firststeps.model.ProductGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GroupTest {

    public static void main(String[] args) {

        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("FirstStepsPU");
            EntityManager em = factory.createEntityManager()) {

            /*
            ProductGroup pg1 = new ProductGroup();
            pg1.setName("Lebensmittel");

            ProductGroup pg2 = new ProductGroup();
            pg2.setName("Putzmittel");

            Product p1 = new Product();
            p1.setName("Milch");
            p1.setDescription("H Weidemilch, 3,5% Fett");
            p1.setPrice(1.19);
            p1.setAvailable(true);

            pg1.addProduct(p1);

            Product p2 = new Product();
            p2.setName("Käse");
            p2.setDescription("Käse, Alt");
            p2.setPrice(3.99);
            p2.setAvailable(true);

            pg1.addProduct(p2);

            Product p3 = new Product();
            p3.setName("General Reiniger");
            p3.setDescription("General Alpenfrische, extra scharf");
            p3.setPrice(7.29);

            pg2.addProduct(p3);

            em.getTransaction().begin();
            em.persist(pg1);
            em.persist(pg2);
            em.getTransaction().commit();
            */

            ProductGroup pg = em.find(ProductGroup.class, 2);
            for (Product p: pg.getProducts()) {
                System.out.println(p.getName());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
