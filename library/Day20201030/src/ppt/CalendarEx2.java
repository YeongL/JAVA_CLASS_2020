package ppt;

import java.util.Calendar;

public class CalendarEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] DAY_OF_WEEK = {"","��","��","ȭ","��","��","��","��","��"};
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2015, 7, 15);
		
		long difference = (date2.getTimeInMillis()-date1.getTimeInMillis())/1000;
		System.out.println(difference);
		System.out.println(toString(date1));
		System.out.println(toString(date2));
		
	}
	
	
	public static String toString(Calendar date)
	{
		return date.get(Calendar.YEAR)+"��"+date.get(Calendar.MONTH)+1+"��"+date.get(Calendar.DATE)+"��";
	}

}