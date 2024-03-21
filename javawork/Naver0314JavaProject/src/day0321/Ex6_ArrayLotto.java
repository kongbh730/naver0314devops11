package day0321;

import java.util.Scanner;

public class Ex6_ArrayLotto 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		int []lotto = new int[6];
		int money;
		int i, j, k, temp;
		
		/*
		 * money를 입력하면 해당 횟수만큼 로또 구하기
		 * 로또 : 1~45까지의 중복되지 않은 숫자, 오름차순으로 정렬
		 * 
		 * 로또 금액 입력 : 800
		 * 		금액이 부족합니다!
		 * 로또 금액 입력 : 0
		 * 		종료합니다.(while)종료
		 * 
		 * 로또 금액 입력 : 3000
		 * 		1회 : 4 7 12 34 44 45
		 * 		2회 : ...
		 * 		3회 : ...
		 */
		
		while(true)
		{
			System.out.print("로또 금액 입력 : ");
			money = Integer.parseInt(sc.nextLine());
			if(money == 0)
			{
				break;
			}
			else if(money < 1000)
			{
				System.out.println("\t금액이 부족합니다.");
				continue;//일찍 끝낼 수 있으면 일찍 끝내기
			}
			//각 회차 시작
			for(i = 1; i <= money/1000; i++)
			{
				System.out.printf("\t%4d회 : ", i);
		//====================================================
				//중복없는 로또번호 6개 생성
				for(j = 0; j < lotto.length; j++)
				{
					lotto[j] = (int)(Math.random()*45) + 1;
					for(k = 0; k < j; k++)
					{
						if(lotto[j] == lotto[k])
						{
							j--;
							break;
						}
					}
				}
		//====================================================
				//로또번호 6개 오름차순 선택정렬
				for(j = 0; j < lotto.length - 1; j++)//기준값
				{
					for(k = j + 1; k < lotto.length; k++)//비교값
					{
						if(lotto[j] > lotto[k])//오름차순은 기준값이 비교값보다 커야 한다
						{
							temp = lotto[j];
							lotto[j] = lotto[k];
							lotto[k] = temp;
						}
					}
				}
		//====================================================
				//반복문으로 출력
//				for(j = 0; j < lotto.length; j++)
//				{
//					System.out.printf("%4d", lotto[j]);
//				}
				//컬렉션 출력
				for(int a : lotto)
				{
					System.out.printf("%4d", a);
				}
				System.out.println();
			}
		}
		System.out.println("\t종료합니다.");
		
		sc.close();
	}
	
}