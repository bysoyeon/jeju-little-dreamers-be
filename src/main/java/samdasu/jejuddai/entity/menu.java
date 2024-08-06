package samdasu.jejuddai.entity;

import jakarta.persistence.*;
import samdasu.jejuddai.dto.MenuResponseDTO;

@Entity
public class menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name="store_id")
    private store store;

    private String name;
    private int price;
//
//    public MenuResponseDTO toResponseDTO() {
//        return MenuResponseDTO.builder()
//                    .id(this.id)
//                    .store_id(this.store.getId())
//                    .name(this.name)
//                    .price(this.price)
//                    .build();
//    }
}
