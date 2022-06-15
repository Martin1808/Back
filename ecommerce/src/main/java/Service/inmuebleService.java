package Service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import model.inmueble;



public class inmuebleService {
private final inmuebleRepository inRepository;
	
	// Inicializamos
	@Autowired
	public inmuebleService(inmuebleRepository inRepository) {
		this.inRepository = inRepository;
	}

	// Comenzar a utilizar metodos de nuestro Repository
	// Get productos
	public List<inmueble> getInmueble() {
		return inRepository.findAll();
	}

	// Get producto
	public inmueble getInmueble(Long inId) {
		return inRepository.findById(inId).orElse(null);
	}

	// SET producto
	public void addInmueble(inmueble in) {
		// Verificar si existe
		Optional<inmueble> inByName = inRepository.findByName(in.getId());
		if(inByName.isPresent()) {
			throw new IllegalStateException("El producto ya existe"); // Lanza error en caso de que exista
		} else {
			inRepository.save(in); // Guarda los datos en caso de que no exista
		}	
	}

	// Revisamos si existe el producto
	// If true = se elimina
	// If false = no se elimina y lanzamos exception
	public void deleteInmueble(Long inId) {
		if(inRepository.findById(inId) != null) {
			inRepository.deleteById(inId);
		} else {
			throw new IllegalStateException("El producto no existe");
		}
	}

	public void updateInmueble(Long inId, String ciudad, String direccion, String tipoInmueble, int nPersona,String mascotas, String descripcion , String dimensiones, double precio,String imagen) {
		// Verifica si existe
		if(inRepository.findById(inId) != null) {
			// Vamos a setear cada parametro
			inmueble p = inRepository.findById(inId).get();
			if(ciudad != null) p.setCiudad(ciudad);
			if(direccion != null) p.setDireccion(direccion);
			if(tipoInmueble != null) p.setTipoInmueble(tipoInmueble);
			if(nPersona != 0) p.setnPersona(nPersona);
			if(mascotas != null) p.setMascotas(mascotas);
			if(descripcion != null) p.setDescripcion(descripcion);
			if(precio!=0)p.setPrecio(precio);
			if(imagen != null) p.setImagen(imagen);
			// Guardamos de forma persistente
			inRepository.save(p);
		} else {
			// Lanzamos exception
			throw new IllegalStateException("El producto no existe");
		}
	}
}
