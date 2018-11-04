package ThreadedChat;


import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
		    final Socket socket; 
		    final BufferedReader in; 
		    final PrintWriter out;
			
public ClientHandler(Socket socket, BufferedReader reader, PrintWriter writer) throws IOException {
			this.socket = socket;
			this.in = reader;
			this.out = writer;
			//start();
			}
			@Override
			public void run() {
				
			while(true) {
				try {
				
					//offer client to start conversation
				out.println("Type in your message here...");
				//get answer from client
				in.readLine();
				}
			catch(Exception e){
				System.out.print("Error!");
			}
			}
		}

	}


