package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.PersonaNegocio;
import negociolmpl.PersonaNegocioImpl;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener{
	private VistaPrincipal vistaPrincipal;
	private PanelAgregar panelAgregar;
	private PanelEliminar panelEliminar;
	
	public ControladorPrincipal(VistaPrincipal vista) {
		this.vistaPrincipal = vista;
		
		this.panelAgregar = new PanelAgregar();
			
		this.vistaPrincipal.getMenuAgregar().addActionListener(a->EventoClickAbrirPanelAgregar(a));
		this.vistaPrincipal.getMenuEliminar().addActionListener(l->EventoClickAbrirPanelEliminar(l));

	}
	
	private void EventoClickAbrirPanelEliminar(ActionEvent l) {
		panelEliminar  = new PanelEliminar();
		PersonaNegocio personaNegocio = new PersonaNegocioImpl();
		ControladorEliminar controladorEliminar = new ControladorEliminar(panelEliminar,personaNegocio);
		this.vistaPrincipal.setContentPane(panelEliminar);
		this.vistaPrincipal.getContentPane().repaint();
		this.vistaPrincipal.getContentPane().revalidate();
		
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
