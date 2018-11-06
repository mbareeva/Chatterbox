package ThreadedChat;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

public class Client {
	
	private static Socket socket;
	//private static BufferedReader reader;
	//private static BufferedReader in;
//	private static PrintWriter out;
	private int port;
	private String name;
	private String serverName;
	
	/*
	 * Create a client with its name and port
	 * @param port The port that the client connects to.
	 * @param name The name of connected client.
	 */
	public Client(int port, String name) throws UnknownHostException, IOException {
		this.name = name;
		socket = new Socket("localhost", port);
		//reader = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		//out = new PrintWriter(clientSocket.getOutputStream());
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException{ 
		Client client = new Client(6666, "client1");
		client.startConnection();
	}
	
	public void startConnection() {
			try {
				System.out.println("Insert you message here: ");
				//instantiating threads - reading and writing to streams
					new ReadMsg(socket, serverName).start();
					new WriteMsg(socket).start();
				}catch(Exception e)
					{
					System.out.println(e);
					} 
	}
}
			
		
