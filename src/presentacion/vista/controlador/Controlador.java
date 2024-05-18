package presentacion.vista.controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.PersonaNegocio;
import entidad.Persona;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;
import presentacion.vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controlador implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregar panelAgregar;
	private PanelEliminar panelEliminar;
	private PanelListar panelListar;
	private PanelModificar panelModificar;
	private PersonaNegocio personaNegocio;
	private ArrayList<Persona> personasTotal;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio personaNegocio) {
		
		this.ventanaPrincipal = vista;
		this.personaNegocio = personaNegocio;
		
		this.panelAgregar = new PanelAgregar();
		this.panelEliminar = new PanelEliminar();
		this.panelListar = new PanelListar();
		this.panelModificar = new PanelModificar();
		
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		
		this.panelAgregar.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPersona_PanelAgregarPersonas(a));

		
	}
	
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelAgregar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickBoton_AgregarPersona_PanelAgregarPersonas(ActionEvent a) {		
		String mensaje;
		if(this.panelAgregar.getTxtDni().getText().isEmpty() || this.panelAgregar.getTxtNombre().getText().isEmpty() || this.panelAgregar.getTxtApellido().getText().isEmpty()) {
			mensaje = "Es necesario completar todos los campos";
			this.panelAgregar.mostrarMensaje(mensaje);
		}
		else {
			String DNI = this.panelAgregar.getTxtDni().getText();
			String nombre = this.panelAgregar.getTxtNombre().getText();
			String apellido = this.panelAgregar.getTxtApellido().getText();
			Persona p = new Persona(DNI,nombre,apellido);
			
			List<Persona> lista = new ArrayList<Persona>();
			lista = personaNegocio.listar();
			int b = 0;
			for(Persona per: lista) {
				if(per.getDNI().equals(p.getDNI())) {
					b = 1;
					mensaje = "DNI ya registrado";
					this.panelAgregar.mostrarMensaje(mensaje);
				}
			}
			if(b==0) {
				personaNegocio.agregar(p);
				mensaje = "Persona agregada";
				this.panelAgregar.mostrarMensaje(mensaje);
				this.panelAgregar.getTxtNombre().setText("");
				this.panelAgregar.getTxtApellido().setText("");
				this.panelAgregar.getTxtDni().setText("");
			}
		}
	}
	
	public void  EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelEliminar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void  EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelListar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void  EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelModificar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}