import java.awt.image.BufferedImage;
import java.awt.image.*;
import java.awt.color.ColorSpace;
import java.awt.image.ColorConvertOp;
import java.awt.Color;

public class FiltersList {

    public BufferedImage DetectionF(BufferedImage I)
    {
        Kernel kernel1 = new Kernel(3, 3, new float[]{1f, 0f, -1f, 2f, 0f, -2f, 1f, 0f, -1f});
        ConvolveOp convolution1 = new ConvolveOp(kernel1);
        BufferedImage resultatIntermediaire = convolution1.filter(I, null);   
        Kernel kernel2 = new Kernel(3, 3, new float[]{1f, 2f, 1f, 0f, 0f, 0f, -1f, -2f, -1f});
        ConvolveOp convolution2 = new ConvolveOp(kernel2);
        BufferedImage resultat = convolution2.filter(resultatIntermediaire, null);
        return resultat;
    }
    public BufferedImage GrisF(BufferedImage I)
    {
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        BufferedImage resultat = op.filter(I, null);
        return resultat;
    }
    public BufferedImage InvColF(BufferedImage I)
    {
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);
        BufferedImage resultat = op.filter(I, null);
        return resultat;
    }
    public BufferedImage SepiaF(BufferedImage I)
    {
        int w = I.getWidth();
        int h = I.getHeight();
        for(int i=0; i<w; i++){
        for(int j=0; j<h; j++){
            Color c = new Color(I.getRGB(i, j));
            int outputRed = (int) Math.min(255, ((c.getRed() * 0.393f) + (c.getGreen() *0.769f) + (c.getBlue() * 0.189f)));
            int outputGreen = (int) Math.min(255, ((c.getRed() * 0.349f) + (c.getGreen() *0.686f) + (c.getBlue() * 0.168f)));
            int outputBlue = (int) Math.min(255, ((c.getRed() * 0.272f) + (c.getGreen() * 0.534f) + (c.getBlue() *  0.131f)));
            I.setRGB(i,j,new Color(outputRed, outputGreen, outputBlue).getRGB());
        }
        }
        return I;
    }
    public BufferedImage BlurF(BufferedImage I)
    {
        float[] matrix = new float[400];
	        for (int i = 0; i < 400; i++)
		        matrix[i] = 1.0f/400.0f;
            Kernel kernel = new Kernel(20, 20, matrix);
            ConvolveOp convolution1 = new ConvolveOp(kernel);
            BufferedImage Res = convolution1.filter(I, null);  
        return Res;
    }
    public BufferedImage GaussF(BufferedImage I)
    {
        final float[] Gauss3x3 = {
            1.f/16.f*1.f,1.f/16.f*2.f,1.f/16.f*1.f,
            1.f/16.f*2.f,1.f/16.f*4.f,1.f/16.f*2.f,
            1.f/16.f*1.f,1.f/16.f*2.f,1.f/16.f*1.f
            };
            Kernel kernel = new Kernel(3, 3, Gauss3x3);
            ConvolveOp convolution1 = new ConvolveOp(kernel);
            BufferedImage Res = convolution1.filter(I, null);  
        return Res;
    }
    public BufferedImage SharpenF(BufferedImage I)
    {
        float[] Filtre3x3 = {
            0.f,-1.f,0.f,
            -1.f,5.f,-1.f,
            0.f,-1.f,0.f
            };
        Kernel kernel = new Kernel(3, 3, Filtre3x3);
        ConvolveOp convolution1 = new ConvolveOp(kernel);
        BufferedImage Res = convolution1.filter(I, null);  
        return Res;
    }
    public BufferedImage FlouF(BufferedImage I)
    {
        final float[] Flou5x5 = {
            -1.f/256.f, -1.f/256.f*4.f,-1.f/256.f*6.f,-1.f/256.f*4.f,-1.f/256.f*-1.f,
            -1.f/256.f*4.f, -1.f/256.f*-16.f,-1.f/256.f*24.f,-1.f/256.f*-16.f,-1.f/256.f*4.f,
            -1.f/256.f*6.f, -1.f/256.f*24.f,1.f/256.f*476.f,-1.f/256.f*24.f,-1.f/256.f*6.f,
            -1.f/256.f*4.f, -1.f/256.f*-16.f,-1.f/256.f*24.f,-1.f/256.f*-16.f,-1.f/256.f*4.f,
            -1.f/256.f, -1.f/256.f*4.f,-1.f/256.f*6.f,-1.f/256.f*4.f,-1.f/256.f
            };
            Kernel kernel = new Kernel(5, 5, Flou5x5);
            ConvolveOp convolution1 = new ConvolveOp(kernel);
            BufferedImage Res = convolution1.filter(I, null); 
            return Res;
    }
}
