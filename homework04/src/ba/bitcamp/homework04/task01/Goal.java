package ba.bitcamp.homework04.task01;
/**
 * Describes the main goal.
 * @author USER
 *
 */
public class Goal extends StoryElement {
	/**
	 * Constants initialization
	 */
	public static final int EASY = 0;
	public static final int HARD = 1;
	public static final int IMPOSSIBLE = 2;
	
	private int difficulty; //attribute based on value
	private Event event;
	private Character whomOrWith;
	/**
	 * Constructor
	 * @param name
	 * @param difficulty
	 * @param event
	 * @param whomOrWith
	 */
	public Goal(String name, int difficulty, Event event, Character whomOrWith) {
		super(name);
		this.difficulty = difficulty;
		this.event = event;
		this.whomOrWith = whomOrWith;
	}
	/**
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}
	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}
	/**
	 * @return the whomOrWith
	 */
	public Character getWhomOrWith() {
		return whomOrWith;
	}
	/**
	 * @param whomOrWith the whomOrWith to set
	 */
	public void setWhomOrWith(Character whomOrWith) {
		this.whomOrWith = whomOrWith;
	}
	
	@Override
	public String toString() {
		String s = " ";
		s += "Goal difficulty =" + difficulty + ", event = " + event + ", with or whom " + whomOrWith;
		return s;
	}
}
