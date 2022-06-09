package org.hogari.ecommerce.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(path="/api/user/")

@RestController

public class useController {
	
	@Autowired
//Constructor
	
	private final usersService usService;
	public userController(userService usService) {
		this.usService = usService;
		
	}
	
	@GetMapping
	public ArrayList<user> getuser(){
		return user
	}
	
	
	
	
	
	
	
	
	
	
	
}
