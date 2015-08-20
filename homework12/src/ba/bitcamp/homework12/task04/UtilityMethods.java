package ba.bitcamp.homework12.task04;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UtilityMethods {
	/**
	 * Method converts FileInputStream object into byte array
	 * @param in - FileInputStream object
	 * @return - array representation of received InputStream Object
	 * @throws IOException
	 */
	public static byte[] getBytesFromFileInputStream(FileInputStream in)throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024]; // Create the byte array to hold the data

		for (int len; (len = in.read(buffer)) != -1;)
			os.write(buffer, 0, len);

		os.flush();

		return os.toByteArray();
	}
}
