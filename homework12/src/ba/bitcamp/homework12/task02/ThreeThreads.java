package ba.bitcamp.homework12.task02;

import java.util.Random;

/**
 * ThreeThreads class ensures that three threads are running tasks one by one, and completing tasks
 * for certain period of time. Class contains one inner class implementing Runnable interface.  
 * @author emina.a
 *
 */
public class ThreeThreads {
	
	private static final int NUMBERS = 1;
	private static final int BITCAMP = 2;
	private static final int RAND_NUMBERS = 3;
	
	/**
	 * ThreadTest is inner class, implements Runnable interface. 
	 * Class has one attribute choice, that should be one of the constants defined in ThreeThreads class.
	 * Constructor receives one parameter, that should be one of the choices defined with constants in ThreeThread class.
	 * @author USER
	 *
	 */
	private static class ThreadTest implements Runnable{
		
		private int choice;
		
		public ThreadTest(int choice){
			this.choice = choice;
		}
		

		@Override
		public void run() {
			
			if(choice == NUMBERS){
				for(int i = 1; i < 11; i++){
					System.out.print(i + ", ");
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}System.out.println();
				
			}else if(choice == BITCAMP){
				for(int i = 1; i < 5; i ++){
					System.out.print("BitCamp, ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}System.out.println();
				
			}else if(choice == RAND_NUMBERS){
				Random rand = new Random();
				for(int i = 1; i < 6; i++){
					System.out.print((rand.nextInt(5) + 1) + ", ");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		//creating three threads
		Thread t1 = new Thread(new ThreadTest(NUMBERS));
		Thread t2 = new Thread(new ThreadTest(BITCAMP));
		Thread t3 = new Thread(new ThreadTest(RAND_NUMBERS));
		
		try {
			t1.start(); //t1 begins execution
			t1.join();
			
			t2.start();
			t2.join();
			
			t3.start();
			t3.join();
			
			System.out.println("\nEnd of the main.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
