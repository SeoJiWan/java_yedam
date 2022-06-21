package practice.date_calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 k시 mm분 ss초");
		String format = sdf.format(date);
		System.out.println(format);
		
	}

}
