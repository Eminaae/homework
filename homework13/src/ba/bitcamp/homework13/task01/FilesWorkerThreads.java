package ba.bitcamp.homework13.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class FilesWorkerThreads {
	
	private static LinkedBlockingQueue<Producer> tasks;
	private static ArrayList<Consumer> consumers;
	private static Object lock = new Object();
	private static int counter = 1;
	
	/**
	 * Producer class
	 */
	private static class Producer implements Runnable{
		
		//declaring attributes: line in the file, and letter for counting
		private String line;
		private Character letter;
		
		public Producer(String line, Character letter){
			this.line = line;
			this.letter = letter;
		}

		@Override
		public void run() {
			for(int i = 0; i < line.length(); i++){
				if(line.charAt(i) == letter){//line.charAt(i) returns value at the index 0 which is first letter in file
					synchronized (lock) {
						counter++;
					}
				}
			}
		}
	}
	
	/**
	 * Inner class Consumer represents threads that will do tasks
	 * @author USER
	 *
	 */
	private static class Consumer extends Thread{
		
		@Override
		public void run() {
			while(!tasks.isEmpty()){
				try {
					Producer work = tasks.take();
					work.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, IOException {
		
		tasks = new LinkedBlockingQueue<>();
		consumers = new ArrayList<>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(new File("src/public/chapter.txt")));
			try {
				char first = (char) reader.read(); // reads a single character
				System.out.println(first);
				first = Character.toLowerCase(first);
				String readLine = "";
				
				while (reader.ready()) {
					readLine = reader.readLine().toLowerCase();
					Producer p = new Producer(readLine, first);
					tasks.add(p);
				}
				reader.close();

				long start = System.currentTimeMillis();
				for (int i = 0; i < 3; i++) {
					Consumer consum = new Consumer();
					consum.start();
					consumers.add(consum);
				}

				for (Consumer c : consumers) {
					try {
						c.join();
					} catch (InterruptedException e) {
						if (Thread.interrupted()) // Clears interrupted status!
							throw new InterruptedException();
					}
				}
				
				System.out.println("Time -> " + (System.currentTimeMillis() - start) + "(ms)");
				System.out.printf("letter repeated %s : %d", first, counter);

			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				if (reader != null)
					reader.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Wrong path or file doesnt exist.");
			if(reader != null)
				reader.close();
		}
	}
}
