package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;
import presentacion.vista.VentanaPrincipal;

public class ControladorVentPrinc implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;

	private PanelAgregar panelAgregar;
	private PanelEliminar panelEliminar;
	private PanelModificar panelModificar;
	private PanelListar panelListar;
	private PersonaNegocio persona;
	private ArrayList<Persona> personasTotal;

	public ControladorVentPrinc(VentanaPrincipal vista, PersonaNegocio personaNegocio) {

		this.ventanaPrincipal = vista;
		this.persona = personaNegocio;

		this.panelAgregar = new PanelAgregar();
		new ControladorAgregar(panelAgregar,persona);

		this.panelModificar = new PanelModificar();
		new ControladorModificar(panelModificar, persona);

		this.panelEliminar = new PanelEliminar();
		new ControladorEliminar(panelEliminar,persona);

		this.panelListar = new PanelListar();
		new ControladorListar(panelListar);

		this.ventanaPrincipal.getMenuAgregar().addActionListener(a -> EventoClickMenu_Panel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a -> EventoClickMenu_Panel_ModificarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a -> EventoClickMenu_Panel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a -> EventoClickMenu_Panel_ListarPersona(a));
	}

	public void showView(JPanel view) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(view);
		ventanaPrincipal.getContentPane().revalidate();
		ventanaPrincipal.getContentPane().repaint();
	}

	// EVENTOS DEL MENU
	public void EventoClickMenu_Panel_AgregarPersona(ActionEvent a) {
		showView(panelAgregar);
	}

	public void EventoClickMenu_Panel_ModificarPersona(ActionEvent a) {
		showView(panelModificar);

		this.personasTotal = (ArrayList<Persona>) persona.listar();
		llenarJList(this.personasTotal, panelModificar.getList());
	}

	public void EventoClickMenu_Panel_EliminarPersona(ActionEvent a) {
		showView(panelEliminar);

		this.personasTotal = (ArrayList<Persona>) persona.listar();
		llenarJList(this.personasTotal, panelEliminar.getList());
	}

	public void EventoClickMenu_Panel_ListarPersona(ActionEvent a) {
		showView(panelListar);
		refrescarTabla();
	}

	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	public void llenarTabla(List<Persona> personasEnTabla) {
		this.panelListar.getModelPersonas().setRowCount(0); 
		this.panelListar.getModelPersonas().setColumnCount(0);
		this.panelListar.getModelPersonas().setColumnIdentifiers(this.panelListar.getNombreColumnas());

		for (Persona p : personasEnTabla) {
			String dni = p.getDNI();
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			Object[] fila = { nombre, apellido, dni };
			this.panelListar.getModelPersonas().addRow(fila);
		}
	}

	public void llenarJList(List<Persona> personasEnLista, javax.swing.JList<String> list) {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Persona p : personasEnLista) {
			model.addElement(p.getNombre() + " " + p.getApellido() + " - " + p.getDNI());
		}
		list.setModel(model);
	}

	public void refrescarTabla() {
		this.personasTotal = (ArrayList<Persona>) persona.listar();
		this.llenarTabla(this.personasTotal);
	}
}
