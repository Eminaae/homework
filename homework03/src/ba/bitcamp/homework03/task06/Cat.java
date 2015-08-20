package ba.bitcamp.homework03.task06;

/**
 * A subclass. Child of the parent class Pet.
 * 
 * @author USER
 *
 */
public class Cat extends Pet {
	/**
	 * Constructor from super class (Pet)
	 * 
	 * @param name
	 * @param age
	 * @param species
	 */
	public Cat(String name, int year) {
		super(name, year, Pet.CAT);
	}
	
	/**
	 * Returns string representing Cat.
	 */
	public String toString(){
		return super.toString();
	}

}