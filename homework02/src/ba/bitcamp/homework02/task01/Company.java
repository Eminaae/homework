package ba.bitcamp.homework02.task01;

public class Company {

	private String name;
	private Employee director;
	private Employee[] employees;

	/**
	 * Default constructor.
	 * @param name
	 * @param director
	 * @param employees
	 */
	public Company(String name, Employee director, Employee[] employees) {
		this.name = name;
		this.director = director;
		this.employees = employees;
	}

	/**
	 * Returns number of employees.
	 */
	public int getNumberOfEmployees() {
		return employees.length;
	}

	/**
	 * Returns sum of all salaries
	 * @return salaries
	 */
	public int getSalaries() {
		int salaries = 0;
		for (int i = 0; i < employees.length; i++) {
			salaries += employees[i].getSalary();
		}
		return salaries;
	}

	/**
	 * Returns number of female employees
	 * 
	 * @return counter that counts number of female employees in company
	 */
	public int getNumberOfFemales() {
		int females = 0; // counter
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getGender().equals("female")) {
				females++;
			}
		}
		return females;
	}

	/**
	 * Increases employee salaries for a given amount
	 */

	public int increaseSalary(int increaseAmount) {
		director.setSalary(director.getSalary() + increaseAmount);
		for (int i = 0; i < employees.length; i++) {
			employees[i].setSalary(employees[i].getSalary() + increaseAmount);
		}
		return increaseAmount;
	}

	/**
	 * Returns String that represents an object.
	 */
	public String toString() {
		String s = "Company: " + name + "\n";
		s += "Director: " + director.getName() + "\n";
		s += "Number of employees: " + employees.length;
		return s;
	}
}
