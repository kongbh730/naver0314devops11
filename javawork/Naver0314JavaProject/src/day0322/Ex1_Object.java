package day0322;

class Apple// bin에 Apple.class가 생성되므로, 같은 package에서는 새로운 Apple생성 불가
{
	String msg = "Happy Day!!";//인스턴스 멤버변수
	static String message = "오늘은 금요일";//static 멤버변수 == class 멤버변수
}

//접근제한을 지정 안하면 default
//public은 package 외부에서도 접근 가능
//protected는 ?
//default는 같은 package에서 접근 가능
//private만 같은 객체 안에서 접근 가능

class Banana
{
	static int kor = 100;
	static int eng = 80;
	String name = "마이클";//인스턴스
}

public class Ex1_Object 
{
	//멤버 변수들
	String name = "홍길동"; //인스턴스 변수
	final static int MAX = 100;//static 멤버변수 //class 이름으로 접근 가능 //final : 상수
	
	public static void main(String[] args) //static : Ex1_object의 멤버 메소드
	{
		/*
		 * static 멤버 메서드는 static 멤버 변수나 멤버메서드만 접근가능
		 * 일반 인스턴스 메서드나 변수를 접근하기 위해서는 new로 생성 후 그 변수를 이용해서 호출해야만 한다.
		 * 
		 */
		System.out.println("==== Ex1_Object 예제 ====");
		//System.out.println(name);//오류 발생
		System.out.println(Ex1_Object.MAX);//static 변수는 "클래스명.변수명"으로 접근 가능
		System.out.println(MAX);//같은 클래스일 경우는 앞에 클래스명 생략 가능
		
		//name을 출력하려면 new로 생성한 인스턴스 변수 필요
		Ex1_Object ex = new Ex1_Object();
		//ex가 인스턴스 변수, 이 변수를 이용해야만 name 접근 가능
		System.out.println(ex.name);
		//C언어로 생각하면, 전역변수인데 마음대로 접근할 수 없는 전역변수?
		
		//Apple이 가진 2개의 멤버변수를 출력해보세요
		System.out.println("\n==== Apple 예제 ====");
		System.out.println(Apple.message);//static이니까 class명.message로도 출력 가능
		//System.out.println(Apple.msg);//instance변수니까 new가 없으면 호출불가
		Apple apple_Ex = new Apple();
		System.out.println(apple_Ex.msg);
		
		//Banana 클래스의 kor, eng 점수 출력하고 합계 출력/ name변수도 출력
		//kor, eng변수는 static변수니까 이름.변수로 호출가능
		System.out.println("\n==== Banana 예제 ====");
		System.out.println("바나나 eng : " + Banana.eng);
		System.out.println("바나나 kor : " + Banana.kor);
		System.out.println(Banana.eng + Banana.kor);
		//name는 instance변수니까 new로 생성이 필요
		Banana banana_ex = new Banana();
		System.out.println(banana_ex.name);
	}
}
