package ru.letnes.Networking.demo5;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    static final int PORT = 8080;
    private static int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        SocketChannel socketChannel = null;
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        try {
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server on port: " + PORT);
            while (true) {
                int count = selector.select();
                if (count == 0) {
                    continue;
                }
                Iterator it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey skey = (SelectionKey) it.next();
                    it.remove();
                    if (skey.isAcceptable()) {
                        socketChannel = serverSocketChannel.accept();
                        System.out.println("Accepted connection from:"
                                + socketChannel.socket());
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    if (skey.isReadable()) {
                        socketChannel = (SocketChannel) skey.channel();
                        socketChannel.read(buffer);
                        buffer.rewind();
                        socketChannel.write(buffer);
                        if (new String(buffer.array()).contains("END")) {
                            socketChannel.close();
                        }
                        buffer.clear();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("IO Exception");
        } finally {
            if (socketChannel != null)
                socketChannel.close();
            serverSocketChannel.close();
            selector.close();
        }
    }
}


