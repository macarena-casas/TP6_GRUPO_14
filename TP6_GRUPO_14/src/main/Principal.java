package main;

import negocio.PersonaNegocio;
import negociolmpl.PersonaNegocioImpl;
import presentacion.controlador.ControladorPrincipal;
import presentacion.vista.VistaPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		VistaPrincipal frame = new VistaPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();

		ControladorPrincipal controladorPrincipal = new ControladorPrincipal(frame);
		controladorPrincipal.inicializar();
		

		
	
	}

}
