package day0326;

class OuterClass
{
	int a = 10;
	static int b = 20;
	
	class InnerClass
	{
		int c = 30;
		static int d = 40;//jdk11 버전에서는 오류
		//멤버 내부클래스에서는 static 변수 선언 불가
		
		public void show()
		{
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			System.out.println("c = " + c);
			System.out.println("d = " + d);
		}
	}
	
	//정적내부클래스
	static class InnerClass2
	{
		int e = 50;
		static int f = 60;
		public void show()//static 내부 클레스에서는 외부 클래스의 인스턴스 
		{
			System.out.println("b = " + b);
			System.out.println("c = " + e);
			System.out.println("d = " + f);
		}
	}
	
	public void disp()
	{
		//내부 클래스가 가진 show 메서드 호출
		InnerClass in = new InnerClass();
		in.show();
		
		InnerClass2 in2 = new InnerClass2();
		in2.show();
	}
}

public class Ex9_InnerClass 
{
	public static void main(String[] args) 
	{
		OuterClass outer = new OuterClass();
		outer.disp();
		//outer클래스의 disp메서드를 호출했는데, Inner class의 show를 호출하게 됐다. 
	}
}
