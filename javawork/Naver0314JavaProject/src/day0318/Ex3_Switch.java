package day0318;

import java.util.Scanner;

public class Ex3_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = 0;//지역변수는 초기화 하고 시작이 좋음
		
		System.out.println("숫자 1~3을 눌러 보세요.");
		num = sc.nextInt();
		System.out.println(num + "을 눌렀어요.");
		
		//break가 없는 경우
//		switch (num) 
//		{
//		case 1: 
//		{	
//			System.out.println("one!");
//		}
//		case 2: 
//		{	
//			System.out.println("two!");
//		}
//		case 3: 
//		{	
//			System.out.println("three!");
//		}
//		default:
//			System.out.println("other number!");
//		}
		
		//break를 넣은 경우
		switch (num) 
		{
		case 1: 
		{	
			System.out.println("one!");
			break;
		}
		case 2: 
		{	
			System.out.println("two!");
			break;
		}
		case 3: 
		{	
			System.out.println("three!");
			break;
		}
		default:
			System.out.println("other number!");
		}
		
		
		sc.close();
	}

}
