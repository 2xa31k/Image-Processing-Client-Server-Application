
import java.net.URL;
import java.util.Scanner;

public class ServeurList {
    ConnectionServ[] CS = new ConnectionServ[8];
    public ServeurList() {
        try {
        
			URL url = new URL("https://raw.githubusercontent.com/2xa31k/Image-Processing-Client-Server-Application/main/Servers.txt");//offline Servers
            Scanner s;
            s = new Scanner(url.openStream());
        int pos=0;
        String data;
        while (s.hasNextLine()) {
            data = s.nextLine();
            String[] array = data.split(";"); 
            CS[pos]=new ConnectionServ(array[0],array[1],array[2]);
            pos++;
             }
        }catch(Exception e){}
    }
    public ConnectionServ[] GetServers(){
        return this.CS;
    }
}
