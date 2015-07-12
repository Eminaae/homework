package ba.bitcamp.homework05.task01;

/**
 * Replaces the format item in a specified string with the string representation
 * of a corresponding object in a specified array.
 * 
 * @author USER
 *
 */
public class StringFormat {

	/**
	 * String format implementation
	 * 
	 * @param s - string
	 * @param o - object instance of Integer, Double
	 * @return s - formated string
	 */
	public static String format(String s, Object... o) {
		String s1 = ""; // an empty string
		int count = 0; // counter
		int index = 0;

		for (int i = 0; i < s.length(); i++) {
			// check if string has %.num d
			if (i < s.length() - 2) {
				if (s.substring(i, i + 2).equals("%.")) {
					index = s.indexOf("%.");// Returns the index within this
					// string of the first occurrence of
					// the specified
				}
				if (index >= 0 && s.substring(index + 3, index + 4).equals("b") && (o[count] instanceof Integer)) {
					String s2 = "" + s.charAt(index + 2);
					int num = Integer.parseInt(s2);
					// System.out.println("s2: " + s2); //rtrn number after "."
					// System.out.println("Num = " + num);
					s1 = "" + o[count]; // String the number of digits, counts
					// digits after "."
					// System.out.println("s1 = " + s1);

					if (num < s1.length()) {
						s = s.substring(0, i) + s1.substring(0, num) + s.substring(i + 4, s.length());
						count++;
					} else {
						int nums = num - s1.length();
						String zero = "";
						
						for (int j = 0; j < nums; j++) {
							zero += 0;
						}
						s1 = zero + s1;
						s = s.substring(0, i) + s1 + s.substring(i + 4, s.length());
						count++;
					}
				}

			} else {
				if (s.substring(s.length() - 2, s.length()).equals("%b")) {
					index = s.indexOf("%.");
				}
				if (index >= 0 && s.substring(index + 3, s.length()).equals("b") && (o[count] instanceof Integer)) {
					int num = Integer.parseInt("" + s.charAt(i + 2));
					System.out.println("Num2" + num);
					s1 = "" + o[count];
					s = s.substring(0, s.length() - 2) + s1;
					// System.out.println("I if else s1: " + s1);
					// System.out.println("I if else s = " + s);
				}
			}// System.out.println("Index " + index); //rtrn 4

			// Check if value is Integer and if string contains %b
			if (i < s.length() - 2) {
				if (s.substring(i, i + 2).equals("%b") && (o[count] instanceof Integer)) {
					s1 = "" + o[count];

					s = s.substring(0, i) + s1 + s.substring(i + 2, s.length());
					count++;
				}
			} else {
				if (s.substring(s.length() - 2, s.length()).equals("%b")
						&& (o[count] instanceof Integer)) {
					s1 = "" + o[count];
					s = s.substring(0, s.length() - 2) + s1;
				}
			}

			// Checks if value is String and if in the string contains %b
			if (i < s.length() - 2) {
				if (s.substring(i, i + 2).equals("%b") && (o[count] instanceof String)) {
					s1 = "" + o[count];

					s = s.substring(0, i) + s1 + s.substring(i + 2, s.length());
					count++;
				}
			} else {
				if (s.substring(s.length() - 2, s.length()).equals("%b") && (o[count] instanceof String)) {
					s1 = "" + o[count];
					s = s.substring(0, s.length() - 2) + s1;
				}
			}

			// check if string contains double
			if (i < s.length() - 2) {
				if (s.substring(i, i + 2).equals("%.")) {
					index = s.indexOf("%.");
				}
				if (index >= 0
						&& s.substring(index + 3, index + 4).equals("b") && ((o[count] instanceof Double) || (o[count] instanceof Integer))) {
					int num = Integer.parseInt("" + s.charAt(index + 2));
					s1 = "" + o[count];
					if (num < s1.substring(s1.indexOf("."), s1.length()).length()) {
						s = s.substring(0, i) + s1.substring(0, s1.indexOf(".") + num + 1) + s.substring(index + 4, s.length());
						count++;
					} else {
						int nums = num - s1.substring(s1.indexOf("."), s1.length()).length() + 1;
						String zero = "";
						for (int j = 0; j < nums; j++) {
							zero += 0;
						}
						s1 = s1 + zero;
						s = s.substring(0, i) + s1 + s.substring(i + 4, s.length());
						count++;
					}

				}
			} else {
				if (s.substring(s.length() - 2, s.length()).equals("%.")) {
					index = s.indexOf("%.");
				}
				if (index >= 0 && s.substring(index + 3, s.length()).equals("b") && ((o[count] instanceof Double) || (o[count] instanceof Integer))) {
					s1 = "" + o[count];
					s = s.substring(0, s.length() - 2) + s1;
				}
			}

			// Checking if the inputed value is Double and if in the string is
			// %f
			if (i < s.length() - 2) {
				if (s.substring(i, i + 2).equals("%b") && ((o[count] instanceof Double) || (o[count] instanceof Integer))) {
					s1 = "" + o[count];
					s = s.substring(0, i) + s1 + s.substring(i + 2, s.length());
					count++;
				}
			} else {
				if (s.substring(s.length() - 2, s.length()).equals("%b") && ((o[count] instanceof Double) || (o[count] instanceof Integer))) {
					s1 = "" + o[count];
					s = s.substring(0, s.length() - 2) + s1;
				}
			}
		}
		return s;
	}

	public static void main(String[] args) {

		System.out.println(format("Moj %b format", 3));
		System.out.println(format("Moj %b format", "Camp"));
		System.out.println(format("Moj %.3b string %b format %.2b", 0.1, 20, 12356.551551595151));

	}
}
