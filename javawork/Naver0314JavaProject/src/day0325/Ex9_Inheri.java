package day0325;

class Animal
{
	public void writeAnimal()
	{
		System.out.println("Animal 부모클래스!!");
	}
}

class Cat extends Animal
{
	@Override
	public void writeAnimal() 
	{
		// TODO Auto-generated method stub
		super.writeAnimal();//부모클래스의 writeAnimal 메서드 방문!
		System.out.println("나는 야옹!! 고양이입니다.");
	}
	
	public void play()
	{
		System.out.println("야옹야옹!!!");
	}
}

class Dog extends Animal
{
	@Override
	public void writeAnimal() 
	{
		// TODO Auto-generated method stub
		super.writeAnimal();//부모클래스의 writeAnimal 메서드 방문!
		System.out.println("나는 멍멍!! 강아지입니다.");
	}
	public void play()
	{
		System.out.println("멍멍멍!!!");
	}
}

public class Ex9_Inheri {
	public static void main(String[] args) 
	{
		Cat c = new Cat();
		Dog d = new Dog();
		
		c.writeAnimal();
		c.play();
		
		d.writeAnimal();
		d.play();
		
		//만약 Cat도 됐다가 Dog도 됐다가 할 수 없을까 -> 다형성Polymorpism
		System.out.println("================================");
		//부모클래스로 선언, 자식클래스로 생성
		//다형성이라고 한다.
		//오버라이드 메서드에 한해서만 호출이 가능하다.
		//writeAnimal은 호출이 가능하지만, play 메서드는 호출할 수 없다.
		Animal ani = null;
		ani = new Cat();//고양이도 됐다가
		ani.writeAnimal();
		ani = new Dog();//강아지도 됐다가
		ani.writeAnimal();
		//ani.play();//오버라이딩 메서드가 아니라 에러발생
	}
}