package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar; 
	

	
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersonas = new JMenu("Persona");
		menuBar.add(mnPersonas);
		
		mntmAgregar = new JMenuItem("Agregar");
		mnPersonas.add(mntmAgregar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnPersonas.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mnPersonas.add(mntmEliminar);
		
		mntmListar = new JMenuItem("Listar");
		mnPersonas.add(mntmListar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}


	public JMenu getMnPersonas() {
		return mnPersonas;
	}

	public void setMnPersonas(JMenu mnPersonad) {
		this.mnPersonas = mnPersonas;
	}

	public JMenuItem getMenuAgregar() {
		return mntmAgregar;
	}

	public void setMenuAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}
	
	public JMenuItem getMenuModificar() {
		return mntmModificar;
	}

	public void setMenuModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMenuEliminar() {
		return mntmEliminar;
	}

	public void setMenuEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}

	public JMenuItem getMenuListar() {
		return mntmListar;
	}

	public void setMenuListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}
	
	
}
