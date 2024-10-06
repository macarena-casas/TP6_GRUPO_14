package presentacion.vista;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	private JButton btnAceptar;

	/**
	 * Create the panel.
	 */
	public PanelAgregar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 60, 56, 16);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(100, 100, 56, 16);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(100, 140, 56, 16);
		add(lblDni);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(200, 57, 140, 22);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(200, 97, 140, 22);
		add(textFieldApellido);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(200, 137, 140, 22);
		add(textFieldDni);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(100, 169, 102, 25);
		add(btnAceptar);

	}
	
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public void setTextFieldApellido(JTextField textFieldApellido) {
		this.textFieldApellido = textFieldApellido;
	}

	public JTextField getTextFieldDni() {
		return textFieldDni;
	}

	public void setTextFieldDni(JTextField textFieldDni) {
		this.textFieldDni = textFieldDni;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
}
