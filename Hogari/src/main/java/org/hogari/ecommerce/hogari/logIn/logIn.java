package org.hogari.ecommerce.hogari.logIn;

public class logIn {
	//propiedades
	
		private String nombre;
		private String contrasena;	
		private int id;
		private static int total =0;
		
		//Constructor	
		public logIn(String nombre, String contrasena) {
			super();
			total ++;
			this.id=total;		
			this.nombre = nombre;
			this.contrasena = contrasena;
		}

		
		
		
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
		public logIn() {
			super();
			total ++;
			this.id=total;
		}// termina constructor vacio para post

}
