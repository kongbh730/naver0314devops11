package day0318;

import java.util.Scanner;

public class Ex7_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름(name), 기본급(gibon), 가족수(familysu)를 키보드로 입력후
		 * 가족수가 3인 이상이면, 기본급 + (가족수*50000)으로 실수령액(totpay) 구하고
		 * 가족수가 3인 미만이면, 기본급 + 30000원으로 실수령액을 구하고
		 * 출력은 
		 * 이름 : 
		 * 기본급 : 
		 * 가족수 : 
		 * 실수령액 : 
		 */
		Scanner sc = new Scanner(System.in);
		String name;
		int gibon, familysu, totpay;
		
		System.out.println("이름을 입력하시오.");
		name = sc.nextLine();
		System.out.println("기본급을 입력하시오.");
		gibon = sc.nextInt();
		System.out.println("가족수를 입력하시오.");
		familysu = sc.nextInt();
		if(familysu >= 3)
		{
			totpay = gibon + 50000 * familysu;
		}
		else
		{
			totpay = gibon + 30000;
		}
		//동일한 삼항연산자
		//totpay = familysu >= 3 ? gibon + 50000 * familysu : gibon + 30000;
		System.out.printf("이름 : %s\n기본급 : %d\n가족수 : %d\n실수령액 : %d\n", name, gibon, familysu, totpay);

		sc.close();
	}

}
//switch-case는 조건 범위를 지정할 수 없다...
