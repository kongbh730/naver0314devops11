package day0325;

//상속 
class AA
{
//	AA()
//	{
//		System.out.println("AA의 default 생성자");
//	}
	AA(String msg)
	{
		System.out.println(msg +" 문자열을 갖는 생성자(AA)");
	}
}

class BB extends AA
{
//	BB()
//	{
//		//super()는 컴파일 시 기본으로 생성되어 숨겨져 있음, 부모의 디폴트 생성자를 호출
//		System.out.println("BB의 default 생성자");
//	}
	BB(String msg)
	{
		super(msg);//만약 AA가 디폴트 생성자가 없다면, AA의 매개변수 생성자와 동일하게 호출해야 한다.
		System.out.println(msg + "를 받는 생성자(BB)");
	}
}

public class Ex4_Inheri 
{
	public static void main(String[] args) 
	{
		//BB b = new BB();
		//BB는 AA의 자식클래스이므로 생성할 때 부모클래스의 기본 생성자를 거치고, 자기자신의 기본생성자를 거쳐 생성된다.
		
		System.out.println();
		
		//BB는 AA의 자식클래스이므로 생성할 때 부모클래스의 기본 생성자를 거치고, 자기자신의 String을 입력받는 생성자를 통해 생성된다.
		BB c = new BB("Hello");
		
		System.out.println();
		
		BB d = new BB("Hello");
	}
}
