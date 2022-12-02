package Network;

import java.util.ArrayList;

public class GetAllIpAddress {
    public static void main(String[] args) throws InvalidIPAddressException {
        String ipAddress = "java2s.com";
        int cidr = 2;
        System.out.println(getListOfIPAddress(ipAddress,cidr));
    }/*from  www .j  ava2  s . c  o  m*/
    public static ArrayList<String> getListOfIPAddress(String ipAddress,
                                                       int cidr) throws InvalidIPAddressException {

        return getListOfIPAddress(ipToNumber(ipAddress), cidr);
    }
    public static ArrayList<String> getListOfIPAddress(long ipAddress,
                                                       int cidr) throws InvalidIPAddressException {

        if (!isValidCidrblock(ipAddress, cidr)) {
            throw new InvalidIPAddressException(
                    "Invalid base IP Address for provided CIDR");
        }

        ArrayList<String> ips = new ArrayList<String>();
        long blockSize = (long) Math.pow(2, (32 - cidr));
        for (long i = 0; i < blockSize; i++) {
            ips.add(numberToIP(ipAddress + i));
        }
        return ips;
    }
    public static long ipToNumber(String ipAddr)
            throws InvalidIPAddressException {
        if (ipAddr == null) {
            throw new InvalidIPAddressException("NULL IP Address");
        }

        String[] addrArray = ipAddr.split("\\.");

        if (addrArray.length != 4) {
            throw new InvalidIPAddressException("Invalid IP Address length");
        }

        long num = 0;
        for (int i = 0; i < addrArray.length; i++) {
            int power = 3 - i;

            int octet = Integer.parseInt(addrArray[i]);

            if (octet < 0 || octet > 255) {
                throw new InvalidIPAddressException(
                        "Invalid octet, it must be between 0-255");
            }

            num += ((octet % 256) * Math.pow(256, power));
        }
        return num;
    }
    public static Boolean isValidCidrblock(final long ipAddress,
                                           final int cidr) throws InvalidIPAddressException {

        if (ipAddress == getCiderBaseIP(ipAddress, cidr)) {
            return true;
        }

        return false;
    }
    public static Boolean isValidCidrblock(final String ipAddress,
                                           final int cidr) throws InvalidIPAddressException {

        long address = GetAllIpAddress.ipToNumber(ipAddress);
        return isValidCidrblock(address, cidr);
    }
    public static String numberToIP(long addr)
            throws InvalidIPAddressException {

        if (addr < 0L || addr > 4294967295L) {
            throw new InvalidIPAddressException("Invalid IP");
        }

        StringBuilder ip = new StringBuilder();

        ip.append((addr >> 24) & 0xFF).append(".");
        ip.append((addr >> 16) & 0xFF).append(".");
        ip.append((addr >> 8) & 0xFF).append(".");
        ip.append((addr) & 0xFF);

        return ip.toString();
    }
    public static long getCiderBaseIP(final long ip, final int cidr)
            throws InvalidIPAddressException {

        long netmask = getSubnetMaskNumeric(cidr);

        // get base network ip for this ip/netmask combo
        long baseIP = ip & netmask;
        return baseIP;
    }
    public static long getSubnetMaskNumeric(final int cidr)
            throws InvalidIPAddressException {

        if (cidr > 32 || cidr < 0)
            throw new InvalidIPAddressException(
                    "CIDR can not be greater than 32");

        // starting /24 netmask, in decimal (255.255.255.0)
        long netmask = 4294967040L;

        // calculating and correcting netmask
        if (cidr > 24) {
            for (long i = cidr; i > 24; i--) {
                netmask += (long) (java.lang.Math.pow(2, (32 - i)));
            }
        } else if (cidr < 24) {
            for (long i = cidr; i < 24; i++) {
                netmask -= (long) (java.lang.Math.pow(2, (32 - (i + 1))));
            }
        }

        return netmask;
    }
}
