import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.*;

import javax.imageio.ImageIO;

public class OpenConnexion implements Runnable,Serializable{
    private ServeurList SL=new ServeurList();
    private ConnectionServ[] CS=SL.GetServers();
    public String Fname;
    private Image iOrg;
    private Image Res=new Image();
    public OpenConnexion(String FN,Image Img)
    {
        this.Fname=FN;
        this.iOrg=Img;
    }
    public int getRandomNumber() {
        return (int)Math.floor(Math.random()*(7-0+1)+0);
    }
    
    public void ConnectRMI(ConnectionServ C,Image img,String Fn) throws NotBoundException, IOException 
    {
		Filter stub = C.ConnectRMI();
        if(Fn.equals("Detection"))Res.imgFromByteArr(stub.Detection(img.imgToByteArr()));
        else if(Fn.equals("Gris"))Res.imgFromByteArr(stub.Gris(img.imgToByteArr()));
        else if(Fn.equals("Sepia"))Res.imgFromByteArr(stub.Sepia(img.imgToByteArr()));
        else if(Fn.equals("InvCol"))Res.imgFromByteArr(stub.InvCol(img.imgToByteArr()));
        else if(Fn.equals("Gauss"))Res.imgFromByteArr(stub.Gauss(img.imgToByteArr()));
        else if(Fn.equals("Flou"))Res.imgFromByteArr(stub.Flou(img.imgToByteArr()));
        else if(Fn.equals("Sharpen"))Res.imgFromByteArr(stub.Sharpen(img.imgToByteArr()));
        else if(Fn.equals("Blur"))Res.imgFromByteArr(stub.Blur(img.imgToByteArr()));
        Res.SaveImg();
    }

    public void ConnectSocket(ConnectionServ C,Image img,String Fn) throws IOException,UnknownHostException
    {
        Socket s = C.ConnectSocket();
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject(img.imgToByteArr());
        out.writeObject(Fn);
        BufferedInputStream in = new BufferedInputStream(s.getInputStream());
        Res=new Image(ImageIO.read(in));
        this.Res.SaveImg();
        s.close();
    }

    public void run(){
        int rnd=getRandomNumber();
        if(CS[rnd].getType().equals("RMI"))
        {
            try {
                this.ConnectRMI(CS[rnd], this.iOrg,this.Fname);
            } catch (Exception e) {
                e.printStackTrace();
             }
         }
        else{
            try {
                this.ConnectSocket(CS[rnd], this.iOrg,this.Fname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
