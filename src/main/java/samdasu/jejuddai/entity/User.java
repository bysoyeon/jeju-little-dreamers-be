package samdasu.jejuddai.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "user")
@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String profile_image;

    // Getters and setters
}
