package day0325;

//Ex9에서 만든 Animal, Cat, Dog 클래스를 이용한 예제
//다형성처리 예제
public class Ex10_Inheri 
{
	public static void showAnimal(Animal ani) // <= Cat, Dog가 넘어오는거에 따라 다름
	{
		ani.writeAnimal();// 이때 ani변수는 Cat이 되기도 하고 Dog가 되기도 한다.(누가 생성되어 넘어오느냐에 따라서)
	}
	
	public static void main(String[] args)
	{
		//다형성 처리
		showAnimal(new Cat());
		showAnimal(new Dog());
	}
}