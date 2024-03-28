package day0328;

//<T>는 T가 타입파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용한다.
class GenericType<T>
{
	T []v;//클래스 타입만 가능
	
	public void set(T[] n)//T[]를 받아서
	{
		v = n;
	}
	
	public void print()
	{
		for(T s:v)
		{
			System.out.print(s + "  ");
		}
		System.out.println();
	}
}

public class Ex1_Type 
{
	public static void main(String[] args) 
	{
		String []s = {"장미꽃", "안개꽃", "국화꽃", "후리지아"};
		Integer []n = {100, 89, 90, 78, 99};
		Double []d = {34.5, 89.7, 90.5};
		
		GenericType<String> gt1 = new GenericType<>();
		gt1.set(s);
		gt1.print();
		
		//T는 클래스 타입만 가능하기때문에 int가 아니라 Integer라고 지정해야함
		GenericType<Integer> gt2 = new GenericType<>();//첫 글자는 대문자로
		gt2.set(n);
		gt2.print();
		
		GenericType<Double> gt3 = new GenericType<>();//첫 글자는 대문자로
		gt3.set(d);
		gt3.print();
	}

}
