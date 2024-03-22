package day0321;

import java.util.Scanner;

public class Book199_9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		int student_num = 0;
		//int []scores = new int[student_num];//크기가 0인 배열을 만드는것보다
		int []scores = null;//null로 초기화하는게 나을 듯 
		int i;
		int max = 0, sum = 0;
		double avg = 0;

		Exit://강사님 추가
			while(true)
			{
				System.out.println("-".repeat(50));
				System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
				System.out.println("-".repeat(50));

				System.out.print("선택 > ");
				option = Integer.parseInt(sc.nextLine());
				//학생수 지정을 안하고 다음으로 넘어간 경우에 대해서는 예외처리가 없다...


				//switch의 break는 switch만 나갈 수 있다.
				switch (option) 
				{
				case 1:
					System.out.print("학생수 > ");
					student_num = Integer.parseInt(sc.nextLine());
					scores = new int[student_num];
					break;
				case 2: 
					for(i = 0; i < scores.length; i++)
					{
						System.out.printf("scores[%d] > ", i);
						scores[i] = Integer.parseInt(sc.nextLine());
					}
					break;
				case 3: 	
					for(i = 0; i < scores.length; i++)
					{
						System.out.printf("scores[%d] : %d\n", i, scores[i]);
					}
					break;
				case 4: 			
					max = 0;
					avg = 0;
					sum = 0;
					for(i = 0; i < scores.length; i++)
					{
						if(max < scores[i])
						{
							max = scores[i];
						}
						sum += scores[i];
					}
					avg = (double)sum / scores.length;
					//최고점수
					System.out.println("최고점수 : " + max);
					//평균점수
					//System.out.println("평균점수 : " + avg);
					System.out.printf("평균 : %5.2f\n", avg);
					break;
				default:
					//break;
					break Exit;//강사님 추가//이렇게 하면 5가 아니어도 종료됨...
				}
//				if(option == 5)
//				{
//					break;
//				}
			}
		System.out.println("프로그램 종료");

		sc.close();
	}
}
