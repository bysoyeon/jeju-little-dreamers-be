package samdasu.jejuddai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samdasu.jejuddai.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
