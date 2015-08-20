package ba.bitcamp.homework03.task03;

import ba.bitcamp.homework03.task02.Author;

public class Book extends Author {
	private String title;
	private double price;
	private int inStack;
	
	
	
	public Book(String name, String email, char gender, String title, double price, int inStack){
	super(name, email, gender);
	this.title = title;
	this.price = price;
	this.inStack = inStack;
}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the inStack
	 */
	public int getInStack() {
		return inStack;
	}

	/**
	 * @param inStack the inStack to set
	 */
	public void setInStack(int inStack) {
		this.inStack += inStack;
	}


	public String toString() {
		String s= "";
		s = super.toString();
		s += "Name of the book: " + title + "\n" 
				+ "Price: " + price + "\n"
				+ "In stack: " + inStack + "\n";
		return s;
	}
}