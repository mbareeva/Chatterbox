import java.io.*;
import java.net.*;

public class Server {
	private static ServerSocket ss;
	private static Socket client;
	private static BufferedReader reader;
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args){ 
		
		try {
			try{
			
			ss = new ServerSocket(6665);
			System.out.println("Server is waiting...");
			client = ss.accept();//accept connection from a client
			//get msg
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//send msg
			out = new PrintWriter(client.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			String receiveMsg, sendMsg;
				while(true) {
					if((receiveMsg = in.readLine()) != null){
					System.out.println(receiveMsg);
					}
					//answer to client
					sendMsg = reader.readLine();
					out.println(sendMsg); 
					out.flush();
				}	
				
			}finally {
				in.close();
				out.close();
				ss.close();
				client.close();}
		}catch(Exception e){System.out.println(e);}
	}
}

		  


