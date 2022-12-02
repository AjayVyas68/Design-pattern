package Network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class SubnetAddresses {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        // get all possible IP addresses of all LANs
        for (Enumeration<NetworkInterface> ifaces =
             NetworkInterface.getNetworkInterfaces();
             ifaces.hasMoreElements(); ) {
            NetworkInterface iface = ifaces.nextElement();
            System.out.println(iface.getName() + ":");
            for (Enumeration<InetAddress> addresses =
                 iface.getInetAddresses();
                 addresses.hasMoreElements(); ) {
                InetAddress address = addresses.nextElement();
                System.out.println(" add " + address);
                System.out.println("upload in github");
            }
        }


    }
}
