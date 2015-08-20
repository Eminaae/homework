package ba.bitcamp.homework06.task03;

import ba.bitcamp.homework06.task01.Computer;

/**
 * Describes maximal number of Computers connected to the Server that will not cause crash
 * @author USER
 *
 */
public class Server extends Computer{
	private int maxComputerNum;

	/**
	 * Constructor initializes computer name, mac address and max number of computers connected to the server
	 * @param name - computer name
	 * @param macAddress - computer's mac address
	 * @param maxComputerNum - max number of computers on server  that will not cause crash
	 */
	public Server(String name, char[] macAddress,int maxComputerNum) {
		super(name, macAddress);
		this.maxComputerNum = maxComputerNum;
	}

	/**
	 * Gets maximal number of computers connected to the Server that will not cause crash
	 * @return macComputerNum - maximal number of computers
	 */
	public int getMaxComputerNum() {
		return maxComputerNum;
	}
	
	@Override
	public String toString() {
		
		return "Maximal number of computers on server" + maxComputerNum;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (maxComputerNum != other.maxComputerNum)
			return false;
		return true;
	}
	
	
	

}
