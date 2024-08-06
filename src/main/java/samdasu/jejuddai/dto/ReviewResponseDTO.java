package samdasu.jejuddai.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewResponseDTO {
    private Long id;
    private Long user_id; // 유저 id (작성자)
    private String user_nickname; // 유저 닉네임(작성자)
    private Long store_id; // 가게 id
    private String store_name; // 가게명
    private int grade; // 등급
    private String content; // 리뷰 내용
    private String image;// 리뷰 이미지
    private LocalDateTime updated_at; // 최근 수정 날짜
}
