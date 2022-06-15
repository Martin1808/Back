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
@Table(name="productos")
public class productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProductos", unique = true, nullable = false)
	private String nombre_archivo;
	private String URL;
	//Esto es para darle un ID al producto
	private int id = 0;
	private static int total = 0;
	
	
	@OneToMany(mappedBy= "inmueble")
	@JsonManagedReference
	private inmueble categoria;
	//constructor
	public productos(String nombre_archivo,String URL) {
		super();
		total ++;
		this.id = total;
		this.nombre_archivo = nombre_archivo;
		this.URL = URL;
	} //constructor
	
	
	//Constructor vacio para agregar productos
	
	public productos () {}
	
	


	
	public int getId() {
		return id;
	}


	// setters y getters 
	public String getNombre_archivo() {
		return nombre_archivo;
	}


	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}


	public String getURL() {
		return URL;
	}


	public void setURL(String uRL) {
		URL = uRL;
	} //setters y getters






	@Override
	public String toString() {
		return "productos [nombre_archivo=" + nombre_archivo + ", URL=" + URL + "]";
	}

	
	
	
}
