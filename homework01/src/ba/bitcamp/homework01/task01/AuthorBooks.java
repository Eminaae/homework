package ba.bitcamp.homework01.task01;

public class AuthorBooks {
	
	public String name;
	public Integer yearOfBirth;
	public Book[] books;

	/**
	 * Constructs an object representing an author.
	 * 
	 * @param name - Name of the author
	 * @param yearOfBirth - Year of birth
	 * @param books - Books written
	 */
	public AuthorBooks(String name, Integer yearOfBirth, Book[] books) {
		super();
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.books = books;
	}

	/**
	 * Returns a String representing authors information.
	 */
	public String toString() {
		String s = "Author: " + name + "\n";
		s += "Born: " + yearOfBirth + "\n";
		s += "*********************";
		for (int i = 0; i < books.length; i++) {
			s += "\n" + books[i] + "\n";
		}
		s += "*********************\n";
		return s;
	}
}
