package presentacion.vista;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import entidad.Persona;

public class PanelListar extends JFrame {

    private JPanel contentPane;
    private JTable PersonaTabla;
    private DefaultTableModel modelPersonas;
    private String[] nombreColumnas = {"Nombre", "Apellido", "Dni"};

    public PanelListar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane spPersona = new JScrollPane();
        spPersona.setBounds(15, 30, 383, 126);
        contentPane.add(spPersona, BorderLayout.CENTER);

        modelPersonas = new DefaultTableModel(null, nombreColumnas);
        PersonaTabla = new JTable(modelPersonas);

        PersonaTabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        PersonaTabla.getColumnModel().getColumn(0).setResizable(false);
        PersonaTabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        PersonaTabla.getColumnModel().getColumn(1).setResizable(false);
        PersonaTabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        PersonaTabla.getColumnModel().getColumn(2).setResizable(false);

        spPersona.setViewportView(PersonaTabla);
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
        PersonaTabla = personaTabla;
    }

    public void llenarTabla(List<Persona> personas) {
        this.getModelPersonas().setRowCount(0);
        this.getModelPersonas().setColumnCount(0);
        this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

        for (Persona p : personas) {
            String Nombre = p.getNombre();
            String Apellido = p.getApellido();
            String Dni = p.getDni();
            Object[] fila = {Nombre, Apellido, Dni};
            this.getModelPersonas().addRow(fila);
        }
    }
}
