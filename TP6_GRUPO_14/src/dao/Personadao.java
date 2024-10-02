package dao;

import java.util.List;
import entidad.Persona;

public interface Personadao {

	public boolean insert (Persona persona);
	public boolean delete (Persona persona_eliminar);
	public List <Persona> readall();
	
	
}
