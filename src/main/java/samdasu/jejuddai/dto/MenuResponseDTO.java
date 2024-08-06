package samdasu.jejuddai.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuResponseDTO {
    private Long id; // 메뉴 아이디
    private String name; // 메뉴 이름
    private int price; // 메뉴 가격
    private Long store_id; // 가게 아이디
    private String store_name; // 가게명

}
