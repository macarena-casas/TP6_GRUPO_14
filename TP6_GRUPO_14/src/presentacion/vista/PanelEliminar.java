package presentacion.vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelEliminar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
	private JButton btnEliminar;
	private JLabel lblEliminar;
	public PanelEliminar() {
		
		setLayout(null);
		
		lblEliminar = new JLabel("Eliminar usuario");
		lblEliminar.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEliminar.setBounds(157, 11, 101, 27);
		add(lblEliminar);
		
		textArea = new JTextArea();
		textArea.setBounds(143, 37, 131, 149);
		
		add(textArea);
		textArea.setColumns(10);
		textArea.setRows(10);
		textArea.setLineWrap(true); 
		
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBounds(143, 197, 131, 23);
		add(btnEliminar);
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JLabel getLblEliminar() {
		return lblEliminar;
	}


	public void setLblEliminar(JLabel lblEliminar) {
		this.lblEliminar = lblEliminar;
	}
	
	public void llenar (List <Persona> personas) {
		
		 StringBuilder sb = new StringBuilder();
	        for (Persona persona : personas) {
	            sb.append(persona.toString()).append("\n");
	        }

	        textArea.setText(sb.toString());
	
	}
	
	
	
}
