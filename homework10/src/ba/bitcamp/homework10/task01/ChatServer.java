package ba.bitcamp.homework10.task01;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.security.ntlm.Client;

import ba.bitcamp.homework10.shared.SharedMethods;

/**
 * This is an example for chat server - client Scoket Programming in java. 
 * This class describes chat server side. Java Scoket is used to connect server and client.
 * To run this application first run the server one and then client. Chat server class extends JFrame and implements
 * two interfaces Action Listener and Runnable.
 * @author USER
 *
 */
public class ChatServer extends JFrame {

	private static final long serialVersionUID = -298617982912721581L;
	private static final int PORT = 7543;
	private Socket client;
	private ServerSocket server;

	private JPanel panel = new JPanel();
	private JPanel areaPanel = new JPanel();
	private JPanel textPanel = new JPanel();
	private JTextArea area = new JTextArea();
	private JScrollPane scroll = new JScrollPane(area);
	private JTextField text = new JTextField();
	private BufferedReader reader;
	private BufferedWriter writer;
	private String areaText = "";
	
	/**
	 * Constructor of server that enables server to receive and send message to
	 * the client.
	 */
	public ChatServer() {
		panel.setLayout(new BorderLayout());
		areaPanel.setLayout(new BorderLayout());
		areaPanel.add(scroll);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		area.setEditable(false);

		textPanel.setLayout(new BorderLayout());
		textPanel.setBorder(BorderFactory.createTitledBorder("Write message"));
		textPanel.add(text);

		text.addKeyListener(new ServerAction());
		panel.add(areaPanel, BorderLayout.CENTER);
		panel.add(textPanel, BorderLayout.SOUTH);
		add(panel);

		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 200);
		setTitle("Server Chat");
		setVisible(true);

		runServer();
	}

	/**
	 * Inner class implementing key listener. KeyPressed method enables
	 * user to send message if ENTER is pressed.
	 */
	private class ServerAction implements KeyListener {

		/**
		 * Enables server to send message when key ENTER is pressed.
		 */
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER && !text.getText().equals("")) {
				try {
					writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					writer.write(text.getText());
					writer.newLine();
					writer.flush();
					area.append("Server: " + text.getText() + "\n");
					text.setText("");
					
				} catch (IOException e1) {
					if(writer!= null)
						try {
							writer.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					if(client != null)
						try {
							client.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					System.out.println("Failed or interrupted I/O operations");
					e1.printStackTrace();
				}
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	/**
	 * Creates server socket and enables server to receive messages from
	 * clients.
	 */
	public void runServer() {
			
			try {
				server = new ServerSocket(PORT);
				client = server.accept();
				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		try {
			while (true) {
				areaText = "Client: " + reader.readLine();
				if (areaText.indexOf("/open") != -1) {
					File file = new File(SharedMethods.getAddress(areaText, "/open", 6));
					Desktop.getDesktop().open(file);
				} else if (areaText.indexOf("/web") != -1) {
					Desktop.getDesktop().browse(new URL(SharedMethods.getAddress(areaText, "/web",5)).toURI());
				} else if (areaText.indexOf("/delete") != -1) {
					File file = new File(SharedMethods.getAddress(areaText, "/delete", 8));
					file.delete();
				} else if (areaText.indexOf("/list") != -1) {
					File file = new File(SharedMethods.getAddress(areaText,"/list", 6));
					area.append("Server: " + SharedMethods.directories(file) + "\n");
					writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					writer.write(SharedMethods.directories(file));
					writer.newLine();
					writer.flush();
					
				} else {
					area.append(areaText + "\n");
					area.setCaretPosition(area.getDocument().getLength());
				}
			}
		} catch (IOException | URISyntaxException e) {
			if(writer != null)
				try {
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(reader !=null)
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(client != null)
				try {
					reader.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			if(server != null)
				try {
					server.close();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				
			System.out.println("Failed or interrupted I/O operations, or string could not be parsed as a URI reference");
			//e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
