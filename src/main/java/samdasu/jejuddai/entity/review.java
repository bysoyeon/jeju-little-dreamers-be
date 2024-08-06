package samdasu.jejuddai.entity;

import jakarta.persistence.*;
import samdasu.jejuddai.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

@Entity
public class review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private store store;

    private int grade;
    private String content;
    private String image;//이미지 모르겟어여
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    public ReviewResponseDTO toResponseDTO() {
        return ReviewResponseDTO.builder()
                .id(this.id)
                .user_id(this.user.getId())
                .user_nickname(this.user.getNickname())
                .store_id(this.store.getId())
                .store_name(this.store.getName())
                .grade(this.grade)
                .content(this.content)
                .image(this.image)
                .updated_at(this.updated_at)
                .build();
    }
}
