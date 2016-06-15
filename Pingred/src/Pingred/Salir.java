package Pingred;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;


/*
  public class Salir implements ActionListener {
 
	
	 public void actionPerformed(ActionEvent e) { 
       	Pingred.principal.dispose();
		
     }	
}

*/
public class Salir implements ActionListener {

	 public void actionPerformed(ActionEvent e) { 
      
		 SwingUtilities.invokeLater(new Runnable(){		 
			 public void run(){			 				
				 Pingred.principal.dispose();
			 }		
		    });	 
	 
    }	
}








