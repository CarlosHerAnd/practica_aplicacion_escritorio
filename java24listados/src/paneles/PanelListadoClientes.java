package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel {
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;

	public PanelListadoClientes() {
		this.add(new JLabel("Soy el panel de listado de cliente"));
	}// end panellistadoclientes

	public void refrescarClientes() {
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabla.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabla);

        //Add the scroll pane to this panel.
        add(scrollPane);
		removeAll();//quito todo lo que tenga antes el dentro el panel 
		this.add(scrollPane);
		
	}// end refrescarClientes

}// end class
