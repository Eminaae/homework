package ba.bitcamp.homework03.task06;

/**
 * A subclass. Child of the parent class Pet.
 * @author USER
 *
 */
public class Dog extends Pet {
	private String breed;
	
	/**
	 * Constructs an object representing dog.
	 * @param name - Dog's name
	 * @param age - Dog's age
	 * @param species - Dog's species
	 * @param breed - Dog's breed
	 */

	public Dog(String name, int year,String breed) {
		super(name, year, Pet.DOG);
		this.breed = breed;
	}
	
	public String toString(){
		return super.toString();
	}
}
