package day0318;

import java.util.Scanner;

public class Ex11_For {
	public static void main(String[] args) {
		System.out.println("1~100까지 합계구하기");
		int sum = 0;
		
		for(int i = 1; i <= 100; i++)
		{
			sum += i;
		}
		System.out.println(sum);
		Scanner sc = new Scanner(System.in);
		int x, y;
		x = sc.nextInt();
		y = sc.nextInt();
		
		sum = 0;
		for(int i = x; i <= y; i++)
		{
			sum += i;
		}
		System.out.println(sum);
		
		sc.close();
	}

}
