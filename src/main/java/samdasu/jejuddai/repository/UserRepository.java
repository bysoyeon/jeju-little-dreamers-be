package samdasu.jejuddai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samdasu.jejuddai.entity.user;

public interface UserRepository extends JpaRepository<user, Long>{

}
