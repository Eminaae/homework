package ba.bitcamp.homework12.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Server represents server on port 8888. Client sends one String (file path) to Server, this server
 * checks whether file exist or does not exist on server. 
 * @author emina.a
 *
 */
public class Server {

	public static final int PORT = 8888;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("Listening for a client...");
			Socket client = server.accept();
			System.out.println("Client connected");
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			String filesOnServer = "";
			while(client.isConnected()){
				filesOnServer = reader.readLine();
				File file = new File(filesOnServer);
				//Tests whether the file denoted by this abstract pathname is a normal file. A file is normal if it is not a directory.
				if(file.isFile() && file.exists()){
					writer.write("1");
				}else{
					writer.write("0");
				}
				writer.newLine();
				writer.flush();
			//	writer.close();
			}
		} catch (IOException e) {
			System.out.println("Failed or interrupted I/O operations");
			e.printStackTrace();
		}
	}
}
