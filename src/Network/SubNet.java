package Network;

public class SubNet {
    public static void main(String[] args) throws InvalidIPAddressException {
        int cidr = 2;
        System.out.println(getSubnetMask(cidr));
    }/*  w w w  .  j  a  v a  2  s.c om*/
    public static String getSubnetMask(final int cidr)
            throws InvalidIPAddressException {
        return numberToIP(getSubnetMaskNumeric(cidr));
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

    private static class InvalidIPAddressException extends Exception {
        /**
         * Constructs a new exception with {@code null} as its detail message.
         * The cause is not initialized, and may subsequently be initialized by a
         * call to {@link #initCause}.
         */
        public InvalidIPAddressException() {
            super();
        }

        /**
         * Constructs a new exception with the specified detail message.  The
         * cause is not initialized, and may subsequently be initialized by
         * a call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        public InvalidIPAddressException(String message) {
            super(message);
        }

        /**
         * Constructs a new exception with the specified detail message and
         * cause.  <p>Note that the detail message associated with
         * {@code cause} is <i>not</i> automatically incorporated in
         * this exception's detail message.
         *
         * @param message the detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method).
         * @param cause   the cause (which is saved for later retrieval by the
         *                {@link #getCause()} method).  (A {@code null} value is
         *                permitted, and indicates that the cause is nonexistent or
         *                unknown.)
         * @since 1.4
         */
        public InvalidIPAddressException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
