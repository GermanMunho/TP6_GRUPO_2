package Main;

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

public class PaginaBase extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar;

	private JPanel contentPane;

	private PanelAgregar panelAgregar;
	private PanelModificar panelModificar;
	private PanelEliminar panelEliminar;
	private PanelListar panelListar;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaBase frame = new PaginaBase();
					frame.setTitle("Trabajo Practico Nº6");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PaginaBase() {
		IniciarComponentes();
		IniciarAcciones();

	}

	private void IniciarComponentes() {
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

	private void IniciarAcciones() {
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				panelAgregar = new PanelAgregar();
				contentPane.add(panelAgregar);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				panelModificar = new PanelModificar();
				contentPane.add(panelModificar);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				panelEliminar = new PanelEliminar();
				contentPane.add(panelEliminar);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				panelListar = new PanelListar();
				contentPane.add(panelListar);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});

	}

}
