package Pingred;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

//import javax.swing.SwingUtilities;



public class Comenzar implements ActionListener{
	
	public static InetAddress direccionIPconsulta;
//	public static boolean z=false;
	public static String ipconsulta="";
//	public static  int g=0;
	
	
	static int ip1primeraparte=0;
	static int ip1segundaparte=0;
	static int ip1terceraparte=0;
	static int ip1cuartaparte=0;
	
	int primeraparte=0;
	int segundaparte=0;
	int terceraparte=0;
	int cuartaparte=0;
	
	static int ip2primeraparte=0;
	static int ip2segundaparte=0;
	static int ip2terceraparte=0;
	static int ip2cuartaparte=0;
	
	static boolean sigue=true;	
	
	static Object [] filas = new Object[4];
	static int id=0;
	
	//static int[] cadenahilos =new int[100];
//********************************************************************************	
public static int  convierteaentero (char aconvertir){
		
		switch((int)aconvertir){
		
		case 48:
	        return(0);	     		
		case 49:
			return(1);	     
		case 50:
			return(2);	 
		case 51:
			return(3);	       
		case 52:
			return(4);	        
		case 53:
			return(5); 	       
		case 54:
			return(6);	       	        
		case 55:
			return(7);	       
		case 56:
			return(8);	      
		case 57:
			return(9);
		case 46:
			return(46);
			
	    default:
	    //    System.out.println("No puedo sacar el entero del char");
	        
		}
		return (aconvertir);	      	   				
	}
	
//*****************************************************************************	
//*****************************************************************************

public void textoToip(String ipe){
	
									
					 	
	  	//	 	Pingred.ipInicio.length();
	  	//	 	Pingred.ipFin.length();
	  			 	
	  		 	int bufferparteip=0;
	  		 	
	  		 	int w=0;
	  		 	int r=0;
	  		 	
	  		 	//System.out.println(Pingred.ipFin.length());
	  		 	for (int i=0; i<ipe.length(); i++){		  		 		
		  		 //	System.out.println("SIGUIENTE VALOR LEIDO: "+convierteaentero(Pingred.ipFin.charAt(i)));			  		 	
	  		 		if ((convierteaentero(ipe.charAt(i))==46) ||(i==(ipe.length())-1)){	  		 			
	  		 			if(i==(ipe.length())-1){	  		 				
	  		 				i++;
	  		 				w++;
	  		 			}
	  		 			if(w==0){
	  		 				bufferparteip=convierteaentero(ipe.charAt(i));	  		 			
	  		 			}
	  		 			if (w==1){	  		 			
	  		 				bufferparteip=convierteaentero(ipe.charAt(i-1));	  		 				
	  		 			}
	  		 			if(w==2){	  		 				
	  		 				bufferparteip=10*convierteaentero(ipe.charAt(i-2))+convierteaentero(ipe.charAt(i-1));	  		 				
	  		 			}
	  		 			if (w==3){		  		 					  		 				
	  		 				bufferparteip=100*convierteaentero(ipe.charAt(i-3))+10*convierteaentero(ipe.charAt(i-2))+convierteaentero(ipe.charAt(i-1));	  		 				
	  		 			}		  		 			
	  		 			w=0;
	  		 			r++;	  		 			
	  		 			
	  		 			switch(r){
	  		 			case 1:
	  		 				primeraparte=bufferparteip;
	  		 			case 2:
	  		 				segundaparte=bufferparteip;
	  		 			case 3:
	  		 				terceraparte=bufferparteip;
	  		 			case 4:
	  		 				cuartaparte=bufferparteip;
	  		 			}
	  		 		}
	  		 		else{	  		 			  		 					  		 			  		 				  		 			
	  		 			w++;
	  		 		}	  		 	
	  		 	}			 		  
	
}

//*******************************************************************************
	

