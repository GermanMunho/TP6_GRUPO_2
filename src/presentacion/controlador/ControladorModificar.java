package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelModificar;

public class ControladorModificar {
	private PanelModificar panel;
	private PersonaNegocio personaNegocio;
	DefaultListModel<String> model;
	private ArrayList<Persona> personasTotal;
	private Persona persona_modificar;

	public ControladorModificar(PanelModificar panelModificar, PersonaNegocio personaNegocio) {
		this.panel = panelModificar;
		this.personaNegocio = personaNegocio;
		this.model = new DefaultListModel<String>();
		
		this.panel.getBtnModificar().addActionListener(this::EventoClickBoton_ModificarPersona);
		this.panel.getList().addListSelectionListener(this::EventoSeleccionarPersona);

		LlenarTabla();
	}

	public void EventoClickBoton_ModificarPersona(ActionEvent a) {
		if (persona_modificar != null) {
			persona_modificar.setNombre(panel.getTxtNombre().getText());
			persona_modificar.setApellido(panel.getTxtApellido().getText());

			if (personaNegocio.modificar(persona_modificar)) {
				panel.mostrarMensaje("Elemento modificado correctamente");
				LlenarTabla();
			} else {
				panel.mostrarMensaje("Error al modificar el elemento");
				System.out.println(personaNegocio.modificar(persona_modificar));
			}
		} else {
			panel.mostrarMensaje("Seleccione un elemento para modificar");
		}
	}

	private void llenarJList(List<Persona> personasEnLista) {
		this.model = new DefaultListModel<String>();
		for (Persona p : personasEnLista) {
			model.addElement(p.getNombre() + " " + p.getApellido() + " - " + p.getDNI());
		}
		panel.getList().setModel(model);
	}

	public void EventoSeleccionarPersona(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedIndex = panel.getList().getSelectedIndex();
			this.actualizarLP();
			if (selectedIndex != -1 && selectedIndex < personasTotal.size()) {
				persona_modificar = personasTotal.get(selectedIndex);
				panel.getTxtNombre().setText(persona_modificar.getNombre());
				panel.getTxtApellido().setText(persona_modificar.getApellido());
				panel.getTxtDNI().setText(persona_modificar.getDNI());
				panel.getTxtDNI().setEditable(false);
			} else {
				limpiarCampos();
			}
		}
	}

	private void LlenarTabla() {
		this.personasTotal = (ArrayList<Persona>) this.personaNegocio.listar();
		llenarJList(this.personasTotal);
		limpiarCampos();
	}
	private void actualizarLP() {
		this.personasTotal = (ArrayList<Persona>) this.personaNegocio.listar();
	}

	private void limpiarCampos() {
		panel.getTxtNombre().setText("");
		panel.getTxtApellido().setText("");
		panel.getTxtDNI().setText("");
		persona_modificar = null;
	}

}