package ba.bitcamp.homework09.task02;

public class Main {

	public static void main(String[] args) {
		QueueOfDoubleArray queue = new QueueOfDoubleArray();
		System.out.println(queue.isEmpty());
		for (int i = 1; i <= 15; i++) {
			queue.add(i + 0.0);
		}
		System.out.println(queue.isEmpty());
		System.out.println("Test peek ->" + queue.peek());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.offer(0.25));
		System.out.println(queue.offer(0.22));
		System.out.println(queue);


	}

}
