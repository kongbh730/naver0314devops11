package day0315;

import java.util.Scanner;

public class Ex7_Scanner {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int kor, eng;
		String name;
		System.out.println("국어 점수는? : ");
		kor = Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수는? : ");
		eng = Integer.parseInt(sc.nextLine());
		System.out.println("이름은? : ");
		name = sc.nextLine();

		
		System.out.println("이름 : " + name);
		System.out.printf("국어점수 : %d, 영어점수 : %d\n", kor, eng);
		System.out.printf("총점 : %d점, 평균 : %3.1f점", kor+eng, (kor+eng)/2.0);
		//결과가 double 이어야 할 경우 수식 중 한개라도 double 타입이 있어야 한다.
		
		
		
		

	}

}
