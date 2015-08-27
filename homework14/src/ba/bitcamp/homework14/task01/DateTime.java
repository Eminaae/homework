package ba.bitcamp.homework14.task01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static String dateTime(){
		DateFormat formatDateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return formatDateTime.format(date);
	}
}
