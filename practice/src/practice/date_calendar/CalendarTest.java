package practice.date_calendar;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int date = calendar.get(Calendar.DAY_OF_MONTH);

		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(date);

		String strDay = null;
		switch (day) {
		case Calendar.MONDAY:
			strDay = "월";
			break;
		case Calendar.TUESDAY:
			strDay = "화";
			break;
		case Calendar.WEDNESDAY:
			strDay = "수";
			break;
		case Calendar.THURSDAY:
			strDay = "목";
			break;
		case Calendar.FRIDAY:
			strDay = "금";
			break;
		case Calendar.SATURDAY:
			strDay = "토";
			break;
		case Calendar.SUNDAY:
			strDay = "일";
			break;
		default:
			break;
		}
		System.out.println(strDay);
		
		int amPm = calendar.get(Calendar.AM_PM);
		String strAmPm = null;
		switch (amPm) {
		case Calendar.AM:
			strAmPm = "오전";
			break;
		case Calendar.PM:
			strAmPm = "오후";
			break;

		default:
			break;
		}
		
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		System.out.print(year + "년");
		System.out.print(month + "월");
		System.out.print(date + "일");
		System.out.print(strAmPm);
		System.out.print(hour + "시");
		System.out.print(minute + "분");
		System.out.print(second + "초");

	}

}
