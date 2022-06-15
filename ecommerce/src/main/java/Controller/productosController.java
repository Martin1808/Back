package Controller;
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

import Service.productosService;
import model.productos;


@RestController //Con esta anotacion le estamos diciendo a nuestro controlador que va a manejar la entidad o producto, y en este caso, vamos a utilizar metodos como GET, POST, PUT

@RequestMapping(path="/api/fotos/")
@CrossOrigin(origins = "*")
public class productosController {
private final productosService prodService;
	
	@Autowired
	public productosController(productosService prodService) {
		this.prodService = prodService;
	}
	
	// Get Productos
	@GetMapping
	public List<productos> getProductos() {
		return prodService.getProductos();
	}
	
	// Get Producto
	@GetMapping(path="{prodId}")
	public productos getProducto(@PathVariable("prodId")Long prodId) {
		return prodService.getProducto(prodId);
	}
	
	// ADD Producto
	@PostMapping
	public void addProducto(@RequestBody productos prod) {
		prodService.addProducto(prod);
	}
	
	@DeleteMapping(path="{prodId}")
	public void deleteProducto(@PathVariable("prodId") Long prodId) {
		prodService.deleteProducto(prodId);
	}
	
	// Update producto
	@PutMapping(path="{prodId}")
	public void updateProducto(@PathVariable("prodId") Long prodId,
			@RequestParam(required=false) String nombre_archivo,
			@RequestParam(required=false) String url,
			@RequestParam(required=false) Long categoria_fk_producto) {
		prodService.updateProducto(prodId, nombre_archivo, url);
	}
	
	
	
}
