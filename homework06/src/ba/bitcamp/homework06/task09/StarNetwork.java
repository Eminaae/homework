package ba.bitcamp.homework06.task09;

import ba.bitcamp.homework06.task01.Computer;
import ba.bitcamp.homework06.task02.Network;
import ba.bitcamp.homework06.task03.Server;
import ba.bitcamp.homework06.task04.Client;
import ba.bitcamp.homework06.task06.Functionable;
import ba.bitcamp.homework06.task07.ArrayManipulation;

/**
 * Extends Network class and implements Functionable interface.</p>Contains methods for checking if network is in function.
 * @author USER
 *
 */
public class StarNetwork extends Network implements Functionable {
	
	private Server s;
	static int counter;

	/**
	 * Constructor initializes server.
	 * @param networkName - network name
	 * @param s - represents server
	 */
	public StarNetwork(String networkName, Server s) {
		super(networkName);
		this.s = s;
	}

	/**
	 * Checks network functionality
	 * @return true if number of computers on network is lower than server capacity
	 */
	@Override
	public boolean isFunctioning() {
		for (int i = 0; i < getComputerArray().length; i++) {
			if (getComputerArray()[i] instanceof Client) {
				Client c = (Client) getComputerArray()[i];
				if (c.getConnectedToNetwork() != null) {
					counter++;
				}
			}
			if (counter > s.getMaxComputerNum()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Adds computer to the network.
	 */
	@Override
	public void addComputer(Computer c) {
		if (c instanceof Server) {
			throw new IllegalArgumentException("Can not add server computer");
		} else {
			Computer[] computer = ArrayManipulation.extendArray(getComputerArray());
			computer[computer.length - 1] = c;
			setComputerArray(computer);
			if (c instanceof Client) {
				Client cl = (Client) c;
				cl.connect(s);// Connecting to server
			}
		}
	}

	@Override
	public void removeComputer(Computer c) {
		if (c instanceof Client) {
			Client c1 = (Client) c;
			for (int i = 0; i < getComputerArray().length; i++) {
				if (c.equals(getComputerArray()[i])) {
					c1.disconnect();
					ArrayManipulation.shrinkArray(getComputerArray(), i);
					counter--;
					return;

				} else {
					throw new IllegalArgumentException("Computer does not exist");
				}
			}
		}
		throw new IllegalArgumentException("Computer not found!");
	}

	@Override
	public String toString() {
		return "Number of computers: " + counter + " network functionable is " + isFunctioning();
	}
	
	
}
