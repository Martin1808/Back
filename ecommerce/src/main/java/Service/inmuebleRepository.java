package Service;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.inmueble;

public interface inmuebleRepository extends JpaRepository<inmueble,Long>{
	@Query("SELECT p FROM Producto p WHERE p.id=?1")
	Optional<inmueble>findByName(int inId);
}
