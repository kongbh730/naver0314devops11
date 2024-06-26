package day0320;

import java.util.Random;
import java.util.Scanner;

public class Ex3_RandomGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. 1~100사이에 난수를 발생한 수 숫자 알아맞추기
		 * 2. 숫자 입력시 앞에 횟수 출력
		 * 3. 숫자 n이 난수보다 크면 (n보다 작습니다)
		 * 4. 드디어 숫자를 맞췄을 경우 (횟수와 정답을 출력 후)
		 * 5. 계속 숫자 맞추기 게임을 하시겠습니까?(y/n) 
		 * 6. y누르면 다시 난수 발생 후 숫자 맞추기 시작
		 * 7. y가 아니면 게임 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int count = 0, randomInt;
		int su;
		Exit:
			while(true)
			{
				//횟수 초기화
				count = 0;
				//난수 생성
				randomInt = r.nextInt(100) + 1;//1부터 100까지
				System.out.println("테스트용으로 보이는 난수 : " + randomInt);
				while(true)
				{
					System.out.print(++count + "회 : ");
					su = Integer.parseInt(sc.nextLine());
					if(su > randomInt)
					{
						System.out.println("\t" + su + "보다 작습니다.");
					}
					else if(su < randomInt)
					{
						System.out.println("\t" + su + "보다 큽니다.");
					}
					else
					{
						System.out.printf("정답(%d)입니다.\n", randomInt);
						System.out.println("계속하려면 y/그만하려면 n을 눌러주세요");
						String ans = sc.nextLine();
						if(ans.equalsIgnoreCase("y"))
						{
							System.out.println("** 새로운 게임을 시작합니다. **");
							break;
						}
						else
						{
							break Exit;//바깥쪽 while문까지 한번에 빠져나감
						}
					}
				}
			}
		System.out.println("** 게임을 종료합니다 **");
		
		sc.close();
		
	}

}
