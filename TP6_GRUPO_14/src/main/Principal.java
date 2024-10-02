package main;

import dao.Personadao;
import daoImpl.Personadaoimpl;
import entidad.Persona;
import presentacion.vista.Vista_principal;

public class Principal {

	public static void main(String[] args) {
		
		Personadao perdao = new Personadaoimpl() ;
		Persona persona1= new Persona("12345678","Juan", "Perez");
		Vista_principal frame = new Vista_principal();
		frame.setVisible(true);


		
		 boolean fila = perdao.insert(persona1);
		
		if (fila == true) {
			System.out.println("Agregado con exito");
			
		}
		else{
			System.out.println("No fue agregado");
			
		}
		
	}

}
