package day0319;

import java.util.Scanner;

public class Ex11_munjae 
{

	public static void main(String[] args) 
	{
		/*
		 * 문제
		 * String 타입의 문자열 msg를 입력받아
		 * 그 문자열 안에 대문자,소문자, 숫자가 몇개가 포함되어있는지 출력하시오
		 * ex)
		 * Happy day 123!!
		 * 대문자 : 2개
		 * 소문자 : 6개
		 * 숫자 : 3개
		 * 
		 * String의 charAt과 length()를 사용
		 */
		
		Scanner sc = new Scanner(System.in);
		String str;//msg
		int num_cnt = 0;
		int big_alphabet_cnt = 0;
		int small_alphabet_cnt = 0;
		int other_char = 0;
		int i, temp;
		char ch;
		String num = "0123456789";
		String bigA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallA = "abcdefghijklmnopqrstuvwxyz";
		
		System.out.print("문자열 입력 : ");
		str = sc.nextLine();
		for(i = 0; i < str.length(); i++)
		{
//			temp = str.charAt(i);//charAt의 결과는 char형 이지만 int형으로 저장하면 아스키코드값으로 저장된다.
//			if(temp >= 48 && temp <= 57)
//			{
//				num_cnt++;
//			}
//			else if(temp >= 65 && temp <= 90)
//			{
//				big_alphabet_cnt++;
//			}
//			else if(temp >= 97 && temp <= 122)
//			{
//				small_alphabet_cnt++;
//			}
//			else
//			{
//				other_char++;
//			}
			
			//조건문이 너무 많은데.... 알아보기도 힘들고...
//			ch = str.charAt(i);
//			if(ch >= '0' && ch <= '9')
//			{
//				num_cnt++;
//			}
//			else if(ch >= 'A' && ch <='Z')
//			{
//				big_alphabet_cnt++;
//			}
//			else if(ch >= 'a' && ch <= 'z')
//			{
//				small_alphabet_cnt++;
//			}
//			else
//			{
//				other_char++;
//			}
			
			ch = str.charAt(i);
			if(num.indexOf(ch) >= 0)
			{
				num_cnt++;
			}
			else if(bigA.indexOf(ch) >= 0)
			{
				big_alphabet_cnt++;
			}
			else if(smallA.indexOf(ch) >= 0)
			{
				small_alphabet_cnt++;
			}
			else
			{
				other_char++;
			}
		}
		System.out.println(str);
		System.out.printf("대문자 : %d개\n소문자 : %d개\n숫자 : %d개\n", big_alphabet_cnt, small_alphabet_cnt, num_cnt);
		System.out.printf("기타문자 : %d개\n", other_char);//대문자, 소문자, 숫자를 제외한 기호, 공백문자 등을 출력
		
		sc.close();

	}

}
