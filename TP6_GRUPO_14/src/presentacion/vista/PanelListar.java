package presentacion.vista;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import entidad.Persona;

public class PanelListar extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable PersonaTabla;
    private DefaultTableModel modelPersonas;
    private JScrollPane tbPersonas;
    private String[] nombreColumnas = {"Nombre", "Apellido", "Dni"};

    public PanelListar() {
        setLayout(null);

        modelPersonas = new DefaultTableModel(null, nombreColumnas);
        PersonaTabla = new JTable(modelPersonas);

        PersonaTabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        PersonaTabla.getColumnModel().getColumn(0).setResizable(false);
        PersonaTabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        PersonaTabla.getColumnModel().getColumn(1).setResizable(false);
        PersonaTabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        PersonaTabla.getColumnModel().getColumn(2).setResizable(false); 

        tbPersonas = new JScrollPane();
        tbPersonas.setBounds(15, 30, 383, 126);
        tbPersonas.setViewportView(PersonaTabla);

        add(tbPersonas, BorderLayout.CENTER);
    }

    public void llenarTabla(List<Persona> personas) {
        System.out.println("Tamaño de la lista de personas: " + personas.size());
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " " + p.getApellido() + " " + p.getDni());
        }

        this.getModelPersonas().setRowCount(0); 
        this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

        for (Persona p : personas) {
            String Nombre = p.getNombre();
            String Apellido = p.getApellido();
            String Dni = p.getDni();
            Object[] fila = {Nombre, Apellido, Dni};
            this.getModelPersonas().addRow(fila);
        }
    }

    public DefaultTableModel getModelPersonas() {
        return modelPersonas;
    }

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public JTable getPersonaTabla() {
        return PersonaTabla;
    }

    public void setPersonaTabla(JTable personaTabla) {
        this.PersonaTabla = personaTabla;
    }
}
