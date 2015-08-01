package ba.bitcamp.homework10.shared;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Shared Methods class contains static getAction method used in both ChatClient and ChatServer classes
 * @author emina
 *
 */
public class SharedMethods {
	
	/**
	 * Method getAction checks message for given parameters
	 *"/open" - opens file; "/delete" - deletes file in given path
	 *"/web" - opens web page, "/list" - write out list of files in given directory
	 * @param text - received string
	 */
		public static void getAction(String text) {
			try {

				String[] line = text.split(" ", 2);
				File file = new File(line[1]);
				Socket client = new Socket();

				if (line[0].equals("/open")) {
					Desktop.getDesktop().open(file);

				} else if (line[0].equals("/web")) {
					Desktop.getDesktop().browse(
							new URL("http://" + line[1]).toURI());

				} else if (line[0].equals("/delete")) {
					file.delete();

				} else if (line[0].equals("/list")) {
					String[] list = file.list();

					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					writer.write("Files in folder " + file);
					writer.newLine();

					for (String string : list) {
						writer.write(string);
						writer.newLine();
					}
					writer.flush();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

