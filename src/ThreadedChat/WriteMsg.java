package ThreadedChat;

import java.io.*;
import java.net.*;

public class WriteMsg extends Thread{
	Socket socket;
	BufferedReader reader;
	PrintWriter out;
	String sender;
	
	public WriteMsg(Socket socket) {
			this.socket = socket;
	}
	@Override
	public void run() {
			String output;
			try {
				while(true) {
				reader = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(socket.getOutputStream());
				if((output = reader.readLine()) != null) {
					out.println(output + "\n");
					out.flush();
					}
				}
				
			}catch(Exception e) {
				System.out.println("Error!");
				}
		}
	}
