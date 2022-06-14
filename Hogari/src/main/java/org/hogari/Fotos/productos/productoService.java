//En el producto Service nosotros estamos creando una "peque;a" base de datos, esto con la finalidad de tener cirtas entidades (productos, doctores,playeras,inmuebles, negocios, usuarios con mascotas, etc)
//Estas entidades tomaran los datos o atributos de la clase a la que se refieren (por ejemplo, si hablamos de productos, vamos a tomar los datos de la clase productos, y asi con cada entidad.
//En este caso creamos nuestras entidades con un array list.



package org.hogari.Fotos.productos;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

// DFebemos agregar la anotacion service, para que spring pueda identificar que esta clase es para crear un servicio. En esta capa vamos a crear todo nuestro listado de productos, mismo que sera modificado segun el metodo que utilicemos. Para esto, tambien tenemos que crear un constructor vacio para instanciar la lista


@Service
public class productoService {
	public final ArrayList<productos>lista = new ArrayList <productos>();
	
	public productoService() {
		lista.add(new productos("Casa 1",  "Casa1.jpg"));
		lista.add(new productos("Casa 2",  "Casa2.jpg"));
		lista.add(new productos("Casa 3",  "Casa3.jpg"));
		lista.add(new productos("Casa 4",  "Casa4.jpg"));
		lista.add(new productos("Casa 5",  "Casa5.jpg"));
		
	}//constructor
	
	
	//metodo para traer todos los productos
	
	 public ArrayList<productos> getProductos(){
		 return lista;
	 }//GetProductos

	 
	 //Metodo para ttraer un solo producto
	 
	 public productos getProducto(Long prodId) {
		 productos tmpProd = null;
		 for (productos prod : lista) {
			 if(prod.getId() == prodId) {
				 tmpProd = prod;}//if}//foreachreturn tmpProd; //dejamos el return fuera del foreach por si no encuentra un producto, pueda terminar de forma correcta}//getProducto
		 }
		return tmpProd;
	 } //metodo para traer un objeto por ID

	 //Metodo para agregar productos a la lista

	public void addProductos(productos prod) {
		lista.add(prod);
		
	} //metodo add producto

	//metodo para modificar valores de un producto existente (con validaciones)
	public void updateProducto(Long prodId, String nombre_archivo, String URL) {
		for (productos prod : lista) {
			if(prod.getId() == prodId) {
				if (nombre_archivo!=null) prod.setNombre_archivo(nombre_archivo);
				if (URL != null) prod.setURL (URL);	
			}//if
		}//foreach
	}//update products


	public void deleteProducto(Long prodId) {
		for (productos prod: lista) {
			if (prod.getId() == prodId) {
				lista.remove(prod);
				break;
			}
		}
		
	}
	 

	 
	 
}// class product service
