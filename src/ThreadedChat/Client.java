package ThreadedChat;
import java.net.Socket;
import java.io.*;

public class Client {
	
	private static Socket clientSocket;
	private static BufferedReader reader;
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args){ 
	
	try {
		try{  
			
			//set the connection with server on port 6665
		clientSocket = new Socket("127.0.0.1", 6665);
		//hostname - ip of PC to connect to
		
		//read from keyboard, read from and write to server
		reader = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new PrintWriter(clientSocket.getOutputStream());
		
		System.out.println("Insert you message here: ");
		
		String sendMsg;
			while(true) {
				System.out.println(in.readLine());
				sendMsg = reader.readLine();
				out.println(sendMsg);//send to server
				out.flush();
				}	
		}finally {
			//closing streams
		in.close();
		out.close();
		clientSocket.close();}
	}catch(Exception e)
		{System.out.println(e);
		}  
	}
}
