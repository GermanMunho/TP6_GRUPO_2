package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelEliminar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7274074834103372746L;

	public PanelEliminar() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(123, 39, 188, 201);
		add(list);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(171, 251, 89, 23);
		add(btnAceptar);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setBounds(161, 11, 139, 14);
		add(lblEliminarUsuarios);
	}
}

