package presentacion.controlador;

import java.awt.Color;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelModificar;

public class ControladorModificar implements ActionListener {
	
	private PanelModificar panelModificar;
	private PersonaNegocio PerNeg;
	private DefaultListModel<Persona> listmodel;
	

	public ControladorModificar(PanelModificar panel, PersonaNegocio negocio) {
		this.panelModificar = panel;
		this.PerNeg = negocio;

		cargarLista();
		panelModificar.getBtnModificar().addActionListener(m -> ModificarPersona(m));
		panelModificar.getListPersonas().addListSelectionListener(l -> SeleccionarPersona(l));
		panelModificar.getTxfDNI().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {soloNumerosDNI(e);}
		});
		panelModificar.getTxfDNI().setEditable(false);
		panelModificar.getTxfNombre().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {soloLetras(e, panelModificar.getTxfNombre().getText());}
		});
		panelModificar.getTxfApellido().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)  {soloLetras(e, panelModificar.getTxfApellido().getText());}
		});
		
	}

	private void soloNumerosDNI(KeyEvent e) {
		char c = e.getKeyChar();
		if(panelModificar.getTxfDNI().getText().length()>=8 || ((c<'0') || (c>'9'))) {
			e.consume();
		}
	}
	
	private void soloLetras(KeyEvent e, String s) {
		char c = e.getKeyChar();
		if(s.length()>=25 || !Character.isAlphabetic(c)) {
			e.consume();
		}
	}
	
	private void SeleccionarPersona(ListSelectionEvent l){
		if(!panelModificar.getListPersonas().isSelectionEmpty()) {
			panelModificar.getTxfNombre().setText(panelModificar.getListPersonas().getSelectedValue().getNombre());
			panelModificar.getTxfApellido().setText(panelModificar.getListPersonas().getSelectedValue().getApellido());
			panelModificar.getTxfDNI().setText(panelModificar.getListPersonas().getSelectedValue().getDni());
		}else {
			panelModificar.getTxfNombre().setText("");
			panelModificar.getTxfApellido().setText("");
			panelModificar.getTxfDNI().setText("");
		}
	}

	private void ModificarPersona(ActionEvent m) {
		if(validarTextfield()) {
			Persona modificar = new Persona();
			String DNI = panelModificar.getListPersonas().getSelectedValue().getDni();
			modificar.setNombre(panelModificar.getTxfNombre().getText());
			modificar.setApellido(panelModificar.getTxfApellido().getText());
			modificar.setDni(panelModificar.getTxfDNI().getText());
			if(PerNeg.modificarPersona(modificar, DNI)){
				JOptionPane.showMessageDialog(null, "Persona modificada");
			}else {
				JOptionPane.showMessageDialog(null, "No se puedo modificar persona");
			}
			limpiarTextfield();
			panelModificar.repaint();
			panelModificar.revalidate();
		}
	}
	
	private void cargarLista() {
		List<Persona> lista = PerNeg.readAll();
		listmodel = new DefaultListModel<Persona>();
		listmodel = panelModificar.getModel();
		panelModificar.getModel().clear();
		for (int x=0; x< lista.size(); x++) {
			listmodel.addElement((Persona)lista.get(x));
		}
		panelModificar.setModel(listmodel);
	}
	
	private boolean validarTextfield() {
		boolean pass=true;
		if(panelModificar.getTxfApellido().getText().isEmpty()) {
			panelModificar.getTxfApellido().setBackground(Color.red);
			pass=false;
		}else {
			panelModificar.getTxfApellido().setBackground(Color.white);
		}
		
		if(panelModificar.getTxfNombre().getText().isEmpty()) {
			panelModificar.getTxfNombre().setBackground(Color.red);
			pass=false;
		}else {
			panelModificar.getTxfNombre().setBackground(Color.white);
		}
		
		if(panelModificar.getTxfDNI().getText().isEmpty()) {
			panelModificar.getTxfDNI().setBackground(Color.red);
			pass=false;
		}else {
			panelModificar.getTxfDNI().setBackground(Color.white);
		}
		if(panelModificar.getListPersonas().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "No se seleccion� ninguna persona");
			limpiarTextfield();
			pass=false;
		}
		return pass;
	}
	
	private void limpiarTextfield() {
		panelModificar.getTxfApellido().setText("");
		panelModificar.getTxfNombre().setText("");
		panelModificar.getTxfDNI().setText("");
		
		cargarLista();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
