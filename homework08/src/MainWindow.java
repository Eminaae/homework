import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Gives an option to choose to read from database, add information to the file, 
 * search file, and link to code on Git Hub
 * 
 * @author emina.arapcic
 *
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = -6948440214404681818L;
	static BufferedImage bufferedImage;

	private JButton btnRead = new JButton("Open database");
	private JButton btnWrite = new JButton("Add data");
	private JButton btnSearch = new JButton("Search database");

	private ImageIcon icon = new ImageIcon(MainWindow.class.getResource("icon.png"));
	private JButton btnGitHub = new JButton("Git Hub", icon);

	public MainWindow() {

		setLayout(new GridLayout(4, 1));

		btnWrite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertInfo();
			}
		});

		btnRead.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ReadDataBase();
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SearchByName();
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		});

		btnGitHub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/Eminaae/homework/tree/homework08"));
				} catch (URISyntaxException | IOException e1) {

					e1.printStackTrace();
				}
			}

		});

		add(btnRead);
		add(btnWrite);
		add(btnSearch);
		add(btnGitHub);

		setSize(300, 200);
		setTitle("Birthday memo");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static class ImagePanel extends JPanel {

		private static final long serialVersionUID = 221227307122900452L;

		public ImagePanel() {
			try {
				bufferedImage = ImageIO.read(new File("icon.png"));
			} catch (IOException ex) {
				JOptionPane error = new JOptionPane("File can not be found.",JOptionPane.ERROR_MESSAGE);
				error.createDialog("Error").setVisible(true);
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bufferedImage, 0, 0, null);
		}

	}

	public static void main(String[] args) {
		new MainWindow();

	}
}
