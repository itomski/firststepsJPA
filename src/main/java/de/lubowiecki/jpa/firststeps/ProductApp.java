package de.lubowiecki.jpa.firststeps;

import de.lubowiecki.jpa.firststeps.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class ProductApp {

    public static void main(String[] args) {

        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("FirstStepsPU");
                EntityManager em = factory.createEntityManager()) {

            // CRUD - Create Read Update Delete
            // insert(em);
            // readOne(em);
            update(em);
            //delete(em);
            readAll(em);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // INSERT
    private static void insert(EntityManager em) {
        Product p1 = new Product();
        p1.setName("Milch");
        p1.setDescription("H Weidemilch. 3,5% Fett");
        p1.setPrice(1.39);
        p1.setAvailable(true);

        em.getTransaction().begin(); // Start der Transaktion
        em.persist(p1); // Nur Klassen mit der Annotation @Entity können von Hibernate verwaltet werden
        em.getTransaction().commit(); // Aufgaben in der Transaktion werden an die DB übertragen
    }

    // SELECT
    private static void readOne(EntityManager em) {

        Product p = em.find(Product.class, 1); // Fragt alle Daten für den Datensatz mit der ID 1
        System.out.println(p.getName());
        System.out.println(p.getDescription());
        System.out.println(p.getPrice());
    }

    private static void readAll(EntityManager em) {

        Query query = em.createNamedQuery("Product.findAll");
        List<Product> products = query.getResultList(); // Liefert alle Objekte aus einer Tabelle

        for (Product p : products) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
    }

    private static void delete(EntityManager em) {

        Product p = em.find(Product.class, 2);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    private static void update(EntityManager em) {

        Product p = em.find(Product.class, 1);
        p.setPrice(2.35);
        p.setName("H Milch");
        p.setDescription("H Hofmilch, 3,5% Fett.");

        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    private static void readByGroup(EntityManager em) {
        // Objekt-Beziehungen
        // OneToOne
        // OneToMany
        // ManyToMany

        //...
    }
}
