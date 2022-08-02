
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class ConnectionServ{
    private String IP;
    private String port;
    private String Type;
    public ConnectionServ(String ip,String p,String T)
    {
        this.IP=ip;
        this.port=p;
        this.Type=T;
    }
    public String getType()
    {
        return this.Type;
    }
    public Filter ConnectRMI() throws NotBoundException, IOException 
    {
		Filter stub = (Filter)Naming.lookup("rmi://"+IP+":"+this.port+"/filtre");
        return stub;
    }
    public Socket ConnectSocket() throws IOException,RemoteException,UnknownHostException
    {
        Socket s = new Socket(this.IP, Integer.parseInt(this.port));
		return s;
    }

}