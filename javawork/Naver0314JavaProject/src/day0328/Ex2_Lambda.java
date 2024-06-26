package day0328;

/*
 * 자바에서의 함수형 프로그램인 람다 표현식은 인터페이스를 사용하는 
 * 익명 내부 클래스의 또 다른 표현시기다.
 * 단, 인터페이스는 단 하나의 추상 메로드만 가지고 있어야 한다.
 * -> : 화살표 함수 / => : 람다
 */

@FunctionalInterface // @FunctionalInterface는 메소드가 하나인지 아닌지 검응
interface Orange
{
	public void write(); //추상메서드
	//public void play();//오류발생
}

@FunctionalInterface // @FunctionalInterface는 메소드가 하나인지 아닌지 검응
interface DataAdd
{
	public void add(int x, int y);
}

public class Ex2_Lambda 
{
	//익명내부클래스 형태로 Orange 구현
	Orange or = new Orange()
	{
		@Override
		public void write() 
		{
			System.out.println("오렌지 먹고 싶어요!");
		}
	};
	
	private void lambdaMethod() 
	{
		Orange or2 = () -> System.out.println("람다식 오렌지 먹고싶어요!");
		or2.write();

		Orange or3=()->
		{
			System.out.println("안녕하세요");
			System.out.println("람다식 공부중...");
		};
		or3.write();

		Orange or4 = new Orange()
		{
			@Override
			public void write()
			{
				System.out.println("다양한 방법으로 구현하기");
			}
		};
		
		or4.write();
	}
	
	public void lambdaMethod2() 
	{
		DataAdd add1 = (int x, int y) -> System.out.println("두 수의 합 : " + (x+y));
		
		add1.add(10, 20);
		add1.add(5, 6);
		
	}

	//우리가 알고 있는 익명 내부클래스 형태로 Orange를 구현
	public static void main(String[] args) 
	{
		Ex2_Lambda ex = new Ex2_Lambda();
		ex.or.write();
		ex.lambdaMethod();
		
		ex.lambdaMethod2();
	}
}
