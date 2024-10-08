package negociolmpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Personadao;
import daoImpl.Conexion;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	Personadao pdao = new PersonaDaoImpl();

	@Override
	public boolean agregarPersona(Persona persona) {
		
		boolean Estado = false;
		
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 && persona.getDni().trim().length()>0)
		{
			Estado=pdao.agregarPersona(persona);
		}
		return Estado;
		
	}

	@Override
	public boolean modificarPersona(Persona modificar, String DNI) {
		
		return pdao.modificarPersona(modificar, DNI);
	}

	@Override
	public boolean eliminarPersona(Persona persona_elim) {
		
		boolean estado=false;
		if(persona_elim.getDni().trim().length()>0 )
		{
			estado=pdao.eliminarPersona(persona_elim);
		}
		return estado;
		
	}
	
	public List<Persona> listarPersonas() {
	    Conexion cone = new Conexion();
	    List<Persona> listaPersonas = new ArrayList<>();
	    
	    try {
	        cone.setearSp("listarPersonas");
	        ResultSet rs = cone.ejecutarLectura();
	        
	        while (rs.next()) {
	            Persona persona = new Persona();
	            persona.setNombre(rs.getString("nombre"));
	            persona.setApellido(rs.getString("apellido"));
	            persona.setDni(rs.getString("dni"));
	            listaPersonas.add(persona);
	        }
	        cone.cerrarConexion();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listaPersonas;
	}

	
	

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
		
	}
}
