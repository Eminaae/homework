package ba.bitcamp.homework06.task04;

import ba.bitcamp.homework06.task01.Computer;
import ba.bitcamp.homework06.task02.Network;

/**
 * Interface with three methods, connect Computer, connect Network and disconnect
 * @author USER
 *
 */
public interface Connectable {

	/**
	 * Connects computer to the network
	 * @param c - computer
	 */
	public void connect(Computer c);
	
	/**
	 * Connects network to the link
	 * @param net - network
	 */
	public void connect(Network net);
	
	/**
	 * Disconnects computer from the network
	 */
	public void disconnect();
}
