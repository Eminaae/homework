package ba.bitcamp.homework09.task01;

import java.util.EmptyStackException;

/**
 * Class stack of strings implemented using lists
 * 
 * @author USER
 *
 */
public class StackListString {

	private Node head;

	/**
	 * Default constructor
	 */
	public StackListString() {
		super();
	}

	/**
	 * isEmpty method checks if stack is empty
	 * 
	 * @return - true if and only if stack is empty, otherwise returns false
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * push method adds item on the top of the stack
	 * @param item - string that will be added on the top of the stack
	 * @return item - string argument
	 */
	public String push(String item){
		Node temp = new Node(item);
		temp.setNext(head);
		head = temp;
		return item;
	}
	
	/**
	 * Pop method removes an object from the top of the stack and returns that object.
	 * @return - object at the top of the stack
	 * @throws EmptyStackException if stack is empty.
	 */
	public String pop() throws EmptyStackException {
		if(head == null)
			throw new EmptyStackException();
		String item = head.getValue();
		head = head.getNext();
		return item;	
	}

	/**
	 * Peek method looks at the object on the top of stack
	 * @return object at the top of the stack
	 * @throws EmptyStackException if stack is empty
	 */
	public String peek() throws EmptyStackException {
			if(head == null)
					throw new EmptyStackException();
			return head.getValue();
			
	}
	
	/**
	 * Search method returns the 1-based position where an object is on this stack. 
	 * If the object o occurs as an item in this stack, this method returns the distance from the top of the stack 
	 * of the occurrence nearest the top of the stack; 
	 * the topmost item on the stack is considered to be at distance 1. 
	 * The equals method is used to compare o to the items in this stack.
	 * @param item - chosen string
	 * @return The 1-based position from the top of the stack where the object is located; 
	 * the return value -1 indicates that the object is not on the stack.
	 * @param item
	 * @return The 1-based position from the top of the stack where the object is located; 
	 * the return value -1 indicates that the object is not on the stack.
	 */
	public int search(String item){
		int position = 1;
		Node temp = head;
		while(temp != null){
			if(temp.getValue().equals(item)){
				return position;
			}
			position++;
			temp = temp.getNext();
		}
		return -1;
	}
	
	
	@Override
	public String toString() {
		if(head == null){
			System.out.println("Stack is empty!");
		}
		return head.toString();
	}


	private class Node {

		private String value;
		private Node next;

		/**
		 * Default constructor
		 * 
		 * @param value- this is the string that will be added on the top of stack
		 */
		public Node(String value) {
			super();
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			if(next == null){
				return value;
			}
			return value + "," + next.toString();
		}
	}
}