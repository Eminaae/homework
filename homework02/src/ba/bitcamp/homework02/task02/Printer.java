package ba.bitcamp.homework02.task02;
/**
 * Describes one printer.
 * 
 * @author Emina
 *
 */
public class Printer {

	private String name;
	private int paperCount;
	private int inkCount;
	private static int printedPages;

	/**
	 * An empty constructor
	 */
	public Printer() {
		this.name = "Default Printer";
		this.paperCount = 0;
		this.inkCount = 0;
		this.printedPages = 0;
	}

	/**
	 * Constructor that initialize name to the given parameter and sets other
	 * attributes to zero.
	 * 
	 * @param name - Printer name
	 * @param paperQuantity
	 * @param inkQuantity
	 * @param printedPages
	 */
	public Printer(String name, int paperCount, int inkCount, int pagesPrinted) {
		this.name = name;
		this.paperCount = 0;
		this.inkCount = 0;
		this.printedPages = 0;
	}

	/**
	 * Returns printers name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets printers name to the given parameter.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns true or false if there is ink in printer cartridge.
	 */
	public boolean hasInk() {
		if (this.inkCount != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true or false if there is paper in the printer
	 */
	public boolean hasPaper() {
		if (this.paperCount != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns number of paper left in the printer.
	 */
	public int getNumOfPrintedPages() {
		return printedPages;
	}

	/**
	 * Adding paper to printer.
	 * @param newPaper
	 */
	public void addPaper(int newPaper) {
		this.paperCount += newPaper;
		if (this.paperCount > 100) {
			this.paperCount = 100;
		}
	}

	/**
	 * Sets ink amount to maximum
	 */
	public void setMaxInk() {
		this.inkCount = 100;
	}

	/**
	 * Prints pages with certain conditions.
	 * @param numOfPages
	 */
	public void print(int numOfPages) {
		if (paperCount - numOfPages >= 0 && inkCount - 3 * paperCount >= 0) {
			paperCount -= numOfPages;
			inkCount = inkCount - 3 * paperCount;
			printedPages += numOfPages;
		}
	}

	/* Prints name and status about printer */
	public String toString() {
		String s = name + "\n";
		if (paperCount > 0 && inkCount > 0) {
			s += "Ready";
		} else if (paperCount > 0 && inkCount == 0) {
			s += "No ink";
		} else if (paperCount == 0 && inkCount > 0) {
			s += "No paper";
		} else if (paperCount == 0 && inkCount == 0) {
			s += "No ink nor paper";
		}
		return s;
	}
}
