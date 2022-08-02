import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
public class ApplyFilter implements Runnable{
    Socket s;
    FiltersList F=new FiltersList();
    public ApplyFilter(Socket socket){
        this.s=socket;
    }
    public void WriteClient(String Fn) throws IOException
    {
        File myLog = new File("LOG.txt");
      LocalDateTime myDateObj = LocalDateTime.now();
      DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
      String formattedDate = myDateObj.format(myFormatObj);
      if (!myLog.exists()) {
          myLog.createNewFile();
          FileWriter myWriter = new FileWriter("LOG.txt",true);
          BufferedWriter bw = new BufferedWriter(myWriter);
          bw.write("Client-Server4:"+s.getRemoteSocketAddress().toString()+" "+Fn+"  le:"+formattedDate+"\n");
          bw.close();
          myWriter.close();
      } else {
          FileWriter myWriter = new FileWriter("LOG.txt",true);
          BufferedWriter bw = new BufferedWriter(myWriter);
          bw.write("Client-Server4:"+s.getRemoteSocketAddress().toString()+" "+Fn+"  le:"+formattedDate+"\n");
          bw.close();
          myWriter.close();
      }
    }
    public void ImgFilter() throws IOException, ClassNotFoundException{
        System.out.println("---Recevoir l'Image---");  
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        byte[] byteimg = (byte[]) in.readObject();
        Image i=new Image();
        i.imgFromByteArr(byteimg);
        BufferedImage Res=i.getImg();
        String Fn=(String)in.readObject(); 
        WriteClient(Fn);
        if(Fn.equals("Detection")) Res = F.DetectionF(Res);
        else if(Fn.equals("Gris")) Res=F.GrisF(Res);
        else if(Fn.equals("Gauss")) Res=F.GaussF(Res);
        else if(Fn.equals("Sepia")) Res=F.SepiaF(Res);
        else if(Fn.equals("Blur")) Res=F.BlurF(Res);
        else if(Fn.equals("InvCol")) Res=F.InvColF(Res);
        else if(Fn.equals("Flou")) Res=F.FlouF(Res);
        else if(Fn.equals("Sharpen")) Res=F.SharpenF(Res);
        BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream());
        System.out.println("---Envoyer l'Image---");
        ImageIO.write(Res, "png", out);
    }
public void run()
{
    try {
        ImgFilter();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}
