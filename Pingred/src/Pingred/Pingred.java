package Pingred;

import java.awt.BorderLayout;

import java.awt.Container;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class Pingred {
	

	public static JFrame principal =new JFrame("PING");	
	static String directorio_seleccion_cadena;
	public static JTextField ipInicial = new JTextField(15);
	public static JTextField ipFinal = new JTextField(15);
	public static String ipInicio=null;
	public static String ipFin=null;
	
	//public static JTable tabla = new JTable(4,4);
	public static DefaultTableModel modelo = new DefaultTableModel();
	public static JTable tabla = new JTable(modelo);
	static int filas=0;
	
	public static void main(String[] args) {
	
		
		
		Abrir abre=new Abrir();
		Guardar guarda=new Guardar();
		Salir sal=new Salir();
		
	 
	 
	 	Comenzar comienza=new Comenzar();  
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		principal.setBounds(100, 100, 150, 150);

		tabla.setFillsViewportHeight(true); //creo el contenedor scroll para la tabla		
		tabla.getTableHeader();		
		modelo.addColumn("Máquina");
		modelo.addColumn("IP");
		modelo.addColumn("OTRO");
		modelo.addColumn("OTRA");
		
		//JTextField ipInicial = new JTextField(15);
		//JTextField ipFinal = new JTextField(15);
		JLabel ipInicialTexto =new JLabel("IP Inicial");
		JLabel ipFinalTexto =new JLabel("IP Final");
		JButton botonComenzar= new JButton ("Comenzar");
		
		JMenuBar menu=new JMenuBar();
		JMenu archivo=new JMenu("Archivo");
		JMenu edicion=new JMenu("Edicion");			
		JMenuItem opcion1=new JMenuItem("Abrir");
		JMenuItem opcion2=new JMenuItem("Guardar");
		JMenuItem opcion3=new JMenuItem("Salir");
		
		opcion1.addActionListener(abre);
		opcion2.addActionListener(guarda);
		opcion3.addActionListener(sal);
		botonComenzar.addActionListener(comienza);		
		
		archivo.add(opcion1);		
		archivo.add(opcion2);
		archivo.add(opcion3);
			
		menu.add(archivo);
		menu.add(edicion);
					
		Container contenedor = principal.getContentPane();
	
		contenedor.setLayout(new BorderLayout());
			
		JPanel contentPaneMenu = new JPanel(new BorderLayout());
		JPanel contentPaneOpciones = new JPanel();		
	//	JPanel contentPaneTabla = new JPanel(new BorderLayout());
		JScrollPane barraScroll = new JScrollPane(tabla);	
		
		contentPaneMenu.add(menu);
		
		contentPaneOpciones.add(ipInicialTexto);
		contentPaneOpciones.add(ipInicial);
		contentPaneOpciones.add(ipFinalTexto);		
		contentPaneOpciones.add(ipFinal);
		contentPaneOpciones.add(botonComenzar);

	//	contentPaneTabla.add(tabla);
	//	contentPaneTabla.add(barraScroll);
				
		
		contenedor.add(contentPaneMenu, BorderLayout.NORTH );
		contenedor.add(contentPaneOpciones, BorderLayout.CENTER);
	//contenedor.add(contentPaneTabla, BorderLayout.CENTER);
		contenedor.add(barraScroll, BorderLayout.SOUTH);

		/*  **********************************

		
		
		****************************************** */
		
		
		
		principal.pack();
		principal.setVisible(true);

			
	}
	
	
	
}
