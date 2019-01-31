package ru.letnes.Networking.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Demo2 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket sSocket = new ServerSocket();
        System.out.println(sSocket);
        System.out.println(sSocket.getInetAddress());
        System.out.println(sSocket.getLocalPort());

        sSocket.bind(new InetSocketAddress(PORT));

        System.out.println(sSocket);
        System.out.println(sSocket.getInetAddress());
        System.out.println(sSocket.getLocalPort());
        sSocket.close();
        System.out.println(sSocket.isClosed());
    }
}
