package daoImpl;


import java.util.ArrayList;
import java.util.List;

import dao.Personadao;
import entidad.Persona;


public class Personadaoimpl implements Personadao {

	private static final String insert = "insert into personas(Dni, Nombre, Apellido) values(?, ?, ?)";
	
	
	public boolean insert(Persona persona)
	{
		Conexion cone = new Conexion();
		
		try
		{
			cone.agregarpersona(persona);
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		
		}
		
		return true;
	}




	@Override
	public boolean delete(Persona persona_eliminar) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public List<Persona> readall() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
