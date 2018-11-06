package ThreadedChat;

import java.io.*;
import java.net.*;

public class Server {
	private  ServerSocket serverSocket;
	private  Socket clientSocket;
	private  BufferedReader in;
	private  PrintWriter out;
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
			//exchange information about server and client
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintWriter(clientSocket.getOutputStream());
				//get the name of a client.
				clientName = in.readLine();
				//share server's name with a client.
				out.println(serverName + "\n");
				out.flush();
			//instantiating threads - reading and writing to streams
				new ReadMsg(clientSocket, clientName).start();
				new WriteMsg(clientSocket).start();
			
		}catch(Exception e) {
			System.out.println(e);
			}
		}
	}
}

		  


