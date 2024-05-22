package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelEliminar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JList<String> list;
    private JButton btnEliminar;

    public PanelEliminar() {
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 34, 300, 150);
        add(scrollPane);

        list = new JList<>();
        scrollPane.setViewportView(list);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(150, 200, 100, 30);
        add(btnEliminar);
    }

    public JList<String> getList() {
        return list;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
