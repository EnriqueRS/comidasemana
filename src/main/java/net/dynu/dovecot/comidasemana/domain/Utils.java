package net.dynu.dovecot.comidasemana.domain;

import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	public static int getCurrentWeekOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

}
