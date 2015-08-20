package ba.bitcamp.homework03.task03;

import ba.bitcamp.homework03.task02.Author;
import ba.bitcamp.homework03.task04.Library;

public class Main {

	public static void main(String[] args) {

		Book b1 = new Book("George R. R. Martin", "g.r@mail.com", 'M', "Game of Thrones", 45.2, 2);
		Book b2 = new Book("George R. R. Martin", "g.r@mail.com", 'M', "A Song of Ice and Fire", 34.50, 1);
		Book b3 = new Book("Donald Koosis", "d.k@mail.com", 'M', "Java Programming For Dummies", 59.29, 2);
		Book b4 = new Book("Malik", "malik@mail.com",'M',"Java™ Programming: From Problem Analysis to Program Design, 5th Edition", 140.49, 0);
		Book b5 = new Book("Bruce Eckel", "be@mail.com", 'M', "Misliti na javi", 60.0, 1);
		Book [] books = {b1, b2, b3, b4, b5};
		
		Library l = new Library("Library 1", books);
		System.out.println(l.toString());
		l.setBooks(b4);
		l.getBooks("Book 4");
		System.out.println(l.toString());
		
		System.out.println(l.getBooksByAutor("Autor 3"));
		System.out.println(l.getBooks());
	}

}
