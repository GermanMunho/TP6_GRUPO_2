package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;

public class PanelListar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8032949896262579677L;
	private JTable table;
	public PanelListar() {
		setLayout(null);
		
		table = new JTable();
		table.setBorder(new CompoundBorder());
		table.setColumnSelectionAllowed(true);
		table.setBounds(62, 220, 312, -168);
		add(table);
	}
}
