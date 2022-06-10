package org.hogari.ecommerce.Users;

public class users {
//Atributos
	private String email;
	private String name;
	private String lastname;
	private int number;
	private String password;
	private int id;
	private static int total=0;
	
	
//Fin atributos
	
	
	
//Constructor
	public users(String email, String name, String lastname, int number, String password) {
		super();
		total++;
		this.id=total;
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.number = number;
		this.password = password;
	}//Final Constructor

	//Constructor vacío
	public users() {
		super();
		total++; 
		this.id=total;
	}
	
	
//Getters y Setters
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}//Final Getters y Setters 

	
//tostring

	@Override
	public String toString() {
		return "users [email=" + email + ", name=" + name + ", lastname=" + lastname + ", number=" + number
				+ ", password=" + password + "]";
	}
	
	

	
	
	
	
	
}
