package org.hogari.ecommerce.hogari.inmbueble;

public class inmueble {
	private String ciudad;
	private String direccion;
	private String tipoInmueble;
	private int nPersona;
	private String mascotas;
	private String descripcion;
	private String dimensiones;
	private double precio;
	private String imagen;
	
	private int id;
	private static int total=0;
	
	
	public inmueble(String ciudad, String direccion, String tipoInmueble, int nPersona, String mascotas,
			String descripcion, String dimensiones, double precio, String imagen) {
		super();
		total ++;
		this.id = total;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.tipoInmueble = tipoInmueble;
		this.nPersona = nPersona;
		this.mascotas = mascotas;
		this.descripcion = descripcion;
		this.dimensiones = dimensiones;
		this.precio = precio;
		this.imagen = imagen;
		
	}




	
	public inmueble() {
		super();
		total++;
		this.id = total;
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





	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	public int getnPersona() {
		return nPersona;
	}
	public void setnPersona(int nPersona) {
		this.nPersona = nPersona;
	}
	public String getMascotas() {
		return mascotas;
	}
	public void setMascotas(String mascotas) {
		this.mascotas = mascotas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "inmueble [ciudad=" + ciudad + ", direccion=" + direccion + ", tipoInmueble=" + tipoInmueble
				+ ", nPersona=" + nPersona + ", mascotas=" + mascotas + ", descripcion=" + descripcion
				+ ", dimensiones=" + dimensiones + ", precio=" + precio + "]";
	}

	
	
	
}
