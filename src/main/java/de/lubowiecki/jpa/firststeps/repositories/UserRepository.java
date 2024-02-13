package de.lubowiecki.jpa.firststeps.repositories;

import de.lubowiecki.jpa.firststeps.model.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UserRepository {

    // CRUD - Create Read Update Delete
    public static Optional<User> findOne(EntityManager em, long id) throws Exception {

        User user = em.find(User.class, id);

        if(user == null)
            return Optional.empty();
        else
            return Optional.of(user);
    }

    public static List<User> findAll(EntityManager em) throws Exception {

        return em.createNamedQuery("User.findAll").getResultList();
    }

    public static void save(EntityManager em, User user) throws Exception {

        if(user.getId() > 0) {
            update(em, user);
        }
        else {
            insert(em, user);
        }
    }

    private static void insert(EntityManager em, User user) throws Exception {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    private static void update(EntityManager em, User user) throws Exception {

        if(!em.contains(user)) // ist der User im Persistenz-Kontext?
            em.merge(user); // Objekt in den Persistenz-Kontext aufnehmen

        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    public static void delete(EntityManager em, User user) throws Exception {

        if(!em.contains(user))
            em.merge(user);

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }
}
