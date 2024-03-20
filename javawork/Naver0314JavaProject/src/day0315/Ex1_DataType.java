package day0315;

public class Ex1_DataType
{
	public static void main(String[] args) 
	{
		/*주석처리*/
		//주석처리
		//자바에서의 데이타 타입에 대하여 알아보자
		/*
		 * 2024년 03월 15일 수업 둘째날
		 * 자바에서의 주석처리 하는 방법
		 */
		//기본자료형 공부 //+ 기본 한글은 utf-8로 맞추고 한다.
		//지역 안에서 선언하는 변수들은 자동초기화 안됨
		//초기값을 지정하거나 나중에 변수에 값 저장 필요.
		boolean flag = true;//지역변수 : 지역변수는 초기화가 안됨
		boolean flag2;
		flag2 = false;
		System.out.println(flag);
		System.out.println(flag2);
		System.out.println(!flag);//! : not : 반대로 출력
		System.out.println(!flag2);
		//println()은 오버로딩 메소드
		// && : 둘다 true일때만 true
		// || : 둘 중 하나라도 true면 true
		System.out.println(flag && flag2); //false
		System.out.println(flag || flag2); //true
		
	
		
		
		
	}
}
