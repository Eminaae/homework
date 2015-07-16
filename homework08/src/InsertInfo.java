
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Adds new person information into database.txt file
 * 
 * @author emina.a
 *
 */
public class InsertInfo extends JFrame {

	private static final long serialVersionUID = -5582704702717902655L;

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;

	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;

	private JButton button;

	public InsertInfo() {
		setLayout(new BorderLayout());
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		panel1.setBorder(BorderFactory.createTitledBorder("User information"));
		panel2.setBorder(BorderFactory.createTitledBorder("Write to file"));
		panel1.setLayout(new GridLayout(5, 1));

		label1 = new JLabel("First name");
		panel1.add(label1);
		text1 = new JTextField(10);
		panel1.add(text1);

		label2 = new JLabel("Last name");
		panel1.add(label2);
		text2 = new JTextField(10);
		panel1.add(text2);

		label3 = new JLabel("Day");
		panel1.add(label3);
		text3 = new JTextField(10);
		panel1.add(text3);

		label4 = new JLabel("Month");
		panel1.add(label4);
		text4 = new JTextField(10);
		panel1.add(text4);

		label5 = new JLabel("Year");
		panel1.add(label5);
		text5 = new JTextField(10);
		panel1.add(text5);

		button = new JButton("Subbmit");
		panel2.add(button);

		event e = new event();
		button.addActionListener(e);

		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 265);
		setTitle("Writer");
		setVisible(true);

	}

	public class event implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String word = text1.getText() + ", " + text2.getText() + ", "
						+ text3.getText() + "." + text4.getText() + "."
						+ text5.getText() + ". ";
				FileWriter stream = new FileWriter("database.txt", true);
				BufferedWriter out = new BufferedWriter(stream);
				out.write("\n" + word);
				out.close();
			} catch (IOException ex) {
				System.out.println("Failed input/output operation");

			}
		}
	}
}
