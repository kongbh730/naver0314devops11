package day0315;

public class Ex10_Operator 
{
	public static void main(String[] args) 
	{
		//증감연산자
		//전치일 경우 1순위
		//후치일 경우 끝순위
		//단항일 경우 상관 없음
		
		int m = 5, n = 5, a = 10, b = 10;
		m++;//단항이라 상관 없음
		++n;//단항이라 상관 없음
		System.out.println("m = " + m);//6
		System.out.println("n = " + n);//6
		
		a += m++;//a = a + m, m + 1; //후치는 제일 마지막에 계산한다.
		System.out.println("a = " + a);//16
		System.out.println("m = " + m);//7
		
		b += ++n;//n = n+1 , b = b + n//n 먼저 증가후 b에 더해짐
		System.out.println("b = " + b);
		System.out.println("n = " + n);
		
		m = 5;
		n = 5;
		System.out.println("m = " + m++);//5로 먼저 출력 후 메모리 내에서 6으로 증가
		System.out.println("m = " + ++m);//7로 먼저 증가 후 출력
		System.out.println("n = " + ++n);//6으로 먼저 증가 후 출력
		System.out.println("n = " + n++);//6으로 먼저 출력 후 7로 증가
		System.out.println("m = " + m);
		System.out.println("n = " + n);
		
		//증감연산자는 반드시 초기값이 지정되어 있어야 한다.
		
		
		
	}

}
