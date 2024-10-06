package daoImpl;


import java.util.ArrayList;
import java.util.List;

import dao.Personadao;
import entidad.Persona;


public class PersonaDaoImpl implements Personadao {
	
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
	public boolean agregarPersona(Persona Agregar) {
		Personadao agregar = new PersonaDaoImpl();
		return agregar.agregarPersona(Agregar);
	}




	
}
