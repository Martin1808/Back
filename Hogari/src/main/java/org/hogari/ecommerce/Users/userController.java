package org.hogari.ecommerce.Users;

import java.util.ArrayList;

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

@RestController

@RequestMapping(path="/api/user/")
public class userController {
	
	
	
	@Autowired
	
	
//Constructor
	
	private final userService usService;
	public userController(userService usService) {
		this.usService = usService;
		
	}
	
	
	
	@GetMapping  //
	public ArrayList<users> getusers(){
		return usService.getusers();
	}
	
	
	@GetMapping (path="{userId}") //
	public users getusers(@PathVariable("userId")Long userId){
		return usService.getusers(userId);
	}//getProductos

	
	
	
	@PostMapping  
	public void addUsers(@RequestBody users user) {
		usService.addUsers(user);
	}
	

	@PutMapping(path="{userId}")
	public void updateUsers(@PathVariable("userId")Long userId,
			@RequestParam (required = false) String email,
			@RequestParam (required = false) String name,
			@RequestParam (required = false) String lastname,
			@RequestParam (required = false) int number,
			@RequestParam (required = false) String password){
			usService.updateUsers(userId,email,name,lastname,number,password);
		}//updateProducto

	
	@DeleteMapping (path="{userId}")
	public void delUsers(@PathVariable("userId")Long userId) 
	{
		usService.delUsers(userId);}

	
	
	
}
