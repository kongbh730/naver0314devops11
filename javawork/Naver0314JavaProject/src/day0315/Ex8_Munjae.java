package day0315;

import java.util.Scanner;

public class Ex8_Munjae {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*
		 * 이름(name), 핸드폰(hp), 태어난년도(birthYear) 입력받은후
		 * 이름, 핸드폰, 태어난년도, 나이(2024-태어난년도)를 출력하는 프로그램 작성
		 * 그런데, println 사용
		 * 선언-입력-계산-출력 
		 */
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		String hp = "";
		int birthYear, age;
		
		System.out.print("이름 입력 : ");
		//name = sc.nextLine();//nextLine()을 사용해야 한다면
		//nextLine()를 쓰기 싫다면 아래처럼
		name = sc.next();
		sc.nextLine();
		
		System.out.print("핸드폰 번호 입력 : ");
		hp = sc.nextLine();
		System.out.print("태어난 년도 입력 : ");
		birthYear = sc.nextInt();
		age = 2024 - birthYear;
		System.out.printf("이름 : %s\n", name);
		System.out.printf("핸드폰 : %s\n", hp);
		System.out.printf("태어난 년도 : %d\n", birthYear);
		System.out.printf("나이 : %d\n", age);		

		sc.close();
	}

}
