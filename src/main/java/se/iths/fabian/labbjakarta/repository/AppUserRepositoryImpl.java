package se.iths.fabian.labbjakarta.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.iths.fabian.labbjakarta.entity.AppUser;

import java.util.List;

@ApplicationScoped
public class AppUserRepositoryImpl implements AppUserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppUser save(AppUser user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    @Override
    public List<AppUser> findAll() {
        return entityManager.createQuery("SELECT u FROM AppUser u", AppUser.class).getResultList();
    }

    @Override
    public AppUser findByUsername(String username) {
        try {
            return entityManager.createQuery("SELECT u FROM AppUser u WHERE u.username = :username", AppUser.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
