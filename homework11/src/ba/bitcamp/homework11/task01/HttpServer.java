package ba.bitcamp.homework11.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	private static final int HTTP_PORT = 8008;

	public static void main(String[] args) throws IOException {

		ServerSocket httpServer; //declaring http server socket
		Socket httpClient; //declaring http client

		try {
			httpServer = new ServerSocket(HTTP_PORT);

			while (true) {
				System.out.println("Waiting for a client...");
				httpClient = httpServer.accept();
				System.out.println("Client " + httpClient.getLocalAddress() + "connected to http server.");
				// Reader reads html file
				BufferedReader reader = new BufferedReader(new FileReader(new File("public/index.html")));
				String indexHtmlFile = ""; // all read data will be put in this
											// string
				// read all data from htmlFile
				while (reader.ready()) {
					indexHtmlFile += reader.readLine();
				}

				// fileReader will read all httpFile.txt index.html")));
				BufferedReader readFile = new BufferedReader(new FileReader("public/httpFile.txt"));

				while (readFile.ready()) {
					String httpFileTxt = readFile.readLine();
					String[] parts = httpFileTxt.split(" ", 2);
					indexHtmlFile += "<h1><a href = " + parts[0] + ">" + parts[1] + "</a></h1>";
				}
				indexHtmlFile += "</body></html>";

				// writer will write string to local web site
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(httpClient.getOutputStream()));
				writer.write(indexHtmlFile);
				writer.newLine();
				writer.close(); //closing writer
				readFile.close(); // closing reader
				httpClient.close(); //closing http client
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
