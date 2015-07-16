
/**
 * Class represents person with attributes name, last name and date of birth
 * @author USER
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private int month; // month (between 1 and 12)
	private int day; // day (between 1 and DAYS[month]
	private int year; // year
	private DateOfBirth dateOfBirthInClass;

	/**
	 * Constructor initializes a new date from the month, day, and year.
	 * 
	 * @param month - the month (between 1 and 12)
	 * @param day - the day (between 1 and 28-31, depending on the month)
	 * @param year - the year
	 */

	public Person(String firstName, String lastName, DateOfBirth dateOfBirthInClass) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirthInClass = dateOfBirthInClass;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return the month.
	 * 
	 * @return the month (an integer between 1 and 12)
	 */
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Return the day.
	 * 
	 * @return the day (an integer between 1 and 31)
	 */
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Return the year.
	 * 
	 * @return the year
	 */
	public int year() {
		return year;
	}

	/**
	 * Return a string representation of this date.
	 * 
	 * @return the string representation
	 */
	public String toString() {
		// System.out.println(dateOfBirthInClass.toString());
		String person = "First name: " + firstName + "\tLast name: " + lastName
				+ "\tDate of birth: " + dateOfBirthInClass;
		return person;
	}
}
