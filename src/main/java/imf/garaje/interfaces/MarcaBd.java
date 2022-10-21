package imf.garaje.interfaces;

import java.util.ArrayList;

import imf.garaje.models.Marca;

public interface MarcaBd {

	public Marca crearMarca(Marca marca);
	public boolean eliminarMarca(int id);
	public Marca actualizarMarca(Marca marca);
	public Marca buscarMarca(int id);
	public Marca find(int id);
	public ArrayList<Marca> getMarcas();
}
