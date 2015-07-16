
/**
 * Models DateOfBirth with day, month and year
 * 
 * @author emina.arapcic
 *
 */
public class DateOfBirth {

	private int day;
	private int month;
	private int year;

	/**
	 * Constructor creates objects from DateOfBirth class
	 * @param day
	 * @param month
	 * @param year
	 */
	public DateOfBirth(int day, int month, int year) {
		super();
		System.out.println(day + "" + month + "" + year);
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns earlier date
	 * 
	 * @param other
	 * @return earlier
	 */
	public DateOfBirth gatEarlierDate(DateOfBirth other) {
		if (this.month < other.month) {
			return this;
		} else if (this.month > other.month) {
			return other;
		}
		if (this.day < other.day) {
			return this;
		} else {
			return other;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DateOfBirth))
			return false;
		DateOfBirth other = (DateOfBirth) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return String.format("%02d.%02d.%d.", day, month, year);
	}

}