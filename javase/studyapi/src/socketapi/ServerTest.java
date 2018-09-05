package socketapi;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws Exception {
        // 服务端在20006端口监听客户端请求的TCP连接
        ServerSocket server = new ServerSocket(20006);
        System.out.println("服务端已经开始监听----");
        Socket client = null;
        boolean f = true;
        while (f) {//循环监听
            // 等待客户端的连接
            client = server.accept();
            System.out.println("与客户端连接成功！");
            // 为每个客户端连接开启一个线程
            new Thread(new ServerThread(client)).start();
        }
        server.close();
    }
}
