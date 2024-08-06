package samdasu.jejuddai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samdasu.jejuddai.entity.menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<menu, Long> { List<menu> findByStoreId(Long storeId);
}
