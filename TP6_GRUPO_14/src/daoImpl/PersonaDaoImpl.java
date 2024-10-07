package daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Personadao;
import entidad.Persona;


public class PersonaDaoImpl implements Personadao {
	
	private static final String Agregar = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String Eliminar = "DELETE FROM personas WHERE Dni = ?";
	private static final String readall = "SELECT * FROM personas";
	
	public boolean modificarPersona(Persona Modificar, String dni) {
		Personadao modificar = new PersonaDaoImpl();
		return modificar.modificarPersona(Modificar, dni);
	}
	

	@Override
	public List<Persona> readAll() {
		Personadao perdao = new PersonaDaoImpl();
		return perdao.readAll();
		
	}

	@Override
	public boolean eliminarPersona(Persona Eliminar) {
		Personadao eliminar = new PersonaDaoImpl();
		if (eliminar.readAll().contains(Eliminar)) {		
				return eliminar.eliminarPersona(Eliminar);
		} else
		{ return false; }
	}


	@Override
	public boolean agregarPersona(Persona agre) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isagregarExitoso = false;
		try
		{
			statement = conexion.prepareStatement(Agregar);
			statement.setString(1, agre.getDni());
			statement.setString(2, agre.getNombre());
			statement.setString(3, agre.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isagregarExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isagregarExitoso;
	}




	
}
