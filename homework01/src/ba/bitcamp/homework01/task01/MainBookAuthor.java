package ba.bitcamp.homework01.task01;

public class MainBookAuthor {

	public static void main(String[] args) {

		Book b1 = new Book("Tvrdjava", 1935, "Novel", true);
		Book b2 = new Book("Dervis i Smrt", 1960, "Novel", true);
		Book b3 = new Book("Tisina", 1955, "Novel", true);
		Book b4 = new Book("Ostrvo", 1950, "Novel", true);
		Book b5 = new Book("Krug", 1961, "Novel", true);
		Book[] books1 = new Book[] { b1, b2, b3, b4, b5 };
		AuthorBooks a1 = new AuthorBooks("Mesa Selimovic", 1910, books1);
		Book b6 = new Book("Orlovi rano lete", 1950, "Short story", true);
		Book b7 = new Book("Prolom", 1966, "Short story", true);
		Book b8 = new Book("Ne tuguj, bronzana stražo", 1970, "Short story",
				true);
		Book[] books2 = new Book[] { b6, b7, b8 };
		AuthorBooks a2 = new AuthorBooks("Branko Copic", 1970, books2);
		AuthorBooks[] authors = new AuthorBooks[] { a1, a2 };

		System.out.println(countBestSellingBooks(a2));
		System.out.println(getNumberOfWrittenBooks(a1, 2012, 2015));
		System.out.println(getAuthorWithMostBestsellers(authors));

	}

	/**
	 * Returns a number of bestsellers from author
	 * 
	 * @param a
	 *            author
	 * @return counted numbers of bestsellers
	 */
	public static int countBestSellingBooks(AuthorBooks a) {
		int counter = 0;
		for (int i = 0; i < a.books.length; i++) {
			if (a.books[i].isBestseller) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Returns number of written books from two years
	 * 
	 * @param a
	 *            author
	 * @param year1
	 *            Year from
	 * @param year2
	 *            Year to
	 * @return Returns number of written books in a given period
	 */
	public static int getNumberOfWrittenBooks(AuthorBooks a, int year1,
			int year2) {
		int counter = 0;
		for (int i = 0; i < a.books.length; i++) {
			if (a.books[i].yearPublished >= year1
					&& a.books[i].yearPublished <= year2) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Returns author with the most best selling books.
	 * 
	 * @param authors
	 *            An array of authors
	 * @return Author with most bestsellers
	 * @throws NullPointerException
	 *             When null is passed as parameter
	 */
	public static AuthorBooks getAuthorWithMostBestsellers(AuthorBooks[] authors)
			throws NullPointerException {
		if (authors == null) {
			throw new NullPointerException();
		}
		AuthorBooks mostBestsellers = authors[0];
		int counter = 0;
		for (int i = 0; i < authors.length; i++) {
			if (countBestSellingBooks(authors[i]) > counter) {
				counter = countBestSellingBooks(authors[i]);
				mostBestsellers = authors[i];
			}
		}
		return mostBestsellers;
	}
}
