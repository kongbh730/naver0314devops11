package day0326;

//다형성을 수행할 수 있는 클래스
//class Animal
//{
//	public void sound()
//	{
//		//진짜 딱히 하는 일 없음
//		System.out.println("딱히 하는 일 없음");
//	}
//}

//추상클래스로 바꿔보기
//abstract 메서드는 오버라이드만을 목적으로 body()없이 구현하고자 할 경우
//앞에 abstract 를 붙여서 추상 메서드로 만든다
//abstract 메서드를 한 개 이상 포함하고 있는 클래스는 클래스 역시 추상화시켜야 한다.
//추상화시키는 방법은 class 앞에 abstract를 붙이면 된다.
//단 추상클래스는 그 자체로는 생성할 수 없다.
//추상클래스를 상속받는 서브 클래스는 반드시 추상메서드를 오버라이드해야한 하는데
//만약 오버라이드하지 않았을 경우 서브클래스 역시 추상화시킨다.
abstract class Animal//추상클래스
{
	abstract public void sound();//추상메서드
	public void showTitle()//추상클래스에는 일반메서드가 존재 할 수 있다
	{
		System.out.println("추상 클래스 공부중!");
	}
}

class Dog extends Animal
{
	@Override
	public void sound() 
	{
		// TODO Auto-generated method stub
		//super.sound();//추상클래스의 추상 메서드는 기능이 없음
		System.out.println("멍멍!!!");
	}
}

class Chick extends Animal
{
	@Override
	public void sound() 
	{
		// TODO Auto-generated method stub
		//super.sound();
		System.out.println("삐약삐약!!!");
	}
}

class Cat extends Animal
{
	@Override
	public void sound() 
	{
		// TODO Auto-generated method stub
		//super.sound();
		super.showTitle();//추상클래스의 일반메서드는 문제없이 호출 가능
		System.out.println("야옹야옹!!!");
	}
}

public class Ex1_Abstract 
{
	public static void hello(Animal ani)
	{
		ani.showTitle();//추상 메서드가 아니라 호출 가능
		ani.sound();
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		hello(new Cat());
		hello(new Dog());
		hello(new Chick());
		//hello(new Animal());//추상클래스로 바꾼 후쿠터 에러발생
		//->여기까진 다형성
		
		//abstract로 바꿔보기
		//hello(new Animal());//추상클래스로 바꾸면 그때부터는 선언만 가능, 생성은 불가
	}
}
