package org.hogari.ecommerce.Users;


import org.springframework.stereotype.Service;
import java.util.ArrayList;



@Service
public class userService {
	public final ArrayList<users> lista= new ArrayList<users>();
	public userService() { 
		lista.add(new users("ejemplo@gmail.com","Sandra","Ruiz",5555555,"sandra123")
				 );
		
			lista.add(new users("ejemplo1@gmail.com","Ivan","Lopez",525555,"s23")
					 );
		
				lista.add(new users("ejemplo2@gmail.com","Martin","Sol",555528,"4567")
						 );

	}
	
	public ArrayList<users> getusers(){
		return lista;
	}
	
	
	//metodo para traer producto por id usando un foreach para recorrer todos los objetos
	
	public users getusers(Long userId) {
		
		users tmpUser = null;
		for (users user : lista) {
			if(user.getId() == userId) {
				tmpUser = user;
			}//if
		}//foreach
		return tmpUser; //dejamos el return fuera del foreach por si no encuentra un producto, pueda terminar de forma correcta
		
	}//getProducto

	
	
	//POST
	
	public void addUsers(users user) {
		lista.add(user);
		
	}

	
	
	//PUT
	
	
	public void updateUsers (Long userId,String email, String name, String lastname, int number, String password) {
		for (users user :lista) {
			if(user.getId() == userId) {
				if (email!=null) user.setEmail(email);
				if (name!=null) user.setName(name);
				if (name!=null) user.setLastname(lastname);
				if (number!=0)user.setNumber(number);
				if (password!=null)user.setPassword(password);
			}//if
		}//foreach

		
	}

	
	//DELETE
	public void delUsers(Long userId) {
		for(users user:lista) {
			if(user.getId()==userId) {
				lista.remove(user);
				break;
			}
		}

		
	}

	
	
	

	


}

