package app.store.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeHelper {

	
	public static Date getDateTimeFrom(int y, int m, int d, int h, int mm, int s)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(y,m,d,h,mm,s);
		return cal.getTime();
	}
	

	public static Date getDateTimeFrom(int y, int m, int d){
		return getDateTimeFrom(y,m,d,0,0,0);
	}
	
	
	public static Date getDateTimeFrom(String dateTime)
	{
		try {
			String[] dateTimeStrings = dateTime.split(" ");
			int year,month,day;
			int hour = 0,minute = 0,second = 0;
			
			String datePartString = dateTimeStrings[0];						
			String[] dateParts = datePartString.split("-");
			year = Integer.parseInt(dateParts[0]);
			month = Integer.parseInt(dateParts[1]);
			day = Integer.parseInt(dateParts[2]);
			
			if (dateTimeStrings.length == 2) {
				String timePartString = dateTimeStrings[1];
				String[] timeParts = timePartString.split(":");
				hour = Integer.parseInt(timeParts[0]);
				minute = Integer.parseInt(timeParts[1]);
				second = Integer.parseInt(timeParts[2]);
			}
			
			return getDateTimeFrom(year,month,day,hour,minute,second);
		}
		catch (Exception ex){
			ex.printStackTrace();
			throw new IllegalArgumentException("日期转换错误");
		}
		
		
	}
}
