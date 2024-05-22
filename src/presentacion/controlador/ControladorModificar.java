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
	private ArrayList<Persona> personasTotal;
	private Persona persona_modificar;

	public ControladorModificar(PanelModificar panelModificar, PersonaNegocio personaNegocio) {
		this.panel = panelModificar;
		this.personaNegocio = personaNegocio;

		this.panel.getBtnModificar().addActionListener(this::EventoClickBoton_ModificarPersona);
		this.panel.getList().addListSelectionListener(this::EventoSeleccionarPersona);

		LlenarTabla();
	}

	public void EventoClickBoton_ModificarPersona(ActionEvent a) {
		if (persona_modificar != null) {
			persona_modificar.setNombre(panel.getTxtNombre().getText());
			persona_modificar.setApellido(panel.getTxtApellido().getText());

			if (personaNegocio.modificar(persona_modificar)) {
				LlenarTabla();
				panel.mostrarMensaje("Elemento modificado correctamente");
			} else {
				panel.mostrarMensaje("Error al modificar el elemento");
			}
		} else {
			panel.mostrarMensaje("Seleccione un elemento para modificar");
		}
	}

	private void llenarJList(List<Persona> personasEnLista) {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Persona p : personasEnLista) {
			model.addElement(p.getNombre() + " " + p.getApellido() + " - " + p.getDNI());
		}
		panel.getList().setModel(model);
	}

	public void EventoSeleccionarPersona(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedIndex = panel.getList().getSelectedIndex();
			if (selectedIndex != -1 && selectedIndex < personasTotal.size()) {
				Persona persona_seleccionada = personasTotal.get(selectedIndex);
				persona_modificar = persona_seleccionada;
				panel.getTxtNombre().setText(persona_seleccionada.getNombre());
				panel.getTxtApellido().setText(persona_seleccionada.getApellido());
				panel.getTxtDNI().setText(persona_seleccionada.getDNI());
				panel.getTxtDNI().setEditable(false);
			} else {
				LlenarTabla();
			}
		}
	}

	private void LlenarTabla() {
		this.personasTotal = (ArrayList<Persona>) this.personaNegocio.listar(); 
		llenarJList(this.personasTotal);
		panel.getTxtNombre().setText("");
		panel.getTxtApellido().setText("");
		panel.getTxtDNI().setText("");
		persona_modificar=null;
	}

	
}