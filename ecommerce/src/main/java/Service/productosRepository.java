package Service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import model.productos;
import org.springframework.data.jpa.repository.Query;

public interface productosRepository extends JpaRepository<productos,Long>{
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	Optional<productos> findByName(String nombre);
}
