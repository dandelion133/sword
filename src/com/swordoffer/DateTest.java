package com.swordoffer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date date = new Date(2016-1900,4-1,9);
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = sdf.format(date);
		System.out.println(formatDate);
		
		DateFormat df=DateFormat.getDateInstance();  
		try {
			date=df.parse("2005-04-19");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println(date);              //输出结果为：Mon Dec 19 00:00:00 CST 2005  
		System.out.println(df.format(date));
		System.out.println("--------------------------------");
		
		
		Date dateBegin = new Date(2016-1900,4-1,9);
		Date dateEnd = new Date(2016-1900,6-1,9);
		Calendar calendarBegin = Calendar.getInstance();
		calendarBegin.setTime(dateBegin);
		System.out.println(df.format(calendarBegin.getTime()));
		Calendar calendarEnd = Calendar.getInstance(); 
		//calendarEnd.setTime(dateEnd);
		calendarEnd.set(2016, 6-1, 9);
		System.out.println(sdf.format(calendarEnd.getTime()));
		//calendarEnd.add(Calendar.DAY_OF_MONTH, 1);
		calendarEnd.getTime();
		// 得微秒级时间差  
		long val = calendarEnd.getTimeInMillis() - calendarBegin.getTimeInMillis();  
		// 换算后得到天数  
		long day = val / (1000 * 60 * 60 * 24);  
		System.out.println("相隔"+ day+"天");
		
		
		
		
		
		float value = 1.456789f;
		System.out.println("value = "+((int)(value*100))+"");
		
		
		
		
		
		
		
		
		
	}
}
