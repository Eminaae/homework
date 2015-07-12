package ba.bitcamp.homework04.task01;

/**
 * Describes the main positive character in the story.
 * 
 * @author USER
 *
 */
public class Protagonist extends Character {
	public static int NUM_OF_HELPING_CHARACTERS = 0;

	private Goal mainGoal;
	private Character[] helpingCharacters;
	private Character enemy;

	/**
	 * @param name
	 * @param gender
	 * @param isAlive
	 * @param isCapable
	 */
	public Protagonist(String name, String gender, Boolean isCapable,
			Goal mainGoal) {
		super(name, gender, isCapable, isAlive);
		this.mainGoal = mainGoal;
		this.helpingCharacters = new Character[3];
		
	}

	/**
	 * @return the mainGoal
	 */
	public Goal getMainGoal() {
		return mainGoal;
	}

	/**
	 * @param mainGoal the mainGoal to set
	 */
	public void setMainGoal(Goal mainGoal) {
		this.mainGoal = mainGoal;
	}

	/**
	 * @return the helpingCharacters
	 */
	public Character[] getHelpingCharacters() {
		return helpingCharacters;
	}

	/**
	 * @param helpingCharacters the helpingCharacters to set
	 */
	public void setHelpingCharacters(Character[] helpingCharacters) {
		this.helpingCharacters = helpingCharacters;
	}

	/**
	 * @return the enemy
	 */
	public Character getEnemy() {
		return enemy;
	}

	/**
	 * Sets the main enemy. 
	 * @param enemy-the enemy to set
	 */
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	public void addHelpingCharacter(Character helper) {
		if (NUM_OF_HELPING_CHARACTERS == helpingCharacters.length) {
			throw new IndexOutOfBoundsException(); // throws exception if we
													// have more that 3 helping
													// Characters
		} else if (NUM_OF_HELPING_CHARACTERS < helpingCharacters.length) {
			for (int i = 0; i < helpingCharacters.length; i++) {
				if (helpingCharacters[i] == null) { // check number of helping
													// characters
					helpingCharacters[i] = helper; // add Character
					break; // break after adding one object
				}
			}
			NUM_OF_HELPING_CHARACTERS++; // increase NUM_OF_HELPING_CHARACTERS
		}
	}

	public void attainGoal() {
		int success = 0;
		if (this.getIsCapable() == true) {
			success += 40; // increasing success rate by 40%
		}
		for (int i = 0; i < helpingCharacters.length; i++) {
			if (helpingCharacters[i].getIsCapable() == true) {
				success += 20;
			}
		}
		if (enemy.getIsCapable() == true) {
			success -= 30;
		}
		if (mainGoal.getDifficulty() == Goal.HARD) {
			success -= 20;
		} else if (mainGoal.getDifficulty() == Goal.IMPOSSIBLE) {
			success -= 100; // reduces success rate by 100%
		}

		if (success >= 100) {
		} else if (success <= 0) {
			success = 0;
		}

		if (success >= 50) {
			System.out.printf("Protagonist has succeed at his goal: %s",
					mainGoal, getName());
		} else if (success < 50) {
			System.out.printf("Protagonist has not succeed at his goal: %s",
					mainGoal.getName());
		}
	}

	/**
	 * Prints out helping characters and informations about them
	 * @return s - string presenting helping characters
	 */
	public String getHelpers() {
		String s = "Helping character:";
		for (int i = 0; i < helpingCharacters.length; i++) {
			s += "\n" + helpingCharacters[i] + "\n";
		}
		return s;
	}

}