package ba.bitcamp.homework12.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Class Client represents client connected to server port 8888. 
 * When client connects to the server, client sends request to check whether file exist on server, if does returns 1, otherwise 0.
 * @author emina.a
 *
 */
public class Client {

	public static final String HOST = "localhost";
	public static final int PORT = 8888;
	
	public static void main(String[] args) {
		
		try {
			Socket client = new Socket(HOST, PORT);
			System.out.println("Connecting to server...");
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			Scanner in = new Scanner(System.in);
			
				System.out.println("Enter the file path you are looking for...");
				writer.write(in.nextLine());
				writer.newLine();
				writer.flush();
				
				System.out.println("Response from server -> " + reader.readLine());
			
				writer.close();
				in.close();
				client.close();
				reader.close();
			} catch (IOException e) {
			System.out.println("Failed or interrupted I/O operations.");
		
		}
		
	}

}
