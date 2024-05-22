package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.List;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregar;

public class ControladorAgregar {

    private PanelAgregar panelAgregar;
    private PersonaNegocio personaNegocio;

    public ControladorAgregar(PanelAgregar panelAgregar, PersonaNegocio personaNegocio) {
        this.panelAgregar = panelAgregar;
        this.personaNegocio = personaNegocio;

        this.panelAgregar.getBtnAceptar().addActionListener(this::EventoClickBoton_AgregarPersona_PanelAgregarPersonas);
    }

    public void EventoClickBoton_AgregarPersona_PanelAgregarPersonas(ActionEvent a) {
        String mensaje;
        if (this.panelAgregar.getTxtDNI().getText().isEmpty() ||
            this.panelAgregar.getTxtNombre().getText().isEmpty() ||
            this.panelAgregar.getTxtApellido().getText().isEmpty()) {

            mensaje = "Es necesario completar todos los campos";
            this.panelAgregar.mostrarMensaje(mensaje);

        } else {
            String DNI = this.panelAgregar.getTxtDNI().getText();
            String nombre = this.panelAgregar.getTxtNombre().getText();
            String apellido = this.panelAgregar.getTxtApellido().getText();
            Persona p = new Persona(DNI, nombre, apellido);

            List<Persona> lista = personaNegocio.listar();
            boolean dniExists = lista.stream().anyMatch(per -> per.getDNI().equals(p.getDNI()));

            if (dniExists) {
                mensaje = "DNI ya registrado";
                this.panelAgregar.mostrarMensaje(mensaje);
            } else {
                boolean isAdded = personaNegocio.agregar(p);
                if (isAdded) {
                    mensaje = "Persona agregada";
                    this.panelAgregar.mostrarMensaje(mensaje);
                    this.panelAgregar.getTxtNombre().setText("");
                    this.panelAgregar.getTxtApellido().setText("");
                    this.panelAgregar.getTxtDNI().setText("");
                } else {
                    mensaje = "Error al agregar la persona";
                    this.panelAgregar.mostrarMensaje(mensaje);
                }
            }
        }
    }
}
