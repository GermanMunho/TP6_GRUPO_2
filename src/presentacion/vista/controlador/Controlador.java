package presentacion.vista.controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.PersonaNegocio;
import entidad.Persona;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;
import presentacion.vista.VentanaPrincipal;

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
		
	}
	
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelAgregar);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
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