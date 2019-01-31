package ru.letnes.Networking.demo6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

    public static void main(String[] args) {
        byte[] data = new byte[10000];
        try (DatagramSocket s = new DatagramSocket();
             FileInputStream fr = new FileInputStream(new File("sound.mp3"))) {
            InetAddress addr = InetAddress.getLocalHost();
            DatagramPacket pac;
            while (fr.read(data) != -1) {
                pac = new DatagramPacket(data, data.length, addr, 8033);
                s.send(pac);//отправление пакета
            }
            System.out.println("Файл отправлен");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}

