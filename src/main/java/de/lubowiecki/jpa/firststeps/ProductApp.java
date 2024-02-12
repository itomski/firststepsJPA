package de.lubowiecki.jpa.firststeps;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductApp {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FirstStepsPU");
        EntityManager em = factory.createEntityManager();

        //...

        em.close();
        factory.close();
    }
}
