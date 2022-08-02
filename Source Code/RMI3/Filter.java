import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.IOException;
public interface Filter extends Remote {
    public byte[] Detection(byte[] i)throws RemoteException, IOException;
    public byte[] Gris(byte[] i)throws RemoteException, IOException;
    public byte[] InvCol(byte[] i)throws RemoteException, IOException;
    public byte[] Sepia(byte[] i)throws RemoteException, IOException;
    public byte[] Blur(byte[] i)throws RemoteException, IOException;
    public byte[] Gauss(byte[] i)throws RemoteException, IOException;
    public byte[] Sharpen(byte[] i)throws RemoteException, IOException;
    public byte[] Flou(byte[] i)throws RemoteException, IOException;
}
