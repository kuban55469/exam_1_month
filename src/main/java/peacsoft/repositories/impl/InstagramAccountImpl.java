package peacsoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peacsoft.config.HibernateConfig;
import peacsoft.entity.InstagramAccount;
import peacsoft.entity.Post;
import peacsoft.entity.User;
import peacsoft.repositories.InstagramAccountRepositories;

import java.util.List;

public class InstagramAccountImpl implements InstagramAccountRepositories {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();

    @Override
    public String saveAccount(InstagramAccount instagramAccount) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(instagramAccount);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instagramAccount.getUserName() + " is logined.";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public InstagramAccount getAccountById(Long accountId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            InstagramAccount instagramAccount = entityManager.find(InstagramAccount.class, accountId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instagramAccount;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<InstagramAccount> getAllAccounts() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<InstagramAccount> fromInstagramAccount = entityManager.createQuery("from InstagramAccount ", InstagramAccount.class).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return fromInstagramAccount;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String updateAccount(Long accountID, InstagramAccount instagramAccount) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            InstagramAccount instagramAccount1 = entityManager.find(InstagramAccount.class, accountID);
            instagramAccount1.setUserName(instagramAccount.getUserName());
            instagramAccount1.setLogin(instagramAccount.getLogin());
            instagramAccount1.setPassword(instagramAccount.getPassword());
            instagramAccount1.setUser(instagramAccount.getUser());
            instagramAccount1.setPosts(instagramAccount.getPosts());
            entityManager.merge(instagramAccount1);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Account updated.";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteAccountById(Long accountId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            InstagramAccount instagramAccount = entityManager.find(InstagramAccount.class, accountId);
            entityManager.remove(instagramAccount);
            entityManager.getTransaction().commit();
            entityManager.close();
            return " account deleted.";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public String changePassword(Long accountId, String newPassword) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            InstagramAccount instagramAccount = entityManager.find(InstagramAccount.class, accountId);
            instagramAccount.setPassword(newPassword);
            entityManager.merge(instagramAccount);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instagramAccount.getUserName() + " is password changed.";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public void assignPostToInstagramAccount(Long accountId, Long postId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            InstagramAccount instagramAccount = entityManager.find(InstagramAccount.class, accountId);
            Post post = entityManager.find(Post.class, postId);
            instagramAccount.getPosts().add(post);
            post.getInstagramAccounts().add(instagramAccount);
            entityManager.merge(instagramAccount);
            entityManager.merge(post);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Assign post to instagram account");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void assignUserToInstagramAccount(Long accountId, Long userId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            InstagramAccount instagramAccount = entityManager.find(InstagramAccount.class, accountId);
            User user = entityManager.find(User.class, userId);
            instagramAccount.setUser(user);
            user.setInstagramAccount(instagramAccount);
            entityManager.merge(instagramAccount);
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Assign user to instagram");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }


}
