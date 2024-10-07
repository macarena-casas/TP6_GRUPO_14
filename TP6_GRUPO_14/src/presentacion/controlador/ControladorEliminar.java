package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;

import presentacion.vista.PanelEliminar;
import presentacion.vista.VistaPrincipal;

public class ControladorEliminar implements ActionListener {

    private VistaPrincipal Principal;
	private PanelEliminar panelEliminar;
	private PersonaNegocio perNegocio;
	private ArrayList<Persona> PersonaTabla;

	public ControladorEliminar(PanelEliminar panel, PersonaNegocio negocio) {
		this.panelEliminar = panel;
		this.perNegocio = negocio;
		
		PersonaTabla = (ArrayList<Persona>) perNegocio.readAll();
		panelEliminar.llenar(PersonaTabla);
		
         panelEliminar.getBtnEliminar().addActionListener(l -> eliminarPersona(l));
         }
	
	
	
	private void eliminarPersona(ActionEvent l) {
	  
		boolean estado= false;
		int filaseleccionada = this.panelEliminar.getTextArea().getRows();
		/*for (int fila : filaseleccionada)
		{
			estado = perNegocio.eliminarPersona(this.PersonaTabla.get(fila));
		}
		*/
		JOptionPane.showMessageDialog(null, "Eliminado con exito");

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
