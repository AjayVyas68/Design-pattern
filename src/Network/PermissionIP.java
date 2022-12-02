package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PermissionIP {

    public PermissionIP() throws IOException {
        URL url=new URL("http://checkip.amazonaws.com");

        BufferedReader bf=null;
        try {
            bf=new BufferedReader(new InputStreamReader(url.openStream()));
            String ipWrite=bf.readLine();

            System.out.println("port Number ->"+url.getPort());
            System.out.println("hosted url ->"+url.getHost());
            System.out.println("path in wifi ->"+url.getPath());
            System.out.println("user info"+url.getUserInfo());
            URLConnection v= url.openConnection();
            System.out.println("update permission"+v.getPermission());
            System.out.println("uri=l connection time out->"+v.getConnectTimeout());
            System.out.println("update permission->"+v.getURL());
            System.out.println(ipWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            bf.close();
        }
    }


    public static void main(String[] args) throws IOException {
       // new PermissionIP();
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        URLConnection connection = whatismyip.openConnection();
        connection.addRequestProperty("Protocol", "Http/1.1");
        connection.addRequestProperty("Connection", "keep-alive");
        connection.addRequestProperty("Keep-Alive", "1000");
        connection.addRequestProperty("User-Agent", "Web-Agent");

        BufferedReader in =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String ip = in.readLine(); //you get the IP as a String
        System.out.println(ip);
    }
}