	public void actionPerformed (ActionEvent e){
		
		Runnable miRunnablePrincipal = new Runnable(){
			
			public void run() {				
				Pingred.botonComenzar.setEnabled(false);
				Pingred.ipInicial.setEnabled(false);
				Pingred.ipFinal.setEnabled(false);
				int numhilo=0;
				
				System.out.println("Numero de filas"+Pingred.filas);
				
				try{ 		
					
					if (Pingred.filas>0){
						//System.out.println("entro en el if");
						while (Pingred.filas>=1){
						//	System.out.println("entro en el while");
						//	System.out.println("borrofila");
						//	System.out.println("FILAS: "+Pingred.filas);
						
							//Pingred.tabla.removeRowSelectionInterval(Pingred.filas, 1); 
							Pingred.modelo.removeRow (Pingred.filas-1);
							Pingred.filas--;
							System.out.println("Filas: "+Pingred.filas);
						}
					}

				
				//	Pingred.ipInicial.setText("172.17.103.1");
				//	Pingred.ipFinal.setText("172.17.103.8"); 
					ComprobarIP comprueba=new ComprobarIP();
					if ((comprueba.shouldYieldFocus(Pingred.ipInicial))&&			
							 (comprueba.shouldYieldFocus(Pingred.ipFinal))){								
					
					
						Pingred.ipInicio= Pingred.ipInicial.getText();
			  		 	Pingred.ipFin = Pingred.ipFinal.getText();
			  		 	
			  		 	textoToip(Pingred.ipInicio);
			  		 	ip1primeraparte=primeraparte;
			  		 	ip1segundaparte=segundaparte;
			  		 	ip1terceraparte=terceraparte;
			  		 	ip1cuartaparte=cuartaparte;
			  		 	
			  		 	textoToip(Pingred.ipFin);
			  		 	ip2primeraparte=primeraparte;
			  		 	ip2segundaparte=segundaparte;
			  		 	ip2terceraparte=terceraparte;
			  		 	ip2cuartaparte=cuartaparte;	
					
			  		 	
			  		 	String ip1="";
			  		 //	String ip2="";
			  		// 	String ipconsulta="";
						ip1=String.valueOf(ip1primeraparte)+"."+String.valueOf(ip1segundaparte)+"."+String.valueOf(ip1terceraparte)+"."+String.valueOf(ip1cuartaparte);
					//	ip2=String.valueOf(ip2primeraparte)+"."+String.valueOf(ip2segundaparte)+"."+String.valueOf(ip2terceraparte)+"."+String.valueOf(ip2cuartaparte);
						ipconsulta=ip1;
						
				//		InetAddress direccionIP1;						
				//		direccionIP1 = InetAddress.getByName(ip1); //creo la IP
						
				//		InetAddress direccionIP2;						
				//		direccionIP2 = InetAddress.getByName(ip2); //creo la IP
						
						 						
						direccionIPconsulta = InetAddress.getByName(ipconsulta); //creo la IP
						//System.out.println("IP asocio: "+direccionIPconsulta.getCanonicalHostName());
					
					
						//	System.out.println("dentro");
						//	Pingred.modelo.addRow ( fila );
						
						boolean primera=true;
						//static boolean sigue=true;	
									
			     while (sigue){		
			    	 
			    	 							
							//	System.out.println("Ping a: "+ipconsulta);
								//	System.out.println(direccionIPconsulta.isReachable(1000));						
			    	 	//	Pingred.modelo.addRow ( fila ); //PINTA NUEVA FILA
			    	 	//	Pingred.filas++;
								
								
			    	 		if (primera){
			    	 			System.out.println("Lanzo el primer hilo con ID: "+numhilo);
			    	 			System.out.println("Lanzo el primer hilo con IP: "+direccionIPconsulta);
			    	 			Thread hilo =new Thread(new LanzaPing(direccionIPconsulta,numhilo));
			    	 			Pingred.lanzapines++;
			    	 			numhilo++;        	 			
								hilo.start();
								primera =false;								

			    	 		}				 											
					 
								if ((ip1cuartaparte==254) || (ip1cuartaparte==ip2cuartaparte)){
									ip1cuartaparte=1;																				
									//System.out.println("ACABO CUARTA");														
									if ((ip1terceraparte==255) || (ip1terceraparte==ip2terceraparte)){
										ip1terceraparte=0;
						
										if ((ip1segundaparte==255) || (ip1segundaparte==ip2segundaparte)){
											ip1segundaparte=0;

											if ((ip1primeraparte==255) || (ip1primeraparte==ip2primeraparte)){
											//	System.out.println("he acabado");
												sigue=false;
												}
												else{
												ip1primeraparte++;
												}
																	
											}
											else{
											ip1segundaparte++;
											}

										}
										else{
										ip1terceraparte++;							
										direccionIPconsulta = InetAddress.getByName(ipconsulta);
										}					

								}
							else{
								ip1cuartaparte++;						
								}																			
								ipconsulta=String.valueOf(ip1primeraparte)+"."+String.valueOf(ip1segundaparte)+"."+String.valueOf(ip1terceraparte)+"."+String.valueOf(ip1cuartaparte);
								direccionIPconsulta = InetAddress.getByName(ipconsulta);
								if (sigue){						
								//	System.out.println("Lanzo hilo con ID: "+numhilo);
								//System.out.println("Parametro al Thread: "+direccionIPconsulta.getCanonicalHostName());						
								Thread hilo =new Thread(new LanzaPing(direccionIPconsulta,numhilo));
								Pingred.lanzapines++;								
								numhilo++;
								//id++;
								hilo.start();					         						
								}
			      
			     } //FIN DEL WHILE
								
			     	sigue=true; 
			     	
					}		  		 			
					else{						
							//NO HAGO NADA
					}
					  		 
				 }
				catch (UnknownHostException noencuentrohost) {			
					noencuentrohost.printStackTrace();
				}
				
				catch(NullPointerException f){
					f.printStackTrace();
				  	} 
//				catch (IOException go) {		
//					go.printStackTrace();
			//} 		
				
				
				  finally{
			   
				  }
	    
				while(Pingred.lanzapines!=0){
					System.out.println("LANZAPINES= "+Pingred.lanzapines);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
				Pingred.botonComenzar.setEnabled(true);
				Pingred.ipInicial.setEnabled(true);
				Pingred.ipFinal.setEnabled(true);
			}//FIN RUN	
			
					
		};// FIN DEL RUNNABLE
		
		Thread hiloPrincipal = new Thread (miRunnablePrincipal);		
	    hiloPrincipal.start();
	    
	    
	} //FIN DEL ACTION PERFORMED

}//FIN CLASE