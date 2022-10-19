/**
 * 
 */
package imf.garaje.models;

import java.util.Objects;

/**
 * @author manue
 *
 */
public class Marca {

	private int id_marca;
	private String foto_marca;
	private String nombre_marca;

	public Marca() {
		super();
	}

	public Marca(int id_marca, String foto_marca, String nombre_marca) {
		super();
		this.id_marca = id_marca;
		this.foto_marca = foto_marca;
		this.nombre_marca = nombre_marca;
	}

	public int getId_marca() {
		return id_marca;
	}

	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	public String getFoto_marca() {
		return foto_marca;
	}

	public void setFoto_marca(String foto_marca) {
		this.foto_marca = foto_marca;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	@Override
	public String toString() {
		return "Marca [id_marca=" + id_marca + ", foto_marca=" + foto_marca + ", nombre_marca=" + nombre_marca + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(foto_marca, id_marca, nombre_marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return Objects.equals(foto_marca, other.foto_marca) && id_marca == other.id_marca
				&& Objects.equals(nombre_marca, other.nombre_marca);
	}

}
