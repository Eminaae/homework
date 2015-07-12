package ba.bitcamp.homework06.task02;

import ba.bitcamp.homework06.task01.Computer;
/**
 * Describes network with network name and computers in that network
 * @author USER
 *
 */
public abstract class Network {
	private String networkName;
	private Computer[] computerArray;
	
	/**
	 * Constructor that initialize array of computers to zero, and adds network name
	 * @param networkName
	 * @param computerArray
	 */
	public Network(String networkName) {
		super();
		this.networkName = networkName;
		this.computerArray = new Computer[0];
	}
	
	/**
	 * Gets network name
	 * @return networkName - network name
	 */
	
	public String getNetworkName() {
		return networkName;
	}

	/**
	 * Gets array of computers and uses it in BusNetwork and StarNetwork
	 * @return computerArray - array of computers in the network
	 */
	public Computer[] getComputerArray() {
		return computerArray;
	}

	/**
	 * Sets the new array of computers that is used in Bus and Star network
	 * @param computerArray - array of computers in the network
	 */

	public void setComputerArray(Computer[] computerArray) {
		this.computerArray = computerArray;
	}


	/**
	 * Abstract method adds computer to the network
	 * @param c - one computer
	 */
	public abstract void addComputer(Computer c);
	
	/**
	 * Abstract method removes computer from the network
	 * @param c - computer
	 */
	public abstract void removeComputer(Computer c);
}
