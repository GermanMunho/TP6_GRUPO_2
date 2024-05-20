package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;


public class PanelListar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8032949896262579677L;
	
	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre","Apellido","Dni"};
	
	public PanelListar() {
		setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(15, 30, 383, 126);
		this.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
	
}
