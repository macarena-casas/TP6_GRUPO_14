package negociolmpl;

import java.util.List;

import dao.Personadao;
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

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
		
	}
}
