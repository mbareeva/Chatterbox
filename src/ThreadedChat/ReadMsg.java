package ThreadedChat;

import java.io.*;
import java.net.*;

public class ReadMsg extends Thread{
	Socket socket;
	String recipient;
	BufferedReader in;

		public ReadMsg(Socket socket, String recipient) {
			//why dont we have to create new Socket()?
				this.socket = socket;
				this.recipient = recipient;
		}		
	/*
	 *  Print out messages from the input.		
	 */
	@Override
	public void run() {
		String input;
		try {
			while(true) {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				input = in.readLine();
				System.out.println(recipient + ": " + input + "\n");
			}
		}catch(Exception e) {
			System.out.println(e);}
	}
}
