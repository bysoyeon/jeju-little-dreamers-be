package samdasu.jejuddai.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {

    //클래스명 바꿔야 할 듯ㅠㅠ StoreResponseDTO
    private Long id; // 가게 아이디

    private String name; // 가게명
    
    private double latitude; // 위도

    private double longitude; // 경도

    private String address; // 가게 주소

    private String phone; // 가게 연락처

    private String category; // 가게 카테고리

    private String image; // 가게 이미지
}
