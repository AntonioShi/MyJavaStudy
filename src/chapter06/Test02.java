package chapter06;

import java.text.DateFormat;
import java.util.Calendar;

public class Test02 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();											//哦,这个就是单例设计模式的一种,Calendar的对象自能有一个
		calendar.add(Calendar.DATE, 100);																//加个一百天
		DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);//设置格式的函数
		String string = format.format(calendar.getTime());							
		System.out.println(string);
	}

}
