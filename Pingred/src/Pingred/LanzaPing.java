package Pingred;

import java.io.IOException;
import java.net.InetAddress;


public class LanzaPing  implements Runnable{
	
	
//	public static InetAddress[] consulta;	
	InetAddress[] consulta = new InetAddress[255];
	boolean llego=false;
	
	
	int idhilocopy;
	
	public LanzaPing(InetAddress mydireccionIPconsulta,int idhilo) {
	 	
		idhilocopy=idhilo;
	//	System.out.println("LA IDE DEL HILO ES: "+idhilo);
		consulta[idhilo]=mydireccionIPconsulta;						
	//	System.out.println("AL LLEGAR: "+consulta[idhilo].getCanonicalHostName());	

	}

	public void run(){
		try {
		//	System.out.println("CREO LA FILA PARA EL HILO: "+Pingred.filas);
			Pingred.modelo.addRow(Comenzar.filas); //PINTA NUEVA FILA
	 		Pingred.filas++;
	 		
	 	
		//	System.out.println("Ping hilo a: "+ consulta[Comenzar.id].getCanonicalHostName());
	 	//	System.out.println("EL COPY VALE: "+idhilocopy);
	 	//	System.out.println("HAGO PING"+consulta[idhilocopy]);
			llego=consulta[idhilocopy].isReachable(2000);
			if (llego){ //LLEGO A LA MÁQUINA																
				Pingred.modelo.setValueAt (consulta[idhilocopy].getCanonicalHostName(), idhilocopy, 0);
				Pingred.modelo.setValueAt (consulta[idhilocopy].getHostAddress(), idhilocopy, 1);
				Pingred.modelo.setValueAt (llego, idhilocopy, 2);
				Pingred.modelo.setValueAt (consulta[idhilocopy].getCanonicalHostName(), idhilocopy, 3);
				}
			
			else{ //NO LLEGO A LA MÁQUINA
			//	System.out.println("NO LLEGO A LA MÁQUINA DEL HILO: "+idhilocopy);
				Pingred.modelo.setValueAt ("", idhilocopy, 0);
				Pingred.modelo.setValueAt (consulta[idhilocopy].getHostAddress(), idhilocopy, 1);
				Pingred.modelo.setValueAt (llego, idhilocopy, 2);
				Pingred.modelo.setValueAt ("NO LLEGO", idhilocopy, 3);					
				}					
		//	System.out.println("ACABO hilo: "+idhilocopy+ consulta[idhilocopy].getCanonicalHostName());
			

		} 
		catch (IOException e) {
			
			e.printStackTrace();
		} 
	

	}//FIN DEL RUN

} //FIN DE LA CLASE