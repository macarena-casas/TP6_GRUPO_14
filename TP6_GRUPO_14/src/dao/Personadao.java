package dao;

import java.util.List;
import entidad.Persona;

public interface Personadao {

	public boolean agregarPersona (Persona Agregar);
	public boolean modificarPersona(Persona Modificar, String dNI);
	public boolean eliminarPersona(Persona Eliminar);
	public List<Persona> readAll();
	
	
}
