package day0315;

import java.util.Scanner;

public class Ex9_munjae {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money;
		//백만단위의 금액 입력받고
		//만원 천원 백원 십원 일원 단위로 몇개인지 출력
		//그리디 알고리즘
		
		//money = sc.nextInt();
		money = Integer.parseInt(sc.nextLine());
		System.out.println("만원짜리 : " + money/10000);
		money = money % 10000;
		System.out.println("천원짜리 : " + money/1000);
		money = money % 1000;
		System.out.println("백원짜리 : " + money/100);
		money = money % 100;
		System.out.println("십원짜리 : " + money/10);
		money = money % 10;
		System.out.println("천원짜리 : " + money);
		
		sc.close();
	}

}
