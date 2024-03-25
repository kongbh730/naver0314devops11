package day0325;

class Parent2
{
	public void job()
	{
		System.out.println("부모클래스에서 해야할 일 처리...");
	}
	
}

class Sub2 extends Parent2
{
	@Override 
	public void job() 
	{
		System.out.println("자식 클래스에서 처리해야 할 일...");
		//자식클래스에 부모클래스의 메서드 job과 동일한 이름의 job이 있기 때문에 반드시 super로 호출해야 함.
		super.job();//부모클래스의 job을 오버라이드 하기 때문에 반드시 부모클래스의 job()을 호출해야함.
	}
	
}

public class Ex6_Override 
{
	public static void main(String[] args) 
	{
		Sub2 s = new Sub2();
		s.job();//sub2가 가진 job 메서드가 호출
		
		
	}
}
