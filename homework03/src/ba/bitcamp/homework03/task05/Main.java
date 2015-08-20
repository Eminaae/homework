package ba.bitcamp.homework03.task05;

public class Main {

	public static void main(String[] args) {

		Date d = new Date(31, 12, 2000);
		System.out.println(d.toString());
		d.dayPassed();
		System.out.println(d.toString());
		d.monthPassed();
		System.out.println(d.toString());
		try {
			d.setDay(-1);
		} catch (Exception e) {
			System.out.println("Wrong input!");
		}
	}

}
