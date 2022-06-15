package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import model.logIn;

@Service
public class logInService {

	private final logInRepository loginRepository;
	
	// Inicializamos
	@Autowired
	public logInService(logInRepository loginRepository) {
		this.loginRepository=loginRepository;
	}

	// Comenzar a utilizar metodos de nuestro Repository
	// Get productos
	public List<logIn> getLogIn() {
		return loginRepository.findAll();
	}

	// Get producto
	public logIn getLogIn(Long logId) {
		return loginRepository.findById(logId).orElse(null);
	}

	// SET producto
	public void addLogIn(logIn log) {
		// Verificar si existe
		Optional<logIn> logInByName = loginRepository.findByName(log.getNombre());
		if(logInByName.isPresent()) {
			throw new IllegalStateException("El producto ya existe"); // Lanza error en caso de que exista
		} else {
			loginRepository.save(log); // Guarda los datos en caso de que no exista
		}	
	}

	// Revisamos si existe el producto
	// If true = se elimina
	// If false = no se elimina y lanzamos exception
	public void deleteLongId(Long logId) {
		if(loginRepository.findById(logId) != null) {
			loginRepository.deleteById(logId);
		} else {
			throw new IllegalStateException("El producto no existe");
		}
	}

	public void updateLongId(Long logId,String nombre,String contrasena) {
		// Verifica si existe
		if(loginRepository.findById(logId) != null) {
			// Vamos a setear cada parametro
			logIn p = loginRepository.findById(logId).get();
			if(nombre != null) p.setNombre(nombre);
			if(contrasena != null) p.setContrasena(contrasena);
			// Guardamos de forma persistente
			loginRepository.save(p);
		} else {
			// Lanzamos exception
			throw new IllegalStateException("El producto no existe");
		}
	}
	}


