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
		ServerSocket server = null;
		Socket client = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			server = new ServerSocket(PORT);
			System.out.println("Listening for a client...");
			client = server.accept();
			System.out.println("Client connected");
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			File file = new File(reader.readLine());
			
			//Tests whether the file denoted by this abstract pathname is a normal file. A file is normal if it is not a directory.
			if (file.isFile() && file.exists()) {
				writer.write("1");
				
			} else {
				writer.write("0");
				writer.newLine();
				writer.flush();
			}
			writer.close();
			reader.close();
			client.close();
			server.close();
		} catch (IOException e) {
			System.out.println("Failed or interrupted I/O operations");
			if(!writer.equals(null) || !client.equals(null) || !reader.equals(null)){
				try {
					writer.close();
					client.close();
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
