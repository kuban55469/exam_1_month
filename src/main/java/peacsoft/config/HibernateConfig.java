package peacsoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peacsoft.entity.InstagramAccount;

import peacsoft.entity.Post;
import peacsoft.entity.User;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManagerFactory entityManagerFactory(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/java8");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(InstagramAccount.class);
        configuration.addAnnotatedClass(Post.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
