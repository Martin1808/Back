package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.users;

@Service
public class userService {
	private final userRepository usRepository;
		
//Get para llamar a todos los elementos 
	// Definimos repositorio
		
		// Inicializamos
		@Autowired
		public userService(userRepository usRepository) {
			this.usRepository=usRepository;
		}

		// Comenzar a utilizar metodos de nuestro Repository
		// Get productos
		public List<users> getUsers() {
			return usRepository.findAll();
		}

		// Get producto
		public users getUsers(Long usId) {
			return usRepository.findById(usId).orElse(null);
		}

		// SET producto
		public void addUsers(users us) {
			// Verificar si existe
			Optional<users> usersByName = usRepository.findByName(us.getName());
			if(usersByName.isPresent()) {
				throw new IllegalStateException("El producto ya existe"); // Lanza error en caso de que exista
			} else {
				usRepository.save(us); // Guarda los datos en caso de que no exista
			}	
		}

		// Revisamos si existe el producto
		// If true = se elimina
		// If false = no se elimina y lanzamos exception
		public void deleteUsers(Long usId) {
			if(usRepository.findById(usId) != null) {
				usRepository.deleteById(usId);
			} else {
				throw new IllegalStateException("El producto no existe");
			}
		}

		public void updateUsers(Long userId , String name,String lastname,int number,String  email,String password,String arrendador,String imagen) {
			// Verifica si existe
			if(usRepository.findById(userId) != null) {
				// Vamos a setear cada parametro
				users p = usRepository.findById(userId).get();
				if(name!=null)p.setName(name);
				if(lastname!=null)p.setLastname(lastname);
				if(number!=0)p.setNumber(number);
				if(arrendador!=null)p.setArrendador(arrendador);
				if(email!=null)p.setEmail(email);
				if(password!=null)p.setPassword(password);
				if(imagen!=null)p.setImagen(imagen);
				// Guardamos de forma persistente
				usRepository.save(p);
			} else {
				// Lanzamos exception
				throw new IllegalStateException("El producto no existe");
			}
		}
		

}
