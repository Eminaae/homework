package ba.bitcamp.homework09.task02;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Class queue of doubles implemented using arrays
 * @author emina.a
 *
 */
public class QueueOfDoubleArray {
	
	private Double[] array;

	/**
	 * Default constructor
	 */
	public QueueOfDoubleArray() {
		array = new Double[0];
	}
	
		
	/**
	 * Inserts the specified element into this queue
	 * @param item - item to add
	 * @return returning true upon success
	 */
	public boolean add(Double item){
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = item;
		return true;
	}
	
	/**
	 * Retrieves, but does not remove, the head of this queue, 
	 * or returns null if this queue is empty.
	 * @return - the head of this queue, or null if this queue is empty
	 */
	public double peek(){
		return array[0];
		
	}
	
	/**
	 * poll method will remove element from queue and return element to calling method.
	 * @return item that was removed
	 */
	public Double poll() {
		Double item = array[0];
		array = Arrays.copyOf(Arrays.copyOfRange(array, 1, array.length),array.length - 1);
		return item;
	}
	

	/**
	 * Inserts the specified element into this queue
	 * @param item - the element to add
	 * @return true if the item was added to the queue, otherwise returns false
	 * @throws ClassCastException - if the class of the specified element prevents it from being added to this queue
	 * @throws NullPointerException - if the specified element is null and this queue does not permit null elements
	 * @throws IllegalArgumentException - if some property of this element prevents it from being added to this queue
	 */
	public boolean offer(Double item) {
		try {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = item;
			return true;
		} catch (NullPointerException e1) {
			return false;
		} catch (ClassCastException e2) {
			return false;
		} catch (IllegalArgumentException e3) {
			return false;
		}
	}

	/**
	 * Retrieves and removes the head of this queue. 
	 * This method differs from poll only in that it throws an exception if this queue is empty.
	 * @return item - the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public Double remove() {
		try {
			Double item = array[0];
			array = Arrays.copyOf(Arrays.copyOfRange(array, 1, array.length),
					array.length - 1);
			return item;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of this queue. 
	 * This method differs from peek only in that it throws an exception if this queue is empty.
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public Double element() {
		if (array == null) {
			throw new NoSuchElementException();
		} else {
			return array[0];
		}
	}

	/**
	 * IsEmpty method checks if queue is empty
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		return array.length == 0;
	}

	public String toString() {
		return Arrays.toString(array);
	}

}
