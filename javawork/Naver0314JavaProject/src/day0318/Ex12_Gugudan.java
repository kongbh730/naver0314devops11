package day0318;

import java.util.Scanner;

public class Ex12_Gugudan {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*
		 * 구구단?11
		 * 잘못된 숫자입니다.//if
		 * 
		 * 구구단?5
		 * 
		 *   ** 5단 ** 단일for문
		 * 5 * 1 = 5
		 * 5 * 2 = 10
		 * ...
		 * 5 * 9 = 45
		 * 
		 */		
		
		Scanner sc = new Scanner(System.in);
		int x, i;
		
		System.out.print("구구단? ");
		x = sc.nextInt();
		if(x < 2 || x > 9)
		{
			System.out.println("잘못된 입력입니다.");
		}
		else
		{
			System.out.printf("** %d단 **\n\n", x);
			for(i = 1; i <= 9; i++)
			{
				System.out.printf("%d * %d = %2d\n", x, i, x*i);
			}
		}
		
		sc.close();
	}
}
