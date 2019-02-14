package ru.letnes.Networking.demo3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        System.out.println(addr);
        Socket socket = new Socket(addr, Server.PORT);
        System.out.println(socket);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            for (int i = 0; i < 10; i++) {
                out.println("Message " + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        } finally {
            socket.close();
        }
    }

}
