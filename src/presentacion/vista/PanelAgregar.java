package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2287695659009951162L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;

	public PanelAgregar() {
		setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 34, 46, 14);
		add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(35, 70, 46, 14);
		add(lblApellido);

		lblDni = new JLabel("DNI");
		lblDni.setBounds(35, 106, 46, 14);
		add(lblDni);

		txtNombre = new JTextField();
		txtNombre.setBounds(138, 31, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(138, 67, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(138, 103, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(74, 142, 89, 23);
		add(btnAceptar);

	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblDNI() {
		return lblDni;
	}

	public void setLblDNI(JLabel lblDNI) {
		this.lblDni = lblDNI;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtDNI() {
		return txtDni;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDni = txtDNI;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
