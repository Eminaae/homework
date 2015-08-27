package ba.bitcamp.homework14.task01;

/**
 * Complaint class represents user complaint that contains id, text message and time and date when complaint was sent. 
 * @author USER
 *
 */
public class Complaint {
	
	private int id;
	private String complaint;
	private String dateTime;

	

	
	/**
	 * Complaint class constructor used to create object when complaint is
	 * read from database.
	 * 
	 * @param id Integer value, primary key
	 * @param complaint user complaint message
	 * @param date - the date when complaint was sent
	 */
	public Complaint(int id, String complaint, String dateTime) {
		this.id = id;
		this.complaint = complaint;
		this.dateTime = dateTime;
	}

	public Complaint() {
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the complaint
	 */
	public String getComplaint() {
		return complaint;
	}

	/**
	 * @param complaint the complaint to set
	 */
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Complaint ID: " + id + ", complaint: " + complaint
				+ ", Date and Time: " + dateTime ;
	}
}
