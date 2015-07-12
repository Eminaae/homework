package ba.bitcamp.homework04.task01;
/**
 * A heroic coming-of-age story which follows the epic adventures of 
 * a young lion cub named Simba as he struggles to accept the responsibilities
 * of adulthood and his destined role as king of the jungle. 
 * @author USER
 *
 */
public abstract class StoryElement{
	
	private String name;
	
	/**
	 * Constructor for making an object. 
	 * @param kingdom
	 * @param youngLion
	 */
	public StoryElement(String name) {
		this.name = name;
	}
	
	/**
	 * An empty constructor initialized to STElement 
	 */
	public StoryElement() {
		this.name = "STElement";	
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
