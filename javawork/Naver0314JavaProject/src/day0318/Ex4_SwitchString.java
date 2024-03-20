package day0318;

import java.util.Scanner;

public class Ex4_SwitchString {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String color;
		
		System.out.println("영문으로 색상 입력하기");
		color = sc.nextLine();
		
		//switch에서 문자열도 가능(JDK8부터)
		switch (color) 
		{
		case "RED"://어차피 같은 명령문이 실행될거라면 break를 없애서 다음 문장이 실행되게 할 수 있다.
		case "Red"://어차피 같은 명령문이 실행될거라면 break를 없애서 다음 문장이 실행되게 할 수 있다.
		case "red": 
		{	
			System.out.println("빨강색!");
			break;
		}
		case "GREEN":
		case "green": 
		{	
			System.out.println("초록색!");
			break;
		}
		case "PINK" :
		case "pink" :
		{	
			System.out.println("분홍색!");
			break;
		}
		default:
			System.out.println("빨강, 초록, 분홍 이외의 색!");
		}
		
		
		
		sc.close();
	}

}
