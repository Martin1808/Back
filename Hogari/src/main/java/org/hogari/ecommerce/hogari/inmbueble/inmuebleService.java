package org.hogari.ecommerce.hogari.inmbueble;


	import java.util.ArrayList;
	import java.util.List;

import org.springframework.stereotype.Service;

	@Service
	public class inmuebleService {

		public final ArrayList<inmueble> lista =new ArrayList<inmueble>();
		
		public inmuebleService() {
			lista.add(new inmueble("gdl","zapopan","casa",4,"si","bonit","40*40",400.0));
			lista.add(new inmueble("gdl","zapopan","casa",4,"si","bonto","40*40",400.0));
			lista.add(new inmueble("gdl","zapopan","casa",4,"si","boto","40*40",400.0));
		}//objeto

		public List<inmueble> getInmuebles() {
			// TODO Auto-generated method stub
			return lista;
		}//lista para obtener inmuebles

		public inmueble getInmueble(Long inId) {
			// TODO Auto-generated method stub
			inmueble tmpIn=null;
			for(inmueble i:lista) {
				if(i.getId()==inId) {
					tmpIn=i;
				}
			}return tmpIn;
		}
		
		
		
		
		public void updateInmueble(Long inId, String ciudad, String direccion, String tipoInmueble, int nPersona,
				String mascotas, String descripcion, String dimensiones, double precio) {
			for(inmueble in:lista) {
				if(in.getId()==inId) {
					if(ciudad!=null) in.setCiudad(ciudad);
					if(direccion!=null)in.setDescripcion(descripcion);
					if(tipoInmueble!=null)in.setTipoInmueble(tipoInmueble);
					if(nPersona!=0)in.setnPersona(nPersona);
					if(mascotas!=null)in.setMascotas(mascotas);
					if(descripcion!=null)in.setDescripcion(descripcion);
					if(dimensiones!=null)in.setDimensiones(dimensiones);
					if(precio!=0)in.setPrecio(precio);
				}
			}
			
		}//Metodo para cambiar valores

		public void addInmueble(inmueble in) {
			lista.add(in);
			
		}//agregar valores

		public void delInmueble(Long inId) {
			for(inmueble i:lista) {
				if(i.getId()==inId) {
					lista.remove(i);
					break;
				}
			}
			
		}


		
}
