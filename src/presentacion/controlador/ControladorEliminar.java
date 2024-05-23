package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminar;

public class ControladorEliminar {
    private PanelEliminar panel;
    private PersonaNegocio personaNegocio;
    private ArrayList<Persona> personasTotal;

    public ControladorEliminar(PanelEliminar panelEliminar, PersonaNegocio personaNegocio) {
        this.panel = panelEliminar;
        this.personaNegocio = personaNegocio;
        this.panel.getBtnEliminar().addActionListener(this::EventoClickBoton_EliminarPersona);
        this.personasTotal = (ArrayList<Persona>) personaNegocio.listar();
        llenarJList(this.personasTotal);
    }

    public void EventoClickBoton_EliminarPersona(ActionEvent a) {
    	actualizarLP();
        int selectedIndex = panel.getList().getSelectedIndex();
        if (selectedIndex != -1) {
            Persona personaAEliminar = personasTotal.get(selectedIndex);
            if (personaNegocio.eliminar(personaAEliminar)) {
                personasTotal.remove(selectedIndex);
                llenarJList(personasTotal);
                panel.mostrarMensaje("Elemento eliminado correctamente");
            } else {
                panel.mostrarMensaje("Error al eliminar el elemento");
            }
        } else {
            panel.mostrarMensaje("Seleccione un elemento para eliminar");
        }
    }

    private void llenarJList(List<Persona> personasEnLista) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Persona p : personasEnLista) {
            model.addElement(p.getNombre() + " " + p.getApellido() + " - " + p.getDNI());
        }
        panel.getList().setModel(model);
    }
    private void actualizarLP() {
    	this.personasTotal = (ArrayList<Persona>) personaNegocio.listar();
    }
}
