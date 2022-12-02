package Network;

import java.net.*;
import java.util.*;

public class SubnetAddresses {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        // get all possible IP addresses of all LANs
        for (Enumeration<NetworkInterface> ifaces =
                NetworkInterface.getNetworkInterfaces();
        ifaces.hasMoreElements(); )
        {
            NetworkInterface iface = ifaces.nextElement();
            System.out.println(iface.getName() + ":");
            for (Enumeration<InetAddress> addresses =
                 iface.getInetAddresses();
                 addresses.hasMoreElements(); )
            {
                InetAddress address = addresses.nextElement();
                System.out.println(" add " + address);
            }
        }


    }
}
