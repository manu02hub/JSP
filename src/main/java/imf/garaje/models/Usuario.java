package imf.garaje.models;

import java.util.Objects;

public class Usuario {

	private int id;
	private String nombre;
	private String dni;
	private String email;
	private String password;
	private String image;
	private String role;

	/**
	 * @param id
	 * @param nombre
	 * @param email
	 * @param password
	 * @param image
	 */

	public Usuario() {
	}

	public Usuario(int id, String nombre, String dni, String email, String password, String image, String role) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.image = image;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, email, id, image, nombre, password, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(image, other.image) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", email=" + email + ", password="
				+ password + ", image=" + image + ", role=" + role + "]";
	}

}
