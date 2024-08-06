package samdasu.jejuddai.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDTO {
    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    private double radius; // 1미터 단위 - 이후 확인 필요
}
