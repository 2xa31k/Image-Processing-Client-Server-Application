import java.rmi.*;
import java.rmi.server.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
public class ApplyFilter extends UnicastRemoteObject implements Filter{
    private FiltersList F=new FiltersList();
ApplyFilter()throws RemoteException{
super();
}


    public static  void WriteClient(String Filt) throws IOException, ServerNotActiveException
    {
      File myLog = new File("LOG.txt");
      LocalDateTime myDateObj = LocalDateTime.now();
      DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
      String formattedDate = myDateObj.format(myFormatObj);
      if (!myLog.exists()) {
          myLog.createNewFile();
          FileWriter myWriter = new FileWriter("LOG.txt",true);
          BufferedWriter bw = new BufferedWriter(myWriter);
          bw.write("Client-RMI1:"+RemoteServer.getClientHost()+" "+Filt+"  le:"+formattedDate+"\n");
          bw.close();
          myWriter.close();
      } else {
          FileWriter myWriter = new FileWriter("LOG.txt",true);
          BufferedWriter bw = new BufferedWriter(myWriter);
          bw.write("Client-RMI1:"+RemoteServer.getClientHost()+" "+Filt+"  le:"+formattedDate+"\n");
          bw.close();
          myWriter.close();
      }
    }
    //Detection Contours
    public byte[] Detection(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("Detection");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.DetectionF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }


    //Gris Filter
    public byte[] Gris(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("Gris");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.GrisF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }
    //Inversion Couleurs
    public byte[] InvCol(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("InvCol");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.InvColF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }
    //Sepia Filter
    public byte[] Sepia(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("Sepia");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.SepiaF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }
    //Filtre Guassian
    public byte[] Gauss(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("Gauss");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.GaussF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }
    //Sharpen Filtre
    public byte[] Sharpen(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("Sharpen");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.SharpenF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }
    //Ajouter Bruit
    public byte[] Blur(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("Bruit");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.BlurF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }
    //Flou Filter
    public byte[] Flou(byte[] i) throws IOException{
      System.out.println("---Recevoir l'Image---");
      try {
        ApplyFilter.WriteClient("Flou");
      } catch (ServerNotActiveException e) {
        e.printStackTrace();
      }
        //Get Image
        ByteArrayInputStream bais = new ByteArrayInputStream(i);
        BufferedImage img = ImageIO.read(bais);
         //Aplly FIlter
        BufferedImage resultat = F.FlouF(img);
        //Sending Image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resultat, "PNG", baos);
        byte[] imageData = baos.toByteArray();
        System.out.println("---Envoyer l'Image---");
        return imageData;
    }

}
