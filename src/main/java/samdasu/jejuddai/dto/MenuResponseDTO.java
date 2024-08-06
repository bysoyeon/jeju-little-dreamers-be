package samdasu.jejuddai.dto;

import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponseDTO {
    private Long id; // 메뉴 아이디
    private String name; // 메뉴 이름
    private int price; // 메뉴 가격
    private Long store_id; // 가게 아이디
    private String store_name; // 가게명

}
