package ba.bitcamp.homework09.task01;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Class stack of strings implemented using arrays.
 * @author emina.a
 *
 */
public class StackArrayString {
	
	private String[] array;

	/**
	 * Default constructor 
	 * @param array
	 */
	public StackArrayString() {
		array = new String[0];
	}
	
	/**
	 * isEmpty method checking if stack is empty.
	 * @return true if stack does not contains items, otherwise return false.
	 */
	public boolean isEmpty(){
		return (array.length == 0);	
	}
	
	/**
	 * Push method adds item on the top of stack.
	 * @param item - String that will be added to the stack.
	 * @return / returns string argument
	 */
	public String push(String item){
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = item;
		return 	item;
	}
	
	/**
	 * Pop method removes an object at the top of the stack
	 * @return the string at the top of stack
	 * @throws EmptyStackException if stack is empty
	 */
	public String pop(){
		if(array.length == 0)
			throw new EmptyStackException();
		String temp = array[array.length - 1];
		array = Arrays.copyOf(array, array.length - 1);
		return temp;
	}
	
	/**
	 * Peek method just looks at the Sting on the top of stack 
	 * @return
	 * @throws EmptyStackException if stack is empty
	 */
	
	public String peek(){
		if(array.length > 0){
			return array[array.length - 1];
		}else{
			throw new EmptyStackException();
		}
	}

	/**
	 * Search method Returns the 1-based position where an object is on this stack. 
	 * If the object o occurs as an item in this stack, this method returns the distance from the top of the stack 
	 * of the occurrence nearest the top of the stack; 
	 * the topmost item on the stack is considered to be at distance 1. 
	 * The equals method is used to compare o to the items in this stack.
	 * @param item - chosen string
	 * @return The 1-based position from the top of the stack where the object is located; 
	 * the return value -1 indicates that the object is not on the stack.
	 */
	public int search(String item){
		for(int i = array.length - 1; i >= 0; i--){
			if(array[i].equals(item)){
				return array.length -1; 
			}
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return  Arrays.toString(array) ;
	}
	
	
	

}
