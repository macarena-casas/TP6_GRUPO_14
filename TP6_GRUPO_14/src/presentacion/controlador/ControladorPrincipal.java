package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.PersonaNegocio;
import negociolmpl.PersonaNegocioImpl;
import presentacion.vista.PanelAgregar;
import presentacion.vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener{
	private VistaPrincipal vistaPrincipal;
	private PanelAgregar panelAgregar;
	
	
	public ControladorPrincipal(VistaPrincipal vista) {
		this.vistaPrincipal = vista;
		
		this.panelAgregar = new PanelAgregar();
			
		this.vistaPrincipal.getMenuAgregar().addActionListener(a->EventoClickAbrirPanelAgregar(a));

	}
	
	public void  EventoClickAbrirPanelAgregar(ActionEvent a)
	{	
		panelAgregar = new PanelAgregar();
		PersonaNegocio personaNegocio = new PersonaNegocioImpl();
		ControladorAgregar controladorAgregar = new ControladorAgregar(panelAgregar,personaNegocio);
		this.vistaPrincipal.setContentPane(panelAgregar);
		this.vistaPrincipal.getContentPane().repaint();
		this.vistaPrincipal.getContentPane().revalidate();
	}
	
	public void inicializar()
	{
		this.vistaPrincipal.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
	}
	
}
