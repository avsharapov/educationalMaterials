package ru.letnes.Networking.demo6;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

public class Recipient {

    public static void main(String[] args) {
        File file = new File("sound2.mp3");
        System.out.println("Прием данных…");
        try {
            acceptFile(file, 8033, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptFile(File file, int port, int pacSize) throws IOException {
        byte[] data = new byte[pacSize];
        DatagramPacket pac = new DatagramPacket(data, data.length);
        try (DatagramSocket s = new DatagramSocket(port);
             BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file))) {
            s.setSoTimeout(50000);
            while (true) {
                s.receive(pac);
                os.write(data);
                os.flush();
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Истекло время ожидания, прием данных закончен");
        }
    }
}

