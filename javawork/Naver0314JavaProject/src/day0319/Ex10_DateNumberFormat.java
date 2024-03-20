package day0319;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_DateNumberFormat {
	public static void main(String[] args) {
		//현재 날짜를 문자열로 출력하기
		Date date = new Date();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");//EEE는 화, EEEE는 화요일
		System.out.println(sdf1.format(date));
		

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss EEEE");
		System.out.println(sdf2.format(date));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		System.out.println(sdf3.format(date));
		
		
		
		//숫자 포맷양식 지정하기
		int money = 5678900;
		double average = 98.7256;
		
		NumberFormat nf1 = NumberFormat.getCurrencyInstance();// 화폐단위 + 3자리 마다 ','가 주가됨
		System.out.println(nf1.format(money));
		
		//따로 생성없이 바로 method 호출 가능
		System.out.println(NumberFormat.getInstance().format(money));
		System.out.println(NumberFormat.getCurrencyInstance().format(money));
	
		NumberFormat nf2 = NumberFormat.getInstance();
		nf2.setMaximumFractionDigits(1);
		System.out.println(nf2.format(average));
		
	
	}

}
