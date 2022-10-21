package imf.garaje.interfaces;

import java.util.ArrayList;

import imf.garaje.models.Modelo;

public interface ModeloBd {
	public Modelo crearModelo(Modelo modelo);
	public boolean eliminarModelo(int id);
	public Modelo actualizarModelo(Modelo modelo);
	public Modelo buscarModelo(int id);
	public Modelo find(int id);
	public ArrayList<Modelo> getModelos();
}
