package practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 这个算是服务器端
 * */
public class Server {

	public static void main(String[] args) throws Exception {
		// 创建TCPServer对象并调用listen()方法
		System.out.println("数据交互开始");
		new TCPServer().listen();
		System.out.println("数据交互结束");
	}
}

/*
 * TCP服务端
 */
class TCPServer {
	private static final int PORT = 7788;
	private ServerSocket serverSocket;

	public void listen() throws Exception {
		serverSocket = new ServerSocket(PORT);
		Socket client = serverSocket.accept();
		
		InputStream is = client.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		System.out.println(new String(buf, 1, len));
	
		OutputStream os = client.getOutputStream();
		os.write(("五邑大学欢迎你!!!").getBytes());
		os.close();
		is.close();
		client.close();
	}
}
