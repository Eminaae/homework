package ba.bitcamp.homework02.task01;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee("e1", "female", 1000);
		Employee e2 = new Employee("e2", "female", 1100);
		Employee e3 = new Employee("e3", "male", 1500);
		Company c = new Company("c", e3, new Employee[] { e1, e2 });

		System.out.println(c.getNumberOfEmployees());
		
		c.increaseSalary(1123);
		System.out.println(c.getSalaries());
		System.out.println(c.getNumberOfFemales());
		System.out.println(c);
	}
}
