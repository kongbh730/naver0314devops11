package day0315;

import java.util.Scanner;

public class Ex5_Scanner 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Scanner 선언
		Scanner sc = new Scanner(System.in);//키보드로부터 입력을 받는 인스턴스 변수//클래스는 왠만하면 대문자로 시작하는게 약속
		String msg = "";
		
		System.out.println("메세지를 입력하세요");
		msg = sc.nextLine();//next = 한 단어만 읽기 //  nextLine = 한 줄을 읽기
		System.out.println("입력한 문자열은 "+ msg+"입니다.");
		System.out.println("입력한 문자열은 \""+ msg+"\"입니다.");//"출력방법 : \"
		System.out.println("입력한 문자열은 \'"+ msg+"\'입니다.");//'출력방법 : \'
		//System.out.println("메세지를 입력하세요");
		//msg = sc.next();//next = 한 단어만 읽기 //  nextLine = 한 단어만 읽기
		//System.out.println("입력한 문자열은 "+ msg+"입니다.");
		
		int age;
		System.out.println("당신의 나이는?");
		//age = sc.nextInt();
		age = Integer.parseInt(sc.nextLine());//나이를 문자열로 읽은 후 정수타입으로 변환
		System.out.println("내 나이는 " + age + "세입니다");
		
		
		
		
		
		

		
		sc.close();
	}

}
