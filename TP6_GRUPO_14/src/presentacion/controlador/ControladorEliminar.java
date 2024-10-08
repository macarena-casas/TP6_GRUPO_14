package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import daoImpl.Conexion;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminar;

public class ControladorEliminar implements ActionListener {

    private PanelEliminar panelEliminar;
    private PersonaNegocio perNegocio;
    private DefaultListModel<Persona> listmodel;

    public ControladorEliminar(PanelEliminar panel, PersonaNegocio negocio) {
        this.panelEliminar = panel;
        this.perNegocio = negocio;
        cargarLista();

        panelEliminar.getBtnEliminar().addActionListener(e -> eliminarPersona());
        
    }

   

    

    private void eliminarPersona() {
        if (!panelEliminar.getListPersonas().isSelectionEmpty()) {
            Conexion cone = new Conexion();
            Persona seleccionada = panelEliminar.getListPersonas().getSelectedValue();
            try {
                cone.setearSp("eliminarPersona(?)");
                cone.setearParametros(1, seleccionada.getDni());
                int filasAfectadas = cone.ejecutarAccion();

                if (filasAfectadas > 0) { 
                    JOptionPane.showMessageDialog(null, "Persona eliminada con éxito");
                    cargarLista();  
                } else {
                    JOptionPane.showMessageDialog(null, "No se eliminó ninguna persona");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la acción: " + ex.getMessage());
            } finally {
                cone.cerrarConexion(); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna persona para eliminar");
        }
    }

    private void cargarLista() {
        List<Persona> lista = perNegocio.readAll();
        

        if (panelEliminar.getModel() == null) {
            listmodel = new DefaultListModel<>();
            panelEliminar.setModel(listmodel);  
        } else {
            listmodel = panelEliminar.getModel(); 
        }
        
        listmodel.clear(); 
        for (Persona persona : lista) {
            listmodel.addElement(persona);
        }
        
        panelEliminar.setModel(listmodel);      }



    @Override
    public void actionPerformed(ActionEvent e) {
    	// TODO Auto-generated method stub
    }
}
