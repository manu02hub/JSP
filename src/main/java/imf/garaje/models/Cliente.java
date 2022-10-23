package imf.garaje.models;

import java.util.Objects;

public class Cliente {

	private int id;
	private String foto;
	private String nombre;
	private String email;

	public Cliente() {
		super();
	}

	public Cliente(int id, String foto, String nombre, String email) {
		super();
		this.id = id;
		this.foto = foto;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", foto=" + foto + ", nombre=" + nombre + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, foto, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(foto, other.foto) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}

}
