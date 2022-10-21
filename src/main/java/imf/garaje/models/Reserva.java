package imf.garaje.models;

import java.util.Objects;

public class Reserva {

	private int id;
	private String motivo;
	private String fecha;
	private Usuario usuario;

	public Reserva() {
		super();
	}

	public Reserva(int id, String motivo, String fecha, Usuario usuario) {
		super();
		this.id = id;
		this.motivo = motivo;
		this.fecha = fecha;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, motivo, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(fecha, other.fecha) && id == other.id && Objects.equals(motivo, other.motivo)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", motivo=" + motivo + ", fecha=" + fecha + ", usuario=" + usuario + "]";
	}

}
