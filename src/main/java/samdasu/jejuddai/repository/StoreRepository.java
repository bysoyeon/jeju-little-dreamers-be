package samdasu.jejuddai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samdasu.jejuddai.entity.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, String> {
//    List<Store> findByCategoryAndLatitudeBetweenAndLongitudeBetween(String category, double latStart, double latEnd, double lonStart, double lonEnd);

    // 카테고리 제거
    List<Store> findByLatitudeBetweenAndLongitudeBetween(double latStart, double latEnd, double lonStart, double lonEnd);

}
