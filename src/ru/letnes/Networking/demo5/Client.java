package ru.letnes.Networking.demo5;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final int MAX_THREADS = 5;

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress addr = InetAddress.getByName(null);
        while (ClientThread.counter < 10) {
            if (ClientThread.threadCount() < MAX_THREADS) {
                new ClientThread(addr);
            }
            Thread.sleep(100);
        }
    }

    static class ClientThread extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private static int counter = 0;
        private int id = counter++;
        private static int threadcount = 0;

        public static int threadCount() {
            return threadcount;
        }

        public ClientThread(InetAddress addr) {
            System.out.println("Making client " + id);
            threadcount++;
            try {
                socket = new Socket(addr, Server.PORT);
            } catch (IOException e) {
                System.err.println("Socket " + id + " failed");
                return;
            }
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                start();
            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException e2) {
                    System.err.println("Socket not closed");
                }
            }
        }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    out.println("[ " + id + " ] message " + i);
                    String str = in.readLine();
                    System.out.println(str);
                    Thread.sleep(1000);
                }
                out.println("END");
            } catch (IOException | InterruptedException e) {
                System.err.println("IO Exception");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Socket not closed");
                }
                threadcount--;
            }
        }
    }
}
