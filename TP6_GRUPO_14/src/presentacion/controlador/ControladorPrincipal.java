package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.PersonaNegocio;
import negociolmpl.PersonaNegocioImpl;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;
import presentacion.vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener{
	private PersonaNegocio personaNegocio;
	private VistaPrincipal vistaPrincipal;
	private PanelAgregar panelAgregar;
	private PanelEliminar panelEliminar;
	private PanelModificar panelModificar;
	private PanelListar panelListar;
	
	public ControladorPrincipal(VistaPrincipal vista,PersonaNegocio personaNegocio) {
		this.vistaPrincipal = vista;
		this.personaNegocio = personaNegocio;
			
		this.vistaPrincipal.getMenuAgregar().addActionListener(a->EventoClickAbrirPanelAgregar(a));
		this.vistaPrincipal.getMenuEliminar().addActionListener(l->EventoClickAbrirPanelEliminar(l));
		this.vistaPrincipal.getMenuModificar().addActionListener(a->EventoClickAbrirPanelModificar(a));
		this.vistaPrincipal.getMenuListar().addActionListener(a->EventoClickAbrirPanelListar(a));
		

	}
	
	private void EventoClickAbrirPanelEliminar(ActionEvent l) {
		panelEliminar  = new PanelEliminar();
		ControladorEliminar controladorEliminar = new ControladorEliminar(panelEliminar,personaNegocio);
		this.vistaPrincipal.setContentPane(panelEliminar);
		this.vistaPrincipal.getContentPane().repaint();
		this.vistaPrincipal.getContentPane().revalidate();
		
	}

	public void  EventoClickAbrirPanelAgregar(ActionEvent a)
	{	
		panelAgregar = new PanelAgregar();
		ControladorAgregar controladorAgregar = new ControladorAgregar(panelAgregar,personaNegocio);
		this.vistaPrincipal.setContentPane(panelAgregar);
		this.vistaPrincipal.getContentPane().repaint();
		this.vistaPrincipal.getContentPane().revalidate();
	}
	
	public void  EventoClickAbrirPanelModificar(ActionEvent a)
	{		
		panelModificar = new PanelModificar();
		ControladorModificar controladorModificar = new ControladorModificar(panelModificar,personaNegocio);
		this.vistaPrincipal.setContentPane(panelModificar);
		this.vistaPrincipal.repaint();
		this.vistaPrincipal.revalidate();
	}
	
	public void EventoClickAbrirPanelListar(ActionEvent a)
	{		
		panelListar = new PanelListar();
		ControladorListar controladorListar = new ControladorListar(panelListar,personaNegocio);
		this.vistaPrincipal.setContentPane(panelListar);
		this.vistaPrincipal.repaint();
		this.vistaPrincipal.revalidate();
	}

	
	
	
	public void inicializar()
	{
		this.vistaPrincipal.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}
