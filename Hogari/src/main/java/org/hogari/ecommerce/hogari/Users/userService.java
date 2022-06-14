package org.hogari.ecommerce.hogari.Users;


import org.springframework.stereotype.Service;
import java.util.ArrayList;




@Service
public class userService {
	public final ArrayList<users> lista= new ArrayList<users>();
	public userService() { 
		lista.add(new users("Sandra","Ruiz",5555555,"ejemplo@gmail.com","sandra123","si","nam.jgp")
				 );
		lista.add(new users("Sandra","Ruiz",5555555,"ejemplo@gmail.com","sandra123","si","nam.jgp")
				 );
		lista.add(new users("Sandra","Ruiz",5555555,"ejemplo@gmail.com","sandra123","si","nam.jgp")
				 );
	}//Contructor		
		
		
//Get para llamar a todos los elementos 
	public ArrayList<users> getUsers(){
		return lista;
	}
	
	
	//metodo  GET para traer producto por id usando un foreach para recorrer todos los objetos
	

	public users getUsers(Long userId) {
		users tmpUser = null;
		for (users user : lista) {
		if(user.getId() == userId) {
			tmpUser = user;
			}//if
	}//foreach
	return tmpUser;
		
	}//getProducto

	
	
	//POST
	public void addUsers(users us) {
		lista.add(us);	
	}//Termina post

	
	
	//PUT
	public void updateUsers(Long userId, String name, String lastname, int number, String email, String password,
			String arrendador, String imagen) {
		for (users user :lista) {
     		if(user.getId() == userId) {
				if (name!=null) user.setName(name);
				if (name!=null) user.setLastname(lastname);
				if (number!=0)user.setNumber(number);
				if (email!=null) user.setEmail(email);
				if (password!=null)user.setPassword(password);
				if (arrendador!=null) user.setArrendador(arrendador);
				if (imagen!=null) user.setImagen(imagen);
			}//if
		}//foreach	
		
	}//Termina put

	
	//DELETE
	public void deleteUsers(Long userId) {
		for(users us:lista) {
			if(us.getId()==userId) {
				lista.remove(us);
				break;
			}//if
		}	//foreach
	}//Termina delete 



}//Class userService

