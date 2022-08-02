import java.io.*;
import java.net.*;
public class Serveur {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Serveur:");
        ServerSocket server = new ServerSocket(9700); 
        while(true)
        {
        Socket s = server.accept();
        Thread T=new Thread(new ApplyFilter(s));
        T.start();
        }
    }
}