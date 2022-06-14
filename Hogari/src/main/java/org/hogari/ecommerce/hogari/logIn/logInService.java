package org.hogari.ecommerce.hogari.logIn;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
//

@Service
//constructor lista usuarios logIn
public class logInService {
	public final ArrayList<logIn> lista = new ArrayList<logIn>();

	public logInService() {
		
		lista.add(new logIn("Mario",
				"Contrasena123")
				);
		lista.add(new logIn("Karla",
				"Dificil123")
				);
		lista.add(new logIn("Guillermo",
				"11Generation")
				);
		}//Se cierra constructor
	
	
	
	//Metodo para traer todos los usuarios logIn
	
	public ArrayList<logIn> getLogIns(){
		return lista;
	}


	//metodo para traer todos los usuarios logIn por id
	public logIn getLogIn(Long logId) {
		logIn tmpLog=null;// Esto es para evitar el error 404
		for (logIn log : lista) {
			if(log.getId()==logId) {
				tmpLog= log;
		}//if
	}//foreach
		return tmpLog;
	}//get usuarios login



	//Metodo para agregar usuarios login
	public void addLogIn(logIn log) {
		lista.add(log);	
	}// metodo add



	//Metodo para modificar valores de un usuario login existente (con validaciones)
	public void updateLogIn(Long logId, String nombre, String contrasena) {
		for (logIn log : lista) {
			if(log.getId()==logId) {
				if(nombre!=null) log.setNombre(nombre);
				if(contrasena !=null) log.setContrasena(contrasena);
				}//if
		}//foreach
	}//update



	//Metdo Delete usuario logIn
	public void deletelogIn(Long logId) {
		for (logIn log : lista) {
			if(log.getId()==logId) {
				lista.remove(log);
				break;
			}//if		
		}//foreach			
	}// Delete

}
