package day0322;

class Stu
{
	String name = "이영자";
	String blood = "A";
	int age = 12;
	
	
}

public class Ex6_CallByReference 
{
	public static void changeStu(Stu s)
	{
		//주소를 통해 main의 s변수의 값을 직접 변경
		s.blood = "O";
		s.age = 34;
	}
	public static void main(String[] args) 
	{
		Stu s = new Stu();
		System.out.println(s.name + ", " + s.blood + ", " + s.age);
		changeStu(s);//클래스는 무조건 call by reference
		System.out.println("메서드 호출 후 다시 출력");
		System.out.println(s.name + ", " + s.blood + ", " + s.age);
		
		
	}
}
