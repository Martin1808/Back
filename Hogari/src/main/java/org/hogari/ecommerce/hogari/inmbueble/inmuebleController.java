package org.hogari.ecommerce.hogari.inmbueble;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(path="/api/inmuebles/")

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })
public class inmuebleController {
	private final  inmuebleService inService;//LLamo a la clase service
	@Autowired
	public inmuebleController(inmuebleService inService) {
		this.inService=new inmuebleService();
	}
	//Aqui empiezan las solicitudes :3
	
	@GetMapping
	public List<inmueble>getInmuebles(){
		return inService.getInmuebles();
	}
	@GetMapping (path="{inId}")
	public inmueble getInmueble(@PathVariable("inId")Long inId) {
		return inService.getInmueble(inId);
	}
	
	@PostMapping
	public void addInmueble(@RequestBody inmueble in) {
		inService.addInmueble(in);
	}
	
	
	
	
	
	@PutMapping(path="{inId}")
	public void updateInmueble(@PathVariable("inId")Long inId,
			@RequestParam (required=false) String ciudad,
			@RequestParam (required=false) String direccion,
			@RequestParam (required=false) String tipoInmueble,
			@RequestParam (required=false) int nPersona,
			@RequestParam (required=false) String mascotas,
			@RequestParam (required=false) String descripcion,
			@RequestParam (required=false) String dimensiones,
			@RequestParam (required=false) double precio) {
			inService.updateInmueble(inId,ciudad,direccion,tipoInmueble,nPersona,mascotas,descripcion,dimensiones,precio);
	}
	
	@DeleteMapping(path="{inId}")
		public void delInmueble(@PathVariable("inId")Long inId) {
			inService.delInmueble(inId);
		}
	
	
}
