package ba.bitcamp.homework06.task05;

import ba.bitcamp.homework06.task01.Computer;
import ba.bitcamp.homework06.task03.Server;
import ba.bitcamp.homework06.task04.Client;

public class Main {

	public static void main(String[] args) {
		
				char[] mac1 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b' };
				char[] mac2 = new char[] { '0', '3', '2', '3', '4', '5', '6', '7', '8', '9', 'c', 'd' };
				char[] mac3 = new char[] { '0', '3', '2', '3', '4', '5', '6', '7', '8', '9', 'e', 'f' };
				
				// Creating client
				Client c1 = new Client("Computer01", mac1);
				Client c2 = new Client("Computer02", mac2);
				Client c3 = new Client("Computer02", mac3);
				
				// Getting mac address from c1 and c2
				System.out.println(c1.getMacAddress());
				System.out.println(c2.getMacAddress());
				System.out.println(c3.getMacAddress());

				Computer[] arrComp = new Computer[3];
				Server s1 = new Server("Computer", mac1, 2);
				arrComp[0] = c1;
				arrComp[1] = c2;
				arrComp[2] = c3;
				// Connecting client to server
				c1.connect(s1);
				// Disconnecting client from server
				c1.disconnect();
				c1.connect(s1);
				// Printing client status
				System.out.println(c1);


	}

}
