package org.hogari.ecommerce.hogari.logIn;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//	
@RestController //estamos diciendo a nuestro controlador que va a manejar la entidad  y  en este caso vamos a utilizar metodos como GET, POST, PUT Y DELETE
//	
@RequestMapping(path="/api/logIn/")


public class logInController {

	//Variable del tipo productoService llamada prodService
			private final logInService logService;
//			
			@Autowired  //Es para el contexto, por que nosotros no podemos instanciar objetos
//			//cuando la api este desplegada se ttiene que definir todo desde antes.
//			
			//constructor
			public logInController(logInService logService) {
				this.logService = logService;
			}// constrructor
				
			///////////////////////////////////////////////////////////

			//Aqui empiezan las solicitudes
					
			@GetMapping 
			public List<logIn> getLogIns(){
				return logService.getLogIns();
			} //getLogIn
			
			
			
			// solicitud get
			@GetMapping (path="{logId}")
			public logIn getLogIn(@PathVariable("logId")Long logId) {
				
				return logService.getLogIn(logId);
			}// get productos
			
			
			//metodo post para crear nuevos logIn
			@PostMapping 
			public void addLogIn(@RequestBody logIn log) {
				logService.addLogIn(log);			
			}// add usuario logIn
			
			
			
			//Metodo PUT para modificar un usuario ya existente
			@PutMapping (path="{logId}")
			public void updateLogIn(@PathVariable("logId")Long logId,
				
				@RequestParam (required = false) String nombre,
				@RequestParam (required = false) String contrasena){
				logService.updateLogIn (logId, nombre, contrasena);						
		}// modificar usuario logIn
			
			
		 
			@DeleteMapping (path="{logId}")
			public void deleteLogIn(@PathVariable("logId")Long logId){
				
				logService.deletelogIn(logId);
			}

	
}
