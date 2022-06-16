package org.hogari.ecommerce.hogari.Users;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="usuario")//debe llamarse algo distinto de "user", por que esta es palabra reservada
public class users {
//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	
	//Parametros del usuario
	private Long id;
	private String username;
	private String password;
	
	//1. constructor
	//1.1 constructor vacio
	//2. getters y setters
	//3. toString
	
	//constructor
	public users(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}//constructor

	//constructor vacio o por default
	public users() {
		super();
	}//constructor vacio
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	//toString
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}//toString
	

	
	
	
}
