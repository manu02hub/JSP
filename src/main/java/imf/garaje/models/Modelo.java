/**
 * 
 */
package imf.garaje.models;

import java.util.Objects;

/**
 * @author manue
 *
 */
public class Modelo {

	
	private int id_modelo;
	private String foto_modelo;
	private String nombre_modelo;
	private int anno;
	public Modelo() {
		super();
	}
	public Modelo(int id_modelo, String foto_modelo, String nombre_modelo, int anno) {
		super();
		this.id_modelo = id_modelo;
		this.foto_modelo = foto_modelo;
		this.nombre_modelo = nombre_modelo;
		this.anno = anno;
	}
	public int getId_modelo() {
		return id_modelo;
	}
	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}
	public String getFoto_modelo() {
		return foto_modelo;
	}
	public void setFoto_modelo(String foto_modelo) {
		this.foto_modelo = foto_modelo;
	}
	public String getNombre_modelo() {
		return nombre_modelo;
	}
	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	@Override
	public String toString() {
		return "Modelo [id_modelo=" + id_modelo + ", foto_modelo=" + foto_modelo + ", nombre_modelo=" + nombre_modelo
				+ ", anno=" + anno + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(anno, foto_modelo, id_modelo, nombre_modelo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		return anno == other.anno && Objects.equals(foto_modelo, other.foto_modelo) && id_modelo == other.id_modelo
				&& Objects.equals(nombre_modelo, other.nombre_modelo);
	}
	
	
}
