package de.lubowiecki.jpa.firststeps;

import de.lubowiecki.jpa.firststeps.model.Profile;
import de.lubowiecki.jpa.firststeps.model.User;
import de.lubowiecki.jpa.firststeps.model.UserStatus;
import de.lubowiecki.jpa.firststeps.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class UserTest {

    public static void main(String[] args) {

        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("FirstStepsPU");
            EntityManager em = factory.createEntityManager()) {

            /*
            User u = new User();
            u.setCreatedAt(LocalDateTime.now());
            u.setEmail("p.parker@shield.org");
            u.setPassword("geheim");
            u.setStatus(UserStatus.CREATED);

            Profile p = new Profile();
            p.setFirstname("Peter");
            p.setLastname("Parker");
            p.setCity("New York");

            u.setProfile(p);

            UserRepository.save(em, u); // Speichert User und Profil ab
            */

            UserRepository.findOne(em, 1).ifPresent(u -> {
                System.out.println(u.getEmail());
                System.out.println(u.getCreatedAt());
                System.out.println(u.getStatus());
                System.out.println(u.getProfile().getFirstname() + " " + u.getProfile().getFirstname());
            });

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
