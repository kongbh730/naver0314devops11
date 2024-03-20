package day0319;

import java.util.Scanner;

public class Ex7_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * while문을 이용하여 score 점수를 입력 받은 후 
		 * 0을 입력하면 while문을 빠져나가서 총 갯수를 구하시오
		 * (단, 1~100이 아닌 값은 갯수와 합계에서 제외
		 */
		Scanner sc = new Scanner(System.in);
		int score, count = 0, sum = 0;
		
		while(true)
		{
			System.out.print("점수는? ");
			score = sc.nextInt();
			if(score == 0)
			{
				break;
			}	
			if(score >= 1 && score <= 100)
			{
				count++;
				sum += score;
			}
			else
			{
				continue;
			}
		}
		System.out.println("\n입력한 점수 갯수 : " + count);
		System.out.println("총 합계 : " + sum);
		
		sc.close();
	}

}
