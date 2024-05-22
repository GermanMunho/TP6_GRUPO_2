package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class PanelModificar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDNI;
    private JButton btnModificar;
    private JList<String> list;

    public PanelModificar() {
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(27, 224, 46, 14);
        add(lblNombre);

        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(27, 252, 46, 14);
        add(lblApellido);

        JLabel lblDNI = new JLabel("DNI");
        lblDNI.setBounds(27, 196, 46, 14);
        add(lblDNI);

        txtNombre = new JTextField();
        txtNombre.setBounds(83, 221, 86, 20);
        add(txtNombre);
        txtNombre.setColumns(10);

        txtApellido = new JTextField();
        txtApellido.setBounds(83, 249, 86, 20);
        add(txtApellido);
        txtApellido.setColumns(10);

        txtDNI = new JTextField();
        txtDNI.setBounds(83, 193, 86, 20);
        txtDNI.setEditable(false);
        add(txtDNI);
        txtDNI.setColumns(10);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(190, 192, 89, 23);
        add(btnModificar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 32, 253, 150);
        add(scrollPane);

        list = new JList<>();
        scrollPane.setViewportView(list);
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public JTextField getTxtDNI() {
        return txtDNI;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JList<String> getList() {
        return list;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

