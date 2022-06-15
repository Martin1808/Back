package Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.productos;

@Service
public class productosService {
	// Definimos repositorio
	private final productosRepository productosRepository;
	
	// Inicializamos
	@Autowired
	public productosService(productosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}

	// Comenzar a utilizar metodos de nuestro Repository
	// Get productos
	public List<productos> getProductos() {
		return productosRepository.findAll();
	}

	// Get producto
	public productos getProducto(Long prodId) {
		return productosRepository.findById(prodId).orElse(null);
	}

	// SET producto
	public void addProducto(productos prod) {
		// Verificar si existe
		Optional<productos> productoByName = productosRepository.findByName(prod.getNombre_archivo());
		if(productoByName.isPresent()) {
			throw new IllegalStateException("El producto ya existe"); // Lanza error en caso de que exista
		} else {
			productosRepository.save(prod); // Guarda los datos en caso de que no exista
		}	
	}

	// Revisamos si existe el producto
	// If true = se elimina
	// If false = no se elimina y lanzamos exception
	public void deleteProducto(Long prodId) {
		if(productosRepository.findById(prodId) != null) {
			productosRepository.deleteById(prodId);
		} else {
			throw new IllegalStateException("El producto no existe");
		}
	}

	public void updateProducto(Long prodId, String nombre_archivo, String url) {
		// Verifica si existe
		if(productosRepository.findById(prodId) != null) {
			// Vamos a setear cada parametro
			productos p = productosRepository.findById(prodId).get();
			if(nombre_archivo != null)p.setNombre_archivo(nombre_archivo);;
			if(url!=null)p.setURL(url);
			// Guardamos de forma persistente
			productosRepository.save(p);
		} else {
			// Lanzamos exception
			throw new IllegalStateException("El producto no existe");
		}
	}
}
