package presentacion.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregar;

public class ControladorAgregar implements ActionListener {
	
	private PanelAgregar panelAgregar;
	private PersonaNegocio perNegocio;

	public ControladorAgregar(PanelAgregar panel, PersonaNegocio negocio) {
		this.panelAgregar = panel;
		this.perNegocio = negocio;

		panelAgregar.getBtnAceptar().addActionListener(l -> agregarPersona(l));
		panelAgregar.getTextFieldDni().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {soloNumerosDNI(e);}
		});
		panelAgregar.getTextFieldNombre() .addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {soloLetras(e, panelAgregar.getTextFieldNombre().getText());}
		});
		panelAgregar.getTextFieldApellido().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)  {soloLetras(e, panelAgregar.getTextFieldApellido().getText());}
		});
		

	}

	private void agregarPersona(ActionEvent l) {

		if(validarTextfield()) {
			Persona persona = new Persona();
			persona.setNombre(panelAgregar.getTextFieldNombre().getText());
			persona.setApellido(panelAgregar.getTextFieldApellido().getText());
			persona.setDni(panelAgregar.getTextFieldDni().getText());
			//if (perNegocio.getPersonaPorDni(persona.getDni()) == null) {

				if(perNegocio.agregarPersona(persona)) {
															
				JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
				limpiarTextfield();
				}else {
					JOptionPane.showMessageDialog(null, "ERROR - No se pudo procesar la solicitud");
				}
			/*}else {
				JOptionPane.showMessageDialog(null, "ERROR - Persona con Dni = "+panelAgregar.getTextFieldDni().getText()+" ya existe");
			}
		}else {*/
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos");
		
		
		}
		
	}
	
	private boolean validarTextfield() {
		boolean pass=true;
		if(panelAgregar.getTextFieldApellido().getText().isEmpty()) {
			panelAgregar.getTextFieldApellido().setBackground(Color.red);
			pass=false;
		}else {
			panelAgregar.getTextFieldApellido().setBackground(Color.white);
		}
		
		if(panelAgregar.getTextFieldNombre().getText().isEmpty()) {
			panelAgregar.getTextFieldNombre().setBackground(Color.red);
			pass=false;
		}else {
			panelAgregar.getTextFieldNombre().setBackground(Color.white);
		}
		
		if(panelAgregar.getTextFieldDni().getText().isEmpty()) {
			panelAgregar.getTextFieldDni().setBackground(Color.red);
			pass=false;
		}else {
			panelAgregar.getTextFieldDni().setBackground(Color.white);
		}
		return pass;
	}

	private void soloNumerosDNI(KeyEvent e) {
		char c = e.getKeyChar();
		if(panelAgregar.getTextFieldDni().getText().length()>=8 || ((c<'0') || (c>'9'))) {
			e.consume();
		}
	}
	
	private void soloLetras(KeyEvent e, String s) {
		char c = e.getKeyChar();
		if(s.length()>=25 || !Character.isAlphabetic(c)) {
			e.consume();
		}
	}
	
	private void limpiarTextfield() {
		panelAgregar.getTextFieldApellido().setText("");
		panelAgregar.getTextFieldNombre().setText("");
		panelAgregar.getTextFieldDni().setText("");
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
