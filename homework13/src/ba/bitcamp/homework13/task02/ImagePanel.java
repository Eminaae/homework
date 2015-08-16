package ba.bitcamp.homework13.task02;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * ImagePanel class is loading image
 * To convert image to negative:
 * 	1. Get the RGB value of the pixel
 * 	2. Calculate the new RGB value as: R = 255 - R, G = 255 - G; B = 255 - B
 * 	3. Save the new RGB value (Negative pixel)
 * @author emina.a
 *
 */
public class ImagePanel extends JPanel {
	
	private static final long serialVersionUID = -8366561993283233380L;
	private BufferedImage image;
	private String originalImg = "src/public/picture.jpg";
	private String newImg ="src/public/newImage.jpg"; 
	boolean click = false; // declaring and initializing boolean
	
	private LinkedBlockingQueue<Producer> task = new LinkedBlockingQueue<>();
	private ArrayList<Consumer> consumer = new ArrayList<>();

	/**
	 * ImagePanel Constructor constructs JPanel. Mouse Clicked method defines change that is going to happen
	 * if we click on panel.
	 */
	public ImagePanel(){
		
		setSize(600,400);
		setVisible(true);
		loadImage(originalImg);
		
		//adding mouse listener to panel clickin on panel will load new image
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(click){
					loadImage(originalImg);
					click = false;
				}else{
					loadImage(newImg);
					click = true;
				}
				updateUI();//Resets the UI property with a value from the current look and feel.
			}
		});
	}
	
	/**
	 * Getter - returns imported image
	 * @return imported image
	 */
	
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * Load method is loading original image
	 * @param str - path to original image stored in src/public folder
	 */
	public void loadImage(String str){
		try {
			image = ImageIO.read(new File(originalImg));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 600, 400, this);
		repaint();
	}
	
	/**
	 * Inner Producer class represents tasks for execution
	 * @author emina.a
	 *
	 */
	private class Producer implements Runnable{
		//attributes
		private int row;
		private int column;
		
		/**
		 * Constructor construct a new producer
		 * @param row - rows number
		 * @param column - columns number
		 */

		public Producer(int row, int column) {
			this.row = row;
			this.column = column;
		}

		//subtract all pixels for 255 in row
		@Override
		public void run() {
			for(int i = 0; i < row; i++){
				image.setRGB(i, column, 255 - image.getRGB(i, column));
			}
		}
	}
	
	/**
	 * Inner class Consumer represents threads that will do tasks
	 * @author emina.a
	 *
	 */
	private class Consumer extends Thread{
		//thread needs to be alive as long as there are tasks in the task list
		@Override
		public void run() {
			while (!task.isEmpty()) {
				Producer job;
				try {
					job = task.take();
					job.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		
		/**
		 *  This method should is used when an application thread needs to update the GUI.
		 */
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(600, 400);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Buffered Image");
				frame.setVisible(true);
				frame.add(new ImagePanel());
			}
		});
	}
}
