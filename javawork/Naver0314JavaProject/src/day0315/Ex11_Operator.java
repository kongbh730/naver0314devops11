package day0315;

import java.util.Scanner;

public class Ex11_Operator {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//삼항 조건 연산자
		//조건식 ? 참 : 거짓
		//두 수를 입력 후, 더 큰 숫자 출력
		
		Scanner sc = new Scanner(System.in);
		//한꺼번에 주석처리 : ctrl + /
//		int A, B;
//		int max;
//		
//		System.out.println("두개의 숫자 입력");
//		A = sc.nextInt();
//		B = sc.nextInt();
//		
//		max = (A > B ? A : B);//삼항조건연산자 먼저 연산후 max에 저장
//		System.out.println("max = " + max);
		
		// 세 개의 숫자 입력후 더 큰 숫자 출력
		int A, B, C, max;
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		max = (A > B) ? (A > C ? A : C) : (B > C ? B : C);
		//max = (A > B && A > C) ? A : (B > A && B > C) ? B : C;
		System.out.println("max = " + max);
		
		sc.close();
	}
}
