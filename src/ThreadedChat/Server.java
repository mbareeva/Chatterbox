package ThreadedChat;

import java.io.*;
import java.net.*;

public class Server {
	private static ServerSocket serverSocket;
	private static Socket clientSocket;
//	private static BufferedReader in;
	//private static PrintWriter out;
	private  String serverName;
	private  String clientName;
	
	public Server(int port, String serverName) throws IOException {
		serverSocket = new ServerSocket(port);
		this.serverName = serverName;
	}
	
	public static void main(String[] args) throws IOException{
		Server server = new Server(6666, "Server");
		server.startConnection();
	}
	
	public void startConnection() {
		
		System.out.println("Server is waiting for the connection...");
		while(true) {
				//wait connection from a client
			try {
				clientSocket = serverSocket.accept();
				System.out.println("The connection was successfully established.");
			
			//instantiating threads - reading and writing to streams
				new ReadMsg(clientSocket, clientName).start();
				new WriteMsg(clientSocket).start();
			
		}catch(Exception e) {
			System.out.println(e);
			}
		}
	}
}

		  


