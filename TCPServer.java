package com.learn.demo02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通信的服务器端
 * 作用：接收客户端的请求，读取客户端发送的数据，给客户端回写数据
 *
 * 表示服务器的类：java.net.ServerSocket 此类实现服务器套接字
 *
 * 构造方法：
 * public ServerSocket(int port) 创建绑定到特定端口的服务器套接字
 *
 * 服务器端必须明确是哪个客户端请求的服务器
 * 所以可以使用 accept 方法获取到请求的客户端对象 Socket
 * 成员方法：
 *  Socket accept() 侦听并接受到此套接字的连接
 *
 *
 * 实现步骤：
 *  1. 创建服务器 ServerSocket 对象和系统要指定的端口号
 *  2. 使用 ServerSocket 对象中的方法 accept ，获取到请求的客户端对象 Socket
 *  3. 使用客户端 Socket 对象中的方法 getInputStream() 获取网络字节流输入对象 InputStream
 *  4. 使用 InputStream 对象中的方法 read ，读取客户端发送的数据
 *  5. 使用客户端 Socket 对象中的方法 getOutputStream() 获取网络字节流输出对象 OutputStream
 *  6. 使用 OutputStream 对象中的方法 write ，给客户端回送数据
 *  7. 释放资源
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1. 创建服务器 ServerSocket 对象和系统要指定的端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        //2. 使用 ServerSocket 对象中的方法 accept ，获取到请求的客户端对象 Socket
        Socket socket = serverSocket.accept();
        //3. 使用客户端 Socket 对象中的方法 getInputStream() 获取网络字节流输入对象 InputStream
        InputStream inputStream = socket.getInputStream();
        //4. 使用 InputStream 对象中的方法 read ，读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //5. 使用客户端 Socket 对象中的方法 getOutputStream() 获取网络字节流输出对象 OutputStream
        OutputStream outputStream = socket.getOutputStream();
        //6. 使用 OutputStream 对象中的方法 write ，给客户端回送数据
        outputStream.write("收到谢谢".getBytes());
        //7. 释放资源
        socket.close();
        serverSocket.close();
    }
}
