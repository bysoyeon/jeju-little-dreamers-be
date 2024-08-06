package samdasu.jejuddai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samdasu.jejuddai.entity.review;
import samdasu.jejuddai.entity.store;

import java.util.List;

public interface StoreRepository extends JpaRepository<store, Long> {
    List<store> findByCategoryAndLatitudeBetweenAndLongitudeBetween(String category, double latStart, double latEnd, double lonStart, double lonEnd);
}
