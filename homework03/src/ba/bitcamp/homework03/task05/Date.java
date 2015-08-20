package ba.bitcamp.homework03.task05;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day){
		super();
		this.day = day;
		this.month = 1;
		this.year = 1;
	}
	
	public Date(int day, int month){
		super();
		this.day = day;
		this.month = month;
		this.year = 1;
		
	}
	
	public Date ( int day, int month, int year){
		super();
		this.day = day;
		this.month = month;
		this.year=year;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) throws Exception {
		if(day <= 0 || day > 31){
			throw new Exception();
		} else {
			this.day = day;
		}
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) throws Exception{
		if(month <= 0 || month > 12){
			throw new Exception ();
		} else {
			this.month = month;
		}
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	public void monthPassed(){
		if(this.month == 12){
			this.month = 1;
			this.year += 1;
		} else {
			this.month += 1;
		}
	}
	
	public void dayPassed(){
		if(this.day == 30){
			switch(this.month){
			case 4:
			case 6:
			case 9:
			case 11:
				this.month += 1;
				this.day = 1;
				break;
			default:
					this.day += 1;
					break;
			}
		}else if(this.day == 31){
			switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				this.month += 1;
				this.day = 1 ;
				break;
			case 12:
				this.month = 1;
				this.year += 1;
				this.day = 1;
				break;
				default:
					this.day += 1;
					break;
			}
		} else if(this.day == 28 && this.month == 2){
			this.month += 1;
			this.day = 1;
		} else {
			this.day += 1;
		}
	}
	
	public String toString(){
		String s = "";
		if (day < 10){
			s += "0" + Integer.toString(day) + ".";
		} else {
			s += Integer.toString(day) + ".";
		}if (month < 10){
			s += "0" + Integer.toString(month) + ".";	
		} else {
			s += Integer.toString(month) + ".";
		}s += Integer.toString(year)+ "." + "\n";
		return s;
	}
}
