package peacsoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String description;
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @ManyToMany(mappedBy = "posts",cascade = {DETACH,REFRESH,MERGE,PERSIST})
    private List<InstagramAccount> instagramAccounts = new ArrayList<>();

    public Post(String image, String description, LocalDate publicationDate) {
        this.image = image;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Post{" +
               "id=" + id +
               ", image='" + image + '\'' +
               ", description='" + description + '\'' +
               ", publicationDate=" + publicationDate +
               '}';
    }
}
