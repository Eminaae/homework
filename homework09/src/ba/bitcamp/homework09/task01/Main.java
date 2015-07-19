package ba.bitcamp.homework09.task01;

public class Main {


			public static void main(String[] args) {
				
				long start = System.currentTimeMillis();
				StackArrayString stack = new StackArrayString();
				for (int i = 0; i < 10000; i++) {
					stack.push("Add this on the top of stack");
				}
				while (!stack.isEmpty()) {
					stack.pop();
				}
				System.out.println("Time needed -> " + (System.currentTimeMillis() - start) + " millis");
				
				//testing StackString class methods
				stack.push("adding");
				stack.push("item1");
				stack.push("item2");
				System.out.println("Is stack empty: " + stack.isEmpty());
				System.out.println("Distance from the top of the stack to the searched item is: " + stack.search("item1"));
				System.out.println("What is on the top of stack: " + stack.peek());
				System.out.println("Item removed form stack: " + stack.pop());
				System.out.println(stack.search("item2"));
				
	}

}
