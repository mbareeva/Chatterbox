package ThreadedChat;

import java.io.*;
import java.net.*;

public class Server {
	private static ServerSocket ss;
	private static Socket client;
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		
		ss = new ServerSocket(6666);
		System.out.println("Server is waiting for the connection...");
		
		while(true) {
			Socket client = null;
		
			try{
				//wait connection from a client
			client = ss.accept();
			System.out.println("The connection was successfully established.");
			
			
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());
			
			System.out.println("Creating new thread for the new client");
			
			//create new thread object 
			Thread thr = new ClientHandler(client, in, out);
			
			thr.start();
			}
			catch (Exception e){
			client.close();
			e.printStackTrace(); }
		}
	}
}

		  


