

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ReadDataBase extends JFrame {

	private static final long serialVersionUID = -5933108435092844539L;

	JTextArea txt = new JTextArea();
	Person[] persons;

	
	public ReadDataBase() {

		txt.setEditable(false);
		try {
			fillArray();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


		String s = "";
		for (int i = 0; i < persons.length; i++) {
			s += persons[i].toString() + "\n";
		}
		txt.setText(s);
		add(txt);

		setSize(560, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	/**
	 * Reads database.txt file line by line. Creates new person with attributes
	 * first name, last name, day, month and year of birth. 
	 * @throws IOException
	 */
	private void fillArray() throws IOException {
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("database.txt"));
			String line = null;
			int counter = 0;
			while ((line = br.readLine()) != null) {
				counter++;
			}

			persons = new Person[counter];
			br = new BufferedReader(new FileReader("database.txt"));

			for (int i = 0; i < persons.length; i++) {

				line = br.readLine();
				String[] peopleInfo = line.split(",");

				String firstName = peopleInfo[0];
				String lastName = peopleInfo[1];
				String dateOfBirth = peopleInfo[2];
				//
				persons[i] = new Person(firstName, lastName,
						new DateOfBirth(
								Integer.parseInt(dateOfBirth.substring(1, 3)),
								Integer.parseInt(dateOfBirth.substring(4, 6)),
								Integer.parseInt(dateOfBirth.substring(7, 11))));
			

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Takes a string parameter representing the name of the file, and it will
	 * copy the contents into an array of strings.
	 * 
	 * @param String file
	 * @return String[]
	 */
	public static String[] readArray(String file) {

		int counter = 0;// Counts how many lines are in the file
		try {
			Scanner s1 = new Scanner(new File(file));
			while (s1.hasNextLine()) {
				counter++;
				s1.next();
			}
			String[] lines = new String[counter];// Creates the array and copy the elements in
			Scanner s2 = new Scanner(new File(file));
			for (int i = 0; i < counter; i++) {
				lines[i] = s2.next();
			}
			return lines;

		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		return null;
	}
	
}
