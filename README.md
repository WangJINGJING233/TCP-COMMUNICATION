# TCP-COMMUNICATION
模拟客户端和服务端的tcp通信

/**
 * TCP通信的客户端
 * 作用： 向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据
 *
 * 表示客户端的类：java.net.Socket 此类实现客户端套接字。套接字是两台机器间通信的端点。
 *
 * 构造方法：
 * public Socket(String host, int port)
 *          String host ： 服务器主机的名称
 *          int port : 服务器端口号
 *
 * 成员方法：
 * OutputStream getOutputStream() 返回此套接字的输出流
 * InputStream getInputStream() 返回此套接字的输入流
 * void close() 关闭此套接字
 *
 * 实现步骤：
 *  1. 创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
 *  2. 使用 Socket 对象中的方法 getOutputStream() 获取网络字节流输出对象 OutputStream
 *  3. 使用 OutputStream 对象中的方法 write ，给服务器发送数据
 *  4. 使用 Socket 对象中的方法 getInputStream() 获取网络字节流输入对象 InputStream
 *  5. 使用 InputStream 对象中的方法 read ，读取服务器回送的数据
 *  6. 释放资源
 * 注意：
 *  1. 客户端和服务端进行交互，必须使用 Socket 中提供的网络流，不能使用自己创建的流对象
 *  2. 当创建客户端对象 Socket 的时候，就会去请求服务器和服务器经过三次握手，建立连接通路
 *      这时如果服务器没有启动，那么就会抛出异常 ConnectException
 *      如果服务器已经启动了，那么就可以进行通信
 */
 
 
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
