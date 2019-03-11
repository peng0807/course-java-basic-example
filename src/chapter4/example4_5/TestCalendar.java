package chapter4.example4_5;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(2000, 9, 1);
		calendar.add(Calendar.DATE, 9);
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.YEAR) + "年");
		System.out.println((calendar.get(Calendar.MONTH) + 1) + "月" );
		System.out.println(calendar.get(Calendar.DATE) + "号");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		System.out.println(format.format(calendar.getTime()));
		format = new SimpleDateFormat("yyyyy-MMM-ddd hh:mm:ss");
		format = new SimpleDateFormat("EEE, MMM d");
		System.out.println(format.format(calendar.getTime()));
	}
}
