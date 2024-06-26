package day0319;

import java.util.Calendar;
import java.util.Date;

public class Ex9_DateCalendar {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Date 클래스를 이용해서 년, 원, 일, 시, 분, 초를 얻기(jdk 1.1이후 deprecate되어
		//calendar를 권장하나 여전히 많이 사용중
		
		//util로 임포트 해야함
		Date date = new Date();
		int year = date.getYear();//1900이 빠진 값
		int month = date.getMonth();//0~11 반환
		int day = date.getDate();
		int week = date.getDay();//요일 (0 : 일, 1 : 월, .... 6 : 토)
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
		

		System.out.println("Date 를 이용하여 출력하기");
		System.out.println("현재년도 : " + (year + 1900));
		System.out.println("현재월 : " + (month + 1));
		System.out.println("현재일 : " + day);
		System.out.println("현재요일 : " + week + "(" + 
		(week == 0 ? "일" : week == 1 ? "월" :week == 2 ? "화" :week == 3 ? "수" :week == 4 ? "목" :week == 5 ? "금" : "토 ") 
		+ ")");
		System.out.printf("%d시 %d분 %d초\n", hour, minute, second);
		
		//=============================================================================================================================
		System.out.println("=".repeat(30));
		System.out.println("Calendar 를 이용하여 출력하기");
		//new로 생성이 불가능한 클래스
		Calendar cal = Calendar.getInstance();//생성자가 public이 아니라서 new로 생성불가
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH) + 1;//Date와 동일하게 0부터 11까지로 출력
		day=cal.get(Calendar.DATE);
		
		System.out.printf("%d년 %d월 %d일입니다.\n", year, month, day);
		
		
		
		
	}

}
