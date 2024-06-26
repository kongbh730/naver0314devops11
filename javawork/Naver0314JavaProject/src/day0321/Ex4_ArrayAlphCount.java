package day0321;

import java.util.Scanner;

public class Ex4_ArrayAlphCount 
{
	public static void main(String[] args) {
		/*
		 * 영어 문장을 입력하면, 알파벳 기준으로 각각의 갯수를 출력하시오
		 * "Have a nice Day!!!"
		 * 
		 * A : 3   B : 0....  Z : 0
		 */
		
		Scanner sc = new Scanner(System.in);
		String msg;
		int []alpha = new int[26];
		int i, temp;
		
		System.out.print("문자열을 입력하시오 : ");
		msg = sc.nextLine();
		System.out.println(msg);
		msg = msg.toUpperCase();
		System.out.println(msg);
		for(i = 0; i < msg.length(); i++)
		{
			//내 풀이
//			temp = msg.charAt(i) - 'A';
//			if(temp >= 0 && temp <= 26)
//			{
//				alpha[temp]++;
//			}
			
			//강사님 풀이
			char ch = msg.toUpperCase().charAt(i);
			if(ch >= 'A' && ch <= 'Z')
			//if(ch >= 65 && ch <= 90)
			{
				alpha[ch - 'A']++;
			}
		}
		
		//인덱스가 필요하니 이번에는 반복문으로 출력 
//		for(i = 0; i < alpha.length; i++)
//		{
//			System.out.printf("%c:%d  ", i + 65, alpha[i]);
//		}
//		System.out.println();
		
		for(i = 0; i < alpha.length; i++)
		{
			System.out.printf("%c:%d  ", i + 65, alpha[i]);
			if((i+1) % 5 == 0)//5개씩 출력법
			{
				System.out.println();
			}
		}
		
		sc.close();
	}
}
