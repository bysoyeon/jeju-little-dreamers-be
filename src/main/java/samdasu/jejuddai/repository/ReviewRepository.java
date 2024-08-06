package samdasu.jejuddai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samdasu.jejuddai.entity.review;
import samdasu.jejuddai.entity.store;

import java.util.List;


public interface ReviewRepository extends JpaRepository<review, Long> {
    List<review> findByStoreId(Long storeId);
}
