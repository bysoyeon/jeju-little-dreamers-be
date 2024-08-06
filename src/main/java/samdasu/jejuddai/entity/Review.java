package samdasu.jejuddai.entity;

import jakarta.persistence.*;
import lombok.*;
import samdasu.jejuddai.dto.ReviewDTO;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private int grade;
    private String content;

    @Lob
    @Column(name = "image1", columnDefinition = "BLOB")
    private byte[] image1;

    @Lob
    @Column(name = "image2", columnDefinition = "BLOB")
    private byte[] image2;

    @Lob
    @Column(name = "image3", columnDefinition = "BLOB")
    private byte[] image3;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    public ReviewDTO toResponseDTO() {
        return ReviewDTO.builder()
                .id(this.id)
                .store_id(this.store.getId())
                .store_name(this.store.getName())
                .user_id(this.user.getId())
                .user_nickname(this.user.getNickname())
                .grade(this.grade)
                .content(this.content)
                .image1(this.image1)
                .image2(this.image2)
                .image3(this.image3)
                .updated_at(this.updated_at)
                .build();
    }
}
