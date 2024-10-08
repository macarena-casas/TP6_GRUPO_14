package presentacion.controlador;

import java.util.List;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelListar;


public class ControladorListar {
    private PanelListar panelListar;
    private PersonaNegocio personaNegocio;

    public ControladorListar(PanelListar panelListar, PersonaNegocio personaNegocio) {
        this.panelListar = panelListar;
        this.personaNegocio = personaNegocio;
        cargarPersonas();  
    }

    public void cargarPersonas() {
        System.out.println("Método cargarPersonas llamado");  
        List<Persona> personas = personaNegocio.listarPersonas();  
        System.out.println("Personas obtenidas: " + personas.size());  
        panelListar.llenarTabla(personas);  
    }
}

