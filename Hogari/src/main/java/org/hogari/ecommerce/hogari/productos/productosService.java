package org.hogari.ecommerce.hogari.productos;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

// DFebemos agregar la anotacion service, para que spring pueda identificar que esta clase es para crear un servicio. En esta capa vamos a crear todo nuestro listado de productos, mismo que sera modificado segun el metodo que utilicemos. Para esto, tambien tenemos que crear un constructor vacio para instanciar la lista


@Service
public class productosService {
public final ArrayList<productos>lista = new ArrayList <productos>();
	
	public productosService() {
		lista.add(new productos("Casa 1",  "https://englishlive.ef.com/es-mx/blog/wp-content/uploads/sites/8/2019/03/partes-de-la-casa-en-ingles.jpg","un excelente lugar para cambiarte e inicar una vida",1000000.00));
		lista.add(new productos("Casa 2",  "https://englishlive.ef.com/es-mx/blog/wp-content/uploads/sites/8/2019/03/partes-de-la-casa-en-ingles.jpg","Es un buen vecindario en una buena ciudad",750000.00));
		lista.add(new productos("Casa 3",  "https://englishlive.ef.com/es-mx/blog/wp-content/uploads/sites/8/2019/03/partes-de-la-casa-en-ingles.jpg","bonito lugar",500000.00));
	
		
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
	public void updateProducto(Long prodId, String nombre_archivo, String URL,String descripcion,double precio) {
		for (productos prod : lista) {
			if(prod.getId() == prodId) {
				if (nombre_archivo!=null) prod.setNombre_archivo(nombre_archivo);
				if (URL != null) prod.setURL (URL);	
				if(descripcion!=null)prod.setDescripcion(descripcion);
				if(precio!=0)prod.setPrecio(precio);
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
	 

	 
}
