package org.hogari.ecommerce.Users;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class userService {
	public final ArrayList<users> lista= new ArrayList<users>();
	public userService() {
		lista.add(new users("ejemplo@gmail.com","Sandra","Ruiz",5555555,"sandra123")
				 );
		

	}
	
	public ArrayList<list> get(){
		return lista;
	}
	
//	public List<producto> getProductos() {
//		// TODO Auto-generated method stub
//		return lista;
//	}

}

