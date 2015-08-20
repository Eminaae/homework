package ba.bitcamp.homework11.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
/**
 * Class Server represents localhost Server opened on port 7777. Server receives two strings from Client, 
 * checks if link is valid and if link exist. The link and the name will be added to the string indexHtmlFile.
 * As soon as client disconnect from server data added to the string will be saved in a httpFile.txt 
 * @author emina.a
 *
 */
public class Server {
	public static final int PORT = 7777;

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("Listening for a client...");
			Socket client = server.accept();
			System.out.println("Client connected.");
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("public/httpFile.txt"), true));
		
			writer.write(reader.readLine());
			writer.newLine();
			writer.close();
			reader.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
