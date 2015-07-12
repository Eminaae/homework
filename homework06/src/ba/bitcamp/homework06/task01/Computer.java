package ba.bitcamp.homework06.task01;

import java.util.Arrays;

/**
 * Describes computer with name and MAC address.
 * 
 * @author emina
 *
 */
public abstract class Computer {
	private String name;
	private MACAddress macAddress;

	/**
	 * Constructor, generates computer name and MAC address.
	 * 
	 * @param name - Computer name
	 * @param macAddress - MAC address
	 */
	public Computer(String name, char[] macAddress) {
		super();
		this.name = name;
		this.macAddress = new MACAddress(macAddress);
	}

	/**
	 * Constructor constructs default computer name and sets MAC address to
	 * null.
	 */
	public Computer() {
		this.name = "Default PC";
	}

	/**
	 * Gets computer name.
	 * 
	 * @return computer name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets MAC address
	 * 
	 * @return - MAC address
	 */
	public MACAddress getMacAddress() {
		return macAddress;
	}

	
	/**
	 * Inner non static class MACAddress. Defines computer's MAC address.
	 * 
	 * @author USER
	 *
	 */
	public class MACAddress {
		// mac address contains char array without ':' 
		private char[] macAddress = new char[12];

		public MACAddress(char[] macAddress) {
			super();
			this.macAddress = macAddress;

		}

		//12:34:56:78:90:cb
		@Override
		public String toString() {
			String s = "";
			int counter = 2;
			for (int i = 0; i < macAddress.length; i++) {
				if (i == counter) {
					s += ":";
					counter += 2;
				}
				s += macAddress[i];
			}
			return s;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + Arrays.hashCode(macAddress);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MACAddress other = (MACAddress) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!Arrays.equals(macAddress, other.macAddress))
				return false;
			return true;
		}

		private Computer getOuterType() {
			return Computer.this;
		}

	}

}
