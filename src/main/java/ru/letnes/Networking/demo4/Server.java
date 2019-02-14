package ru.letnes.Networking.demo4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket sSocket = new ServerSocket(PORT, 3)) {
            System.out.println(sSocket);
            while (true) {
                Socket socket = sSocket.accept();
                try {
                    new ServeOneClient(socket);
                    //Thread.sleep(10000);
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }

    static class ServeOneClient extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ServeOneClient(Socket s) throws IOException {
            socket = s;
            System.out.println(socket);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            start();
        }

        public void run() {
            try {
                while (true) {
                    String str = in.readLine();
                    if (str.contains("END")) {
                        System.out.println(str.split("/")[1] + " closing...");
                        break;
                    }
                    System.out.println("Client say: " + str);
                    out.println(str);
                }
            } catch (IOException e) {
                System.err.println("IO Exception");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Socket not closed");
                }
            }
        }
    }
}


