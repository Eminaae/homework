package ba.bitcamp.homework11.task01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;


/**
 * Class Client represents client who is connecting to the localhost server.
 * Client sends two Strings link and name. Scanner is used for data input.
 * 
 * @author emina.a
 *
 */
public class Client {

	public static final String HOST = "localhost";
	public static final int PORT = 7777;

	public static void main(String[] args) {

		try {
			Socket client = new Socket(HOST, PORT);
			// writer sends user entered message to the server
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			Scanner in = new Scanner(System.in);

			while (true) {
				try {

					// Ask user to insert web site
					System.out.println("Type the link address (eg. http://google.ba or www.google.ba):");
					URL url = checkURL(in.nextLine());
					writer.write(url + " "); // this is where we save only urlLink
												
					// Ask user to insert web site name eg. Google
					System.out.println("Type the name of the web site (eg. Google): ");
					writer.write(in.nextLine());
					break;
					// writer.flush();

				} catch (MalformedURLException e) {
					System.out.println("Wrong link format");
				}
			}
			writer.newLine();
			writer.flush();
			writer.close();
			client.close();
			in.close();

		} catch (IOException e) {
			System.out.println("Client disconnected");
			e.printStackTrace();
		}
	}

	/**
	 * Method checkURL checks whether a given http url is available.
	 * @param urlLink- web site link that user insert
	 * @return - returns link after checking user input type
	 * @throws MalformedURLException if there is no legal protocol in typed urlLink
	 */
	public static URL checkURL(String urlLink) throws MalformedURLException {
		URL url;
		if (urlLink.contains("http") || urlLink.contains("https")) {
			url = new URL(urlLink);
		} else if (urlLink.contains("www")) {
			url = new URL("http://" + urlLink);
		} else {
			url = new URL(urlLink);
		}
		return url;
	}
}
