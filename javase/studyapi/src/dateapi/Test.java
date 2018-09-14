package dateapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Test {
	public static void main(String args[]) {
		Date d = new Date();
		System.out.println(d);
//		System.out.println(d.getMinutes()); 废除

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.get(Calendar.YEAR);
		System.out.println("year:" + calendar.get(Calendar.YEAR));
		System.out.println("month:" + (calendar.get(Calendar.MONTH) + 1));
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH, 22);
		System.out.println("setTIme:" + calendar.getTime());

		// 查看默认时区
		Locale locale = Locale.getDefault();
		locale.getCountry();
		locale.getLanguage();
		System.out.println("default locale is " + locale);
		System.out.println("default country is " + locale.getCountry());
		System.out.println("default language is " + locale.getLanguage());
		// 查看默认时区
		TimeZone timeZone = TimeZone.getDefault();
		System.out.println("default time zone is " + timeZone.getDisplayName());

		// 时间格式化
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, Locale.SIMPLIFIED_CHINESE);
		DateFormat format2 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
		DateFormat format3 = DateFormat.getDateInstance(DateFormat.LONG, Locale.SIMPLIFIED_CHINESE);
		DateFormat format4 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
		DateFormat format5 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH);
		DateFormat format6 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
		try {
			System.out.println("format : " + format.format(new Date()));
			System.out.println("format2 : " + format2.format(new Date()));
			System.out.println("format3 : " + format3.format(new Date()));
			System.out.println("format4 : " + format4.format(new Date()));
			System.out.println("format5 : " + format5.format(new Date()));
			System.out.println("format6 : " + format6.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// SimpleDateFormat
		String dateString = "2013-02-12T12:22:33";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		System.out.println("simpleDate format " + simpleDateFormat.format(new Date()));
		try {
		    System.out.println("simpleDate parse "+ simpleDateFormat.parse(dateString));
		} catch (ParseException e) {
		    e.printStackTrace();
		}


	}
}
