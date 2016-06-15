package Pingred;

import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ComprobarIP extends InputVerifier {

	 Pattern pat = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."+
             "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
             "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
             "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");  		
		                       		           
          
          public boolean shouldYieldFocus(JComponent input) {
              boolean inputOK = verify(input);
              if (inputOK) {
            	  
                  return true;
              } else {
            	
                  Toolkit.getDefaultToolkit().beep();
                  
                JFrame error_ip = new JFrame("COMPROBANDO IP");
				
				error_ip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
				error_ip.setSize(300, 300);
				error_ip.setResizable(false);
				error_ip.setLocation(500, 500);
                  
                  
                JOptionPane.showMessageDialog(error_ip,
                      "PARECE QUE ESAS IPs NO SON VALIDAS",	                              
                      "Comprobando ip",
                      JOptionPane.INFORMATION_MESSAGE);
                  return false;
              }
          }

	               

      public boolean verify(JComponent input) {
          JTextField field = (JTextField) input;
          Matcher m = pat.matcher(field.getText());
          return m.matches();
      }
	
	
	
	
	
}
