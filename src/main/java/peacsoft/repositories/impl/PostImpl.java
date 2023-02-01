package peacsoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peacsoft.config.HibernateConfig;
import peacsoft.entity.Post;
import peacsoft.repositories.PostRepositories;

import java.util.List;

public class PostImpl implements PostRepositories {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();
    @Override
    public void savePost(Post post) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(post);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Post saved.");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Post getPostById(Long postId) {
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Post post = entityManager.find(Post.class, postId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return post;
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> getAllPosts() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Post> posts = entityManager.createQuery("from Post", Post.class).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return posts;
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String updatePost(Long postID, Post post) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Post post1 = entityManager.find(Post.class, postID);
            post1.setImage(post.getImage());
            post1.setDescription(post.getDescription());
            post1.setInstagramAccounts(post.getInstagramAccounts());
            post1.setPublicationDate(post.getPublicationDate());
            entityManager.merge(post1);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Post updated.";
        }catch (HibernateException e){
            return e.getMessage();
        }
    }

    @Override
    public String deletePostById(Long postId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from Post p where p.id = :id").setParameter("id",postId).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Post is deleted.";
        }catch (HibernateException e){
            return e.getMessage();
        }
    }

    @Override
    public String editDescription(Long postId, String newDescription) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Post post = entityManager.find(Post.class, postId);
            post.setDescription(newDescription);
            entityManager.merge(post);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Post edited.";
        }catch (HibernateException e){
            return e.getMessage();
        }
    }
}
