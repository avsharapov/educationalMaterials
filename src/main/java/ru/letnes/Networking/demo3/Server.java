package ru.letnes.Networking.demo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket sSocket = new ServerSocket(PORT)) {
            System.out.println(sSocket);
            try (Socket socket = sSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true)) {
                System.out.println(socket);
                while (true) {
                    String str = in.readLine();
                    if (str.equals("END"))
                        break;
                    System.out.println("Client say: " + str);
                    out.println(str);
                }
            }
        }
    }

}
