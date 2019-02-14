package ru.letnes.Networking.demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Demo1 {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("// address of the local host");
        InetAddress localHost = InetAddress.getLocalHost();
/*        System.out.println(localHost);
        System.out.println("...additional parameters...");
        System.out.println(Arrays.toString(localHost.getAddress()));*/
        System.out.println(localHost.getHostAddress());
/*        System.out.println(localHost.getHostName());
        System.out.println("// address of the my host");
        System.out.println(InetAddress.getByName("SAV"));*/

        System.out.println("// loopback address");
        System.out.println(InetAddress.getLoopbackAddress());
        System.out.println(InetAddress.getByName(null));
        System.out.println(InetAddress.getByName("localhost"));
        System.out.println(InetAddress.getByName("127.0.0.1"));
    }
}
