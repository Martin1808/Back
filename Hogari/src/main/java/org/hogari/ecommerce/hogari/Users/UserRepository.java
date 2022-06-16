package org.hogari.ecommerce.hogari.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
public interface UserRepository extends JpaRepository<users,Long>{
	@Query("SELECT u FROM users u WHERE u.username=?1")
	Optional<users> findByUsername(String username); 
}
