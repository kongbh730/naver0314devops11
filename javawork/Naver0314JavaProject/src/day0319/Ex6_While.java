package day0319;

public class Ex6_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		
		//선조건 : 조건이 맞지 않으면 바로 반복문을 빠져나간다.
		while(n > 10)
		{
			System.out.println("hello #1");
		}
		System.out.println();
		//후조건 : 일단 로직을 처리한 후 조건을 비교하여 빠져나간다.
		
		n = 1;
		do 
		{
			n++;
			System.out.println("hello #2"); 
		}
		while(n < 5);
		
		n = 10;
		do 
		{
			n++;
			System.out.println("hello #3"); 
		}
		while(n < 5);
		
		int a = 1;
		while(a < 10)
		{
			System.out.printf("%3d", a++);
		}
		System.out.println();
		
		a = 1;
		while(a <= 10)
		{
			System.out.printf("%3d", a++);
		}
		System.out.println();
		
		a = 1;
		while(true)
		{
			System.out.printf("%3d", a++);
			if(a > 10)
			{
				break;
			}
		}
		System.out.println();
		
		char ch = 'A';
		//while(ch != 'Z' + 1)//자바의 모든 char형은 아스키코드로 저장된다.
		while(ch <= 'Z')//자바의 모든 char형은 아스키코드로 저장된다.
		{
			System.out.print(ch);
			ch++;
		}
		System.out.println();
	}

}
