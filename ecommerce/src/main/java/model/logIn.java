package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="logIn")
public class logIn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLogIn", unique = true, nullable = false)
	private String nombre;
	private String contrasena;	
	private int id;
	private static int total =0;
	@OneToMany(mappedBy= "users")
	@JsonManagedReference
	
	private users categoria;
	//Constructor	
	public logIn(String nombre, String contrasena) {
		super();
		total ++;
		this.id=total;		
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public logIn(){}
	
	
	//Getters y Setters

	public int getId() {
	return id;
	}//get id
	public String getNombre() {
		return nombre;
	}//get nombrre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//set nombre
	public String getContrasena() {
		return contrasena;
	}// get contrasena
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	//set contrasena
	



	@Override
	public String toString() {
		return "logIn [nombre=" + nombre + ", contrasena=" + contrasena + "]";
	}//to string


	//Constructor vacio
	

}
