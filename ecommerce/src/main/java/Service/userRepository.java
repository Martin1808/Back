package Service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import model.users;

public interface userRepository extends  JpaRepository<users, Long>{
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	Optional<users> findByName(String users);
}
