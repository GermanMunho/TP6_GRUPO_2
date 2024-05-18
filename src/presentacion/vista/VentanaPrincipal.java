package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar;

	private JPanel contentPane;

	public VentanaPrincipal() {
		IniciarComponentes();

	}

	private void IniciarComponentes() {
		setBounds(150, 150, 500, 400);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);

		mntmAgregar = new JMenuItem("Agregar");
		mnPersona.add(mntmAgregar);

		mntmModificar = new JMenuItem("Modificar");
		mnPersona.add(mntmModificar);

		mntmEliminar = new JMenuItem("Eliminar");
		mnPersona.add(mntmEliminar);

		mntmListar = new JMenuItem("Listar");
		mnPersona.add(mntmListar);

	}
	
	public JMenuItem getMenuEliminar() {
		return mntmEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.mntmEliminar = menuEliminar;
	}

	public JMenuItem getMenuAgregar() {
		return mntmAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.mntmAgregar = menuAgregar;
	}
	public JMenuItem getMenuListar() {
		return mntmListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.mntmListar = menuListar;
	}
	public JMenuItem getMenuModificar() {
		return mntmModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		this.mntmModificar = menuModificar;
	}

	

}
