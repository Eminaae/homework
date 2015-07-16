import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Creates new JTextArea where we can check first and last names in database
 * @author emina.a
 *
 */
public class SearchByName extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextArea txt = new JTextArea();
	Person[] persons;

	public SearchByName() throws IOException {

		txt.setEditable(false);
		try {
			fillArray();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String s = "";
		for (int i = 0; i < persons.length; i++) {
			s += persons[i].getFirstName() + " " + persons[i].getLastName() + "\n";
		}
		
		txt.setText(s);
		add(txt);

		setSize(560, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Creates an array with information from the file
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
				persons[i] = new Person(firstName, lastName, new DateOfBirth(
						Integer.parseInt(dateOfBirth.substring(1, 3)),
						Integer.parseInt(dateOfBirth.substring(4, 6)),
						Integer.parseInt(dateOfBirth.substring(7, 11))));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}