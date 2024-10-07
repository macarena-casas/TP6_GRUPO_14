package presentacion.controlador;

import negocio.PersonaNegocio;
import presentacion.vista.PanelListar;

public class ControladorListar {
	
	private PanelListar panelListar;
	private PersonaNegocio PerNeg;
	
	public ControladorListar(PanelListar panelListar, PersonaNegocio personaNegocio) {
		this.panelListar = panelListar;
		this.PerNeg = personaNegocio;
	}
	
	

}
