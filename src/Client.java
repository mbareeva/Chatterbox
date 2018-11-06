import java.net.Socket;

import ThreadedChat.ReadMsg;
import ThreadedChat.WriteMsg;

import java.io.*;

public class Client {
	
	private static Socket clientSocket;
	private static BufferedReader reader;
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args){ 
	
	
		try{  
			
			//ask server for access the connection
		clientSocket = new Socket("127.0.0.1", 6665);   //hostname - ip of PC to connect to
		//read from keyboard
		reader = new BufferedReader(new InputStreamReader(System.in));
		//read msg from server
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		///send message to server
		out = new PrintWriter(clientSocket.getOutputStream());
		System.out.println("Insert you message here: ");
		
		try {
			new ReadMsg().start();
			new WriteMsg().start();
		}catch(Exception e)
		{
		System.out.println(e);} 			
		
	}catch(Exception e){
		System.out.println(e);}  
	}
		
}
