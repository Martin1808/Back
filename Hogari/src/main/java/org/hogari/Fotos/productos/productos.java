//Esta es la clase para poder crear productos. En productos nosotros creamos nuestra clase con atributos para posteriormente ir creando o ir modificando productos.
//A este ni vel sabemos que para crear un objeto, necesitamos una clase solida (que tenga propiedades, metodos, getters, setters, toString

package org.hogari.Fotos.productos;

public class productos {

	//propiedades
	private String nombre_archivo;
	private String URL;
	//Esto es para darle un ID al producto
	private int id = 0;
	private static int total = 0;
	
	
	//constructor
	public productos(String nombre_archivo,String URL) {
		super();
		total ++;
		this.id = total;
		this.nombre_archivo = nombre_archivo;
		this.URL = URL;
	} //constructor
	
	
	//Constructor vacio para agregar productos
	
	public productos () {
		super();
		total ++;
		this.id= total;
		
	}
	
	


	
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
