package org.hogari.ecommerce.hogari.productos;

public class productos {

	//propiedades
		private String nombre_archivo;
		private String URL;
		private String descripcion;
		private double precio;
		//Esto es para darle un ID al producto
		private int id = 0;
		private static int total = 0;
		
		
		//constructor
		public productos(String nombre_archivo,String URL,String descripcion,double precio) {
			super();
			total ++;
			this.id = total;
			this.nombre_archivo = nombre_archivo;
			this.URL = URL;
			this.descripcion=descripcion;
			this.precio=precio;
		} //constructor
		
		
		//Constructor vacio para agregar productos
		
		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public double getPrecio() {
			return precio;
		}


		public void setPrecio(double precio) {
			this.precio = precio;
		}


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
			return "productos [nombre_archivo=" + nombre_archivo + ", URL=" + URL + ", descripcion=" + descripcion
					+ ", precio=" + precio + ", id=" + id + "]";
		}




}
