package peacsoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peacsoft.config.HibernateConfig;
import peacsoft.entity.User;
import peacsoft.repositories.UserRepositories;

import java.util.List;

public class UserImpl implements UserRepositories {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();
    @Override
    public String saveUser(User user) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.close();
            return user.getFullName() + " is saved.";
        }catch (HibernateException e){
            return e.getMessage();
        }
    }

    @Override
    public User getUserById(Long userId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return user;
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> getAllUsers() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<User> users = entityManager.createQuery("from User", User.class).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return users;
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String updateUser(Long userId, User user) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            User user1 = entityManager.find(User.class, userId);
            user1.setFullName(user.getFullName());
            user1.setDateOfBrith(user.getDateOfBrith());
            user1.setEmail(user.getEmail());
            user1.setInstagramAccount(user.getInstagramAccount());

            entityManager.merge(user1);
            entityManager.getTransaction().commit();
            entityManager.close();
            return user.getFullName() + " updated.";
        }catch (HibernateException e){
            return e.getMessage();
        }
    }

    @Override
    public String deleteUserById(Long userId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "User is deleted.";
        }catch (HibernateException e){
           return e.getMessage();
        }
    }

    @Override
    public boolean existByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        for (User user : users) {
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
