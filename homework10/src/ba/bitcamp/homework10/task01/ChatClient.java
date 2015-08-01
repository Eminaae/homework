package ba.bitcamp.homework10.task01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ba.bitcamp.homework10.shared.SharedMethods;
/**
 * To run this configuration first run the server one and than client. 
 * Chat client class connects user to the server, which can communicate continuously. GUI is used 
 * to have a field where user enters message, shows current messages. 
 * ChatClient class extends JFrame and implements two interfaces ActionListener and Runnable
 * @author emina.a
 *
 */
public class ChatClient extends JFrame implements ActionListener, Runnable{

	//attributes declaration
	public static BufferedWriter writer;
	public static BufferedReader reader;
	private Socket clientSocket;
	private Thread t;
	private JFrame clientWindow;
	private JPanel panelClient;
	private JTextArea msgArea;
	private JTextField msgField;
	private JButton msgSend;
	

	/**
	 * Default constructor constructs chat client window and socket for a client
	 */
	public ChatClient() {
		clientWindow = new JFrame("ChatClient"); //frame for client
		panelClient = new JPanel(); // panel for client

		msgArea = new JTextArea();
		msgField = new JTextField();
		msgSend = new JButton("Send");
		msgSend.addActionListener(this); // adding an action listener to send button

		clientWindow.add(panelClient);
		panelClient.add(msgField);
		panelClient.add(msgSend);
		panelClient.add(msgArea);
		

		panelClient.setLayout(new BorderLayout());
		panelClient.add(msgArea, BorderLayout.NORTH); // adding text area to the panel
		panelClient.add(msgField, BorderLayout.CENTER);
		panelClient.add(msgSend, BorderLayout.SOUTH);
		
		clientWindow.setLocationRelativeTo(null);
		clientWindow.setSize(300, 400);
		clientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientWindow.setResizable(false);
		//clientWindow.pack();
		clientWindow.setVisible(true);

		try {
			clientSocket = new Socket(InetAddress.getLocalHost(), 8788); //Socket for a client
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // reads input from input stream reader
			writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); //reads output from output stream
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread t = new Thread(this); //creates a new thread
		t.setDaemon(true); //
		t.start();
	}
	
/**
 * ActionPerformed method will be called after clicking on send button.
 * The value of text field will be written in buffered writer, appended to the string and at the
 * end text field will be cleaned.
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == msgSend){
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

	/**
	 * Thread running as a process in a background, reading lines and appends them to msg areaa
	 */
	@Override
	public void run() {
		while (true) {
			try {
				msgArea.append(reader.readLine() + "\n");
				System.out.println(reader.readLine());
				SharedMethods.getAction(reader.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		ChatClient client = new ChatClient(); //instantiate a chat client
		
	}
}
