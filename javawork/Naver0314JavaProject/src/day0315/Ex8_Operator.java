package day0315;

import java.util.Scanner;

public class Ex8_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두개의 숫자를 입력받은 후 산술 연산하기(+, -, *, /, %)
		
		Scanner sc = new Scanner(System.in);
		int A, B;
		
		A = Integer.parseInt(sc.nextLine());
		//B = Integer.parseInt(sc.nextLine());
		//A = sc.nextInt();
		B = sc.nextInt();
		
		
		//실수형태로 나오기 하려면?
		//수 중 하나만 실수 형태이면 됨
		//계산 결과를 실수로 형변환하는건 의미 없음
		System.out.println("더하기 " + (A + B));
		System.out.println("빼기 " + (A - B));
		System.out.println("곱하기 " + (A * B));
		System.out.println("나누기 " + ((double)A / B));
		System.out.println("나머지 " + (A % B));
		
		sc.close();
		}

}
