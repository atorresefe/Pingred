package Pingred;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class Guardar implements ActionListener {


	public void actionPerformed(ActionEvent u) {
		
		try{ 	  
	  		  JFileChooser ventana_explorer= new JFileChooser();
	  		  ventana_explorer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	  		  int error_ventana_explorer = ventana_explorer.showOpenDialog(ventana_explorer);		     		      		      		        
	  		  File directorio_seleccion=null;
	  		  if(error_ventana_explorer == JFileChooser.APPROVE_OPTION){
	  			  directorio_seleccion = ventana_explorer.getSelectedFile();
	  		  }		 		
	  		  Pingred.directorio_seleccion_cadena=directorio_seleccion.toString();  			       		       
	  	  	}
		catch(NullPointerException e){
  		 
  		   
  	  }		    	 
	  	  finally{
		   
	  	  }
		

	}

}
