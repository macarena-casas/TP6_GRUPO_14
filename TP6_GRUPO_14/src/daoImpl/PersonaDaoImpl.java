package daoImpl;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.Personadao;
import entidad.Persona;


public class PersonaDaoImpl implements Personadao {
	
	
	
	

	@Override
	public List<Persona> readAll() {
	    PreparedStatement statement = null;
	    ResultSet result = null;
	    ArrayList<Persona> personas = new ArrayList<>();
	    Conexion conexion = new Conexion();
	    
	    try {
	        conexion.setearSp("listarPersonas");
	        result = conexion.ejecutarLectura();
	        while (result.next()) {  
	            personas.add(getPersona(result));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	       
	        try {
	            if (result != null) result.close();
	            if (statement != null) statement.close();
	            if (conexion != null) conexion.cerrarConexion(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
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

		Conexion conexion = new Conexion();
		boolean isagregarExitoso = false;
		try
		{
			conexion.setearSp("agregarPersona(?,?,?)");
			conexion.setearParametros(1, agre.getDni());
			conexion.setearParametros(2, agre.getNombre());
			conexion.setearParametros(3, agre.getApellido());
			conexion.ejecutarAccion();
			isagregarExitoso = true;
			conexion.cerrarConexion();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
		if(isagregarExitoso != true)
		{
			
			isagregarExitoso = false;
		}
		conexion.cerrarConexion();
		return isagregarExitoso;
	}


	@Override
	public boolean modificarPersona(Persona mod, String dNI) {
		Conexion conexion = new Conexion();
		try
		{
			conexion.setearSp("modificarPersona(?,?,?)");
			conexion.setearParametros(1, dNI);
			conexion.setearParametros(2, mod.getNombre());
			conexion.setearParametros(3, mod.getApellido());
			conexion.ejecutarAccion();
			conexion.cerrarConexion();
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	
	


	
}
