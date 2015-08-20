package ba.bitcamp.homework03.task01;

public class CampStringBuilder {
	private char[] chars; 
	
	public CampStringBuilder(char[] characters) {
		super();
		this.chars = characters;
	}

	/**
	 * Appends the string representation of the Object argument.
	 * The overall effect is exactly as if the argument were converted to a string by the method String.valueOf(Object),
	 * and the characters of that string were then appended to this character sequence.
	 * @param o - an Object
	 */
	public void append(Object o){
		System.out.println(this.toString()+o.toString());
	}
	
	public void prepend(Object o){
		System.out.println(o.toString()+this.toString());
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < chars.length; i++){
			s += chars[i] + ","  ;
		}
		return s;
	}
	
}
