package ba.bitcamp.homework12.task03;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * InterruptingThread class extends JFrame, has three attributes label, button and thread.
 * We need to make our own thread.At the beginning label is empty.Every seconds label gets one letter.
 * eg. after three seconds label will have "abc". Button interrupts this process.
 * @author emina.a
 *
 */
public class InterruptingThread extends JFrame{

	private static final long serialVersionUID = 8266732242789162182L;
	public static JLabel label = new JLabel();
	private JButton button;
	private static Thread myThread;
	
	
	/**
	 * Constructor construct interrupting thread object.
	 * @param label - JLabel
	 * @param button - interrupt button
	 * @param myThread - thread
	 */

	public InterruptingThread(){
		label = new JLabel();
		button = new JButton("Interrupt");
		setLayout(new FlowLayout());
		add(button);
		add(label);
		
		button.addActionListener(new Action());//action listener for button
		label.setHorizontalAlignment(NORMAL);
		
		setSize(250, 150);
		setTitle("Interrupt writing");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		myThread = new Thread(new MyThread());
		myThread.start();
		
	}
	
	/**
	 * Action class is inner class implementing ActionListener. 
	 * Override method actionPerformed defines action if button is pressed.
	 */
	private class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button){
				myThread.interrupt();
			}
		}
	}
	

	/**
	 * Inner class implementing Runnable interface.
	 * Every second label gets one character, thread sleeps every one second unless button is pressed.
	 * @author USER
	 *
	 */
	private static class MyThread implements Runnable{

		@SuppressWarnings("static-access")
		@Override
		public void run() {
			
			for(char i = 65; i < 91; i++){
				label.setText(label.getText() + i);
				try {
					myThread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interrupted");
				}
			}
		}
	}
	

	public static void main(String[] args) {

		new InterruptingThread();
	}

}
