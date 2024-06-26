package day0325;

//!!!! 추상메서드로 선언된 클래스 또한 추상타입이어야 한다.
abstract class Animal2
{
	//메서드 선언
	public void breathe()
	{
		System.out.println("숨을 쉽니다.");
	}
	
	//추상 메서드 선언
	//소리를 내긴 하는데 구체적인 소리는 모른다.
	public abstract void sound();
}

//class Animal2
//{
//	//추상 메서드 선언
//	public void sound()
//	{
//		;
//	}
//}

class Dog2 extends Animal2
{
	@Override
	public void sound() 
	{
		System.out.println("멍멍");
	}
}

class Cat2 extends Animal2
{
	@Override
	public void sound() 
	{
		System.out.println("야옹");
	}
}

public class Ex11_Book328 
{	
	public static void main(String[] args) 
	{
		Dog2 dog = new Dog2();
		dog.sound();
		
		Cat2 cat = new Cat2();
		cat.sound();
		
		Animal2 ani = null;//Animal2로 선언
		ani = new Dog2();//Dog2로 생성
		ani.sound();
		ani = new Cat2();//Cat2로 생성
		ani.sound();
		
		//매개변수의 다형성
		System.out.println("\n매개변수의 다형성");
		System.out.print("Animal2로 선언하고 Dog2로 생성\n-> ");
		animalSound(new Dog2());
		System.out.print("Animal2로 선언하고 Cat2로 생성\n-> ");
		animalSound(new Cat2());
	}

	private static void animalSound(Animal2 animal) //자동 타입 변환
	{
		animal.sound();
	}
}
