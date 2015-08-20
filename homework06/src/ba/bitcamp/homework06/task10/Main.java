package ba.bitcamp.homework06.task10;

import ba.bitcamp.homework06.task03.Server;
import ba.bitcamp.homework06.task04.Client;
import ba.bitcamp.homework06.task08.BusNetwork;
import ba.bitcamp.homework06.task09.StarNetwork;

public class Main {

	public static void main(String[] args) {
		// Creating mac addresses
		char[] mac1 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b' };
		char[] mac2 = new char[] { '1', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'c', 'd' };
		char[] mac3 = new char[] { '2', '2', '1', '3', '4', '5', '6', '7', '8', '9', 'e', 'f' };

		// Creating client
		Client c1 = new Client("Computer1", mac1);
		Client c2 = new Client("Computer2", mac2);
		Client c3 = new Client("Computer2", mac3);
		Client c4 = new Client("Computer2", mac3);

		Server s1 = new Server("Computer", mac1, 2);

		StarNetwork sn1 = new StarNetwork("Network", s1);
		sn1.addComputer(c1);
		sn1.addComputer(c2);

		System.out.println(sn1);

		BusNetwork bn1 = new BusNetwork("Bus Network");
		bn1.addComputer(c3);
		bn1.addComputer(c4);
		
		System.out.println(bn1); 
		 
	}

}
