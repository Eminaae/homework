package ba.bitcamp.homework12.task04;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Class Client represents client uploading image file as bytes array to server.
 * @author emina.a
 *
 */
public class Client {

	private static final String HOST = "localhost";
	private static final int PORT = 8000;
	

	public static void main(String[] args) {
		try {
			Socket client = new Socket(HOST, PORT);
			//writer for transferring message to the server
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			writer.write("PUT");
			writer.newLine();
			writer.flush();
			//output stream for the network socket
			OutputStream out = client.getOutputStream(); //sends image to the server
			FileInputStream in = new FileInputStream(new File("/src/image.jpg")); //reads from image file
			//**UtilityMethods.getBytesFromFileInputStream(in);
			byte[] array = new byte[1024];
			int readBytes;
			// Reading image file and sending it to the server.
			while ((readBytes = in.read(array, 0, 1024)) > 0) {
				out.write(array, 0, readBytes);
			}
			in.close();
			client.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
