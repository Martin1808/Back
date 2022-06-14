
package org.hogari.Fotos.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController // Con esta anotacion le estamos diciendo a nuestro controlador que va a manejar
				// la entidad o producto, y en este caso, vamos a utilizar metodos como GET,
				// POST, PUT

@RequestMapping(path = "/api/fotos/")
//Variable del tipo producto llamada prodservice

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

public class productosController {

	private final productoService prodService;

	@Autowired // ES para el contexto, porque nosotros no podemos instanciar objetos cuando la
				// aplicacion este desplegada, se tiene que definir todo desde abtes,

	// Constructor
	public productosController(productoService prodService) {
		this.prodService = new productoService();

	}// Constructor

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// AQUI EMPIEZAN LAS SOLICITUDES

	// SOLICTUD GET
	@GetMapping
	public List<productos> getProductos() {
		return prodService.getProductos(); // quiero que regrese los productos

	}// get productos

	// solicitud GET para un solo producto

	@GetMapping(path = "{prodId}")
	public productos getProducto(@PathVariable("prodId") Long prodId) {
		return prodService.getProducto(prodId);

	}// getproductos

	// Metodo POST para crear nuevos productos

	@PostMapping
	public void addProducto(@RequestBody productos prod) {
		prodService.addProductos(prod);
	}

	// Metodo Put para modificar un producto ya existente

	@PutMapping(path = "{prodId}")

	public void updateProducto(@PathVariable("prodId") Long prodId,
			@RequestParam(required = false) String nombre_archivo, @RequestParam(required = false) String URL) {
		prodService.updateProducto(prodId, nombre_archivo, URL);
	}// Update producto

	// metodo para borrar un producto existente.

	@DeleteMapping(path = "{prodId}")
	public void deleteProducto(@PathVariable("prodId") Long prodId) {
		prodService.deleteProducto(prodId);

	}

}// clase product controller
