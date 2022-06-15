package Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Service.userService;
import model.users;

@RestController

@RequestMapping(path = "/api/users/")
@CrossOrigin(origins = "*")
public class userController {
private final userService usService;
	
	@Autowired
	public userController(userService usService) {
		this.usService = usService;
	}
	
/////////////////////////////////////////////////////////
	////Solicitudes
	
	

	@GetMapping //Para llamar todos los elementos 
	public List<users> getUsers() {
		return usService.getUsers();
	}

	
	
	@GetMapping(path = "{userId}") //
	public users getUsers(@PathVariable("userId") Long userId) {
		return usService.getUsers(userId);
	}// getProductos

	
	
	@PostMapping
	public void addUsers(@RequestBody users us) {
		usService.addUsers(us);
	}

	
	@PutMapping(path = "{userId}")
	public void updateUsers(@PathVariable("userId") Long userId, 

@RequestParam(required = false) String name, @RequestParam(required = false) String lastname,
@RequestParam(required = false) int number, 
@RequestParam(required = false) String email,
@RequestParam(required = false) String password,
@RequestParam(required = false) String arrendador,
@RequestParam(required = false) String imagen){
		
usService.updateUsers(userId,name, lastname, number,  email,password,arrendador, imagen);
	}// updateProducto

	@DeleteMapping(path = "{userId}")
	public void delUsers(@PathVariable("userId") Long userId) {
		usService.deleteUsers(userId);
	}
}
