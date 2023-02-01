package peacsoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "date_of_brith")
    private LocalDate dateOfBrith;

    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private InstagramAccount instagramAccount;

    public User(String fullName, LocalDate dateOfBrith, String email) {
        this.fullName = fullName;
        this.dateOfBrith = dateOfBrith;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", fullName='" + fullName + '\'' +
               ", dateOfBrith=" + dateOfBrith +
               ", email='" + email + '\'' +
               '}';
    }
}
