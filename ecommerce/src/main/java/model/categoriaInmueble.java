package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="categoriaInmueble")
public class categoriaInmueble {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoriaid", unique = true, nullable = false)
	private Long categoriaid;
//	@Column(name="nombreCategoria")
	private String categoria;
	
	@OneToMany(mappedBy= "categoriaInmueble")
	@JsonManagedReference
	private List<inmueble> inmueble;

	public categoriaInmueble(Long categoriaid, String categoria, List<inmueble> inmueble) {
		super();
		this.categoriaid = categoriaid;
		this.categoria = categoria;
		this.inmueble = inmueble;
	}
	
	public categoriaInmueble() {}

	public Long getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(Long categoriaid) {
		this.categoriaid = categoriaid;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<inmueble> getProductos() {
		return inmueble;
	}

	public void setProductos(List<inmueble> inmueble) {
		this.inmueble = inmueble;
	}

	@Override
	public String toString() {
		return "Categoria [categoriaid=" + categoriaid + ", categoria=" + categoria + ", productos=" + inmueble + "]";
	}
}
