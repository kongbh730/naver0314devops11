package day0327;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex3_SetLotto 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Set<Integer> setLotto = new TreeSet<>();

		while(true)
		{
			System.out.println("로또를 구입할 금액을 입력하세요.");
			int money = sc.nextInt();
			//0이면 종료
			if(money == 0)
			{
				System.out.println("\t종료합니다.");
				break;
			}
			if(money < 1000)
			{
				System.out.println("\t금액이 부족합니다.");
				//break;
				continue;
			}
			for(int i = 0; i < money/1000; i++)
			{
				//6개의 중복되지 않은 로또 숫자 구하기(1~45)
				//기존값 모두 삭제후 다시 구하기
				setLotto.clear();	
			
				while(true)
				{
					int n = (int)(Math.random() * 45) + 1;
					setLotto.add(n);
					if(setLotto.size() == 6)
					{
						break;
					}
				}
				//출력
				System.out.printf("\t%3d회 : ", i + 1);
				for(int n : setLotto)
				{
					System.out.printf("%2d ", n);
				}
				System.out.println();
			}

		}

		sc.close();
	}
}
