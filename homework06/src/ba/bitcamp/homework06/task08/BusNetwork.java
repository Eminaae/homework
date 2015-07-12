package ba.bitcamp.homework06.task08;

import java.util.Arrays;

import ba.bitcamp.homework06.task01.Computer;
import ba.bitcamp.homework06.task02.Network;
import ba.bitcamp.homework06.task03.Server;
import ba.bitcamp.homework06.task04.Client;
import ba.bitcamp.homework06.task06.Functionable;
import ba.bitcamp.homework06.task07.ArrayManipulation;

/**
 * Extends Network class and contains methods implemented </p>from Functionable interface
 * @author USER
 *
 */
public class BusNetwork extends Network implements Functionable{

	static int counter;
	
	/**
	 * Constructs network name inherited from Network class
	 * @param networkName
	 */
	public BusNetwork(String networkName) {
		super(networkName);
	}

	/**
	 * Checks network functionality
	 */
	@Override
	public boolean isFunctioning() {
		int counter = 0;
		
		for(int i = 0; i < getComputerArray().length; i++){
			if(getComputerArray()[i] != null){
				counter ++;
			}
		}
		if(counter > 1){
			return true;
		}else
			return false;
	}

	@Override
	public void addComputer(Computer c) {
		
		Computer[] c1 = ArrayManipulation.extendArray(getComputerArray());
		//add new computer value to the new extended array
		c1[c1.length-1] = c;
		setComputerArray(c1);
		if(c instanceof Server){
			throw new IllegalArgumentException("Can not add server computer");
		}else if(c instanceof Client){
			Client computer = (Client) c;
			computer.connect(this);
		}
	}

	@Override
	public void removeComputer(Computer c) {
		if(c instanceof Server){
			throw new IllegalArgumentException("Server can not be removed!");
		}else if(c instanceof Client){
			((Client) c).disconnect(); // computer has to be disconnected before removing
			
			for(int i = 0; i < getComputerArray().length; i++){
				if(c.equals(getComputerArray()[i])){
				
					ArrayManipulation.shrinkArray(getComputerArray(), i);
					counter--;
					return;
				}
			}
			throw new IllegalArgumentException("Computer not found.");
		}
	}

	@Override
	public String toString() {
		return "Number of computers on network: " + getComputerArray().length
				+ "\nNetwork functioning: " + isFunctioning();
	}
	
	 

}
