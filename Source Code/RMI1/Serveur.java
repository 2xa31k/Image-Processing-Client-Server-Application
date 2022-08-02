
import java.rmi.*;
import java.rmi.registry.*;
public class Serveur {



    public static void main(String args[]) {
        try{
        	//System.setProperty("java.rmi.server.hostname", "javaprojet.ddns.net");
            System.setProperty("java.rmi.server.hostname", "localhost");
            
            Filter skeleton=new ApplyFilter();
            LocateRegistry.createRegistry(9800);
            Naming.rebind("rmi://localhost:9800/filtre",skeleton);
            //Naming.rebind("rmi://javaprojet.ddns.net:9900/filtre",skeleton);
            System.out.println("Server is ready ...");
        }catch(Exception e){System.out.println(e);} 
    }

}

