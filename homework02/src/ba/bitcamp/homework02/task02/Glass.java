package ba.bitcamp.homework02.task02;

/**
 * Describes glass.
 * 
 * @author USER
 *
 */
public class Glass {
	private String typeOfLiquid;
	private int amountOfLiquid;
	private int maxAmountOfLiquid;

	/**
	 * Default constructor, initialized amount of liquid to zero.
	 * 
	 * @param maxAmountOfLiquid
	 */
	public Glass(int maxAmountOfLiquid) {
		typeOfLiquid = null;
		amountOfLiquid = 0;
		this.maxAmountOfLiquid = maxAmountOfLiquid;

	}

	/**
	 * Returns type of liquid in a glass.
	 * 
	 * @return typeOfLiquid
	 */
	public String getTypeOfLiquid() {
		return typeOfLiquid;
	}

	/**
	 * Sets given parameter as a type of liquid.
	 * 
	 * @param typeOfLiquid
	 */
	public void setTypeOfLiquid(String typeOfLiquid) {
		this.typeOfLiquid = typeOfLiquid;
	}

	/**
	 * Returns maximal amount of liquid in a glass.
	 * 
	 * @return maxAmountOfLiquid
	 */
	public int getMaxCapacity() {
		return maxAmountOfLiquid;
	}

	/**
	 * Sets given parameter as maximum amount of liquid in a glass
	 * 
	 * @param maxAmountOfLiquid
	 */
	public void setMaxCapacity(int maxAmountOfLiquid) {
		this.maxAmountOfLiquid = maxAmountOfLiquid;
	}

	/**
	 * Returns current capacity of glass.
	 * @return amountOfLiquid
	 */
	public int getCurrentCapacity() {
		return amountOfLiquid;
	}

	/**
	 * Sets given parameter as current liquid amount in a glass
	 * @param amountOfLiquid
	 */
	public void setCurrentCapacity(int amountOfLiquid) {
		this.amountOfLiquid = amountOfLiquid;
	}

	public void addLiquid(String liquidType, int otherLiquid) {
		if (typeOfLiquid.equals(liquidType)) {
			if (amountOfLiquid + otherLiquid <= maxAmountOfLiquid) {
				amountOfLiquid += otherLiquid;
			} else {
				amountOfLiquid = maxAmountOfLiquid;
			}
		}
	}

	public void emptyGlass() {

		amountOfLiquid = 0;
	}
}
