package ba.bitcamp.homework07.task01;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Represents linked list of double data type
 * 
 * @author USER
 *
 */
public class LinkedListDouble {

	private Node start;

	/**
	 * An empty constructor
	 */
	public LinkedListDouble() {
		super();
	}

	public LinkedListDouble(LinkedListDouble list) {
		super();
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}

	/**
	 * Adds value to the list
	 * 
	 * @param value
	 */
	public void add(double value) {
		if (start == null) {
			start = new Node(value);
			return;
		}
		Node temp = start;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		temp.setNext(new Node(value));
	}

	/**
	 * Removes value on given index
	 * 
	 * @param index
	 *            - index of element
	 * @return value
	 * @throw NoSuchElementException() if given index is bigger than list size
	 */
	public void remove(int index) {
		Node previous = start;
		for (int i = 0; i < index - 1; i++) {
			if (previous == null) {
				throw new NoSuchElementException();
			}
			previous = previous.getNext();
		}
		if (previous.getNext() == null)
			throw new NoSuchElementException();
		Node temp = previous.getNext();
		previous.setNext(temp.getNext());
	}

	/**
	 * Returns given index value
	 * 
	 * @param index
	 *            - index
	 * @return value
	 */
	public double get(int index) {
		Node temp = start;
		for (int i = 0; i < index - 1; i++) {
			if (temp == null) {
				throw new NoSuchElementException();
			}
			temp = temp.getNext();
		}
		return temp.getValue();
	}

	/**
	 * Returns list size
	 * 
	 * @return size - list size
	 */
	public int size() {
		Node temp = start;
		int size = 0;
		while (temp != null) {
			temp = temp.getNext();
			size++;
		}
		return size;
	}

	/**
	 * Returns middle element value.
	 * 
	 * @throws NoSuchElementException
	 *             if list is empty
	 */

	public double getMiddle() throws NoSuchElementException {
		if (start == null)
			throw new NoSuchElementException();
		return get((size() - 1) / 2);
	}

	/**
	 * Returns first element in the list
	 * 
	 * @return first element in the list
	 * @throws NoSuchElementException
	 */
	public double getFirst() throws NoSuchElementException {
		if (start == null)
			throw new NoSuchElementException();
		return start.getValue();
	}

	/**
	 * Returns the last element in the list
	 * 
	 * @return the last element in the list
	 * @throws NoSuchElementException
	 *             if list is empty
	 */
	public double getLast() throws NoSuchElementException {
		if (start == null)
			throw new NoSuchElementException();
		return get(size() - 1);
	}

	/**
	 * Deletes the first element in the list
	 * 
	 * @throws NoSuchElementException
	 *			   if list is empty
	 */
	public void deleteFirst() throws NoSuchElementException {
		if (start == null)
			throw new NoSuchElementException();
		start = start.getNext();
	}

	/**
	 * Deletes the last element in the list
	 * 
	 * @throws NoSuchElementException
	 */

	public void deleteLast() throws NoSuchElementException {
		if (start == null)
			throw new NoSuchElementException();
		remove((size() - 1));
	}

	/**
	 * Adds value to the list at the given index
	 * 
	 * @param value - value to add
	 * @param index - index to add
	 * @throws ArrayIndexOutOfBoundsException if index is bigger than a list size
	 */
	public void add(double value, int index)
			throws ArrayIndexOutOfBoundsException {
		if (index > size())
			throw new ArrayIndexOutOfBoundsException();
		Node previous = start;
		for (int i = 0; i < index - 1; i++) {
			previous = previous.getNext();
		}
		Node temp = new Node(value);
		temp.setNext(previous.getNext());
		previous.setNext(temp);
	}

	@Override
	public String toString() {
		if (start == null)
			System.out.println("Empty list");
		return start.toString();
	}

	private class Node {

		private double value;
		private Node next;

		public Node(double value) {
			super();
			this.value = value;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			if (next == null) {
				return String.valueOf(value);
			}
			return value + " " + next.toString();
		}
	}
}
