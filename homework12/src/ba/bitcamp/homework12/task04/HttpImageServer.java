package ba.bitcamp.homework12.task04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

public class HttpImageServer {

	private static final int PORT = 8000;
	
	
	public static void main(String[] args) {
		ArrayList<File> files = new ArrayList<File>(); // list of received files
		ServerSocket httpServer;
		try {
			httpServer = new ServerSocket(PORT);
			System.out.println("Waiting for a client...");
			while (true) {

				Socket client = httpServer.accept();
				System.out.println("Client connected.");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				String line = ""; // here will be saved first received line

				try {
					line = reader.readLine();

					if (line.contains("GET")) {
						String[] part = line.split(" ");
						String wantedAddress = part[1]; // this part contains requested part
						if (wantedAddress.equals("/") || wantedAddress.equals("/src/icon.png")) {
							// create reader for reading html code(index.html)
							BufferedReader htmlRead = new BufferedReader(new FileReader(new File("/index.html")));
							// writer writes string variable on local web site
							BufferedWriter htmlWrite = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
							String htmlContent = ""; // this string we need to put all read html data
							
							while (htmlRead.ready()) {
								htmlContent += htmlRead.readLine();
							}
							for (File f : files) {
								htmlContent += "<h1 align='center'><a href = /"+ f.toString() + ">"+ f.getName().substring(0, 7) + "</a></h1>";
							}
							htmlContent += "</body></html>";
							htmlWrite.write(htmlContent);
							htmlWrite.newLine();
							htmlWrite.close();
							htmlRead.close();

						} else {
							//fileName will contain the name of wanted adress
							String fileName = wantedAddress.substring(1);
							OutputStream clientWriter = client.getOutputStream();//stream will send image on browser
							FileInputStream clientReader = new FileInputStream(new File(fileName));//stream will read from image file
							
							byte[] buffer = new byte[1024];
							int readbyte;
							// Reading image file and sending it on browser.
							while ((readbyte = clientReader.read(buffer, 0,buffer.length)) > 0) {
								clientWriter.write(buffer, 0, readbyte);
							}
							
							// clientWriter.flush();
							clientWriter.close();
							clientReader.close();
						}

					} else if (line.contains("PUT")) {
						String date = Calendar.getInstance().getTime() + "";//will contain present date and time.
						String time = date.split(" ")[3];
						String name = "icon" + time.split(":")[0]+ time.split(":")[1] + time.split(":")[2];//represents name of received file
						InputStream is = client.getInputStream();// Declaring stream that will receive stream from client.
						File file = new File(name + ".png");// Creating new file.
						FileOutputStream fileSave = new FileOutputStream(file);//put received files in the stream
						
						byte[] array = new byte[1024];
						int readBytes;
						while ((readBytes = is.read(array, 0, array.length)) > 0) {
							fileSave.write(array, 0, readBytes);
						}
						// Closing stream.
						is.close();
						fileSave.close();
						files.add(file);	// Adds received image file into an list of files.
					}
				} catch (NullPointerException e) {
					System.out.println("error");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
