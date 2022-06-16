package org.hogari.ecommerce.hogari.logIn;
import org.hogari.ecommerce.hogari.Users.userService;
import org.hogari.ecommerce.hogari.Users.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//	
@RestController //estamos diciendo a nuestro controlador que va a manejar la entidad  y  en este caso vamos a utilizar metodos como GET, POST, PUT Y DELETE
//	
@RequestMapping(path="/api/logIn/")
@CrossOrigin(origins="*")

public class logInController {


	private final userService usService;

	@Autowired
	public logInController(userService usService) {
		super();
		this.usService=usService;
	}//constructor
	
	
	@PostMapping
	public String Login(@RequestBody users user) { //pasamos parametros 
		String resultado = "Nombre de usuario o contrasenia incorrectos"; //resultado si no es correcto
		if(usService.login(user.getUsername(), user.getPassword())){ //if para validar username y password
			resultado = "Ok, las contrasenias coinciden, bienvenid@"; //resultado si es correcto
		}//if
		return resultado;
	}//Login
	

}
