package ba.bitcamp.homework06.task07;

import ba.bitcamp.homework06.task01.Computer;

/**
 * Contains two methods to shrink or extend array of computers
 * @author USER
 *
 */
public class ArrayManipulation {

	/**
	 * Extends computer array if computer is added to the network
	 * @param c
	 * @return
	 */
	public static Computer[] extendArray(Computer[] c){
		Computer[] c1 = new Computer[c.length + 1];
		for (int i = 0; i < c.length; i++) {
			c1[i] = c[i];
		}
		c = c1;
		return c;
	}


	/**
	 * Shrinks computer array if computer is removed from the network
	 * @param c
	 * @return
	 */
	public static void shrinkArray(Computer[] c, int index){
		Computer[] c1 = new Computer[c.length - 1];
		for (int i = 0; i < index; i++) {
			c1[i] = c[i];
		}
		for (int i = index + 1; i < c1.length; i++) {
			c1[i] = c[i];
		}	
	}
}

