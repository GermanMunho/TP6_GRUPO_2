package Main;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelModificar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	public PanelModificar() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(21, 54, 367, 201);
		add(list);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(351, 266, 89, 23);
		add(btnModificar);
		
		JLabel lblSelecioneLaPersona = new JLabel("Selecione la Persona a Modificar");
		lblSelecioneLaPersona.setBounds(21, 29, 177, 14);
		add(lblSelecioneLaPersona);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(21, 266, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(128, 266, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(238, 266, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
	}

}
