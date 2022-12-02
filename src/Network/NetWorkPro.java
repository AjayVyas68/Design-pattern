package Network;

import java.net.*;

public class NetWorkPro {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException, SocketException {
        String s = "https://www.google.com/";
        InetAddress address=Inet6Address.getByName(new URL(s).getHost());
        InetAddress localAddress=Inet4Address.getLocalHost();
        NetworkInterface n=NetworkInterface.getByInetAddress(address);

        n.getInterfaceAddresses().get(1).getNetworkPrefixLength();
        for (InterfaceAddress address1: n.getInterfaceAddresses())
        {
            System.out.println(address1.getNetworkPrefixLength());
        }
        System.out.println(address);
        System.out.println("local Address ->"+localAddress);
    }
}
