package ba.bitcamp.homework03.task02;

public class Author {
	public String name;
	public String email;
	public char gender; // The author's gender 'M' is male, 'F' is female

	
	/**
	 * @param name
	 * @param email
	 * @param gender
	 */
	public Author(String name, String email, char gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	/**
	 * Default constructor.
	 */
	public Author() {
		this.setName("Unknown");
		this.setEmail("Unknown");
		this.setGender('U');
	}
	
	/**
	 * Returns author's name.
	 * @return author's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets author's name to the argument name.
	 * @return author's name
	 */
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			this.name = "Unknown";
		} else {
			this.name = name;
		}
	}
	
	/**
	 * Returns author's email.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets author's email to the argument email.
	 * @return author's email
	 */
	public void setEmail(String email) {
		if (email == null || email.isEmpty()) {
			this.email = "Unknown";
		} else {
			this.email = email;
		}
	}
	
	/**
	 * Returns author's gender
	 * @return
	 */
	
	public char getGender() {
		return gender;
	}

	/**
	 * Sets author's gender to the argument gender.
	 * <p>
	 * The character F stands for female and M for male.
	 * <p>
	 * The character U designates unknown gender.
	 * 
	 * @param gender
	 */

	public void setGender(char gender) {
		if (gender != 'M' && gender != 'F') {
			this.gender = 'U';
		} else {
			this.gender = gender;
		}
	}

	/**
	 *
	 * Indicates whether some other object is "equal to" this one
	 * @return true if this object is the same as the object argument; false
	 *         otherwise.
	 */
	
	public boolean equals(Author author) {
		if (this.getName() == author.getName()
				&& this.getEmail() == author.getEmail()
				&& this.getGender() == author.getGender()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns string representing an author.
	 */
	public String toString() {
		String s = "Author: " + name + "\n";
		s += "email: " + email + "\n";
		s += "Gender: " + gender + "\n";
		return s;
	}
}
