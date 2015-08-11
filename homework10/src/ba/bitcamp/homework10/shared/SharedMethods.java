package ba.bitcamp.homework10.shared;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * Shared Methods class contains static getAddress and directories method used in both ChatClient and ChatServer classes
 * @author emina.a
 *
 */
public class SharedMethods {

		/**
		 * getAddress method for getting file path if entered line is command
		 * 
		 * @param areaText
		 * @param command
		 * @param index
		 * @return path of the file.
		 */
		public static String getAddress(String areaText, String command, int index) {
			return areaText.substring(areaText.indexOf(command) + index,
					areaText.length());
		}

		/**
		 * Method for getting list of directories if entered line is file
		 * Instances of classes that implement this interface are used to filter filenames. 
		 * These instances are used to filter directory listings in the list method of class File
		 * @param file- File that contains directories.
		 * @return Array of directories in the file.
		 */
		public static String directories(File file) {
			String[] directories = file.list(new FilenameFilter() {
				public boolean accept(File current, String name) {
					return new File(current, name).isDirectory();
				}
			});
			return Arrays.toString(directories);
		}
		
	}

