package org.hogari.ecommerce.hogari.Users;

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

@RestController

@RequestMapping(path = "/api/usuario/")
@CrossOrigin(origins="*")
public class userController {

	//constante
	public final userService usService;
	
	@Autowired
	public userController(userService usService) {
		this.usService = usService;
	}//constructor

	
	//GET para todos los usuarios
	@GetMapping
	public List<users> getUsuarios(){
		return usService.getUsers();
	}//get para todos los usuarios
	
	
	//GET para usuario por id
	@GetMapping(path = "{userId}")
	public users getUser(@PathVariable("userId") Long userId) {
		return usService.getUser(userId);
	}//get para un usuario por id
	
	
	//DELETE para borrar usuarios
	@DeleteMapping(path="{userId}")
	public void deleteUsuario(@PathVariable ("userId") Long userId) {
		usService.deleteUser(userId);
	}//deleteUsuario
	

	//POST para agregar nuevos usuarios
	@PostMapping
	public void addUsuario(@RequestBody users user) {
		usService.addUsuario(user);
	}//addUsuario
	
	
	//PUT para actualizar nuevos usuarios
	@PutMapping(path = "{userId}")
	public void updateUsuario(@PathVariable("userId") Long userId,
			@RequestParam(required = false) String currentPassword,
			@RequestParam(required = false) String newPassword) {
		this.usService.updateUser(userId, currentPassword, newPassword);
	}//updateUsuario

	
	
	
	
	
	
	
	
	//DELETE
	//POST
	//PUT
	
}
