package day0318;

import java.util.Scanner;

public class Ex5_Switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year, month, days;
		boolean flag;
		
		//년도 입력
		System.out.println("년도를 입력하세요");
		year= sc.nextInt();
		if(year%4 == 0 && year % 100 != 0 || year % 400 == 0)//윤년공식
		{
			flag = true;
			System.out.println(year + "년은 윤년입니다.");
		}
		else
		{
			flag = false;
			System.out.println(year + "년은 평년입니다.");
		}		
		
		//월 입력
		System.out.println("월을 입력하세요.");
		month = sc.nextInt();
		//1보다 작거나 12보다 크면 "잘못 입력했어요!"출력 후 메인함수 종료(return)
		if(month < 1 || month > 12)
		{
			System.out.println("잘 못 입력했어요!");
			sc.close();
			return;
		}
		
		//1.switch 문으로 해보기
//		switch(month)
//		{
//		case 2:
//			//days = flag == true ? 29 : 28;
//			days = flag ? 29 : 28;//같은 명령문
//			break;
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			days = 30;
//			break;
//		default:
//			days = 31;
//		}
//		System.out.println(year+"년 "+month + "월은 "+days + "일까지 있습니다.");
		
		//2. if-else문으로 해보기
		if(month == 2)
		{
			days = flag ? 29 : 28;
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			days = 30;
		}
		else
		{
			days = 31;
		}
		System.out.println(year+"년 "+month + "월은 "+days + "일까지 있습니다.");
		
		
		sc.close();
	}

}
