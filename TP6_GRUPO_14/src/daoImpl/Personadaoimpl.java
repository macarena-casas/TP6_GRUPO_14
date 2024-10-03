package daoImpl;


import java.util.ArrayList;
import java.util.List;

import dao.Personadao;
import entidad.Persona;


public class Personadaoimpl implements Personadao {

	
	
	
	public boolean insert(Persona persona)
	{
		Conexion cone = new Conexion();
		
		try
		{
			// Agregar
            //cone.setearSp("agregarPersona(?,?,?)");
            //cone.setearParametros(1, "11");
            //cone.setearParametros(2, "Don");
            //cone.setearParametros(3, "Cirilio");
            //cone.ejecutarAccion();
		
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
