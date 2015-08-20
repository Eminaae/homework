package ba.bitcamp.homework03.task02;

public class Main {

	public static void main(String[] args) {
	
			Author a = new Author();
			Author a1 = new Author();
			a.setName("Leslie Kaminoff");
			a.setEmail("l.kaminoff@yoga.de");
			a.setGender('M');
			System.out.println(a);
			a1.setName("");
			a1.setEmail("");
			a1.setGender('K');
			System.out.println(a1);
			System.out.println(a.equals(a1));
	}

}
