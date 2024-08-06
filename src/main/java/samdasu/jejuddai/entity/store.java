package samdasu.jejuddai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import samdasu.jejuddai.dto.ReviewResponseDTO;
import samdasu.jejuddai.dto.StoreResponseDTO;

@Entity
@Getter
public class store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String category;
    private double latitude;
    private double longitude;
    private String image;

    public StoreResponseDTO toResponseDTO() {
        return StoreResponseDTO.builder()
                .id(this.id)
                .name(this.name)
                .latitude(this.latitude)
                .longitude(this.longitude)
                .address(this.address)
                .phone(this.phone)
                .category(this.category)
                .image(this.image)
                .build();
    }


}
