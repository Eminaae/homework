package ba.bitcamp.homework10.task01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ba.bitcamp.homework10.shared.SharedMethods;

/**
 * This is an example for chat server - client Scoket Programming in java. 
 * This class describes chat server side. Java Scoket is used to connect server and client.
 * To run this application first run the server one and then client. Chat server class extends JFrame and implements
 * two interfaces Action Listener and Runnable.
 * @author USER
 *
 */
public class ChatServer extends JFrame implements ActionListener, Runnable {
	
	private static final long serialVersionUID = -4866337574069034139L;
	//attributes declaration
	private BufferedWriter writer;
	private BufferedReader reader;;
	private static final int PORT = 8788;
	ServerSocket server;
	JFrame serverWindow;
	JPanel panelServer;
	JTextArea msgArea;
	JButton msgSend;
	JTextField msgField;
	Thread t;
	private JScrollBar scroll;

	/**
	 *  Default constructor constructs chat server window and server socket.
	 */
	public ChatServer() {
		// chat server
		serverWindow = new JFrame("ChatServer");
		panelServer = new JPanel();
		
		msgArea = new JTextArea();
		msgField = new JTextField();
		msgSend = new JButton("Send");
		msgSend.addActionListener(this);// adding an action listener to send button
		
		serverWindow.add(panelServer);
		panelServer.add(msgArea);
		panelServer.add(msgField);
		panelServer.add(msgSend);
		
		panelServer.setLayout(new BorderLayout());
		panelServer.add(msgArea, BorderLayout.NORTH);// adding text area to the panel
		panelServer.add(msgField,BorderLayout.CENTER);
		panelServer.add(msgSend, BorderLayout.SOUTH);
		add(scroll = new JScrollBar(), BorderLayout.EAST);
		
		
		serverWindow.setLocationRelativeTo(null);
		serverWindow.setSize(300, 400);
		serverWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverWindow.setResizable(false);
		//serverWindow.pack();
		serverWindow.setVisible(true);

		System.out.println("Connecting to port" + PORT + "....");

		try {

			server = new ServerSocket(PORT);
			Socket clientSocket = server.accept();
			System.out.println("Client connected" + clientSocket);
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // reads input from input stream reader
			writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));//reads output from output stream
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		t = new Thread(this); // starts a new thread
		t.setDaemon(true); // sets a thread as daemon
		t.start();
	}

	/**
	 * Thread running as a process in a background, reading lines and appends them to msg area
	 */
	@Override
	public void run() {
		while (true) {
			try {
				String s = reader.readLine(); // reads input from text field
				msgArea.append(s + "\n");
				SharedMethods.getAction(reader.readLine());
				System.out.println(s);
			} catch (Exception e2) {
			}
		}
	}

	/**
	 * ActionPerformed method will be called after clicking on send button.
	 * The value of text field will be written in buffered writer, appended to the string and at the
	 * end text field will be cleaned.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == msgSend) {
			String s = msgField.getText();
			try {
				writer.write(s);
				writer.newLine();
				writer.flush();
				msgArea.append("me: " + s + "\n");
				msgField.setText(""); // clean the text field
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ChatServer server = new ChatServer(); //instantiate a chat server
	}
}
