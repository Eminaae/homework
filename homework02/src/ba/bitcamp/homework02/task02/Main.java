package ba.bitcamp.homework02.task02;

public class Main {

	public static void main(String[] args) {

		Temperature t = new Temperature(0);
		System.out.println(t.getTemperatureInC());
		System.out.println(t.getTemperatureInK());
		System.out.println(t.getTemperatureInF());

		Glass g = new Glass(30);
		g.setTypeOfLiquid("Ice Coffee");
		g.addLiquid("Ice Coffee", 10);
		System.out.println(g.getCurrentCapacity());

		/* New printer declaration */

		Printer p1 = new Printer();
		System.out.println(p1);
		p1.setMaxInk();
		p1.print(7);

		System.out.println(p1.getNumOfPrintedPages());
	}
}
