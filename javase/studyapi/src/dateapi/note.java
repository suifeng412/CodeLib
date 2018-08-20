package dateapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/*
 * JDK1.1前Date类完成日期表示、转换、设定修改三个功能、后来拆分为三个类
 * 
 * Date 负责时间的表示
 * Calendar 是一个工具类，负责对Date类进行修改等操作
 * DateFormat 负责日期的转换（读特性格式的时间字符串装维Date对象、或将对象转换为字符串）
 * 
 * Date
 * Date() 
 * Date(long date)
 * before，after，compareTo
 * getMillisOf()
 * 
 * Calendar 
 * 该类本身不存储对象，在内部有一个变量记录一个毫秒数，他不是操作外部date对象，而是操作自己内部毫秒数
 * Calendar本身是一个抽象类，不能直接实例化，它提供一个工厂方法getInstance()方法来创建一个实例
 * 1.setTime()  设定一个Calendar内部的毫秒数
 * 2.set()  设置时间
 * 3.get()  获取时间
 * 国际化与时区问题：
 * TimeZone.getAvailableIDs() 获取所有时区id
 * TimeZone.getDefault() 查看默认时区
 * 
 * 
 * DateFormat类
 * 本身是一个抽象类，一般都是使用它的子类SimpleDateFormat
 * parse() 字符串转换为对象
 * format() 对象转换为字符串
 * 设置style和locale参数
 * style就是长度、locale为格式化时间的地区
 * DateFormat format = DateFormat.getDateInstance(DateFormat.LONG, Locale.SIMPLIFIED_CHINESE);
 * format.format(new Date()))
 * 
 * SimpleDateFormat
 * 常用的时间格式化类，可以自由搭配
 * 
 * 当使用parse时，只有你的字符串和SimpleDateFormat的pattern完全匹配才能识别，否则报错。
 * 
 * */
public class note {
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
