package ba.bitcamp.homework06.task04;

import ba.bitcamp.homework06.task01.Computer;
import ba.bitcamp.homework06.task02.Network;

/**
 * Extends Computer class and implements Connectable interface 
 * @author USER
 *
 */
public class Client extends Computer implements Connectable{
	private Computer connectedToComputer;
	private Network connectedToNetwork;
	
	/**
	 * Constructor with computer name and mac address
	 * @param name
	 * @param macAddress
	 */
	public Client(String name,char[] macAddress){
		super(name,macAddress);
		
	}
	

	@Override
	public void connect(Computer c) {
		if(connectedToComputer != null || connectedToNetwork != null){
			throw new IllegalArgumentException("Link to this computer already exist");
		}else{
			connectedToComputer = c;
		}
	}
	
	
	@Override
	public void connect(Network net) {
		if(connectedToNetwork != null || connectedToComputer != null){
			throw new IllegalArgumentException("Link to this network already exist");
		}else{
			connectedToNetwork = net;
		}
	}
	
	@Override
	public void disconnect() {
		connectedToComputer = null;
		connectedToNetwork = null;
		
	}
	
	/**
	 * Gets connected computer
	 * @return connectedToComputer
	 */
	
	public Computer getConnectedToComputer() {
		return connectedToComputer;
	}

	/**
	 * Gets connected network
	 * @return connectedToNetwork
	 */
	public Network getConnectedToNetwork() {
		return connectedToNetwork;
	}


	@Override
	public String toString() {
		return "Client connected to Computer, " + connectedToComputer + " "
				+ ", connected to Network " + connectedToNetwork ;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (connectedToComputer == null) {
			if (other.connectedToComputer != null)
				return false;
		} else if (!connectedToComputer.equals(other.connectedToComputer))
			return false;
		if (connectedToNetwork == null) {
			if (other.connectedToNetwork != null)
				return false;
		} else if (!connectedToNetwork.equals(other.connectedToNetwork))
			return false;
		return true;
	}
}
