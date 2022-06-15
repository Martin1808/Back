package Service;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import model.inmueble;
import model.logIn;

public interface logInRepository extends JpaRepository<logIn, Long>{
	@Query("SELECT p FROM Producto p WHERE p.id=?1")
	Optional<logIn>findByName(String logIn);
}
