package day0318;

import java.util.Scanner;

public class Ex6_ScoreSwitch {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int score;
		char grade;

		System.out.println("점수?");
		score = sc.nextInt();
		//if문을 이용해서 점수를 잘못 입력했을 경우 메서드 종룔를 하자.
		if(score < 1 || score > 100)
		{
			System.out.println("잘못된 점수입니다.");
			sc.close();
			return;//main 메서드 종료(곧 프로그램이 종료됨)
		}
		
		//삼항연산자
//		grade = score >= 90 ? 'A' : score >= 80 ? 'B' : score >= 70 ? 'C' : score >= 60 ? 'D' : 'F';
		
		//switch-case문
//		switch(score/10)
//		{
//		case 10:
//		case 9:
//			grade = 'A';
//			break;
//		case 8:
//			grade = 'B';
//			break;
//		case 7:
//			grade = 'C';
//			break;
//		case 6:
//			grade = 'D';
//			break;
//		default:
//			grade = 'F';
//		}
		
		//if문으로 학점구하기
		if(score >= 90)
		{
			grade = 'A';
		}
		else if(score >= 80)
		{
			grade = 'B';
		}
		else if(score >= 70)
		{
			grade = 'C';
		}
		else if(score >= 60)
		{
			grade = 'D';
		}
		else
		{
			grade = 'E';
		}
		System.out.println(score + "점은 " + grade + "학점입니다.");
		
		
		sc.close();
	}

}

//ctrl + i : 코드 정렬하기