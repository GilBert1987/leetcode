package com.gilbert.io.network.nio.bio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

//https://mp.weixin.qq.com/s?__biz=MzUyNzgyNzAwNg==&mid=2247483929&idx=1&sn=ed536aee5ac7f898fc5e640785769fd4&scene=21#wechat_redirect


public class SocketHandler implements Runnable {
    private SocketChannel socketChannel;
    public SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            // 将请求数据读入 Buffer 中
            int num;
            while ((num = socketChannel.read(buffer)) > 0) {
                // 读取 Buffer 内容之前先 flip 一下
                buffer.flip();

                // 提取 Buffer 中的数据
                byte[] bytes = new byte[num];
                buffer.get(bytes);

                String re = new String(bytes, "UTF-8");
                System.out.println("收到请求：" + re);

                // 回应客户端
                ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + re).getBytes());
                socketChannel.write(writeBuffer);

                buffer.clear();
            }
        } catch (IOException e) {
            try {
                socketChannel.close();
            } catch (Exception ex) {

            }
        }
    }
}
