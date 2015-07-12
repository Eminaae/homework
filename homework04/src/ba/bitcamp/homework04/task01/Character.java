package ba.bitcamp.homework04.task01;
/**
 * Describes one character in story, named Simba. 
 * @author USER
 *
 */
public class Character extends StoryElement{
	String gender;
	static Boolean isAlive = true;
	Boolean isCapable;
	
	/**
	 * Constructor 
	 * @param name
	 */
	public Character(String name, String gender, Boolean isAlive, Boolean isCapable) {
		super(name);	
		this.gender = gender;
		Character.isAlive = true;
		this.isCapable = isCapable; 
	
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the isAlive
	 */
	public Boolean getIsAlive() {
		return isAlive;
	}
	/**
	 * @param isAlive the isAlive to set
	 */
	public void setIsAlive(Boolean isAlive) {
		Character.isAlive = isAlive;
	}
	/**
	 * @return the isCapable
	 */
	public Boolean getIsCapable() {
		return isCapable;
	}
	/**
	 * @param isCapable the isCapable to set
	 */
	public void setIsCapable(Boolean isCapable) {
		this.isCapable = isCapable;
	}
	
	public void killCharacter(){
		if(isAlive == true){
			isAlive = false;
			isCapable = false;
			
		}
	}
	
	/**
	 * Transmutes character from incapable to capable
	 */
	
	public void transmuteCharacter(){
		if(isAlive == true && isCapable == true){
			isCapable = false;
		}
	}
	
	public String toString(){
		String s = "";
		s += "Name: " + getName() + "\nGender: " + gender + "\nCapable: " + isCapable + "\nAlive: " + isAlive;
		return s;
	}
	
}
