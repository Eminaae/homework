package ba.bitcamp.homework14.task01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * ViewComplaint class extends JFrame and is used to setup GUI interface for
 * management so they can view all complaints in database easily.
 * 
 *
 */
public class GuiViewComplaint extends JFrame {
	private static final long serialVersionUID = 2815863892603059630L;

	private static JButton button = new JButton("Refresh list");
	private JTextArea complaintArea = new JTextArea();
	private Connection conn = null;
	
	/**
	 * Default constructor of ViewComplaint class
	 */
	public GuiViewComplaint() {
		
		setLayout(new BorderLayout());
		add(button, BorderLayout.SOUTH);
		add(complaintArea, BorderLayout.CENTER);
		button.addActionListener(new Action());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 250);
		setVisible(true);
	}


	/**
	 * Private inner class used to add action to update button. When button is
	 * pressed query is sent to database to select all complaints from complaint
	 * table. Complaints are parsed, temp Complaint object is created and if not
	 * already added, it's added to ArrayList of complaints.

	 */
	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ConnectToDatabase.connect();
			} catch (ClassNotFoundException e2) {
				System.err.println("JDBC library is not loaded.");
				System.err.println("Msg: " + e2.getMessage());
				System.exit(1);
			}
			ArrayList<Complaint> list = new ArrayList<>();
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM book");

				while (result.next()) {
					int id = result.getInt(1);
					String complaint = result.getString(2);
					String timeDate = result.getString(3);

				Complaint c = new Complaint();
				c.setId(id);
				c.setComplaint(complaint);
				c.setDateTime(timeDate);
				list.add(c);
				}
			} catch (SQLException e1) {
				System.err.println("Bad SQL command.");
				System.err.println("Msg: " + e1.getMessage());
				System.exit(1);
			}
			complaintArea.setText(list.toString());
		}
	}
}