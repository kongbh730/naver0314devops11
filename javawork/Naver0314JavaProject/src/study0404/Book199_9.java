package study0404;

import java.util.Scanner;

public class Book199_9 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);//스캐너 선언
		
		int option;//메뉴선택지
		int student_num = 0;//학생수
		int []scores = null;//scores라는 int형 배열을 선언만 함.
		int i;
		int max = 0, sum = 0;
		double avg = 0;

		while(true)//무한정 반복할 것이다. option값이 5면 탈출할거고
		{
			System.out.println("-".repeat(50));//서식출력
			System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");//서식출력
			System.out.println("-".repeat(50));//서식출력
			System.out.print("선택 > ");
			option = Integer.parseInt(sc.nextLine());// 문자열로 입력받아서 Integer형태로 읽어서 option에 저장한다. 

			//switch의 break는 switch만 나갈 수 있다.
			switch (option) //option의 값에 따라 case 결정
			{
			case 1://1 : 학생수 입력
				System.out.print("학생수 > ");
				student_num = Integer.parseInt(sc.nextLine());//학생수를 문자열로 입력받아서 integer형태로 변환하여 저장
				scores = new int[student_num];//null인 scores 배열을 int형 배열 student_num개로 할당, 값은 0 저장
				//같은 이름의 배열을 새로 선언하면 이전에 저장된 배열이 모두 지워지고 새로 생성된다.
				break;//case 1 탈출
			case 2: //2 : 점수입력
				for(i = 0; i < scores.length; i++)//scores배열의 크기만큼 반복수행
				{
					System.out.printf("scores[%d] > ", i);
					scores[i] = Integer.parseInt(sc.nextLine());//문자열을 int형으로 변환하여 scores[i]에 저장
				}
				break;//case 2 탈출
			case 3: //3 : 점수리스트 출력
				for(i = 0; i < scores.length; i++)//scores배열의 크기만큼 반복수행
				{
					System.out.printf("scores[%d] : %d\n", i, scores[i]);//scores[i]에 들어있는 원소값 순차 출력
				}
				break;//case 3 탈출
			case 4: //4 : 총 점수들에 대한 분석	
				max = 0;
				avg = 0;
				sum = 0;
				for(i = 0; i < scores.length; i++)//scores의 배열크기만큼 반복
				{
					if(max < scores[i])//만약 max가 scores[i]보다 작다면
					{
						max = scores[i];//max를 현재 scores원소값으로 갱신
					}
					sum += scores[i];//sum에 scores[i]값 누적합
				}//모든 누적합 종료
				avg = (double)sum / scores.length;// 평균값은 누적합 / scores배열크기
				//최고점수
				System.out.println("최고점수 : " + max);//최고점수 출력
				//평균점수
				System.out.printf("평균 : %5.2f\n", avg);//평균값 출력 : 소수점아래 2자리까지만 출력
				break;//case4 탈출
			default://5이상 입력시 switch case문 탈출
			}
			if(option == 5)//.option값이 5면 반복탈출
			{
				break;//탈출
			}
		}
		System.out.println("프로그램 종료");

		sc.close();
	}
}
