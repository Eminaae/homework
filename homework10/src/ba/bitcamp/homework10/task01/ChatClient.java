package ba.bitcamp.homework10.task01;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ba.bitcamp.homework10.shared.SharedMethods;


/**
 * To run this configuration first run the server one and than client. 
 * Chat client class connects user to the server, which can communicate continuously. GUI is used 
 * to have a field where user enters message, shows current messages. 
 * ChatClient class extends JFrame.
 * @author emina.a
 *
 */
public class ChatClient extends JFrame {

	private static final long serialVersionUID = -7757769690378658201L;
	private static final int PORT = 7543;
	private static final String HOST = "localhost";
	
	private Socket client;

	private JPanel panel = new JPanel();
	private JPanel areaPanel = new JPanel();
	private JPanel textPanel = new JPanel();
	
	private JTextArea area = new JTextArea();
	private JTextField text = new JTextField();
	private JScrollPane scroll = new JScrollPane(area);
	

	/**
	 * ChatClient constructor constructs GUI application for Client
	 */
	public ChatClient() {
		panel.setLayout(new BorderLayout());

		areaPanel.setLayout(new BorderLayout());
		areaPanel.add(scroll);
		
		textPanel.setLayout(new BorderLayout());
		textPanel.add(text);
		textPanel.setBorder(BorderFactory.createTitledBorder("Write message"));
		text.addKeyListener(new ClientAction());
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		area.setEditable(false);
		
		panel.add(areaPanel, BorderLayout.CENTER);
		panel.add(textPanel, BorderLayout.SOUTH);

		add(panel);

		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);;
		setTitle("Client");
		setVisible(true);

		runClient();
	}

	/**
	 * ClientAction class is inner class implementing key listener. KeyPressed method allows user to 
	 * send message if ENTER is pressed.
	 */
	private class ClientAction implements KeyListener {

		/**
		 * Enables client to send message when key ENTER is pressed.
		 */
		public void keyPressed(KeyEvent e) {
			BufferedWriter writer = null;
			if (e.getKeyCode() == KeyEvent.VK_ENTER && !text.getText().equals("")) {
				try {
					writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					writer.write(text.getText());
					writer.newLine();
					writer.flush();
					area.append( "Client: " + text.getText() + "\n");
					text.setText("");
				} catch (IOException e1) {
					if(writer != null)
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
	 *runClient method is used to connect Client to the Server and to enable receiving messages from the Server
	 *
	 */
	public void runClient() {
		BufferedWriter writer = null;
		BufferedReader reader = null;
		try {
			client = new Socket(HOST, PORT);
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			String areaText = "";

			while (true) {
				areaText = "Server: " + reader.readLine();
				if (areaText.indexOf("/open") != -1) {
					File file = new File(SharedMethods.getAddress(areaText, "/open", 6));
					Desktop.getDesktop().open(file);
				} else if (areaText.indexOf("/web") != -1) {
					Desktop.getDesktop().browse(new URL(SharedMethods.getAddress(areaText, "/web", 5)).toURI());
				} else if (areaText.indexOf("/delete") != -1) {
					File file = new File(SharedMethods.getAddress(areaText, "/delete", 8));
					file.delete();
				} else if (areaText.indexOf("/list") != -1) {
					File file = new File(SharedMethods.getAddress(areaText, "/list", 6));
					area.append("Client: " + SharedMethods.directories(file) + "\n");
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
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(client != null)
				try {
					client.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			System.out.println("Failed or interrupted I/O operations, or string could not be parsed as a URI reference");
			//e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new ChatClient();
	}

}
