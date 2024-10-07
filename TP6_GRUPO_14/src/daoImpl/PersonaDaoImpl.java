package daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Personadao;
import entidad.Persona;


public class PersonaDaoImpl implements Personadao {
	
	private static final String Agregar = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String Eliminar = "DELETE FROM personas WHERE Dni = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String Modificar = "UPDATE personas SET Dni = ?, Nombre = ?, Apellido = ? WHERE Dni LIKE ?;";
	
	

	@Override
	public List<Persona> readAll() {
		PreparedStatement statement;
		ResultSet result;
		ArrayList <Persona> personas = new ArrayList<Persona>();
		Conexion conexion =Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			result = statement.executeQuery();
			while(result.next()) {
				personas.add(getPersona(result));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	
	}
	private Persona getPersona(ResultSet result) throws SQLException{
		String nombre =result.getString("Nombre");
		String dni =result.getString("Dni");
		String apellido =result.getString("Apellido");
		return new Persona (dni,nombre,apellido);
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
	
	@Override
	public boolean modificarPersona(Persona modificar, String dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modificarOk = false;
		try {
			statement = conexion.prepareStatement(Modificar);
			statement.setString(1, modificar.getDni());
			statement.setString(2, modificar.getNombre());
			statement.setString(3, modificar.getApellido());
			statement.setString(4, dni);
			
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				modificarOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return modificarOk;
	}
	


	
}
