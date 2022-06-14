package org.hogari.ecommerce.hogari.Users;



public class users {
//Atributos
	private String name;
	private String lastname;
	private int number;
	private String email;
	private String password;
	private String arrendador;
	private String  imagen;
	private int id;
	private static int total=0;
	
	
//Fin atributos
	
	
	
//Constructor
	public users(String name, String lastname, int number, String email, String password, String arrendador,
			String imagen) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.number = number;
		this.email = email;
		this.password = password;
		this.arrendador = arrendador;
		this.imagen = imagen;
	}//Final Constructor

	//Constructor vacío
	public users() {
		super();
		total++; 
		this.id=total;
	}

	
	
	//Getters y Setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String isArrendador() {
		return arrendador;
	}

	public void setArrendador(String arrendador) {
		this.arrendador = arrendador;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	//Cierra Getters y Setters
	
	
	//toString
	@Override
	public String toString() {
		return "users [name=" + name + ", lastname=" + lastname + ", number=" + number + ", email=" + email
				+ ", password=" + password + ", arrendador=" + arrendador + ", imagen=" + imagen + "]";
	}

	
	
	

	
	

	
	
	
	
	
}
