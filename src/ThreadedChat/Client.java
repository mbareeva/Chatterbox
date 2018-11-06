package ThreadedChat;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

public class Client {
	
	private static Socket socket;
	private static BufferedReader in;
	private static PrintWriter out;
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
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException{ 
		Client client = new Client(6666, "client1");
		client.startConnection();
	}
	
	public void startConnection() {
			try {
				System.out.println("Insert you message here: ");
				
				//exchange the information
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream());
				//how does it understands that I need the name of a client?, 
				//just through socket.getOutputStream??
				out.println(name + "\n");
				out.flush();
				
				//receive the name 
				//same: how does it filters and give us exactly the name of server?
				serverName = in.readLine();
				
				//instantiating threads - reading and writing to streams
					new ReadMsg(socket, serverName).start();
					new WriteMsg(socket).start();
				}catch(Exception e)
					{
					System.out.println(e);
					} 
	}
}
			
		
