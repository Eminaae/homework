package ba.bitcamp.homework09.task01;

public class Main1 {

	public static void main(String[] args) {

		//Testing class
		long start = System.currentTimeMillis();
		StackListString stack = new StackListString();
		for (int i = 0; i < 100000; i++) {
			stack.push("aaa");
		}
		while (!stack.isEmpty()) {
			stack.pop();
		}
		System.out.println("It took: " + (System.currentTimeMillis() - start) + " millis");
		//testing StackString class methods
		stack.push("adding");
		stack.push("item1");
		stack.push("item2");
		System.out.println("Is stack empty: " + stack.isEmpty());
		System.out.println("Distance from the top of the stack to the searched item is: " + stack.search("item1"));
		System.out.println("What is on the top of stack: " + stack.peek());
		System.out.println("Item removed form stack: " + stack.pop());
		System.out.println(stack.search("item2"));
		System.out.println(stack);

	}

}
