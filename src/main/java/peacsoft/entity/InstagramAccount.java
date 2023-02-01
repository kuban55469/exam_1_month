package peacsoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "instagram_accounts")
public class InstagramAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String login;
    private String password;
    @OneToOne(cascade = {DETACH,REFRESH,MERGE,PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = {ALL})
    private List<Post> posts = new ArrayList<>();

    public InstagramAccount(String userName, String login, String password) {
        this.userName = userName;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "InstagramAccount{" +
               "userName='" + userName + '\'' +
               ", login='" + login + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
