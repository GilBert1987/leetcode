package com.gilbert.io.network.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String [] argv) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8367));

        // 发送请求
        System.out.println("发送数据...");
        ByteBuffer buffer = ByteBuffer.wrap("1234567890".getBytes());
        socketChannel.write(buffer);


        // 读取响应
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();
            byte[] re = new byte[num];
            readBuffer.get(re);
            String result = new String(re, "UTF-8");
            System.out.println("服务器返回值: " + result);
        }


        Thread.sleep(1000);
        socketChannel.close();
    }
}
