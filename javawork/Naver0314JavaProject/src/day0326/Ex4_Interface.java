package day0326;

//인터페이스는 음식점의 메뉴판과 같다
//구현 나은한 목록을 나열만 하고 실체가 없다.
//상수와 추상메서드로만 구성이 되어있다.
interface InterA
{
	int MAX = 10;//상수이지만 구분할 필요가 없으므로 final 생략
	public void disp();//추상메서드지만 구분할 필요가 없으므로 abstract 생략
	public void study();//추상메서드지만 구분할 필요가 없으므로 abstract 생략
}

//인터페이스의 모든 메서드를 반드시 오버라이드 해야한다.
class MyInter implements InterA
{
	@Override
	public void disp() 
	{
		System.out.println("현재 최대 인원수는 " + MAX + "명입니다.");
	}
	@Override
	public void study() 
	{
		System.out.println("우리는 인터페이스를 공부하고 있습니다.");
	}
	
	public void play()//굳이 호출하고 싶으면 부모클래스 말고 해당 클래스로 생성해야 함
	{
		System.out.println("게임을 합니다.");
	}
}

public class Ex4_Interface
{
	public static void main(String[] args) 
	{
		InterA a = new MyInter();
		
		a.disp();
		a.study();
		//a.play();//호출불가
		//play() 굳이 호출하고 싶을 경우
		//MyInter로 생성하거나...
		//서브클래스로 형변환 후 호출하면 된다.
		((MyInter)a).play();

		
	}
}
