package de.lubowiecki.jpa.firststeps;

import de.lubowiecki.jpa.firststeps.model.Product;
import de.lubowiecki.jpa.firststeps.model.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TagTest {

    public static void main(String[] args) {

        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("FirstStepsPU");
            EntityManager em = factory.createEntityManager()) {

            /*
            em.getTransaction().begin();
            em.persist(new Tag("sauber"));
            em.persist(new Tag("lecker"));
            em.persist(new Tag("fruchtig"));
            em.persist(new Tag("sahnig"));
            em.persist(new Tag("premium"));
            em.persist(new Tag("giftig"));
            em.getTransaction().commit();
            */

            /*
            Product p = new Product();
            p.setName("Joghurt");
            p.setPrice(1.49);

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            */

            /*
            Tag t1 = em.find(Tag.class, 2);
            Tag t2 = em.find(Tag.class, 3);
            Tag t3 = em.find(Tag.class, 4);

            Product p = em.find(Product.class, 52);
            p.addTag(t1);
            p.addTag(t2);
            p.addTag(t3);

            em.getTransaction().begin();
            em.getTransaction().commit();
            */

            Product p = em.find(Product.class, 52);
            System.out.print(p.getName() + ": ");
            for (Tag t : p.getTags()) {
                System.out.print(t.getName() + ", ");
            }
            System.out.println();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
