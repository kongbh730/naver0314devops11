package day0322;

/*
 * 생성자(constructor)의 특징
 * 1. 클래스명과 동일한 메서드명으로 만들어야 한다.
 * 2. 리턴 타입이 없다.
 * 3. overloading이 가능하다.(여러개 생성 가능)
 * 4. 생성할 때 단 한번 호출된다.
 * 5. 멤버변수의 초기화를 담당한다.
 */

class Kiwi
{
	String name, addr;

	//생성자1
	Kiwi()
	{
		System.out.println("디폴트 생성자");
		name = "이미자";
		addr = "서울";
	}
	//생성자2
	Kiwi(String name)
	{
		this.name = name;
		addr = "서울";
	}

	/*
	//생성자 불가 : 왜냐하면 오버로딩 규칙에 어긋남, 변수명이 다르다고 오버로딩이 되는게 아님
	Kiwi(String addr)
	{
		this.name = name;
		this.addr = addr;
	}
	*/
	
	//생성자3
	Kiwi(String name, String addr)
	{
		this.name = name;
		this.addr = addr;
	}

	public void show()
	{
		System.out.println(name + "님은 " + addr + "에 살고 있어요.");
	}
}

public class Ex8_Constructor 
{
	public static void main(String[] args) 
	{
		Kiwi k1 = new Kiwi();
		k1.show();

		Kiwi k2 = new Kiwi("강호동");
		k2.show();

		Kiwi k3 = new Kiwi("유재석", "부산");
		k3.show();
	}
}
