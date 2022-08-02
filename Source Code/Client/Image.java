import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import java.io.*;
public class Image implements Serializable{
    private int width = 800;
    private int height = 800;
    private BufferedImage image = new BufferedImage(
        width, height, BufferedImage.TYPE_INT_RGB);

    //Constructeur 
    public Image(){}
    public Image(BufferedImage ImgIns) throws IOException
    {
        this.image = ImgIns;
    }
    public void ChooseImage() throws IOException
    {

        JFileChooser jfc=new JFileChooser();
        jfc.showDialog(null, "Select Image");
        jfc.setVisible(true);
        File ImgPath=jfc.getSelectedFile();
        if(ImgPath!=null)
        this.image = ImageIO.read(ImgPath);
        else {this.image=null;
                System.out.println("vous n'avez pas choisir une image");
                System.exit(0);}

    }
    //Save Image to folder
    public void SaveImg() throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entrer le nom d'image pour la sauvgarder:");
        String s= br.readLine();
        File output_file = new File(
            s+".png");

        // Writing to file taking type and path as
        ImageIO.write(this.image, "png", output_file);

        System.out.println("Image est Sauvgarder .");
    }
    //setter
    public void setImage(BufferedImage Img)
    {
        this.image=Img;
    }

    //getter
    public BufferedImage getImg()
    {
        return this.image;
    }

    public byte[] imgToByteArr() throws IOException
    {
            ByteArrayOutputStream arr = new ByteArrayOutputStream();
            ImageIO.write(this.image, "png", arr);
            return  arr.toByteArray();

    }
    public void imgFromByteArr(byte[] arr) throws IOException
    {
            ByteArrayInputStream img = new ByteArrayInputStream(arr);
            this.setImage(ImageIO.read(img));
    }

}
