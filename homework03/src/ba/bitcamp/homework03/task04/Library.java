package ba.bitcamp.homework03.task04;

import ba.bitcamp.homework03.task03.Book;
/**
 * Represents library
 */
public class Library {
	private String libraryName;
	private Book[] books;
	
	/**
	 * Constructor for Library.
	 * @param libraryName
	 * @param books
	 */
	public Library (String libraryName, Book[] books){
		this.libraryName = libraryName;
		this.books = books;
	}

	/**
	 * Returns library name.
	 * @return the libraryName
	 */
	public String getLibraryName() {
		return libraryName;
	}

	/**
	 * Sets library name.
	 * @param libraryName the libraryName to set
	 */
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	/**
	 * Returns string books by title
	 * @return
	 */
	public String getBooks(){
		String s = "";
		for(int i=0; i < books.length; i++ ){
			s += books[i].getTitle() + "\n";
		}
		return s;
	}
	/**
	 * @return the books
	 */
	public Book getBooks(String libraryName) {
		int temp = 0; //temporary variable
		for (int i = 0; i < this.books.length; i++){
			if (this.books[i].getTitle().equals(libraryName)){
				if (this.books[i].getInStack() == 0){
					System.out.println("This book is not in the stack");
				return null;
			}
			temp = i;
			this.books[i].setInStack(-1);
			return this.books[temp];
		}
	}
		System.out.println("Sorry. We we do not have that book in the stack at all.");
		return null;
	}

	/**
	 * Return books by author name.
	 * @param nameOfAutor
	 * @return
	 */
	public String getBooksByAutor(String nameOfAutor){
		String s = "";
		for(int i=0; i < books.length; i++ ){
			if(books[i].getName().equals(nameOfAutor)){
				s += books[i].getTitle()+"\n";
			}
		}
		return s;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(Book[] books) {
		this.books = books;
	}
	
	/**
	 * Adds book to library.
	 * @param b
	 */
	public void setBooks(Book b){
		boolean temp = false;
		for(int i = 0; i < books.length; i++){
			if(books[i].getTitle().equals(b.getTitle())){
				books[i].setInStack(i);
				temp = true;
			}
		}
		if (temp == false){
			Book [] b1 = new Book [books.length +1];
			for(int i = 0; i < books.length; i++){
				b1[i] = books [i];
			}
			b1[books.length] = b;
			this.setBooks(b1);
		}
	}
	
	public String toString() {
		String s = "";
		s = "Library name: " + libraryName + "\n";
		for(int i = 0; i < books.length; i++){
		s += books[i].toString();
		}
		return s;
	}
}
	
	

