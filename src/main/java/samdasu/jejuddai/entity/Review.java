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
    private String image;//이미지 모르겟어여
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    public ReviewDTO toResponseDTO() {
        return ReviewDTO.builder()
                .id(this.id)
                .user_id(this.user.getId())
                .user_nickname(this.user.getNickname())
                .store_id(this.store.getId())
                .grade(this.grade)
                .content(this.content)
                .image(this.image)
                .updated_at(this.updated_at)
                .build();
    }
}
