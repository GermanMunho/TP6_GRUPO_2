package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2287695659009951162L;
	private JTextField textNombre;
	private JTextField txtNombre;
	private JTextField txtDni;
	public PanelAgregar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 34, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(35, 70, 46, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(35, 106, 46, 14);
		add(lblDni);
		
		textNombre = new JTextField();
		textNombre.setBounds(138, 31, 86, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 67, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(138, 103, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(74, 142, 89, 23);
		add(btnAceptar);
	}
}
