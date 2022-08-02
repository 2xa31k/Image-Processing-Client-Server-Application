import java.io.IOException;
import java.io.*;

public class Client{
    public static void clrscr(){
        System.out.println("Bonjour :");
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String Choix;
        Image i=new Image();
        Thread T;
        System.out.println("Bonjour :");
        System.out.println("Choisir une photo:");
        i.ChooseImage();
        if(i.getImg()==null){
            System.exit(0);}
        else{

            do{
                clrscr();
            System.out.println("Menu:");
            System.out.println("1 pour Detecter Les contours");
            System.out.println("2 pour Niveaux de gris");
            System.out.println("3 Inversion des couleurs");
            System.out.println("4 pour Filtre Sepia");
            System.out.println("5 Ajouter Bruit");
            System.out.println("6 Flou de Gauss 3x3");
            System.out.println("7 Amélioration de la nettete");
            System.out.println("8 Masque flou 5x5");
            System.out.println("9 pour choisir une autre Image");
            System.out.println("10 pour quitter");
            System.out.print("Entrer votre choix:");
            Choix= br.readLine();

            switch(Choix){

            case "1":      
                            T=new Thread(new OpenConnexion("Detection", i));
                            T.run();
                            break;
            case "2":   
                            T=new Thread(new OpenConnexion("Gris", i));
                            T.run();
                            break;
            case "3":   
                            T=new Thread(new OpenConnexion("Sepia", i));
                            T.run();
                            break;
            case "4":   
                            T=new Thread(new OpenConnexion("InvCol", i));
                            T.run();
                            break;
            case "5":      
                            T=new Thread(new OpenConnexion("Blur", i));
                            T.run();
                            break;
            case "6":   
                            T=new Thread(new OpenConnexion("Gauss", i));
                            T.run();
                            break;
            case "7":   
                            T=new Thread(new OpenConnexion("Sharpen", i));
                            T.run();
                            break;
            case "8":   
                            T=new Thread(new OpenConnexion("Flou", i));
                            T.run();
                            break;
            case "9":
                            i.ChooseImage();
                            break;
            case "10":    System.out.println("Thanks");
                            break;
            default:   System.out.println("Choix incorrect");

                }
            }while(! Choix.equals("10"));
        }
    }
}
