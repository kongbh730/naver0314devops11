package day0315;

import java.util.Scanner;

public class Ex12_Munjae 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*
		 * 점수(score)입력받아
		 * 점수가 90이상이면 "참 잘했어요!!"
		 * 80이상이면 "수고했어요!"
		 * 70이상이면 "조금 더 노력하세요!"
		 * 나머지는 "재시험입니다!"
		 * 메세지를 저장할 문자열 변수명 : msg
		 * 삼항조건연산자로 풀어보기
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		String msg = "";
		
		score = sc.nextInt();
//		msg =  (score >= 90) ? "참 잘했어요!" : 
//			((score >= 80) ? "수고했어요!" : 
//				((score >= 70) ? "조금 더 노력하세요!" : "재시험입니다!"));
		
		msg =  (score >= 90) ? "참 잘했어요!" : (score >= 80) ? "수고했어요!" : (score >= 70) ? "조금 더 노력하세요!" : "재시험입니다!";
		
		System.out.println(score + "점  " + msg);
		
		sc.close();
	}

}
