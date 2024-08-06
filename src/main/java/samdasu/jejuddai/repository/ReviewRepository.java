package samdasu.jejuddai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samdasu.jejuddai.entity.Review;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStoreId(String storeId);

}
