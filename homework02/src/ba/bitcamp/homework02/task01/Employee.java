package ba.bitcamp.homework02.task01;

public class Employee {

	private String name;
	private String gender;
	private int salary;

	/**
	 * Default Constructor
	 * 
	 * @param name
	 * @param gender
	 * @param salary - monthly salary
	 */
	public Employee(String name, String gender, int salary) {
		this.name = name;
		this.gender = gender;
		this.salary = salary;

	}

	/**
	 * Returns employee name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns employee gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Returns monthly salary.
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * Sets monthly salary.
	 * @param salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
