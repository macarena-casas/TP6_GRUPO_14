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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEliminar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnEliminar;
	private JLabel lblEliminar;
	private JList<Persona> listPersonas;
	private DefaultListModel<Persona> model;
	private JScrollPane Scroll;
	public PanelEliminar() {
		
		setLayout(null);
		
		lblEliminar = new JLabel("Eliminar usuario");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEliminar.setBounds(10, 11, 430, 27);
		add(lblEliminar);
		
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBounds(160, 245, 133, 23);
		add(btnEliminar);
		
		listPersonas = new JList<Persona>();
		listPersonas.setBounds(10, 46, 430, 177);
		add(listPersonas);
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	


	public JLabel getLblEliminar() {
		return lblEliminar;
	}


	public void setLblEliminar(JLabel lblEliminar) {
		this.lblEliminar = lblEliminar;
	}
	
	public JList<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(JList<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	public DefaultListModel<Persona> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<Persona> model) {
		this.model = model;
		listPersonas.setModel(this.model);
	}

	public JScrollPane getScroll() {
		return Scroll;
	}

	public void setScroll(JScrollPane scroll) {
		Scroll = scroll;
	}
	
	
	
}
