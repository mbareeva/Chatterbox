package ThreadedChat;


import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
		    final Socket socket; 
		    final BufferedReader in; 
		    final PrintWriter out;
			
public ClientHandler(Socket socket, BufferedReader reader, PrintWriter writer){
			this.socket = socket;
			in = reader;
			out = writer;
			//start();
			}

			@Override
			public void run()
		{
		 try {
			while(true) {
				try {	
				//offer client to start conversation
				out.println("Type in your message here...");
				//get answer from client
				in.readLine();
				}finally
				{
					in.close();
					out.close();}
			}
		 
				
			}catch(Exception e) {
				System.out.println("Error!");
			}
		}

	}


