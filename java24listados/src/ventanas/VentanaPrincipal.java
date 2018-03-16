package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoClientes;
import paneles.PanelRegistroClientes;

public class VentanaPrincipal extends JFrame implements ActionListener{
	//Paneles de la ventana
	private PanelRegistroClientes panelRegistroClientes =
			new PanelRegistroClientes();
	private PanelListadoClientes panelListadoClientes =
			new PanelListadoClientes();
	//barra de menu
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuAyuda = new JMenu("ayuda");
	

	//preparacion de la ventana principal 
	public VentanaPrincipal() {
		
		//preparo menu
		JMenuItem clientesInsertar = new JMenuItem("Insertar Cliente");
		JMenuItem clientesListar = new JMenuItem("Listar clientes");
		menuClientes.add(clientesInsertar);
		menuClientes.add(clientesListar);
		barraDeMenu.add(menuClientes);
		barraDeMenu.add(menuAyuda);
		this.setJMenuBar(barraDeMenu);
		
		//voy a decir a las opciones de menu quien las va a atender cuando se las clicke
		clientesInsertar.addActionListener(this);
		clientesListar.addActionListener(this);
		//preparo ventana
		
		this.setSize(800,600);
		this.setLocation(50,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//cuando arranque esta ventana se muestre el panel de registro cliente
		
		this.setContentPane(panelRegistroClientes);
		this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("atiendo a: " + e.getActionCommand());
		
		if(e.getActionCommand().equals("Insertar Cliente")){
		setContentPane(panelRegistroClientes);
		
	} else if(e.getActionCommand().equals("Listar clientes")){
		setContentPane(panelListadoClientes);
		panelListadoClientes.refrescarClientes();
	}
	
		SwingUtilities.updateComponentTreeUI(this);
		
}
}

