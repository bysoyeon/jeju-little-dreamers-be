package samdasu.jejuddai.entity;

import jakarta.persistence.*;
import lombok.Getter;
import samdasu.jejuddai.dto.StoreResponseDTO;

@Entity
@Getter
@Table(name = "store")
public class Store {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
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
