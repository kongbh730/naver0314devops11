package day0326;

interface Apple
{
	public void one();
}

interface Banana extends Apple
{
	//one()이 숨어있다.
	public void two();
}

class Orange implements Banana
{
	//Apple을 상속받은 Banana로부터 상속받은 클래스이기 때문에
	//Apple의 one()과 Banana의 two를 모두 갖고 있어야 한다.
	@Override
	public void one() 
	{
		System.out.println("하나");
	}
	@Override
	public void two() 
	{
		System.out.println("둘");
	}
	public void three()
	{
		System.out.println("셋");
	}
}

public class Ex5_Interface 
{
	public static void main(String[] args) 
	{
		Banana b = new Orange();
		b.one();
		b.two();
		((Orange)b).three();
	}
}
