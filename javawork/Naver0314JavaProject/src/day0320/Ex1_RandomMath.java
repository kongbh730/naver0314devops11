package day0320;

public class Ex1_RandomMath {
	public static void main(String[] args) {
		//상수 : final : 값 변경 불가 // 보통 전부 대문자로 선언
		System.out.println("** Math.random()을 이용한 난수구하기 **");
		System.out.println("1. random() 시 값");
		for(int i = 0; i < 5; i++)
		{
			double d = Math.random();
			System.out.println(d);
		}

		System.out.println("=".repeat(30));
		System.out.println("2. 0~9 발생");
		for(int i = 0; i < 5; i++)
		{
			int n = (int)(Math.random()*10);
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		System.out.println("3. 1~10 발생");
		for(int i = 0; i < 5; i++)
		{
			int n = (int)(Math.random()*10 + 1);
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		System.out.println("4. 1~100 발생");
		for(int i = 0; i < 10; i++)
		{
			int n = (int)(Math.random()*100) + 1;
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		//랜덤 알파벳 소문자
		System.out.println("5. 65('A')~90('B') 발생");
		for(int i = 0; i < 5; i++)
		{
			int n = (int)(Math.random()* 26) + 65;
			System.out.printf("%4c", (char)n);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		//랜덤 알파벳 소문자
		System.out.println("6. 97('a')~122('b') 발생");
		for(int i = 0; i < 5; i++)
		{
			int n = (int)(Math.random()* 26) + 97;
			System.out.printf("%4c", (char)n);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		//Example : 5부터 9까지
		System.out.println("EX. 5~9 발생");
		for(int i = 0; i < 5; i++)
		{
			int n = (int)(Math.random()* 5) + 5;
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		//Example : 5부터 10까지
		System.out.println("EX. 5~10 발생");
		for(int i = 0; i < 5; i++)
		{
			int n = (int)(Math.random()* 6) + 5;
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));

	}

}
